package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmr {
    private final zzah zza;
    private final SparseArray zzb;

    public zzmr(zzah zzahVar, SparseArray sparseArray) {
        this.zza = zzahVar;
        SparseArray sparseArray2 = new SparseArray(zzahVar.zzb());
        for (int i11 = 0; i11 < zzahVar.zzb(); i11++) {
            int iZza = zzahVar.zza(i11);
            zzmq zzmqVar = (zzmq) sparseArray.get(iZza);
            zzmqVar.getClass();
            sparseArray2.append(iZza, zzmqVar);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i11) {
        return this.zza.zza(i11);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzmq zzc(int i11) {
        zzmq zzmqVar = (zzmq) this.zzb.get(i11);
        zzmqVar.getClass();
        return zzmqVar;
    }

    public final boolean zzd(int i11) {
        return this.zza.zzc(i11);
    }
}
