package com.google.protobuf;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class v extends c<Float> implements y.f, RandomAccess, w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f41425d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f41426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41427c;

    static {
        v vVar = new v(new float[0], 0);
        f41425d = vVar;
        vVar.k();
    }

    public v() {
        this(new float[10], 0);
    }

    public v(float[] fArr, int i11) {
        this.f41426b = fArr;
        this.f41427c = i11;
    }

    private void i(int i11) {
        if (i11 < 0 || i11 >= this.f41427c) {
            throw new IndexOutOfBoundsException(r(i11));
        }
    }

    private String r(int i11) {
        return "Index:" + i11 + ", Size:" + this.f41427c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        y.a(collection);
        if (!(collection instanceof v)) {
            return super.addAll(collection);
        }
        v vVar = (v) collection;
        int i11 = vVar.f41427c;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f41427c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        float[] fArr = this.f41426b;
        if (i13 > fArr.length) {
            this.f41426b = Arrays.copyOf(fArr, i13);
        }
        System.arraycopy(vVar.f41426b, 0, this.f41426b, this.f41427c, vVar.f41427c);
        this.f41427c = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i11, Float f11) {
        g(i11, f11.floatValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f11) {
        f(f11.floatValue());
        return true;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return super.equals(obj);
        }
        v vVar = (v) obj;
        if (this.f41427c != vVar.f41427c) {
            return false;
        }
        float[] fArr = vVar.f41426b;
        for (int i11 = 0; i11 < this.f41427c; i11++) {
            if (Float.floatToIntBits(this.f41426b[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public void f(float f11) {
        a();
        int i11 = this.f41427c;
        float[] fArr = this.f41426b;
        if (i11 == fArr.length) {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            this.f41426b = fArr2;
        }
        float[] fArr3 = this.f41426b;
        int i12 = this.f41427c;
        this.f41427c = i12 + 1;
        fArr3[i12] = f11;
    }

    public final void g(int i11, float f11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f41427c)) {
            throw new IndexOutOfBoundsException(r(i11));
        }
        float[] fArr = this.f41426b;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[((i12 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.f41426b, i11, fArr2, i11 + 1, this.f41427c - i11);
            this.f41426b = fArr2;
        }
        this.f41426b[i11] = f11;
        this.f41427c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i11 = 0; i11 < this.f41427c; i11++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f41426b[i11]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.f41426b[i11] == fFloatValue) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public Float get(int i11) {
        return Float.valueOf(o(i11));
    }

    public float o(int i11) {
        i(i11);
        return this.f41426b[i11];
    }

    @Override // java.util.AbstractList
    public void removeRange(int i11, int i12) {
        a();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f41426b;
        System.arraycopy(fArr, i12, fArr, i11, this.f41427c - i12);
        this.f41427c -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public y.f c(int i11) {
        if (i11 >= this.f41427c) {
            return new v(Arrays.copyOf(this.f41426b, i11), this.f41427c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41427c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Float remove(int i11) {
        a();
        i(i11);
        float[] fArr = this.f41426b;
        float f11 = fArr[i11];
        int i12 = this.f41427c;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, (i12 - i11) - 1);
        }
        this.f41427c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Float set(int i11, Float f11) {
        return Float.valueOf(w(i11, f11.floatValue()));
    }

    public float w(int i11, float f11) {
        a();
        i(i11);
        float[] fArr = this.f41426b;
        float f12 = fArr[i11];
        fArr[i11] = f11;
        return f12;
    }
}
