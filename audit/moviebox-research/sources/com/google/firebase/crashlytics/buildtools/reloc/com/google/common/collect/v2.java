package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class v2<E> extends n2<E> implements Set<E> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return Sets.a(this, obj);
    }

    public int standardHashCode() {
        return Sets.b(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardRemoveAll(Collection<?> collection) {
        return Sets.h(this, (Collection) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(collection));
    }
}
