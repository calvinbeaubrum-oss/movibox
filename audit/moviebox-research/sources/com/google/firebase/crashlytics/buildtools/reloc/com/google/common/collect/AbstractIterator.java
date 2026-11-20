package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractIterator<T> extends t7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f39212a = State.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f39213b;

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
        public static final /* synthetic */ int[] f39214a;

        static {
            int[] iArr = new int[State.values().length];
            f39214a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39214a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public abstract T a();

    public final T b() {
        this.f39212a = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f39212a = State.FAILED;
        this.f39213b = a();
        if (this.f39212a == State.DONE) {
            return false;
        }
        this.f39212a = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.t(this.f39212a != State.FAILED);
        int i11 = a.f39214a[this.f39212a.ordinal()];
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
        this.f39212a = State.NOT_READY;
        T t11 = this.f39213b;
        this.f39213b = null;
        return t11;
    }
}
