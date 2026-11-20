package th;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import okhttp3.internal.http2.Settings;
import okio.Utf8;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f77150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77151e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f77154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f77155i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f77147a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f77148b = new c0(x.f35652a);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77152f = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77153g = -1;

    public g(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77149c = jVar;
    }

    private static int d(int i11) {
        return (i11 == 19 || i11 == 20) ? 1 : 0;
    }

    private void e(c0 c0Var, int i11) throws ParserException {
        if (c0Var.d().length < 3) {
            throw ParserException.createForMalformedManifest("Malformed FU header.", null);
        }
        int i12 = c0Var.d()[1] & 7;
        byte b11 = c0Var.d()[2];
        int i13 = b11 & Utf8.REPLACEMENT_BYTE;
        boolean z11 = (b11 & 128) > 0;
        boolean z12 = (b11 & 64) > 0;
        if (z11) {
            this.f77154h += h();
            c0Var.d()[1] = (byte) ((i13 << 1) & 127);
            c0Var.d()[2] = (byte) i12;
            this.f77147a.M(c0Var.d());
            this.f77147a.P(1);
        } else {
            int i14 = (this.f77153g + 1) % Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            if (i11 != i14) {
                s.i("RtpH265Reader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", Integer.valueOf(i14), Integer.valueOf(i11)));
                return;
            } else {
                this.f77147a.M(c0Var.d());
                this.f77147a.P(3);
            }
        }
        int iA = this.f77147a.a();
        this.f77150d.c(this.f77147a, iA);
        this.f77154h += iA;
        if (z12) {
            this.f77151e = d(i13);
        }
    }

    private void f(c0 c0Var) {
        int iA = c0Var.a();
        this.f77154h += h();
        this.f77150d.c(c0Var, iA);
        this.f77154h += iA;
        this.f77151e = d((c0Var.d()[0] >> 1) & 63);
    }

    private static long g(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 90000L);
    }

    private int h() {
        this.f77148b.P(0);
        int iA = this.f77148b.a();
        ((e0) com.google.android.exoplayer2.util.a.e(this.f77150d)).c(this.f77148b, iA);
        return iA;
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) throws ParserException {
        if (c0Var.d().length == 0) {
            throw ParserException.createForMalformedManifest("Empty RTP data packet.", null);
        }
        int i12 = (c0Var.d()[0] >> 1) & 63;
        com.google.android.exoplayer2.util.a.i(this.f77150d);
        if (i12 >= 0 && i12 < 48) {
            f(c0Var);
        } else {
            if (i12 == 48) {
                throw new UnsupportedOperationException("need to implement processAggregationPacket");
            }
            if (i12 != 49) {
                throw ParserException.createForMalformedManifest(String.format("RTP H265 payload type [%d] not supported.", Integer.valueOf(i12)), null);
            }
            e(c0Var, i11);
        }
        if (z11) {
            if (this.f77152f == C.TIME_UNSET) {
                this.f77152f = j11;
            }
            this.f77150d.d(g(this.f77155i, j11, this.f77152f), this.f77151e, this.f77154h, 0, null);
            this.f77154h = 0;
        }
        this.f77153g = i11;
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 2);
        this.f77150d = e0VarTrack;
        e0VarTrack.e(this.f77149c.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77152f = j11;
        this.f77154h = 0;
        this.f77155i = j12;
    }
}
