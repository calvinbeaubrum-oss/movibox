package com.applovin.impl;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements k8 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final o8 f19794m = new o8() { // from class: com.applovin.impl.sy
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return j0.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k0 f19796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final bh f19797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final bh f19798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ah f19799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m8 f19800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f19801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f19802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f19804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f19805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f19806l;

    public j0() {
        this(0);
    }

    public j0(int i11) {
        this.f19795a = (i11 & 2) != 0 ? i11 | 1 : i11;
        this.f19796b = new k0(true);
        this.f19797c = new bh(2048);
        this.f19803i = -1;
        this.f19802h = -1L;
        bh bhVar = new bh(10);
        this.f19798d = bhVar;
        this.f19799e = new ah(bhVar.c());
    }

    private static int a(int i11, long j11) {
        return (int) ((((long) (i11 * 8)) * 1000000) / j11);
    }

    private ij a(long j11, boolean z11) {
        return new p4(j11, this.f19802h, a(this.f19803i, this.f19796b.d()), this.f19803i, z11);
    }

    private void b(long j11, boolean z11) {
        if (this.f19806l) {
            return;
        }
        boolean z12 = (this.f19795a & 1) != 0 && this.f19803i > 0;
        if (z12 && this.f19796b.d() == C.TIME_UNSET && !z11) {
            return;
        }
        if (!z12 || this.f19796b.d() == C.TIME_UNSET) {
            this.f19800f.a(new ij.b(C.TIME_UNSET));
        } else {
            this.f19800f.a(a(j11, (this.f19795a & 2) != 0));
        }
        this.f19806l = true;
    }

    private void b(l8 l8Var) throws dh {
        if (this.f19804j) {
            return;
        }
        this.f19803i = -1;
        l8Var.b();
        long j11 = 0;
        if (l8Var.f() == 0) {
            c(l8Var);
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            try {
                if (l8Var.b(this.f19798d.c(), 0, 2, true)) {
                    this.f19798d.f(0);
                    if (!k0.a(this.f19798d.C())) {
                        break;
                    }
                    if (l8Var.b(this.f19798d.c(), 0, 4, true)) {
                        this.f19799e.c(14);
                        int iA = this.f19799e.a(13);
                        if (iA <= 6) {
                            this.f19804j = true;
                            throw dh.a("Malformed ADTS stream", null);
                        }
                        j11 += (long) iA;
                        i12++;
                        if (i12 != 1000 && l8Var.a(iA - 6, true)) {
                        }
                    }
                }
            } catch (EOFException unused) {
            }
            i11 = i12;
            break;
        }
        l8Var.b();
        if (i11 > 0) {
            this.f19803i = (int) (j11 / ((long) i11));
        } else {
            this.f19803i = -1;
        }
        this.f19804j = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] b() {
        return new k8[]{new j0()};
    }

    private int c(l8 l8Var) {
        int i11 = 0;
        while (true) {
            l8Var.c(this.f19798d.c(), 0, 10);
            this.f19798d.f(0);
            if (this.f19798d.z() != 4801587) {
                break;
            }
            this.f19798d.g(3);
            int iV = this.f19798d.v();
            i11 += iV + 10;
            l8Var.c(iV);
        }
        l8Var.b();
        l8Var.c(i11);
        if (this.f19802h == -1) {
            this.f19802h = i11;
        }
        return i11;
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        b1.b(this.f19800f);
        long jA = l8Var.a();
        int i11 = this.f19795a;
        if ((i11 & 2) != 0 || ((i11 & 1) != 0 && jA != -1)) {
            b(l8Var);
        }
        int iA = l8Var.a(this.f19797c.c(), 0, 2048);
        boolean z11 = iA == -1;
        b(jA, z11);
        if (z11) {
            return -1;
        }
        this.f19797c.f(0);
        this.f19797c.e(iA);
        if (!this.f19805k) {
            this.f19796b.a(this.f19801g, 4);
            this.f19805k = true;
        }
        this.f19796b.a(this.f19797c);
        return 0;
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        this.f19805k = false;
        this.f19796b.a();
        this.f19801g = j12;
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f19800f = m8Var;
        this.f19796b.a(m8Var, new dp.d(0, 1));
        m8Var.c();
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        int iC = c(l8Var);
        int i11 = iC;
        int i12 = 0;
        int i13 = 0;
        do {
            l8Var.c(this.f19798d.c(), 0, 2);
            this.f19798d.f(0);
            if (k0.a(this.f19798d.C())) {
                i12++;
                if (i12 >= 4 && i13 > 188) {
                    return true;
                }
                l8Var.c(this.f19798d.c(), 0, 4);
                this.f19799e.c(14);
                int iA = this.f19799e.a(13);
                if (iA <= 6) {
                    i11++;
                    l8Var.b();
                    l8Var.c(i11);
                } else {
                    l8Var.c(iA - 6);
                    i13 += iA;
                }
            } else {
                i11++;
                l8Var.b();
                l8Var.c(i11);
            }
            i12 = 0;
            i13 = 0;
        } while (i11 - iC < 8192);
        return false;
    }
}
