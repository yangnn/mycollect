package com.collect.service.impl;

import com.collect.entity.User;
import com.collect.mapper.UserMapper;
import com.collect.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangning123
 * @since 2018-04-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
