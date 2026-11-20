package th;

import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f77119h = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f77120i = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f77122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f77124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f77125e = C.TIME_UNSET;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f77127g = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f77126f = 0;

    public d(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77121a = jVar;
        this.f77122b = MimeTypes.AUDIO_AMR_WB.equals(com.google.android.exoplayer2.util.a.e(jVar.f34552c.f33445m));
        this.f77123c = jVar.f34551b;
    }

    public static int d(int i11, boolean z11) {
        boolean z12 = (i11 >= 0 && i11 <= 8) || i11 == 15;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Illegal AMR ");
        sb2.append(z11 ? "WB" : "NB");
        sb2.append(" frame type ");
        sb2.append(i11);
        com.google.android.exoplayer2.util.a.b(z12, sb2.toString());
        return z11 ? f77120i[i11] : f77119h[i11];
    }

    private static long e(long j11, long j12, long j13, int i11) {
        return j11 + o0.O0(j12 - j13, 1000000L, i11);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        int iB;
        com.google.android.exoplayer2.util.a.i(this.f77124d);
        int i12 = this.f77127g;
        if (i12 != -1 && i11 != (iB = com.google.android.exoplayer2.source.rtsp.g.b(i12))) {
            s.i("RtpAmrReader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i11)));
        }
        c0Var.Q(1);
        int iD = d((c0Var.h() >> 3) & 15, this.f77122b);
        int iA = c0Var.a();
        com.google.android.exoplayer2.util.a.b(iA == iD, "compound payload not supported currently");
        this.f77124d.c(c0Var, iA);
        this.f77124d.d(e(this.f77126f, j11, this.f77125e, this.f77123c), 1, iA, 0, null);
        this.f77127g = i11;
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 1);
        this.f77124d = e0VarTrack;
        e0VarTrack.e(this.f77121a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
        this.f77125e = j11;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77125e = j11;
        this.f77126f = j12;
    }
}
