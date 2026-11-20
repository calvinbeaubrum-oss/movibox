package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(m0.b());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f38571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ImmutableSet<E> f38572b;
    final transient m0<E> contents;

    /* JADX INFO: compiled from: source.java */
    public final class ElementSet extends IndexedImmutableSet<E> {
        public ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i11) {
            return RegularImmutableMultiset.this.contents.i(i11);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.C();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public SerializedForm(j0<? extends Object> j0Var) {
            int size = j0Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i11 = 0;
            for (j0.a<? extends Object> aVar : j0Var.entrySet()) {
                this.elements[i11] = aVar.getElement();
                this.counts[i11] = aVar.getCount();
                i11++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i11 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i11 >= objArr.length) {
                    return bVar.k();
                }
                bVar.j(objArr[i11], this.counts[i11]);
                i11++;
            }
        }
    }

    public RegularImmutableMultiset(m0<E> m0Var) {
        this.contents = m0Var;
        long jK = 0;
        for (int i11 = 0; i11 < m0Var.C(); i11++) {
            jK += (long) m0Var.k(i11);
        }
        this.f38571a = Ints.l(jK);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public int count(Object obj) {
        return this.contents.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.f38572b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.f38572b = elementSet;
        return elementSet;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public j0.a<E> getEntry(int i11) {
        return this.contents.g(i11);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public int size() {
        return this.f38571a;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
