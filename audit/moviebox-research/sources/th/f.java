package th;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f77141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77142e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f77145h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f77146i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f77139b = new c0(x.f35652a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f77138a = new c0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77143f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77144g = -1;

    public f(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77140c = jVar;
    }

    public static int d(int i11) {
        return i11 == 5 ? 1 : 0;
    }

    private static long h(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 90000L);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) throws ParserException {
        try {
            int i12 = c0Var.d()[0] & Ascii.US;
            com.google.android.exoplayer2.util.a.i(this.f77141d);
            if (i12 > 0 && i12 < 24) {
                f(c0Var);
            } else if (i12 == 24) {
                g(c0Var);
            } else {
                if (i12 != 28) {
                    throw ParserException.createForMalformedManifest(String.format("RTP H264 packetization mode [%d] not supported.", Integer.valueOf(i12)), null);
                }
                e(c0Var, i11);
            }
            if (z11) {
                if (this.f77143f == C.TIME_UNSET) {
                    this.f77143f = j11;
                }
                this.f77141d.d(h(this.f77146i, j11, this.f77143f), this.f77142e, this.f77145h, 0, null);
                this.f77145h = 0;
            }
            this.f77144g = i11;
        } catch (IndexOutOfBoundsException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 2);
        this.f77141d = e0VarTrack;
        ((e0) o0.j(e0VarTrack)).e(this.f77140c.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
    }

    public final void e(c0 c0Var, int i11) {
        byte b11 = c0Var.d()[0];
        byte b12 = c0Var.d()[1];
        int i12 = (b11 & 224) | (b12 & Ascii.US);
        boolean z11 = (b12 & 128) > 0;
        boolean z12 = (b12 & 64) > 0;
        if (z11) {
            this.f77145h += i();
            c0Var.d()[1] = (byte) i12;
            this.f77138a.M(c0Var.d());
            this.f77138a.P(1);
        } else {
            int iB = com.google.android.exoplayer2.source.rtsp.g.b(this.f77144g);
            if (i11 != iB) {
                s.i("RtpH264Reader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(iB), Integer.valueOf(i11)));
                return;
            } else {
                this.f77138a.M(c0Var.d());
                this.f77138a.P(2);
            }
        }
        int iA = this.f77138a.a();
        this.f77141d.c(this.f77138a, iA);
        this.f77145h += iA;
        if (z12) {
            this.f77142e = d(i12 & 31);
        }
    }

    public final void f(c0 c0Var) {
        int iA = c0Var.a();
        this.f77145h += i();
        this.f77141d.c(c0Var, iA);
        this.f77145h += iA;
        this.f77142e = d(c0Var.d()[0] & Ascii.US);
    }

    public final void g(c0 c0Var) {
        c0Var.D();
        while (c0Var.a() > 4) {
            int iJ = c0Var.J();
            this.f77145h += i();
            this.f77141d.c(c0Var, iJ);
            this.f77145h += iJ;
        }
        this.f77142e = 0;
    }

    public final int i() {
        this.f77139b.P(0);
        int iA = this.f77139b.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f77141d)).c(this.f77139b, iA);
        return iA;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77143f = j11;
        this.f77145h = 0;
        this.f77146i = j12;
    }
}
