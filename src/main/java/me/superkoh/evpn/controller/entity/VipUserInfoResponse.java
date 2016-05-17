package me.superkoh.evpn.controller.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.superkoh.evpn.controller.base.BizResponse;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.service.entity.VipUserWithToken;

import java.util.Date;

/**
 * Created by KOH on 16/5/12.
 */
@ApiModel
public class VipUserInfoResponse extends BizResponse {

    @ApiModelProperty(required = true, value = "用户手机号")
    public String mobile;

    @ApiModelProperty(value = "用户套餐截止日期", required = true)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "GMT+8")
    public Date expireDate;

    @ApiModelProperty(value = "用户当前登录Token", required = true)
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
