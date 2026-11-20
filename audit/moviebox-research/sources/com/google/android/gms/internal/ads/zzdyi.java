package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.cloud.config.utils.XLogUtil;
import com.google.common.util.concurrent.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdyi {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdua zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdwp zzl;
    private final zzcei zzm;
    private final zzdht zzo;
    private final zzfnc zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzceu zze = new zzceu();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();

    public zzdyi(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdua zzduaVar, ScheduledExecutorService scheduledExecutorService, zzdwp zzdwpVar, zzcei zzceiVar, zzdht zzdhtVar, zzfnc zzfncVar) {
        this.zzh = zzduaVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdwpVar;
        this.zzm = zzceiVar;
        this.zzo = zzdhtVar;
        this.zzp = zzfncVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* bridge */ /* synthetic */ void zzj(final zzdyi zzdyiVar, String str) {
        int i11 = 5;
        final zzfmo zzfmoVarZza = zzfmn.zza(zzdyiVar.zzf, 5);
        zzfmoVarZza.zzh();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(XLogUtil.TAG);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzfmo zzfmoVarZza2 = zzfmn.zza(zzdyiVar.zzf, i11);
                zzfmoVarZza2.zzh();
                zzfmoVarZza2.zzd(next);
                final Object obj = new Object();
                final zzceu zzceuVar = new zzceu();
                s sVarZzo = zzgen.zzo(zzceuVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbO)).longValue(), TimeUnit.SECONDS, zzdyiVar.zzk);
                zzdyiVar.zzl.zzc(next);
                zzdyiVar.zzo.zzc(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                sVarZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxz
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzq(obj, zzceuVar, next, jElapsedRealtime, zzfmoVarZza2);
                    }
                }, zzdyiVar.zzi);
                arrayList.add(sVarZzo);
                final zzdyh zzdyhVar = new zzdyh(zzdyiVar, obj, next, jElapsedRealtime, zzfmoVarZza2, zzceuVar);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        int i12 = 0;
                        while (i12 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i12);
                            String strOptString = jSONObject2.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbpn(strOptString, bundle));
                            i12++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdyiVar.zzv(next, false, "", 0);
                try {
                    try {
                        final zzfif zzfifVarZzc = zzdyiVar.zzh.zzc(next, new JSONObject());
                        zzdyiVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyd
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzn(next, zzdyhVar, zzfifVarZzc, arrayList2);
                            }
                        });
                    } catch (RemoteException e11) {
                        zzcec.zzh("", e11);
                    }
                } catch (zzfho unused2) {
                    zzdyhVar.zze("Failed to create Adapter.");
                }
                i11 = 5;
            }
            zzgen.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdya
                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.zza.zzf(zzfmoVarZza);
                    return null;
                }
            }, zzdyiVar.zzi);
        } catch (JSONException e12) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e12);
            zzdyiVar.zzo.zza("MalformedJson");
            zzdyiVar.zzl.zza("MalformedJson");
            zzdyiVar.zze.zzd(e12);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e12, "AdapterInitializer.updateAdapterStatus");
            zzfnc zzfncVar = zzdyiVar.zzp;
            zzfmoVarZza.zzg(e12);
            zzfmoVarZza.zzf(false);
            zzfncVar.zzb(zzfmoVarZza.zzl());
        }
    }

    private final synchronized s zzu() {
        String strZzc = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return zzgen.zzh(strZzc);
        }
        final zzceu zzceuVar = new zzceu();
        com.google.android.gms.ads.internal.zzt.zzo().zzi().zzq(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(zzceuVar);
            }
        });
        return zzceuVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z11, String str2, int i11) {
        this.zzn.put(str, new zzbpd(str, z11, i11, str2));
    }

    public final /* synthetic */ Object zzf(zzfmo zzfmoVar) throws Exception {
        this.zze.zzc(Boolean.TRUE);
        zzfmoVar.zzf(true);
        this.zzp.zzb(zzfmoVar.zzl());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbpd zzbpdVar = (zzbpd) this.zzn.get(str);
            arrayList.add(new zzbpd(str, zzbpdVar.zzb, zzbpdVar.zzc, zzbpdVar.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    public final /* synthetic */ void zzm() {
        synchronized (this) {
            try {
                if (this.zzc) {
                    return;
                }
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ void zzn(String str, zzbph zzbphVar, zzfif zzfifVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbphVar.zzf();
                    return;
                }
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzfifVar.zzi(context, zzbphVar, list);
            } catch (RemoteException e11) {
                zzcec.zzh("", e11);
            }
        } catch (RemoteException e12) {
            throw new zzfxz(e12);
        } catch (zzfho unused) {
            zzbphVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
        }
    }

    public final /* synthetic */ void zzo(final zzceu zzceuVar) {
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxy
            @Override // java.lang.Runnable
            public final void run() {
                String strZzc = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzc();
                boolean zIsEmpty = TextUtils.isEmpty(strZzc);
                zzceu zzceuVar2 = zzceuVar;
                if (zIsEmpty) {
                    zzceuVar2.zzd(new Exception());
                } else {
                    zzceuVar2.zzc(strZzc);
                }
            }
        });
    }

    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    public final /* synthetic */ void zzq(Object obj, zzceu zzceuVar, String str, long j11, zzfmo zzfmoVar) {
        synchronized (obj) {
            try {
                if (!zzceuVar.isDone()) {
                    zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j11));
                    this.zzl.zzb(str, "timeout");
                    this.zzo.zzb(str, "timeout");
                    zzfnc zzfncVar = this.zzp;
                    zzfmoVar.zzc("Timeout");
                    zzfmoVar.zzf(false);
                    zzfncVar.zzb(zzfmoVar.zzl());
                    zzceuVar.zzc(Boolean.FALSE);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbig.zza.zze()).booleanValue()) {
            if (this.zzm.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbN)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.zza) {
                            return;
                        }
                        this.zzl.zzf();
                        this.zzo.zzf();
                        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdye
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzp();
                            }
                        }, this.zzi);
                        this.zza = true;
                        s sVarZzu = zzu();
                        this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxx
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzm();
                            }
                        }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbP)).longValue(), TimeUnit.SECONDS);
                        zzgen.zzr(sVarZzu, new zzdyg(this), this.zzi);
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(Boolean.FALSE);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzbpk zzbpkVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdyc
            @Override // java.lang.Runnable
            public final void run() {
                zzdyi zzdyiVar = this.zza;
                try {
                    zzbpkVar.zzb(zzdyiVar.zzg());
                } catch (RemoteException e11) {
                    zzcec.zzh("", e11);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
