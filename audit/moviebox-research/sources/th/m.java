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
public final class m implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f77186b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f77190f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77187c = C.TIME_UNSET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77188d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77189e = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77191g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f77192h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f77193i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f77194j = false;

    public m(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77185a = jVar;
    }

    private static long d(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 90000L);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        int i12;
        int i13;
        com.google.android.exoplayer2.util.a.i(this.f77186b);
        if (e(c0Var, i11)) {
            int i14 = (this.f77190f == 0 && this.f77193i && (c0Var.h() & 4) == 0) ? 1 : 0;
            if (!this.f77194j && (i12 = this.f77191g) != -1 && (i13 = this.f77192h) != -1) {
                m1 m1Var = this.f77185a.f34552c;
                if (i12 != m1Var.f33450r || i13 != m1Var.f33451s) {
                    this.f77186b.e(m1Var.b().j0(this.f77191g).Q(this.f77192h).E());
                }
                this.f77194j = true;
            }
            int iA = c0Var.a();
            this.f77186b.c(c0Var, iA);
            this.f77190f += iA;
            if (z11) {
                if (this.f77187c == C.TIME_UNSET) {
                    this.f77187c = j11;
                }
                this.f77186b.d(d(this.f77188d, j11, this.f77187c), i14, this.f77190f, 0, null);
                this.f77190f = 0;
                this.f77193i = false;
            }
            this.f77189e = i11;
        }
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 2);
        this.f77186b = e0VarTrack;
        e0VarTrack.e(this.f77185a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
    }

    public final boolean e(c0 c0Var, int i11) {
        int iD = c0Var.D();
        if (this.f77193i) {
            int iB = com.google.android.exoplayer2.source.rtsp.g.b(this.f77189e);
            if (i11 != iB) {
                s.i("RtpVp9Reader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i11)));
                return false;
            }
        } else {
            if ((iD & 8) == 0) {
                s.i("RtpVp9Reader", "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
                return false;
            }
            this.f77193i = true;
        }
        if ((iD & 128) != 0 && (c0Var.D() & 128) != 0 && c0Var.a() < 1) {
            return false;
        }
        int i12 = iD & 16;
        com.google.android.exoplayer2.util.a.b(i12 == 0, "VP9 flexible mode is not supported.");
        if ((iD & 32) != 0) {
            c0Var.Q(1);
            if (c0Var.a() < 1) {
                return false;
            }
            if (i12 == 0) {
                c0Var.Q(1);
            }
        }
        if ((iD & 2) != 0) {
            int iD2 = c0Var.D();
            int i13 = (iD2 >> 5) & 7;
            if ((iD2 & 16) != 0) {
                int i14 = i13 + 1;
                if (c0Var.a() < i14 * 4) {
                    return false;
                }
                for (int i15 = 0; i15 < i14; i15++) {
                    this.f77191g = c0Var.J();
                    this.f77192h = c0Var.J();
                }
            }
            if ((iD2 & 8) != 0) {
                int iD3 = c0Var.D();
                if (c0Var.a() < iD3) {
                    return false;
                }
                for (int i16 = 0; i16 < iD3; i16++) {
                    int iJ = (c0Var.J() & 12) >> 2;
                    if (c0Var.a() < iJ) {
                        return false;
                    }
                    c0Var.Q(iJ);
                }
            }
        }
        return true;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77187c = j11;
        this.f77190f = 0;
        this.f77188d = j12;
    }
}
