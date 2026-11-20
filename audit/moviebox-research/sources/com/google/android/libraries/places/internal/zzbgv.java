package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbgv implements Runnable {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbgy zzb;

    public zzbgv(zzbgy zzbgyVar, Object obj) {
        this.zza = obj;
        this.zzb = zzbgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzc(this.zza);
    }
}
