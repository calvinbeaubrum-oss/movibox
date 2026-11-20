package com.applovin.impl;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e9 implements k8 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final o8 f18657q = new o8() { // from class: com.applovin.impl.gv
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return e9.d();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m8 f18663f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f18666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f18668k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18669l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f18670m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f18671n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private s1 f18672o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private yq f18673p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bh f18658a = new bh(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f18659b = new bh(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f18660c = new bh(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final bh f18661d = new bh();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ej f18662e = new ej();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18664g = 1;

    private bh b(l8 l8Var) {
        if (this.f18669l > this.f18661d.b()) {
            bh bhVar = this.f18661d;
            bhVar.a(new byte[Math.max(bhVar.b() * 2, this.f18669l)], 0);
        } else {
            this.f18661d.f(0);
        }
        this.f18661d.e(this.f18669l);
        l8Var.d(this.f18661d.c(), 0, this.f18669l);
        return this.f18661d;
    }

    private void b() {
        if (this.f18671n) {
            return;
        }
        this.f18663f.a(new ij.b(C.TIME_UNSET));
        this.f18671n = true;
    }

    private long c() {
        if (this.f18665h) {
            return this.f18666i + this.f18670m;
        }
        if (this.f18662e.a() == C.TIME_UNSET) {
            return 0L;
        }
        return this.f18670m;
    }

    private boolean c(l8 l8Var) {
        if (!l8Var.a(this.f18659b.c(), 0, 9, true)) {
            return false;
        }
        this.f18659b.f(0);
        this.f18659b.g(4);
        int iW = this.f18659b.w();
        boolean z11 = (iW & 4) != 0;
        boolean z12 = (iW & 1) != 0;
        if (z11 && this.f18672o == null) {
            this.f18672o = new s1(this.f18663f.a(8, 1));
        }
        if (z12 && this.f18673p == null) {
            this.f18673p = new yq(this.f18663f.a(9, 2));
        }
        this.f18663f.c();
        this.f18667j = this.f18659b.j() - 5;
        this.f18664g = 2;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    /* JADX WARN: Code duplicated, block: B:27:0x008b  */
    private boolean d(l8 l8Var) {
        boolean zA;
        boolean z11;
        long j11;
        long jC = c();
        int i11 = this.f18668k;
        if (i11 == 8 && this.f18672o != null) {
            b();
            zA = this.f18672o.a(b(l8Var), jC);
        } else {
            if (i11 != 9 || this.f18673p == null) {
                if (i11 != 18 || this.f18671n) {
                    l8Var.a(this.f18669l);
                    zA = false;
                    z11 = false;
                } else {
                    zA = this.f18662e.a(b(l8Var), jC);
                    long jA = this.f18662e.a();
                    if (jA != C.TIME_UNSET) {
                        this.f18663f.a(new mb(this.f18662e.b(), this.f18662e.c(), jA));
                        this.f18671n = true;
                    }
                }
                if (!this.f18665h && zA) {
                    this.f18665h = true;
                    if (this.f18662e.a() == C.TIME_UNSET) {
                        j11 = -this.f18670m;
                    } else {
                        j11 = 0;
                    }
                    this.f18666i = j11;
                }
                this.f18667j = 4;
                this.f18664g = 2;
                return z11;
            }
            b();
            zA = this.f18673p.a(b(l8Var), jC);
        }
        z11 = true;
        if (!this.f18665h) {
            this.f18665h = true;
            if (this.f18662e.a() == C.TIME_UNSET) {
                j11 = -this.f18670m;
            } else {
                j11 = 0;
            }
            this.f18666i = j11;
        }
        this.f18667j = 4;
        this.f18664g = 2;
        return z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] d() {
        return new k8[]{new e9()};
    }

    private boolean e(l8 l8Var) {
        if (!l8Var.a(this.f18660c.c(), 0, 11, true)) {
            return false;
        }
        this.f18660c.f(0);
        this.f18668k = this.f18660c.w();
        this.f18669l = this.f18660c.z();
        this.f18670m = this.f18660c.z();
        this.f18670m = (((long) (this.f18660c.w() << 24)) | this.f18670m) * 1000;
        this.f18660c.g(3);
        this.f18664g = 4;
        return true;
    }

    private void f(l8 l8Var) {
        l8Var.a(this.f18667j);
        this.f18667j = 0;
        this.f18664g = 3;
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) {
        b1.b(this.f18663f);
        while (true) {
            int i11 = this.f18664g;
            if (i11 != 1) {
                if (i11 == 2) {
                    f(l8Var);
                } else if (i11 != 3) {
                    if (i11 != 4) {
                        throw new IllegalStateException();
                    }
                    if (d(l8Var)) {
                        return 0;
                    }
                } else if (!e(l8Var)) {
                    return -1;
                }
            } else if (!c(l8Var)) {
                return -1;
            }
        }
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        if (j11 == 0) {
            this.f18664g = 1;
            this.f18665h = false;
        } else {
            this.f18664g = 3;
        }
        this.f18667j = 0;
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f18663f = m8Var;
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        l8Var.c(this.f18658a.c(), 0, 3);
        this.f18658a.f(0);
        if (this.f18658a.z() != 4607062) {
            return false;
        }
        l8Var.c(this.f18658a.c(), 0, 2);
        this.f18658a.f(0);
        if ((this.f18658a.C() & 250) != 0) {
            return false;
        }
        l8Var.c(this.f18658a.c(), 0, 4);
        this.f18658a.f(0);
        int iJ = this.f18658a.j();
        l8Var.b();
        l8Var.c(iJ);
        l8Var.c(this.f18658a.c(), 0, 4);
        this.f18658a.f(0);
        return this.f18658a.j() == 0;
    }
}
