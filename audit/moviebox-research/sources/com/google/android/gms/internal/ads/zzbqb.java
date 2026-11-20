package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzbqb {
    public static void zza(zzbqc zzbqcVar, String str, Map map) {
        try {
            zzbqcVar.zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzcec.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbqc zzbqcVar, String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb2.append(str);
        sb2.append("',");
        sb2.append(string);
        sb2.append(");");
        zzcec.zze("Dispatching AFMA event: ".concat(sb2.toString()));
        zzbqcVar.zza(sb2.toString());
    }

    public static void zzc(zzbqc zzbqcVar, String str, String str2) {
        zzbqcVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbqc zzbqcVar, String str, JSONObject jSONObject) {
        zzbqcVar.zzb(str, jSONObject.toString());
    }
}
