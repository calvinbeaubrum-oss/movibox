package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetw implements zzexq {
    private final zzgey zza;
    private final zzduf zzb;
    private final String zzc;
    private final zzfhh zzd;

    public zzetw(zzgey zzgeyVar, zzduf zzdufVar, zzfhh zzfhhVar, String str) {
        this.zza = zzgeyVar;
        this.zzb = zzdufVar;
        this.zzd = zzfhhVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 17;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetv
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzetx zzc() throws Exception {
        zzfhh zzfhhVar = this.zzd;
        zzduf zzdufVar = this.zzb;
        return new zzetx(zzdufVar.zzb(zzfhhVar.zzf, this.zzc), zzdufVar.zza());
    }
}
