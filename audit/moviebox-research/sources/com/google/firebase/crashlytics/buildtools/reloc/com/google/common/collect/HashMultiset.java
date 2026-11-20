package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    private static final long serialVersionUID = 0;

    private HashMultiset() {
        super(new HashMap());
    }

    private HashMultiset(int i11) {
        super(Maps.n(i11));
    }

    public static <E> HashMultiset<E> create() {
        return new HashMultiset<>();
    }

    public static <E> HashMultiset<E> create(int i11) {
        return new HashMultiset<>(i11);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> hashMultisetCreate = create(Multisets.h(iterable));
        j5.a(hashMultisetCreate, iterable);
        return hashMultisetCreate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = y6.h(objectInputStream);
        setBackingMap(Maps.m());
        y6.g(this, objectInputStream, iH);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        y6.k(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ int add(Object obj, int i11) {
        return super.add(obj, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ int count(Object obj) {
        return super.count(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        super.forEachEntry(objIntConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ int remove(Object obj, int i11) {
        return super.remove(obj, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i11) {
        return super.setCount(obj, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ boolean setCount(Object obj, int i11, int i12) {
        return super.setCount(obj, i11, i12);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return k6.c(this);
    }
}
