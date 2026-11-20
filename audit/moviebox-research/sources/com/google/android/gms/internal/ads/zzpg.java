package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpg {
    public static final zzpg zza = new zzpe().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public /* synthetic */ zzpg(zzpe zzpeVar, zzpf zzpfVar) {
        this.zzb = zzpeVar.zza;
        this.zzc = zzpeVar.zzb;
        this.zzd = zzpeVar.zzc;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzpg.class == obj.getClass()) {
            zzpg zzpgVar = (zzpg) obj;
            if (this.zzb == zzpgVar.zzb && this.zzc == zzpgVar.zzc && this.zzd == zzpgVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z11 = this.zzb;
        boolean z12 = this.zzc;
        return ((z11 ? 1 : 0) << 2) + (z12 ? 1 : 0) + (z12 ? 1 : 0) + (this.zzd ? 1 : 0);
    }
}
