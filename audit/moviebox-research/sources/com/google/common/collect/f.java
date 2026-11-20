package com.google.common.collect;

import java.lang.Comparable;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f<C extends Comparable> implements s0<C> {
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void addAll(s0<C> s0Var) {
        addAll(s0Var.asRanges());
    }

    public void addAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c11) {
        return rangeContaining(c11) != null;
    }

    @Override // com.google.common.collect.s0
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(s0<C> s0Var) {
        return enclosesAll(s0Var.asRanges());
    }

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            if (!encloses(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s0) {
            return asRanges().equals(((s0) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // com.google.common.collect.s0
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c11);

    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s0
    public void removeAll(s0<C> s0Var) {
        removeAll(s0Var.asRanges());
    }

    public void removeAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final String toString() {
        return asRanges().toString();
    }
}
