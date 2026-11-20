package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbmu implements zzgej {
    final /* synthetic */ zzcjk zza;

    public zzbmu(zzcjk zzcjkVar) {
        this.zza = zzcjkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcjk zzcjkVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzca(zzcjkVar.getContext(), zzcjkVar.zzn().zza, (String) obj).zzb();
    }
}
