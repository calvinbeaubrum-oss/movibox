package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadv {
    public static final zzadv zza = new zzadv(0, 0);
    public final long zzb;
    public final long zzc;

    public zzadv(long j11, long j12) {
        this.zzb = j11;
        this.zzc = j12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadv.class == obj.getClass()) {
            zzadv zzadvVar = (zzadv) obj;
            if (this.zzb == zzadvVar.zzb && this.zzc == zzadvVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        return "[timeUs=" + this.zzb + ", position=" + this.zzc + "]";
    }
}
