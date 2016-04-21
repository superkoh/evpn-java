package me.superkoh.evpn.exception;

/**
 * Created by KOH on 16/4/20.
 */
public class MonthlyTrafficOverLimitException extends BizException {

    public MonthlyTrafficOverLimitException() {
        super(1001, "您当月已使用流量超过5G,欢迎下月继续使用.如有任何问题,欢迎使用意见反馈与我们联系");
    }
}
