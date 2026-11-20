package com.applovin.impl;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gb implements Map, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map.Entry[] f19198d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient ib f19199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient ib f19200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient cb f19201c;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator f19202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object[] f19203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19204c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f19205d;

        public a() {
            this(4);
        }

        public a(int i11) {
            this.f19203b = new Object[i11 * 2];
            this.f19204c = 0;
            this.f19205d = false;
        }

        private void a(int i11) {
            int i12 = i11 * 2;
            Object[] objArr = this.f19203b;
            if (i12 > objArr.length) {
                this.f19203b = Arrays.copyOf(objArr, cb.b.a(objArr.length, i12));
                this.f19205d = false;
            }
        }

        public a a(Iterable iterable) {
            if (iterable instanceof Collection) {
                a(this.f19204c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a((Map.Entry) it.next());
            }
            return this;
        }

        public a a(Object obj, Object obj2) {
            a(this.f19204c + 1);
            p3.a(obj, obj2);
            Object[] objArr = this.f19203b;
            int i11 = this.f19204c;
            int i12 = i11 * 2;
            objArr[i12] = obj;
            objArr[i12 + 1] = obj2;
            this.f19204c = i11 + 1;
            return this;
        }

        public a a(Map.Entry entry) {
            return a(entry.getKey(), entry.getValue());
        }

        public gb a() {
            b();
            this.f19205d = true;
            return ni.a(this.f19204c, this.f19203b);
        }

        public void b() {
            int i11;
            if (this.f19202a != null) {
                if (this.f19205d) {
                    this.f19203b = Arrays.copyOf(this.f19203b, this.f19204c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f19204c];
                int i12 = 0;
                while (true) {
                    i11 = this.f19204c;
                    if (i12 >= i11) {
                        break;
                    }
                    Object[] objArr = this.f19203b;
                    int i13 = i12 * 2;
                    entryArr[i12] = new AbstractMap.SimpleImmutableEntry(objArr[i13], objArr[i13 + 1]);
                    i12++;
                }
                Arrays.sort(entryArr, 0, i11, wg.a(this.f19202a).a(vc.c()));
                for (int i14 = 0; i14 < this.f19204c; i14++) {
                    int i15 = i14 * 2;
                    this.f19203b[i15] = entryArr[i14].getKey();
                    this.f19203b[i15 + 1] = entryArr[i14].getValue();
                }
            }
        }
    }

    public static a a() {
        return new a();
    }

    public static gb a(Iterable iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.a(iterable);
        return aVar.a();
    }

    public static gb a(Map map) {
        if ((map instanceof gb) && !(map instanceof SortedMap)) {
            gb gbVar = (gb) map;
            if (!gbVar.f()) {
                return gbVar;
            }
        }
        return a(map.entrySet());
    }

    public static gb h() {
        return ni.f21335i;
    }

    public abstract ib b();

    public abstract ib c();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract cb d();

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public ib entrySet() {
        ib ibVar = this.f19199a;
        if (ibVar != null) {
            return ibVar;
        }
        ib ibVarB = b();
        this.f19199a = ibVarB;
        return ibVarB;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return vc.a((Map) this, obj);
    }

    public abstract boolean f();

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ib keySet() {
        ib ibVar = this.f19200b;
        if (ibVar != null) {
            return ibVar;
        }
        ib ibVarC = c();
        this.f19200b = ibVarC;
        return ibVarC;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return rj.a(entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public cb values() {
        cb cbVar = this.f19201c;
        if (cbVar != null) {
            return cbVar;
        }
        cb cbVarD = d();
        this.f19201c = cbVarD;
        return cbVarD;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return vc.a(this);
    }
}
