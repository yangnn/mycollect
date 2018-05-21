package com.collect.service;

import com.collect.entity.Collect;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangning123
 * @since 2018-04-25
 */
public interface CollectService extends IService<Collect> {


    List<Collect> getByUserId(Long userId);

    boolean deleteById(Long id);
}
