package com.collect.controller;


import com.collect.dto.CollectDto;
import com.collect.entity.Collect;
import com.collect.entity.User;
import com.collect.service.CollectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangning123
 * @since 2018-04-25
 */
//@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Collect query(@PathVariable Long id){
        Collect collect = collectService.selectById(id);
        return collect;
    }

    @RequestMapping(value = "/build",method = RequestMethod.POST)
    public void add(CollectDto dto){
        Collect collect = new Collect();
        BeanUtils.copyProperties(dto, collect);
        collectService.insert(collect);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delte(@PathVariable Long id){
        collectService.deleteById(id);
    }

    @RequestMapping(value = "/getCollects", method = RequestMethod.GET)
    public List<Collect> getByUserId(Long userId){
        return collectService.getByUserId(userId);
    }


}

