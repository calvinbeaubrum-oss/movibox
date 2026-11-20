package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfzh extends zzfyu {
    final /* synthetic */ zzfzj zza;
    private final Object zzb;
    private int zzc;

    public zzfzh(zzfzj zzfzjVar, int i11) {
        this.zza = zzfzjVar;
        this.zzb = zzfzj.zzg(zzfzjVar, i11);
        this.zzc = i11;
    }

    private final void zza() {
        int i11 = this.zzc;
        if (i11 == -1 || i11 >= this.zza.size() || !zzfwy.zza(this.zzb, zzfzj.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfyu, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfyu, java.util.Map.Entry
    public final Object getValue() {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.get(this.zzb);
        }
        zza();
        int i11 = this.zzc;
        if (i11 == -1) {
            return null;
        }
        return zzfzj.zzj(this.zza, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzfyu, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.put(this.zzb, obj);
        }
        zza();
        int i11 = this.zzc;
        if (i11 == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzfzj zzfzjVar = this.zza;
        Object objZzj = zzfzj.zzj(zzfzjVar, i11);
        zzfzj.zzn(zzfzjVar, this.zzc, obj);
        return objZzj;
    }
}
