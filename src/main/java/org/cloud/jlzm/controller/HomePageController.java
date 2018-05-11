package org.cloud.jlzm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.cloud.jlzm.base.BaseController;
import org.cloud.jlzm.domain.MenuItem;
import org.cloud.jlzm.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController extends BaseController {
	
	@Autowired
	private IMenuItemService menuItemService;
	
	@GetMapping("/home")
    public ModelAndView homePageHandler(HttpServletRequest request, HttpSession session) {
        ModelAndView result = new ModelAndView("home");
        int lv = this.getUserRoleLevel();
        List<MenuItem> list = menuItemService.getTreeData(lv);
        result.addObject("menuLists", list);
        return result;
    }
	
}
