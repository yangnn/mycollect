package com.collect.controller;

import com.collect.dto.UserInfoDTO;
import com.collect.entity.User;
import com.collect.service.UserService;
import com.collect.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nina_nyang on 2018/4/28.
 */
@RestController
@RequestMapping("/login1")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseVo login(UserInfoDTO dto){
        ResponseVo vo = new ResponseVo();
        User user = userService.getByUserName(dto.getUserName());
        if(user != null){
            vo.setCode(200);
            vo.setData(user);
        }
        return vo;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseVo add(@RequestBody UserInfoDTO dto){
        ResponseVo vo = new ResponseVo();
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassWord(dto.getPassword());
        boolean result = userService.insert(user);
        if(result){
            vo.setCode(200);
            vo.setData(user);
        }

        return vo;
    }


}
