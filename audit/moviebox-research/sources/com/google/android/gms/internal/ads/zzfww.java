package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfww {
    private final String zza;
    private final zzfwu zzb;
    private zzfwu zzc;

    public /* synthetic */ zzfww(String str, zzfwv zzfwvVar) {
        zzfwu zzfwuVar = new zzfwu();
        this.zzb = zzfwuVar;
        this.zzc = zzfwuVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.zza);
        sb2.append('{');
        zzfwu zzfwuVar = this.zzb.zzb;
        String str = "";
        while (zzfwuVar != null) {
            Object obj = zzfwuVar.zza;
            sb2.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb2.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzfwuVar = zzfwuVar.zzb;
            str = ", ";
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final zzfww zza(Object obj) {
        zzfwu zzfwuVar = new zzfwu();
        this.zzc.zzb = zzfwuVar;
        this.zzc = zzfwuVar;
        zzfwuVar.zza = obj;
        return this;
    }
}
