package com.applovin.impl;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class a6 implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f17452a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f17453b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zp f17454c = new zp();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o7 f17455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17458g;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f17459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f17460b;

        private b(int i11, long j11) {
            this.f17459a = i11;
            this.f17460b = j11;
        }
    }

    private double a(l8 l8Var, int i11) {
        long jB = b(l8Var, i11);
        return i11 == 4 ? Float.intBitsToFloat((int) jB) : Double.longBitsToDouble(jB);
    }

    private long b(l8 l8Var) {
        l8Var.b();
        while (true) {
            l8Var.c(this.f17452a, 0, 4);
            int iA = zp.a(this.f17452a[0]);
            if (iA != -1 && iA <= 4) {
                int iA2 = (int) zp.a(this.f17452a, iA, false);
                if (this.f17455d.c(iA2)) {
                    l8Var.a(iA);
                    return iA2;
                }
            }
            l8Var.a(1);
        }
    }

    private long b(l8 l8Var, int i11) {
        l8Var.d(this.f17452a, 0, i11);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | ((long) (this.f17452a[i12] & 255));
        }
        return j11;
    }

    private static String c(l8 l8Var, int i11) {
        if (i11 == 0) {
            return "";
        }
        byte[] bArr = new byte[i11];
        l8Var.d(bArr, 0, i11);
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        return new String(bArr, 0, i11);
    }

    @Override // com.applovin.impl.p7
    public void a(o7 o7Var) {
        this.f17455d = o7Var;
    }

    @Override // com.applovin.impl.p7
    public boolean a(l8 l8Var) throws dh {
        b1.b(this.f17455d);
        while (true) {
            b bVar = (b) this.f17453b.peek();
            if (bVar != null && l8Var.f() >= bVar.f17460b) {
                this.f17455d.a(((b) this.f17453b.pop()).f17459a);
                return true;
            }
            if (this.f17456e == 0) {
                long jA = this.f17454c.a(l8Var, true, false, 4);
                if (jA == -2) {
                    jA = b(l8Var);
                }
                if (jA == -1) {
                    return false;
                }
                this.f17457f = (int) jA;
                this.f17456e = 1;
            }
            if (this.f17456e == 1) {
                this.f17458g = this.f17454c.a(l8Var, false, true, 8);
                this.f17456e = 2;
            }
            int iB = this.f17455d.b(this.f17457f);
            if (iB != 0) {
                if (iB == 1) {
                    long jF = l8Var.f();
                    this.f17453b.push(new b(this.f17457f, this.f17458g + jF));
                    this.f17455d.a(this.f17457f, jF, this.f17458g);
                    this.f17456e = 0;
                    return true;
                }
                if (iB == 2) {
                    long j11 = this.f17458g;
                    if (j11 <= 8) {
                        this.f17455d.a(this.f17457f, b(l8Var, (int) j11));
                        this.f17456e = 0;
                        return true;
                    }
                    throw dh.a("Invalid integer size: " + this.f17458g, null);
                }
                if (iB == 3) {
                    long j12 = this.f17458g;
                    if (j12 <= 2147483647L) {
                        this.f17455d.a(this.f17457f, c(l8Var, (int) j12));
                        this.f17456e = 0;
                        return true;
                    }
                    throw dh.a("String element size: " + this.f17458g, null);
                }
                if (iB == 4) {
                    this.f17455d.a(this.f17457f, (int) this.f17458g, l8Var);
                    this.f17456e = 0;
                    return true;
                }
                if (iB != 5) {
                    throw dh.a("Invalid element type " + iB, null);
                }
                long j13 = this.f17458g;
                if (j13 == 4 || j13 == 8) {
                    this.f17455d.a(this.f17457f, a(l8Var, (int) j13));
                    this.f17456e = 0;
                    return true;
                }
                throw dh.a("Invalid float size: " + this.f17458g, null);
            }
            l8Var.a((int) this.f17458g);
            this.f17456e = 0;
        }
    }

    @Override // com.applovin.impl.p7
    public void reset() {
        this.f17456e = 0;
        this.f17453b.clear();
        this.f17454c.b();
    }
}
