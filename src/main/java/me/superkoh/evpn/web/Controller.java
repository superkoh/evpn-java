package me.superkoh.evpn.web;

import me.superkoh.evpn.domain.entity.Banner;
import me.superkoh.evpn.domain.entity.Server;
import me.superkoh.evpn.service.VpnService;
import me.superkoh.evpn.web.response.ConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
@RestController
public class Controller {

    @Autowired
    private VpnService vpnService;

    @RequestMapping(path = "/config.php")
    public ConfigResponse config() {
        List<Server> serverList = vpnService.getServerList();
        List<Banner> bannerList = vpnService.getBannerList();
        ConfigResponse response = new ConfigResponse();
        for (Server server : serverList) {
            response.servers.add(new ConfigResponse.ServerResponse(server));
        }
        for (Banner banner : bannerList) {
            response.ads.add(new ConfigResponse.BannerResponse(banner));
        }
        return response;
    }
}
