package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbnn implements zzgej {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zza zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbnr zzd;

    public zzbnn(zzbnr zzbnrVar, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str) {
        this.zza = zzaVar;
        this.zzb = map;
        this.zzc = str;
        this.zzd = zzbnrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th2) {
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "OpenGmsgHandler.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zza;
        Map map = this.zzb;
        String str = this.zzc;
        this.zzd.zzh((String) obj, zzaVar, map, str);
    }
}
