package me.superkoh.evpn.controller.advice;

import me.superkoh.evpn.configuration.ApplicationContextUtil;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by KOH on 16/5/12.
 */
public class BeforeActionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger accessLogger = LoggerFactory.getLogger("accessLogger");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        StringBuilder accessLogBuilder = new StringBuilder();
        addLogKV(accessLogBuilder, "remoteIp", getRemoteIpAddress(request));
        addLogKV(accessLogBuilder, "request", request.getRequestURI());
        addLogKV(accessLogBuilder, "method", request.getMethod());
        addLogKV(accessLogBuilder, "params", parseParams(request.getParameterMap()));
        ApplicationContext ctx = ApplicationContextUtil.getApplicationContext();
        UserService userService = (UserService) ctx.getBean("userService");
        String userToken = request.getParameter("token");
        if (null != userToken) {
            VipUser user = userService.getVipUserByToken(userToken);
            if (null != user) {
                request.setAttribute("curUserToken", userToken);
                request.setAttribute("curUser", user);
                addLogKV(accessLogBuilder, "user", user.getMobile());
                addLogKV(accessLogBuilder, "token", userToken);
            }
        }
        String vd = (String) request.getAttribute("vd");
        if (null == vd) {
            vd = request.getHeader("evpn-vd");
            if (null == vd) vd = request.getParameter("vd");
            if (null != vd) {
                request.setAttribute("vd", vd);
                addLogKV(accessLogBuilder, "vd", vd);
            } else {
                response.sendError(403, "Permission Denied");
                return false;
            }
        } else {
            addLogKV(accessLogBuilder, "vd", vd);
        }

        String v = (String) request.getAttribute("v");
        if (null == v) {
            v = request.getHeader("evpn-v");
            if (null == v) v = request.getParameter("v");
            if (null != v) {
                request.setAttribute("v", v);
                addLogKV(accessLogBuilder, "v", v);
            } else {
                response.sendError(403, "Permission Denied");
                return false;
            }
        } else {
            addLogKV(accessLogBuilder, "v", v);
        }

        accessLogger.info(accessLogBuilder.toString());

        return super.preHandle(request, response, handler);
    }

    private static void addLogKV(StringBuilder builder, String key, String value) {
        builder.append("[").append(key).append(":").append(value).append("]");
    }

    private static String parseParams(Map<String, String[]> paramMap) {
        StringBuilder builder = new StringBuilder();
        for (String key : paramMap.keySet()) {
            if (key.equals("token") || key.equals("vd") || key.equals("v")) continue;
            addLogKV(builder, key, Arrays.toString(paramMap.get(key)));
        }
        return builder.toString();
    }

    private static String getRemoteIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (null == ip || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (null == ip || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ip || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (null == ip || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (null == ip || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
