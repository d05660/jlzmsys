package org.cloud.jlzm.base;

import org.apache.shiro.SecurityUtils;
import org.cloud.jlzm.domain.ReturnMessage;
import org.cloud.jlzm.security.ShiroUser;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

    /**
     * 获取当前登录用户对象
     * @return {ShiroUser}
     */
    public ShiroUser getShiroUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前登录用户id
     * @return {Long}
     */
    public String getUserId() {
        return this.getShiroUser().getUserId();
    }

    /**
     * 获取当前登录用户名
     * @return {String}
     */
    public String getStaffName() {
        return this.getShiroUser().getLoginName();
    }

    /**
     * 获取当前登录用户名
     * @return {String}
     */
    public int getUserRoleLevel() {
        return this.getShiroUser().getLevel();
    }

    /**
     * ajax失败
     * @param msg 失败的消息
     * @return {Object}
     */
    public Object renderError(String msg) {
        ReturnMessage result = new ReturnMessage();
        result.setMessage(msg);
        return result;
    }

    /**
     * ajax成功
     * @return {Object}
     */
    public Object renderSuccess() {
        ReturnMessage result = new ReturnMessage();
        result.setSuccess(true);
        return result;
    }

    /**
     * ajax成功
     * @param msg 消息
     * @return {Object}
     */
    public Object renderSuccess(String msg) {
        ReturnMessage result = new ReturnMessage();
        result.setSuccess(true);
        result.setMessage(msg);
        return result;
    }
    
    @ModelAttribute("contextPath")
    public String getBasePath() {
        return "http://localhost:8080";
    }

}
