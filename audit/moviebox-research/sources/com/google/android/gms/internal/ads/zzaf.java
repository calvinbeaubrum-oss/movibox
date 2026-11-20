package com.google.android.gms.internal.ads;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaf {
    private final SparseBooleanArray zza = new SparseBooleanArray();
    private boolean zzb;

    public final zzaf zza(int i11) {
        zzek.zzf(!this.zzb);
        this.zza.append(i11, true);
        return this;
    }

    public final zzah zzb() {
        zzek.zzf(!this.zzb);
        this.zzb = true;
        return new zzah(this.zza, null);
    }
}
