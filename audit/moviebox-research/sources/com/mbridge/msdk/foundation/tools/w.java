package com.mbridge.msdk.foundation.tools;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f45090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f45091b;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f45090a = charArray;
        int[] iArr = new int[256];
        f45091b = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i11 = 0; i11 < length; i11++) {
            f45091b[f45090a[i11]] = i11;
        }
        f45091b[61] = 0;
    }

    public static String a(String str) {
        int i11;
        int i12;
        byte[] bArr;
        int length = str.length();
        if (length == 0) {
            bArr = new byte[0];
        } else {
            int i13 = length - 1;
            int i14 = 0;
            while (i14 < i13 && f45091b[str.charAt(i14) & 255] < 0) {
                i14++;
            }
            while (i13 > 0 && f45091b[str.charAt(i13) & 255] < 0) {
                i13--;
            }
            if (str.charAt(i13) == '=') {
                i11 = str.charAt(i13 + (-1)) == '=' ? 2 : 1;
            } else {
                i11 = 0;
            }
            int i15 = (i13 - i14) + 1;
            if (length > 76) {
                i12 = (str.charAt(76) == '\r' ? i15 / 78 : 0) << 1;
            } else {
                i12 = 0;
            }
            int i16 = (((i15 - i12) * 6) >> 3) - i11;
            byte[] bArr2 = new byte[i16];
            int i17 = (i16 / 3) * 3;
            int i18 = 0;
            int i19 = 0;
            while (i18 < i17) {
                int[] iArr = f45091b;
                int i21 = i14 + 4;
                int i22 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
                bArr2[i18] = (byte) (i22 >> 16);
                int i23 = i18 + 2;
                bArr2[i18 + 1] = (byte) (i22 >> 8);
                i18 += 3;
                bArr2[i23] = (byte) i22;
                if (i12 <= 0 || (i19 = i19 + 1) != 19) {
                    i14 = i21;
                } else {
                    i14 += 6;
                    i19 = 0;
                }
            }
            if (i18 < i16) {
                int i24 = 0;
                int i25 = 0;
                while (i14 <= i13 - i11) {
                    i24 |= f45091b[str.charAt(i14)] << (18 - (i25 * 6));
                    i25++;
                    i14++;
                }
                int i26 = 16;
                while (i18 < i16) {
                    bArr2[i18] = (byte) (i24 >> i26);
                    i26 -= 8;
                    i18++;
                }
            }
            bArr = bArr2;
        }
        return bArr.length == 0 ? "" : new String(bArr, StandardCharsets.UTF_8);
    }
}
