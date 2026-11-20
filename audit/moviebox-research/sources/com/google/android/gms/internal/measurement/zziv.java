package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zziv extends zzix {
    final /* synthetic */ zzje zza;
    private int zzb = 0;
    private final int zzc;

    public zziv(zzje zzjeVar) {
        this.zza = zzjeVar;
        this.zzc = zzjeVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zziz
    public final byte zza() {
        int i11 = this.zzb;
        if (i11 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i11 + 1;
        return this.zza.zzb(i11);
    }
}
