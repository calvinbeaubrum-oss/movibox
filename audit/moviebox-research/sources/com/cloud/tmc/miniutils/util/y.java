package com.cloud.tmc.miniutils.util;

import android.content.res.Resources;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import java.util.IllegalFormatException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class y {
    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (charSequence.charAt(i11) != charSequence2.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public static String b(@Nullable String str, Object... objArr) {
        if (str == null || objArr == null || objArr.length <= 0) {
            return str;
        }
        try {
            return String.format(str, objArr);
        } catch (IllegalFormatException e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static String c(@StringRes int i11) {
        return d(i11, null);
    }

    public static String d(@StringRes int i11, Object... objArr) {
        try {
            return b(e0.a().getString(i11), objArr);
        } catch (Resources.NotFoundException e11) {
            e11.printStackTrace();
            return String.valueOf(i11);
        }
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }
}
