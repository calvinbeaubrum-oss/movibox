package com.applovin.impl;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class xc extends b4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final be f24282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f24283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final fo.d f24284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final fo.b f24285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f24286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private wc f24287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f24288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f24289q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f24290r;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends i9 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Object f24291g = new Object();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f24292d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f24293f;

        private a(fo foVar, Object obj, Object obj2) {
            super(foVar);
            this.f24292d = obj;
            this.f24293f = obj2;
        }

        public static a a(fo foVar, Object obj, Object obj2) {
            return new a(foVar, obj, obj2);
        }

        public static a a(td tdVar) {
            return new a(new b(tdVar), fo.d.f19042s, f24291g);
        }

        @Override // com.applovin.impl.i9, com.applovin.impl.fo
        public int a(Object obj) {
            Object obj2;
            fo foVar = this.f19652c;
            if (f24291g.equals(obj) && (obj2 = this.f24293f) != null) {
                obj = obj2;
            }
            return foVar.a(obj);
        }

        @Override // com.applovin.impl.i9, com.applovin.impl.fo
        public fo.b a(int i11, fo.b bVar, boolean z11) {
            this.f19652c.a(i11, bVar, z11);
            if (xp.a(bVar.f19032b, this.f24293f) && z11) {
                bVar.f19032b = f24291g;
            }
            return bVar;
        }

        @Override // com.applovin.impl.i9, com.applovin.impl.fo
        public fo.d a(int i11, fo.d dVar, long j11) {
            this.f19652c.a(i11, dVar, j11);
            if (xp.a(dVar.f19046a, this.f24292d)) {
                dVar.f19046a = fo.d.f19042s;
            }
            return dVar;
        }

        public a a(fo foVar) {
            return new a(foVar, this.f24292d, this.f24293f);
        }

        @Override // com.applovin.impl.i9, com.applovin.impl.fo
        public Object b(int i11) {
            Object objB = this.f19652c.b(i11);
            return xp.a(objB, this.f24293f) ? f24291g : objB;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends fo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final td f24294c;

        public b(td tdVar) {
            this.f24294c = tdVar;
        }

        @Override // com.applovin.impl.fo
        public int a() {
            return 1;
        }

        @Override // com.applovin.impl.fo
        public int a(Object obj) {
            return obj == a.f24291g ? 0 : -1;
        }

        @Override // com.applovin.impl.fo
        public fo.b a(int i11, fo.b bVar, boolean z11) {
            bVar.a(z11 ? 0 : null, z11 ? a.f24291g : null, 0, C.TIME_UNSET, 0L, u.f23439h, true);
            return bVar;
        }

        @Override // com.applovin.impl.fo
        public fo.d a(int i11, fo.d dVar, long j11) {
            dVar.a(fo.d.f19042s, this.f24294c, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, false, true, null, 0L, C.TIME_UNSET, 0, 0, 0L);
            dVar.f19057m = true;
            return dVar;
        }

        @Override // com.applovin.impl.fo
        public int b() {
            return 1;
        }

        @Override // com.applovin.impl.fo
        public Object b(int i11) {
            return a.f24291g;
        }
    }

    public xc(be beVar, boolean z11) {
        this.f24282j = beVar;
        this.f24283k = z11 && beVar.c();
        this.f24284l = new fo.d();
        this.f24285m = new fo.b();
        fo foVarD = beVar.d();
        if (foVarD == null) {
            this.f24286n = a.a(beVar.a());
        } else {
            this.f24286n = a.a(foVarD, (Object) null, (Object) null);
            this.f24290r = true;
        }
    }

    private Object a(Object obj) {
        return (this.f24286n.f24293f == null || !this.f24286n.f24293f.equals(obj)) ? obj : a.f24291g;
    }

    private void a(long j11) {
        wc wcVar = this.f24287o;
        int iA = this.f24286n.a(wcVar.f24080a.f24653a);
        if (iA == -1) {
            return;
        }
        long j12 = this.f24286n.a(iA, this.f24285m).f19034d;
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            j11 = Math.max(0L, j12 - 1);
        }
        wcVar.e(j11);
    }

    private Object b(Object obj) {
        return (this.f24286n.f24293f == null || !obj.equals(a.f24291g)) ? obj : this.f24286n.f24293f;
    }

    @Override // com.applovin.impl.b4
    public be.a a(Void r11, be.a aVar) {
        return aVar.b(a(aVar.f24653a));
    }

    @Override // com.applovin.impl.be
    public td a() {
        return this.f24282j.a();
    }

    @Override // com.applovin.impl.be
    public void a(wd wdVar) {
        ((wc) wdVar).i();
        if (wdVar == this.f24287o) {
            this.f24287o = null;
        }
    }

    @Override // com.applovin.impl.b4, com.applovin.impl.c2
    public void a(xo xoVar) {
        super.a(xoVar);
        if (this.f24283k) {
            return;
        }
        this.f24288p = true;
        a((Object) null, this.f24282j);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.applovin.impl.b4
    public void a(Void r13, be beVar, fo foVar) {
        long j11;
        be.a aVarB;
        if (this.f24289q) {
            this.f24286n = this.f24286n.a(foVar);
            wc wcVar = this.f24287o;
            if (wcVar != null) {
                a(wcVar.c());
            }
        } else {
            if (!foVar.c()) {
                foVar.a(0, this.f24284l);
                long jC = this.f24284l.c();
                Object obj = this.f24284l.f19046a;
                wc wcVar2 = this.f24287o;
                if (wcVar2 != null) {
                    long jD = wcVar2.d();
                    this.f24286n.a(this.f24287o.f24080a.f24653a, this.f24285m);
                    long jE = this.f24285m.e() + jD;
                    if (jE != this.f24286n.a(0, this.f24284l).c()) {
                        j11 = jE;
                    } else {
                        j11 = jC;
                    }
                } else {
                    j11 = jC;
                }
                Pair pairA = foVar.a(this.f24284l, this.f24285m, 0, j11);
                Object obj2 = pairA.first;
                long jLongValue = ((Long) pairA.second).longValue();
                this.f24286n = this.f24290r ? this.f24286n.a(foVar) : a.a(foVar, obj, obj2);
                wc wcVar3 = this.f24287o;
                if (wcVar3 != null) {
                    a(jLongValue);
                    be.a aVar = wcVar3.f24080a;
                    aVarB = aVar.b(b(aVar.f24653a));
                }
                this.f24290r = true;
                this.f24289q = true;
                a((fo) this.f24286n);
                if (aVarB != null) {
                    ((wc) b1.a(this.f24287o)).a(aVarB);
                }
            }
            this.f24286n = this.f24290r ? this.f24286n.a(foVar) : a.a(foVar, fo.d.f19042s, a.f24291g);
        }
        aVarB = null;
        this.f24290r = true;
        this.f24289q = true;
        a((fo) this.f24286n);
        if (aVarB != null) {
            ((wc) b1.a(this.f24287o)).a(aVarB);
        }
    }

    @Override // com.applovin.impl.be
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public wc a(be.a aVar, n0 n0Var, long j11) {
        wc wcVar = new wc(aVar, n0Var, j11);
        wcVar.a(this.f24282j);
        if (this.f24289q) {
            wcVar.a(aVar.b(b(aVar.f24653a)));
        } else {
            this.f24287o = wcVar;
            if (!this.f24288p) {
                this.f24288p = true;
                a((Object) null, this.f24282j);
            }
        }
        return wcVar;
    }

    @Override // com.applovin.impl.be
    public void b() {
    }

    @Override // com.applovin.impl.b4, com.applovin.impl.c2
    public void h() {
        this.f24289q = false;
        this.f24288p = false;
        super.h();
    }

    public fo i() {
        return this.f24286n;
    }
}
