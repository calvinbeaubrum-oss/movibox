package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcwx {
    private final zzfgy zza;
    private final zzfgm zzb;
    private final String zzc;

    public zzcwx(zzfgy zzfgyVar, zzfgm zzfgmVar, @Nullable String str) {
        this.zza = zzfgyVar;
        this.zzb = zzfgmVar;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzfgm zza() {
        return this.zzb;
    }

    public final zzfgp zzb() {
        return this.zza.zzb.zzb;
    }

    public final zzfgy zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzc;
    }
}
