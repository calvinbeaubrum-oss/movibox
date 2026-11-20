package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhr implements Runnable {
    final /* synthetic */ zzbdo zza;
    final /* synthetic */ zzbhy zzb;

    public zzbhr(zzbhy zzbhyVar, zzbdo zzbdoVar) {
        this.zza = zzbdoVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzh(this.zza);
    }
}
