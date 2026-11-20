package com.applovin.impl;

import android.util.Pair;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends fo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final wj f17800d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17801f;

    public b(boolean z11, wj wjVar) {
        this.f17801f = z11;
        this.f17800d = wjVar;
        this.f17799c = wjVar.a();
    }

    private int a(int i11, boolean z11) {
        if (z11) {
            return this.f17800d.a(i11);
        }
        if (i11 < this.f17799c - 1) {
            return i11 + 1;
        }
        return -1;
    }

    public static Object a(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int b(int i11, boolean z11) {
        if (z11) {
            return this.f17800d.b(i11);
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        return -1;
    }

    public static Object c(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object d(Object obj) {
        return ((Pair) obj).first;
    }

    @Override // com.applovin.impl.fo
    public int a(int i11, int i12, boolean z11) {
        if (this.f17801f) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int iE = e(i11);
        int iH = h(iE);
        int iA = i(iE).a(i11 - iH, i12 != 2 ? i12 : 0, z11);
        if (iA != -1) {
            return iH + iA;
        }
        int iA2 = a(iE, z11);
        while (iA2 != -1 && i(iA2).c()) {
            iA2 = a(iA2, z11);
        }
        if (iA2 != -1) {
            return h(iA2) + i(iA2).a(z11);
        }
        if (i12 == 2) {
            return a(z11);
        }
        return -1;
    }

    @Override // com.applovin.impl.fo
    public final int a(Object obj) {
        int iA;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objD = d(obj);
        Object objC = c(obj);
        int iB = b(objD);
        if (iB == -1 || (iA = i(iB).a(objC)) == -1) {
            return -1;
        }
        return g(iB) + iA;
    }

    @Override // com.applovin.impl.fo
    public int a(boolean z11) {
        if (this.f17799c == 0) {
            return -1;
        }
        if (this.f17801f) {
            z11 = false;
        }
        int iB = z11 ? this.f17800d.b() : 0;
        while (i(iB).c()) {
            iB = a(iB, z11);
            if (iB == -1) {
                return -1;
            }
        }
        return h(iB) + i(iB).a(z11);
    }

    @Override // com.applovin.impl.fo
    public final fo.b a(int i11, fo.b bVar, boolean z11) {
        int iD = d(i11);
        int iH = h(iD);
        i(iD).a(i11 - g(iD), bVar, z11);
        bVar.f19033c += iH;
        if (z11) {
            bVar.f19032b = a(f(iD), b1.a(bVar.f19032b));
        }
        return bVar;
    }

    @Override // com.applovin.impl.fo
    public final fo.b a(Object obj, fo.b bVar) {
        Object objD = d(obj);
        Object objC = c(obj);
        int iB = b(objD);
        int iH = h(iB);
        i(iB).a(objC, bVar);
        bVar.f19033c += iH;
        bVar.f19032b = obj;
        return bVar;
    }

    @Override // com.applovin.impl.fo
    public final fo.d a(int i11, fo.d dVar, long j11) {
        int iE = e(i11);
        int iH = h(iE);
        int iG = g(iE);
        i(iE).a(i11 - iH, dVar, j11);
        Object objF = f(iE);
        if (!fo.d.f19042s.equals(dVar.f19046a)) {
            objF = a(objF, dVar.f19046a);
        }
        dVar.f19046a = objF;
        dVar.f19060p += iG;
        dVar.f19061q += iG;
        return dVar;
    }

    @Override // com.applovin.impl.fo
    public int b(int i11, int i12, boolean z11) {
        if (this.f17801f) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int iE = e(i11);
        int iH = h(iE);
        int iB = i(iE).b(i11 - iH, i12 != 2 ? i12 : 0, z11);
        if (iB != -1) {
            return iH + iB;
        }
        int iB2 = b(iE, z11);
        while (iB2 != -1 && i(iB2).c()) {
            iB2 = b(iB2, z11);
        }
        if (iB2 != -1) {
            return h(iB2) + i(iB2).b(z11);
        }
        if (i12 == 2) {
            return b(z11);
        }
        return -1;
    }

    public abstract int b(Object obj);

    @Override // com.applovin.impl.fo
    public int b(boolean z11) {
        int i11 = this.f17799c;
        if (i11 == 0) {
            return -1;
        }
        if (this.f17801f) {
            z11 = false;
        }
        int iC = z11 ? this.f17800d.c() : i11 - 1;
        while (i(iC).c()) {
            iC = b(iC, z11);
            if (iC == -1) {
                return -1;
            }
        }
        return h(iC) + i(iC).b(z11);
    }

    @Override // com.applovin.impl.fo
    public final Object b(int i11) {
        int iD = d(i11);
        return a(f(iD), i(iD).b(i11 - g(iD)));
    }

    public abstract int d(int i11);

    public abstract int e(int i11);

    public abstract Object f(int i11);

    public abstract int g(int i11);

    public abstract int h(int i11);

    public abstract fo i(int i11);
}
