package me.superkoh.evpn.web;

import me.superkoh.evpn.domain.entity.Banner;
import me.superkoh.evpn.domain.entity.Server;
import me.superkoh.evpn.service.VpnService;
import me.superkoh.evpn.web.response.ConfigResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
        response.servers.addAll(serverList.stream().map(ConfigResponse.ServerResponse::new)
                .collect(Collectors.toList()));
        response.ads.addAll(bannerList.stream().map(ConfigResponse.BannerResponse::new)
                .collect(Collectors.toList()));
        return response;
    }
}
