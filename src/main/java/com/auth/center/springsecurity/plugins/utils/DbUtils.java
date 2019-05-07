package com.auth.center.springsecurity.plugins.utils;

import com.auth.center.springsecurity.plugins.bean.DbType;
import java.text.ParseException;
import javax.sql.DataSource;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;

/**
 * ClassName: <br>
 * Function: <br>
 * date: 2019-05-07 16:10<br>
 * @author liqiangqiang<br>
 * @version
 * @since JDK 1.8
 */
public class DbUtils {
    private VendorDatabaseIdProvider databaseIdProvider;
    private DataSource dataSource;

    public static DbType DB_TYPE;

    public DbUtils() {
    }

    public DbUtils(VendorDatabaseIdProvider databaseIdProvider, DataSource dataSource) {
        // 初始化
        this.databaseIdProvider = databaseIdProvider;
        this.dataSource = dataSource;
        String databaseId = databaseIdProvider.getDatabaseId(dataSource);
        DB_TYPE = DbType.valueOf(StringUtils.upperCase(databaseId));
    }

    /**
     * 获得当前时间
     *
     * @return
     */
    public static String getCurrentTime() throws ParseException {
        String result = "";
        if (DB_TYPE.equals(DbType.MYSQL)) {
            result = "now()";
        } else if (DB_TYPE.equals(DbType.ORACLE)) {
            result = "sysdate";
        } else {

        }
        return result;
    }
}