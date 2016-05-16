package me.superkoh.evpn.service.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KOH on 16/5/13.
 */
public class WeidianQuery {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Map<String, String> _param = new HashMap<>();
    private Map<String, String> _public = new HashMap<>();

    public void addParam(String name, String value) {
        this._param.put(name, value);
    }

    public void addPublic(String name, String value) {
        this._public.put(name, value);
    }

    public MultiValueMap<String, String> toQueryMap() {
        MultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
        try {
            queryMap.add("param", objectMapper.writeValueAsString(this._param));
            queryMap.add("public", objectMapper.writeValueAsString(this._public));
        } catch (JsonProcessingException e) {
        }
        return queryMap;
    }
}
