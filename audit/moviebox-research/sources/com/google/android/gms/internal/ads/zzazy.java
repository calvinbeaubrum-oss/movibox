package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazy {
    final long zza;
    final String zzb;
    final int zzc;

    public zzazy(long j11, String str, int i11) {
        this.zza = j11;
        this.zzb = str;
        this.zzc = i11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzazy)) {
            zzazy zzazyVar = (zzazy) obj;
            if (zzazyVar.zza == this.zza && zzazyVar.zzc == this.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
