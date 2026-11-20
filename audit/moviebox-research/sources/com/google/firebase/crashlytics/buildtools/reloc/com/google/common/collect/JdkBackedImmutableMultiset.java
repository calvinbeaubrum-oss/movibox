package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class JdkBackedImmutableMultiset<E> extends ImmutableMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ImmutableSet<E> f39422a;
    private final Map<E, Integer> delegateMap;
    private final ImmutableList<l6.a<E>> entries;
    private final long size;

    public JdkBackedImmutableMultiset(Map<E, Integer> map, ImmutableList<l6.a<E>> immutableList, long j11) {
        this.delegateMap = map;
        this.entries = immutableList;
        this.size = j11;
    }

    public static <E> ImmutableMultiset<E> create(Collection<? extends l6.a<? extends E>> collection) {
        l6.a[] aVarArr = (l6.a[]) collection.toArray(new l6.a[0]);
        HashMap mapN = Maps.n(aVarArr.length);
        long j11 = 0;
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            l6.a aVar = aVarArr[i11];
            int count = aVar.getCount();
            j11 += (long) count;
            Object objN = com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(aVar.getElement());
            mapN.put(objN, Integer.valueOf(count));
            if (!(aVar instanceof Multisets.ImmutableEntry)) {
                aVarArr[i11] = Multisets.g(objN, count);
            }
        }
        return new JdkBackedImmutableMultiset(mapN, ImmutableList.asImmutableList(aVarArr), j11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        return ((Integer) this.delegateMap.getOrDefault(obj, 0)).intValue();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f39422a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableMultiset.ElementSet elementSet = new ImmutableMultiset.ElementSet(this.entries, this);
        this.f39422a = elementSet;
        return elementSet;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset
    public l6.a<E> getEntry(int i11) {
        return this.entries.get(i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        return Ints.i(this.size);
    }
}
