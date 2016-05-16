package me.superkoh.evpn.controller.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import me.superkoh.evpn.controller.base.BizResponse;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.service.entity.VipUserWithToken;

import java.util.Date;

/**
 * Created by KOH on 16/5/12.
 */
public class VipUserInfoResponse extends BizResponse {

    public String mobile;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "GMT+8")
    public Date expireDate;

    public String token;

    public VipUserInfoResponse() {
    }

    public VipUserInfoResponse(VipUserWithToken userWithToken) {
        this.mobile = userWithToken.getUser().getMobile();
        this.expireDate = userWithToken.getUser().getExpireDate();
        this.token = userWithToken.getToken().getToken();
    }

    public VipUserInfoResponse(VipUser user, String token) {
        this.mobile = user.getMobile();
        this.expireDate = user.getExpireDate();
        this.token = token;
    }
}
