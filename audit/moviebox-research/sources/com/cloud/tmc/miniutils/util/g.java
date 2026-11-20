package com.cloud.tmc.miniutils.util;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static byte[] a(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[0] : Base64.decode(bArr, 2);
    }

    public static byte[] b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[0] : Base64.encode(bArr, 2);
    }

    public static String c(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : Base64.encodeToString(bArr, 2);
    }

    public static String d(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] strArrSplit = str.split(" ");
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb2.append((char) Integer.parseInt(str2, 2));
        }
        return sb2.toString();
    }

    public static String e(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c11 : str.toCharArray()) {
            sb2.append(Integer.toBinaryString(c11));
            sb2.append(" ");
        }
        return sb2.deleteCharAt(sb2.length() - 1).toString();
    }

    public static String f(String str) {
        return g(str, "UTF-8");
    }

    public static String g(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), str2);
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }

    public static String h(String str) {
        return i(str, "UTF-8");
    }

    public static String i(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e11) {
            throw new AssertionError(e11);
        }
    }
}
