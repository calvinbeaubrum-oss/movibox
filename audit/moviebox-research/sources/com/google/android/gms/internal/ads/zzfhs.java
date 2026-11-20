package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfhs implements zzgej {
    final /* synthetic */ zzfht zza;
    final /* synthetic */ int zzb;

    public zzfhs(zzfht zzfhtVar, int i11) {
        this.zzb = i11;
        this.zza = zzfhtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "BufferingUrlPinger.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i11 = this.zzb;
        this.zza.zzb((String) obj, i11);
    }
}
