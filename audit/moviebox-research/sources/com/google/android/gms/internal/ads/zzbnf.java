package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.util.concurrent.s;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbnf {
    public static final zzbng zza = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmd
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckn zzcknVar = (zzckn) obj;
            zzbng zzbngVar = zzbnf.zza;
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzcec.zzj("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(",");
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzcknVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                boolean z11 = true;
                if (packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) == null) {
                    z11 = false;
                }
                Boolean boolValueOf = Boolean.valueOf(z11);
                map2.put(str2, boolValueOf);
                com.google.android.gms.ads.internal.util.zze.zza("/canOpenURLs;" + str2 + ";" + boolValueOf);
            }
            ((zzbqa) zzcknVar).zzd("openableURLs", map2);
        }
    };
    public static final zzbng zzb = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmf
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckn zzcknVar = (zzckn) obj;
            zzbng zzbngVar = zzbnf.zza;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzid)).booleanValue()) {
                zzcec.zzj("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get("package_name");
            if (TextUtils.isEmpty(str)) {
                zzcec.zzj("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap map2 = new HashMap();
            Boolean boolValueOf = Boolean.valueOf(zzcknVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
            map2.put(str, boolValueOf);
            com.google.android.gms.ads.internal.util.zze.zza("/canOpenApp;" + str + ";" + boolValueOf);
            ((zzbqa) zzcknVar).zzd("openableApp", map2);
        }
    };
    public static final zzbng zzc = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmi
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzbnf.zzb((zzckn) obj, map);
        }
    };
    public static final zzbng zzd = new zzbmx();
    public static final zzbng zze = new zzbmy();
    public static final zzbng zzf = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmj
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckn zzcknVar = (zzckn) obj;
            zzbng zzbngVar = zzbnf.zza;
            String str = (String) map.get("u");
            if (str == null) {
                zzcec.zzj("URL missing from httpTrack GMSG.");
            } else {
                new com.google.android.gms.ads.internal.util.zzca(zzcknVar.getContext(), ((zzcku) zzcknVar).zzn().zza, str).zzb();
            }
        }
    };
    public static final zzbng zzg = new zzbmz();
    public static final zzbng zzh = new zzbna();
    public static final zzbng zzi = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbmh
        @Override // com.google.android.gms.internal.ads.zzbng
        public final void zza(Object obj, Map map) {
            zzckt zzcktVar = (zzckt) obj;
            zzbng zzbngVar = zzbnf.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int i11 = Integer.parseInt(str);
                int i12 = Integer.parseInt(str2);
                int i13 = Integer.parseInt(str3);
                zzavi zzaviVarZzI = zzcktVar.zzI();
                if (zzaviVarZzI != null) {
                    zzaviVarZzI.zzc().zzl(i11, i12, i13);
                }
            } catch (NumberFormatException unused) {
                zzcec.zzj("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbng zzj = new zzbnb();
    public static final zzbng zzk = new zzbnc();
    public static final zzbng zzl = new zzchk();
    public static final zzbng zzm = new zzchl();
    public static final zzbng zzn = new zzblz();
    public static final zzbnv zzo = new zzbnv();
    public static final zzbng zzp = new zzbnd();
    public static final zzbng zzq = new zzbne();
    public static final zzbng zzr = new zzbmk();
    public static final zzbng zzs = new zzbml();
    public static final zzbng zzt = new zzbmm();
    public static final zzbng zzu = new zzbmn();
    public static final zzbng zzv = new zzbmo();
    public static final zzbng zzw = new zzbmp();
    public static final zzbng zzx = new zzbmq();
    public static final zzbng zzy = new zzbmr();
    public static final zzbng zzz = new zzbms();
    public static final zzbng zzA = new zzbmt();
    public static final zzbng zzB = new zzbmv();
    public static final zzbng zzC = new zzbmw();

    public static s zza(zzcjk zzcjkVar, String str) {
        Uri uriZza = Uri.parse(str);
        try {
            zzavi zzaviVarZzI = zzcjkVar.zzI();
            zzfhl zzfhlVarZzQ = zzcjkVar.zzQ();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || zzfhlVarZzQ == null) {
                if (zzaviVarZzI != null && zzaviVarZzI.zzf(uriZza)) {
                    uriZza = zzaviVarZzI.zza(uriZza, zzcjkVar.getContext(), zzcjkVar.zzF(), zzcjkVar.zzi());
                }
            } else if (zzaviVarZzI != null && zzaviVarZzI.zzf(uriZza)) {
                uriZza = zzfhlVarZzQ.zza(uriZza, zzcjkVar.getContext(), zzcjkVar.zzF(), zzcjkVar.zzi());
            }
        } catch (zzavj unused) {
            zzcec.zzj("Unable to append parameter to URL: ".concat(str));
        }
        final String strZzb = zzccj.zzb(uriZza, zzcjkVar.getContext());
        long jLongValue = ((Long) zzbhz.zze.zze()).longValue();
        if (jLongValue <= 0 || jLongValue > 240304702) {
            return zzgen.zzh(strZzb);
        }
        zzgee zzgeeVarZzu = zzgee.zzu(zzcjkVar.zzS());
        zzbma zzbmaVar = new zzfws() { // from class: com.google.android.gms.internal.ads.zzbma
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                Throwable th2 = (Throwable) obj;
                zzbng zzbngVar = zzbnf.zza;
                if (!((Boolean) zzbhz.zzk.zze()).booleanValue()) {
                    return "failure_click_attok";
                }
                com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "prepareClickUrl.attestation1");
                return "failure_click_attok";
            }
        };
        zzgey zzgeyVar = zzcep.zzf;
        return zzgen.zze(zzgen.zzm(zzgen.zze(zzgeeVarZzu, Throwable.class, zzbmaVar, zzgeyVar), new zzfws() { // from class: com.google.android.gms.internal.ads.zzbmb
            /* JADX WARN: Code duplicated, block: B:16:0x004f  */
            /* JADX WARN: Code duplicated, block: B:19:0x0059  */
            /* JADX WARN: Code duplicated, block: B:21:0x0067  */
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                String str2;
                String str3;
                Uri uri;
                String str4 = (String) obj;
                zzbng zzbngVar = zzbnf.zza;
                String strReplace = strZzb;
                if (str4 != null) {
                    if (((Boolean) zzbhz.zzf.zze()).booleanValue()) {
                        String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                        String host = Uri.parse(strReplace).getHost();
                        for (int i11 = 0; i11 < 3; i11++) {
                            if (host.endsWith(strArr[i11])) {
                                str2 = (String) zzbhz.zza.zze();
                                str3 = (String) zzbhz.zzb.zze();
                                if (!TextUtils.isEmpty(str2)) {
                                    strReplace = strReplace.replace(str2, str4);
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    uri = Uri.parse(strReplace);
                                    if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                        break;
                                    }
                                    return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                                }
                                break;
                            }
                        }
                    } else {
                        str2 = (String) zzbhz.zza.zze();
                        str3 = (String) zzbhz.zzb.zze();
                        if (!TextUtils.isEmpty(str2)) {
                            strReplace = strReplace.replace(str2, str4);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            uri = Uri.parse(strReplace);
                            if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                            }
                        }
                    }
                }
                return strReplace;
            }
        }, zzgeyVar), Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzbmc
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                Throwable th2 = (Throwable) obj;
                zzbng zzbngVar = zzbnf.zza;
                if (((Boolean) zzbhz.zzk.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzgeyVar);
    }

    public static /* synthetic */ void zzb(zzckn zzcknVar, Map map) {
        Intent uri;
        PackageManager packageManager = zzcknVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString("u");
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString(TtmlNode.TAG_P);
                        String strOptString6 = jSONObject2.optString("c");
                        String strOptString7 = jSONObject2.optString("intent_url");
                        ResolveInfo resolveInfoResolveActivity = null;
                        if (TextUtils.isEmpty(strOptString7)) {
                            uri = null;
                        } else {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e11) {
                                zzcec.zzh("Error parsing the url: ".concat(String.valueOf(strOptString7)), e11);
                                uri = null;
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split("/", 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        Intent intent = uri;
                        try {
                            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
                        } catch (NullPointerException e12) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzw(e12, intent.toString());
                        }
                        try {
                            jSONObject.put(strOptString, resolveInfoResolveActivity != null);
                        } catch (JSONException e13) {
                            zzcec.zzh("Error constructing openable urls response.", e13);
                        }
                    } catch (JSONException e14) {
                        zzcec.zzh("Error parsing the intent data.", e14);
                    }
                }
                ((zzbqa) zzcknVar).zze("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzbqa) zzcknVar).zze("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzbqa) zzcknVar).zze("openableIntents", new JSONObject());
        }
    }

    public static void zzc(Map map, zzdiu zzdiuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkl)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzdiuVar != null) {
            zzdiuVar.zzs();
        }
    }
}
