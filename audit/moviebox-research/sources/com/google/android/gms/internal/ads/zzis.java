package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzis {
    public final String zza;
    public final zzam zzb;
    public final zzam zzc;
    public final int zzd;
    public final int zze;

    public zzis(String str, zzam zzamVar, zzam zzamVar2, int i11, int i12) {
        boolean z11 = true;
        if (i11 != 0) {
            if (i12 == 0) {
                i12 = 0;
            } else {
                z11 = false;
            }
        }
        zzek.zzd(z11);
        zzek.zzc(str);
        this.zza = str;
        this.zzb = zzamVar;
        zzamVar2.getClass();
        this.zzc = zzamVar2;
        this.zzd = i11;
        this.zze = i12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzis.class == obj.getClass()) {
            zzis zzisVar = (zzis) obj;
            if (this.zzd == zzisVar.zzd && this.zze == zzisVar.zze && this.zza.equals(zzisVar.zza) && this.zzb.equals(zzisVar.zzb) && this.zzc.equals(zzisVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
