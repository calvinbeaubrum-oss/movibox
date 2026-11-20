package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class z<E> extends r<E> implements Set<E> {
    @Override // com.google.common.collect.r, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public abstract Set<E> u();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || u().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return u().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return Sets.a(this, obj);
    }

    public int standardHashCode() {
        return Sets.d(this);
    }

    @Override // com.google.common.collect.r
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.i(this, (Collection) com.google.common.base.m.p(collection));
    }
}
