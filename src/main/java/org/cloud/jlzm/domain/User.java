package org.cloud.jlzm.domain;

import java.util.Date;

public class User {
    private String userId;
    private String deptId;
    private String userName;
    private String kanaName;
    private String password;
    private String genDiv;
    private String htelNo;
    private String famReg;
    private String addr;
    private String edct;
    private String gradtSchl;
    private String spec;
    private Date gradtDate;
    private String jpLv;
    private String enLv;
    private Date entcomDate;
    private String attdncChkSgn;
    private int atthCd;
    private String empDiv;
    private Date lvjobDate;
    private String delSgn;
    private String addBy;
    private String addDate;
    private String updBy;
    private String updDate;
    private int lockVerCnt;
    private String taxprc;
    private String passportNo;
    private Date expDate;
    private Date birthday;
    private String jpClass;
    private Date jpDate;
    private Date enDate;
    private String jpExMm;
    private String idCard;
    private String email;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getKanaName() {
		return kanaName;
	}
	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGenDiv() {
		return genDiv;
	}
	public void setGenDiv(String genDiv) {
		this.genDiv = genDiv;
	}
	public String getHtelNo() {
		return htelNo;
	}
	public void setHtelNo(String htelNo) {
		this.htelNo = htelNo;
	}
	public String getFamReg() {
		return famReg;
	}
	public void setFamReg(String famReg) {
		this.famReg = famReg;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getEdct() {
		return edct;
	}
	public void setEdct(String edct) {
		this.edct = edct;
	}
	public String getGradtSchl() {
		return gradtSchl;
	}
	public void setGradtSchl(String gradtSchl) {
		this.gradtSchl = gradtSchl;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public Date getGradtDate() {
		return gradtDate;
	}
	public void setGradtDate(Date gradtDate) {
		this.gradtDate = gradtDate;
	}
	public String getJpLv() {
		return jpLv;
	}
	public void setJpLv(String jpLv) {
		this.jpLv = jpLv;
	}
	public String getEnLv() {
		return enLv;
	}
	public void setEnLv(String enLv) {
		this.enLv = enLv;
	}
	public Date getEntcomDate() {
		return entcomDate;
	}
	public void setEntcomDate(Date entcomDate) {
		this.entcomDate = entcomDate;
	}
	public String getAttdncChkSgn() {
		return attdncChkSgn;
	}
	public void setAttdncChkSgn(String attdncChkSgn) {
		this.attdncChkSgn = attdncChkSgn;
	}
	public int getAtthCd() {
		return atthCd;
	}
	public void setAtthCd(int atthCd) {
		this.atthCd = atthCd;
	}
	public String getEmpDiv() {
		return empDiv;
	}
	public void setEmpDiv(String empDiv) {
		this.empDiv = empDiv;
	}
	public Date getLvjobDate() {
		return lvjobDate;
	}
	public void setLvjobDate(Date lvjobDate) {
		this.lvjobDate = lvjobDate;
	}
	public String getDelSgn() {
		return delSgn;
	}
	public void setDelSgn(String delSgn) {
		this.delSgn = delSgn;
	}
	public String getAddBy() {
		return addBy;
	}
	public void setAddBy(String addBy) {
		this.addBy = addBy;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getUpdBy() {
		return updBy;
	}
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}
	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}
	public int getLockVerCnt() {
		return lockVerCnt;
	}
	public void setLockVerCnt(int lockVerCnt) {
		this.lockVerCnt = lockVerCnt;
	}
	public String getTaxprc() {
		return taxprc;
	}
	public void setTaxprc(String taxprc) {
		this.taxprc = taxprc;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getJpClass() {
		return jpClass;
	}
	public void setJpClass(String jpClass) {
		this.jpClass = jpClass;
	}
	public Date getJpDate() {
		return jpDate;
	}
	public void setJpDate(Date jpDate) {
		this.jpDate = jpDate;
	}
	public Date getEnDate() {
		return enDate;
	}
	public void setEnDate(Date enDate) {
		this.enDate = enDate;
	}
	public String getJpExMm() {
		return jpExMm;
	}
	public void setJpExMm(String jpExMm) {
		this.jpExMm = jpExMm;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", kanaName=" + kanaName + "]";
	}
}
