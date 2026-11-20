package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class y8 extends gl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a9 f24568n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f24569o;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements kg {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a9 f24570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a9.a f24571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f24572c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f24573d = -1;

        public a(a9 a9Var, a9.a aVar) {
            this.f24570a = a9Var;
            this.f24571b = aVar;
        }

        @Override // com.applovin.impl.kg
        public long a(l8 l8Var) {
            long j11 = this.f24573d;
            if (j11 < 0) {
                return -1L;
            }
            long j12 = -(j11 + 2);
            this.f24573d = -1L;
            return j12;
        }

        @Override // com.applovin.impl.kg
        public ij a() {
            b1.b(this.f24572c != -1);
            return new z8(this.f24570a, this.f24572c);
        }

        @Override // com.applovin.impl.kg
        public void a(long j11) {
            long[] jArr = this.f24571b.f17491a;
            this.f24573d = jArr[xp.b(jArr, j11, true, true)];
        }

        public void b(long j11) {
            this.f24572c = j11;
        }
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    private int b(bh bhVar) {
        int i11 = (bhVar.c()[2] & 255) >> 4;
        if (i11 == 6 || i11 == 7) {
            bhVar.g(4);
            bhVar.D();
        }
        int iB = w8.b(bhVar, i11);
        bhVar.f(0);
        return iB;
    }

    public static boolean c(bh bhVar) {
        return bhVar.a() >= 5 && bhVar.w() == 127 && bhVar.y() == 1179402563;
    }

    @Override // com.applovin.impl.gl
    public long a(bh bhVar) {
        if (a(bhVar.c())) {
            return b(bhVar);
        }
        return -1L;
    }

    @Override // com.applovin.impl.gl
    public void a(boolean z11) {
        super.a(z11);
        if (z11) {
            this.f24568n = null;
            this.f24569o = null;
        }
    }

    @Override // com.applovin.impl.gl
    public boolean a(bh bhVar, long j11, gl.b bVar) {
        byte[] bArrC = bhVar.c();
        a9 a9Var = this.f24568n;
        if (a9Var == null) {
            a9 a9Var2 = new a9(bArrC, 17);
            this.f24568n = a9Var2;
            bVar.f19260a = a9Var2.a(Arrays.copyOfRange(bArrC, 9, bhVar.e()), (bf) null);
            return true;
        }
        if ((bArrC[0] & Ascii.DEL) == 3) {
            a9.a aVarA = x8.a(bhVar);
            a9 a9VarA = a9Var.a(aVarA);
            this.f24568n = a9VarA;
            this.f24569o = new a(a9VarA, aVarA);
            return true;
        }
        if (!a(bArrC)) {
            return true;
        }
        a aVar = this.f24569o;
        if (aVar != null) {
            aVar.b(j11);
            bVar.f19261b = this.f24569o;
        }
        b1.a(bVar.f19260a);
        return false;
    }
}
