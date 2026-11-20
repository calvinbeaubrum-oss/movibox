package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzcdf;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcep;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzj implements zzg {
    private boolean zzb;
    private s zzd;

    @Nullable
    private SharedPreferences zzf;

    @Nullable
    private SharedPreferences.Editor zzg;

    @Nullable
    private String zzi;

    @Nullable
    private String zzj;
    private final Object zza = new Object();
    private final List zzc = new ArrayList();

    @Nullable
    private zzazp zze = null;
    private boolean zzh = true;
    private boolean zzk = true;
    private String zzl = "-1";
    private String zzm = "-1";
    private String zzn = "-1";
    private int zzo = -1;
    private zzcdf zzp = new zzcdf("", 0);
    private long zzq = 0;
    private long zzr = 0;
    private int zzs = -1;
    private int zzt = 0;
    private Set zzu = Collections.emptySet();
    private JSONObject zzv = new JSONObject();
    private boolean zzw = true;
    private boolean zzx = true;
    private String zzy = null;
    private String zzz = "";
    private boolean zzA = false;
    private String zzB = "";
    private int zzC = -1;
    private int zzD = -1;
    private long zzE = 0;

    private final void zzT() {
        s sVar = this.zzd;
        if (sVar == null || sVar.isDone()) {
            return;
        }
        try {
            this.zzd.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            zzcec.zzk("Interrupted while waiting for preferences loaded.", e11);
        } catch (CancellationException e12) {
            e = e12;
            zzcec.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e13) {
            e = e13;
            zzcec.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e14) {
            e = e14;
            zzcec.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final void zzU() {
        zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzA(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
            zzT();
            synchronized (this.zza) {
                try {
                    if (this.zzB.equals(str)) {
                        return;
                    }
                    this.zzB = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzU();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzB(boolean z11) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
            zzT();
            synchronized (this.zza) {
                try {
                    if (this.zzA == z11) {
                        return;
                    }
                    this.zzA = z11;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z11);
                        this.zzg.apply();
                    }
                    zzU();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzC(String str) {
        zzT();
        synchronized (this.zza) {
            try {
                if (TextUtils.equals(this.zzy, str)) {
                    return;
                }
                this.zzy = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzD(long j11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzr == j11) {
                    return;
                }
                this.zzr = j11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzE(int i11) {
        zzT();
        synchronized (this.zza) {
            try {
                this.zzo = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    if (i11 == -1) {
                        editor.remove("gad_has_consent_for_cookies");
                    } else {
                        editor.putInt("gad_has_consent_for_cookies", i11);
                    }
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzF(@NonNull String str, @NonNull String str2) {
        byte b11;
        zzT();
        synchronized (this.zza) {
            try {
                int iHashCode = str.hashCode();
                if (iHashCode != -2004976699) {
                    if (iHashCode != 83641339) {
                        if (iHashCode == 1218895378 && str.equals("IABTCF_TCString")) {
                            b11 = 1;
                        } else {
                            b11 = -1;
                        }
                    } else if (str.equals("IABTCF_gdprApplies")) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                } else if (str.equals("IABTCF_PurposeConsents")) {
                    b11 = 2;
                } else {
                    b11 = -1;
                }
                if (b11 == 0) {
                    this.zzl = str2;
                } else if (b11 == 1) {
                    this.zzm = str2;
                } else if (b11 != 2) {
                    return;
                } else {
                    this.zzn = str2;
                }
                if (this.zzg != null) {
                    if (str2.equals("-1")) {
                        this.zzg.remove(str);
                    } else {
                        this.zzg.putString(str, str2);
                    }
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzG(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue()) {
            zzT();
            synchronized (this.zza) {
                try {
                    if (this.zzz.equals(str)) {
                        return;
                    }
                    this.zzz = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzU();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzH(boolean z11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (z11 == this.zzk) {
                    return;
                }
                this.zzk = z11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzI(boolean z11) {
        zzT();
        synchronized (this.zza) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjW)).longValue();
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("is_topics_ad_personalization_allowed", z11);
                    this.zzg.putLong("topics_consent_expiry_time_ms", jCurrentTimeMillis);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzJ(String str, String str2, boolean z11) {
        zzT();
        synchronized (this.zza) {
            try {
                JSONArray jSONArrayOptJSONArray = this.zzv.optJSONArray(str);
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                int length = jSONArrayOptJSONArray.length();
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                    if (jSONObjectOptJSONObject == null) {
                        return;
                    }
                    if (str2.equals(jSONObjectOptJSONObject.optString("template_id"))) {
                        if (!z11 || !jSONObjectOptJSONObject.optBoolean("uses_media_view", false)) {
                            length = i11;
                            break;
                        }
                        return;
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("template_id", str2);
                    jSONObject.put("uses_media_view", z11);
                    jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
                    jSONArrayOptJSONArray.put(length, jSONObject);
                    this.zzv.put(str, jSONArrayOptJSONArray);
                } catch (JSONException e11) {
                    zzcec.zzk("Could not update native advanced settings", e11);
                }
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("native_advanced_settings", this.zzv.toString());
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzK(int i11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzs == i11) {
                    return;
                }
                this.zzs = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzL(int i11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzD == i11) {
                    return;
                }
                this.zzD = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzM(long j11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzE == j11) {
                    return;
                }
                this.zzE = j11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzN() {
        boolean z11;
        zzT();
        synchronized (this.zza) {
            z11 = this.zzw;
        }
        return z11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzO() {
        boolean z11;
        zzT();
        synchronized (this.zza) {
            z11 = this.zzx;
        }
        return z11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzP() {
        boolean z11;
        zzT();
        synchronized (this.zza) {
            z11 = this.zzA;
        }
        return z11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzQ() {
        boolean z11;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzau)).booleanValue()) {
            return false;
        }
        zzT();
        synchronized (this.zza) {
            z11 = this.zzk;
        }
        return z11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzR() {
        zzT();
        synchronized (this.zza) {
            try {
                SharedPreferences sharedPreferences = this.zzf;
                boolean z11 = false;
                if (sharedPreferences == null) {
                    return false;
                }
                if (sharedPreferences.getLong("topics_consent_expiry_time_ms", 0L) < System.currentTimeMillis()) {
                    return false;
                }
                if (this.zzf.getBoolean("is_topics_ad_personalization_allowed", false) && !this.zzk) {
                    z11 = true;
                }
                return z11;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ void zzS(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        synchronized (this.zza) {
            try {
                this.zzf = sharedPreferences;
                this.zzg = editorEdit;
                if (PlatformVersion.isAtLeastM()) {
                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                }
                this.zzh = this.zzf.getBoolean("use_https", this.zzh);
                this.zzw = this.zzf.getBoolean("content_url_opted_out", this.zzw);
                this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
                this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
                this.zzx = this.zzf.getBoolean("content_vertical_opted_out", this.zzx);
                this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
                this.zzt = this.zzf.getInt("version_code", this.zzt);
                this.zzp = new zzcdf(this.zzf.getString("app_settings_json", this.zzp.zzc()), this.zzf.getLong("app_settings_last_update_ms", this.zzp.zza()));
                this.zzq = this.zzf.getLong("app_last_background_time_ms", this.zzq);
                this.zzs = this.zzf.getInt("request_in_session_count", this.zzs);
                this.zzr = this.zzf.getLong("first_ad_req_time_ms", this.zzr);
                this.zzu = this.zzf.getStringSet("never_pool_slots", this.zzu);
                this.zzy = this.zzf.getString("display_cutout", this.zzy);
                this.zzC = this.zzf.getInt("app_measurement_npa", this.zzC);
                this.zzD = this.zzf.getInt("sd_app_measure_npa", this.zzD);
                this.zzE = this.zzf.getLong("sd_app_measure_npa_ts", this.zzE);
                this.zzz = this.zzf.getString("inspector_info", this.zzz);
                this.zzA = this.zzf.getBoolean("linked_device", this.zzA);
                this.zzB = this.zzf.getString("linked_ad_unit", this.zzB);
                this.zzl = this.zzf.getString("IABTCF_gdprApplies", this.zzl);
                this.zzn = this.zzf.getString("IABTCF_PurposeConsents", this.zzn);
                this.zzm = this.zzf.getString("IABTCF_TCString", this.zzm);
                this.zzo = this.zzf.getInt("gad_has_consent_for_cookies", this.zzo);
                try {
                    this.zzv = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
                } catch (JSONException e11) {
                    zzcec.zzk("Could not convert native advanced settings to json object", e11);
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zza() {
        int i11;
        zzT();
        synchronized (this.zza) {
            i11 = this.zzt;
        }
        return i11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzb() {
        int i11;
        zzT();
        synchronized (this.zza) {
            i11 = this.zzo;
        }
        return i11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzc() {
        int i11;
        zzT();
        synchronized (this.zza) {
            i11 = this.zzs;
        }
        return i11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzd() {
        long j11;
        zzT();
        synchronized (this.zza) {
            j11 = this.zzq;
        }
        return j11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zze() {
        long j11;
        zzT();
        synchronized (this.zza) {
            j11 = this.zzr;
        }
        return j11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzf() {
        long j11;
        zzT();
        synchronized (this.zza) {
            j11 = this.zzE;
        }
        return j11;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final zzazp zzg() {
        if (!this.zzb) {
            return null;
        }
        if ((zzN() && zzO()) || !((Boolean) zzbhs.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            try {
                if (Looper.getMainLooper() == null) {
                    return null;
                }
                if (this.zze == null) {
                    this.zze = new zzazp();
                }
                this.zze.zze();
                zzcec.zzi("start fetching content...");
                return this.zze;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzcdf zzh() {
        zzcdf zzcdfVar;
        zzT();
        synchronized (this.zza) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzle)).booleanValue() && this.zzp.zzj()) {
                    Iterator it = this.zzc.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
                zzcdfVar = this.zzp;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzcdfVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzcdf zzi() {
        zzcdf zzcdfVar;
        synchronized (this.zza) {
            zzcdfVar = this.zzp;
        }
        return zzcdfVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final String zzj() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final String zzk() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzl() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzB;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzm() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzy;
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    @Override // com.google.android.gms.ads.internal.util.zzg
    @Nullable
    public final String zzn(@NonNull String str) {
        byte b11;
        zzT();
        synchronized (this.zza) {
            try {
                int iHashCode = str.hashCode();
                if (iHashCode != -2004976699) {
                    if (iHashCode != 83641339) {
                        if (iHashCode == 1218895378 && str.equals("IABTCF_TCString")) {
                            b11 = 1;
                        } else {
                            b11 = -1;
                        }
                    } else if (str.equals("IABTCF_gdprApplies")) {
                        b11 = 0;
                    } else {
                        b11 = -1;
                    }
                } else if (str.equals("IABTCF_PurposeConsents")) {
                    b11 = 2;
                } else {
                    b11 = -1;
                }
                if (b11 == 0) {
                    return this.zzl;
                }
                if (b11 == 1) {
                    return this.zzm;
                }
                if (b11 != 2) {
                    return null;
                }
                return this.zzn;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzo() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzz;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final JSONObject zzp() {
        JSONObject jSONObject;
        zzT();
        synchronized (this.zza) {
            jSONObject = this.zzv;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzq(Runnable runnable) {
        this.zzc.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzr(final Context context) {
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    return;
                }
                final String str = "admob";
                this.zzd = zzcep.zza.zza(new Runnable(context, str) { // from class: com.google.android.gms.ads.internal.util.zzi
                    public final /* synthetic */ Context zzb;
                    public final /* synthetic */ String zzc = "admob";

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzS(this.zzb, this.zzc);
                    }
                });
                this.zzb = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzs() {
        zzT();
        synchronized (this.zza) {
            try {
                this.zzv = new JSONObject();
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.remove("native_advanced_settings");
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzt(long j11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzq == j11) {
                    return;
                }
                this.zzq = j11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzu(String str) {
        zzT();
        synchronized (this.zza) {
            try {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                if (str != null && !str.equals(this.zzp.zzc())) {
                    this.zzp = new zzcdf(str, jCurrentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                        this.zzg.apply();
                    }
                    zzU();
                    Iterator it = this.zzc.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    return;
                }
                this.zzp.zzg(jCurrentTimeMillis);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzv(int i11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzt == i11) {
                    return;
                }
                this.zzt = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzw(@Nullable String str) {
        zzT();
        synchronized (this.zza) {
            try {
                if (str.equals(this.zzi)) {
                    return;
                }
                this.zzi = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_url_hashes", str);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzx(boolean z11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzw == z11) {
                    return;
                }
                this.zzw = z11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzy(@Nullable String str) {
        zzT();
        synchronized (this.zza) {
            try {
                if (str.equals(this.zzj)) {
                    return;
                }
                this.zzj = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzz(boolean z11) {
        zzT();
        synchronized (this.zza) {
            try {
                if (this.zzx == z11) {
                    return;
                }
                this.zzx = z11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z11);
                    this.zzg.apply();
                }
                zzU();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
