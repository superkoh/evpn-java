package me.superkoh.evpn.exception;

/**
 * Created by KOH on 16/4/22.
 */
public class IllegalRequestParamException extends BizException {

    public IllegalRequestParamException(String paramName) {
        super(-1, paramName + " is invalid");
    }
}
