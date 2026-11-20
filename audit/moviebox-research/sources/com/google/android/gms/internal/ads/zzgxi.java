package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgxi {
    public static String zza(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb2 = new StringBuilder(length + length);
        for (byte b11 : bArr) {
            sb2.append("0123456789abcdef".charAt((b11 & 255) >> 4));
            sb2.append("0123456789abcdef".charAt(b11 & Ascii.SI));
        }
        return sb2.toString();
    }

    public static byte[] zzb(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 + i11;
            int iDigit = Character.digit(str.charAt(i12), 16);
            int iDigit2 = Character.digit(str.charAt(i12 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i11] = (byte) ((iDigit * 16) + iDigit2);
        }
        return bArr;
    }
}
