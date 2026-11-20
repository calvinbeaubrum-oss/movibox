package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwz {
    public final boolean zza;
    public final String zzb;

    public zzbwz(boolean z11, String str) {
        this.zza = z11;
        this.zzb = str;
    }

    @Nullable
    public static zzbwz zza(JSONObject jSONObject) {
        return new zzbwz(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
