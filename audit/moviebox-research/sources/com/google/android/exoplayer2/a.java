package com.google.android.exoplayer2;

import android.util.Pair;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends j3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nh.e0 f32681d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f32682f;

    public a(boolean z11, nh.e0 e0Var) {
        this.f32682f = z11;
        this.f32681d = e0Var;
        this.f32680c = e0Var.getLength();
    }

    public static Object B(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object C(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object E(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract int A(int i11);

    public abstract Object D(int i11);

    public abstract int F(int i11);

    public abstract int G(int i11);

    public final int H(int i11, boolean z11) {
        if (z11) {
            return this.f32681d.getNextIndex(i11);
        }
        if (i11 < this.f32680c - 1) {
            return i11 + 1;
        }
        return -1;
    }

    public final int I(int i11, boolean z11) {
        if (z11) {
            return this.f32681d.getPreviousIndex(i11);
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        return -1;
    }

    public abstract j3 J(int i11);

    @Override // com.google.android.exoplayer2.j3
    public int e(boolean z11) {
        if (this.f32680c == 0) {
            return -1;
        }
        if (this.f32682f) {
            z11 = false;
        }
        int firstIndex = z11 ? this.f32681d.getFirstIndex() : 0;
        while (J(firstIndex).u()) {
            firstIndex = H(firstIndex, z11);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return G(firstIndex) + J(firstIndex).e(z11);
    }

    @Override // com.google.android.exoplayer2.j3
    public final int f(Object obj) {
        int iF;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objC = C(obj);
        Object objB = B(obj);
        int iY = y(objC);
        if (iY == -1 || (iF = J(iY).f(objB)) == -1) {
            return -1;
        }
        return F(iY) + iF;
    }

    @Override // com.google.android.exoplayer2.j3
    public int g(boolean z11) {
        int i11 = this.f32680c;
        if (i11 == 0) {
            return -1;
        }
        if (this.f32682f) {
            z11 = false;
        }
        int lastIndex = z11 ? this.f32681d.getLastIndex() : i11 - 1;
        while (J(lastIndex).u()) {
            lastIndex = I(lastIndex, z11);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return G(lastIndex) + J(lastIndex).g(z11);
    }

    @Override // com.google.android.exoplayer2.j3
    public int i(int i11, int i12, boolean z11) {
        if (this.f32682f) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int iA = A(i11);
        int iG = G(iA);
        int i13 = J(iA).i(i11 - iG, i12 != 2 ? i12 : 0, z11);
        if (i13 != -1) {
            return iG + i13;
        }
        int iH = H(iA, z11);
        while (iH != -1 && J(iH).u()) {
            iH = H(iH, z11);
        }
        if (iH != -1) {
            return G(iH) + J(iH).e(z11);
        }
        if (i12 == 2) {
            return e(z11);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.j3
    public final j3.b k(int i11, j3.b bVar, boolean z11) {
        int iZ = z(i11);
        int iG = G(iZ);
        J(iZ).k(i11 - F(iZ), bVar, z11);
        bVar.f33364c += iG;
        if (z11) {
            bVar.f33363b = E(D(iZ), com.google.android.exoplayer2.util.a.e(bVar.f33363b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.j3
    public final j3.b l(Object obj, j3.b bVar) {
        Object objC = C(obj);
        Object objB = B(obj);
        int iY = y(objC);
        int iG = G(iY);
        J(iY).l(objB, bVar);
        bVar.f33364c += iG;
        bVar.f33363b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.j3
    public int p(int i11, int i12, boolean z11) {
        if (this.f32682f) {
            if (i12 == 1) {
                i12 = 2;
            }
            z11 = false;
        }
        int iA = A(i11);
        int iG = G(iA);
        int iP = J(iA).p(i11 - iG, i12 != 2 ? i12 : 0, z11);
        if (iP != -1) {
            return iG + iP;
        }
        int I = I(iA, z11);
        while (I != -1 && J(I).u()) {
            I = I(I, z11);
        }
        if (I != -1) {
            return G(I) + J(I).g(z11);
        }
        if (i12 == 2) {
            return g(z11);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.j3
    public final Object q(int i11) {
        int iZ = z(i11);
        return E(D(iZ), J(iZ).q(i11 - F(iZ)));
    }

    @Override // com.google.android.exoplayer2.j3
    public final j3.d s(int i11, j3.d dVar, long j11) {
        int iA = A(i11);
        int iG = G(iA);
        int iF = F(iA);
        J(iA).s(i11 - iG, dVar, j11);
        Object objD = D(iA);
        if (!j3.d.f33373s.equals(dVar.f33377a)) {
            objD = E(objD, dVar.f33377a);
        }
        dVar.f33377a = objD;
        dVar.f33391p += iF;
        dVar.f33392q += iF;
        return dVar;
    }

    public abstract int y(Object obj);

    public abstract int z(int i11);
}
