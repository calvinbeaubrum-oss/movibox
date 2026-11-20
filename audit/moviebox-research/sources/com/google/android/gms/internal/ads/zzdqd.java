package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdqd {
    private final Context zza;
    private final zzdpm zzb;
    private final zzavi zzc;
    private final zzcei zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbbp zzf;
    private final Executor zzg;
    private final zzbjb zzh;
    private final zzdqv zzi;
    private final zzdtk zzj;
    private final ScheduledExecutorService zzk;
    private final zzdsf zzl;
    private final zzdwf zzm;
    private final zzflw zzn;
    private final zzfny zzo;
    private final zzehh zzp;
    private final zzehs zzq;
    private final zzfhl zzr;

    public zzdqd(Context context, zzdpm zzdpmVar, zzavi zzaviVar, zzcei zzceiVar, com.google.android.gms.ads.internal.zza zzaVar, zzbbp zzbbpVar, Executor executor, zzfhh zzfhhVar, zzdqv zzdqvVar, zzdtk zzdtkVar, ScheduledExecutorService scheduledExecutorService, zzdwf zzdwfVar, zzflw zzflwVar, zzfny zzfnyVar, zzehh zzehhVar, zzdsf zzdsfVar, zzehs zzehsVar, zzfhl zzfhlVar) {
        this.zza = context;
        this.zzb = zzdpmVar;
        this.zzc = zzaviVar;
        this.zzd = zzceiVar;
        this.zze = zzaVar;
        this.zzf = zzbbpVar;
        this.zzg = executor;
        this.zzh = zzfhhVar.zzi;
        this.zzi = zzdqvVar;
        this.zzj = zzdtkVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdwfVar;
        this.zzn = zzflwVar;
        this.zzo = zzfnyVar;
        this.zzp = zzehhVar;
        this.zzl = zzdsfVar;
        this.zzq = zzehsVar;
        this.zzr = zzfhlVar;
    }

    @Nullable
    public static final com.google.android.gms.ads.internal.client.zzel zzi(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(jSONObjectOptJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(CampaignEx.JSON_NATIVE_VIDEO_MUTE);
        if (jSONObjectOptJSONObject == null) {
            return zzgaa.zzl();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgaa.zzl();
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
            com.google.android.gms.ads.internal.client.zzel zzelVarZzr = zzr(jSONArrayOptJSONArray.optJSONObject(i11));
            if (zzelVarZzr != null) {
                arrayList.add(zzelVarZzr);
            }
        }
        return zzgaa.zzj(arrayList);
    }

    private final com.google.android.gms.ads.internal.client.zzq zzk(int i11, int i12) {
        if (i11 == 0) {
            if (i12 == 0) {
                return com.google.android.gms.ads.internal.client.zzq.zzc();
            }
            i11 = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzq(this.zza, new AdSize(i11, i12));
    }

    private static s zzl(s sVar, Object obj) {
        final Object obj2 = null;
        return zzgen.zzf(sVar, Exception.class, new zzgdu(obj2) { // from class: com.google.android.gms.internal.ads.zzdqb
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzgen.zzh(null);
            }
        }, zzcep.zzf);
    }

    private static s zzm(boolean z11, final s sVar, Object obj) {
        return z11 ? zzgen.zzn(sVar, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdqc
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj2) {
                return obj2 != null ? sVar : zzgen.zzg(new zzeml(1, "Retrieve required value in native ad response failed."));
            }
        }, zzcep.zzf) : zzl(sVar, null);
    }

    private final s zzn(@Nullable JSONObject jSONObject, boolean z11) {
        if (jSONObject == null) {
            return zzgen.zzh(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzgen.zzh(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z11) {
            return zzgen.zzh(new zzbiz(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgen.zzm(this.zzb.zzb(strOptString, dOptDouble, zOptBoolean), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdpt
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return new zzbiz(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2);
            }
        }, this.zzg), null);
    }

    private final s zzo(@Nullable JSONArray jSONArray, boolean z11, boolean z12) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgen.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z12 ? jSONArray.length() : 1;
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i11), z11));
        }
        return zzgen.zzm(zzgen.zzd(arrayList), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdpy
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbiz zzbizVar : (List) obj) {
                    if (zzbizVar != null) {
                        arrayList2.add(zzbizVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final s zzp(JSONObject jSONObject, zzfgm zzfgmVar, zzfgp zzfgpVar) {
        final s sVarZzb = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfgmVar, zzfgpVar, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgen.zzn(sVarZzb, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdpu
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) throws zzeml {
                zzcjk zzcjkVar = (zzcjk) obj;
                if (zzcjkVar == null || zzcjkVar.zzq() == null) {
                    throw new zzeml(1, "Retrieve video view in html5 ad response failed.");
                }
                return sVarZzb;
            }
        }, zzcep.zzf);
    }

    @Nullable
    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(CampaignEx.JSON_KEY_AD_R), jSONObject2.getInt("g"), jSONObject2.getInt(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private static final com.google.android.gms.ads.internal.client.zzel zzr(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzel(strOptString, strOptString2);
    }

    public final /* synthetic */ zzbiw zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
        Integer numZzq = zzq(jSONObject, "bg_color");
        Integer numZzq2 = zzq(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzbiw(strOptString, list, numZzq, numZzq2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzh.zze, zOptBoolean);
    }

    public final /* synthetic */ s zzb(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfgm zzfgmVar, zzfgp zzfgpVar, String str, String str2, Object obj) throws Exception {
        zzcjk zzcjkVarZza = this.zzj.zza(zzqVar, zzfgmVar, zzfgpVar);
        final zzcet zzcetVarZza = zzcet.zza(zzcjkVarZza);
        zzdsc zzdscVarZzb = this.zzl.zzb();
        zzcjkVarZza.zzN().zzN(zzdscVarZzb, zzdscVarZzb, zzdscVarZzb, zzdscVarZzb, zzdscVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zza, null, null), null, null, this.zzp, this.zzo, this.zzm, this.zzn, null, zzdscVarZzb, null, null, null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdF)).booleanValue()) {
            zzcjkVarZza.zzae("/getNativeAdViewSignals", zzbnf.zzs);
        }
        zzcjkVarZza.zzae("/getNativeClickMeta", zzbnf.zzt);
        zzcjkVarZza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdpx
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z11, int i11, String str3, String str4) {
                zzcet zzcetVar = zzcetVarZza;
                if (z11) {
                    zzcetVar.zzb();
                    return;
                }
                zzcetVar.zzd(new zzeml(1, "Image Web View failed to load. Error code: " + i11 + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcjkVarZza.zzac(str, str2, null);
        return zzcetVarZza;
    }

    public final /* synthetic */ s zzc(String str, Object obj) throws Exception {
        com.google.android.gms.ads.internal.zzt.zzz();
        zzcjk zzcjkVarZza = zzcjx.zza(this.zza, zzcla.zza(), "native-omid", false, false, this.zzc, null, this.zzd, null, null, this.zze, this.zzf, null, null, this.zzq, this.zzr);
        final zzcet zzcetVarZza = zzcet.zza(zzcjkVarZza);
        zzcjkVarZza.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdpz
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z11, int i11, String str2, String str3) {
                zzcetVarZza.zzb();
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeX)).booleanValue()) {
            zzcjkVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zzcjkVarZza.loadData(str, "text/html", "UTF-8");
        }
        return zzcetVarZza;
    }

    public final s zzd(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return zzgen.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzm(jSONObjectOptJSONObject.optBoolean("require"), zzgen.zzm(zzo(jSONArrayOptJSONArray, false, true), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdqa
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return this.zza.zza(jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final s zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final s zzf(JSONObject jSONObject, String str) {
        zzbjb zzbjbVar = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbjbVar.zzb, zzbjbVar.zzd);
    }

    public final s zzg(JSONObject jSONObject, String str, final zzfgm zzfgmVar, final zzfgp zzfgpVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjK)).booleanValue()) {
            return zzgen.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgen.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzgen.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString("html");
        final com.google.android.gms.ads.internal.client.zzq zzqVarZzk = zzk(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzgen.zzh(null);
        }
        final s sVarZzn = zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdpv
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzb(zzqVarZzk, zzfgmVar, zzfgpVar, strOptString, strOptString2, obj);
            }
        }, zzcep.zze);
        return zzgen.zzn(sVarZzn, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdpw
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) throws zzeml {
                if (((zzcjk) obj) != null) {
                    return sVarZzn;
                }
                throw new zzeml(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzcep.zzf);
    }

    public final s zzh(JSONObject jSONObject, zzfgm zzfgmVar, zzfgp zzfgpVar) {
        s sVarZza;
        JSONObject jSONObjectZzg = com.google.android.gms.ads.internal.util.zzbw.zzg(jSONObject, "html_containers", "instream");
        if (jSONObjectZzg != null) {
            return zzp(jSONObjectZzg, zzfgmVar, zzfgpVar);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzgen.zzh(null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("vast_xml");
        boolean z11 = false;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjJ)).booleanValue() && jSONObjectOptJSONObject.has("html")) {
            z11 = true;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z11) {
                sVarZza = this.zzi.zza(jSONObjectOptJSONObject);
            }
            return zzl(zzgen.zzo(sVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdG)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z11) {
            zzcec.zzj("Required field 'vast_xml' or 'html' is missing");
            return zzgen.zzh(null);
        }
        sVarZza = zzp(jSONObjectOptJSONObject, zzfgmVar, zzfgpVar);
        return zzl(zzgen.zzo(sVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdG)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }
}
