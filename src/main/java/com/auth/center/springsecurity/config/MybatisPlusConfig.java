package com.auth.center.springsecurity.config;

import com.baiwang.mybatisx.sqlconverter.plugins.ConvertSqlInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 */
@Configuration
@MapperScan(basePackages = {"com.auth.center.springsecurity"})
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public ConvertSqlInterceptor convertSqlInterceptor() {
        //tenantEnable true 开启多租户过滤，false 关闭多租户过滤；值可以放到配置中心去获取
        return new ConvertSqlInterceptor(false);
    }

}
