package me.superkoh.evpn.domain.entity;

/**
 * Created by KOH on 16/4/17.
 */
public class Server {

    private String ip;
    private String name;
    private int cnt = 0;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
