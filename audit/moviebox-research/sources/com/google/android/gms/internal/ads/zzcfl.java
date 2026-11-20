package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcfl implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcfp zzc;

    public zzcfl(zzcfp zzcfpVar, int i11, int i12) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp zzcfpVar = this.zzc;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzj(this.zza, this.zzb);
        }
    }
}
