package com.collect.controller;


import com.collect.entity.Collect;
import com.collect.entity.User;
import com.collect.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangning123
 * @since 2018-04-25
 */
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    CollectService collectService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Collect query(@PathVariable Long id){
        return collectService.selectById(id);
    }
}

