package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractIterator<T> extends g1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f38209a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f38210b;

    /* JADX INFO: compiled from: source.java */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38211a;

        static {
            int[] iArr = new int[State.values().length];
            f38211a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38211a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f38209a = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f38209a = State.FAILED;
        this.f38210b = a();
        if (this.f38209a == State.DONE) {
            return false;
        }
        this.f38209a = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.common.base.m.v(this.f38209a != State.FAILED);
        int i11 = a.f38211a[this.f38209a.ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f38209a = State.NOT_READY;
        T t11 = (T) k0.a(this.f38210b);
        this.f38210b = null;
        return t11;
    }
}
