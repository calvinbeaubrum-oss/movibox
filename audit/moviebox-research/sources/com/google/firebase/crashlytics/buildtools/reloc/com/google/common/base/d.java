package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.function.Function;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface d<F, T> extends Function<F, T> {
    @Override // java.util.function.Function
    T apply(F f11);

    boolean equals(Object obj);
}
