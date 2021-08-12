package com.sh.util;

import com.sh.config.BizException;

import java.util.Collection;
import java.util.List;

public class Validate {

    /**
     * 若object在数据库中不存在，则抛出[某某不存在或者已经被删除。]异常。
     *
     * @param object
     * @param titleName
     */
    public static void notLost(Object object, String titleName) {
        if (object == null) {
            throw new BizException(titleName + "不存在或者已经被删除。");
        }
    }

    /**
     * 若object为null，则抛出[某某不能为空。]异常。
     *
     * @param object
     * @param titleName
     */
    public static void notNull(Object object, String titleName) {
        if (object == null) {
            throw new IllegalArgumentException(titleName + "不能为空。");
        }
    }

    /**
     * 若str为null或空，则抛出[某某不能为空。]异常。
     *
     * @param str
     * @param titleName
     */
    public static void notBlank(String str, String titleName) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException(titleName + "不能为空。");
        }
    }

    /**
     * 若str为null或空，则抛出[某某不能为空。]异常。
     *
     * @param collection
     * @param titleName
     */
    public static void notEmpty(Collection collection, String titleName) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException(titleName + "不能为空。");
        }
    }

    /**
     * 若list中存在重复元素，则抛出[某某不能重复。]异常。
     *
     * @param list
     * @param titleName
     */
    public static void notRepeat(List<String> list, String titleName) {
        long count = list.stream().distinct().count();
        boolean isRepeat = count < list.size();
        if (isRepeat) {
            throw new IllegalArgumentException(titleName + "不能重复。");
        }
    }

    /**
     * 若str不是合法的email格式，则抛出[不是正确的Email格式。]异常。
     *
     * @param str
     * @param titleName
     */
    public static void notEmail(String str, String titleName) {
        if (!StringUtil.isEmail(str)) {
            throw new IllegalArgumentException(titleName + "不是正确的Email格式。");
        }
    }


    /**
     * 若str不是合法的手机号格式，则抛出[不是正确的手机号码格式。]异常。
     *
     * @param str
     * @param titleName
     */
    public static void notMobileNo(String str, String titleName) {
        if (!StringUtil.isMobileNo(str)) {
            throw new IllegalArgumentException(titleName + "不是正确的手机号码格式。");
        }
    }


}
