package me.superkoh.evpn.controller;

import me.superkoh.evpn.controller.base.EmptyResponse;
import me.superkoh.evpn.controller.entity.ConfigResponse;
import me.superkoh.evpn.controller.entity.ConnectAuthResponse;
import me.superkoh.evpn.controller.entity.VipUserInfoResponse;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.domain.model.radius.Nas;
import me.superkoh.evpn.exception.IllegalRequestParamException;
import me.superkoh.evpn.service.BannerService;
import me.superkoh.evpn.service.NasService;
import me.superkoh.evpn.service.UserService;
import me.superkoh.evpn.service.entity.VipUserWithToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by KOH on 16/4/17.
 */
@RestController
public class VpnController {

    public static final Logger logger = LoggerFactory.getLogger(VpnController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private NasService nasService;

    @Autowired
    private BannerService bannerService;

    @RequestMapping(path = "/config.php", method = RequestMethod.GET)
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

    @RequestMapping(path = "/connect.php", method = RequestMethod.GET)
    public ConnectAuthResponse connect(HttpServletRequest request) throws Exception {
        String vd = (String) request.getAttribute("vd");
        userService.createFreeUserIfNotExists(vd);
        return new ConnectAuthResponse(userService.createConnInfoIfNotExists(vd));
    }

    @RequestMapping(path = "/notify.php", method = {RequestMethod.GET, RequestMethod.POST})
    public List<String> weidianCallback(HttpServletRequest request) throws IOException {
        String content = request.getParameter("content");
        logger.info(content);
        return Collections.singletonList("ok");
    }

    @RequestMapping(path = "/sendMobileCode.php", method = RequestMethod.POST)
    public EmptyResponse sendMobileCode(String mobile, String captcha, HttpServletRequest request) throws IOException {
        if (null == mobile || mobile.isEmpty()) {
            throw new IllegalRequestParamException("mobile");
        }
        if (null == captcha || captcha.isEmpty()) {
            throw new IllegalRequestParamException("captcha");
        }
        userService.sendMobileCode(mobile, captcha, (String) request.getAttribute("vd"));
        return new EmptyResponse();
    }

    @RequestMapping(path = "/login.php", method = RequestMethod.POST)
    public VipUserInfoResponse loginWithMobile(String mobile, String code, HttpServletRequest request) throws
            Exception {
        if (null == mobile || mobile.isEmpty()) {
            throw new IllegalRequestParamException("mobile");
        }
        if (null == code || code.isEmpty()) {
            throw new IllegalRequestParamException("code");
        }
        String vd = (String) request.getAttribute("vd");
        VipUserWithToken userWithToken = userService.loginWithMobile(mobile, code, vd);
        return new VipUserInfoResponse(userWithToken);
    }

}
