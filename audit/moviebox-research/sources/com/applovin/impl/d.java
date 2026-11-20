package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends pp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f18321a = b.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f18322b;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f18323a;

        static {
            int[] iArr = new int[b.values().length];
            f18323a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18323a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f18321a = b.FAILED;
        this.f18322b = a();
        if (this.f18321a == b.DONE) {
            return false;
        }
        this.f18321a = b.READY;
        return true;
    }

    public abstract Object a();

    public final Object b() {
        this.f18321a = b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.checkState(this.f18321a != b.FAILED);
        int i11 = a.f18323a[this.f18321a.ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f18321a = b.NOT_READY;
        Object obj = this.f18322b;
        this.f18322b = null;
        return obj;
    }
}
