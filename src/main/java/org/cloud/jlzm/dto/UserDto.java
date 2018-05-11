package org.cloud.jlzm.dto;

import org.cloud.jlzm.domain.User;

public class UserDto extends BaseDto<User> {

    private String userName;
    private String deptName;
    private String genDiv;
    private String education;
    private String japaneseLevel;
    private String delSgn;
    private String phoneNumber;
    private String graduateDate;
    private String accessionDate;
    private String empDiv;
    private String birthday;
    private String jpDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getGenDiv() {
        return genDiv;
    }

    public void setGenDiv(String genDiv) {
        this.genDiv = genDiv;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJapaneseLevel() {
        return japaneseLevel;
    }

    public void setJapaneseLevel(String japaneseLevel) {
        this.japaneseLevel = japaneseLevel;
    }

    public String getAccessionDate() {
        return accessionDate;
    }

    public void setAccessionDate(String accessionDate) {
        this.accessionDate = accessionDate;
    }

    public String getDelSgn() {
        return delSgn;
    }

    public void setDelSgn(String delSgn) {
        this.delSgn = delSgn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(String graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getEmpDiv() {
        return empDiv;
    }

    public void setEmpDiv(String empDiv) {
        this.empDiv = empDiv;
    }

    public String getJpDate() {
        return jpDate;
    }

    public void setJpDate(String jpDate) {
        this.jpDate = jpDate;
    }

	@Override
    public User generateBean() {
	    // TODO Auto-generated method stub
	    return null;
    }
}
