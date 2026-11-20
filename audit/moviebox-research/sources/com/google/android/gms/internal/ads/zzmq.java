package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmq {
    public final long zza;
    public final zzcx zzb;
    public final int zzc;

    @Nullable
    public final zzur zzd;
    public final long zze;
    public final zzcx zzf;
    public final int zzg;

    @Nullable
    public final zzur zzh;
    public final long zzi;
    public final long zzj;

    public zzmq(long j11, zzcx zzcxVar, int i11, @Nullable zzur zzurVar, long j12, zzcx zzcxVar2, int i12, @Nullable zzur zzurVar2, long j13, long j14) {
        this.zza = j11;
        this.zzb = zzcxVar;
        this.zzc = i11;
        this.zzd = zzurVar;
        this.zze = j12;
        this.zzf = zzcxVar2;
        this.zzg = i12;
        this.zzh = zzurVar2;
        this.zzi = j13;
        this.zzj = j14;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmq.class == obj.getClass()) {
            zzmq zzmqVar = (zzmq) obj;
            if (this.zza == zzmqVar.zza && this.zzc == zzmqVar.zzc && this.zze == zzmqVar.zze && this.zzg == zzmqVar.zzg && this.zzi == zzmqVar.zzi && this.zzj == zzmqVar.zzj && zzfwy.zza(this.zzb, zzmqVar.zzb) && zzfwy.zza(this.zzd, zzmqVar.zzd) && zzfwy.zza(this.zzf, zzmqVar.zzf) && zzfwy.zza(this.zzh, zzmqVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
