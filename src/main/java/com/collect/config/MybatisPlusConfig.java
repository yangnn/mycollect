package com.collect.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by nina_nyang on 2018/4/20.
 */
@Configuration
@MapperScan("com.collect.*.mapper*")
public class MybatisPlusConfig {

    /*
    * 分页插件，自动识别数据库类型
    * 多租户，请参考官网【插件扩展】
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");

        return paginationInterceptor;
    }
}
