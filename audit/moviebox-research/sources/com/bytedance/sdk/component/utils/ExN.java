package com.bytedance.sdk.component.utils;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final char[] f27022sc = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String sc(File file) {
        FileInputStream fileInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i11 = fileInputStream.read(bArr, 0, 8192);
                    if (i11 <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i11);
                }
                String strSc = sc(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return strSc;
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception unused4) {
            }
        }
        return null;
    }

    public static String sc(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return sc(messageDigest.digest());
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String sc(byte[] bArr) {
        if (bArr != null) {
            return sc(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String sc(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i11 < 0 || i11 + i12 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i13 = i12 * 2;
        char[] cArr = new char[i13];
        int i14 = 0;
        for (int i15 = 0; i15 < i12; i15++) {
            byte b11 = bArr[i15 + i11];
            int i16 = i14 + 1;
            char[] cArr2 = f27022sc;
            cArr[i14] = cArr2[(b11 & 255) >> 4];
            i14 += 2;
            cArr[i16] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr, 0, i13);
    }
}
