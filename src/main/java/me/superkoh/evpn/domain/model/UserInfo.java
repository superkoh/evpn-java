package me.superkoh.evpn.domain.model;

import java.util.Date;

public class UserInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.id
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.username
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.firstname
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String firstname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.lastname
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String lastname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.email
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.department
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String department;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.company
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String company;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.workphone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String workphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.homephone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String homephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.mobilephone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String mobilephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.address
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.city
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.state
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.country
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.zip
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String zip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.notes
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String notes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.changeuserinfo
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String changeuserinfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.portalloginpassword
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String portalloginpassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.enableportallogin
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private Integer enableportallogin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.creationdate
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private Date creationdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.creationby
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String creationby;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.updatedate
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private Date updatedate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userinfo.updateby
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String updateby;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.id
     *
     * @return the value of userinfo.id
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.id
     *
     * @param id the value for userinfo.id
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.username
     *
     * @return the value of userinfo.username
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.username
     *
     * @param username the value for userinfo.username
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.firstname
     *
     * @return the value of userinfo.firstname
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.firstname
     *
     * @param firstname the value for userinfo.firstname
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname == null ? null : firstname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.lastname
     *
     * @return the value of userinfo.lastname
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.lastname
     *
     * @param lastname the value for userinfo.lastname
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.email
     *
     * @return the value of userinfo.email
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.email
     *
     * @param email the value for userinfo.email
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.department
     *
     * @return the value of userinfo.department
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getDepartment() {
        return department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.department
     *
     * @param department the value for userinfo.department
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.company
     *
     * @return the value of userinfo.company
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.company
     *
     * @param company the value for userinfo.company
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.workphone
     *
     * @return the value of userinfo.workphone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getWorkphone() {
        return workphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.workphone
     *
     * @param workphone the value for userinfo.workphone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setWorkphone(String workphone) {
        this.workphone = workphone == null ? null : workphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.homephone
     *
     * @return the value of userinfo.homephone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getHomephone() {
        return homephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.homephone
     *
     * @param homephone the value for userinfo.homephone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setHomephone(String homephone) {
        this.homephone = homephone == null ? null : homephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.mobilephone
     *
     * @return the value of userinfo.mobilephone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getMobilephone() {
        return mobilephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.mobilephone
     *
     * @param mobilephone the value for userinfo.mobilephone
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.address
     *
     * @return the value of userinfo.address
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.address
     *
     * @param address the value for userinfo.address
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.city
     *
     * @return the value of userinfo.city
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.city
     *
     * @param city the value for userinfo.city
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.state
     *
     * @return the value of userinfo.state
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.state
     *
     * @param state the value for userinfo.state
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.country
     *
     * @return the value of userinfo.country
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.country
     *
     * @param country the value for userinfo.country
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.zip
     *
     * @return the value of userinfo.zip
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getZip() {
        return zip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.zip
     *
     * @param zip the value for userinfo.zip
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.notes
     *
     * @return the value of userinfo.notes
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getNotes() {
        return notes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.notes
     *
     * @param notes the value for userinfo.notes
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.changeuserinfo
     *
     * @return the value of userinfo.changeuserinfo
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getChangeuserinfo() {
        return changeuserinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.changeuserinfo
     *
     * @param changeuserinfo the value for userinfo.changeuserinfo
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setChangeuserinfo(String changeuserinfo) {
        this.changeuserinfo = changeuserinfo == null ? null : changeuserinfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.portalloginpassword
     *
     * @return the value of userinfo.portalloginpassword
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getPortalloginpassword() {
        return portalloginpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.portalloginpassword
     *
     * @param portalloginpassword the value for userinfo.portalloginpassword
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setPortalloginpassword(String portalloginpassword) {
        this.portalloginpassword = portalloginpassword == null ? null : portalloginpassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.enableportallogin
     *
     * @return the value of userinfo.enableportallogin
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public Integer getEnableportallogin() {
        return enableportallogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.enableportallogin
     *
     * @param enableportallogin the value for userinfo.enableportallogin
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setEnableportallogin(Integer enableportallogin) {
        this.enableportallogin = enableportallogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.creationdate
     *
     * @return the value of userinfo.creationdate
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public Date getCreationdate() {
        return creationdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.creationdate
     *
     * @param creationdate the value for userinfo.creationdate
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.creationby
     *
     * @return the value of userinfo.creationby
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getCreationby() {
        return creationby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.creationby
     *
     * @param creationby the value for userinfo.creationby
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setCreationby(String creationby) {
        this.creationby = creationby == null ? null : creationby.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.updatedate
     *
     * @return the value of userinfo.updatedate
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.updatedate
     *
     * @param updatedate the value for userinfo.updatedate
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userinfo.updateby
     *
     * @return the value of userinfo.updateby
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getUpdateby() {
        return updateby;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userinfo.updateby
     *
     * @param updateby the value for userinfo.updateby
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }
}