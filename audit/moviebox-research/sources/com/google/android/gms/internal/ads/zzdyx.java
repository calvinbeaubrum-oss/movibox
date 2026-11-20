package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdyx {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private final int zzf;
    private final boolean zzg;

    public zzdyx(String str, String str2, String str3, int i11, String str4, int i12, boolean z11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = i11;
        this.zze = str4;
        this.zzf = i12;
        this.zzg = z11;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adapterClassName", this.zza);
        jSONObject.put("version", this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjj)).booleanValue()) {
            jSONObject.put(PushConstants.PROVIDER_FIELD_SDK_VERSION, this.zzb);
        }
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.zzd);
        jSONObject.put(TrackingKey.DESCRIPTION, this.zze);
        jSONObject.put("initializationLatencyMillis", this.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjk)).booleanValue()) {
            jSONObject.put("supportsInitialization", this.zzg);
        }
        return jSONObject;
    }
}
