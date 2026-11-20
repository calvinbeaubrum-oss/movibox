package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfru;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzh implements zzfru {
    final /* synthetic */ zzi zza;

    public zzh(zzi zziVar) {
        this.zza = zziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zza(int i11, long j11) {
        this.zza.zzi.zzd(i11, System.currentTimeMillis() - j11);
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zzb(int i11, long j11, String str) {
        this.zza.zzi.zze(i11, System.currentTimeMillis() - j11, str);
    }
}
