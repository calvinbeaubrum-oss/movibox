package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class x<E> extends t<E> implements g7<E> {
    final Comparator<? super E> comparator;
    private transient g7<E> descendingMultiset;

    /* JADX INFO: compiled from: source.java */
    public class a extends l2<E> {
        public a() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return x.this.descendingIterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l2
        public Iterator<l6.a<E>> u() {
            return x.this.descendingEntryIterator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l2
        public g7<E> v() {
            return x.this;
        }
    }

    public x() {
        this(Ordering.natural());
    }

    public x(Comparator<? super E> comparator) {
        this.comparator = (Comparator) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public g7<E> createDescendingMultiset() {
        return new a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t
    public NavigableSet<E> createElementSet() {
        return new h7.b(this);
    }

    public abstract Iterator<l6.a<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    public g7<E> descendingMultiset() {
        g7<E> g7Var = this.descendingMultiset;
        if (g7Var != null) {
            return g7Var;
        }
        g7<E> g7VarCreateDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = g7VarCreateDescendingMultiset;
        return g7VarCreateDescendingMultiset;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    public l6.a<E> firstEntry() {
        Iterator<l6.a<E>> itEntryIterator = entryIterator();
        if (itEntryIterator.hasNext()) {
            return itEntryIterator.next();
        }
        return null;
    }

    public l6.a<E> lastEntry() {
        Iterator<l6.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (itDescendingEntryIterator.hasNext()) {
            return itDescendingEntryIterator.next();
        }
        return null;
    }

    public l6.a<E> pollFirstEntry() {
        Iterator<l6.a<E>> itEntryIterator = entryIterator();
        if (!itEntryIterator.hasNext()) {
            return null;
        }
        l6.a<E> next = itEntryIterator.next();
        l6.a<E> aVarG = Multisets.g(next.getElement(), next.getCount());
        itEntryIterator.remove();
        return aVarG;
    }

    public l6.a<E> pollLastEntry() {
        Iterator<l6.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (!itDescendingEntryIterator.hasNext()) {
            return null;
        }
        l6.a<E> next = itDescendingEntryIterator.next();
        l6.a<E> aVarG = Multisets.g(next.getElement(), next.getCount());
        itDescendingEntryIterator.remove();
        return aVarG;
    }

    public g7<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(boundType);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(boundType2);
        return tailMultiset(e11, boundType).headMultiset(e12, boundType2);
    }
}
