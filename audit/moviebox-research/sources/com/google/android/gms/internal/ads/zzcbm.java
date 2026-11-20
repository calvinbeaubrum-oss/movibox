package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcbm implements zzgej {
    final /* synthetic */ s zza;

    public zzcbm(zzcbn zzcbnVar, s sVar) {
        this.zza = sVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        zzcbn.zzc.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcbn.zzc.remove(this.zza);
    }
}
