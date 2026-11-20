package th;

import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f77157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f77158c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77161f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77159d = C.TIME_UNSET;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77160e = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77162g = 0;

    public h(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77156a = jVar;
    }

    public static int d(c0 c0Var) {
        int iA = com.google.common.primitives.a.a(c0Var.d(), new byte[]{0, 0, 1, -74});
        if (iA == -1) {
            return 0;
        }
        c0Var.P(iA + 4);
        return (c0Var.h() >> 6) == 0 ? 1 : 0;
    }

    private static long e(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 90000L);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        int iB;
        com.google.android.exoplayer2.util.a.i(this.f77157b);
        int i12 = this.f77160e;
        if (i12 != -1 && i11 != (iB = com.google.android.exoplayer2.source.rtsp.g.b(i12))) {
            s.i("RtpMpeg4Reader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i11)));
        }
        int iA = c0Var.a();
        this.f77157b.c(c0Var, iA);
        if (this.f77162g == 0) {
            this.f77158c = d(c0Var);
        }
        this.f77162g += iA;
        if (z11) {
            if (this.f77159d == C.TIME_UNSET) {
                this.f77159d = j11;
            }
            this.f77157b.d(e(this.f77161f, j11, this.f77159d), this.f77158c, this.f77162g, 0, null);
            this.f77162g = 0;
        }
        this.f77160e = i11;
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 2);
        this.f77157b = e0VarTrack;
        ((e0) o0.j(e0VarTrack)).e(this.f77156a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77159d = j11;
        this.f77161f = j12;
        this.f77162g = 0;
    }
}
