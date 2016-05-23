package me.superkoh.evpn.domain.model.evpn;

import me.superkoh.evpn.domain.base.BaseRecord;

public class Product extends BaseRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.id
     *
     * @mbggenerated Mon May 23 12:01:53 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product.limit_in_month
     *
     * @mbggenerated Mon May 23 12:01:53 CST 2016
     */
    private Integer limitInMonth;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.id
     *
     * @return the value of product.id
     *
     * @mbggenerated Mon May 23 12:01:53 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.id
     *
     * @param id the value for product.id
     *
     * @mbggenerated Mon May 23 12:01:53 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product.limit_in_month
     *
     * @return the value of product.limit_in_month
     *
     * @mbggenerated Mon May 23 12:01:53 CST 2016
     */
    public Integer getLimitInMonth() {
        return limitInMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product.limit_in_month
     *
     * @param limitInMonth the value for product.limit_in_month
     *
     * @mbggenerated Mon May 23 12:01:53 CST 2016
     */
    public void setLimitInMonth(Integer limitInMonth) {
        this.limitInMonth = limitInMonth;
    }
}