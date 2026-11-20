package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbfu {
    private final int zza;
    private final String zzb;
    private final Object zzc;

    public /* synthetic */ zzbfu(int i11, String str, Object obj, zzbft zzbftVar) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = obj;
        com.google.android.gms.ads.internal.client.zzba.zza().zzd(this);
    }

    public static zzbfu zzf(int i11, String str, float f11) {
        return new zzbfr(1, str, Float.valueOf(f11));
    }

    public static zzbfu zzg(int i11, String str, int i12) {
        return new zzbfp(1, str, Integer.valueOf(i12));
    }

    public static zzbfu zzh(int i11, String str, long j11) {
        return new zzbfq(1, str, Long.valueOf(j11));
    }

    public static zzbfu zzi(int i11, String str, Boolean bool) {
        return new zzbfo(i11, str, bool);
    }

    public static zzbfu zzj(int i11, String str, String str2) {
        return new zzbfs(1, str, str2);
    }

    public static zzbfu zzk(int i11, String str) {
        zzbfu zzbfuVarZzj = zzj(1, "gads:sdk_core_constants:experiment_id", null);
        com.google.android.gms.ads.internal.client.zzba.zza().zzc(zzbfuVarZzj);
        return zzbfuVarZzj;
    }

    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzl() {
        return com.google.android.gms.ads.internal.client.zzba.zzc().zza(this);
    }

    public final Object zzm() {
        return this.zzc;
    }

    public final String zzn() {
        return this.zzb;
    }
}
