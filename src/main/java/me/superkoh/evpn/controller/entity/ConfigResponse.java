package me.superkoh.evpn.controller.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.radius.Nas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
public class ConfigResponse {

    public List<ServerResponse> servers = new ArrayList<>();
    public List<BannerResponse> ads = new ArrayList<>();
    public boolean needUpdate = false;
    public String updateInfo = "";
    public boolean forceUpdate = false;
    public String forceUpdateWebview = "";

    public static class ServerResponse {
        public String ip;
        public String name;
        public int cnt;

        public ServerResponse(Nas nas, int connectCount) {
            this.ip = nas.getNasname();
            this.name = nas.getShortname();
            this.cnt = connectCount;
        }
    }

    public static class BannerResponse {
        public String asset;
        public String link;
        @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "GMT+8")
        public Date onlineTime;
        @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "GMT+8")
        public Date offlineTime;

        public BannerResponse(Banner banner) {
            this.asset = banner.getAssetUrl();
            this.link = banner.getLinkUrl();
            this.onlineTime = banner.getOnlineTime();
            this.offlineTime = banner.getOfflineTime();
        }
    }
}
