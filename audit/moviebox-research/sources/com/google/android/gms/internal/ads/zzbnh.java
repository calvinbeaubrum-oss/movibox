package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbnh implements zzbng {
    private final zzbni zza;

    public zzbnh(zzbni zzbniVar) {
        this.zza = zzbniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        boolean zEquals = "1".equals(map.get("transparentBackground"));
        boolean zEquals2 = "1".equals(map.get("blur"));
        float f11 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f11 = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e11) {
            zzcec.zzh("Fail to parse float", e11);
        }
        this.zza.zzc(zEquals);
        this.zza.zzb(zEquals2, f11);
        zzcjkVar.zzav(zEquals);
    }
}
