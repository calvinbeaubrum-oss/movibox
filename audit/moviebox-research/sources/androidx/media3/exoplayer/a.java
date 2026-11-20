package androidx.media3.exoplayer;

import android.util.Pair;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends androidx.media3.common.m0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p4.f0 f9820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9821h;

    public a(boolean z11, p4.f0 f0Var) {
        this.f9821h = z11;
        this.f9820g = f0Var;
        this.f9819f = f0Var.getLength();
    }

    public static Object v(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object w(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object y(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract int A(int i11);

    public final int B(int i11, boolean z11) {
        if (z11) {
            return this.f9820g.getNextIndex(i11);
        }
        if (i11 < this.f9819f - 1) {
            return i11 + 1;
        }
        return -1;
    }

    public final int C(int i11, boolean z11) {
        if (z11) {
            return this.f9820g.getPreviousIndex(i11);
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        return -1;
    }

    public abstract androidx.media3.common.m0 D(int i11);

    @Override // androidx.media3.common.m0
    public int a(boolean z11) {
        if (this.f9819f == 0) {
            return -1;
        }
        if (this.f9821h) {
            z11 = false;
        }
        int firstIndex = z11 ? this.f9820g.getFirstIndex() : 0;
        while (D(firstIndex).q()) {
            firstIndex = B(firstIndex, z11);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return A(firstIndex) + D(firstIndex).a(z11);
    }

    @Override // androidx.media3.common.m0
    public final int b(Object obj) {
        int iB;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objW = w(obj);
        Object objV = v(obj);
        int iS = s(objW);
        if (iS == -1 || (iB = D(iS).b(objV)) == -1) {
            return -1;
        }
        return z(iS) + iB;
    }

    @Override // androidx.media3.common.m0
    public int c(boolean z11) {
        int i11 = this.f9819f;
        if (i11 == 0) {
            return -1;
        }
        if (this.f9821h) {
            z11 = false;
        }
        int lastIndex = z11 ? this.f9820g.getLastIndex() : i11 - 1;
        while (D(lastIndex).q()) {
            lastIndex = C(lastIndex, z11);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return A(lastIndex) + D(lastIndex).c(z11);
    }

    @Override // androidx.media3.common.m0
    public int e(int i11, int i12, boolean z11) {
        if (this.f9821h) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int iU = u(i11);
        int iA = A(iU);
        int iE = D(iU).e(i11 - iA, i12 != 2 ? i12 : 0, z11);
        if (iE != -1) {
            return iA + iE;
        }
        int iB = B(iU, z11);
        while (iB != -1 && D(iB).q()) {
            iB = B(iB, z11);
        }
        if (iB != -1) {
            return A(iB) + D(iB).a(z11);
        }
        if (i12 == 2) {
            return a(z11);
        }
        return -1;
    }

    @Override // androidx.media3.common.m0
    public final androidx.media3.common.m0.b g(int i11, androidx.media3.common.m0.b bVar, boolean z11) {
        int iT = t(i11);
        int iA = A(iT);
        D(iT).g(i11 - z(iT), bVar, z11);
        bVar.f9295c += iA;
        if (z11) {
            bVar.f9294b = y(x(iT), z3.a.e(bVar.f9294b));
        }
        return bVar;
    }

    @Override // androidx.media3.common.m0
    public final androidx.media3.common.m0.b h(Object obj, androidx.media3.common.m0.b bVar) {
        Object objW = w(obj);
        Object objV = v(obj);
        int iS = s(objW);
        int iA = A(iS);
        D(iS).h(objV, bVar);
        bVar.f9295c += iA;
        bVar.f9294b = obj;
        return bVar;
    }

    @Override // androidx.media3.common.m0
    public int l(int i11, int i12, boolean z11) {
        if (this.f9821h) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int iU = u(i11);
        int iA = A(iU);
        int iL = D(iU).l(i11 - iA, i12 != 2 ? i12 : 0, z11);
        if (iL != -1) {
            return iA + iL;
        }
        int iC = C(iU, z11);
        while (iC != -1 && D(iC).q()) {
            iC = C(iC, z11);
        }
        if (iC != -1) {
            return A(iC) + D(iC).c(z11);
        }
        if (i12 == 2) {
            return c(z11);
        }
        return -1;
    }

    @Override // androidx.media3.common.m0
    public final Object m(int i11) {
        int iT = t(i11);
        return y(x(iT), D(iT).m(i11 - z(iT)));
    }

    @Override // androidx.media3.common.m0
    public final androidx.media3.common.m0.c o(int i11, androidx.media3.common.m0.c cVar, long j11) {
        int iU = u(i11);
        int iA = A(iU);
        int iZ = z(iU);
        D(iU).o(i11 - iA, cVar, j11);
        Object objX = x(iU);
        if (!androidx.media3.common.m0.c.f9300r.equals(cVar.f9309a)) {
            objX = y(objX, cVar.f9309a);
        }
        cVar.f9309a = objX;
        cVar.f9323o += iZ;
        cVar.f9324p += iZ;
        return cVar;
    }

    public abstract int s(Object obj);

    public abstract int t(int i11);

    public abstract int u(int i11);

    public abstract Object x(int i11);

    public abstract int z(int i11);
}
