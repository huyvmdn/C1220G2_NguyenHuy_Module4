package com.baitap.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"","/","/testAjax"})
    public String getIndex() {
        return "/testAjax";
    }
}
