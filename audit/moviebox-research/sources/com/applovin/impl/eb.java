package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class eb extends cb implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final qp f18678b = new b(mi.f21163f, 0);

    /* JADX INFO: compiled from: source.java */
    public static final class a extends cb.a {
        public a() {
            this(4);
        }

        public a(int i11) {
            super(i11);
        }

        public eb a() {
            this.f18172c = true;
            return eb.b(this.f18170a, this.f18171b);
        }

        public a b(Object obj) {
            super.a(obj);
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends com.applovin.impl.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final eb f18679c;

        public b(eb ebVar, int i11) {
            super(ebVar.size(), i11);
            this.f18679c = ebVar;
        }

        @Override // com.applovin.impl.c
        public Object a(int i11) {
            return this.f18679c.get(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends eb {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient int f18680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final transient int f18681d;

        public c(int i11, int i12) {
            this.f18680c = i11;
            this.f18681d = i12;
        }

        @Override // com.applovin.impl.eb, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public eb subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, this.f18681d);
            eb ebVar = eb.this;
            int i13 = this.f18680c;
            return ebVar.subList(i11 + i13, i12 + i13);
        }

        @Override // com.applovin.impl.cb
        public Object[] b() {
            return eb.this.b();
        }

        @Override // com.applovin.impl.cb
        public int c() {
            return eb.this.d() + this.f18680c + this.f18681d;
        }

        @Override // com.applovin.impl.cb
        public int d() {
            return eb.this.d() + this.f18680c;
        }

        @Override // com.applovin.impl.cb
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i11) {
            Preconditions.checkElementIndex(i11, this.f18681d);
            return eb.this.get(i11 + this.f18680c);
        }

        @Override // com.applovin.impl.eb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.applovin.impl.eb, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.applovin.impl.eb, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i11) {
            return super.listIterator(i11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f18681d;
        }
    }

    public static eb a(Object obj) {
        return b(obj);
    }

    public static eb a(Object obj, Object obj2) {
        return b(obj, obj2);
    }

    public static eb a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return b(obj, obj2, obj3, obj4, obj5);
    }

    public static eb a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return b(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public static eb a(Collection collection) {
        if (!(collection instanceof cb)) {
            return b(collection.toArray());
        }
        eb ebVarA = ((cb) collection).a();
        return ebVarA.e() ? a(ebVarA.toArray()) : ebVarA;
    }

    public static eb a(Comparator comparator, Iterable iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] objArrC = wb.c(iterable);
        gg.a(objArrC);
        Arrays.sort(objArrC, comparator);
        return a(objArrC);
    }

    public static eb a(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    private static eb b(Object... objArr) {
        return a(gg.a(objArr));
    }

    public static eb b(Object[] objArr, int i11) {
        return i11 == 0 ? h() : new mi(objArr, i11);
    }

    public static eb c(Object[] objArr) {
        return objArr.length == 0 ? h() : b((Object[]) objArr.clone());
    }

    public static a f() {
        return new a();
    }

    public static eb h() {
        return mi.f21163f;
    }

    @Override // com.applovin.impl.cb
    public int a(Object[] objArr, int i11) {
        int size = size();
        for (int i12 = 0; i12 < size; i12++) {
            objArr[i11 + i12] = get(i12);
        }
        return i11 + size;
    }

    @Override // com.applovin.impl.cb
    public final eb a() {
        return this;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a */
    public eb subList(int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i12, size());
        int i13 = i12 - i11;
        if (i13 == size()) {
            return this;
        }
        return i13 == 0 ? h() : b(i11, i12);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public qp listIterator(int i11) {
        Preconditions.checkPositionIndex(i11, size());
        return isEmpty() ? f18678b : new b(this, i11);
    }

    @Override // java.util.List
    public final void add(int i11, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i11, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public eb b(int i11, int i12) {
        return new c(i11, i12 - i11);
    }

    @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return ic.a(this, obj);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public qp listIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i11 = 1;
        for (int i12 = 0; i12 < size; i12++) {
            i11 = ~(~((i11 * 31) + get(i12).hashCode()));
        }
        return i11;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ic.b(this, obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public pp iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return ic.d(this, obj);
    }

    @Override // java.util.List
    public final Object remove(int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i11, Object obj) {
        throw new UnsupportedOperationException();
    }
}
