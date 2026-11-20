package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgan extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzfws zzb;

    public zzgan(List list, zzfws zzfwsVar) {
        this.zza = list;
        this.zzb = zzfwsVar;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i11) {
        return new zzgam(this, this.zza.listIterator(i11));
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i11, int i12) {
        this.zza.subList(i11, i12).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
