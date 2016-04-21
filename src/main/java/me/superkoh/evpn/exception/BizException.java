package me.superkoh.evpn.exception;

/**
 * Created by KOH on 16/4/19.
 */
public class BizException extends Exception {

    protected int errorCode = -1;

    public BizException() {
        super("系统错误,请稍后重试");
    }

    public BizException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
