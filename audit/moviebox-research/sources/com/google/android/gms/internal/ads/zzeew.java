package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeew extends zzbyt {
    private final Context zza;
    private final zzeze zzb;
    private final zzezc zzc;
    private final zzefe zzd;
    private final zzgey zze;
    private final zzefb zzf;
    private final zzbzq zzg;

    public zzeew(Context context, zzeze zzezeVar, zzezc zzezcVar, zzefb zzefbVar, zzefe zzefeVar, zzgey zzgeyVar, zzbzq zzbzqVar) {
        this.zza = context;
        this.zzb = zzezeVar;
        this.zzc = zzezcVar;
        this.zzf = zzefbVar;
        this.zzd = zzefeVar;
        this.zze = zzgeyVar;
        this.zzg = zzbzqVar;
    }

    private final void zzc(s sVar, zzbyx zzbyxVar) {
        zzgen.zzr(zzgen.zzn(zzgee.zzu(sVar), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeet
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzh(zzfii.zza((InputStream) obj));
            }
        }, zzcep.zza), new zzeev(this, zzbyxVar), zzcep.zzf);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00a5  */
    public final s zzb(zzbym zzbymVar, int i11) {
        s sVarZzh;
        HashMap map = new HashMap();
        Bundle bundle = zzbymVar.zzc;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    map.put(str, string);
                }
            }
        }
        final zzeey zzeeyVar = new zzeey(zzbymVar.zza, zzbymVar.zzb, map, zzbymVar.zzd, "", zzbymVar.zze);
        zzezc zzezcVar = this.zzc;
        zzezcVar.zza(new zzfak(zzbymVar));
        boolean z11 = zzeeyVar.zzf;
        zzezd zzezdVarZzb = zzezcVar.zzb();
        if (z11) {
            String str2 = zzbymVar.zza;
            String str3 = (String) zzbih.zzb.zze();
            if (TextUtils.isEmpty(str3)) {
                sVarZzh = zzgen.zzh(zzeeyVar);
            } else {
                String host = Uri.parse(str2).getHost();
                if (TextUtils.isEmpty(host)) {
                    sVarZzh = zzgen.zzh(zzeeyVar);
                } else {
                    Iterator it = zzfxr.zzc(zzfwp.zzc(';')).zzd(str3).iterator();
                    while (it.hasNext()) {
                        if (host.endsWith((String) it.next())) {
                            sVarZzh = zzgen.zzm(zzezdVarZzb.zza().zza(new JSONObject()), new zzfws() { // from class: com.google.android.gms.internal.ads.zzeeo
                                @Override // com.google.android.gms.internal.ads.zzfws
                                public final Object apply(Object obj) {
                                    zzeey zzeeyVar2 = zzeeyVar;
                                    zzefe.zza(zzeeyVar2.zzc, (JSONObject) obj);
                                    return zzeeyVar2;
                                }
                            }, this.zze);
                        }
                    }
                    sVarZzh = zzgen.zzh(zzeeyVar);
                }
            }
        } else {
            sVarZzh = zzgen.zzh(zzeeyVar);
        }
        zzflm zzflmVarZzb = zzezdVarZzb.zzb();
        return zzgen.zzn(zzflmVarZzb.zzb(zzflg.HTTP, sVarZzh).zze(new zzefa(this.zza, "", this.zzg, i11)).zza(), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeep
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) throws JSONException {
                zzeez zzeezVar = (zzeez) obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("response", zzeezVar.zza);
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str4 : zzeezVar.zzb.keySet()) {
                        if (str4 != null) {
                            List<String> list = (List) zzeezVar.zzb.get(str4);
                            JSONArray jSONArray = new JSONArray();
                            for (String str5 : list) {
                                if (str5 != null) {
                                    jSONArray.put(str5);
                                }
                            }
                            jSONObject2.put(str4, jSONArray);
                        }
                    }
                    jSONObject.put("headers", jSONObject2);
                    Object obj2 = zzeezVar.zzc;
                    if (obj2 != null) {
                        jSONObject.put(TtmlNode.TAG_BODY, obj2);
                    }
                    jSONObject.put("latency", zzeezVar.zzd);
                    return zzgen.zzh(new ByteArrayInputStream(jSONObject.toString().getBytes(StandardCharsets.UTF_8)));
                } catch (JSONException e11) {
                    zzcec.zzj("Error converting response to JSONObject: ".concat(String.valueOf(e11.getMessage())));
                    throw new JSONException("Parsing HTTP Response: ".concat(String.valueOf(e11.getCause())));
                }
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zze(zzbym zzbymVar, zzbyx zzbyxVar) {
        zzc(zzb(zzbymVar, Binder.getCallingUid()), zzbyxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzf(zzbyi zzbyiVar, zzbyx zzbyxVar) {
        zzeyt zzeytVar = new zzeyt(zzbyiVar, Binder.getCallingUid());
        zzeze zzezeVar = this.zzb;
        zzezeVar.zza(zzeytVar);
        final zzezf zzezfVarZzb = zzezeVar.zzb();
        zzflm zzflmVarZzb = zzezfVarZzb.zzb();
        zzfkr zzfkrVarZza = zzflmVarZzb.zzb(zzflg.GMS_SIGNALS, zzgen.zzi()).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzees
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzezfVarZzb.zza().zza(new JSONObject());
            }
        }).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzeer
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("GMS AdRequest Signals: ");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final s zza(Object obj) {
                return zzgen.zzh(new ByteArrayInputStream(((JSONObject) obj).toString().getBytes(StandardCharsets.UTF_8)));
            }
        }).zza();
        zzc(zzfkrVarZza, zzbyxVar);
        if (((Boolean) zzbia.zzd.zze()).booleanValue()) {
            final zzefe zzefeVar = this.zzd;
            Objects.requireNonNull(zzefeVar);
            zzfkrVarZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeeu
                @Override // java.lang.Runnable
                public final void run() {
                    zzefeVar.zzb();
                }
            }, this.zze);
        }
    }
}
