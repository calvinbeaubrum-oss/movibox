package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgpm {
    public static final Charset zza = Charset.forName("UTF-8");

    public static final zzgxq zza(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new zzgpl("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i11] = (byte) cCharAt;
        }
        return zzgxq.zzb(bArr);
    }

    public static boolean zzb(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr2[i11] != bArr[i11]) {
                return false;
            }
        }
        return true;
    }
}
