package com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f38139a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f38140b;

    /* JADX INFO: compiled from: source.java */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38141a;

        static {
            int[] iArr = new int[State.values().length];
            f38141a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38141a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f38139a = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f38139a = State.FAILED;
        this.f38140b = a();
        if (this.f38139a == State.DONE) {
            return false;
        }
        this.f38139a = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        m.v(this.f38139a != State.FAILED);
        int i11 = a.f38141a[this.f38139a.ordinal()];
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
        this.f38139a = State.NOT_READY;
        T t11 = (T) i.a(this.f38140b);
        this.f38140b = null;
        return t11;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
