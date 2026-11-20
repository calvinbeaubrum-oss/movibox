package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetg implements zzexp {
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final float zzi;
    public final boolean zzj;

    public zzetg(int i11, boolean z11, boolean z12, int i12, int i13, int i14, int i15, int i16, float f11, boolean z13) {
        this.zza = i11;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = i12;
        this.zze = i13;
        this.zzf = i14;
        this.zzg = i15;
        this.zzh = i16;
        this.zzi = f11;
        this.zzj = z13;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zza);
        bundle.putBoolean("ma", this.zzb);
        bundle.putBoolean("sp", this.zzc);
        bundle.putInt("muv", this.zzd);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkv)).booleanValue()) {
            bundle.putInt("muv_min", this.zze);
            bundle.putInt("muv_max", this.zzf);
        }
        bundle.putInt("rm", this.zzg);
        bundle.putInt("riv", this.zzh);
        bundle.putFloat("android_app_volume", this.zzi);
        bundle.putBoolean("android_app_muted", this.zzj);
    }
}
