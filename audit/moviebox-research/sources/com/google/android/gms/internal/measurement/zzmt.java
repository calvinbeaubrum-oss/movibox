package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmt extends AbstractList implements RandomAccess, zzku {
    private final zzku zza;

    public zzmt(zzku zzkuVar) {
        this.zza = zzkuVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i11) {
        return ((zzkt) this.zza).get(i11);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzms(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i11) {
        return new zzmr(this, i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final zzku zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final Object zzf(int i11) {
        return this.zza.zzf(i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final void zzi(zzje zzjeVar) {
        throw new UnsupportedOperationException();
    }
}
