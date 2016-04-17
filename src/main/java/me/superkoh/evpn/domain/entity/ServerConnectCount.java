package me.superkoh.evpn.domain.entity;

/**
 * Created by KOH on 16/4/17.
 */
public class ServerConnectCount {

    private String ip;
    private int cnt;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
