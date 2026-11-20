package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzoc extends zzox {
    private Object zza;

    public zzoc(Object obj) {
        this.zza = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj = this.zza;
        this.zza = this;
        if (obj != this) {
            return obj;
        }
        throw new NoSuchElementException();
    }
}
