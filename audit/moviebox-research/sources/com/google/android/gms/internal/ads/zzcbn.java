package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbn implements zzcbs {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzheb zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzcbp zzi;
    private final zzcbo zzn;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzcbn(Context context, zzcei zzceiVar, zzcbp zzcbpVar, @Nullable String str, zzcbo zzcboVar) {
        Preconditions.checkNotNull(zzcbpVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzn = zzcboVar;
        this.zzi = zzcbpVar;
        Iterator it = zzcbpVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzheb zzhebVarZza = zzhfz.zza();
        zzhebVarZza.zzn(9);
        zzhebVarZza.zzj(str);
        zzhebVarZza.zzh(str);
        zzhec zzhecVarZza = zzhed.zza();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzhecVarZza.zza(str2);
        }
        zzhebVarZza.zzg((zzhed) zzhecVarZza.zzal());
        zzhfq zzhfqVarZza = zzhfr.zza();
        zzhfqVarZza.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = zzceiVar.zza;
        if (str3 != null) {
            zzhfqVarZza.zza(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzhfqVarZza.zzb(apkVersion);
        }
        zzhebVarZza.zzf((zzhfr) zzhfqVarZza.zzal());
        this.zzd = zzhebVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final zzcbp zza() {
        return this.zzi;
    }

    public final /* synthetic */ s zzb(Map map) throws Exception {
        zzhfo zzhfoVar;
        s sVarZzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        synchronized (this.zzj) {
                            try {
                                int length = jSONArrayOptJSONArray.length();
                                synchronized (this.zzj) {
                                    try {
                                        zzhfoVar = (zzhfo) this.zze.get(str);
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                if (zzhfoVar == null) {
                                    zzcbr.zza("Cannot find the corresponding resource object for " + str);
                                } else {
                                    for (int i11 = 0; i11 < length; i11++) {
                                        zzhfoVar.zza(jSONArrayOptJSONArray.getJSONObject(i11).getString("threat_type"));
                                    }
                                    this.zza = (length > 0) | this.zza;
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                }
            } catch (JSONException e11) {
                if (((Boolean) zzbii.zzb.zze()).booleanValue()) {
                    zzcec.zzf("Failed to get SafeBrowsing metadata", e11);
                }
                return zzgen.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z11 = this.zza;
        if (!(z11 && this.zzi.zzg) && (!(this.zzm && this.zzi.zzf) && (z11 || !this.zzi.zzd))) {
            return zzgen.zzh(null);
        }
        synchronized (this.zzj) {
            try {
                Iterator it = this.zze.values().iterator();
                while (it.hasNext()) {
                    this.zzd.zzc((zzhfp) ((zzhfo) it.next()).zzal());
                }
                this.zzd.zza(this.zzf);
                this.zzd.zzb(this.zzg);
                if (zzcbr.zzb()) {
                    StringBuilder sb2 = new StringBuilder("Sending SB report\n  url: " + this.zzd.zzl() + "\n  clickUrl: " + this.zzd.zzk() + "\n  resources: \n");
                    for (zzhfp zzhfpVar : this.zzd.zzm()) {
                        sb2.append("    [");
                        sb2.append(zzhfpVar.zza());
                        sb2.append("] ");
                        sb2.append(zzhfpVar.zze());
                    }
                    zzcbr.zza(sb2.toString());
                }
                s sVarZzb = new com.google.android.gms.ads.internal.util.zzbq(this.zzh).zzb(1, this.zzi.zzb, null, ((zzhfz) this.zzd.zzal()).zzax());
                if (zzcbr.zzb()) {
                    sVarZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbk
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcbr.zza("Pinged SB successfully.");
                        }
                    }, zzcep.zza);
                }
                sVarZzm = zzgen.zzm(sVarZzb, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcbl
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        int i12 = zzcbn.zzb;
                        return null;
                    }
                }, zzcep.zzf);
            } catch (Throwable th4) {
                throw th4;
            }
        }
        return sVarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzd(String str, Map map, int i11) {
        synchronized (this.zzj) {
            if (i11 == 3) {
                try {
                    this.zzm = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (this.zze.containsKey(str)) {
                if (i11 == 3) {
                    ((zzhfo) this.zze.get(str)).zze(4);
                }
                return;
            }
            zzhfo zzhfoVarZzc = zzhfp.zzc();
            int iZza = zzhfn.zza(i11);
            if (iZza != 0) {
                zzhfoVarZzc.zze(iZza);
            }
            zzhfoVarZzc.zzb(this.zze.size());
            zzhfoVarZzc.zzd(str);
            zzheo zzheoVarZza = zzher.zza();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzhem zzhemVarZza = zzhen.zza();
                        zzhemVarZza.zza(zzgyl.zzw(str2));
                        zzhemVarZza.zzb(zzgyl.zzw(str3));
                        zzheoVarZza.zza((zzhen) zzhemVarZza.zzal());
                    }
                }
            }
            zzhfoVarZzc.zzc((zzher) zzheoVarZza.zzal());
            this.zze.put(str, zzhfoVarZzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            s sVarZzh = zzgen.zzh(Collections.emptyMap());
            zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.internal.ads.zzcbi
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final s zza(Object obj) {
                    return this.zza.zzb((Map) obj);
                }
            };
            zzgey zzgeyVar = zzcep.zzf;
            s sVarZzn = zzgen.zzn(sVarZzh, zzgduVar, zzgeyVar);
            s sVarZzo = zzgen.zzo(sVarZzn, 10L, TimeUnit.SECONDS, zzcep.zzd);
            zzgen.zzr(sVarZzn, new zzcbm(this, sVarZzo), zzgeyVar);
            zzc.add(sVarZzo);
        }
    }

    public final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgyi zzgyiVarZzt = zzgyl.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzgyiVarZzt);
        synchronized (this.zzj) {
            zzheb zzhebVar = this.zzd;
            zzhfh zzhfhVarZza = zzhfj.zza();
            zzhfhVarZza.zza(zzgyiVarZzt.zzb());
            zzhfhVarZza.zzb("image/png");
            zzhfhVarZza.zzc(2);
            zzhebVar.zzi((zzhfj) zzhfhVarZza.zzal());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzg(View view) {
        Bitmap bitmapCreateBitmap;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.zzt.zzp();
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                    try {
                        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                    } catch (RuntimeException e11) {
                        e = e11;
                        zzcec.zzh("Fail to capture the web view", e);
                    }
                } catch (RuntimeException e12) {
                    e = e12;
                    bitmapCreateBitmap = null;
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            zzcec.zzj("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException e13) {
                        zzcec.zzh("Fail to capture the webview", e13);
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzcbr.zza("Failed to capture the webview bitmap.");
                return;
            }
            this.zzl = true;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcbj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf(bitmap);
                }
            };
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                runnable.run();
            } else {
                zzcep.zza.execute(runnable);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzh(String str) {
        synchronized (this.zzj) {
            try {
                if (str == null) {
                    this.zzd.zzd();
                } else {
                    this.zzd.zze(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
