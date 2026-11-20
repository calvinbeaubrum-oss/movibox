package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbpj implements Runnable {
    final /* synthetic */ zzbqq zza;
    final /* synthetic */ zzbpl zzb;

    public zzbpj(zzbpl zzbplVar, zzbqq zzbqqVar) {
        this.zza = zzbqqVar;
        this.zzb = zzbplVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzy.zzf(this.zza);
    }
}
