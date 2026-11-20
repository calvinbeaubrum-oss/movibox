package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface v6<C extends Comparable> {
    void add(Range<C> range);

    Set<Range<C>> asRanges();

    v6<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void remove(Range<C> range);

    void removeAll(v6<C> v6Var);

    v6<C> subRangeSet(Range<C> range);
}
