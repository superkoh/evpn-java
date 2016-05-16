package me.superkoh.evpn.controller.advice;

import me.superkoh.evpn.controller.base.BizResponse;
import me.superkoh.evpn.controller.base.EmptyResponse;
import me.superkoh.evpn.controller.base.ErrorResponse;
import me.superkoh.evpn.controller.base.SuccessResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by KOH on 16/4/17.
 */
@ControllerAdvice
public class ResponseWrapper implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (!(body instanceof BizResponse)) {
            return body;
        }
        if (body instanceof ErrorResponse) {
            return body;
        }
        if (body instanceof EmptyResponse) {
            return new SuccessResponse();
        }
        SuccessResponse successResponse = new SuccessResponse();
        successResponse.obj = body;
        return successResponse;
    }
}
