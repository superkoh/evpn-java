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
        String eAuth = request.getHeader("eAuth");
        if (null == eAuth || !eAuth.equals(E_AUTH)) {
            response.sendError(403, "Permission Denied");
            return false;
        }
        String vd = request.getHeader("evpn-vd");
        if (null == vd) vd = request.getParameter("vd");
        if (null == vd || vd.length() != 36) {
            response.sendError(403, "Permission Denied");
            return false;
        }
        String v = request.getHeader("evpn-v");
        if (null == v) v = request.getParameter(v);
        if (null == v) {
            response.sendError(403, "Permission Denied");
            return false;
        }
        request.setAttribute("vd", vd);
        request.setAttribute("v", v);
        return super.preHandle(request, response, handler);
    }
}
