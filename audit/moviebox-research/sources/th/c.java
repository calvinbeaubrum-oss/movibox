package th;

import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77112a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f77114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f77115d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f77118g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f77113b = new b0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f77116e = C.TIME_UNSET;

    public c(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77112a = jVar;
    }

    private static long i(long j11, long j12, long j13, int i11) {
        return j11 + o0.O0(j12 - j13, 1000000L, i11);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        int iD = c0Var.D() & 3;
        int iD2 = c0Var.D() & 255;
        long jI = i(this.f77118g, j11, this.f77116e, this.f77112a.f34551b);
        if (iD == 0) {
            d();
            if (iD2 == 1) {
                h(c0Var, jI);
                return;
            } else {
                g(c0Var, iD2, jI);
                return;
            }
        }
        if (iD == 1 || iD == 2) {
            d();
        } else if (iD != 3) {
            throw new IllegalArgumentException(String.valueOf(iD));
        }
        f(c0Var, z11, iD, jI);
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 1);
        this.f77114c = e0VarTrack;
        e0VarTrack.e(this.f77112a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
        com.google.android.exoplayer2.util.a.g(this.f77116e == C.TIME_UNSET);
        this.f77116e = j11;
    }

    public final void d() {
        if (this.f77115d > 0) {
            e();
        }
    }

    public final void e() {
        ((e0) o0.j(this.f77114c)).d(this.f77117f, 1, this.f77115d, 0, null);
        this.f77115d = 0;
    }

    public final void f(c0 c0Var, boolean z11, int i11, long j11) {
        int iA = c0Var.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f77114c)).c(c0Var, iA);
        this.f77115d += iA;
        this.f77117f = j11;
        if (z11 && i11 == 3) {
            e();
        }
    }

    public final void g(c0 c0Var, int i11, long j11) {
        this.f77113b.n(c0Var.d());
        this.f77113b.s(2);
        for (int i12 = 0; i12 < i11; i12++) {
            com.google.android.exoplayer2.audio.b.C0358b c0358bE = com.google.android.exoplayer2.audio.b.e(this.f77113b);
            ((e0) com.google.android.exoplayer2.util.a.e(this.f77114c)).c(c0Var, c0358bE.f32784e);
            ((e0) o0.j(this.f77114c)).d(j11, 1, c0358bE.f32784e, 0, null);
            j11 += ((long) (c0358bE.f32785f / c0358bE.f32782c)) * 1000000;
            this.f77113b.s(c0358bE.f32784e);
        }
    }

    public final void h(c0 c0Var, long j11) {
        int iA = c0Var.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f77114c)).c(c0Var, iA);
        ((e0) o0.j(this.f77114c)).d(j11, 1, iA, 0, null);
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77116e = j11;
        this.f77118g = j12;
    }
}
