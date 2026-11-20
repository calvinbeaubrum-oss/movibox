package th;

import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import tg.e0;
import tg.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.j f77103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f77104b = new b0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f77106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f77107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f77108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f77109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e0 f77110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f77111i;

    public b(com.google.android.exoplayer2.source.rtsp.j jVar) {
        this.f77103a = jVar;
        this.f77105c = jVar.f34551b;
        String str = (String) com.google.android.exoplayer2.util.a.e(jVar.f34553d.get("mode"));
        if (com.google.common.base.a.a(str, "AAC-hbr")) {
            this.f77106d = 13;
            this.f77107e = 3;
        } else {
            if (!com.google.common.base.a.a(str, "AAC-lbr")) {
                throw new UnsupportedOperationException("AAC mode not supported");
            }
            this.f77106d = 6;
            this.f77107e = 2;
        }
        this.f77108f = this.f77107e + this.f77106d;
    }

    public static void d(e0 e0Var, long j11, int i11) {
        e0Var.d(j11, 1, i11, 0, null);
    }

    public static long e(long j11, long j12, long j13, int i11) {
        return j11 + o0.O0(j12 - j13, 1000000L, i11);
    }

    @Override // th.j
    public void a(c0 c0Var, long j11, int i11, boolean z11) {
        com.google.android.exoplayer2.util.a.e(this.f77110h);
        short sZ = c0Var.z();
        int i12 = sZ / this.f77108f;
        long jE = e(this.f77111i, j11, this.f77109g, this.f77105c);
        this.f77104b.m(c0Var);
        if (i12 == 1) {
            int iH = this.f77104b.h(this.f77106d);
            this.f77104b.r(this.f77107e);
            this.f77110h.c(c0Var, c0Var.a());
            if (z11) {
                d(this.f77110h, jE, iH);
                return;
            }
            return;
        }
        c0Var.Q((sZ + 7) / 8);
        for (int i13 = 0; i13 < i12; i13++) {
            int iH2 = this.f77104b.h(this.f77106d);
            this.f77104b.r(this.f77107e);
            this.f77110h.c(c0Var, iH2);
            d(this.f77110h, jE, iH2);
            jE += o0.O0(i12, 1000000L, this.f77105c);
        }
    }

    @Override // th.j
    public void b(n nVar, int i11) {
        e0 e0VarTrack = nVar.track(i11, 1);
        this.f77110h = e0VarTrack;
        e0VarTrack.e(this.f77103a.f34552c);
    }

    @Override // th.j
    public void c(long j11, int i11) {
        this.f77109g = j11;
    }

    @Override // th.j
    public void seek(long j11, long j12) {
        this.f77109g = j11;
        this.f77111i = j12;
    }
}
