package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfq {
    public static final zzfq zza = new zzfq(-1, -1);
    public static final zzfq zzb = new zzfq(0, 0);
    private final int zzc;
    private final int zzd;

    public zzfq(int i11, int i12) {
        boolean z11 = false;
        if ((i11 == -1 || i11 >= 0) && (i12 == -1 || i12 >= 0)) {
            z11 = true;
        }
        zzek.zzd(z11);
        this.zzc = i11;
        this.zzd = i12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfq) {
            zzfq zzfqVar = (zzfq) obj;
            if (this.zzc == zzfqVar.zzc && this.zzd == zzfqVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzc;
        return ((i11 >>> 16) | (i11 << 16)) ^ this.zzd;
    }

    public final String toString() {
        return this.zzc + "x" + this.zzd;
    }

    public final int zza() {
        return this.zzd;
    }

    public final int zzb() {
        return this.zzc;
    }
}
