package me.superkoh.evpn.controller.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.superkoh.evpn.controller.base.BizResponse;
import me.superkoh.evpn.domain.model.radius.RadCheck;

/**
 * Created by KOH on 16/4/20.
 */
@ApiModel
public class ConnectAuthResponse extends BizResponse {

    @ApiModelProperty(value = "VPN拨号用户名", required = true)
    public String username;

    @ApiModelProperty(value = "VPN拨号密码", required = true)
    public String password;

    @ApiModelProperty(value = "VPN拨号Secret", required = true)
    public String secret = "superkoh";

    public ConnectAuthResponse(RadCheck radCheck) {
        this.username = radCheck.getUsername();
        this.password = radCheck.getValue();
    }
}
