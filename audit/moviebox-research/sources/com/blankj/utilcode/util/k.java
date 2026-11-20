package com.blankj.utilcode.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static byte[] a(byte[] bArr) {
        return d(bArr, "MD5");
    }

    public static String b(String str) {
        return (str == null || str.length() == 0) ? "" : c(str.getBytes());
    }

    public static String c(byte[] bArr) {
        return j0.b(a(bArr));
    }

    public static byte[] d(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }
}
