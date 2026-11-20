package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class x extends c<Integer> implements y.g, RandomAccess, w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f41429d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f41430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41431c;

    static {
        x xVar = new x(new int[0], 0);
        f41429d = xVar;
        xVar.k();
    }

    public x() {
        this(new int[10], 0);
    }

    public x(int[] iArr, int i11) {
        this.f41430b = iArr;
        this.f41431c = i11;
    }

    public static x g() {
        return f41429d;
    }

    private void i(int i11) {
        if (i11 < 0 || i11 >= this.f41431c) {
            throw new IndexOutOfBoundsException(o(i11));
        }
    }

    private String o(int i11) {
        return "Index:" + i11 + ", Size:" + this.f41431c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        y.a(collection);
        if (!(collection instanceof x)) {
            return super.addAll(collection);
        }
        x xVar = (x) collection;
        int i11 = xVar.f41431c;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f41431c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        int[] iArr = this.f41430b;
        if (i13 > iArr.length) {
            this.f41430b = Arrays.copyOf(iArr, i13);
        }
        System.arraycopy(xVar.f41430b, 0, this.f41430b, this.f41431c, xVar.f41431c);
        this.f41431c = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i11, Integer num) {
        f(i11, num.intValue());
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public y.j<Integer> c2(int i11) {
        if (i11 >= this.f41431c) {
            return new x(Arrays.copyOf(this.f41430b, i11), this.f41431c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        n(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return super.equals(obj);
        }
        x xVar = (x) obj;
        if (this.f41431c != xVar.f41431c) {
            return false;
        }
        int[] iArr = xVar.f41430b;
        for (int i11 = 0; i11 < this.f41431c; i11++) {
            if (this.f41430b[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i11, int i12) {
        int i13;
        a();
        if (i11 < 0 || i11 > (i13 = this.f41431c)) {
            throw new IndexOutOfBoundsException(o(i11));
        }
        int[] iArr = this.f41430b;
        if (i13 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i13 - i11);
        } else {
            int[] iArr2 = new int[((i13 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.f41430b, i11, iArr2, i11 + 1, this.f41431c - i11);
            this.f41430b = iArr2;
        }
        this.f41430b[i11] = i12;
        this.f41431c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.y.g
    public int getInt(int i11) {
        i(i11);
        return this.f41430b[i11];
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.f41431c; i12++) {
            i11 = (i11 * 31) + this.f41430b[i12];
        }
        return i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f41430b[i11] == iIntValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Integer get(int i11) {
        return Integer.valueOf(getInt(i11));
    }

    @Override // com.google.protobuf.y.g
    public void n(int i11) {
        a();
        int i12 = this.f41431c;
        int[] iArr = this.f41430b;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f41430b = iArr2;
        }
        int[] iArr3 = this.f41430b;
        int i13 = this.f41431c;
        this.f41431c = i13 + 1;
        iArr3[i13] = i11;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i11) {
        a();
        i(i11);
        int[] iArr = this.f41430b;
        int i12 = iArr[i11];
        int i13 = this.f41431c;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.f41431c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i12);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i11, int i12) {
        a();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f41430b;
        System.arraycopy(iArr, i12, iArr, i11, this.f41431c - i12);
        this.f41431c -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer set(int i11, Integer num) {
        return Integer.valueOf(u(i11, num.intValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41431c;
    }

    public int u(int i11, int i12) {
        a();
        i(i11);
        int[] iArr = this.f41430b;
        int i13 = iArr[i11];
        iArr[i11] = i12;
        return i13;
    }
}
