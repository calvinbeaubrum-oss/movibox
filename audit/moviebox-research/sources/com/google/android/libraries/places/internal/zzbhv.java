package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhv implements Runnable {
    final /* synthetic */ zzbcf zza;
    final /* synthetic */ zzbhx zzb;

    public zzbhv(zzbhx zzbhxVar, zzbcf zzbcfVar) {
        this.zza = zzbcfVar;
        this.zzb = zzbhxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zze(this.zza);
    }
}
