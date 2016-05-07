package me.superkoh.evpn.service;

import me.superkoh.evpn.domain.entity.NasConnectCount;
import me.superkoh.evpn.domain.mapper.radius.NasMapper;
import me.superkoh.evpn.domain.mapper.radius.RadAcctMapper;
import me.superkoh.evpn.domain.model.radius.Nas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by KOH on 16/5/7.
 */
@Service
public class NasService {

    @Autowired
    private NasMapper nasMapper;

    @Autowired
    private RadAcctMapper radAcctMapper;

    @Transactional(readOnly = true, transactionManager = "radiusTransactionManager")
    public List<Nas> getAllNasList() {
        return nasMapper.selectByExample(null);
    }

    @Transactional(readOnly = true, transactionManager = "radiusTransactionManager")
    public Map<String, Integer> getNasConnectCount() {
        List<NasConnectCount> list = radAcctMapper.getNasConnectCount();
        HashMap<String, Integer> map = new HashMap<>();
        for (NasConnectCount connectCount : list) {
            map.put(connectCount.getIp(), connectCount.getCnt());
        }
        return map;
    }
}
