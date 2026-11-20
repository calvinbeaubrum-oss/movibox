package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbnd implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        if (map.keySet().contains("start")) {
            zzcjkVar.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcjkVar.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcjkVar.zzN().zzk();
        }
    }
}
