package me.superkoh.evpn.service.entity;

import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.domain.model.evpn.VipUserToken;

/**
 * Created by KOH on 16/5/12.
 */
public class VipUserWithToken {

    private VipUser user;
    private VipUserToken token;

    public VipUserWithToken(VipUser user, VipUserToken token) {
        this.user = user;
        this.token = token;
    }

    public VipUser getUser() {
        return user;
    }

    public void setUser(VipUser user) {
        this.user = user;
    }

    public VipUserToken getToken() {
        return token;
    }

    public void setToken(VipUserToken token) {
        this.token = token;
    }
}
