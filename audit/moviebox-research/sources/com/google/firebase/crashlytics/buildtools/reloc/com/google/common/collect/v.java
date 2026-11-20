package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.lang.Comparable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class v<C extends Comparable> implements v6<C> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void addAll(v6<C> v6Var) {
        addAll(v6Var.asRanges());
    }

    public /* synthetic */ void addAll(Iterable iterable) {
        u6.a(this, iterable);
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c11) {
        return rangeContaining(c11) != null;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(v6<C> v6Var) {
        return enclosesAll(v6Var.asRanges());
    }

    public /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return u6.b(this, iterable);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v6) {
            return asRanges().equals(((v6) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c11);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v6
    public void removeAll(v6<C> v6Var) {
        removeAll(v6Var.asRanges());
    }

    public /* synthetic */ void removeAll(Iterable iterable) {
        u6.c(this, iterable);
    }

    public final String toString() {
        return asRanges().toString();
    }
}
