package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class l2<E> extends s2<E> implements g7<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Comparator<? super E> f39723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient NavigableSet<E> f39724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Set<l6.a<E>> f39725c;

    /* JADX INFO: compiled from: source.java */
    public class a extends Multisets.d<E> {
        public a() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multisets.d
        public l6<E> a() {
            return l2.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<l6.a<E>> iterator() {
            return l2.this.u();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return l2.this.v().entrySet().size();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.e7
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f39723a;
        if (comparator != null) {
            return comparator;
        }
        Ordering orderingReverse = Ordering.from(v().comparator()).reverse();
        this.f39723a = orderingReverse;
        return orderingReverse;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public g7<E> descendingMultiset() {
        return v();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f39724b;
        if (navigableSet != null) {
            return navigableSet;
        }
        h7.b bVar = new h7.b(this);
        this.f39724b = bVar;
        return bVar;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public Set<l6.a<E>> entrySet() {
        Set<l6.a<E>> set = this.f39725c;
        if (set != null) {
            return set;
        }
        Set<l6.a<E>> setG = g();
        this.f39725c = setG;
        return setG;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public l6<E> delegate() {
        return v();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> firstEntry() {
        return v().lastEntry();
    }

    public Set<l6.a<E>> g() {
        return new a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public g7<E> headMultiset(E e11, BoundType boundType) {
        return v().tailMultiset(e11, boundType).descendingMultiset();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> lastEntry() {
        return v().firstEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> pollFirstEntry() {
        return v().pollLastEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> pollLastEntry() {
        return v().pollFirstEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public g7<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        return v().subMultiset(e12, boundType2, e11, boundType).descendingMultiset();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public g7<E> tailMultiset(E e11, BoundType boundType) {
        return v().headMultiset(e11, boundType).descendingMultiset();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public String toString() {
        return entrySet().toString();
    }

    public abstract Iterator<l6.a<E>> u();

    public abstract g7<E> v();
}
