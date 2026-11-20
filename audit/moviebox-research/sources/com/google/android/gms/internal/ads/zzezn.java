package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzezn implements zzexp {

    @Nullable
    final String zza;
    final int zzb;

    public zzezn(@Nullable String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (TextUtils.isEmpty(this.zza) || this.zzb == -1) {
            return;
        }
        try {
            JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.util.zzbw.zzf(jSONObject, "pii");
            jSONObjectZzf.put("pvid", this.zza);
            jSONObjectZzf.put("pvid_s", this.zzb);
        } catch (JSONException e11) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting gms core app set ID info.", e11);
        }
    }
}
