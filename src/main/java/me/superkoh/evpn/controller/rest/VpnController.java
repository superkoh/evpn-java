package me.superkoh.evpn.controller.rest;

import me.superkoh.evpn.controller.rest.entity.ConfigResponse;
import me.superkoh.evpn.controller.rest.entity.ConnectAuthResponse;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.radius.Nas;
import me.superkoh.evpn.domain.model.radius.RadCheck;
import me.superkoh.evpn.exception.IllegalRequestParamException;
import me.superkoh.evpn.service.BannerService;
import me.superkoh.evpn.service.NasService;
import me.superkoh.evpn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by KOH on 16/4/17.
 */
@RestController
public class VpnController {

    @Autowired
    private UserService userService;

    @Autowired
    private NasService nasService;

    @Autowired
    private BannerService bannerService;

    @RequestMapping(path = "/config.php")
    public ConfigResponse config() throws Exception {
        List<Nas> nasList = nasService.getAllNasList();
        Map<String, Integer> nasConnectCount = nasService.getNasConnectCount();
        List<Banner> bannerList = bannerService.getBannerList();
        ConfigResponse response = new ConfigResponse();
        for (Nas nas : nasList) {
            int connectCount = 0;
            if (nasConnectCount.containsKey(nas.getNasname())) {
                connectCount = nasConnectCount.get(nas.getNasname());
            }
            response.servers.add(new ConfigResponse.ServerResponse(nas, connectCount));
        }
        response.ads.addAll(bannerList.stream().map(ConfigResponse.BannerResponse::new)
                .collect(Collectors.toList()));
        return response;
    }

    @RequestMapping(path = "/connect.php")
    public ConnectAuthResponse connect(String vd, HttpServletRequest request) throws Exception {
        if (null == vd || vd.isEmpty()) {
            throw new IllegalRequestParamException("vd");
        }
        RadCheck radCheck = userService.getConnInfoByDevice(vd);
        if (null == radCheck) {
            return new ConnectAuthResponse(userService.createNewConnInfo(vd));
        } else {
            return new ConnectAuthResponse(radCheck);
        }
    }

}