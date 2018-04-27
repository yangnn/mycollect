package com.collect.controller;


import com.collect.dto.TagDto;
import com.collect.entity.Tag;
import com.collect.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangning
 * @since 2018-04-27
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tag get(@PathVariable Long id){
        return tagService.selectById(id);
    }

    @RequestMapping(value = "/build",method = RequestMethod.POST)
    public void add(TagDto dto){
        Tag tag = new Tag();
        BeanUtils.copyProperties(dto, tag);
        tagService.insert(tag);
    }

}

