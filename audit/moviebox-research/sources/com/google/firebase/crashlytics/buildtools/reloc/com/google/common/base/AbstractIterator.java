package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f39029a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f39030b;

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
        public static final /* synthetic */ int[] f39031a;

        static {
            int[] iArr = new int[State.values().length];
            f39031a = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39031a[State.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f39029a = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f39029a = State.FAILED;
        this.f39030b = a();
        if (this.f39029a == State.DONE) {
            return false;
        }
        this.f39029a = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        l.t(this.f39029a != State.FAILED);
        int i11 = a.f39031a[this.f39029a.ordinal()];
        if (i11 == 1) {
            return true;
        }
        if (i11 != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f39029a = State.NOT_READY;
        T t11 = this.f39030b;
        this.f39030b = null;
        return t11;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
