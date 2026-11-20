package com.google.android.gms.internal.ads;

import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbsp {
    public final List zza;
    public final List zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final List zzf;
    public final String zzg;
    public final String zzh;

    public zzbsp(JSONObject jSONObject) throws JSONException {
        if (zzcec.zzm(2)) {
            com.google.android.gms.ads.internal.util.zze.zza("Mediation Response JSON: ".concat(String.valueOf(jSONObject.toString(2))));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i11 = -1;
        for (int i12 = 0; i12 < jSONArray.length(); i12++) {
            try {
                zzbso zzbsoVar = new zzbso(jSONArray.getJSONObject(i12));
                "banner".equalsIgnoreCase(zzbsoVar.zzv);
                arrayList.add(zzbsoVar);
                if (i11 < 0) {
                    Iterator it = zzbsoVar.zzc.iterator();
                    while (it.hasNext()) {
                        if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                            i11 = i12;
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        this.zzg = jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject == null) {
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = null;
            this.zzh = null;
            return;
        }
        jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzb = zzbsq.zza(jSONObjectOptJSONObject, "click_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzc = zzbsq.zza(jSONObjectOptJSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzd = zzbsq.zza(jSONObjectOptJSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zze = zzbsq.zza(jSONObjectOptJSONObject, "nofill_urls");
        com.google.android.gms.ads.internal.zzt.zzg();
        this.zzf = zzbsq.zza(jSONObjectOptJSONObject, "remote_ping_urls");
        jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
        jSONObjectOptJSONObject.optLong(ToolBar.REFRESH, -1L);
        zzcag zzcagVarZza = zzcag.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
        if (zzcagVarZza == null) {
            this.zzh = null;
        } else {
            this.zzh = zzcagVarZza.zza;
        }
        jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
        jSONObjectOptJSONObject.optBoolean("allow_pub_rendered_attribution", false);
        jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
        jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
    }
}
