package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbjn implements Runnable {
    final /* synthetic */ zzbjo zza;

    public zzbjn(zzbjo zzbjoVar) {
        this.zza = zzbjoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbkd zzbkdVar = this.zza.zzb;
        zzbml zzbmlVar = zzbkdVar.zzq;
        zzbkdVar.zzp = null;
        this.zza.zzb.zzq = null;
        zzbmlVar.zzd(zzbdo.zzp.zzg("InternalSubchannel closed transport due to address change"));
    }
}
