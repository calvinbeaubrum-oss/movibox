package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdpq {
    private final zzgey zza;
    private final zzdqd zzb;
    private final zzdqi zzc;

    public zzdpq(zzgey zzgeyVar, zzdqd zzdqdVar, zzdqi zzdqiVar) {
        this.zza = zzgeyVar;
        this.zzb = zzdqdVar;
        this.zzc = zzdqiVar;
    }

    public final s zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        s sVarZzn;
        final s sVarZzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdpo
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzeml {
                zzdna zzdnaVar = new zzdna();
                JSONObject jSONObject2 = jSONObject;
                zzdnaVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdnaVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null;
                zzfgy zzfgyVar2 = zzfgyVar;
                zzdnaVar.zzV(strOptString);
                zzfhh zzfhhVar = zzfgyVar2.zza.zza;
                if (!zzfhhVar.zzg.contains(Integer.toString(zzdnaVar.zzc()))) {
                    throw new zzeml(1, "Invalid template ID: " + zzdnaVar.zzc());
                }
                if (zzdnaVar.zzc() == 3) {
                    if (zzdnaVar.zzA() == null) {
                        throw new zzeml(1, "No custom template id for custom template ad response.");
                    }
                    if (!zzfhhVar.zzh.contains(zzdnaVar.zzA())) {
                        throw new zzeml(1, "Unexpected custom template id in the response.");
                    }
                }
                zzfgm zzfgmVar2 = zzfgmVar;
                zzdnaVar.zzY(jSONObject2.optDouble(CampaignEx.JSON_KEY_STAR, -1.0d));
                String strOptString2 = jSONObject2.optString("headline", null);
                if (zzfgmVar2.zzN) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    strOptString2 = com.google.android.gms.ads.internal.util.zzt.zzx() + " : " + strOptString2;
                }
                zzdnaVar.zzZ("headline", strOptString2);
                zzdnaVar.zzZ(TtmlNode.TAG_BODY, jSONObject2.optString(TtmlNode.TAG_BODY, null));
                zzdnaVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                zzdnaVar.zzZ(PlaceTypes.STORE, jSONObject2.optString(PlaceTypes.STORE, null));
                zzdnaVar.zzZ(BidResponsed.KEY_PRICE, jSONObject2.optString(BidResponsed.KEY_PRICE, null));
                zzdnaVar.zzZ("advertiser", jSONObject2.optString("advertiser", null));
                return zzdnaVar;
            }
        });
        final s sVarZzf = this.zzb.zzf(jSONObject, "images");
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        zzdqd zzdqdVar = this.zzb;
        final s sVarZzg = zzdqdVar.zzg(jSONObject, "images", zzfgmVar, zzfgpVar);
        final s sVarZze = zzdqdVar.zze(jSONObject, "secondary_image");
        final s sVarZze2 = zzdqdVar.zze(jSONObject, "app_icon");
        final s sVarZzd = zzdqdVar.zzd(jSONObject, "attribution");
        final s sVarZzh = this.zzb.zzh(jSONObject, zzfgmVar, zzfgyVar.zzb.zzb);
        final s sVarZza = this.zzc.zza(jSONObject, "custom_assets");
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            if (TextUtils.isEmpty(strOptString)) {
                sVarZzn = zzgen.zzh(null);
            } else {
                final zzdqd zzdqdVar2 = this.zzb;
                sVarZzn = zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdps
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final s zza(Object obj) {
                        return zzdqdVar2.zzc(strOptString, obj);
                    }
                }, zzcep.zze);
            }
        } else {
            sVarZzn = zzgen.zzh(null);
        }
        final s sVar = sVarZzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(sVarZzb);
        arrayList.add(sVarZzf);
        arrayList.add(sVarZzg);
        arrayList.add(sVarZze);
        arrayList.add(sVarZze2);
        arrayList.add(sVarZzd);
        arrayList.add(sVarZzh);
        arrayList.add(sVarZza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
            arrayList.add(sVar);
        }
        return zzgen.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdpp
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdna zzdnaVar = (zzdna) sVarZzb.get();
                zzdnaVar.zzP((List) sVarZzf.get());
                zzdnaVar.zzM((zzbjm) sVarZze2.get());
                zzdnaVar.zzQ((zzbjm) sVarZze.get());
                zzdnaVar.zzJ((zzbjf) sVarZzd.get());
                JSONObject jSONObject2 = jSONObject;
                zzdnaVar.zzS(zzdqd.zzj(jSONObject2));
                zzdnaVar.zzL(zzdqd.zzi(jSONObject2));
                zzcjk zzcjkVar = (zzcjk) sVarZzh.get();
                if (zzcjkVar != null) {
                    zzdnaVar.zzad(zzcjkVar);
                    zzdnaVar.zzac(zzcjkVar.zzF());
                    zzdnaVar.zzab(zzcjkVar.zzq());
                }
                zzcjk zzcjkVar2 = (zzcjk) sVarZzg.get();
                if (zzcjkVar2 != null) {
                    zzdnaVar.zzO(zzcjkVar2);
                    zzdnaVar.zzae(zzcjkVar2.zzF());
                }
                s sVar2 = sVar;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
                    zzdnaVar.zzU(sVar2);
                    zzdnaVar.zzX(new zzceu());
                } else {
                    zzcjk zzcjkVar3 = (zzcjk) sVar2.get();
                    if (zzcjkVar3 != null) {
                        zzdnaVar.zzT(zzcjkVar3);
                    }
                }
                for (zzdqh zzdqhVar : (List) sVarZza.get()) {
                    if (zzdqhVar.zza != 1) {
                        zzdnaVar.zzN(zzdqhVar.zzb, zzdqhVar.zzd);
                    } else {
                        zzdnaVar.zzZ(zzdqhVar.zzb, zzdqhVar.zzc);
                    }
                }
                return zzdnaVar;
            }
        }, this.zza);
    }
}
