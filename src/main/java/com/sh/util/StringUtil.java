package com.sh.util;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    /**
     * 生成指定位数的随机数
     *
     * @param digit 位数
     * @return
     */
    public static String getRandomString(int digit) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < digit; i++) {
            result += random.nextInt(10);
        }
        return result;
    }


    /**
     * 判断是否为合法的电子邮箱地址
     *
     * @param str
     */
    public static boolean isEmail(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }

        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(str);
        return m.matches();

    }


    /**
     * 判断是否为合法的手机号码
     *
     * @param str
     */
    public static boolean isMobileNo(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        if (str.length() != 11) {
            return false;
        }

        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        return m.matches();
    }

    /**
     * 功能：判断字符串是否为日期格式
     *
     * @param str
     * @return
     */
    public static boolean isDate(String str) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(str);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
