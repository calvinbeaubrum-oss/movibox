package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzvr {
    public final int zza;
    public final boolean zzb;

    public zzvr(int i11, boolean z11) {
        this.zza = i11;
        this.zzb = z11;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvr.class == obj.getClass()) {
            zzvr zzvrVar = (zzvr) obj;
            if (this.zza == zzvrVar.zza && this.zzb == zzvrVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
