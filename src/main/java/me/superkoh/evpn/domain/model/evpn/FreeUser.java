package me.superkoh.evpn.domain.model.evpn;

import java.util.Date;
import me.superkoh.evpn.domain.base.BaseRecord;

public class FreeUser extends BaseRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column free_user.id
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column free_user.username
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column free_user.expire_date
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    private Date expireDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column free_user.create_time
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column free_user.id
     *
     * @return the value of free_user.id
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column free_user.id
     *
     * @param id the value for free_user.id
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column free_user.username
     *
     * @return the value of free_user.username
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column free_user.username
     *
     * @param username the value for free_user.username
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column free_user.expire_date
     *
     * @return the value of free_user.expire_date
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column free_user.expire_date
     *
     * @param expireDate the value for free_user.expire_date
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column free_user.create_time
     *
     * @return the value of free_user.create_time
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column free_user.create_time
     *
     * @param createTime the value for free_user.create_time
     *
     * @mbggenerated Thu May 12 15:10:16 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}