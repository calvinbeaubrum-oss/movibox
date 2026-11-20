package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f0 extends c<Long> implements y.i, RandomAccess, w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f0 f41263d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f41264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41265c;

    static {
        f0 f0Var = new f0(new long[0], 0);
        f41263d = f0Var;
        f0Var.k();
    }

    public f0() {
        this(new long[10], 0);
    }

    public f0(long[] jArr, int i11) {
        this.f41264b = jArr;
        this.f41265c = i11;
    }

    private void i(int i11) {
        if (i11 < 0 || i11 >= this.f41265c) {
            throw new IndexOutOfBoundsException(r(i11));
        }
    }

    private String r(int i11) {
        return "Index:" + i11 + ", Size:" + this.f41265c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        y.a(collection);
        if (!(collection instanceof f0)) {
            return super.addAll(collection);
        }
        f0 f0Var = (f0) collection;
        int i11 = f0Var.f41265c;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f41265c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        long[] jArr = this.f41264b;
        if (i13 > jArr.length) {
            this.f41264b = Arrays.copyOf(jArr, i13);
        }
        System.arraycopy(f0Var.f41264b, 0, this.f41264b, this.f41265c, f0Var.f41265c);
        this.f41265c = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i11, Long l11) {
        f(i11, l11.longValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l11) {
        g(l11.longValue());
        return true;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return super.equals(obj);
        }
        f0 f0Var = (f0) obj;
        if (this.f41265c != f0Var.f41265c) {
            return false;
        }
        long[] jArr = f0Var.f41264b;
        for (int i11 = 0; i11 < this.f41265c; i11++) {
            if (this.f41264b[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i11, long j11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f41265c)) {
            throw new IndexOutOfBoundsException(r(i11));
        }
        long[] jArr = this.f41264b;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[((i12 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.f41264b, i11, jArr2, i11 + 1, this.f41265c - i11);
            this.f41264b = jArr2;
        }
        this.f41264b[i11] = j11;
        this.f41265c++;
        ((AbstractList) this).modCount++;
    }

    public void g(long j11) {
        a();
        int i11 = this.f41265c;
        long[] jArr = this.f41264b;
        if (i11 == jArr.length) {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            this.f41264b = jArr2;
        }
        long[] jArr3 = this.f41264b;
        int i12 = this.f41265c;
        this.f41265c = i12 + 1;
        jArr3[i12] = j11;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i11 = 0; i11 < this.f41265c; i11++) {
            iF = (iF * 31) + y.f(this.f41264b[i11]);
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f41264b[i11] == jLongValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Long get(int i11) {
        return Long.valueOf(o(i11));
    }

    public long o(int i11) {
        i(i11);
        return this.f41264b[i11];
    }

    @Override // java.util.AbstractList
    public void removeRange(int i11, int i12) {
        a();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f41264b;
        System.arraycopy(jArr, i12, jArr, i11, this.f41265c - i12);
        this.f41265c -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public y.i c(int i11) {
        if (i11 >= this.f41265c) {
            return new f0(Arrays.copyOf(this.f41264b, i11), this.f41265c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41265c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Long remove(int i11) {
        a();
        i(i11);
        long[] jArr = this.f41264b;
        long j11 = jArr[i11];
        int i12 = this.f41265c;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.f41265c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Long set(int i11, Long l11) {
        return Long.valueOf(w(i11, l11.longValue()));
    }

    public long w(int i11, long j11) {
        a();
        i(i11);
        long[] jArr = this.f41264b;
        long j12 = jArr[i11];
        jArr[i11] = j11;
        return j12;
    }
}
