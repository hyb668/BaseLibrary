package com.gosuncn.core.util;

import android.support.annotation.Nullable;

/**
 * 其他工具类
 * @author HWJ
 *
 */
public class CheckNullUtils {

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    public static String keepStringNotNull(String s) {
        return s == null ? "" : s;
    }

}
