package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbgu implements Runnable {
    final /* synthetic */ zzbcf zza;
    final /* synthetic */ zzbgy zzb;

    public zzbgu(zzbgy zzbgyVar, zzbcf zzbcfVar) {
        this.zza = zzbcfVar;
        this.zzb = zzbgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzb(this.zza);
    }
}
