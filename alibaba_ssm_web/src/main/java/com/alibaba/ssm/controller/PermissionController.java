package com.alibaba.ssm.controller;

import com.alibaba.ssm.domain.Permission;
import com.alibaba.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/30 - 15:11
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
