package me.superkoh.evpn.web.controller;

import me.superkoh.evpn.domain.entity.Banner;
import me.superkoh.evpn.domain.entity.Server;
import me.superkoh.evpn.domain.model.EVpnUser;
import me.superkoh.evpn.domain.model.RadCheck;
import me.superkoh.evpn.exception.BizException;
import me.superkoh.evpn.exception.IllegalRequestParamException;
import me.superkoh.evpn.exception.MonthlyTrafficOverLimitException;
import me.superkoh.evpn.service.VpnService;
import me.superkoh.evpn.service.entitiy.UserTrafficInfo;
import me.superkoh.evpn.web.response.ConfigResponse;
import me.superkoh.evpn.web.response.ConnectAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by KOH on 16/4/17.
 */
@RestController
public class VpnController {

    @Autowired
    private VpnService vpnService;

    @RequestMapping(path = "/config.php")
    public ConfigResponse config(HttpServletRequest request) throws Exception {
        String username = request.getParameter("vd");
        if (null == username || username.isEmpty()) {
            throw new IllegalRequestParamException("vd");
        }
        List<Server> serverList = vpnService.getServerList();
        List<Banner> bannerList = vpnService.getBannerList();
        UserTrafficInfo trafficInfo = vpnService.getRemainTraffic(username);
        ConfigResponse response = new ConfigResponse();
        response.servers.addAll(serverList.stream().map(ConfigResponse.ServerResponse::new)
                .collect(Collectors.toList()));
        response.ads.addAll(bannerList.stream().map(ConfigResponse.BannerResponse::new)
                .collect(Collectors.toList()));
        response.trafficInfo = new ConfigResponse.UserTrafficInfoResponse(trafficInfo);
        return response;
    }

    @RequestMapping(path = "/connect.php")
    public ConnectAuthResponse connect(HttpServletRequest request) throws Exception {
        String username = request.getParameter("vd");
        if (null == username || username.isEmpty()) {
            throw new IllegalRequestParamException("vd");
        }
        EVpnUser eVpnUser = vpnService.getVpnUser(username);
        if (null == eVpnUser) {
            eVpnUser = vpnService.createEVpnUser(username);
        }
        RadCheck radCheck = vpnService.getUserAuthByName(username);
        if (null != radCheck) {
            if (vpnService.isTrafficOverLimit(eVpnUser)) {
                throw new MonthlyTrafficOverLimitException();
            }
            return new ConnectAuthResponse(radCheck);
        } else {
            radCheck = vpnService.createNewUser(username);
            return new ConnectAuthResponse(radCheck);
        }
    }

}
