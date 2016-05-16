package me.superkoh.evpn.controller.entity;


import me.superkoh.evpn.controller.base.BizResponse;
import me.superkoh.evpn.domain.model.radius.RadCheck;

/**
 * Created by KOH on 16/4/20.
 */
public class ConnectAuthResponse extends BizResponse {

    public String username;
    public String password;
    public String secret = "superkoh";

    public ConnectAuthResponse(RadCheck radCheck) {
        this.username = radCheck.getUsername();
        this.password = radCheck.getValue();
    }
}
