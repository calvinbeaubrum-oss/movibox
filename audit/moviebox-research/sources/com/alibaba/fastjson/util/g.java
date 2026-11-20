package com.alibaba.fastjson.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K, V>[] f15571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15572b;

    /* JADX INFO: compiled from: source.java */
    public static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f15574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V f15575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a<K, V> f15576d;

        public a(K k11, V v11, int i11, a<K, V> aVar) {
            this.f15574b = k11;
            this.f15575c = v11;
            this.f15576d = aVar;
            this.f15573a = i11;
        }
    }

    public g() {
        this(8192);
    }

    public g(int i11) {
        this.f15572b = i11 - 1;
        this.f15571a = new a[i11];
    }

    public Class a(String str) {
        int i11 = 0;
        while (true) {
            a<K, V>[] aVarArr = this.f15571a;
            if (i11 >= aVarArr.length) {
                return null;
            }
            a<K, V> aVar = aVarArr[i11];
            if (aVar != null) {
                for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f15576d) {
                    K k11 = aVar.f15574b;
                    if (k11 instanceof Class) {
                        Class cls = (Class) k11;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i11++;
        }
    }

    public final V b(K k11) {
        for (a<K, V> aVar = this.f15571a[System.identityHashCode(k11) & this.f15572b]; aVar != null; aVar = aVar.f15576d) {
            if (k11 == aVar.f15574b) {
                return aVar.f15575c;
            }
        }
        return null;
    }

    public boolean c(K k11, V v11) {
        int iIdentityHashCode = System.identityHashCode(k11);
        int i11 = this.f15572b & iIdentityHashCode;
        for (a<K, V> aVar = this.f15571a[i11]; aVar != null; aVar = aVar.f15576d) {
            if (k11 == aVar.f15574b) {
                aVar.f15575c = v11;
                return true;
            }
        }
        this.f15571a[i11] = new a<>(k11, v11, iIdentityHashCode, this.f15571a[i11]);
        return false;
    }
}
