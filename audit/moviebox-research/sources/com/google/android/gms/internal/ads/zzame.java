package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzame {
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final Set zzd;

    private zzame(String str, int i11, String str2, Set set) {
        this.zzb = i11;
        this.zza = str;
        this.zzc = str2;
        this.zzd = set;
    }

    public static zzame zza(String str, int i11) {
        String str2;
        String strTrim = str.trim();
        zzek.zzd(!strTrim.isEmpty());
        int iIndexOf = strTrim.indexOf(" ");
        if (iIndexOf == -1) {
            str2 = "";
        } else {
            String strTrim2 = strTrim.substring(iIndexOf).trim();
            strTrim = strTrim.substring(0, iIndexOf);
            str2 = strTrim2;
        }
        int i12 = zzfy.zza;
        String[] strArrSplit = strTrim.split("\\.", -1);
        String str3 = strArrSplit[0];
        HashSet hashSet = new HashSet();
        for (int i13 = 1; i13 < strArrSplit.length; i13++) {
            hashSet.add(strArrSplit[i13]);
        }
        return new zzame(str3, i11, str2, hashSet);
    }

    public static zzame zzb() {
        return new zzame("", 0, "", Collections.emptySet());
    }
}
