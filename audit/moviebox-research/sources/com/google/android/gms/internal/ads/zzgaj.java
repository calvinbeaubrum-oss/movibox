package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgaj extends zzgce {
    private static final Object zza = new Object();
    private Object zzb;

    public zzgaj(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != zza;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj = this.zzb;
        Object obj2 = zza;
        if (obj == obj2) {
            throw new NoSuchElementException();
        }
        this.zzb = obj2;
        return obj;
    }
}
