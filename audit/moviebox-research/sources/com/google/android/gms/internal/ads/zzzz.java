package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzzz implements zzabo {
    private final Context zza;
    private final zzaab zzb;

    public zzzz(Context context, zzaab zzaabVar, zzcq zzcqVar) throws zzdl {
        this.zza = context;
        this.zzb = zzaabVar;
        int i11 = zzfy.zza;
        if (i11 >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && i11 == 30) {
            String str = zzfy.zzd;
            if (!zzfwk.zzc(str, "moto g(20)")) {
                zzfwk.zzc(str, "rmx3231");
            }
        }
        throw null;
    }
}
