package me.superkoh.evpn.web.response;

import me.superkoh.evpn.domain.entity.Banner;
import me.superkoh.evpn.domain.entity.Server;

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

        public ServerResponse(Server server) {
            this.ip = server.getIp();
            this.name = server.getName();
            this.cnt = server.getCnt();
        }
    }

    public static class BannerResponse {
        public String asset;
        public String link;

        public BannerResponse(Banner banner) {
            this.asset = banner.getAsset();
            this.link = banner.getLink();
        }
    }
}
