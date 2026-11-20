package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhh {
    private final ScheduledExecutorService zza;
    private Runnable zzb;
    private zzbhe zzc;
    private androidx.browser.customtabs.j zzd;
    private String zze;
    private long zzf = 0;
    private long zzg;
    private JSONArray zzh;
    private Context zzi;

    public zzbhh(ScheduledExecutorService scheduledExecutorService) {
        this.zza = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbgc.zzjB)).booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj() {
        zzbhe zzbheVar = this.zzc;
        if (zzbheVar == null) {
            zzcec.zzg("PACT callback is not present, please initialize the PawCustomTabsImpl.");
            return;
        }
        if (zzbheVar.zza().booleanValue()) {
            return;
        }
        if (this.zze != null && this.zzd != null && this.zza != null) {
            if (this.zzf == 0 || com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() > this.zzf) {
            }
            this.zzd.k(Uri.parse(this.zze));
            this.zza.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjC)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("PACT max retry connection duration timed out");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzh == null) {
                this.zzh = new JSONArray((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjE));
            }
            jSONObject.put("eids", this.zzh);
        } catch (JSONException e11) {
            zzcec.zzh("Error fetching the PACT active eids JSON: ", e11);
        }
    }

    public final androidx.browser.customtabs.j zzb() {
        return this.zzd;
    }

    public final JSONObject zzc(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        zzk(jSONObject);
        return jSONObject;
    }

    public final JSONObject zzd(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        zzk(jSONObject);
        return jSONObject;
    }

    public final void zzf() {
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjA)).intValue());
        if (this.zzb == null) {
            this.zzb = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhf
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj();
                }
            };
        }
        zzj();
    }

    public final void zzg(Context context, CustomTabsClient customTabsClient, String str, androidx.browser.customtabs.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        }
        if (customTabsClient == null) {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
        this.zzi = context;
        this.zze = str;
        zzbhe zzbheVar = new zzbhe(this, cVar);
        this.zzc = zzbheVar;
        androidx.browser.customtabs.j jVarE = customTabsClient.e(zzbheVar);
        this.zzd = jVarE;
        if (jVarE == null) {
            zzcec.zzg("CustomTabsClient failed to create new session.");
        }
    }

    public final void zzh(String str) {
        try {
            androidx.browser.customtabs.j jVar = this.zzd;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzg).toString());
            zzk(jSONObject);
            jVar.j(jSONObject.toString(), null);
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzi, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), new zzbhg(this, str));
        } catch (JSONException e11) {
            zzcec.zzh("Error creating JSON: ", e11);
        }
    }

    public final void zzi(long j11) {
        this.zzg = j11;
    }
}
