package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfgr {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    public zzfgr(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        JSONObject jSONObjectZzh = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
        this.zzd = jSONObjectZzh;
        this.zza = jSONObjectZzh.optString(CampaignEx.JSON_KEY_AD_HTML, null);
        this.zzb = jSONObjectZzh.optString("ad_base_url", null);
        this.zzc = jSONObjectZzh.optJSONObject("ad_json");
    }
}
