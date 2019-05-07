package com.auth.center.springsecurity.plugins.utils;

import com.auth.center.springsecurity.plugins.bean.DbType;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

/**
 * ClassName: <br>
 * Function: <br>
 * date: 2019-05-07 17:08<br>
 * @author liqiangqiang<br>
 * @version
 * @since JDK 1.8
 */
public class JdbcUtils {
    private static final Log logger = LogFactory
        .getLog(com.baomidou.mybatisplus.extension.toolkit.JdbcUtils.class);

    /**
     * 根据连接地址判断数据库类型
     *
     * @param jdbcUrl 连接地址
     * @return ignore
     */
    public static DbType getDbType(String jdbcUrl) {
        Assert.isFalse(StringUtils.isEmpty(jdbcUrl), "Error: The jdbcUrl is Null, Cannot read database type");
        if (jdbcUrl.startsWith("jdbc:mysql:") || jdbcUrl.startsWith("jdbc:cobar:")
            || jdbcUrl.startsWith("jdbc:log4jdbc:mysql:")) {
            return DbType.MYSQL;
        } else if (jdbcUrl.startsWith("jdbc:mariadb:")) {
            return DbType.MARIADB;
        } else if (jdbcUrl.startsWith("jdbc:oracle:") || jdbcUrl.startsWith("jdbc:log4jdbc:oracle:")) {
            return DbType.ORACLE;
        } else if (jdbcUrl.startsWith("jdbc:sqlserver:") || jdbcUrl.startsWith("jdbc:microsoft:")) {
            return DbType.SQL_SERVER2005;
        } else if (jdbcUrl.startsWith("jdbc:sqlserver2012:")) {
            return DbType.SQL_SERVER;
        } else if (jdbcUrl.startsWith("jdbc:postgresql:") || jdbcUrl.startsWith("jdbc:log4jdbc:postgresql:")) {
            return DbType.POSTGRE_SQL;
        } else if (jdbcUrl.startsWith("jdbc:hsqldb:") || jdbcUrl.startsWith("jdbc:log4jdbc:hsqldb:")) {
            return DbType.HSQL;
        } else if (jdbcUrl.startsWith("jdbc:db2:")) {
            return DbType.DB2;
        } else if (jdbcUrl.startsWith("jdbc:sqlite:")) {
            return DbType.SQLITE;
        } else if (jdbcUrl.startsWith("jdbc:h2:") || jdbcUrl.startsWith("jdbc:log4jdbc:h2:")) {
            return DbType.H2;
        } else if (jdbcUrl.startsWith("jdbc:dm:") || jdbcUrl.startsWith("jdbc:log4jdbc:dm:")) {
            return DbType.DM;
        } else {
            logger.warn("The jdbcUrl is " + jdbcUrl + ", Mybatis Plus Cannot Read Database type or The Database's Not Supported!");
            return DbType.OTHER;
        }
    }
}
