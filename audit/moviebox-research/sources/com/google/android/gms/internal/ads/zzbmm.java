package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbmm implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzb;
        zzcjk zzcjkVar = (zzcjk) obj;
        zzbja zzbjaVarZzK = zzcjkVar.zzK();
        if (zzbjaVarZzK == null || (jSONObjectZzb = zzbjaVarZzK.zzb()) == null) {
            zzcjkVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcjkVar.zze("nativeClickMetaReady", jSONObjectZzb);
        }
    }
}
