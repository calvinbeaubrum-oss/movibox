package com.bytedance.adsdk.sc.pFF.ExN;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    public static boolean We(char c11) {
        return '+' == c11 || '-' == c11 || '*' == c11 || '/' == c11 || '%' == c11 || '=' == c11 || '>' == c11 || '<' == c11 || '!' == c11 || '&' == c11 || '|' == c11 || '?' == c11 || ':' == c11;
    }

    public static boolean pFF(char c11) {
        if (c11 < 'A' || c11 > 'Z') {
            return c11 >= 'a' && c11 <= 'z';
        }
        return true;
    }

    public static boolean sc(char c11) {
        return c11 == ' ';
    }

    public static boolean zY(char c11) {
        return c11 >= '0' && c11 <= '9';
    }
}
