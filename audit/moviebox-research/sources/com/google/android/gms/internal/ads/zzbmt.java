package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzbmt implements zzbng {
    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfwk.zzc("true", str) && !zzfwk.zzc("false", str)) {
                return;
            }
            zzfuf.zzi(zzcjkVar.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
