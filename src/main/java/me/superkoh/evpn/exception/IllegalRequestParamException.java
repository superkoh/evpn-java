package me.superkoh.evpn.exception;

/**
 * Created by KOH on 16/4/22.
 */
public class IllegalRequestParamException extends BizException {

    public IllegalRequestParamException(String paramName) {
        this.setErrCode(-1);
        this.setErrMsg(paramName + " is invalid");
    }
}
