package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzad implements Iterator {
    final /* synthetic */ zzae zza;
    private int zzb = 0;

    public zzad(zzae zzaeVar) {
        this.zza = zzaeVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zza.zzc();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (this.zzb < this.zza.zzc()) {
            zzae zzaeVar = this.zza;
            int i11 = this.zzb;
            this.zzb = i11 + 1;
            return zzaeVar.zze(i11);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.zzb);
    }
}
