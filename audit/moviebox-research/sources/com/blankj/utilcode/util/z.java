package com.blankj.utilcode.util;

import androidx.collection.v0;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0<String, String> f25340a = new v0<>();

    public static String[] a(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static boolean b(CharSequence charSequence) {
        return c("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", charSequence);
    }

    public static boolean c(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }
}
