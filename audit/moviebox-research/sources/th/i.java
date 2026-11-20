package th;

import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import java.util.List;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f77164b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f77166d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f77168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f77169g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f77165c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f77167e = -1;

    public i(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77163a = jVar;
    }

    public static long d(long j11, long j12, long j13) {
        return j11 + o0.O0(j12 - j13, 1000000L, 48000L);
    }

    public static void e(c0 c0Var) {
        int iE = c0Var.e();
        com.google.android.exoplayer2.util.a.b(c0Var.f() > 18, "ID Header has insufficient data");
        com.google.android.exoplayer2.util.a.b(c0Var.A(8).equals("OpusHead"), "ID Header missing");
        com.google.android.exoplayer2.util.a.b(c0Var.D() == 1, "version number must always be 1");
        c0Var.P(iE);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        com.google.android.exoplayer2.util.a.i(this.f77164b);
        if (this.f77168f) {
            if (this.f77169g) {
                int iB = com.google.android.exoplayer2.source.rtsp.g.b(this.f77167e);
                if (i11 != iB) {
                    s.i("RtpOpusReader", o0.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(iB), Integer.valueOf(i11)));
                }
                int iA = c0Var.a();
                this.f77164b.c(c0Var, iA);
                this.f77164b.d(d(this.f77166d, j11, this.f77165c), 1, iA, 0, null);
            } else {
                com.google.android.exoplayer2.util.a.b(c0Var.f() >= 8, "Comment Header has insufficient data");
                com.google.android.exoplayer2.util.a.b(c0Var.A(8).equals("OpusTags"), "Comment Header should follow ID Header");
                this.f77169g = true;
            }
        } else {
            e(c0Var);
            List<byte[]> listA = com.google.android.exoplayer2.audio.c0.a(c0Var.d());
            m1.b bVarB = this.f77163a.f34552c.b();
            bVarB.T(listA);
            this.f77164b.e(bVarB.E());
            this.f77168f = true;
        }
        this.f77167e = i11;
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 1);
        this.f77164b = e0VarTrack;
        e0VarTrack.e(this.f77163a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
        this.f77165c = j11;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77165c = j11;
        this.f77166d = j12;
    }
}
