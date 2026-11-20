package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class y0<E> extends c<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y0<Object> f41442d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public E[] f41443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41444c;

    static {
        y0<Object> y0Var = new y0<>(new Object[0], 0);
        f41442d = y0Var;
        y0Var.k();
    }

    public y0(E[] eArr, int i11) {
        this.f41443b = eArr;
        this.f41444c = i11;
    }

    public static <E> E[] b(int i11) {
        return (E[]) new Object[i11];
    }

    public static <E> y0<E> e() {
        return (y0<E>) f41442d;
    }

    private void f(int i11) {
        if (i11 < 0 || i11 >= this.f41444c) {
            throw new IndexOutOfBoundsException(g(i11));
        }
    }

    private String g(int i11) {
        return "Index:" + i11 + ", Size:" + this.f41444c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i11, E e11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f41444c)) {
            throw new IndexOutOfBoundsException(g(i11));
        }
        E[] eArr = this.f41443b;
        if (i12 < eArr.length) {
            System.arraycopy(eArr, i11, eArr, i11 + 1, i12 - i11);
        } else {
            E[] eArr2 = (E[]) b(((i12 * 3) / 2) + 1);
            System.arraycopy(this.f41443b, 0, eArr2, 0, i11);
            System.arraycopy(this.f41443b, i11, eArr2, i11 + 1, this.f41444c - i11);
            this.f41443b = eArr2;
        }
        this.f41443b[i11] = e11;
        this.f41444c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e11) {
        a();
        int i11 = this.f41444c;
        E[] eArr = this.f41443b;
        if (i11 == eArr.length) {
            this.f41443b = (E[]) Arrays.copyOf(eArr, ((i11 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f41443b;
        int i12 = this.f41444c;
        this.f41444c = i12 + 1;
        eArr2[i12] = e11;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i11) {
        f(i11);
        return this.f41443b[i11];
    }

    @Override // com.google.protobuf.y.j
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public y0<E> c(int i11) {
        if (i11 >= this.f41444c) {
            return new y0<>(Arrays.copyOf(this.f41443b, i11), this.f41444c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    public E remove(int i11) {
        a();
        f(i11);
        E[] eArr = this.f41443b;
        E e11 = eArr[i11];
        int i12 = this.f41444c;
        if (i11 < i12 - 1) {
            System.arraycopy(eArr, i11 + 1, eArr, i11, (i12 - i11) - 1);
        }
        this.f41444c--;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i11, E e11) {
        a();
        f(i11);
        E[] eArr = this.f41443b;
        E e12 = eArr[i11];
        eArr[i11] = e11;
        ((AbstractList) this).modCount++;
        return e12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f41444c;
    }
}
