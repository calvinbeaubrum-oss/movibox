package com.applovin.impl;

import android.os.Looper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class bj implements qo {
    private boolean A;
    private f9 B;
    private f9 C;
    private int D;
    private boolean E;
    private boolean F;
    private long G;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aj f17942a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b7 f17945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a7.a f17946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Looper f17947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f17948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f9 f17949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private z6 f17950i;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f17958q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f17959r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17960s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f17961t;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f17965x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f17943b = new b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17951j = 1000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f17952k = new int[1000];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long[] f17953l = new long[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long[] f17956o = new long[1000];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int[] f17955n = new int[1000];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f17954m = new int[1000];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private qo.a[] f17957p = new qo.a[1000];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final qk f17944c = new qk(new r4() { // from class: com.applovin.impl.lt
        @Override // com.applovin.impl.r4
        public final void accept(Object obj) {
            bj.a((bj.c) obj);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f17962u = Long.MIN_VALUE;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f17963v = Long.MIN_VALUE;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f17964w = Long.MIN_VALUE;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f17967z = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f17966y = true;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17969b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public qo.a f17970c;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f9 f17971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b7.b f17972b;

        private c(f9 f9Var, b7.b bVar) {
            this.f17971a = f9Var;
            this.f17972b = bVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(f9 f9Var);
    }

    public bj(n0 n0Var, Looper looper, b7 b7Var, a7.a aVar) {
        this.f17947f = looper;
        this.f17945d = b7Var;
        this.f17946e = aVar;
        this.f17942a = new aj(n0Var);
    }

    private int a(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.f17956o[i11];
            if (j12 > j11) {
                break;
            }
            if (!z11 || (this.f17955n[i11] & 1) != 0) {
                i13 = i14;
                if (j12 == j11) {
                    break;
                }
            }
            i11++;
            if (i11 == this.f17951j) {
                i11 = 0;
            }
        }
        return i13;
    }

    private synchronized int a(g9 g9Var, p5 p5Var, boolean z11, boolean z12, b bVar) {
        try {
            p5Var.f21656d = false;
            if (!h()) {
                if (!z12 && !this.f17965x) {
                    f9 f9Var = this.C;
                    if (f9Var == null || (!z11 && f9Var == this.f17949h)) {
                        return -3;
                    }
                    a((f9) b1.a(f9Var), g9Var);
                    return -5;
                }
                p5Var.e(4);
                return -4;
            }
            f9 f9Var2 = ((c) this.f17944c.c(e())).f17971a;
            if (!z11 && f9Var2 == this.f17949h) {
                int iD = d(this.f17961t);
                if (!e(iD)) {
                    p5Var.f21656d = true;
                    return -3;
                }
                p5Var.e(this.f17955n[iD]);
                long j11 = this.f17956o[iD];
                p5Var.f21657f = j11;
                if (j11 < this.f17962u) {
                    p5Var.b(Integer.MIN_VALUE);
                }
                bVar.f17968a = this.f17954m[iD];
                bVar.f17969b = this.f17953l[iD];
                bVar.f17970c = this.f17957p[iD];
                return -4;
            }
            a(f9Var2, g9Var);
            return -5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized long a() {
        int i11 = this.f17958q;
        if (i11 == 0) {
            return -1L;
        }
        return a(i11);
    }

    private long a(int i11) {
        this.f17963v = Math.max(this.f17963v, c(i11));
        this.f17958q -= i11;
        int i12 = this.f17959r + i11;
        this.f17959r = i12;
        int i13 = this.f17960s + i11;
        this.f17960s = i13;
        int i14 = this.f17951j;
        if (i13 >= i14) {
            this.f17960s = i13 - i14;
        }
        int i15 = this.f17961t - i11;
        this.f17961t = i15;
        if (i15 < 0) {
            this.f17961t = 0;
        }
        this.f17944c.b(i12);
        if (this.f17958q != 0) {
            return this.f17953l[this.f17960s];
        }
        int i16 = this.f17960s;
        if (i16 == 0) {
            i16 = this.f17951j;
        }
        int i17 = i16 - 1;
        return this.f17953l[i17] + ((long) this.f17954m[i17]);
    }

    private synchronized long a(long j11, boolean z11, boolean z12) {
        int i11;
        try {
            int i12 = this.f17958q;
            if (i12 != 0) {
                long[] jArr = this.f17956o;
                int i13 = this.f17960s;
                if (j11 >= jArr[i13]) {
                    if (z12 && (i11 = this.f17961t) != i12) {
                        i12 = i11 + 1;
                    }
                    int iA = a(i13, i12, j11, z11);
                    if (iA == -1) {
                        return -1L;
                    }
                    return a(iA);
                }
            }
            return -1L;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static bj a(n0 n0Var, Looper looper, b7 b7Var, a7.a aVar) {
        return new bj(n0Var, (Looper) b1.a(looper), (b7) b1.a(b7Var), (a7.a) b1.a(aVar));
    }

    private synchronized void a(long j11, int i11, long j12, int i12, qo.a aVar) {
        try {
            int i13 = this.f17958q;
            if (i13 > 0) {
                int iD = d(i13 - 1);
                b1.a(this.f17953l[iD] + ((long) this.f17954m[iD]) <= j12);
            }
            this.f17965x = (536870912 & i11) != 0;
            this.f17964w = Math.max(this.f17964w, j11);
            int iD2 = d(this.f17958q);
            this.f17956o[iD2] = j11;
            this.f17953l[iD2] = j12;
            this.f17954m[iD2] = i12;
            this.f17955n[iD2] = i11;
            this.f17957p[iD2] = aVar;
            this.f17952k[iD2] = this.D;
            if (this.f17944c.c() || !((c) this.f17944c.b()).f17971a.equals(this.C)) {
                b7 b7Var = this.f17945d;
                this.f17944c.a(g(), new c((f9) b1.a(this.C), b7Var != null ? b7Var.b((Looper) b1.a(this.f17947f), this.f17946e, this.C) : b7.b.f17879a));
            }
            int i14 = this.f17958q + 1;
            this.f17958q = i14;
            int i15 = this.f17951j;
            if (i14 == i15) {
                int i16 = i15 + 1000;
                int[] iArr = new int[i16];
                long[] jArr = new long[i16];
                long[] jArr2 = new long[i16];
                int[] iArr2 = new int[i16];
                int[] iArr3 = new int[i16];
                qo.a[] aVarArr = new qo.a[i16];
                int i17 = this.f17960s;
                int i18 = i15 - i17;
                System.arraycopy(this.f17953l, i17, jArr, 0, i18);
                System.arraycopy(this.f17956o, this.f17960s, jArr2, 0, i18);
                System.arraycopy(this.f17955n, this.f17960s, iArr2, 0, i18);
                System.arraycopy(this.f17954m, this.f17960s, iArr3, 0, i18);
                System.arraycopy(this.f17957p, this.f17960s, aVarArr, 0, i18);
                System.arraycopy(this.f17952k, this.f17960s, iArr, 0, i18);
                int i19 = this.f17960s;
                System.arraycopy(this.f17953l, 0, jArr, i18, i19);
                System.arraycopy(this.f17956o, 0, jArr2, i18, i19);
                System.arraycopy(this.f17955n, 0, iArr2, i18, i19);
                System.arraycopy(this.f17954m, 0, iArr3, i18, i19);
                System.arraycopy(this.f17957p, 0, aVarArr, i18, i19);
                System.arraycopy(this.f17952k, 0, iArr, i18, i19);
                this.f17953l = jArr;
                this.f17956o = jArr2;
                this.f17955n = iArr2;
                this.f17954m = iArr3;
                this.f17957p = aVarArr;
                this.f17952k = iArr;
                this.f17960s = 0;
                this.f17951j = i16;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(c cVar) {
        cVar.f17972b.a();
    }

    private void a(f9 f9Var, g9 g9Var) {
        f9 f9Var2 = this.f17949h;
        boolean z11 = f9Var2 == null;
        y6 y6Var = z11 ? null : f9Var2.f18903p;
        this.f17949h = f9Var;
        y6 y6Var2 = f9Var.f18903p;
        b7 b7Var = this.f17945d;
        g9Var.f19165b = b7Var != null ? f9Var.a(b7Var.a(f9Var)) : f9Var;
        g9Var.f19164a = this.f17950i;
        if (this.f17945d == null) {
            return;
        }
        if (z11 || !xp.a(y6Var, y6Var2)) {
            z6 z6Var = this.f17950i;
            z6 z6VarA = this.f17945d.a((Looper) b1.a(this.f17947f), this.f17946e, f9Var);
            this.f17950i = z6VarA;
            g9Var.f19164a = z6VarA;
            if (z6Var != null) {
                z6Var.a(this.f17946e);
            }
        }
    }

    private synchronized boolean a(long j11) {
        if (this.f17958q == 0) {
            return j11 > this.f17963v;
        }
        if (d() >= j11) {
            return false;
        }
        b(this.f17959r + b(j11));
        return true;
    }

    private int b(long j11) {
        int i11 = this.f17958q;
        int iD = d(i11 - 1);
        while (i11 > this.f17961t && this.f17956o[iD] >= j11) {
            i11--;
            iD--;
            if (iD == -1) {
                iD = this.f17951j - 1;
            }
        }
        return i11;
    }

    private long b(int i11) {
        int iG = g() - i11;
        boolean z11 = false;
        b1.a(iG >= 0 && iG <= this.f17958q - this.f17961t);
        int i12 = this.f17958q - iG;
        this.f17958q = i12;
        this.f17964w = Math.max(this.f17963v, c(i12));
        if (iG == 0 && this.f17965x) {
            z11 = true;
        }
        this.f17965x = z11;
        this.f17944c.a(i11);
        int i13 = this.f17958q;
        if (i13 == 0) {
            return 0L;
        }
        int iD = d(i13 - 1);
        return this.f17953l[iD] + ((long) this.f17954m[iD]);
    }

    private long c(int i11) {
        long jMax = Long.MIN_VALUE;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int iD = d(i11 - 1);
        for (int i12 = 0; i12 < i11; i12++) {
            jMax = Math.max(jMax, this.f17956o[iD]);
            if ((this.f17955n[iD] & 1) != 0) {
                break;
            }
            iD--;
            if (iD == -1) {
                iD = this.f17951j - 1;
            }
        }
        return jMax;
    }

    private synchronized boolean c(f9 f9Var) {
        try {
            this.f17967z = false;
            if (xp.a(f9Var, this.C)) {
                return false;
            }
            if (this.f17944c.c() || !((c) this.f17944c.b()).f17971a.equals(f9Var)) {
                this.C = f9Var;
            } else {
                this.C = ((c) this.f17944c.b()).f17971a;
            }
            f9 f9Var2 = this.C;
            this.E = Cif.a(f9Var2.f18900m, f9Var2.f18897j);
            this.F = false;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private int d(int i11) {
        int i12 = this.f17960s + i11;
        int i13 = this.f17951j;
        return i12 < i13 ? i12 : i12 - i13;
    }

    private boolean e(int i11) {
        z6 z6Var = this.f17950i;
        return z6Var == null || z6Var.b() == 4 || ((this.f17955n[i11] & 1073741824) == 0 && this.f17950i.c());
    }

    private boolean h() {
        return this.f17961t != this.f17958q;
    }

    private void m() {
        z6 z6Var = this.f17950i;
        if (z6Var != null) {
            z6Var.a(this.f17946e);
            this.f17950i = null;
            this.f17949h = null;
        }
    }

    private synchronized void o() {
        this.f17961t = 0;
        this.f17942a.c();
    }

    public final synchronized int a(long j11, boolean z11) {
        int iD = d(this.f17961t);
        if (h() && j11 >= this.f17956o[iD]) {
            if (j11 > this.f17964w && z11) {
                return this.f17958q - this.f17961t;
            }
            int iA = a(iD, this.f17958q - this.f17961t, j11, true);
            if (iA == -1) {
                return 0;
            }
            return iA;
        }
        return 0;
    }

    @Override // com.applovin.impl.qo
    public /* synthetic */ int a(g5 g5Var, int i11, boolean z11) {
        return g20.a(this, g5Var, i11, z11);
    }

    @Override // com.applovin.impl.qo
    public final int a(g5 g5Var, int i11, boolean z11, int i12) {
        return this.f17942a.a(g5Var, i11, z11);
    }

    public int a(g9 g9Var, p5 p5Var, int i11, boolean z11) {
        int iA = a(g9Var, p5Var, (i11 & 2) != 0, z11, this.f17943b);
        if (iA == -4 && !p5Var.e()) {
            boolean z12 = (i11 & 1) != 0;
            if ((i11 & 4) == 0) {
                if (z12) {
                    this.f17942a.a(p5Var, this.f17943b);
                } else {
                    this.f17942a.b(p5Var, this.f17943b);
                }
            }
            if (!z12) {
                this.f17961t++;
            }
        }
        return iA;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    @Override // com.applovin.impl.qo
    public void a(long j11, int i11, int i12, int i13, qo.a aVar) {
        int i14;
        if (this.A) {
            a((f9) b1.b(this.B));
        }
        int i15 = i11 & 1;
        boolean z11 = i15 != 0;
        if (this.f17966y) {
            if (!z11) {
                return;
            } else {
                this.f17966y = false;
            }
        }
        long j12 = this.G + j11;
        if (!this.E) {
            i14 = i11;
        } else {
            if (j12 < this.f17962u) {
                return;
            }
            if (i15 == 0) {
                if (!this.F) {
                    pc.d("SampleQueue", "Overriding unexpected non-sync sample for format: " + this.C);
                    this.F = true;
                }
                i14 = i11 | 1;
            } else {
                i14 = i11;
            }
        }
        if (this.H) {
            if (!z11 || !a(j12)) {
                return;
            } else {
                this.H = false;
            }
        }
        a(j12, i14, (this.f17942a.a() - ((long) i12)) - ((long) i13), i12, aVar);
    }

    @Override // com.applovin.impl.qo
    public /* synthetic */ void a(bh bhVar, int i11) {
        g20.b(this, bhVar, i11);
    }

    @Override // com.applovin.impl.qo
    public final void a(bh bhVar, int i11, int i12) {
        this.f17942a.a(bhVar, i11);
    }

    public final void a(d dVar) {
        this.f17948g = dVar;
    }

    @Override // com.applovin.impl.qo
    public final void a(f9 f9Var) {
        f9 f9VarB = b(f9Var);
        this.A = false;
        this.B = f9Var;
        boolean zC = c(f9VarB);
        d dVar = this.f17948g;
        if (dVar == null || !zC) {
            return;
        }
        dVar.a(f9VarB);
    }

    public synchronized boolean a(boolean z11) {
        f9 f9Var;
        boolean z12 = true;
        if (h()) {
            if (((c) this.f17944c.c(e())).f17971a != this.f17949h) {
                return true;
            }
            return e(d(this.f17961t));
        }
        if (!z11 && !this.f17965x && ((f9Var = this.C) == null || f9Var == this.f17949h)) {
            z12 = false;
        }
        return z12;
    }

    public f9 b(f9 f9Var) {
        return (this.G == 0 || f9Var.f18904q == Long.MAX_VALUE) ? f9Var : f9Var.a().a(f9Var.f18904q + this.G).a();
    }

    public final void b() {
        this.f17942a.a(a());
    }

    public final void b(long j11, boolean z11, boolean z12) {
        this.f17942a.a(a(j11, z11, z12));
    }

    public void b(boolean z11) {
        this.f17942a.b();
        this.f17958q = 0;
        this.f17959r = 0;
        this.f17960s = 0;
        this.f17961t = 0;
        this.f17966y = true;
        this.f17962u = Long.MIN_VALUE;
        this.f17963v = Long.MIN_VALUE;
        this.f17964w = Long.MIN_VALUE;
        this.f17965x = false;
        this.f17944c.a();
        if (z11) {
            this.B = null;
            this.C = null;
            this.f17967z = true;
        }
    }

    public final synchronized boolean b(long j11, boolean z11) {
        o();
        int iD = d(this.f17961t);
        if (h() && j11 >= this.f17956o[iD] && (j11 <= this.f17964w || z11)) {
            int iA = a(iD, this.f17958q - this.f17961t, j11, true);
            if (iA == -1) {
                return false;
            }
            this.f17962u = j11;
            this.f17961t += iA;
            return true;
        }
        return false;
    }

    public final synchronized long c() {
        return this.f17964w;
    }

    public final void c(long j11) {
        this.f17962u = j11;
    }

    public final synchronized long d() {
        return Math.max(this.f17963v, c(this.f17961t));
    }

    public final int e() {
        return this.f17959r + this.f17961t;
    }

    public final synchronized f9 f() {
        return this.f17967z ? null : this.C;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e  */
    public final synchronized void f(int i11) {
        boolean z11;
        if (i11 >= 0) {
            try {
                if (this.f17961t + i11 <= this.f17958q) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            z11 = false;
        }
        b1.a(z11);
        this.f17961t += i11;
    }

    public final int g() {
        return this.f17959r + this.f17958q;
    }

    public final synchronized boolean i() {
        return this.f17965x;
    }

    public void j() {
        z6 z6Var = this.f17950i;
        if (z6Var != null && z6Var.b() == 1) {
            throw ((z6.a) b1.a(this.f17950i.getError()));
        }
    }

    public void k() {
        b();
        m();
    }

    public void l() {
        b(true);
        m();
    }

    public final void n() {
        b(false);
    }
}
