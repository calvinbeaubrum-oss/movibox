package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n0 f17709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f17711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f17712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f17713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f17714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17715g;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m0 f17719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f17720e;

        public a(long j11, int i11) {
            this.f17716a = j11;
            this.f17717b = j11 + ((long) i11);
        }

        public int a(long j11) {
            return ((int) (j11 - this.f17716a)) + this.f17719d.f20558b;
        }

        public a a() {
            this.f17719d = null;
            a aVar = this.f17720e;
            this.f17720e = null;
            return aVar;
        }

        public void a(m0 m0Var, a aVar) {
            this.f17719d = m0Var;
            this.f17720e = aVar;
            this.f17718c = true;
        }
    }

    public aj(n0 n0Var) {
        this.f17709a = n0Var;
        int iC = n0Var.c();
        this.f17710b = iC;
        this.f17711c = new bh(32);
        a aVar = new a(0L, iC);
        this.f17712d = aVar;
        this.f17713e = aVar;
        this.f17714f = aVar;
    }

    private static a a(a aVar, long j11) {
        while (j11 >= aVar.f17717b) {
            aVar = aVar.f17720e;
        }
        return aVar;
    }

    private static a a(a aVar, long j11, ByteBuffer byteBuffer, int i11) {
        a aVarA = a(aVar, j11);
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (aVarA.f17717b - j11));
            byteBuffer.put(aVarA.f17719d.f20557a, aVarA.a(j11), iMin);
            i11 -= iMin;
            j11 += (long) iMin;
            if (j11 == aVarA.f17717b) {
                aVarA = aVarA.f17720e;
            }
        }
        return aVarA;
    }

    private static a a(a aVar, long j11, byte[] bArr, int i11) {
        a aVarA = a(aVar, j11);
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(i12, (int) (aVarA.f17717b - j11));
            System.arraycopy(aVarA.f17719d.f20557a, aVarA.a(j11), bArr, i11 - i12, iMin);
            i12 -= iMin;
            j11 += (long) iMin;
            if (j11 == aVarA.f17717b) {
                aVarA = aVarA.f17720e;
            }
        }
        return aVarA;
    }

    private static a a(a aVar, p5 p5Var, bj.b bVar, bh bhVar) {
        int iC;
        long j11 = bVar.f17969b;
        bhVar.d(1);
        a aVarA = a(aVar, j11, bhVar.c(), 1);
        long j12 = j11 + 1;
        byte b11 = bhVar.c()[0];
        boolean z11 = (b11 & 128) != 0;
        int i11 = b11 & Ascii.DEL;
        a5 a5Var = p5Var.f21654b;
        byte[] bArr = a5Var.f17440a;
        if (bArr == null) {
            a5Var.f17440a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarA2 = a(aVarA, j12, a5Var.f17440a, i11);
        long j13 = j12 + ((long) i11);
        if (z11) {
            bhVar.d(2);
            aVarA2 = a(aVarA2, j13, bhVar.c(), 2);
            j13 += 2;
            iC = bhVar.C();
        } else {
            iC = 1;
        }
        int[] iArr = a5Var.f17443d;
        if (iArr == null || iArr.length < iC) {
            iArr = new int[iC];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = a5Var.f17444e;
        if (iArr3 == null || iArr3.length < iC) {
            iArr3 = new int[iC];
        }
        int[] iArr4 = iArr3;
        if (z11) {
            int i12 = iC * 6;
            bhVar.d(i12);
            aVarA2 = a(aVarA2, j13, bhVar.c(), i12);
            j13 += (long) i12;
            bhVar.f(0);
            for (int i13 = 0; i13 < iC; i13++) {
                iArr2[i13] = bhVar.C();
                iArr4[i13] = bhVar.A();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f17968a - ((int) (j13 - bVar.f17969b));
        }
        qo.a aVar2 = (qo.a) xp.a(bVar.f17970c);
        a5Var.a(iC, iArr2, iArr4, aVar2.f21968b, a5Var.f17440a, aVar2.f21967a, aVar2.f21969c, aVar2.f21970d);
        long j14 = bVar.f17969b;
        int i14 = (int) (j13 - j14);
        bVar.f17969b = j14 + ((long) i14);
        bVar.f17968a -= i14;
        return aVarA2;
    }

    private void a(int i11) {
        long j11 = this.f17715g + ((long) i11);
        this.f17715g = j11;
        a aVar = this.f17714f;
        if (j11 == aVar.f17717b) {
            this.f17714f = aVar.f17720e;
        }
    }

    private void a(a aVar) {
        if (aVar.f17718c) {
            a aVar2 = this.f17714f;
            boolean z11 = aVar2.f17718c;
            int i11 = (z11 ? 1 : 0) + (((int) (aVar2.f17716a - aVar.f17716a)) / this.f17710b);
            m0[] m0VarArr = new m0[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                m0VarArr[i12] = aVar.f17719d;
                aVar = aVar.a();
            }
            this.f17709a.a(m0VarArr);
        }
    }

    private int b(int i11) {
        a aVar = this.f17714f;
        if (!aVar.f17718c) {
            aVar.a(this.f17709a.b(), new a(this.f17714f.f17717b, this.f17710b));
        }
        return Math.min(i11, (int) (this.f17714f.f17717b - this.f17715g));
    }

    private static a b(a aVar, p5 p5Var, bj.b bVar, bh bhVar) {
        if (p5Var.h()) {
            aVar = a(aVar, p5Var, bVar, bhVar);
        }
        if (!p5Var.c()) {
            p5Var.g(bVar.f17968a);
            return a(aVar, bVar.f17969b, p5Var.f21655c, bVar.f17968a);
        }
        bhVar.d(4);
        a aVarA = a(aVar, bVar.f17969b, bhVar.c(), 4);
        int iA = bhVar.A();
        bVar.f17969b += 4;
        bVar.f17968a -= 4;
        p5Var.g(iA);
        a aVarA2 = a(aVarA, bVar.f17969b, p5Var.f21655c, iA);
        bVar.f17969b += (long) iA;
        int i11 = bVar.f17968a - iA;
        bVar.f17968a = i11;
        p5Var.h(i11);
        return a(aVarA2, bVar.f17969b, p5Var.f21658g, bVar.f17968a);
    }

    public int a(g5 g5Var, int i11, boolean z11) throws EOFException {
        int iB = b(i11);
        a aVar = this.f17714f;
        int iA = g5Var.a(aVar.f17719d.f20557a, aVar.a(this.f17715g), iB);
        if (iA != -1) {
            a(iA);
            return iA;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    public long a() {
        return this.f17715g;
    }

    public void a(long j11) {
        a aVar;
        if (j11 == -1) {
            return;
        }
        while (true) {
            aVar = this.f17712d;
            if (j11 < aVar.f17717b) {
                break;
            }
            this.f17709a.a(aVar.f17719d);
            this.f17712d = this.f17712d.a();
        }
        if (this.f17713e.f17716a < aVar.f17716a) {
            this.f17713e = aVar;
        }
    }

    public void a(bh bhVar, int i11) {
        while (i11 > 0) {
            int iB = b(i11);
            a aVar = this.f17714f;
            bhVar.a(aVar.f17719d.f20557a, aVar.a(this.f17715g), iB);
            i11 -= iB;
            a(iB);
        }
    }

    public void a(p5 p5Var, bj.b bVar) {
        b(this.f17713e, p5Var, bVar, this.f17711c);
    }

    public void b() {
        a(this.f17712d);
        a aVar = new a(0L, this.f17710b);
        this.f17712d = aVar;
        this.f17713e = aVar;
        this.f17714f = aVar;
        this.f17715g = 0L;
        this.f17709a.a();
    }

    public void b(p5 p5Var, bj.b bVar) {
        this.f17713e = b(this.f17713e, p5Var, bVar, this.f17711c);
    }

    public void c() {
        this.f17713e = this.f17712d;
    }
}
