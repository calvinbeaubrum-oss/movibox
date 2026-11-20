package dh;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class v implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m1 f63387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.google.android.exoplayer2.util.k0 f63388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tg.e0 f63389c;

    public v(String str) {
        this.f63387a = new m1.b().e0(str).E();
    }

    @Override // dh.b0
    public void a(com.google.android.exoplayer2.util.k0 k0Var, tg.n nVar, i0.d dVar) {
        this.f63388b = k0Var;
        dVar.a();
        tg.e0 e0VarTrack = nVar.track(dVar.c(), 5);
        this.f63389c = e0VarTrack;
        e0VarTrack.e(this.f63387a);
    }

    @Override // dh.b0
    public void b(com.google.android.exoplayer2.util.c0 c0Var) {
        c();
        long jD = this.f63388b.d();
        long jE = this.f63388b.e();
        if (jD == C.TIME_UNSET || jE == C.TIME_UNSET) {
            return;
        }
        m1 m1Var = this.f63387a;
        if (jE != m1Var.f33449q) {
            m1 m1VarE = m1Var.b().i0(jE).E();
            this.f63387a = m1VarE;
            this.f63389c.e(m1VarE);
        }
        int iA = c0Var.a();
        this.f63389c.c(c0Var, iA);
        this.f63389c.d(jD, 1, iA, 0, null);
    }

    public final void c() {
        com.google.android.exoplayer2.util.a.i(this.f63388b);
        o0.j(this.f63389c);
    }
}
