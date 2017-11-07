package com.lxh.ddshop.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
public class IndexAction {

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    //选项卡跳转
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }
}
