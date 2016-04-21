package me.superkoh.evpn.web.advice;

import me.superkoh.evpn.exception.BizException;
import me.superkoh.evpn.web.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by KOH on 16/4/22.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(BizException.class)
    public @ResponseBody ErrorResponse bizExceptionHandler(BizException e) {
        ErrorResponse res = new ErrorResponse();
        res.ok = e.getErrCode();
        res.msg = e.getErrMsg();
        if (res.msg.isEmpty()) {
            res.msg = "系统异常,请稍后重";
        }
        return res;
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody ErrorResponse exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        ErrorResponse res = new ErrorResponse();
        res.ok = -1;
        res.msg = e.getMessage();
        if (res.msg.isEmpty()) {
            res.msg = "系统异常,请稍后重";
        }
        return res;
    }

}
