package x5;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.r0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.media3.common.y f80243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z3.i0 f80244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f80245c;

    public v(String str) {
        this.f80243a = new androidx.media3.common.y.b().k0(str).I();
    }

    @Override // x5.b0
    public void a(z3.i0 i0Var, u4.u uVar, i0.d dVar) {
        this.f80244b = i0Var;
        dVar.a();
        r0 r0VarTrack = uVar.track(dVar.c(), 5);
        this.f80245c = r0VarTrack;
        r0VarTrack.b(this.f80243a);
    }

    @Override // x5.b0
    public void b(z3.c0 c0Var) {
        c();
        long jE = this.f80244b.e();
        long jF = this.f80244b.f();
        if (jE == C.TIME_UNSET || jF == C.TIME_UNSET) {
            return;
        }
        androidx.media3.common.y yVar = this.f80243a;
        if (jF != yVar.f9505q) {
            androidx.media3.common.y yVarI = yVar.b().o0(jF).I();
            this.f80243a = yVarI;
            this.f80245c.b(yVarI);
        }
        int iA = c0Var.a();
        this.f80245c.c(c0Var, iA);
        this.f80245c.f(jE, 1, iA, 0, null);
    }

    public final void c() {
        z3.a.i(this.f80244b);
        u0.i(this.f80245c);
    }
}
