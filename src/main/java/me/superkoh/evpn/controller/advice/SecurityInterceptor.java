package me.superkoh.evpn.controller.advice;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by KOH on 16/5/9.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private static final String E_AUTH = "3ffdb679e198868ddcd473638df4d8d7";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        String eAuth = request.getHeader("X-EVpn-Auth");
        if (null == eAuth) eAuth = request.getHeader("eAuth");
        if (null == eAuth || !eAuth.equals(E_AUTH)) {
            response.sendError(403, "Permission Denied: auth");
            return false;
        }
        String vd = request.getHeader("X-EVpn-Auth");
        if (null == vd) vd = request.getParameter("vd");
        if (null == vd) {
            response.sendError(403, "Permission Denied: vd");
            return false;
        }
        String v = request.getHeader("X-EVpn-Version");
        if (null == v) v = request.getParameter("v");
        if (null == v) {
            response.sendError(403, "Permission Denied: v");
            return false;
        }
        request.setAttribute("vd", vd);
        request.setAttribute("v", v);
        return super.preHandle(request, response, handler);
    }
}
