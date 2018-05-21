package com.collect.controller;


import com.collect.dto.CollectDto;
import com.collect.entity.Collect;
import com.collect.entity.User;
import com.collect.service.CollectService;
import com.collect.vo.ResponseVo;
import com.collect.vo.ResultBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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
    private CollectService collectService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public Collect query(@PathVariable Long id){
        Collect collect = collectService.selectById(id);
        return collect;
    }

    @RequestMapping(value = "/build",method = RequestMethod.POST)
    public ResponseVo add(@RequestBody CollectDto dto){
        Collect collect = new Collect();
        BeanUtils.copyProperties(dto, collect);
        collect.setUserId(1L);
        collect.setCreateTime(new Date());
        collect.setModifyTime(new Date());
        collect.setIsDelete("0");
        collectService.insert(collect);

        return ResultBuilder.success();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public ResponseVo delte(@PathVariable Long id){
        collectService.deleteById(id);
        return ResultBuilder.success();
    }
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id){
        collectService.deleteById(id);
    }

    @RequestMapping(value = "/getByUserId/{userId}", method = RequestMethod.GET)
    public ResponseVo getByUserId(@PathVariable Long userId){
        List<Collect> collects = collectService.getByUserId(userId);

        ResponseVo vo = new ResponseVo();
        vo.setData(collects);
        vo.setCode(200);
        vo.setSuccess(true);
        return vo;
    }


}

