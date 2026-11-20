package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpx {
    private JSONObject zza;
    private final zzfqg zzb;

    public zzfpx(zzfqg zzfqgVar) {
        this.zzb = zzfqgVar;
    }

    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzfqh(this));
    }

    public final void zzc(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.zzb.zzb(new zzfqi(this, hashSet, jSONObject, j11));
    }

    public final void zzd(JSONObject jSONObject, HashSet hashSet, long j11) {
        this.zzb.zzb(new zzfqj(this, hashSet, jSONObject, j11));
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
