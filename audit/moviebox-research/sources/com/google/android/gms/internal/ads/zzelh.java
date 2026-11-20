package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelh implements zzelb {
    private final zzdlk zza;
    private final zzgey zzb;
    private final zzdpq zzc;
    private final zzfig zzd;
    private final zzdsf zze;

    public zzelh(zzdlk zzdlkVar, zzgey zzgeyVar, zzdpq zzdpqVar, zzfig zzfigVar, zzdsf zzdsfVar) {
        this.zza = zzdlkVar;
        this.zzb = zzgeyVar;
        this.zzc = zzdpqVar;
        this.zzd = zzfigVar;
        this.zze = zzdsfVar;
    }

    private final s zzg(final zzfgy zzfgyVar, final zzfgm zzfgmVar, final JSONObject jSONObject) {
        zzdpq zzdpqVar = this.zzc;
        final s sVarZza = this.zzd.zza();
        final s sVarZza2 = zzdpqVar.zza(zzfgyVar, zzfgmVar, jSONObject);
        return zzgen.zzc(sVarZza, sVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzelc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(sVarZza2, sVarZza, zzfgyVar, zzfgmVar, jSONObject);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final s zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        return zzgen.zzn(zzgen.zzn(this.zzd.zza(), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzele
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zze(zzfgmVar, (zzdrz) obj);
            }
        }, this.zzb), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzelf
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzf(zzfgyVar, zzfgmVar, (JSONArray) obj);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return (zzfgrVar == null || zzfgrVar.zzc == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzdmv zzc(s sVar, s sVar2, zzfgy zzfgyVar, zzfgm zzfgmVar, JSONObject jSONObject) throws Exception {
        zzdna zzdnaVar = (zzdna) sVar.get();
        zzdrz zzdrzVar = (zzdrz) sVar2.get();
        zzdnb zzdnbVarZzd = this.zza.zzd(new zzcwx(zzfgyVar, zzfgmVar, null), new zzdnm(zzdnaVar), new zzdlz(jSONObject, zzdrzVar));
        zzdnbVarZzd.zzh().zzb();
        zzdnbVarZzd.zzk().zza(zzdrzVar);
        zzdnbVarZzd.zzg().zza(zzdnaVar.zzs());
        zzdnbVarZzd.zzl().zza(this.zze);
        return zzdnbVarZzd.zza();
    }

    public final /* synthetic */ s zzd(zzdrz zzdrzVar, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgen.zzh(zzdrzVar));
        if (jSONObject.optBoolean("success")) {
            return zzgen.zzh(jSONObject.getJSONObject("json").getJSONArray(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS));
        }
        throw new zzbrm("process json failed");
    }

    public final /* synthetic */ s zze(zzfgm zzfgmVar, final zzdrz zzdrzVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziw)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfgmVar.zzt.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgen.zzn(zzdrzVar.zzd("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeld
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return this.zza.zzd(zzdrzVar, (JSONObject) obj);
            }
        }, this.zzb);
    }

    public final /* synthetic */ s zzf(zzfgy zzfgyVar, zzfgm zzfgmVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgen.zzg(new zzead(3));
        }
        if (zzfgyVar.zza.zza.zzk <= 1) {
            return zzgen.zzm(zzg(zzfgyVar, zzfgmVar, jSONArray.getJSONObject(0)), new zzfws() { // from class: com.google.android.gms.internal.ads.zzelg
                @Override // com.google.android.gms.internal.ads.zzfws
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzgen.zzh((zzdmv) obj));
                }
            }, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfgyVar.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfgyVar.zza.zza.zzk);
        for (int i11 = 0; i11 < zzfgyVar.zza.zza.zzk; i11++) {
            if (i11 < length) {
                arrayList.add(zzg(zzfgyVar, zzfgmVar, jSONArray.getJSONObject(i11)));
            } else {
                arrayList.add(zzgen.zzg(new zzead(3)));
            }
        }
        return zzgen.zzh(arrayList);
    }
}
