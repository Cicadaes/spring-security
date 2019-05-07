package com.auth.center.springsecurity.config;

import com.auth.center.springsecurity.plugins.ConvertSqlInterceptor;
import com.auth.center.springsecurity.plugins.utils.DbUtils;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import java.util.Properties;
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
    public ConvertSqlInterceptor addDateInterceptor() {
        ConvertSqlInterceptor myPlugin = new ConvertSqlInterceptor();
        //设置参数，比如阈值等，可以在配置文件中配置，这里直接写死便于测试
        Properties properties = new Properties();
        properties.setProperty("createDateColumnName", "LASTPASSWORDRESETDATE");
        properties.setProperty("updateDateColumnName", "LASTPASSWORDRESETDATE");
        properties.setProperty("ignoreTables", "SYS_ROLE");
        myPlugin.setProperties(properties);
        return myPlugin;
    }
    @Bean
    public DbUtils dbUtils() {
        DbUtils dbUtils = new DbUtils();
        //设置参数，比如阈值等，可以在配置文件中配置，这里直接写死便于测试
        Properties properties = new Properties();
        properties.setProperty("createDateColumnName", "LASTPASSWORDRESETDATE");
        properties.setProperty("updateDateColumnName", "LASTPASSWORDRESETDATE");
        properties.setProperty("ignoreTables", "SYS_ROLE");
        return dbUtils;
    }
}
