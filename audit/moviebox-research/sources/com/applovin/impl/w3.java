package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.android.gms.common.api.Api;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class w3 extends AbstractMap implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient int[] f24020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    transient long[] f24021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient Object[] f24022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient Object[] f24023d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    transient float f24024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    transient int f24025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f24026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient int f24027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient Set f24028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient Set f24029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private transient Collection f24030l;

    /* JADX INFO: compiled from: source.java */
    public class a extends e {
        public a() {
            super(w3.this, null);
        }

        @Override // com.applovin.impl.w3.e
        public Object a(int i11) {
            return w3.this.f24022c[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends e {
        public b() {
            super(w3.this, null);
        }

        @Override // com.applovin.impl.w3.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry a(int i11) {
            return w3.this.new g(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends e {
        public c() {
            super(w3.this, null);
        }

        @Override // com.applovin.impl.w3.e
        public Object a(int i11) {
            return w3.this.f24023d[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends AbstractSet {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            w3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iA = w3.this.a(entry.getKey());
            return iA != -1 && Objects.equal(w3.this.f24023d[iA], entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return w3.this.e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iA = w3.this.a(entry.getKey());
            if (iA == -1 || !Objects.equal(w3.this.f24023d[iA], entry.getValue())) {
                return false;
            }
            w3.this.f(iA);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return w3.this.f24027i;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class e implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f24035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f24036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f24037c;

        private e() {
            this.f24035a = w3.this.f24025g;
            this.f24036b = w3.this.f();
            this.f24037c = -1;
        }

        public /* synthetic */ e(w3 w3Var, a aVar) {
            this();
        }

        private void a() {
            if (w3.this.f24025g != this.f24035a) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object a(int i11);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24036b >= 0;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i11 = this.f24036b;
            this.f24037c = i11;
            Object objA = a(i11);
            this.f24036b = w3.this.b(this.f24036b);
            return objA;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            p3.a(this.f24037c >= 0);
            this.f24035a++;
            w3.this.f(this.f24037c);
            this.f24036b = w3.this.a(this.f24036b, this.f24037c);
            this.f24037c = -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends AbstractSet {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            w3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return w3.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return w3.this.h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iA = w3.this.a(obj);
            if (iA == -1) {
                return false;
            }
            w3.this.f(iA);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return w3.this.f24027i;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class g extends com.applovin.impl.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f24040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f24041b;

        public g(int i11) {
            this.f24040a = w3.this.f24022c[i11];
            this.f24041b = i11;
        }

        private void a() {
            int i11 = this.f24041b;
            if (i11 == -1 || i11 >= w3.this.size() || !Objects.equal(this.f24040a, w3.this.f24022c[this.f24041b])) {
                this.f24041b = w3.this.a(this.f24040a);
            }
        }

        @Override // com.applovin.impl.g, java.util.Map.Entry
        public Object getKey() {
            return this.f24040a;
        }

        @Override // com.applovin.impl.g, java.util.Map.Entry
        public Object getValue() {
            a();
            int i11 = this.f24041b;
            if (i11 == -1) {
                return null;
            }
            return w3.this.f24023d[i11];
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            int i11 = this.f24041b;
            if (i11 == -1) {
                w3.this.put(this.f24040a, obj);
                return null;
            }
            Object[] objArr = w3.this.f24023d;
            Object obj2 = objArr[i11];
            objArr[i11] = obj;
            return obj2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends AbstractCollection {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            w3.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return w3.this.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return w3.this.f24027i;
        }
    }

    public w3() {
        a(3, 1.0f);
    }

    private static int a(long j11) {
        return (int) (j11 >>> 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Object obj) {
        int iA = ka.a(obj);
        int iB = this.f24020a[g() & iA];
        while (iB != -1) {
            long j11 = this.f24021b[iB];
            if (a(j11) == iA && Objects.equal(obj, this.f24022c[iB])) {
                return iB;
            }
            iB = b(j11);
        }
        return -1;
    }

    private static long a(long j11, int i11) {
        return (j11 & (-4294967296L)) | (((long) i11) & 4294967295L);
    }

    public static w3 a() {
        return new w3();
    }

    private Object a(Object obj, int i11) {
        int iG = g() & i11;
        int i12 = this.f24020a[iG];
        if (i12 == -1) {
            return null;
        }
        int i13 = -1;
        while (true) {
            if (a(this.f24021b[i12]) == i11 && Objects.equal(obj, this.f24022c[i12])) {
                Object obj2 = this.f24023d[i12];
                if (i13 == -1) {
                    this.f24020a[iG] = b(this.f24021b[i12]);
                } else {
                    long[] jArr = this.f24021b;
                    jArr[i13] = a(jArr[i13], b(jArr[i12]));
                }
                c(i12);
                this.f24027i--;
                this.f24025g++;
                return obj2;
            }
            int iB = b(this.f24021b[i12]);
            if (iB == -1) {
                return null;
            }
            i13 = i12;
            i12 = iB;
        }
    }

    private static int b(long j11) {
        return (int) j11;
    }

    private static long[] d(int i11) {
        long[] jArr = new long[i11];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] e(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object f(int i11) {
        return a(this.f24022c[i11], a(this.f24021b[i11]));
    }

    private int g() {
        return this.f24020a.length - 1;
    }

    private void h(int i11) {
        int length = this.f24021b.length;
        if (i11 > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (iMax != length) {
                g(iMax);
            }
        }
    }

    private void i(int i11) {
        if (this.f24020a.length >= 1073741824) {
            this.f24026h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            return;
        }
        int i12 = ((int) (i11 * this.f24024f)) + 1;
        int[] iArrE = e(i11);
        long[] jArr = this.f24021b;
        int length = iArrE.length - 1;
        for (int i13 = 0; i13 < this.f24027i; i13++) {
            int iA = a(jArr[i13]);
            int i14 = iA & length;
            int i15 = iArrE[i14];
            iArrE[i14] = i13;
            jArr[i13] = (((long) iA) << 32) | (((long) i15) & 4294967295L);
        }
        this.f24026h = i12;
        this.f24020a = iArrE;
    }

    public int a(int i11, int i12) {
        return i11 - 1;
    }

    public void a(int i11) {
    }

    public void a(int i11, float f11) {
        Preconditions.checkArgument(i11 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f11 > 0.0f, "Illegal load factor");
        int iA = ka.a(i11, f11);
        this.f24020a = e(iA);
        this.f24024f = f11;
        this.f24022c = new Object[i11];
        this.f24023d = new Object[i11];
        this.f24021b = d(i11);
        this.f24026h = Math.max(1, (int) (iA * f11));
    }

    public void a(int i11, Object obj, Object obj2, int i12) {
        this.f24021b[i11] = (((long) i12) << 32) | 4294967295L;
        this.f24022c[i11] = obj;
        this.f24023d[i11] = obj2;
    }

    public int b(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.f24027i) {
            return i12;
        }
        return -1;
    }

    public Set b() {
        return new d();
    }

    public Set c() {
        return new f();
    }

    public void c(int i11) {
        int size = size() - 1;
        if (i11 >= size) {
            this.f24022c[i11] = null;
            this.f24023d[i11] = null;
            this.f24021b[i11] = -1;
            return;
        }
        Object[] objArr = this.f24022c;
        objArr[i11] = objArr[size];
        Object[] objArr2 = this.f24023d;
        objArr2[i11] = objArr2[size];
        objArr[size] = null;
        objArr2[size] = null;
        long[] jArr = this.f24021b;
        long j11 = jArr[size];
        jArr[i11] = j11;
        jArr[size] = -1;
        int iA = a(j11) & g();
        int[] iArr = this.f24020a;
        int i12 = iArr[iA];
        if (i12 == size) {
            iArr[iA] = i11;
            return;
        }
        while (true) {
            long j12 = this.f24021b[i12];
            int iB = b(j12);
            if (iB == size) {
                this.f24021b[i12] = a(j12, i11);
                return;
            }
            i12 = iB;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f24025g++;
        Arrays.fill(this.f24022c, 0, this.f24027i, (Object) null);
        Arrays.fill(this.f24023d, 0, this.f24027i, (Object) null);
        Arrays.fill(this.f24020a, -1);
        Arrays.fill(this.f24021b, -1L);
        this.f24027i = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        for (int i11 = 0; i11 < this.f24027i; i11++) {
            if (Objects.equal(obj, this.f24023d[i11])) {
                return true;
            }
        }
        return false;
    }

    public Collection d() {
        return new h();
    }

    public Iterator e() {
        return new b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f24029k;
        if (set != null) {
            return set;
        }
        Set setB = b();
        this.f24029k = setB;
        return setB;
    }

    public int f() {
        return isEmpty() ? -1 : 0;
    }

    public void g(int i11) {
        this.f24022c = Arrays.copyOf(this.f24022c, i11);
        this.f24023d = Arrays.copyOf(this.f24023d, i11);
        long[] jArr = this.f24021b;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, i11);
        if (i11 > length) {
            Arrays.fill(jArrCopyOf, length, i11, -1L);
        }
        this.f24021b = jArrCopyOf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        int iA = a(obj);
        a(iA);
        if (iA == -1) {
            return null;
        }
        return this.f24023d[iA];
    }

    public Iterator h() {
        return new a();
    }

    public Iterator i() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f24027i == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f24028j;
        if (set != null) {
            return set;
        }
        Set setC = c();
        this.f24028j = setC;
        return setC;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        long[] jArr = this.f24021b;
        Object[] objArr = this.f24022c;
        Object[] objArr2 = this.f24023d;
        int iA = ka.a(obj);
        int iG = g() & iA;
        int i11 = this.f24027i;
        int[] iArr = this.f24020a;
        int i12 = iArr[iG];
        if (i12 == -1) {
            iArr[iG] = i11;
        } else {
            while (true) {
                long j11 = jArr[i12];
                if (a(j11) == iA && Objects.equal(obj, objArr[i12])) {
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = obj2;
                    a(i12);
                    return obj3;
                }
                int iB = b(j11);
                if (iB == -1) {
                    jArr[i12] = a(j11, i11);
                    break;
                }
                i12 = iB;
            }
        }
        if (i11 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i13 = i11 + 1;
        h(i13);
        a(i11, obj, obj2, iA);
        this.f24027i = i13;
        if (i11 >= this.f24026h) {
            i(this.f24020a.length * 2);
        }
        this.f24025g++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return a(obj, ka.a(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f24027i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f24030l;
        if (collection != null) {
            return collection;
        }
        Collection collectionD = d();
        this.f24030l = collectionD;
        return collectionD;
    }
}
