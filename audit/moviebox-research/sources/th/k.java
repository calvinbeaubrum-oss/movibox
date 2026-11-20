package th;

import android.util.Log;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f77171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77172c = C.TIME_UNSET;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77173d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77174e = -1;

    public k(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77170a = jVar;
    }

    public static long d(long j11, long j12, long j13, int i11) {
        return j11 + o0.O0(j12 - j13, 1000000L, i11);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        int iB;
        com.google.android.exoplayer2.util.a.e(this.f77171b);
        int i12 = this.f77174e;
        if (i12 != -1 && i11 != (iB = com.google.android.exoplayer2.source.rtsp.g.b(i12))) {
            Log.w("RtpPcmReader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i11)));
        }
        long jD = d(this.f77173d, j11, this.f77172c, this.f77170a.f34551b);
        int iA = c0Var.a();
        this.f77171b.c(c0Var, iA);
        this.f77171b.d(jD, 1, iA, 0, null);
        this.f77174e = i11;
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 1);
        this.f77171b = e0VarTrack;
        e0VarTrack.e(this.f77170a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
        this.f77172c = j11;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77172c = j11;
        this.f77173d = j12;
    }
}
