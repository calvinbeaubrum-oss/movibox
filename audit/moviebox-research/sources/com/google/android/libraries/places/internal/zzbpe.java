package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbpe implements Runnable {
    final /* synthetic */ zzbcf zza;
    final /* synthetic */ zzbpl zzb;

    public zzbpe(zzbpl zzbplVar, zzbcf zzbcfVar) {
        this.zza = zzbcfVar;
        this.zzb = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzy.zze(this.zza);
    }
}
