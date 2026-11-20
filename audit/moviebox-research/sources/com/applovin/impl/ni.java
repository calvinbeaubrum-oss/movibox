package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ni extends gb {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final gb f21335i = new ni(null, new Object[0], 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient int[] f21336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient Object[] f21337g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f21338h;

    /* JADX INFO: compiled from: source.java */
    public static class a extends ib {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient gb f21339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient Object[] f21340d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f21341f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final transient int f21342g;

        /* JADX INFO: renamed from: com.applovin.impl.ni$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0192a extends eb {
            public C0192a() {
            }

            @Override // java.util.List
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i11) {
                Preconditions.checkElementIndex(i11, a.this.f21342g);
                int i12 = i11 * 2;
                return new AbstractMap.SimpleImmutableEntry(a.this.f21340d[a.this.f21341f + i12], a.this.f21340d[i12 + (a.this.f21341f ^ 1)]);
            }

            @Override // com.applovin.impl.cb
            public boolean e() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f21342g;
            }
        }

        public a(gb gbVar, Object[] objArr, int i11, int i12) {
            this.f21339c = gbVar;
            this.f21340d = objArr;
            this.f21341f = i11;
            this.f21342g = i12;
        }

        @Override // com.applovin.impl.cb
        public int a(Object[] objArr, int i11) {
            return a().a(objArr, i11);
        }

        @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f21339c.get(key));
        }

        @Override // com.applovin.impl.cb
        public boolean e() {
            return true;
        }

        @Override // com.applovin.impl.ib
        public eb f() {
            return new C0192a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public pp iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f21342g;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends ib {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient gb f21344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient eb f21345d;

        public b(gb gbVar, eb ebVar) {
            this.f21344c = gbVar;
            this.f21345d = ebVar;
        }

        @Override // com.applovin.impl.cb
        public int a(Object[] objArr, int i11) {
            return a().a(objArr, i11);
        }

        @Override // com.applovin.impl.ib, com.applovin.impl.cb
        public eb a() {
            return this.f21345d;
        }

        @Override // com.applovin.impl.cb, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f21344c.get(obj) != null;
        }

        @Override // com.applovin.impl.cb
        public boolean e() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public pp iterator() {
            return a().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f21344c.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends eb {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final transient Object[] f21346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient int f21347d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final transient int f21348f;

        public c(Object[] objArr, int i11, int i12) {
            this.f21346c = objArr;
            this.f21347d = i11;
            this.f21348f = i12;
        }

        @Override // com.applovin.impl.cb
        public boolean e() {
            return true;
        }

        @Override // java.util.List
        public Object get(int i11) {
            Preconditions.checkElementIndex(i11, this.f21348f);
            return this.f21346c[(i11 * 2) + this.f21347d];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f21348f;
        }
    }

    private ni(int[] iArr, Object[] objArr, int i11) {
        this.f21336f = iArr;
        this.f21337g = objArr;
        this.f21338h = i11;
    }

    public static ni a(int i11, Object[] objArr) {
        if (i11 == 0) {
            return (ni) f21335i;
        }
        if (i11 == 1) {
            p3.a(objArr[0], objArr[1]);
            return new ni(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i11, objArr.length >> 1);
        return new ni(a(objArr, i11, ib.a(i11), 0), objArr, i11);
    }

    public static Object a(int[] iArr, Object[] objArr, int i11, int i12, Object obj) {
        if (obj == null) {
            return null;
        }
        if (i11 == 1) {
            if (objArr[i12].equals(obj)) {
                return objArr[i12 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int iA = ka.a(obj.hashCode());
        while (true) {
            int i13 = iA & length;
            int i14 = iArr[i13];
            if (i14 == -1) {
                return null;
            }
            if (objArr[i14].equals(obj)) {
                return objArr[i14 ^ 1];
            }
            iA = i13 + 1;
        }
    }

    public static int[] a(Object[] objArr, int i11, int i12, int i13) {
        int i14;
        if (i11 == 1) {
            p3.a(objArr[i13], objArr[i13 ^ 1]);
            return null;
        }
        int i15 = i12 - 1;
        int[] iArr = new int[i12];
        Arrays.fill(iArr, -1);
        for (int i16 = 0; i16 < i11; i16++) {
            int i17 = i16 * 2;
            int i18 = i17 + i13;
            Object obj = objArr[i18];
            Object obj2 = objArr[i17 + (i13 ^ 1)];
            p3.a(obj, obj2);
            int iA = ka.a(obj.hashCode());
            while (true) {
                i14 = iA & i15;
                int i19 = iArr[i14];
                if (i19 == -1) {
                    break;
                }
                if (objArr[i19].equals(obj)) {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i19] + "=" + objArr[i19 ^ 1]);
                }
                iA = i14 + 1;
            }
            iArr[i14] = i18;
        }
        return iArr;
    }

    @Override // com.applovin.impl.gb
    public ib b() {
        return new a(this, this.f21337g, 0, this.f21338h);
    }

    @Override // com.applovin.impl.gb
    public ib c() {
        return new b(this, new c(this.f21337g, 0, this.f21338h));
    }

    @Override // com.applovin.impl.gb
    public cb d() {
        return new c(this.f21337g, 1, this.f21338h);
    }

    @Override // com.applovin.impl.gb
    public boolean f() {
        return false;
    }

    @Override // com.applovin.impl.gb, java.util.Map
    public Object get(Object obj) {
        return a(this.f21336f, this.f21337g, this.f21338h, 0, obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f21338h;
    }
}
