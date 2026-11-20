package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhk implements Runnable {
    final /* synthetic */ zzazq zza;
    final /* synthetic */ zzbhy zzb;

    public zzbhk(zzbhy zzbhyVar, zzazq zzazqVar) {
        this.zza = zzazqVar;
        this.zzb = zzbhyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc.zzl(this.zza);
    }
}
