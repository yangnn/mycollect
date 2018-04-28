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
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{loginName}",method = RequestMethod.POST)
    public ResponseVo login(@RequestBody UserInfoDTO dto){
        ResponseVo vo = new ResponseVo();
        User user = userService.getByName(dto.getLoginName());
        if(user != null){
            vo.setCode(200);
            vo.setData(user);
        }
        return vo;
    }

}
