package com.applovin.exoplayer2.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class b implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0172b f17234a = EnumC0172b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f17235b;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17236a;

        static {
            int[] iArr = new int[EnumC0172b.values().length];
            f17236a = iArr;
            try {
                iArr[EnumC0172b.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17236a[EnumC0172b.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public enum EnumC0172b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f17234a = EnumC0172b.FAILED;
        this.f17235b = a();
        if (this.f17234a == EnumC0172b.DONE) {
            return false;
        }
        this.f17234a = EnumC0172b.READY;
        return true;
    }

    public abstract Object a();

    public final Object b() {
        this.f17234a = EnumC0172b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.checkState(this.f17234a != EnumC0172b.FAILED);
        int i11 = a.f17236a[this.f17234a.ordinal()];
        if (i11 == 1) {
            return true;
        }
        if (i11 != 2) {
            return c();
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f17234a = EnumC0172b.NOT_READY;
        Object obj = this.f17235b;
        this.f17235b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
