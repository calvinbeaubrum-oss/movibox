package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.s;
import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbnv implements zzbng {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get(TrackingKey.FAIL_REASON);
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        String strConcat = TextUtils.isEmpty(str4) ? "" : "\n".concat(String.valueOf(str4));
        synchronized (this.zza) {
            try {
                zzbnu zzbnuVar = (zzbnu) this.zzb.remove(str);
                if (zzbnuVar == null) {
                    zzcec.zzj("Received result for unexpected method invocation: " + str);
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    zzbnuVar.zza(str3 + strConcat);
                    return;
                }
                if (str5 == null) {
                    zzbnuVar.zzb(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                        com.google.android.gms.ads.internal.util.zze.zza("Result GMSG: " + jSONObject.toString(2));
                    }
                    zzbnuVar.zzb(jSONObject);
                } catch (JSONException e11) {
                    zzbnuVar.zza(e11.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final s zzb(zzbqn zzbqnVar, String str, JSONObject jSONObject) {
        zzceu zzceuVar = new zzceu();
        com.google.android.gms.ads.internal.zzt.zzp();
        String string = UUID.randomUUID().toString();
        zzc(string, new zzbnt(this, zzceuVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbqnVar.zzl(str, jSONObject2);
        } catch (Exception e11) {
            zzceuVar.zzd(e11);
        }
        return zzceuVar;
    }

    public final void zzc(String str, zzbnu zzbnuVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbnuVar);
        }
    }
}
