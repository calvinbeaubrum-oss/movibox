package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzexc implements zzexp {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;

    @Nullable
    public final String zzc;

    @Nullable
    public final String zzd;

    @Nullable
    public final Long zze;

    public zzexc(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Long l11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = l11;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfhv.zzc(bundle, "gmp_app_id", this.zza);
        zzfhv.zzc(bundle, "fbs_aiid", this.zzb);
        zzfhv.zzc(bundle, "fbs_aeid", this.zzc);
        zzfhv.zzc(bundle, "apm_id_origin", this.zzd);
        Long l11 = this.zze;
        if (l11 != null) {
            bundle.putLong("sai_timeout", l11.longValue());
        }
    }
}
