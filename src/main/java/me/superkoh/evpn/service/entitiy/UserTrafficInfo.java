package me.superkoh.evpn.service.entitiy;

/**
 * Created by KOH on 16/4/21.
 */
public class UserTrafficInfo {

    private long remainTraffic;
    private long totalTraffic;

    public long getRemainTraffic() {
        return remainTraffic;
    }

    public void setRemainTraffic(long remainTraffic) {
        this.remainTraffic = remainTraffic;
    }

    public long getTotalTraffic() {
        return totalTraffic;
    }

    public void setTotalTraffic(long totalTraffic) {
        this.totalTraffic = totalTraffic;
    }
}
