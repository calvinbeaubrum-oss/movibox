package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends c<Boolean> implements y.a, RandomAccess, w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f41271d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f41272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41273c;

    static {
        g gVar = new g(new boolean[0], 0);
        f41271d = gVar;
        gVar.k();
    }

    public g() {
        this(new boolean[10], 0);
    }

    public g(boolean[] zArr, int i11) {
        this.f41272b = zArr;
        this.f41273c = i11;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        y.a(collection);
        if (!(collection instanceof g)) {
            return super.addAll(collection);
        }
        g gVar = (g) collection;
        int i11 = gVar.f41273c;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f41273c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        boolean[] zArr = this.f41272b;
        if (i13 > zArr.length) {
            this.f41272b = Arrays.copyOf(zArr, i13);
        }
        System.arraycopy(gVar.f41272b, 0, this.f41272b, this.f41273c, gVar.f41273c);
        this.f41273c = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i11, Boolean bool) {
        f(i11, bool.booleanValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        g(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return super.equals(obj);
        }
        g gVar = (g) obj;
        if (this.f41273c != gVar.f41273c) {
            return false;
        }
        boolean[] zArr = gVar.f41272b;
        for (int i11 = 0; i11 < this.f41273c; i11++) {
            if (this.f41272b[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i11, boolean z11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f41273c)) {
            throw new IndexOutOfBoundsException(r(i11));
        }
        boolean[] zArr = this.f41272b;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[((i12 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.f41272b, i11, zArr2, i11 + 1, this.f41273c - i11);
            this.f41272b = zArr2;
        }
        this.f41272b[i11] = z11;
        this.f41273c++;
        ((AbstractList) this).modCount++;
    }

    public void g(boolean z11) {
        a();
        int i11 = this.f41273c;
        boolean[] zArr = this.f41272b;
        if (i11 == zArr.length) {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            this.f41272b = zArr2;
        }
        boolean[] zArr3 = this.f41272b;
        int i12 = this.f41273c;
        this.f41273c = i12 + 1;
        zArr3[i12] = z11;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i11 = 0; i11 < this.f41273c; i11++) {
            iC = (iC * 31) + y.c(this.f41272b[i11]);
        }
        return iC;
    }

    public final void i(int i11) {
        if (i11 < 0 || i11 >= this.f41273c) {
            throw new IndexOutOfBoundsException(r(i11));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f41272b[i11] == zBooleanValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i11) {
        return Boolean.valueOf(o(i11));
    }

    public boolean o(int i11) {
        i(i11);
        return this.f41272b[i11];
    }

    public final String r(int i11) {
        return "Index:" + i11 + ", Size:" + this.f41273c;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i11, int i12) {
        a();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f41272b;
        System.arraycopy(zArr, i12, zArr, i11, this.f41273c - i12);
        this.f41273c -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public y.a c(int i11) {
        if (i11 >= this.f41273c) {
            return new g(Arrays.copyOf(this.f41272b, i11), this.f41273c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41273c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i11) {
        a();
        i(i11);
        boolean[] zArr = this.f41272b;
        boolean z11 = zArr[i11];
        int i12 = this.f41273c;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.f41273c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i11, Boolean bool) {
        return Boolean.valueOf(w(i11, bool.booleanValue()));
    }

    public boolean w(int i11, boolean z11) {
        a();
        i(i11);
        boolean[] zArr = this.f41272b;
        boolean z12 = zArr[i11];
        zArr[i11] = z11;
        return z12;
    }
}
