package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeym implements zzexp {

    @Nullable
    private final AdvertisingIdClient.Info zza;

    @Nullable
    private final String zzb;
    private final zzfub zzc;

    public zzeym(@Nullable AdvertisingIdClient.Info info, @Nullable String str, zzfub zzfubVar) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzfubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.util.zzbw.zzf((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                String str = this.zzb;
                if (str != null) {
                    jSONObjectZzf.put("pdid", str);
                    jSONObjectZzf.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            jSONObjectZzf.put("rdid", this.zza.getId());
            jSONObjectZzf.put("is_lat", this.zza.isLimitAdTrackingEnabled());
            jSONObjectZzf.put("idtype", "adid");
            zzfub zzfubVar = this.zzc;
            if (zzfubVar.zzc()) {
                jSONObjectZzf.put("paidv1_id_android_3p", zzfubVar.zzb());
                jSONObjectZzf.put("paidv1_creation_time_android_3p", this.zzc.zza());
            }
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e11);
        }
    }
}
