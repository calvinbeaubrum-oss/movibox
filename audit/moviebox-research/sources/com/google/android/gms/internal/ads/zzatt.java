package com.google.android.gms.internal.ads;

import android.util.Base64;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzatt {
    public static String zza(byte[] bArr, boolean z11) {
        return Base64.encodeToString(bArr, true != z11 ? 2 : 11);
    }

    public static byte[] zzb(String str, boolean z11) throws IllegalArgumentException {
        byte[] bArrDecode = Base64.decode(str, 2);
        if (bArrDecode.length != 0 || str.length() <= 0) {
            return bArrDecode;
        }
        throw new IllegalArgumentException("Unable to decode ".concat(str));
    }
}
