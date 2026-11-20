package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzauy implements zzfru {
    final /* synthetic */ zzfqr zza;

    public zzauy(zzfqr zzfqrVar) {
        this.zza = zzfqrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zza(int i11, long j11) {
        this.zza.zzd(i11, System.currentTimeMillis() - j11);
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zzb(int i11, long j11, String str) {
        this.zza.zze(i11, System.currentTimeMillis() - j11, str);
    }
}
