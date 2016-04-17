package me.superkoh.evpn.service;

import me.superkoh.evpn.domain.entity.Banner;
import me.superkoh.evpn.domain.entity.Server;
import me.superkoh.evpn.domain.entity.ServerConnectCount;
import me.superkoh.evpn.domain.mapper.MyRadAcctMapper;
import me.superkoh.evpn.domain.mapper.NasMapper;
import me.superkoh.evpn.domain.model.Nas;
import me.superkoh.evpn.domain.model.NasExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
@Component
public class VpnService {

    private static HashMap<String, String> nasMapping = new HashMap<>();

    static {
        nasMapping.put("172.31.16.104", "52.69.16.186");
        nasMapping.put("104.131.143.69", "104.131.143.69");
        nasMapping.put("172.31.28.135", "52.196.18.70");
    }

    @Autowired
    private NasMapper nasMapper;

    @Autowired
    private MyRadAcctMapper myRadAcctMapper;

    @Transactional(readOnly = true)
    public List<Server> getServerList() {
        List<Nas> nasList = nasMapper.selectByExample(new NasExample());
        List<ServerConnectCount> serverConnectCountList = myRadAcctMapper.selectNasConnectCount();
        HashMap<String, Integer> serverConnectCountMap = new HashMap<>();
        serverConnectCountList.stream().filter(serverConnectCount ->
                nasMapping.containsKey(serverConnectCount.getIp())).forEach(serverConnectCount -> {
            serverConnectCountMap.put(nasMapping.get(serverConnectCount.getIp()),
                    serverConnectCount.getCnt() * 100);
        });
        List<Server> serverList = new ArrayList<>();
        for (Nas nas : nasList) {
            Server server = new Server();
            server.setName(nas.getShortname());
            server.setIp(nas.getNasname());
            if (serverConnectCountMap.containsKey(nas.getNasname())) {
                server.setCnt(serverConnectCountMap.get(nas.getNasname()));
            }
            serverList.add(server);
        }
        return serverList;
    }

    public List<Banner> getBannerList() {
        List<Banner> bannerList = new ArrayList<>();
        Banner banner = new Banner();
        banner.setAsset("http://img.117go.com/timg/upload/160417/4HFVvSal2gDgE3Hp.jpg");
        banner.setLink("http://travelid.cn/?refer=evpn");
        bannerList.add(banner);
        return bannerList;
    }
}
