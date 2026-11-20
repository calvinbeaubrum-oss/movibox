package com.vungle.warren.utility;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class k {
    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String b(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256).digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder(bArrDigest.length);
            for (byte b11 : bArrDigest) {
                String hexString = Integer.toHexString(b11 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
