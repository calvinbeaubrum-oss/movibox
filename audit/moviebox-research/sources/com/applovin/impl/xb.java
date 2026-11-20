package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xb {

    /* JADX INFO: compiled from: source.java */
    public class a extends pp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f24275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f24276b;

        public a(Object obj) {
            this.f24276b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f24275a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f24275a) {
                throw new NoSuchElementException();
            }
            this.f24275a = true;
            return this.f24276b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends com.applovin.impl.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final qp f24277f = new b(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f24278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f24279d;

        public b(Object[] objArr, int i11, int i12, int i13) {
            super(i12, i13);
            this.f24278c = objArr;
            this.f24279d = i11;
        }

        @Override // com.applovin.impl.c
        public Object a(int i11) {
            return this.f24278c[this.f24279d + i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum c implements Iterator {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            p3.a(false);
        }
    }

    public static pp a() {
        return b();
    }

    public static pp a(Object obj) {
        return new a(obj);
    }

    public static Object a(Iterator it, Object obj) {
        return it.hasNext() ? it.next() : obj;
    }

    public static void a(Iterator it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static boolean a(Collection collection, Iterator it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean a(Iterator it, Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean z11 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static boolean a(Iterator it, Iterator it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.equal(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static qp b() {
        return b.f24277f;
    }

    public static Object b(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static Object c(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Object next = it.next();
        it.remove();
        return next;
    }

    public static Iterator c() {
        return c.INSTANCE;
    }

    public static String d(Iterator it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        while (it.hasNext()) {
            if (!z11) {
                sb2.append(", ");
            }
            sb2.append(it.next());
            z11 = false;
        }
        sb2.append(']');
        return sb2.toString();
    }
}
