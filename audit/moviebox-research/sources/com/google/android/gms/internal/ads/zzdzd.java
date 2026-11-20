package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.common.util.concurrent.s;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdzd implements zzeab, zzdyo {
    private final zzdzl zza;
    private final zzeac zzb;
    private final zzdyp zzc;
    private final zzdyy zzd;
    private final zzdyn zze;
    private final zzdzx zzf;
    private final String zzg;
    private final String zzh;
    private JSONObject zzm;
    private boolean zzp;
    private int zzq;
    private boolean zzr;
    private final Map zzi = new HashMap();
    private final Map zzj = new HashMap();
    private final Map zzk = new HashMap();
    private String zzl = "{}";
    private long zzn = Long.MAX_VALUE;
    private zzdyz zzo = zzdyz.NONE;
    private zzdzc zzs = zzdzc.UNKNOWN;
    private long zzt = 0;

    public zzdzd(zzdzl zzdzlVar, zzeac zzeacVar, zzdyp zzdypVar, Context context, zzcei zzceiVar, zzdyy zzdyyVar, zzdzx zzdzxVar, String str) {
        this.zza = zzdzlVar;
        this.zzb = zzeacVar;
        this.zzc = zzdypVar;
        this.zze = new zzdyn(context);
        this.zzg = zzceiVar.zza;
        this.zzh = str;
        this.zzd = zzdyyVar;
        this.zzf = zzdzxVar;
        com.google.android.gms.ads.internal.zzt.zzs().zzg(this);
    }

    private final synchronized JSONObject zzs() throws JSONException {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.zzi.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                for (zzdyr zzdyrVar : (List) entry.getValue()) {
                    if (zzdyrVar.zzg()) {
                        jSONArray.put(zzdyrVar.zzd());
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put((String) entry.getKey(), jSONArray);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return jSONObject;
    }

    private final void zzt() {
        this.zzr = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        zzz(com.google.android.gms.ads.internal.zzt.zzo().zzi().zzo());
    }

    private final void zzu() {
        com.google.android.gms.ads.internal.zzt.zzo().zzi().zzG(zzd());
    }

    private final synchronized void zzv(zzdyz zzdyzVar, boolean z11) {
        try {
            if (this.zzo != zzdyzVar) {
                if (zzp()) {
                    zzx();
                }
                this.zzo = zzdyzVar;
                if (zzp()) {
                    zzy();
                }
                if (z11) {
                    zzu();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002d A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0033 A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:15:0x0029, B:20:0x0038, B:16:0x002d, B:18:0x0033), top: B:27:0x0001 }] */
    private final synchronized void zzw(boolean z11, boolean z12) {
        try {
            if (this.zzp != z11) {
                this.zzp = z11;
                if (z11) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue() || !com.google.android.gms.ads.internal.zzt.zzs().zzl()) {
                        zzy();
                    } else if (!zzp()) {
                        zzx();
                    }
                } else if (!zzp()) {
                    zzx();
                }
                if (z12) {
                    zzu();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final synchronized void zzx() {
        zzdyz zzdyzVar = zzdyz.NONE;
        int iOrdinal = this.zzo.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzb();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzy() {
        zzdyz zzdyzVar = zzdyz.NONE;
        int iOrdinal = this.zzo.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzc();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzc();
        }
    }

    private final synchronized void zzz(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzw(jSONObject.optBoolean("isTestMode", false), false);
            zzv((zzdyz) Enum.valueOf(zzdyz.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzl = jSONObject.optString("networkExtras", "{}");
            this.zzn = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    public final zzdyz zza() {
        return this.zzo;
    }

    public final synchronized s zzb(String str) {
        zzceu zzceuVar;
        try {
            zzceuVar = new zzceu();
            if (this.zzj.containsKey(str)) {
                zzceuVar.zzc((zzdyr) this.zzj.get(str));
            } else {
                if (!this.zzk.containsKey(str)) {
                    this.zzk.put(str, new ArrayList());
                }
                ((List) this.zzk.get(str)).add(zzceuVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return zzceuVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzp()) {
            if (this.zzn < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                this.zzl = "{}";
                this.zzn = Long.MAX_VALUE;
                return "";
            }
            if (!this.zzl.equals("{}")) {
                return this.zzl;
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzp);
            jSONObject.put("gesture", this.zzo);
            if (this.zzn > com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzl);
                jSONObject.put("networkExtrasExpirationSecs", this.zzn);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackingKey.PLATFORM, "ANDROID");
                if (!TextUtils.isEmpty(this.zzh)) {
                    jSONObject.put(PushConstants.PROVIDER_FIELD_SDK_VERSION, "afma-sdk-a-v" + this.zzh);
                }
                jSONObject.put("internalSdkVersion", this.zzg);
                jSONObject.put("osVersion", Build.VERSION.RELEASE);
                jSONObject.put("adapters", this.zzd.zza());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjn)).booleanValue()) {
                    String strZzn = com.google.android.gms.ads.internal.zzt.zzo().zzn();
                    if (!TextUtils.isEmpty(strZzn)) {
                        jSONObject.put("plugin", strZzn);
                    }
                }
                if (this.zzn < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                    this.zzl = "{}";
                }
                jSONObject.put("networkExtras", this.zzl);
                jSONObject.put("adSlots", zzs());
                jSONObject.put("appInfo", this.zze.zza());
                String strZzc = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzc();
                if (!TextUtils.isEmpty(strZzc)) {
                    jSONObject.put("cld", new JSONObject(strZzc));
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjd)).booleanValue() && (jSONObject2 = this.zzm) != null) {
                    zzcec.zze("Server data: " + jSONObject2.toString());
                    jSONObject.put("serverData", this.zzm);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
                    jSONObject.put("openAction", this.zzs);
                    jSONObject.put("gesture", this.zzo);
                }
                jSONObject.put("isGamRegisteredTestDevice", com.google.android.gms.ads.internal.zzt.zzs().zzl());
                com.google.android.gms.ads.internal.zzt.zzp();
                com.google.android.gms.ads.internal.client.zzay.zzb();
                jSONObject.put("isSimulator", zzcdv.zzr());
            } catch (JSONException e11) {
                com.google.android.gms.ads.internal.zzt.zzo().zzv(e11, "Inspector.toJson");
                zzcec.zzk("Ad inspector encountered an error", e11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzdyr zzdyrVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzp()) {
            if (this.zzq >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziP)).intValue()) {
                zzcec.zzj("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            if (!this.zzi.containsKey(str)) {
                this.zzi.put(str, new ArrayList());
            }
            this.zzq++;
            ((List) this.zzi.get(str)).add(zzdyrVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjl)).booleanValue()) {
                String strZzc = zzdyrVar.zzc();
                this.zzj.put(strZzc, zzdyrVar);
                if (this.zzk.containsKey(strZzc)) {
                    List list = (List) this.zzk.get(strZzc);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzceu) it.next()).zzc(zzdyrVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final void zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue() && com.google.android.gms.ads.internal.zzt.zzo().zzi().zzP()) {
                zzt();
                return;
            }
            String strZzo = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzo();
            if (TextUtils.isEmpty(strZzo)) {
                return;
            }
            try {
                if (new JSONObject(strZzo).optBoolean("isTestMode", false)) {
                    zzt();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzda zzdaVar, zzdzc zzdzcVar) {
        if (!zzp()) {
            try {
                zzdaVar.zze(zzfij.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                zzcec.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue()) {
            this.zzs = zzdzcVar;
            this.zza.zzj(zzdaVar, new zzbnz(this), new zzbns(this.zzf));
            return;
        } else {
            try {
                zzdaVar.zze(zzfij.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                zzcec.zzj("Ad inspector had an internal error.");
                return;
            }
        }
        throw th;
    }

    public final synchronized void zzi(String str, long j11) {
        this.zzl = str;
        this.zzn = j11;
        zzu();
    }

    public final synchronized void zzj(long j11) {
        this.zzt += j11;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0011  */
    public final void zzk(boolean z11) {
        if (this.zzr) {
            if (z11) {
                if (!this.zzp) {
                    zzy();
                    return;
                }
            }
        } else if (z11) {
            zzt();
            if (!this.zzp) {
                zzy();
                return;
            }
        }
        if (zzp()) {
            return;
        }
        zzx();
    }

    public final void zzl(zzdyz zzdyzVar) {
        zzv(zzdyzVar, true);
    }

    public final synchronized void zzm(JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public final void zzn(boolean z11) {
        if (!this.zzr && z11) {
            zzt();
        }
        zzw(z11, true);
    }

    public final boolean zzo() {
        return this.zzm != null;
    }

    public final synchronized boolean zzp() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
            return this.zzp || com.google.android.gms.ads.internal.zzt.zzs().zzl();
        }
        return this.zzp;
    }

    public final synchronized boolean zzq() {
        return this.zzp;
    }

    public final boolean zzr() {
        return this.zzt < ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzji)).longValue();
    }
}
