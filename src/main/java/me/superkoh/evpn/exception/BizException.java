package me.superkoh.evpn.exception;

/**
 * Created by KOH on 16/4/19.
 */
public class BizException extends RuntimeException {

    private int errCode = -1;
    private String errMsg = "";

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public BizException() {
        super();
    }

    public BizException(int errCode, String errMsg) {
        super();
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
