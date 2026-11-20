package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzah {
    private final SparseBooleanArray zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        if (zzfy.zza >= 24) {
            return this.zza.equals(zzahVar.zza);
        }
        if (this.zza.size() != zzahVar.zza.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            if (zza(i11) != zzahVar.zza(i11)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (zzfy.zza >= 24) {
            return this.zza.hashCode();
        }
        int size = this.zza.size();
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            size = (size * 31) + zza(i11);
        }
        return size;
    }

    public final int zza(int i11) {
        zzek.zza(i11, 0, this.zza.size());
        return this.zza.keyAt(i11);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final boolean zzc(int i11) {
        return this.zza.get(i11);
    }
}
