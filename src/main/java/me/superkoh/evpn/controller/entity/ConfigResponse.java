package me.superkoh.evpn.controller.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import me.superkoh.evpn.controller.base.BizResponse;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.radius.Nas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class ConfigResponse extends BizResponse {

    @ApiModelProperty(value = "vpn服务器列表", required = true)
    public List<ServerResponse> servers = new ArrayList<>();

    @ApiModelProperty(value = "广告Banner列表")
    public List<BannerResponse> ads = new ArrayList<>();

    @ApiModelProperty(value = "是否强制升级", required = true)
    public boolean forceUpdate = false;

    @ApiModelProperty(value = "强制升级引导Webview", required = true)
    public String forceUpdateWebview = "";

    @ApiModelProperty(value = "当前登录用户信息")
    public VipUserInfoResponse userInfo;

    @ApiModelProperty(value = "是否需要升级", required = true)
    @Deprecated
    public boolean needUpdate = false;

    @ApiModelProperty(value = "升级信息", required = true)
    @Deprecated
    public String updateInfo = "";

    @ApiModel
    public static class ServerResponse {
        @ApiModelProperty(value = "服务器IP", required = true)
        public String ip;

        @ApiModelProperty(value = "服务器名称", required =  true)
        public String name;

        @ApiModelProperty(value = "服务器当前连接加权参数", required = true)
        public int cnt;

        @ApiModelProperty(value = "服务器当前真实连接数", required = true)
        public int rcnt;

        public ServerResponse(Nas nas, int connectCount) {
            this.ip = nas.getNasname();
            this.name = nas.getShortname();
            this.cnt = connectCount * 3;
            this.rcnt = connectCount;
        }
    }

    @ApiModel
    public static class BannerResponse {

        @ApiModelProperty(value = "图片或视频地址", required = true)
        public String asset;

        @ApiModelProperty(value = "图片或视频跳转地址", required = true)
        public String link;

        @ApiModelProperty(value = "生效时间", required = true)
        @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "GMT+8")
        public Date onlineTime;

        @ApiModelProperty(value = "失效时间", required = true)
        @JsonFormat(shape = JsonFormat.Shape.NUMBER, timezone = "GMT+8")
        public Date offlineTime;

        public BannerResponse(Banner banner) {
            this.asset = banner.getAssetUrl();
            this.link = banner.getLinkUrl();
            this.onlineTime = banner.getOnlineTime();
            this.offlineTime = banner.getOfflineTime();
        }
    }
}
