package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbid implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbie zzb;

    public zzbid(zzbie zzbieVar, boolean z11) {
        this.zza = z11;
        this.zzb = zzbieVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza) {
            zzbih zzbihVar = this.zzb.zza;
            zzbihVar.zzf = true;
            if (zzbihVar.zzt > 0) {
                zzna zznaVar = zzbihVar.zzv;
                zznaVar.zzc();
                zznaVar.zzd();
            }
        }
        this.zzb.zza.zzA = false;
    }
}
