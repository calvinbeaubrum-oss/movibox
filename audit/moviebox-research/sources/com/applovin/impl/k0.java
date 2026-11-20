package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements q7 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final byte[] f20049v = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f20050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f20051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f20052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f20053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f20054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private qo f20055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private qo f20056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f20057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f20058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f20060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f20061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f20062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f20063n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f20064o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f20065p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f20066q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f20067r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f20068s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private qo f20069t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f20070u;

    public k0(boolean z11) {
        this(z11, null);
    }

    public k0(boolean z11, String str) {
        this.f20051b = new ah(new byte[7]);
        this.f20052c = new bh(Arrays.copyOf(f20049v, 10));
        i();
        this.f20062m = -1;
        this.f20063n = -1;
        this.f20066q = C.TIME_UNSET;
        this.f20068s = C.TIME_UNSET;
        this.f20050a = z11;
        this.f20053d = str;
    }

    private void a(qo qoVar, long j11, int i11, int i12) {
        this.f20057h = 4;
        this.f20058i = i11;
        this.f20069t = qoVar;
        this.f20070u = j11;
        this.f20067r = i12;
    }

    private boolean a(byte b11, byte b12) {
        return a(((b11 & 255) << 8) | (b12 & 255));
    }

    public static boolean a(int i11) {
        return (i11 & 65526) == 65520;
    }

    private boolean a(bh bhVar, int i11) {
        bhVar.f(i11 + 1);
        if (!b(bhVar, this.f20051b.f17657a, 1)) {
            return false;
        }
        this.f20051b.c(4);
        int iA = this.f20051b.a(1);
        int i12 = this.f20062m;
        if (i12 != -1 && iA != i12) {
            return false;
        }
        if (this.f20063n != -1) {
            if (!b(bhVar, this.f20051b.f17657a, 1)) {
                return true;
            }
            this.f20051b.c(2);
            if (this.f20051b.a(4) != this.f20063n) {
                return false;
            }
            bhVar.f(i11 + 2);
        }
        if (!b(bhVar, this.f20051b.f17657a, 4)) {
            return true;
        }
        this.f20051b.c(14);
        int iA2 = this.f20051b.a(13);
        if (iA2 < 7) {
            return false;
        }
        byte[] bArrC = bhVar.c();
        int iE = bhVar.e();
        int i13 = i11 + iA2;
        if (i13 >= iE) {
            return true;
        }
        byte b11 = bArrC[i13];
        if (b11 == -1) {
            int i14 = i13 + 1;
            if (i14 == iE) {
                return true;
            }
            return a((byte) -1, bArrC[i14]) && ((bArrC[i14] & 8) >> 3) == iA;
        }
        if (b11 != 73) {
            return false;
        }
        int i15 = i13 + 1;
        if (i15 == iE) {
            return true;
        }
        if (bArrC[i15] != 68) {
            return false;
        }
        int i16 = i13 + 2;
        return i16 == iE || bArrC[i16] == 51;
    }

    private boolean a(bh bhVar, byte[] bArr, int i11) {
        int iMin = Math.min(bhVar.a(), i11 - this.f20058i);
        bhVar.a(bArr, this.f20058i, iMin);
        int i12 = this.f20058i + iMin;
        this.f20058i = i12;
        return i12 == i11;
    }

    private void b(bh bhVar) {
        if (bhVar.a() == 0) {
            return;
        }
        this.f20051b.f17657a[0] = bhVar.c()[bhVar.d()];
        this.f20051b.c(2);
        int iA = this.f20051b.a(4);
        int i11 = this.f20063n;
        if (i11 != -1 && iA != i11) {
            g();
            return;
        }
        if (!this.f20061l) {
            this.f20061l = true;
            this.f20062m = this.f20064o;
            this.f20063n = iA;
        }
        j();
    }

    private boolean b(bh bhVar, byte[] bArr, int i11) {
        if (bhVar.a() < i11) {
            return false;
        }
        bhVar.a(bArr, 0, i11);
        return true;
    }

    private void c() {
        b1.a(this.f20055f);
        xp.a(this.f20069t);
        xp.a(this.f20056g);
    }

    private void c(bh bhVar) {
        byte[] bArrC = bhVar.c();
        int iD = bhVar.d();
        int iE = bhVar.e();
        while (iD < iE) {
            int i11 = iD + 1;
            byte b11 = bArrC[iD];
            int i12 = b11 & 255;
            if (this.f20059j == 512 && a((byte) -1, (byte) i12) && (this.f20061l || a(bhVar, iD - 1))) {
                this.f20064o = (b11 & 8) >> 3;
                this.f20060k = (b11 & 1) == 0;
                if (this.f20061l) {
                    j();
                } else {
                    h();
                }
                bhVar.f(i11);
                return;
            }
            int i13 = this.f20059j;
            int i14 = i12 | i13;
            if (i14 == 329) {
                this.f20059j = 768;
            } else if (i14 == 511) {
                this.f20059j = 512;
            } else if (i14 == 836) {
                this.f20059j = 1024;
            } else if (i14 == 1075) {
                k();
                bhVar.f(i11);
                return;
            } else if (i13 != 256) {
                this.f20059j = 256;
            }
            iD = i11;
        }
        bhVar.f(iD);
    }

    private void d(bh bhVar) {
        int iMin = Math.min(bhVar.a(), this.f20067r - this.f20058i);
        this.f20069t.a(bhVar, iMin);
        int i11 = this.f20058i + iMin;
        this.f20058i = i11;
        int i12 = this.f20067r;
        if (i11 == i12) {
            long j11 = this.f20068s;
            if (j11 != C.TIME_UNSET) {
                this.f20069t.a(j11, 1, i12, 0, null);
                this.f20068s += this.f20070u;
            }
            i();
        }
    }

    private void e() {
        this.f20051b.c(0);
        if (this.f20065p) {
            this.f20051b.d(10);
        } else {
            int i11 = 2;
            int iA = this.f20051b.a(2) + 1;
            if (iA != 2) {
                pc.d("AdtsReader", "Detected audio object type: " + iA + ", but assuming AAC LC.");
            } else {
                i11 = iA;
            }
            this.f20051b.d(5);
            byte[] bArrA = a.a(i11, this.f20063n, this.f20051b.a(3));
            a.b bVarA = a.a(bArrA);
            f9 f9VarA = new f9.b().c(this.f20054e).f(MimeTypes.AUDIO_AAC).a(bVarA.f17406c).c(bVarA.f17405b).n(bVarA.f17404a).a(Collections.singletonList(bArrA)).e(this.f20053d).a();
            this.f20066q = 1024000000 / ((long) f9VarA.A);
            this.f20055f.a(f9VarA);
            this.f20065p = true;
        }
        this.f20051b.d(4);
        int iA2 = this.f20051b.a(13);
        int i12 = iA2 - 7;
        if (this.f20060k) {
            i12 = iA2 - 9;
        }
        a(this.f20055f, this.f20066q, 0, i12);
    }

    private void f() {
        this.f20056g.a(this.f20052c, 10);
        this.f20052c.f(6);
        a(this.f20056g, 0L, 10, this.f20052c.v() + 10);
    }

    private void g() {
        this.f20061l = false;
        i();
    }

    private void h() {
        this.f20057h = 1;
        this.f20058i = 0;
    }

    private void i() {
        this.f20057h = 0;
        this.f20058i = 0;
        this.f20059j = 256;
    }

    private void j() {
        this.f20057h = 3;
        this.f20058i = 0;
    }

    private void k() {
        this.f20057h = 2;
        this.f20058i = f20049v.length;
        this.f20067r = 0;
        this.f20052c.f(0);
    }

    @Override // com.applovin.impl.q7
    public void a() {
        this.f20068s = C.TIME_UNSET;
        g();
    }

    @Override // com.applovin.impl.q7
    public void a(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.f20068s = j11;
        }
    }

    @Override // com.applovin.impl.q7
    public void a(bh bhVar) {
        c();
        while (bhVar.a() > 0) {
            int i11 = this.f20057h;
            if (i11 == 0) {
                c(bhVar);
            } else if (i11 == 1) {
                b(bhVar);
            } else if (i11 != 2) {
                if (i11 == 3) {
                    if (a(bhVar, this.f20051b.f17657a, this.f20060k ? 7 : 5)) {
                        e();
                    }
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    d(bhVar);
                }
            } else if (a(bhVar, this.f20052c.c(), 10)) {
                f();
            }
        }
    }

    @Override // com.applovin.impl.q7
    public void a(m8 m8Var, dp.d dVar) {
        dVar.a();
        this.f20054e = dVar.b();
        qo qoVarA = m8Var.a(dVar.c(), 1);
        this.f20055f = qoVarA;
        this.f20069t = qoVarA;
        if (!this.f20050a) {
            this.f20056g = new i7();
            return;
        }
        dVar.a();
        qo qoVarA2 = m8Var.a(dVar.c(), 5);
        this.f20056g = qoVarA2;
        qoVarA2.a(new f9.b().c(dVar.b()).f(MimeTypes.APPLICATION_ID3).a());
    }

    @Override // com.applovin.impl.q7
    public void b() {
    }

    public long d() {
        return this.f20066q;
    }
}
