package me.superkoh.evpn.domain.entity.weidian;

/**
 * Created by KOH on 16/5/13.
 */
public class WeidianResult<T> {

    T result;
    WeidianResultStatus status;


    public static class WeidianResultStatus {
        int status_code;
        String status_reason;
    }

}
