package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlj {
    public final zzur zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    public zzlj(zzur zzurVar, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = true;
        zzek.zzd(!z14 || z12);
        if (z13 && !z12) {
            z15 = false;
        }
        zzek.zzd(z15);
        this.zza = zzurVar;
        this.zzb = j11;
        this.zzc = j12;
        this.zzd = j13;
        this.zze = j14;
        this.zzf = false;
        this.zzg = z12;
        this.zzh = z13;
        this.zzi = z14;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlj.class == obj.getClass()) {
            zzlj zzljVar = (zzlj) obj;
            if (this.zzb == zzljVar.zzb && this.zzc == zzljVar.zzc && this.zzd == zzljVar.zzd && this.zze == zzljVar.zze && this.zzg == zzljVar.zzg && this.zzh == zzljVar.zzh && this.zzi == zzljVar.zzi && zzfy.zzF(this.zza, zzljVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        long j11 = this.zze;
        long j12 = this.zzd;
        return (((((((((((((iHashCode * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) j12)) * 31) + ((int) j11)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzlj zza(long j11) {
        return j11 == this.zzc ? this : new zzlj(this.zza, this.zzb, j11, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzlj zzb(long j11) {
        return j11 == this.zzb ? this : new zzlj(this.zza, j11, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
