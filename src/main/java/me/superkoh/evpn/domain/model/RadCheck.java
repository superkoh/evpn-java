package me.superkoh.evpn.domain.model;

public class RadCheck {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radcheck.id
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radcheck.username
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radcheck.attribute
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String attribute;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radcheck.op
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String op;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radcheck.value
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    private String value;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radcheck.id
     *
     * @return the value of radcheck.id
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radcheck.id
     *
     * @param id the value for radcheck.id
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radcheck.username
     *
     * @return the value of radcheck.username
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radcheck.username
     *
     * @param username the value for radcheck.username
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radcheck.attribute
     *
     * @return the value of radcheck.attribute
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getAttribute() {
        return attribute;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radcheck.attribute
     *
     * @param attribute the value for radcheck.attribute
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radcheck.op
     *
     * @return the value of radcheck.op
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getOp() {
        return op;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radcheck.op
     *
     * @param op the value for radcheck.op
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setOp(String op) {
        this.op = op == null ? null : op.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radcheck.value
     *
     * @return the value of radcheck.value
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radcheck.value
     *
     * @param value the value for radcheck.value
     *
     * @mbggenerated Thu Apr 21 22:44:30 CST 2016
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}