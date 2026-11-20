package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwx {
    public final long zza;
    public final long zzb;

    public zzwx(long j11, long j12) {
        this.zza = j11;
        this.zzb = j12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwx)) {
            return false;
        }
        zzwx zzwxVar = (zzwx) obj;
        return this.zza == zzwxVar.zza && this.zzb == zzwxVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
