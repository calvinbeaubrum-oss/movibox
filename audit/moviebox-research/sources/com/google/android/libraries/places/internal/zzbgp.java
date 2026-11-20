package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbgp implements Runnable {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbgz zzb;

    public zzbgp(zzbgz zzbgzVar, Object obj) {
        this.zza = obj;
        this.zzb = zzbgzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzh.zzd(this.zza);
    }
}
