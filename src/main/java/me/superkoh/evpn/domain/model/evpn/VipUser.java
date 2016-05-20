package me.superkoh.evpn.domain.model.evpn;

import java.util.Date;
import me.superkoh.evpn.domain.base.BaseRecord;

public class VipUser extends BaseRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_user.id
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_user.mobile
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_user.expire_date
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    private Date expireDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vip_user.create_time
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_user.id
     *
     * @return the value of vip_user.id
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_user.id
     *
     * @param id the value for vip_user.id
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_user.mobile
     *
     * @return the value of vip_user.mobile
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_user.mobile
     *
     * @param mobile the value for vip_user.mobile
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_user.expire_date
     *
     * @return the value of vip_user.expire_date
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_user.expire_date
     *
     * @param expireDate the value for vip_user.expire_date
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vip_user.create_time
     *
     * @return the value of vip_user.create_time
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vip_user.create_time
     *
     * @param createTime the value for vip_user.create_time
     *
     * @mbggenerated Fri May 20 16:05:01 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}