package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzapy implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaqa zzc;

    public zzapy(zzaqa zzaqaVar, String str, long j11) {
        this.zza = str;
        this.zzb = j11;
        this.zzc = zzaqaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzaqa zzaqaVar = this.zzc;
        zzaqaVar.zza.zzb(zzaqaVar.toString());
    }
}
