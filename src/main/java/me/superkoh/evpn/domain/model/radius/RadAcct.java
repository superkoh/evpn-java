package me.superkoh.evpn.domain.model.radius;

import java.util.Date;
import me.superkoh.evpn.domain.base.BaseRecord;

public class RadAcct extends BaseRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.radacctid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Long radacctid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctsessionid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String acctsessionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctuniqueid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String acctuniqueid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.username
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.groupname
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String groupname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.realm
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String realm;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.nasipaddress
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String nasipaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.nasportid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String nasportid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.nasporttype
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String nasporttype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctstarttime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Date acctstarttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctupdatetime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Date acctupdatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctstoptime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Date acctstoptime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctinterval
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Integer acctinterval;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctsessiontime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Integer acctsessiontime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctauthentic
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String acctauthentic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.connectinfo_start
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String connectinfoStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.connectinfo_stop
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String connectinfoStop;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctinputoctets
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Long acctinputoctets;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctoutputoctets
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private Long acctoutputoctets;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.calledstationid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String calledstationid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.callingstationid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String callingstationid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.acctterminatecause
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String acctterminatecause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.servicetype
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String servicetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.framedprotocol
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String framedprotocol;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column radacct.framedipaddress
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    private String framedipaddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.radacctid
     *
     * @return the value of radacct.radacctid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Long getRadacctid() {
        return radacctid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.radacctid
     *
     * @param radacctid the value for radacct.radacctid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setRadacctid(Long radacctid) {
        this.radacctid = radacctid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctsessionid
     *
     * @return the value of radacct.acctsessionid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getAcctsessionid() {
        return acctsessionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctsessionid
     *
     * @param acctsessionid the value for radacct.acctsessionid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctsessionid(String acctsessionid) {
        this.acctsessionid = acctsessionid == null ? null : acctsessionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctuniqueid
     *
     * @return the value of radacct.acctuniqueid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getAcctuniqueid() {
        return acctuniqueid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctuniqueid
     *
     * @param acctuniqueid the value for radacct.acctuniqueid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctuniqueid(String acctuniqueid) {
        this.acctuniqueid = acctuniqueid == null ? null : acctuniqueid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.username
     *
     * @return the value of radacct.username
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.username
     *
     * @param username the value for radacct.username
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.groupname
     *
     * @return the value of radacct.groupname
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.groupname
     *
     * @param groupname the value for radacct.groupname
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.realm
     *
     * @return the value of radacct.realm
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getRealm() {
        return realm;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.realm
     *
     * @param realm the value for radacct.realm
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setRealm(String realm) {
        this.realm = realm == null ? null : realm.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.nasipaddress
     *
     * @return the value of radacct.nasipaddress
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getNasipaddress() {
        return nasipaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.nasipaddress
     *
     * @param nasipaddress the value for radacct.nasipaddress
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setNasipaddress(String nasipaddress) {
        this.nasipaddress = nasipaddress == null ? null : nasipaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.nasportid
     *
     * @return the value of radacct.nasportid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getNasportid() {
        return nasportid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.nasportid
     *
     * @param nasportid the value for radacct.nasportid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setNasportid(String nasportid) {
        this.nasportid = nasportid == null ? null : nasportid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.nasporttype
     *
     * @return the value of radacct.nasporttype
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getNasporttype() {
        return nasporttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.nasporttype
     *
     * @param nasporttype the value for radacct.nasporttype
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setNasporttype(String nasporttype) {
        this.nasporttype = nasporttype == null ? null : nasporttype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctstarttime
     *
     * @return the value of radacct.acctstarttime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Date getAcctstarttime() {
        return acctstarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctstarttime
     *
     * @param acctstarttime the value for radacct.acctstarttime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctstarttime(Date acctstarttime) {
        this.acctstarttime = acctstarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctupdatetime
     *
     * @return the value of radacct.acctupdatetime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Date getAcctupdatetime() {
        return acctupdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctupdatetime
     *
     * @param acctupdatetime the value for radacct.acctupdatetime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctupdatetime(Date acctupdatetime) {
        this.acctupdatetime = acctupdatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctstoptime
     *
     * @return the value of radacct.acctstoptime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Date getAcctstoptime() {
        return acctstoptime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctstoptime
     *
     * @param acctstoptime the value for radacct.acctstoptime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctstoptime(Date acctstoptime) {
        this.acctstoptime = acctstoptime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctinterval
     *
     * @return the value of radacct.acctinterval
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Integer getAcctinterval() {
        return acctinterval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctinterval
     *
     * @param acctinterval the value for radacct.acctinterval
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctinterval(Integer acctinterval) {
        this.acctinterval = acctinterval;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctsessiontime
     *
     * @return the value of radacct.acctsessiontime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Integer getAcctsessiontime() {
        return acctsessiontime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctsessiontime
     *
     * @param acctsessiontime the value for radacct.acctsessiontime
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctsessiontime(Integer acctsessiontime) {
        this.acctsessiontime = acctsessiontime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctauthentic
     *
     * @return the value of radacct.acctauthentic
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getAcctauthentic() {
        return acctauthentic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctauthentic
     *
     * @param acctauthentic the value for radacct.acctauthentic
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctauthentic(String acctauthentic) {
        this.acctauthentic = acctauthentic == null ? null : acctauthentic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.connectinfo_start
     *
     * @return the value of radacct.connectinfo_start
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getConnectinfoStart() {
        return connectinfoStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.connectinfo_start
     *
     * @param connectinfoStart the value for radacct.connectinfo_start
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setConnectinfoStart(String connectinfoStart) {
        this.connectinfoStart = connectinfoStart == null ? null : connectinfoStart.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.connectinfo_stop
     *
     * @return the value of radacct.connectinfo_stop
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getConnectinfoStop() {
        return connectinfoStop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.connectinfo_stop
     *
     * @param connectinfoStop the value for radacct.connectinfo_stop
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setConnectinfoStop(String connectinfoStop) {
        this.connectinfoStop = connectinfoStop == null ? null : connectinfoStop.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctinputoctets
     *
     * @return the value of radacct.acctinputoctets
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Long getAcctinputoctets() {
        return acctinputoctets;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctinputoctets
     *
     * @param acctinputoctets the value for radacct.acctinputoctets
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctinputoctets(Long acctinputoctets) {
        this.acctinputoctets = acctinputoctets;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctoutputoctets
     *
     * @return the value of radacct.acctoutputoctets
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public Long getAcctoutputoctets() {
        return acctoutputoctets;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctoutputoctets
     *
     * @param acctoutputoctets the value for radacct.acctoutputoctets
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctoutputoctets(Long acctoutputoctets) {
        this.acctoutputoctets = acctoutputoctets;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.calledstationid
     *
     * @return the value of radacct.calledstationid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getCalledstationid() {
        return calledstationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.calledstationid
     *
     * @param calledstationid the value for radacct.calledstationid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setCalledstationid(String calledstationid) {
        this.calledstationid = calledstationid == null ? null : calledstationid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.callingstationid
     *
     * @return the value of radacct.callingstationid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getCallingstationid() {
        return callingstationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.callingstationid
     *
     * @param callingstationid the value for radacct.callingstationid
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setCallingstationid(String callingstationid) {
        this.callingstationid = callingstationid == null ? null : callingstationid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.acctterminatecause
     *
     * @return the value of radacct.acctterminatecause
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getAcctterminatecause() {
        return acctterminatecause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.acctterminatecause
     *
     * @param acctterminatecause the value for radacct.acctterminatecause
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setAcctterminatecause(String acctterminatecause) {
        this.acctterminatecause = acctterminatecause == null ? null : acctterminatecause.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.servicetype
     *
     * @return the value of radacct.servicetype
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getServicetype() {
        return servicetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.servicetype
     *
     * @param servicetype the value for radacct.servicetype
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setServicetype(String servicetype) {
        this.servicetype = servicetype == null ? null : servicetype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.framedprotocol
     *
     * @return the value of radacct.framedprotocol
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getFramedprotocol() {
        return framedprotocol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.framedprotocol
     *
     * @param framedprotocol the value for radacct.framedprotocol
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setFramedprotocol(String framedprotocol) {
        this.framedprotocol = framedprotocol == null ? null : framedprotocol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column radacct.framedipaddress
     *
     * @return the value of radacct.framedipaddress
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public String getFramedipaddress() {
        return framedipaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column radacct.framedipaddress
     *
     * @param framedipaddress the value for radacct.framedipaddress
     *
     * @mbggenerated Fri May 20 15:54:07 CST 2016
     */
    public void setFramedipaddress(String framedipaddress) {
        this.framedipaddress = framedipaddress == null ? null : framedipaddress.trim();
    }
}