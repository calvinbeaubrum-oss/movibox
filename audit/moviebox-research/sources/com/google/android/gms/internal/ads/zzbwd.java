package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbwd extends zzbkp {
    final /* synthetic */ zzbwg zza;

    public /* synthetic */ zzbwd(zzbwg zzbwgVar, zzbwc zzbwcVar) {
        this.zza = zzbwgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkq
    public final void zze(zzbkg zzbkgVar, String str) {
        zzbwg zzbwgVar = this.zza;
        if (zzbwgVar.zzb == null) {
            return;
        }
        zzbwgVar.zzb.onCustomClick(zzbwgVar.zzf(zzbkgVar), str);
    }
}
