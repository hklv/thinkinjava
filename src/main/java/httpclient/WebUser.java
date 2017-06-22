package httpclient;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-22 20:51.
 */
public class WebUser {
    //用户名
    private String userName;

    //真实姓名
    private String trueName;

    //手机号
    private String phoneNum;

    //用户类型 P 个人，O 法人
    private String userType;

    //是否是本省用户 Y是，N否
    private String isLocalUser;

    //用户身份证号
    private String idCardNo;
    //证件类型
    private String certType;
    //证件号
    private String certNo;
    //性别
    private String sex;
    //地址
    private String address;
    //邮箱
    private String email;
    //认证级别
    private String authGrade;
    //法人信息
    //机构名称
    private String orgName;

    //机构类型
    private String orgType;

    //社会信用代码
    private String orgCardNo;
    //注册地址
    private String orgAddress;
    //法人姓名
    private String orgLegalPerson;
    //法人身份证号
    private String orgLegalPersonNo;
    //法人手机号
    private String orgLegalPersonPhone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgCardNo() {
        return orgCardNo;
    }

    public void setOrgCardNo(String orgCardNo) {
        this.orgCardNo = orgCardNo;
    }

    public String getIsLocalUser() {
        return isLocalUser;
    }

    public void setIsLocalUser(String isLocalUser) {
        this.isLocalUser = isLocalUser;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAuthGrade(String authGrade) {
        this.authGrade = authGrade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthGrade() {
        return authGrade;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgLegalPerson() {
        return orgLegalPerson;
    }

    public void setOrgLegalPerson(String orgLegalPerson) {
        this.orgLegalPerson = orgLegalPerson;
    }

    public String getOrgLegalPersonNo() {
        return orgLegalPersonNo;
    }

    public void setOrgLegalPersonNo(String orgLegalPersonNo) {
        this.orgLegalPersonNo = orgLegalPersonNo;
    }

    public String getOrgLegalPersonPhone() {
        return orgLegalPersonPhone;
    }

    public void setOrgLegalPersonPhone(String orgLegalPersonPhone) {
        this.orgLegalPersonPhone = orgLegalPersonPhone;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
}
