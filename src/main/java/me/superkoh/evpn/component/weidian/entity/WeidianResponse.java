package me.superkoh.evpn.component.weidian.entity;

/**
 * Created by KOH on 16/5/13.
 */
public class WeidianResponse<T> {

    public T result;
    public WeidianResponseStatus status;


    public static class WeidianResponseStatus {
        public int status_code;
        public String status_reason;
    }

}
