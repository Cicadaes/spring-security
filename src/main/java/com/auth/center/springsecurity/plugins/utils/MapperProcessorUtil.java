package com.auth.center.springsecurity.plugins.utils;

import com.sun.istack.internal.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 给Mapper中的SQL添加支持MySQL
 *
 * @author lqq
 * @date 2018-04-10 13:36 星期二
 */
public class MapperProcessorUtil {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 装载目录下所有的mapper文件
     */
    private ArrayList<File> files = new ArrayList<>();

    /**
     * 检查databaseId是否完整匹配
     */
    public void checkDatabaseId() {
        /*Map<String, Object> resultMap = new HashMap<>();
        for (int i = 0; i < files.size(); i++) {
            MDC.put("num", String.valueOf(i + 1));
            log.info("解析文件：{}", files.get(i).getPath());
            String content = readToString(files.get(i));
            Matcher matcher = Pattern.compile("(?i)((<insert.+?>)|(<delete.+?>)|(<update.+?>)|(<select.+?>))", Pattern.DOTALL).matcher(content);
            int j = 1;
            while (matcher.find()) {
                String sqlTag = matcher.group();
                log.info("[{}] - {}", j++, sqlTag);
                String id = Pattern.compile("id=\"(\\w+)\"").matcher(sqlTag).group();
                log.info(id);
                Matcher matcher1 = Pattern.compile("databaseId=\"(\\w+)\"").matcher(sqlTag);
                if (matcher1.find()) {

                }
            }
        }*/
    }

    public void checkMySqlDML() {

    }

    /**
     * 处理可引用的SQL
     */
    public void sqlHandler() {

    }

    /**
     * 核心处理方法
     */
    public void process() {
        log.debug("开始扫描SQL");
        for (int i = 0; i < files.size(); i++) {
            log.info("解析文件：{}", files.get(i).getPath());
            String content = readToString(files.get(i));
            log.debug(content);
            Matcher matcher = Pattern.compile("((<insert.+?</insert>)|(<delete.+?</delete>)|(<update.+?</update>)|(<select.+?</select>))", Pattern.DOTALL).matcher(content);

            while (matcher.find()) {
                String sourceSql = matcher.group();

                if (isIncludeOracle(sourceSql)) {
                    log.debug("包含Oracle特有函数");
                    if (!Pattern.compile("databaseId").matcher(sourceSql).find()) {
                        log.debug("没有databaseId标识");
                        String result = sourceSql.replaceAll("^(<\\w+)", "$1 databaseId=\"oracle\"");
                        if (updateFileContent(files.get(i).getAbsolutePath(), content.replace(sourceSql, result + "\r\n\t" + replaceOracleWithMysql(result)))) {
                            log.info("处理成功！");
                        } else {
                            log.warn("处理失败:{}", files.get(i).getAbsolutePath());
                        }
                    } else if (Pattern.compile("databaseId=\"mysql\"").matcher(sourceSql).find()) {
                        if (updateFileContent(files.get(i).getAbsolutePath(), content.replace(sourceSql, replaceOracleWithMysql(sourceSql)))) {
                            log.info("更新成功！");
                        } else {
                            log.warn("更新失败:{}", files.get(i).getAbsolutePath());
                        }
                    }
                }
            }
        }
    }

    /**
     * 加载目录下所有*Mapper.xml文件
     *
     * @param file 文件目录
     */
    private void loadAllFile(@NotNull File file) {
        log.info(file.getPath());
        assert file.isDirectory();
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                loadAllFile(f);
            } else if (f.getName().endsWith("Mapper.xml")) {
                files.add(f);
            }
        }
    }

    /**
     * 读取文件内容
     *
     * @param file 目标文件
     * @return String 文件内容
     */
    private String readToString(@NotNull File file) {
        String encoding = "UTF-8";
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(fileContent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 替换Oracle函数为MySQL
     *
     * @param strSql
     * @returnstart with
     */
    public static  String replaceOracleWithMysql(String strSql) {
        return strSql.replaceAll("(?i)databaseId=\"oracle\"", "databaseId=\"mysql\"")
                .replaceAll("(?i)from dual", "")
                .replaceAll("(?i)to_char\\((.+?),\\s?'FM9999,999,999,990.00'\\)", "format($1,2)")
                .replaceAll("(?i)to_char\\((.+?),\\s?'FM9999999999990.00'\\)", "format($1,2)")
                .replaceAll("(?i)to_char", "date_format")
                .replaceAll("(?i)wmsys.wm_concat", "GROUP_CONCAT")
                .replaceAll("(?i)\\bto_date\\b", "str_to_date")
                .replaceAll("(?i)nvl", "ifnull")
                .replaceAll("(?i)instr", "fun_oracle_instr")
                .replaceAll("(?i)length", "char_length")
                .replaceAll("(?i)to_number\\((\\w+\\(.+?\\).*?)\\)", "cast($1 AS SIGNED INTEGER)")
                .replaceAll("(?i)to_number\\((.+?)\\)", "cast($1 AS SIGNED INTEGER)")
                .replaceAll("(?i)sysdate(?!\\(\\))", "sysdate()")
                .replaceAll("(?i)YYYY-MM-DD HH24:MI:SS", "%Y-%m-%d %H:%i:%s")
                .replaceAll("(?i)YYYY-MM-DD HH:MI:SS", "%Y-%m-%d %h:%i:%s")
                .replaceAll("(?i)yyyy-mm-dd", "%Y-%m-%d")
                .replaceAll("(?i)HH24:MI:SS", "%H:%i:%s")
                .replaceAll("(?i)YYYYMMDD", "%Y%m%d")
                .replaceAll("(?i)HH24MISS", "%H%i%s")
                .replaceAll("(?i)decode", "if");
    }

    /**
     * 是否包含Oracle特有函数
     *
     * @param strSql
     * @return
     */
    public static boolean isIncludeOracle(String strSql) {
        return Pattern.compile("(?i)\\b(to_char|to_date|decode|wmsys.wm_concat|sysdate|nvl|instr|from dual|length|to_number|nvl2|rownumber|over|rank|start with)\\b").matcher(strSql).find();
    }

    /**
     * 更新文件内容
     *
     * @param filePath   文件路径
     * @param newContent 文件内容
     * @return boolean 更新结果
     */
    public static  boolean updateFileContent(String filePath, String newContent) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(newContent);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
