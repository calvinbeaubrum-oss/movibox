package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeys implements zzexp {
    private final String zza;

    public zzeys(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zza);
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e11);
        }
    }
}
