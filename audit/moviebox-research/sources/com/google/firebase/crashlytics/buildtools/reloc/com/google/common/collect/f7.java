package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f7 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? Ordering.natural() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof e7)) {
                return false;
            }
            comparator2 = ((e7) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
