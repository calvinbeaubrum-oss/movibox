package com.google.android.exoplayer2.source.rtsp;

import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements tg.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final th.j f34477a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34480d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public tg.n f34483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f34484h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f34487k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f34478b = new com.google.android.exoplayer2.util.c0(65507);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.c0 f34479c = new com.google.android.exoplayer2.util.c0();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f34481e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f34482f = new i();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f34485i = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f34486j = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f34488l = C.TIME_UNSET;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f34489m = C.TIME_UNSET;

    public f(j jVar, int i11) {
        this.f34480d = i11;
        this.f34477a = (th.j) com.google.android.exoplayer2.util.a.e(new th.a().a(jVar));
    }

    public static long a(long j11) {
        return j11 - 30;
    }

    @Override // tg.l
    public boolean b(tg.m mVar) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    @Override // tg.l
    public int c(tg.m mVar, tg.a0 a0Var) throws IOException {
        com.google.android.exoplayer2.util.a.e(this.f34483g);
        int i11 = mVar.read(this.f34478b.d(), 0, 65507);
        if (i11 == -1) {
            return -1;
        }
        if (i11 == 0) {
            return 0;
        }
        this.f34478b.P(0);
        this.f34478b.O(i11);
        g gVarD = g.d(this.f34478b);
        if (gVarD == null) {
            return 0;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jA = a(jElapsedRealtime);
        this.f34482f.e(gVarD, jElapsedRealtime);
        g gVarF = this.f34482f.f(jA);
        if (gVarF == null) {
            return 0;
        }
        if (!this.f34484h) {
            if (this.f34485i == C.TIME_UNSET) {
                this.f34485i = gVarF.f34501h;
            }
            if (this.f34486j == -1) {
                this.f34486j = gVarF.f34500g;
            }
            this.f34477a.c(this.f34485i, this.f34486j);
            this.f34484h = true;
        }
        synchronized (this.f34481e) {
            try {
                if (!this.f34487k) {
                    do {
                        this.f34479c.M(gVarF.f34504k);
                        this.f34477a.a(this.f34479c, gVarF.f34501h, gVarF.f34500g, gVarF.f34498e);
                        gVarF = this.f34482f.f(jA);
                    } while (gVarF != null);
                } else if (this.f34488l != C.TIME_UNSET && this.f34489m != C.TIME_UNSET) {
                    this.f34482f.g();
                    this.f34477a.seek(this.f34488l, this.f34489m);
                    this.f34487k = false;
                    this.f34488l = C.TIME_UNSET;
                    this.f34489m = C.TIME_UNSET;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return 0;
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f34477a.b(nVar, this.f34480d);
        nVar.endTracks();
        nVar.g(new tg.b0.b(C.TIME_UNSET));
        this.f34483g = nVar;
    }

    public boolean e() {
        return this.f34484h;
    }

    public void f() {
        synchronized (this.f34481e) {
            this.f34487k = true;
        }
    }

    public void g(int i11) {
        this.f34486j = i11;
    }

    public void h(long j11) {
        this.f34485i = j11;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        synchronized (this.f34481e) {
            this.f34488l = j11;
            this.f34489m = j12;
        }
    }
}
