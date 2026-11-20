package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbxo extends zzbxh {
    final /* synthetic */ List zza;

    public zzbxo(zzbxq zzbxqVar, List list) {
        this.zza = list;
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final void zze(String str) {
        zzcec.zzg("Error recording click: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzbxi
    public final void zzf(List list) {
        zzcec.zzi("Recorded click: ".concat(this.zza.toString()));
    }
}
