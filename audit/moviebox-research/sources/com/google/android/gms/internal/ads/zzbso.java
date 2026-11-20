package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbso {
    public final String zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;
    public final String zze;
    public final List zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final String zzk;
    public final List zzl;
    public final List zzm;
    public final List zzn;
    public final String zzo;
    public final String zzp;

    @Nullable
    public final String zzq;

    @Nullable
    public final String zzr;
    public final String zzs;

    @Nullable
    public final List zzt;
    public final String zzu;

    @Nullable
    public final String zzv;

    public zzbso(JSONObject jSONObject) throws JSONException {
        List listZza;
        this.zzb = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(jSONArray.getString(i11));
        }
        this.zzc = Collections.unmodifiableList(arrayList);
        this.zzd = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzf = zzbsq.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzg = zzbsq.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzh = zzbsq.zza(jSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzj = zzbsq.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzl = zzbsq.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzn = zzbsq.zza(jSONObject, "video_complete_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzm = zzbsq.zza(jSONObject, "video_reward_urls");
        this.zzo = jSONObject.optString(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER);
        this.zzp = jSONObject.optString("valid_from_timestamp");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        if (jSONObjectOptJSONObject != null) {
            com.google.android.gms.ads.internal.zzt.zzg();
            listZza = zzbsq.zza(jSONObjectOptJSONObject, "manual_impression_urls");
        } else {
            listZza = null;
        }
        this.zzi = listZza;
        this.zza = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.zzk = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        this.zze = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("class_name") : null;
        this.zzq = jSONObject.optString("html_template", null);
        this.zzr = jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzs = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzt = zzbsq.zza(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzu = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.toString() : null;
        this.zzv = jSONObject.optString("response_type", null);
        jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
