package b5;

import u4.e0;
import u4.m0;
import u4.n0;
import u4.r0;
import u4.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f14028b;

    /* JADX INFO: compiled from: source.java */
    public class a extends e0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f14029b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m0 m0Var, m0 m0Var2) {
            super(m0Var);
            this.f14029b = m0Var2;
        }

        @Override // u4.e0, u4.m0
        public m0.a getSeekPoints(long j11) {
            m0.a seekPoints = this.f14029b.getSeekPoints(j11);
            n0 n0Var = seekPoints.f78345a;
            n0 n0Var2 = new n0(n0Var.f78353a, n0Var.f78354b + e.this.f14027a);
            n0 n0Var3 = seekPoints.f78346b;
            return new m0.a(n0Var2, new n0(n0Var3.f78353a, n0Var3.f78354b + e.this.f14027a));
        }
    }

    public e(long j11, u uVar) {
        this.f14027a = j11;
        this.f14028b = uVar;
    }

    @Override // u4.u
    public void endTracks() {
        this.f14028b.endTracks();
    }

    @Override // u4.u
    public void f(m0 m0Var) {
        this.f14028b.f(new a(m0Var, m0Var));
    }

    @Override // u4.u
    public r0 track(int i11, int i12) {
        return this.f14028b.track(i11, i12);
    }
}
