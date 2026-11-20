package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbgp extends zzbgq {
    @Nullable
    private static final String zzb(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i12 < str.length() && str.charAt(i12) == ',') {
            i12++;
        }
        while (length > 0) {
            int i13 = length - 1;
            if (str.charAt(i13) != ',') {
                break;
            }
            length = i13;
        }
        if (length < i12) {
            return null;
        }
        if (i12 != 0) {
            i11 = i12;
        } else if (length == str.length()) {
            return str;
        }
        return str.substring(i11, length);
    }

    @Override // com.google.android.gms.internal.ads.zzbgq
    public final String zza(@Nullable String str, String str2) {
        String strZzb = zzb(str);
        String strZzb2 = zzb(str2);
        if (TextUtils.isEmpty(strZzb)) {
            return strZzb2;
        }
        if (TextUtils.isEmpty(strZzb2)) {
            return strZzb;
        }
        return strZzb + "," + strZzb2;
    }
}
