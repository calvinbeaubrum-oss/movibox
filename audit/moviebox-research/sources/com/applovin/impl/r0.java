package com.applovin.impl;

import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Objects;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class r0 implements qh.e, q1, wq, ce, y1.a, a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l3 f21998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final fo.b f21999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final fo.d f22000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f22001d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray f22002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private hc f22003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private qh f22004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ja f22005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f22006j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fo.b f22007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private eb f22008b = eb.h();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private gb f22009c = gb.h();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private be.a f22010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private be.a f22011e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private be.a f22012f;

        public a(fo.b bVar) {
            this.f22007a = bVar;
        }

        private static be.a a(qh qhVar, eb ebVar, be.a aVar, fo.b bVar) {
            fo foVarN = qhVar.n();
            int iV = qhVar.v();
            Object objB = foVarN.c() ? null : foVarN.b(iV);
            int iA = (qhVar.d() || foVarN.c()) ? -1 : foVarN.a(iV, bVar).a(t2.a(qhVar.getCurrentPosition()) - bVar.e());
            for (int i11 = 0; i11 < ebVar.size(); i11++) {
                be.a aVar2 = (be.a) ebVar.get(i11);
                if (a(aVar2, objB, qhVar.d(), qhVar.E(), qhVar.f(), iA)) {
                    return aVar2;
                }
            }
            if (ebVar.isEmpty() && aVar != null) {
                if (a(aVar, objB, qhVar.d(), qhVar.E(), qhVar.f(), iA)) {
                    return aVar;
                }
            }
            return null;
        }

        private void a(fo foVar) {
            gb.a aVarA = gb.a();
            if (this.f22008b.isEmpty()) {
                a(aVarA, this.f22011e, foVar);
                if (!Objects.equal(this.f22012f, this.f22011e)) {
                    a(aVarA, this.f22012f, foVar);
                }
                if (!Objects.equal(this.f22010d, this.f22011e) && !Objects.equal(this.f22010d, this.f22012f)) {
                    a(aVarA, this.f22010d, foVar);
                }
            } else {
                for (int i11 = 0; i11 < this.f22008b.size(); i11++) {
                    a(aVarA, (be.a) this.f22008b.get(i11), foVar);
                }
                if (!this.f22008b.contains(this.f22010d)) {
                    a(aVarA, this.f22010d, foVar);
                }
            }
            this.f22009c = aVarA.a();
        }

        private void a(gb.a aVar, be.a aVar2, fo foVar) {
            if (aVar2 == null) {
                return;
            }
            if (foVar.a(aVar2.f24653a) != -1) {
                aVar.a(aVar2, foVar);
                return;
            }
            fo foVar2 = (fo) this.f22009c.get(aVar2);
            if (foVar2 != null) {
                aVar.a(aVar2, foVar2);
            }
        }

        private static boolean a(be.a aVar, Object obj, boolean z11, int i11, int i12, int i13) {
            if (aVar.f24653a.equals(obj)) {
                return (z11 && aVar.f24654b == i11 && aVar.f24655c == i12) || (!z11 && aVar.f24654b == -1 && aVar.f24657e == i13);
            }
            return false;
        }

        public be.a a() {
            return this.f22010d;
        }

        public fo a(be.a aVar) {
            return (fo) this.f22009c.get(aVar);
        }

        public void a(qh qhVar) {
            this.f22010d = a(qhVar, this.f22008b, this.f22011e, this.f22007a);
        }

        public void a(List list, be.a aVar, qh qhVar) {
            this.f22008b = eb.a((Collection) list);
            if (!list.isEmpty()) {
                this.f22011e = (be.a) list.get(0);
                this.f22012f = (be.a) b1.a(aVar);
            }
            if (this.f22010d == null) {
                this.f22010d = a(qhVar, this.f22008b, this.f22011e, this.f22007a);
            }
            a(qhVar.n());
        }

        public be.a b() {
            if (this.f22008b.isEmpty()) {
                return null;
            }
            return (be.a) wb.b(this.f22008b);
        }

        public void b(qh qhVar) {
            this.f22010d = a(qhVar, this.f22008b, this.f22011e, this.f22007a);
            a(qhVar.n());
        }

        public be.a c() {
            return this.f22011e;
        }

        public be.a d() {
            return this.f22012f;
        }
    }

    public r0(l3 l3Var) {
        this.f21998a = (l3) b1.a(l3Var);
        this.f22003g = new hc(xp.d(), l3Var, new hc.b() { // from class: com.applovin.impl.s30
            @Override // com.applovin.impl.hc.b
            public final void a(Object obj, b9 b9Var) {
                r0.a((s0) obj, b9Var);
            }
        });
        fo.b bVar = new fo.b();
        this.f21999b = bVar;
        this.f22000c = new fo.d();
        this.f22001d = new a(bVar);
        this.f22002f = new SparseArray();
    }

    private s0.a a(be.a aVar) {
        b1.a(this.f22004h);
        fo foVarA = aVar == null ? null : this.f22001d.a(aVar);
        if (aVar != null && foVarA != null) {
            return a(foVarA, foVarA.a(aVar.f24653a, this.f21999b).f19033c, aVar);
        }
        int iT = this.f22004h.t();
        fo foVarN = this.f22004h.n();
        if (iT >= foVarN.b()) {
            foVarN = fo.f19028a;
        }
        return a(foVarN, iT, (be.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(qh qhVar, s0 s0Var, b9 b9Var) {
        s0Var.a(qhVar, new s0.b(b9Var, this.f22002f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, int i11, qh.f fVar, qh.f fVar2, s0 s0Var) {
        s0Var.a(aVar, i11);
        s0Var.a(aVar, fVar, fVar2, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, int i11, s0 s0Var) {
        s0Var.f(aVar);
        s0Var.b(aVar, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, f9 f9Var, q5 q5Var, s0 s0Var) {
        s0Var.b(aVar, f9Var);
        s0Var.b(aVar, f9Var, q5Var);
        s0Var.a(aVar, 1, f9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, n5 n5Var, s0 s0Var) {
        s0Var.c(aVar, n5Var);
        s0Var.b(aVar, 1, n5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, xq xqVar, s0 s0Var) {
        s0Var.a(aVar, xqVar);
        s0Var.a(aVar, xqVar.f24389a, xqVar.f24390b, xqVar.f24391c, xqVar.f24392d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, String str, long j11, long j12, s0 s0Var) {
        s0Var.a(aVar, str, j11);
        s0Var.b(aVar, str, j12, j11);
        s0Var.a(aVar, 1, str, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0.a aVar, boolean z11, s0 s0Var) {
        s0Var.c(aVar, z11);
        s0Var.e(aVar, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(s0 s0Var, b9 b9Var) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(s0.a aVar, f9 f9Var, q5 q5Var, s0 s0Var) {
        s0Var.a(aVar, f9Var);
        s0Var.a(aVar, f9Var, q5Var);
        s0Var.a(aVar, 2, f9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(s0.a aVar, n5 n5Var, s0 s0Var) {
        s0Var.b(aVar, n5Var);
        s0Var.a(aVar, 1, n5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(s0.a aVar, String str, long j11, long j12, s0 s0Var) {
        s0Var.b(aVar, str, j11);
        s0Var.a(aVar, str, j12, j11);
        s0Var.a(aVar, 2, str, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(s0.a aVar, n5 n5Var, s0 s0Var) {
        s0Var.d(aVar, n5Var);
        s0Var.b(aVar, 2, n5Var);
    }

    private s0.a d() {
        return a(this.f22001d.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(s0.a aVar, n5 n5Var, s0 s0Var) {
        s0Var.a(aVar, n5Var);
        s0Var.a(aVar, 2, n5Var);
    }

    private s0.a e() {
        return a(this.f22001d.c());
    }

    private s0.a f() {
        return a(this.f22001d.d());
    }

    private s0.a f(int i11, be.a aVar) {
        b1.a(this.f22004h);
        if (aVar != null) {
            return this.f22001d.a(aVar) != null ? a(aVar) : a(fo.f19028a, i11, aVar);
        }
        fo foVarN = this.f22004h.n();
        if (i11 >= foVarN.b()) {
            foVarN = fo.f19028a;
        }
        return a(foVarN, i11, (be.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        this.f22003g.b();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    public final s0.a a(fo foVar, int i11, be.a aVar) {
        long jB;
        be.a aVar2 = foVar.c() ? null : aVar;
        long jC = this.f21998a.c();
        boolean z11 = foVar.equals(this.f22004h.n()) && i11 == this.f22004h.t();
        if (aVar2 == null || !aVar2.a()) {
            if (z11) {
                jB = this.f22004h.g();
            } else if (foVar.c()) {
                jB = 0;
            } else {
                jB = foVar.a(i11, this.f22000c).b();
            }
        } else if (z11 && this.f22004h.E() == aVar2.f24654b && this.f22004h.f() == aVar2.f24655c) {
            jB = this.f22004h.getCurrentPosition();
        } else {
            jB = 0;
        }
        return new s0.a(jC, foVar, i11, aVar2, jB, this.f22004h.n(), this.f22004h.t(), this.f22001d.a(), this.f22004h.getCurrentPosition(), this.f22004h.h());
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a() {
        d20.a(this);
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final float f11) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_ZOOM_OUT, new hc.a() { // from class: com.applovin.impl.y20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, f11);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final int i11) {
        final s0.a aVarC = c();
        a(aVarC, 6, new hc.a() { // from class: com.applovin.impl.n30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).e(aVarC, i11);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public void a(final int i11, final int i12) {
        final s0.a aVarF = f();
        a(aVarF, 1029, new hc.a() { // from class: com.applovin.impl.p30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, i11, i12);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final int i11, final long j11) {
        final s0.a aVarE = e();
        a(aVarE, 1023, new hc.a() { // from class: com.applovin.impl.q20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarE, i11, j11);
            }
        });
    }

    @Override // com.applovin.impl.y1.a
    public final void a(final int i11, final long j11, final long j12) {
        final s0.a aVarD = d();
        a(aVarD, PointerIconCompat.TYPE_CELL, new hc.a() { // from class: com.applovin.impl.v30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarD, i11, j11, j12);
            }
        });
    }

    @Override // com.applovin.impl.a7
    public final void a(int i11, be.a aVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1034, new hc.a() { // from class: com.applovin.impl.l30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).h(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.a7
    public final void a(int i11, be.a aVar, final int i12) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1030, new hc.a() { // from class: com.applovin.impl.i40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarF, i12, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.ce
    public final void a(int i11, be.a aVar, final nc ncVar, final ud udVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1002, new hc.a() { // from class: com.applovin.impl.a40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF, ncVar, udVar);
            }
        });
    }

    @Override // com.applovin.impl.ce
    public final void a(int i11, be.a aVar, final nc ncVar, final ud udVar, final IOException iOException, final boolean z11) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1003, new hc.a() { // from class: com.applovin.impl.z30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, ncVar, udVar, iOException, z11);
            }
        });
    }

    @Override // com.applovin.impl.ce
    public final void a(int i11, be.a aVar, final ud udVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1004, new hc.a() { // from class: com.applovin.impl.b40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, udVar);
            }
        });
    }

    @Override // com.applovin.impl.a7
    public final void a(int i11, be.a aVar, final Exception exc) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1032, new hc.a() { // from class: com.applovin.impl.r20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final long j11) {
        final s0.a aVarF = f();
        a(aVarF, 1011, new hc.a() { // from class: com.applovin.impl.m30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, j11);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final long j11, final int i11) {
        final s0.a aVarE = e();
        a(aVarE, 1026, new hc.a() { // from class: com.applovin.impl.w30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarE, j11, i11);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final bf bfVar) {
        final s0.a aVarC = c();
        a(aVarC, PointerIconCompat.TYPE_CROSSHAIR, new hc.a() { // from class: com.applovin.impl.c40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, bfVar);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public /* synthetic */ void a(f9 f9Var) {
        g80.a(this, f9Var);
    }

    @Override // com.applovin.impl.wq
    public final void a(final f9 f9Var, final q5 q5Var) {
        final s0.a aVarF = f();
        a(aVarF, 1022, new hc.a() { // from class: com.applovin.impl.v20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.b(aVarF, f9Var, q5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(fo foVar, final int i11) {
        this.f22001d.b((qh) b1.a(this.f22004h));
        final s0.a aVarC = c();
        a(aVarC, 0, new hc.a() { // from class: com.applovin.impl.b30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarC, i11);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final n5 n5Var) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_TEXT, new hc.a() { // from class: com.applovin.impl.l40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.b(aVarF, n5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final nh nhVar) {
        yd ydVar;
        final s0.a aVarA = (!(nhVar instanceof a8) || (ydVar = ((a8) nhVar).f17475j) == null) ? null : a(new be.a(ydVar));
        if (aVarA == null) {
            aVarA = c();
        }
        a(aVarA, 10, new hc.a() { // from class: com.applovin.impl.p20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarA, nhVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final ph phVar) {
        final s0.a aVarC = c();
        a(aVarC, 12, new hc.a() { // from class: com.applovin.impl.j30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, phVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final po poVar, final to toVar) {
        final s0.a aVarC = c();
        a(aVarC, 2, new hc.a() { // from class: com.applovin.impl.s20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, poVar, toVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public void a(final qh.b bVar) {
        final s0.a aVarC = c();
        a(aVarC, 13, new hc.a() { // from class: com.applovin.impl.d30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, bVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final qh.f fVar, final qh.f fVar2, final int i11) {
        if (i11 == 1) {
            this.f22006j = false;
        }
        this.f22001d.a((qh) b1.a(this.f22004h));
        final s0.a aVarC = c();
        a(aVarC, 11, new hc.a() { // from class: com.applovin.impl.j40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarC, i11, fVar, fVar2, (s0) obj);
            }
        });
    }

    public void a(final qh qhVar, Looper looper) {
        b1.b(this.f22004h == null || this.f22001d.f22008b.isEmpty());
        this.f22004h = (qh) b1.a(qhVar);
        this.f22005i = this.f21998a.a(looper, null);
        this.f22003g = this.f22003g.a(looper, new hc.b() { // from class: com.applovin.impl.u20
            @Override // com.applovin.impl.hc.b
            public final void a(Object obj, b9 b9Var) {
                this.f23507a.a(qhVar, (s0) obj, b9Var);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void a(qh qhVar, qh.d dVar) {
        d20.l(this, qhVar, dVar);
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(r6 r6Var) {
        d20.m(this, r6Var);
    }

    public final void a(s0.a aVar, int i11, hc.a aVar2) {
        this.f22002f.put(i11, aVar);
        this.f22003g.b(i11, aVar2);
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final td tdVar, final int i11) {
        final s0.a aVarC = c();
        a(aVarC, 1, new hc.a() { // from class: com.applovin.impl.x30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, tdVar, i11);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public void a(final vd vdVar) {
        final s0.a aVarC = c();
        a(aVarC, 14, new hc.a() { // from class: com.applovin.impl.a30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, vdVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final xq xqVar) {
        final s0.a aVarF = f();
        a(aVarF, 1028, new hc.a() { // from class: com.applovin.impl.h30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarF, xqVar, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final Exception exc) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_ZOOM_IN, new hc.a() { // from class: com.applovin.impl.u30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final Object obj, final long j11) {
        final s0.a aVarF = f();
        a(aVarF, 1027, new hc.a() { // from class: com.applovin.impl.r30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj2) {
                ((s0) obj2).a(aVarF, obj, j11);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void a(final String str) {
        final s0.a aVarF = f();
        a(aVarF, 1024, new hc.a() { // from class: com.applovin.impl.o20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, str);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void a(final String str, final long j11, final long j12) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_VERTICAL_TEXT, new hc.a() { // from class: com.applovin.impl.o30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarF, str, j12, j11, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void a(List list) {
        d20.q(this, list);
    }

    public final void a(List list, be.a aVar) {
        this.f22001d.a(list, aVar, (qh) b1.a(this.f22004h));
    }

    @Override // com.applovin.impl.qh.e
    public final void a(final boolean z11) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, new hc.a() { // from class: com.applovin.impl.e30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarF, z11);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void a(final boolean z11, final int i11) {
        final s0.a aVarC = c();
        a(aVarC, 5, new hc.a() { // from class: com.applovin.impl.o40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarC, z11, i11);
            }
        });
    }

    @Override // com.applovin.impl.qh.c
    public final void b() {
        final s0.a aVarC = c();
        a(aVarC, -1, new hc.a() { // from class: com.applovin.impl.g30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).e(aVarC);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void b(final int i11) {
        final s0.a aVarC = c();
        a(aVarC, 4, new hc.a() { // from class: com.applovin.impl.k40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarC, i11);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void b(final int i11, final long j11, final long j12) {
        final s0.a aVarF = f();
        a(aVarF, 1012, new hc.a() { // from class: com.applovin.impl.c30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, i11, j11, j12);
            }
        });
    }

    @Override // com.applovin.impl.a7
    public final void b(int i11, be.a aVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1035, new hc.a() { // from class: com.applovin.impl.d40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).g(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.ce
    public final void b(int i11, be.a aVar, final nc ncVar, final ud udVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1000, new hc.a() { // from class: com.applovin.impl.f40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, ncVar, udVar);
            }
        });
    }

    @Override // com.applovin.impl.qh.e
    public /* synthetic */ void b(int i11, boolean z11) {
        d20.u(this, i11, z11);
    }

    @Override // com.applovin.impl.q1
    public /* synthetic */ void b(f9 f9Var) {
        l10.a(this, f9Var);
    }

    @Override // com.applovin.impl.q1
    public final void b(final f9 f9Var, final q5 q5Var) {
        final s0.a aVarF = f();
        a(aVarF, 1010, new hc.a() { // from class: com.applovin.impl.q30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarF, f9Var, q5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void b(final n5 n5Var) {
        final s0.a aVarE = e();
        a(aVarE, InputDeviceCompat.SOURCE_GAMEPAD, new hc.a() { // from class: com.applovin.impl.h40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.c(aVarE, n5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public /* synthetic */ void b(nh nhVar) {
        d20.v(this, nhVar);
    }

    @Override // com.applovin.impl.wq
    public final void b(final Exception exc) {
        final s0.a aVarF = f();
        a(aVarF, 1038, new hc.a() { // from class: com.applovin.impl.t20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void b(final String str) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_ALL_SCROLL, new hc.a() { // from class: com.applovin.impl.t30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF, str);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void b(final String str, final long j11, final long j12) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_GRABBING, new hc.a() { // from class: com.applovin.impl.x20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.b(aVarF, str, j12, j11, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void b(final boolean z11) {
        final s0.a aVarC = c();
        a(aVarC, 9, new hc.a() { // from class: com.applovin.impl.e40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, z11);
            }
        });
    }

    @Override // com.applovin.impl.qh.c
    public final void b(final boolean z11, final int i11) {
        final s0.a aVarC = c();
        a(aVarC, -1, new hc.a() { // from class: com.applovin.impl.z20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC, z11, i11);
            }
        });
    }

    public final s0.a c() {
        return a(this.f22001d.a());
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void c(final int i11) {
        final s0.a aVarC = c();
        a(aVarC, 8, new hc.a() { // from class: com.applovin.impl.k30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).f(aVarC, i11);
            }
        });
    }

    @Override // com.applovin.impl.a7
    public final void c(int i11, be.a aVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1033, new hc.a() { // from class: com.applovin.impl.f30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.ce
    public final void c(int i11, be.a aVar, final nc ncVar, final ud udVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1001, new hc.a() { // from class: com.applovin.impl.w20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).c(aVarF, ncVar, udVar);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void c(final n5 n5Var) {
        final s0.a aVarE = e();
        a(aVarE, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, new hc.a() { // from class: com.applovin.impl.n40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarE, n5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.q1
    public final void c(final Exception exc) {
        final s0.a aVarF = f();
        a(aVarF, 1037, new hc.a() { // from class: com.applovin.impl.n20
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarF, exc);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public final void c(final boolean z11) {
        final s0.a aVarC = c();
        a(aVarC, 3, new hc.a() { // from class: com.applovin.impl.i30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.a(aVarC, z11, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.a7
    public final void d(int i11, be.a aVar) {
        final s0.a aVarF = f(i11, aVar);
        a(aVarF, 1031, new hc.a() { // from class: com.applovin.impl.g40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarF);
            }
        });
    }

    @Override // com.applovin.impl.wq
    public final void d(final n5 n5Var) {
        final s0.a aVarF = f();
        a(aVarF, PointerIconCompat.TYPE_GRAB, new hc.a() { // from class: com.applovin.impl.m40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                r0.d(aVarF, n5Var, (s0) obj);
            }
        });
    }

    @Override // com.applovin.impl.qh.e, com.applovin.impl.qh.c
    public void d(final boolean z11) {
        final s0.a aVarC = c();
        a(aVarC, 7, new hc.a() { // from class: com.applovin.impl.p40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).b(aVarC, z11);
            }
        });
    }

    @Override // com.applovin.impl.qh.c
    public /* synthetic */ void e(int i11) {
        c20.s(this, i11);
    }

    @Override // com.applovin.impl.a7
    public /* synthetic */ void e(int i11, be.a aVar) {
        js.a(this, i11, aVar);
    }

    @Override // com.applovin.impl.qh.c
    public /* synthetic */ void e(boolean z11) {
        c20.t(this, z11);
    }

    public final void h() {
        if (this.f22006j) {
            return;
        }
        final s0.a aVarC = c();
        this.f22006j = true;
        a(aVarC, -1, new hc.a() { // from class: com.applovin.impl.y30
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).a(aVarC);
            }
        });
    }

    public void i() {
        final s0.a aVarC = c();
        this.f22002f.put(1036, aVarC);
        a(aVarC, 1036, new hc.a() { // from class: com.applovin.impl.q40
            @Override // com.applovin.impl.hc.a
            public final void a(Object obj) {
                ((s0) obj).d(aVarC);
            }
        });
        ((ja) b1.b(this.f22005i)).a(new Runnable() { // from class: com.applovin.impl.r40
            @Override // java.lang.Runnable
            public final void run() {
                this.f22039a.g();
            }
        });
    }
}
