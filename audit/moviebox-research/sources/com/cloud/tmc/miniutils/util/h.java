package com.cloud.tmc.miniutils.util;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static byte[] a(byte[] bArr) {
        return g(bArr, "MD5");
    }

    public static String b(String str) {
        return (str == null || str.length() == 0) ? "" : c(str.getBytes());
    }

    public static String c(byte[] bArr) {
        return h0.b(a(bArr));
    }

    public static byte[] d(byte[] bArr) {
        return g(bArr, EncoderUtil.ALGORITHM_SHA_256);
    }

    public static String e(String str) {
        return (str == null || str.length() == 0) ? "" : f(str.getBytes());
    }

    public static String f(byte[] bArr) {
        return h0.b(d(bArr));
    }

    public static byte[] g(byte[] bArr, String str) {
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
