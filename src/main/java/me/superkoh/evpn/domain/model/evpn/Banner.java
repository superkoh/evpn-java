package me.superkoh.evpn.domain.model.evpn;

public class Banner {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.id
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.asset_url
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    private String assetUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.link_url
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    private String linkUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column banner.id
     *
     * @return the value of banner.id
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column banner.id
     *
     * @param id the value for banner.id
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column banner.asset_url
     *
     * @return the value of banner.asset_url
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    public String getAssetUrl() {
        return assetUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column banner.asset_url
     *
     * @param assetUrl the value for banner.asset_url
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    public void setAssetUrl(String assetUrl) {
        this.assetUrl = assetUrl == null ? null : assetUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column banner.link_url
     *
     * @return the value of banner.link_url
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column banner.link_url
     *
     * @param linkUrl the value for banner.link_url
     *
     * @mbggenerated Sun May 08 17:36:19 CST 2016
     */
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }
}