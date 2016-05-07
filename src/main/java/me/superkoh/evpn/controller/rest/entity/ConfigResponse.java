package me.superkoh.evpn.controller.rest.entity;

import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.radius.Nas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
public class ConfigResponse {

    public List<ServerResponse> servers = new ArrayList<>();
    public List<BannerResponse> ads = new ArrayList<>();
    public boolean needUpdate = false;
    public String updateInfo = "";

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

        public BannerResponse(Banner banner) {
            this.asset = banner.getAssetUrl();
            this.link = banner.getLinkUrl();
        }
    }
}
