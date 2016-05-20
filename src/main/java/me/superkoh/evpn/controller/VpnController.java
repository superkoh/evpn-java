package me.superkoh.evpn.controller;

import io.swagger.annotations.ApiOperation;
import me.superkoh.evpn.controller.base.EmptyResponse;
import me.superkoh.evpn.controller.entity.ConfigResponse;
import me.superkoh.evpn.controller.entity.ConnectAuthResponse;
import me.superkoh.evpn.controller.entity.VipUserInfoResponse;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.domain.model.radius.Nas;
import me.superkoh.evpn.service.BannerService;
import me.superkoh.evpn.service.NasService;
import me.superkoh.evpn.service.OrderService;
import me.superkoh.evpn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by KOH on 16/4/17.
 */
@RestController
public class VpnController {

    public static final Logger logger = LoggerFactory.getLogger(VpnController.class);

    public static final Logger callbackLogger = LoggerFactory.getLogger("weidianCallbackLogger");

    @Autowired
    private UserService userService;

    @Autowired
    private NasService nasService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private OrderService orderService;

    @ApiOperation("获取服务器及当前用户信息")
    @RequestMapping(path = "/config.php", method = RequestMethod.GET, produces = {MediaType
            .APPLICATION_JSON_UTF8_VALUE}, consumes = MediaType.ALL_VALUE)
    public ConfigResponse config(HttpServletRequest request) throws Exception {
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
        VipUser user = (VipUser) request.getAttribute("curUser");
        if (null != user) {
            response.userInfo = new VipUserInfoResponse(user, String.valueOf(request.getAttribute("curUserToken")));
        }
        return response;
    }

    @ApiOperation("获取用户VPN连接账户")
    @RequestMapping(path = "/connect.php", method = RequestMethod.GET, produces = {MediaType
            .APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.ALL_VALUE})
    public ConnectAuthResponse connect(HttpServletRequest request) throws Exception {
        String vd = (String) request.getAttribute("vd");
        userService.createFreeUserIfNotExists(vd);
        return new ConnectAuthResponse(userService.createConnInfoIfNotExists(vd));
    }

    @ApiIgnore
    @RequestMapping(path = "/weidian-notify", method = {RequestMethod.GET, RequestMethod.POST})
    public EmptyResponse weidianCallback(HttpServletRequest request) throws Exception {
        String content = request.getParameter("content");
        callbackLogger.info(content);
        orderService.orderCallback(content);
        return new EmptyResponse();
    }

}
