package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class bi extends c2 implements ai.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final td f17922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final td.g f17923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final i5.a f17924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zh.a f17925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b7 f17926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final mc f17927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f17928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17929n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f17930o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f17931p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f17932q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private xo f17933r;

    /* JADX INFO: compiled from: source.java */
    public class a extends i9 {
        public a(fo foVar) {
            super(foVar);
        }

        @Override // com.applovin.impl.i9, com.applovin.impl.fo
        public fo.b a(int i11, fo.b bVar, boolean z11) {
            super.a(i11, bVar, z11);
            bVar.f19036g = true;
            return bVar;
        }

        @Override // com.applovin.impl.i9, com.applovin.impl.fo
        public fo.d a(int i11, fo.d dVar, long j11) {
            super.a(i11, dVar, j11);
            dVar.f19057m = true;
            return dVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements de {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i5.a f17935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private zh.a f17936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private c7 f17937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private mc f17938d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f17939e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f17940f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Object f17941g;

        public b(i5.a aVar) {
            this(aVar, new c6());
        }

        public b(i5.a aVar, final o8 o8Var) {
            this(aVar, new zh.a() { // from class: com.applovin.impl.kt
                @Override // com.applovin.impl.zh.a
                public final zh a() {
                    return bi.b.a(o8Var);
                }
            });
        }

        public b(i5.a aVar, zh.a aVar2) {
            this.f17935a = aVar;
            this.f17936b = aVar2;
            this.f17937c = new z5();
            this.f17938d = new g6();
            this.f17939e = 1048576;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ zh a(o8 o8Var) {
            return new q2(o8Var);
        }

        public bi a(td tdVar) {
            b1.a(tdVar.f23247b);
            td.g gVar = tdVar.f23247b;
            boolean z11 = false;
            boolean z12 = gVar.f23306g == null && this.f17941g != null;
            if (gVar.f23304e == null && this.f17940f != null) {
                z11 = true;
            }
            if (z12 && z11) {
                tdVar = tdVar.a().a(this.f17941g).a(this.f17940f).a();
            } else if (z12) {
                tdVar = tdVar.a().a(this.f17941g).a();
            } else if (z11) {
                tdVar = tdVar.a().a(this.f17940f).a();
            }
            td tdVar2 = tdVar;
            return new bi(tdVar2, this.f17935a, this.f17936b, this.f17937c.a(tdVar2), this.f17938d, this.f17939e, null);
        }
    }

    private bi(td tdVar, i5.a aVar, zh.a aVar2, b7 b7Var, mc mcVar, int i11) {
        this.f17923h = (td.g) b1.a(tdVar.f23247b);
        this.f17922g = tdVar;
        this.f17924i = aVar;
        this.f17925j = aVar2;
        this.f17926k = b7Var;
        this.f17927l = mcVar;
        this.f17928m = i11;
        this.f17929n = true;
        this.f17930o = C.TIME_UNSET;
    }

    public /* synthetic */ bi(td tdVar, i5.a aVar, zh.a aVar2, b7 b7Var, mc mcVar, int i11, a aVar3) {
        this(tdVar, aVar, aVar2, b7Var, mcVar, i11);
    }

    private void i() {
        fo gkVar = new gk(this.f17930o, this.f17931p, false, this.f17932q, null, this.f17922g);
        if (this.f17929n) {
            gkVar = new a(gkVar);
        }
        a(gkVar);
    }

    @Override // com.applovin.impl.be
    public td a() {
        return this.f17922g;
    }

    @Override // com.applovin.impl.be
    public wd a(be.a aVar, n0 n0Var, long j11) {
        i5 i5VarA = this.f17924i.a();
        xo xoVar = this.f17933r;
        if (xoVar != null) {
            i5VarA.a(xoVar);
        }
        return new ai(this.f17923h.f23300a, i5VarA, this.f17925j.a(), this.f17926k, a(aVar), this.f17927l, b(aVar), this, n0Var, this.f17923h.f23304e, this.f17928m);
    }

    @Override // com.applovin.impl.ai.b
    public void a(long j11, boolean z11, boolean z12) {
        if (j11 == C.TIME_UNSET) {
            j11 = this.f17930o;
        }
        if (!this.f17929n && this.f17930o == j11 && this.f17931p == z11 && this.f17932q == z12) {
            return;
        }
        this.f17930o = j11;
        this.f17931p = z11;
        this.f17932q = z12;
        this.f17929n = false;
        i();
    }

    @Override // com.applovin.impl.be
    public void a(wd wdVar) {
        ((ai) wdVar).t();
    }

    @Override // com.applovin.impl.c2
    public void a(xo xoVar) {
        this.f17933r = xoVar;
        this.f17926k.b();
        i();
    }

    @Override // com.applovin.impl.be
    public void b() {
    }

    @Override // com.applovin.impl.c2
    public void h() {
        this.f17926k.a();
    }
}
