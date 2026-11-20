package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdmb implements zzhhd {
    private final zzdlz zza;

    public zzdmb(zzdlz zzdlzVar) {
        this.zza = zzdlzVar;
    }

    public final JSONObject zza() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhhl.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhhl.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }
}
