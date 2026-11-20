package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
final class zzbmx implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        if (zzcjkVar.zzJ() != null) {
            zzcjkVar.zzJ().zza();
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzcjkVar.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzM = zzcjkVar.zzM();
        if (zzmVarZzM != null) {
            zzmVarZzM.zzb();
        } else {
            zzcec.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
