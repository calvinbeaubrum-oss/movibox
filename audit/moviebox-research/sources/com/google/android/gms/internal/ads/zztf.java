package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zztf {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zztf(String str, boolean z11, boolean z12) {
        this.zza = str;
        this.zzb = z11;
        this.zzc = z12;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zztf.class) {
            zztf zztfVar = (zztf) obj;
            if (TextUtils.equals(this.zza, zztfVar.zza) && this.zzb == zztfVar.zzb && this.zzc == zztfVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() + 31) * 31) + (true != this.zzb ? 1237 : 1231)) * 31) + (true != this.zzc ? 1237 : 1231);
    }
}
