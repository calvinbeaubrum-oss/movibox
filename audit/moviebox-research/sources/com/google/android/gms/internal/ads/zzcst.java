package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcst implements zzbng {
    final /* synthetic */ zzcsw zza;

    public zzcst(zzcsw zzcswVar) {
        this.zza = zzcswVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        if (zzcsw.zzg(this.zza, map)) {
            this.zza.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcss
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza.zzd.zzg();
                }
            });
        }
    }
}
