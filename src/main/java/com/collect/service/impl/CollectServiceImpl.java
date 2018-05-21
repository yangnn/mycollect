package com.collect.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.collect.entity.Collect;
import com.collect.mapper.CollectMapper;
import com.collect.service.CollectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangning123
 * @since 2018-04-25
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Override
    public List<Collect> getByUserId(Long userId) {
        Wrapper<Collect> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id", userId).eq("is_delete", 0).orderBy("create_time");

        return collectMapper.selectList(wrapper);
    }

    @Override
    public boolean deleteById(Long id) {
        Collect collect = new Collect();
        collect.setId(id);
        collect.setIsDelete("1");
        collectMapper.updateById(collect);
        return true;
    }
}
