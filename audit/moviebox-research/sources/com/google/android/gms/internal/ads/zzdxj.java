package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdxj {

    @Nullable
    private Long zza;
    private final String zzb;

    @Nullable
    private String zzc;

    @Nullable
    private Integer zzd;

    @Nullable
    private String zze;

    @Nullable
    private Integer zzf;

    public /* synthetic */ zzdxj(String str, zzdxi zzdxiVar) {
        this.zzb = str;
    }

    public static /* bridge */ /* synthetic */ String zza(zzdxj zzdxjVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjI);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdxjVar.zza);
            jSONObject.put("eventCategory", zzdxjVar.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, zzdxjVar.zzc);
            jSONObject.putOpt("errorCode", zzdxjVar.zzd);
            jSONObject.putOpt("rewardType", zzdxjVar.zze);
            jSONObject.putOpt("rewardAmount", zzdxjVar.zzf);
        } catch (JSONException unused) {
            zzcec.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
