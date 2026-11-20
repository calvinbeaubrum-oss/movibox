package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadz {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzadz(int i11, byte[] bArr, int i12, int i13) {
        this.zza = i11;
        this.zzb = bArr;
        this.zzc = i12;
        this.zzd = i13;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadz.class == obj.getClass()) {
            zzadz zzadzVar = (zzadz) obj;
            if (this.zza == zzadzVar.zza && this.zzc == zzadzVar.zzc && this.zzd == zzadzVar.zzd && Arrays.equals(this.zzb, zzadzVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
