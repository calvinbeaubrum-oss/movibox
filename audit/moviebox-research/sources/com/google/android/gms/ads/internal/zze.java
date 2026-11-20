package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbrn;
import com.google.android.gms.internal.ads.zzbrr;
import com.google.android.gms.internal.ads.zzbru;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzcdf;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzces;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzgdu;
import com.google.android.gms.internal.ads.zzgen;
import com.google.android.gms.internal.ads.zzgey;
import com.google.common.util.concurrent.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzcei zzceiVar, String str, @Nullable Runnable runnable, zzfnc zzfncVar) {
        zzb(context, zzceiVar, true, null, str, null, runnable, zzfncVar);
    }

    public final void zzb(Context context, zzcei zzceiVar, boolean z11, @Nullable zzcdf zzcdfVar, String str, @Nullable String str2, @Nullable Runnable runnable, final zzfnc zzfncVar) {
        PackageInfo packageInfo;
        if (zzt.zzB().elapsedRealtime() - this.zzb < 5000) {
            zzcec.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzB().elapsedRealtime();
        if (zzcdfVar != null && !TextUtils.isEmpty(zzcdfVar.zzc())) {
            if (zzt.zzB().currentTimeMillis() - zzcdfVar.zza() <= ((Long) zzba.zzc().zza(zzbgc.zzdY)).longValue() && zzcdfVar.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzcec.zzj("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            zzcec.zzj("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzfmo zzfmoVarZza = zzfmn.zza(context, 4);
        zzfmoVarZza.zzh();
        zzbrx zzbrxVarZza = zzt.zzf().zza(this.zza, zzceiVar, zzfncVar);
        zzbrr zzbrrVar = zzbru.zza;
        zzbrn zzbrnVarZza = zzbrxVarZza.zza("google.afma.config.fetchAppSettings", zzbrrVar, zzbrrVar);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("ad_unit_id", str2);
            }
            jSONObject.put("is_init", z11);
            jSONObject.put("pn", context.getPackageName());
            zzbfu zzbfuVar = zzbgc.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
            jSONObject.put("js", zzceiVar.zza);
            try {
                ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
            }
            s sVarZzb = zzbrnVarZza.zzb(jSONObject);
            zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) throws JSONException {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    boolean zOptBoolean = jSONObject2.optBoolean("isSuccessful", false);
                    if (zOptBoolean) {
                        zzt.zzo().zzi().zzu(jSONObject2.getString("appSettingsJson"));
                    }
                    zzfmo zzfmoVar = zzfmoVarZza;
                    zzfnc zzfncVar2 = zzfncVar;
                    zzfmoVar.zzf(zOptBoolean);
                    zzfncVar2.zzb(zzfmoVar.zzl());
                    return zzgen.zzh(null);
                }
            };
            zzgey zzgeyVar = zzcep.zzf;
            s sVarZzn = zzgen.zzn(sVarZzb, zzgduVar, zzgeyVar);
            if (runnable != null) {
                sVarZzb.addListener(runnable, zzgeyVar);
            }
            zzces.zza(sVarZzn, "ConfigLoader.maybeFetchNewAppSettings");
        } catch (Exception e11) {
            zzcec.zzh("Error requesting application settings", e11);
            zzfmoVarZza.zzg(e11);
            zzfmoVarZza.zzf(false);
            zzfncVar.zzb(zzfmoVarZza.zzl());
        }
    }

    public final void zzc(Context context, zzcei zzceiVar, String str, zzcdf zzcdfVar, zzfnc zzfncVar) {
        zzb(context, zzceiVar, false, zzcdfVar, zzcdfVar != null ? zzcdfVar.zzb() : null, str, null, zzfncVar);
    }
}
