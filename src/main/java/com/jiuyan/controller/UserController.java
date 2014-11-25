package com.jiuyan.controller;

import com.jiuyan.model.User;
import com.jiuyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xiaoshua on 2014/11/19.
 */
@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    @ResponseBody
    public String test1(Model model) {
        List<User> userList = userService.getAll();

        model.addAttribute("userList", userList);
        return "userManage";
    }

    @RequestMapping(value = "/hello/*", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("HERE");
        model.addAttribute("user", "Alice");
        String requestUri = new UrlPathHelper().getLookupPathForRequest(request);
        model.addAttribute("appUrl", requestUri);
        model.addAttribute("appName", "问答");
        model.addAttribute("appHtml", "<div><h1><@person.component/></h1></div>" + requestUri);
        return "hello";
    }

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Object object = request.get
//        System.out.println(ToStringBuilder.reflectionToString(request) + "!!!!!");
//        System.out.println(ToStringBuilder.reflectionToString(request.getParts()));
//        System.out.println(ToStringBuilder.reflectionToString(model) + "aaaaaaaaaa");
        Long id = Long.parseLong(request.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("/getAll");
    }
}
