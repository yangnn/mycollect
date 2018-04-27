package com.collect.service.impl;

import com.collect.entity.Tag;
import com.collect.mapper.TagMapper;
import com.collect.service.TagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangning
 * @since 2018-04-27
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
