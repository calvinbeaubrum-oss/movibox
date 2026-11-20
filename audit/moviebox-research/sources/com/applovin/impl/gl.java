package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class gl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f19248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m8 f19249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private kg f19250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f19253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19255i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f19258l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f19259m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig f19247a = new ig();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f19256j = new b();

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f9 f19260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        kg f19261b;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements kg {
        private c() {
        }

        @Override // com.applovin.impl.kg
        public long a(l8 l8Var) {
            return -1L;
        }

        @Override // com.applovin.impl.kg
        public ij a() {
            return new ij.b(C.TIME_UNSET);
        }

        @Override // com.applovin.impl.kg
        public void a(long j11) {
        }
    }

    private void a() {
        b1.b(this.f19248b);
        xp.a(this.f19249c);
    }

    private boolean a(l8 l8Var) {
        while (this.f19247a.a(l8Var)) {
            this.f19257k = l8Var.f() - this.f19252f;
            if (!a(this.f19247a.b(), this.f19252f, this.f19256j)) {
                return true;
            }
            this.f19252f = l8Var.f();
        }
        this.f19254h = 3;
        return false;
    }

    private int b(l8 l8Var) {
        if (!a(l8Var)) {
            return -1;
        }
        f9 f9Var = this.f19256j.f19260a;
        this.f19255i = f9Var.A;
        if (!this.f19259m) {
            this.f19248b.a(f9Var);
            this.f19259m = true;
        }
        kg kgVar = this.f19256j.f19261b;
        if (kgVar != null) {
            this.f19250d = kgVar;
        } else if (l8Var.a() == -1) {
            this.f19250d = new c();
        } else {
            jg jgVarA = this.f19247a.a();
            this.f19250d = new j6(this, this.f19252f, l8Var.a(), jgVarA.f19955h + jgVarA.f19956i, jgVarA.f19950c, (jgVarA.f19949b & 4) != 0);
        }
        this.f19254h = 2;
        this.f19247a.d();
        return 0;
    }

    private int b(l8 l8Var, th thVar) {
        long jA = this.f19250d.a(l8Var);
        if (jA >= 0) {
            thVar.f23379a = jA;
            return 1;
        }
        if (jA < -1) {
            c(-(jA + 2));
        }
        if (!this.f19258l) {
            this.f19249c.a((ij) b1.b(this.f19250d.a()));
            this.f19258l = true;
        }
        if (this.f19257k <= 0 && !this.f19247a.a(l8Var)) {
            this.f19254h = 3;
            return -1;
        }
        this.f19257k = 0L;
        bh bhVarB = this.f19247a.b();
        long jA2 = a(bhVarB);
        if (jA2 >= 0) {
            long j11 = this.f19253g;
            if (j11 + jA2 >= this.f19251e) {
                long jA3 = a(j11);
                this.f19248b.a(bhVarB, bhVarB.e());
                this.f19248b.a(jA3, 1, bhVarB.e(), 0, null);
                this.f19251e = -1L;
            }
        }
        this.f19253g += jA2;
        return 0;
    }

    public final int a(l8 l8Var, th thVar) {
        a();
        int i11 = this.f19254h;
        if (i11 == 0) {
            return b(l8Var);
        }
        if (i11 == 1) {
            l8Var.a((int) this.f19252f);
            this.f19254h = 2;
            return 0;
        }
        if (i11 == 2) {
            xp.a(this.f19250d);
            return b(l8Var, thVar);
        }
        if (i11 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public long a(long j11) {
        return (j11 * 1000000) / ((long) this.f19255i);
    }

    public abstract long a(bh bhVar);

    public final void a(long j11, long j12) {
        this.f19247a.c();
        if (j11 == 0) {
            a(!this.f19258l);
        } else if (this.f19254h != 0) {
            this.f19251e = b(j12);
            ((kg) xp.a(this.f19250d)).a(this.f19251e);
            this.f19254h = 2;
        }
    }

    public void a(m8 m8Var, qo qoVar) {
        this.f19249c = m8Var;
        this.f19248b = qoVar;
        a(true);
    }

    public void a(boolean z11) {
        if (z11) {
            this.f19256j = new b();
            this.f19252f = 0L;
            this.f19254h = 0;
        } else {
            this.f19254h = 1;
        }
        this.f19251e = -1L;
        this.f19253g = 0L;
    }

    public abstract boolean a(bh bhVar, long j11, b bVar);

    public long b(long j11) {
        return (((long) this.f19255i) * j11) / 1000000;
    }

    public void c(long j11) {
        this.f19253g = j11;
    }
}
