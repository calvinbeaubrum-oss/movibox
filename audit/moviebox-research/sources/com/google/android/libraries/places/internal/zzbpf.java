package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbpf implements Runnable {
    final /* synthetic */ zzbpg zza;

    public zzbpf(zzbpg zzbpgVar) {
        this.zza = zzbpgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbpg zzbpgVar = this.zza;
        zzbpgVar.zzc.zzb.zzai(zzbpgVar.zzb);
    }
}
