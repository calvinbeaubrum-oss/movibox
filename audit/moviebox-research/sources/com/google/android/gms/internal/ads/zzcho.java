package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcho extends com.google.android.gms.ads.internal.util.zzb {
    final zzcgl zza;
    final zzchw zzb;
    private final String zzc;
    private final String[] zzd;

    public zzcho(zzcgl zzcglVar, zzchw zzchwVar, String str, String[] strArr) {
        this.zza = zzcglVar;
        this.zzb = zzchwVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzt.zzy().zzb(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzchn(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final s zzb() {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbW)).booleanValue() && (this.zzb instanceof zzcif)) ? zzcep.zze.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzchm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzd();
            }
        }) : super.zzb();
    }

    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
