package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class s2<E> extends n2<E> implements l6<E> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int add(E e11, int i11) {
        return f().add(e11, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        return f().count(obj);
    }

    public abstract Set<l6.a<E>> entrySet();

    @Override // java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public boolean equals(Object obj) {
        return obj == this || f().equals(obj);
    }

    public abstract l6<E> f();

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int hashCode() {
        return f().hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int remove(Object obj, int i11) {
        return f().remove(obj, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int setCount(E e11, int i11) {
        return f().setCount(e11, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public boolean setCount(E e11, int i11, int i12) {
        return f().setCount(e11, i11, i12);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return k6.c(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public void standardClear() {
        Iterators.d(entrySet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public String standardToString() {
        return entrySet().toString();
    }
}
