package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzesk implements zzexq {
    private final zzgey zza;
    private final zzfhh zzb;
    private final zzcei zzc;
    private final zzcdp zzd;

    public zzesk(zzgey zzgeyVar, zzfhh zzfhhVar, zzcei zzceiVar, zzcdp zzcdpVar) {
        this.zza = zzgeyVar;
        this.zzb = zzfhhVar;
        this.zzc = zzceiVar;
        this.zzd = zzcdpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 9;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    public final /* synthetic */ zzesl zzc() throws Exception {
        return new zzesl(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
