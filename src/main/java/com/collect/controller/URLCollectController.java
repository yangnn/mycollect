package com.collect.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Created by nina_nyang on 2018/4/13.
 */
@RestController
public class URLCollectController {

    @RequestMapping("/mycollect")
    public String hello(Locale locale, Model model) {
        return "hello world";
    }
}
