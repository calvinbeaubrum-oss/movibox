package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface n<T> extends Predicate<T> {
    boolean apply(T t11);

    boolean equals(Object obj);

    @Override // java.util.function.Predicate
    boolean test(T t11);
}
