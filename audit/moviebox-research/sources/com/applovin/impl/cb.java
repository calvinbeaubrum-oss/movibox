package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class cb extends AbstractCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f18169a = new Object[0];

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f18170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f18172c;

        public a(int i11) {
            p3.a(i11, "initialCapacity");
            this.f18170a = new Object[i11];
            this.f18171b = 0;
        }

        private void a(int i11) {
            Object[] objArr = this.f18170a;
            if (objArr.length < i11) {
                this.f18170a = Arrays.copyOf(objArr, b.a(objArr.length, i11));
                this.f18172c = false;
            } else if (this.f18172c) {
                this.f18170a = (Object[]) objArr.clone();
                this.f18172c = false;
            }
        }

        public a a(Object obj) {
            Preconditions.checkNotNull(obj);
            a(this.f18171b + 1);
            Object[] objArr = this.f18170a;
            int i11 = this.f18171b;
            this.f18171b = i11 + 1;
            objArr[i11] = obj;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class b {
        public static int a(int i11, int i12) {
            if (i12 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i11 + (i11 >> 1) + 1;
            if (iHighestOneBit < i12) {
                iHighestOneBit = Integer.highestOneBit(i12 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }
    }

    public abstract int a(Object[] objArr, int i11);

    public eb a() {
        return isEmpty() ? eb.h() : eb.a(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public Object[] b() {
        return null;
    }

    public int c() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    public int d() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean e();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract pp iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f18169a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Preconditions.checkNotNull(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrB = b();
            if (objArrB != null) {
                return mh.a(objArrB, d(), c(), objArr);
            }
            objArr = gg.b(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        a(objArr, 0);
        return objArr;
    }
}
