package com.github.liuyueyi.quick.transfer.dictionary;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yihui
 * @date 20/11/23
 */
public class DictionaryContainer {
    @SuppressLint("StaticFieldLeak")
    private static DictionaryContainer instance;
    private final Context context;

    private final Map<String, BasicDictionary> dictionaryMap = new HashMap<>(8, 1);

    private DictionaryContainer(Context context) {
        this.context = context;
    }

    public static DictionaryContainer getInstance(Context context) {
        if (instance == null) {
            synchronized (DictionaryContainer.class) {
                if (instance == null) {
                    instance = new DictionaryContainer(context);
                }
            }
        }
        return instance;
    }

    public BasicDictionary getDictionary(String key) {
        BasicDictionary dictionary = dictionaryMap.get(key);
        if (dictionary != null) {
            return dictionary;
        }

        synchronized (this) {
            dictionary = dictionaryMap.get(key);
            if (dictionary != null) {
                return dictionary;
            }
            switch (key) {
                case "s2t":
                    dictionary = DictionaryFactory.loadDictionary(context, "tc/s2t.txt", false);
                    break;
                case "s2hk":
                    dictionary = DictionaryFactory.loadSecondDictionary(context, getDictionary("s2t"), "tc/t2hk.txt", false);
                    break;
                case "s2tw":
                    dictionary = DictionaryFactory.loadSecondDictionary(context, getDictionary("s2t"), "tc/t2tw.txt", false);
                    break;
                case "t2s":
                    dictionary = DictionaryFactory.loadDictionary(context, "tc/t2s.txt", false);
                    break;
                case "hk2s":
                    dictionary = DictionaryFactory.loadSecondDictionary(context, getDictionary("t2s"), "tc/t2hk.txt", true);
                    break;
                case "tw2s":
                    dictionary = DictionaryFactory.loadSecondDictionary(context, getDictionary("t2s"), "tc/t2tw.txt", true);
                    break;
                default:
                    throw new IllegalArgumentException("暂不支持转化方式" + key);
            }
        }
        dictionaryMap.put(key, dictionary);
        return dictionary;
    }
}
