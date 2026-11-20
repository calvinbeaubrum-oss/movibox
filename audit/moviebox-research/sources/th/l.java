package th;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f77176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77177c = C.TIME_UNSET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f77178d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77179e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77180f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f77181g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f77182h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f77183i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f77184j = false;

    public l(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77175a = jVar;
    }

    private void d() {
        e0 e0Var = (e0) com.google.android.exoplayer2.util.a.e(this.f77176b);
        long j11 = this.f77180f;
        boolean z11 = this.f77183i;
        e0Var.d(j11, z11 ? 1 : 0, this.f77179e, 0, null);
        this.f77179e = 0;
        this.f77180f = C.TIME_UNSET;
        this.f77182h = false;
    }

    private static long e(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 90000L);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f77176b);
        if (f(c0Var, i11)) {
            if (this.f77179e == -1 && this.f77182h) {
                this.f77183i = (c0Var.h() & 1) == 0;
            }
            if (!this.f77184j) {
                int iE = c0Var.e();
                c0Var.P(iE + 6);
                int iV = c0Var.v() & 16383;
                int iV2 = c0Var.v() & 16383;
                c0Var.P(iE);
                m1 m1Var = this.f77175a.f34552c;
                if (iV != m1Var.f33450r || iV2 != m1Var.f33451s) {
                    this.f77176b.e(m1Var.b().j0(iV).Q(iV2).E());
                }
                this.f77184j = true;
            }
            int iA = c0Var.a();
            this.f77176b.c(c0Var, iA);
            int i12 = this.f77179e;
            if (i12 == -1) {
                this.f77179e = iA;
            } else {
                this.f77179e = i12 + iA;
            }
            this.f77180f = e(this.f77181g, j11, this.f77177c);
            if (z11) {
                d();
            }
            this.f77178d = i11;
        }
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 2);
        this.f77176b = e0VarTrack;
        e0VarTrack.e(this.f77175a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
        com.google.android.exoplayer2.util.a.g(this.f77177c == C.TIME_UNSET);
        this.f77177c = j11;
    }

    public final boolean f(c0 c0Var, int i11) {
        int iD = c0Var.D();
        if ((iD & 16) == 16 && (iD & 7) == 0) {
            if (this.f77182h && this.f77179e > 0) {
                d();
            }
            this.f77182h = true;
        } else {
            if (!this.f77182h) {
                s.i("RtpVP8Reader", "RTP packet is not the start of a new VP8 partition, skipping.");
                return false;
            }
            int iB = com.google.android.exoplayer2.source.rtsp.g.b(this.f77178d);
            if (i11 < iB) {
                s.i("RtpVP8Reader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i11)));
                return false;
            }
        }
        if ((iD & 128) != 0) {
            int iD2 = c0Var.D();
            if ((iD2 & 128) != 0 && (c0Var.D() & 128) != 0) {
                c0Var.Q(1);
            }
            if ((iD2 & 64) != 0) {
                c0Var.Q(1);
            }
            if ((iD2 & 32) != 0 || (iD2 & 16) != 0) {
                c0Var.Q(1);
            }
        }
        return true;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77177c = j11;
        this.f77179e = -1;
        this.f77181g = j12;
    }
}
