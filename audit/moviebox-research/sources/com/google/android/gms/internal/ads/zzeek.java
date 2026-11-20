package com.google.android.gms.internal.ads;

import com.cloud.tmc.integration.permission.PermissionConstant;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzeek implements zzbrq {
    @Override // com.google.android.gms.internal.ads.zzbrq
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeel zzeelVar = (zzeel) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzeelVar.zzd.zze());
            jSONObject2.put("ad_request_post_body", zzeelVar.zzd.zzd());
        }
        jSONObject2.put("base_url", zzeelVar.zzd.zzb());
        jSONObject2.put("signals", zzeelVar.zzc);
        jSONObject3.put(TtmlNode.TAG_BODY, zzeelVar.zzb.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzay.zzb().zzi(zzeelVar.zzb.zzb));
        jSONObject3.put("response_code", zzeelVar.zzb.zza);
        jSONObject3.put("latency", zzeelVar.zzb.zzd);
        jSONObject.put(PermissionConstant.ACTION_REQUEST, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzeelVar.zzd.zzg());
        return jSONObject;
    }
}
