package me.superkoh.evpn.component.weidian.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KOH on 16/5/13.
 */
public class WeidianQuery {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Map<String, String> _param = new HashMap<>();
    private Map<String, String> _public = new HashMap<>();

    public WeidianQuery(String method, String accessToken) {
        this.addPublic("method", method);
        this.addPublic("access_token", accessToken);
    }

    public void addParam(String name, String value) {
        this._param.put(name, value);
    }

    public void addPublic(String name, String value) {
        this._public.put(name, value);
    }

    public MultiValueMap<String, String> toQueryMap() throws UnsupportedEncodingException {
        MultiValueMap<String, String> queryMap = new LinkedMultiValueMap<>();
        try {
            queryMap.add("param", objectMapper.writeValueAsString(this._param));
            queryMap.add("public", objectMapper.writeValueAsString(this._public));
        } catch (JsonProcessingException e) {
        }
        return queryMap;
    }

    public String getParamStr() throws JsonProcessingException {
        return objectMapper.writeValueAsString(this._param);
    }

    public String getPublicStr() throws JsonProcessingException {
        return objectMapper.writeValueAsString(this._public);
    }
}
