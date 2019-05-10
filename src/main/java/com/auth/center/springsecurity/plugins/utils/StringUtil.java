package com.auth.center.springsecurity.plugins.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import sun.misc.BASE64Decoder;

/**
 * @author lqq
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * 将下划线格式转换成驼峰式
     *
     * @param underline 下划线字符串，形如“gmt_create”
     * @return 返回驼峰式属性，"gmtCreate"
     */
    public static String camelCase(String underline) {
        StringBuilder camelCaseProperty = new StringBuilder();
        String[] underlineProperty = underline.split("_");
        for (int i = 0; i < underlineProperty.length; i++) {
            if (i > 0) {
                Character initial = underlineProperty[i].charAt(0);
                String upperInitial = initial.toString().toUpperCase();
                String initialProperty = underlineProperty[i]
                    .replaceFirst(initial.toString(), upperInitial);
                camelCaseProperty.append(initialProperty);
            } else {
                camelCaseProperty.append(underlineProperty[i]);
            }
        }

        return camelCaseProperty.toString();
    }

    /**
     * 不区分大小写替换
     * @param input
     * @param regex
     * @param replacement
     * @return
     */
    public static String replaceAll(String input, String regex, String replacement) {
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        String result = m.replaceAll(replacement);
        return result;
    }
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public static String  stringFilter(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return str;
    }

    public static boolean isEmpty(List str) {
        if (str == null || str.size() == 0) {
            return true;
        }
        return false;
    }

    public static String isNull(String str) {
        if (str == null || str.length() == 0 || "null".equals(str)) {
            return "";
        }
        return str;
    }

    public static String isNullInit(String str, String value) {
        if (str == null || str.length() == 0 || "null".equals(str)) {
            return value;
        }
        return str;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字串的真实长度(含中文)
     */
    public static int String_length(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255) {
                length++;
            } else {
                length += 2;
            }
        }
        return length;
    }

    /**
     * 获取指定字符串之间的字串
     */
    public static String getIntervalValue(String source, String priStr, int fromIndex,
        String suxStr) {
        if (source == null) {
            return "";
        }
        int iFirst = source.indexOf(priStr, fromIndex);
        int iLast = source.indexOf(suxStr, fromIndex);
        if (iFirst < 0 || iLast < 0) {
            return "";
        }
        int beginIndex = iFirst + priStr.length();
        return source.substring(beginIndex, iLast);
    }

    public static String getIntervalValue(String source, String priStr, String suxStr) {
        return getIntervalValue(source, priStr, 0, suxStr);
    }


    /**
     * base64转inputStream
     */
    public static InputStream baseToInputStream(String base64string) {
        ByteArrayInputStream stream = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes1 = decoder.decodeBuffer(base64string);
            stream = new ByteArrayInputStream(bytes1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static final byte[] input2byte(InputStream inStream)
        throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    /**
     * 过滤特殊字符 过滤规则 [∏,¥,§,℅,€,℃,£,℉,№,℡,‰,$,¢,∮,※,？,&,[,],',<,>,?]
     */

    public static String StringFilter(String str) throws PatternSyntaxException {
        if (!StringUtil.isEmpty(str)) {

            // 清除掉所有特殊字符
            String regEx = "[∏,¥,§,℅,€,℃,£,℉,№,℡,‰,$,¢,∮,※,？,&,[,],',<,>,?]";

            //String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        }
        return "";
    }

    //检查字符串中汉子的个数
    public static int countChinese(String str) {
        int count = 0;
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                count = count + 1;
            }
        }
        return count;
    }

    /**
     * 判断BigDecimal 数值是否有小数
     * @param b
     * @return true 无小数 ,false有小数
     */
    public static boolean hasPoint(BigDecimal b) {
        return new BigDecimal(b.intValue()).compareTo(b)==0;
    }

    private static Pattern numberPattern = Pattern.compile("[0-9]*");
    /**
     * 判断str数值是否有小数
     * @param str
     * @return true 无小数 ,false有小数
     */
    public static boolean isNumeric(String str){
        Matcher isNum = numberPattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        String ss="2019090920180809";
        System.out.println(ss.substring(0,8));
        System.out.println(ss.substring(8,ss.length()));

        System.out.println(StringUtil.String_length("M123456789"));

        System.out.println(new BigDecimal("0.0000001").setScale(9).toPlainString());

        BigDecimal a = new BigDecimal("1.0");

        BigDecimal b = new BigDecimal("1.1");

        BigDecimal c = new BigDecimal("99999999999");

        System.out.println(isNumeric(a.toPlainString()));
        System.out.println(isNumeric(b.toPlainString()));
        System.out.println(isNumeric(c.toPlainString()));

    }
}
