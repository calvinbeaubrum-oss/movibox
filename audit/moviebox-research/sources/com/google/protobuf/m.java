package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m extends c<Double> implements y.b, RandomAccess, w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f41380d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f41381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41382c;

    static {
        m mVar = new m(new double[0], 0);
        f41380d = mVar;
        mVar.k();
    }

    public m() {
        this(new double[10], 0);
    }

    public m(double[] dArr, int i11) {
        this.f41381b = dArr;
        this.f41382c = i11;
    }

    private void i(int i11) {
        if (i11 < 0 || i11 >= this.f41382c) {
            throw new IndexOutOfBoundsException(r(i11));
        }
    }

    private String r(int i11) {
        return "Index:" + i11 + ", Size:" + this.f41382c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        y.a(collection);
        if (!(collection instanceof m)) {
            return super.addAll(collection);
        }
        m mVar = (m) collection;
        int i11 = mVar.f41382c;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f41382c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        double[] dArr = this.f41381b;
        if (i13 > dArr.length) {
            this.f41381b = Arrays.copyOf(dArr, i13);
        }
        System.arraycopy(mVar.f41381b, 0, this.f41381b, this.f41382c, mVar.f41382c);
        this.f41382c = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i11, Double d11) {
        g(i11, d11.doubleValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d11) {
        f(d11.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return super.equals(obj);
        }
        m mVar = (m) obj;
        if (this.f41382c != mVar.f41382c) {
            return false;
        }
        double[] dArr = mVar.f41381b;
        for (int i11 = 0; i11 < this.f41382c; i11++) {
            if (Double.doubleToLongBits(this.f41381b[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public void f(double d11) {
        a();
        int i11 = this.f41382c;
        double[] dArr = this.f41381b;
        if (i11 == dArr.length) {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            this.f41381b = dArr2;
        }
        double[] dArr3 = this.f41381b;
        int i12 = this.f41382c;
        this.f41382c = i12 + 1;
        dArr3[i12] = d11;
    }

    public final void g(int i11, double d11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f41382c)) {
            throw new IndexOutOfBoundsException(r(i11));
        }
        double[] dArr = this.f41381b;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[((i12 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.f41381b, i11, dArr2, i11 + 1, this.f41382c - i11);
            this.f41381b = dArr2;
        }
        this.f41381b[i11] = d11;
        this.f41382c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i11 = 0; i11 < this.f41382c; i11++) {
            iF = (iF * 31) + y.f(Double.doubleToLongBits(this.f41381b[i11]));
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f41381b[i11] == dDoubleValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Double get(int i11) {
        return Double.valueOf(o(i11));
    }

    public double o(int i11) {
        i(i11);
        return this.f41381b[i11];
    }

    @Override // java.util.AbstractList
    public void removeRange(int i11, int i12) {
        a();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f41381b;
        System.arraycopy(dArr, i12, dArr, i11, this.f41382c - i12);
        this.f41382c -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public y.b c(int i11) {
        if (i11 >= this.f41382c) {
            return new m(Arrays.copyOf(this.f41381b, i11), this.f41382c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41382c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Double remove(int i11) {
        a();
        i(i11);
        double[] dArr = this.f41381b;
        double d11 = dArr[i11];
        int i12 = this.f41382c;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, (i12 - i11) - 1);
        }
        this.f41382c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Double set(int i11, Double d11) {
        return Double.valueOf(w(i11, d11.doubleValue()));
    }

    public double w(int i11, double d11) {
        a();
        i(i11);
        double[] dArr = this.f41381b;
        double d12 = dArr[i11];
        dArr[i11] = d11;
        return d12;
    }
}
