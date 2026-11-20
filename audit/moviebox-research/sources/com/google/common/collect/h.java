package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h<E> extends d<E> implements z0<E> {
    final Comparator<? super E> comparator;
    private transient z0<E> descendingMultiset;

    /* JADX INFO: compiled from: source.java */
    public class a extends p<E> {
        public a() {
        }

        @Override // com.google.common.collect.r, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return h.this.descendingIterator();
        }

        @Override // com.google.common.collect.p
        public Iterator<j0.a<E>> w() {
            return h.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.p
        public z0<E> x() {
            return h.this;
        }
    }

    public h() {
        this(Ordering.natural());
    }

    public h(Comparator<? super E> comparator) {
        this.comparator = (Comparator) com.google.common.base.m.p(comparator);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public z0<E> createDescendingMultiset() {
        return new a();
    }

    @Override // com.google.common.collect.d
    public NavigableSet<E> createElementSet() {
        return new a1.b(this);
    }

    public abstract Iterator<j0.a<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    public z0<E> descendingMultiset() {
        z0<E> z0Var = this.descendingMultiset;
        if (z0Var != null) {
            return z0Var;
        }
        z0<E> z0VarCreateDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = z0VarCreateDescendingMultiset;
        return z0VarCreateDescendingMultiset;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j0
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    public j0.a<E> firstEntry() {
        Iterator<j0.a<E>> itEntryIterator = entryIterator();
        if (itEntryIterator.hasNext()) {
            return itEntryIterator.next();
        }
        return null;
    }

    public j0.a<E> lastEntry() {
        Iterator<j0.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (itDescendingEntryIterator.hasNext()) {
            return itDescendingEntryIterator.next();
        }
        return null;
    }

    public j0.a<E> pollFirstEntry() {
        Iterator<j0.a<E>> itEntryIterator = entryIterator();
        if (!itEntryIterator.hasNext()) {
            return null;
        }
        j0.a<E> next = itEntryIterator.next();
        j0.a<E> aVarG = Multisets.g(next.getElement(), next.getCount());
        itEntryIterator.remove();
        return aVarG;
    }

    public j0.a<E> pollLastEntry() {
        Iterator<j0.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (!itDescendingEntryIterator.hasNext()) {
            return null;
        }
        j0.a<E> next = itDescendingEntryIterator.next();
        j0.a<E> aVarG = Multisets.g(next.getElement(), next.getCount());
        itDescendingEntryIterator.remove();
        return aVarG;
    }

    public z0<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        com.google.common.base.m.p(boundType);
        com.google.common.base.m.p(boundType2);
        return tailMultiset(e11, boundType).headMultiset(e12, boundType2);
    }
}
