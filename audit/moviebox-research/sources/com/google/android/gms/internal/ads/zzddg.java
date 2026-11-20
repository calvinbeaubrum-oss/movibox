package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzddg extends zzdgl implements zzdbr, zzdcw {
    private final zzfgm zzb;
    private final AtomicBoolean zzc;

    public zzddg(Set set, zzfgm zzfgmVar) {
        super(set);
        this.zzc = new AtomicBoolean();
        this.zzb = zzfgmVar;
    }

    private final void zzb() {
        com.google.android.gms.ads.internal.client.zzs zzsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhH)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzsVar = this.zzb.zzaf) != null && zzsVar.zza == 3) {
            zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzddf
                @Override // com.google.android.gms.internal.ads.zzdgk
                public final void zza(Object obj) throws Exception {
                    this.zza.zza((zzddi) obj);
                }
            });
        }
    }

    public final /* synthetic */ void zza(zzddi zzddiVar) throws Exception {
        zzddiVar.zzh(this.zzb.zzaf);
    }

    @Override // com.google.android.gms.internal.ads.zzdcw
    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        int i11 = this.zzb.zzb;
        if (i11 == 2 || i11 == 5 || i11 == 4 || i11 == 6 || i11 == 7) {
            zzb();
        }
    }
}
