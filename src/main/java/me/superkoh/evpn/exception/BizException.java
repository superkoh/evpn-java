package me.superkoh.evpn.exception;

/**
 * Created by KOH on 16/4/19.
 */
public class BizException extends Exception {

    private int errorCode = -1;

    public BizException() {
        super("系统错误,请稍后重试");
    }

    public BizException(int errorCode) {
        super("系统错误,请稍后重试");
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, Throwable cause) {
        super("系统错误,请稍后重试", cause);
        this.errorCode = errorCode;
    }

    public BizException(int errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
