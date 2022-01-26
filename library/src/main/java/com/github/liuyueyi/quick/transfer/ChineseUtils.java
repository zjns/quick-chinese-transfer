/**
 * File    : ChineseUtils.java
 * Created : 2014年1月16日
 * By      : luhuiguo
 */
package com.github.liuyueyi.quick.transfer;

import android.content.Context;

import com.github.liuyueyi.quick.transfer.dictionary.DictionaryContainer;

/**
 * 中文相关工具类。
 *
 * @author luhuiguo
 */
public class ChineseUtils {
    /**
     * 简体转繁体
     */
    public static String s2t(Context context, String content) {
        return DictionaryContainer.getInstance(context).getDictionary("s2t").convert(content);
    }

    /**
     * 简体转香港繁体
     */
    public static String s2hk(Context context, String content) {
        return DictionaryContainer.getInstance(context).getDictionary("s2hk").convert(content);
    }

    /**
     * 简体转台湾繁体
     */
    public static String s2tw(Context context, String content) {
        return DictionaryContainer.getInstance(context).getDictionary("s2tw").convert(content);
    }

    /**
     * 繁体转简体
     */
    public static String t2s(Context context, String content) {
        return DictionaryContainer.getInstance(context).getDictionary("t2s").convert(content);
    }

    /**
     * 香港繁体转简体
     */
    public static String hk2s(Context context, String content) {
        return DictionaryContainer.getInstance(context).getDictionary("hk2s").convert(content);
    }

    /**
     * 台湾繁体转简体
     */
    public static String tw2s(Context context, String content) {
        return DictionaryContainer.getInstance(context).getDictionary("tw2s").convert(content);
    }
}
