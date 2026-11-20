package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzan implements zzd {
    private final Application zza;
    private final zzap zzb;
    private final Executor zzc;

    public zzan(Application application, zzap zzapVar, Executor executor) {
        this.zza = application;
        this.zzb = zzapVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        return this.zzc;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final boolean zzb(String str, JSONObject jSONObject) {
        byte b11;
        int iHashCode = str.hashCode();
        if (iHashCode != 94746189) {
            if (iHashCode == 113399775 && str.equals("write")) {
                b11 = 0;
            } else {
                b11 = -1;
            }
        } else if (str.equals("clear")) {
            b11 = 1;
        } else {
            b11 = -1;
        }
        if (b11 == 0) {
            zzcn zzcnVar = new zzcn(this.zza);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                String strValueOf = String.valueOf(objOpt);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Writing to storage: [");
                sb2.append(next);
                sb2.append("] ");
                sb2.append(strValueOf);
                if (zzcnVar.zzc(next, objOpt)) {
                    this.zzb.zzd().add(next);
                } else {
                    "Failed writing key: ".concat(String.valueOf(next));
                }
            }
            this.zzb.zzf();
            zzcnVar.zzb();
            return true;
        }
        if (b11 != 1) {
            return false;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keys");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            "Action[clear]: wrong args.".concat(String.valueOf(jSONObject.toString()));
        } else {
            HashSet hashSet = new HashSet();
            int length = jSONArrayOptJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                String strOptString = jSONArrayOptJSONArray.optString(i11);
                if (TextUtils.isEmpty(strOptString)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Action[clear]: empty key at index: ");
                    sb3.append(i11);
                } else {
                    hashSet.add(strOptString);
                }
            }
            zzco.zzb(this.zza, hashSet);
        }
        return true;
    }
}
