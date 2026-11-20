package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f41025a;

    public e() {
        this.f41025a = null;
    }

    public e(T t11) {
        if (t11 == null) {
            throw new NullPointerException("value for optional is empty.");
        }
        this.f41025a = t11;
    }

    public static <T> e<T> a() {
        return new e<>();
    }

    public static <T> e<T> b(T t11) {
        return t11 == null ? a() : e(t11);
    }

    public static <T> e<T> e(T t11) {
        return new e<>(t11);
    }

    public T c() {
        T t11 = this.f41025a;
        if (t11 != null) {
            return t11;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean d() {
        return this.f41025a != null;
    }
}
