package org.cloud.jlzm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.cloud.jlzm.base.BaseController;
import org.cloud.jlzm.domain.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController extends BaseController {

	private static final Logger logger = LogManager.getLogger(LoginController.class);

	public static final String USER_SESSION = "USER_SESSION";

	/**
	 * 首页
	 *
	 * @return
	 */
	@GetMapping("/")
	public String index() {
		return "redirect:/login";
	}

	/**
	 * GET 登录
	 * 
	 * @return {String}
	 */
	@GetMapping("/login")
	public String login() {
		logger.info("GET请求登录");
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:/home";
		}
		return "login";
	}

	// 用户登录
	@PostMapping("/login")
	@ResponseBody
	public ReturnMessage login(@RequestParam(value = "userid") String userId, String password,
	        @RequestParam(value = "rememberMe", defaultValue = "0") Integer rememberMe, HttpSession session)
	        throws IOException {
		logger.info("POST请求登录");
		ReturnMessage result = new ReturnMessage();
		result.setSuccess(false);
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
		// 设置记住密码
		token.setRememberMe(1 == rememberMe);
		try {
			user.login(token);
			result.setMessage("登录成功");
			result.setSuccess(true);
		} catch (UnknownAccountException e) {
			result.setMessage("账号不存在");
			logger.warn("账号不存在");
		} catch (DisabledAccountException e) {
			result.setMessage("账号未启用！");
			logger.warn("账号未启用！");
		} catch (IncorrectCredentialsException e) {
			result.setMessage("密码错误！");
			logger.warn("密码错误！");
		} catch (Throwable e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	// 登出
	@PostMapping("/logout")
	@ResponseBody
	public ReturnMessage logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	        throws IOException {
		logger.info("登出");
		ReturnMessage result = new ReturnMessage();
		Subject subject = SecurityUtils.getSubject();
        subject.logout();
		result.setSuccess(true);
        return result;
	}
}
