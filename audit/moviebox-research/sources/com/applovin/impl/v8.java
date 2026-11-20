package com.applovin.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v8 implements k8 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final o8 f23770o = new o8() { // from class: com.applovin.impl.g70
        @Override // com.applovin.impl.o8
        public final k8[] a() {
            return v8.b();
        }

        @Override // com.applovin.impl.o8
        public /* synthetic */ k8[] a(Uri uri, Map map) {
            return q00.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f23771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f23772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w8.a f23774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m8 f23775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private qo f23776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f23777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private bf f23778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a9 f23779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private u8 f23782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f23783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f23784n;

    public v8() {
        this(0);
    }

    public v8(int i11) {
        this.f23771a = new byte[42];
        this.f23772b = new bh(new byte[32768], 0);
        this.f23773c = (i11 & 1) != 0;
        this.f23774d = new w8.a();
        this.f23777g = 0;
    }

    private long a(bh bhVar, boolean z11) {
        boolean zA;
        b1.a(this.f23779i);
        int iD = bhVar.d();
        while (iD <= bhVar.e() - 16) {
            bhVar.f(iD);
            if (w8.a(bhVar, this.f23779i, this.f23781k, this.f23774d)) {
                bhVar.f(iD);
                return this.f23774d.f24075a;
            }
            iD++;
        }
        if (!z11) {
            bhVar.f(iD);
            return -1L;
        }
        while (iD <= bhVar.e() - this.f23780j) {
            bhVar.f(iD);
            try {
                zA = w8.a(bhVar, this.f23779i, this.f23781k, this.f23774d);
            } catch (IndexOutOfBoundsException unused) {
                zA = false;
            }
            if (bhVar.d() <= bhVar.e() && zA) {
                bhVar.f(iD);
                return this.f23774d.f24075a;
            }
            iD++;
        }
        bhVar.f(bhVar.e());
        return -1L;
    }

    private int b(l8 l8Var, th thVar) {
        boolean z11;
        b1.a(this.f23776f);
        b1.a(this.f23779i);
        u8 u8Var = this.f23782l;
        if (u8Var != null && u8Var.b()) {
            return this.f23782l.a(l8Var, thVar);
        }
        if (this.f23784n == -1) {
            this.f23784n = w8.a(l8Var, this.f23779i);
            return 0;
        }
        int iE = this.f23772b.e();
        if (iE < 32768) {
            int iA = l8Var.a(this.f23772b.c(), iE, 32768 - iE);
            z11 = iA == -1;
            if (!z11) {
                this.f23772b.e(iE + iA);
            } else if (this.f23772b.a() == 0) {
                c();
                return -1;
            }
        } else {
            z11 = false;
        }
        int iD = this.f23772b.d();
        int i11 = this.f23783m;
        int i12 = this.f23780j;
        if (i11 < i12) {
            bh bhVar = this.f23772b;
            bhVar.g(Math.min(i12 - i11, bhVar.a()));
        }
        long jA = a(this.f23772b, z11);
        int iD2 = this.f23772b.d() - iD;
        this.f23772b.f(iD);
        this.f23776f.a(this.f23772b, iD2);
        this.f23783m += iD2;
        if (jA != -1) {
            c();
            this.f23783m = 0;
            this.f23784n = jA;
        }
        if (this.f23772b.a() < 16) {
            int iA2 = this.f23772b.a();
            System.arraycopy(this.f23772b.c(), this.f23772b.d(), this.f23772b.c(), 0, iA2);
            this.f23772b.f(0);
            this.f23772b.e(iA2);
        }
        return 0;
    }

    private ij b(long j11, long j12) {
        b1.a(this.f23779i);
        a9 a9Var = this.f23779i;
        if (a9Var.f17489k != null) {
            return new z8(a9Var, j11);
        }
        if (j12 == -1 || a9Var.f17488j <= 0) {
            return new ij.b(a9Var.b());
        }
        u8 u8Var = new u8(a9Var, this.f23781k, j11, j12);
        this.f23782l = u8Var;
        return u8Var.a();
    }

    private void b(l8 l8Var) {
        this.f23781k = x8.b(l8Var);
        ((m8) xp.a(this.f23775e)).a(b(l8Var.f(), l8Var.a()));
        this.f23777g = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ k8[] b() {
        return new k8[]{new v8()};
    }

    private void c() {
        ((qo) xp.a(this.f23776f)).a((this.f23784n * 1000000) / ((long) ((a9) xp.a(this.f23779i)).f17483e), 1, this.f23783m, 0, null);
    }

    private void c(l8 l8Var) {
        byte[] bArr = this.f23771a;
        l8Var.c(bArr, 0, bArr.length);
        l8Var.b();
        this.f23777g = 2;
    }

    private void d(l8 l8Var) {
        this.f23778h = x8.b(l8Var, !this.f23773c);
        this.f23777g = 1;
    }

    private void e(l8 l8Var) {
        x8.a aVar = new x8.a(this.f23779i);
        boolean zA = false;
        while (!zA) {
            zA = x8.a(l8Var, aVar);
            this.f23779i = (a9) xp.a(aVar.f24267a);
        }
        b1.a(this.f23779i);
        this.f23780j = Math.max(this.f23779i.f17481c, 6);
        ((qo) xp.a(this.f23776f)).a(this.f23779i.a(this.f23771a, this.f23778h));
        this.f23777g = 4;
    }

    private void f(l8 l8Var) throws dh {
        x8.d(l8Var);
        this.f23777g = 3;
    }

    @Override // com.applovin.impl.k8
    public int a(l8 l8Var, th thVar) throws dh {
        int i11 = this.f23777g;
        if (i11 == 0) {
            d(l8Var);
            return 0;
        }
        if (i11 == 1) {
            c(l8Var);
            return 0;
        }
        if (i11 == 2) {
            f(l8Var);
            return 0;
        }
        if (i11 == 3) {
            e(l8Var);
            return 0;
        }
        if (i11 == 4) {
            b(l8Var);
            return 0;
        }
        if (i11 == 5) {
            return b(l8Var, thVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.applovin.impl.k8
    public void a() {
    }

    @Override // com.applovin.impl.k8
    public void a(long j11, long j12) {
        if (j11 == 0) {
            this.f23777g = 0;
        } else {
            u8 u8Var = this.f23782l;
            if (u8Var != null) {
                u8Var.b(j12);
            }
        }
        this.f23784n = j12 != 0 ? -1L : 0L;
        this.f23783m = 0;
        this.f23772b.d(0);
    }

    @Override // com.applovin.impl.k8
    public void a(m8 m8Var) {
        this.f23775e = m8Var;
        this.f23776f = m8Var.a(0, 1);
        m8Var.c();
    }

    @Override // com.applovin.impl.k8
    public boolean a(l8 l8Var) {
        x8.a(l8Var, false);
        return x8.a(l8Var);
    }
}
