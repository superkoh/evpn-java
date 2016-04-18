package me.superkoh.evpn.web.controller;

import me.superkoh.evpn.exception.BizException;
import me.superkoh.evpn.web.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by KOH on 16/4/19.
 */
public class BaseController {
    @ExceptionHandler(Exception.class)
    public ErrorResponse exceptionHandler(Exception e) {
        ErrorResponse res = new ErrorResponse();
        if (e instanceof BizException) {
            res.ok = ((BizException) e).getErrorCode();
            res.msg = e.getMessage();
        } else {
            res.ok = -1;
            res.msg = "系统异常,请稍后重试";
        }
        return res;
    }
}
