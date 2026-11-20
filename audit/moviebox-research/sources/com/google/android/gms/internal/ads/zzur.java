package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzur {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzur(Object obj, int i11, int i12, long j11) {
        this(obj, i11, i12, j11, -1);
    }

    private zzur(Object obj, int i11, int i12, long j11, int i13) {
        this.zza = obj;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = j11;
        this.zze = i13;
    }

    public zzur(Object obj, long j11) {
        this(obj, -1, -1, j11, -1);
    }

    public zzur(Object obj, long j11, int i11) {
        this(obj, -1, -1, j11, i11);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzur)) {
            return false;
        }
        zzur zzurVar = (zzur) obj;
        return this.zza.equals(zzurVar.zza) && this.zzb == zzurVar.zzb && this.zzc == zzurVar.zzc && this.zzd == zzurVar.zzd && this.zze == zzurVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzur zza(Object obj) {
        return this.zza.equals(obj) ? this : new zzur(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }
}
