package com.collect.controller;


import com.collect.dto.UserAddDto;
import com.collect.entity.User;
import com.collect.service.UserService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/build",method = RequestMethod.POST)
    public String add(UserAddDto dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        userService.insert(user);

        return null;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User query(@PathVariable Long id){
        User user = userService.selectById(id);
        return user;
    }

}

