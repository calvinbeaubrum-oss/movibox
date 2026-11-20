package androidx.media3.exoplayer.video;

import androidx.media3.common.t0;
import androidx.media3.exoplayer.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import z3.h0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f11733b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11739h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f11734c = new p.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0<t0> f11735d = new h0<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h0<Long> f11736e = new h0<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z3.q f11737f = new z3.q();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t0 f11738g = t0.f9443e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11740i = C.TIME_UNSET;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void b();

        void h(long j11, long j12, long j13, boolean z11);

        void onVideoSizeChanged(t0 t0Var);
    }

    public t(a aVar, p pVar) {
        this.f11732a = aVar;
        this.f11733b = pVar;
    }

    public final void a() {
        z3.a.i(Long.valueOf(this.f11737f.c()));
        this.f11732a.b();
    }

    public boolean b(long j11) {
        long j12 = this.f11740i;
        return j12 != C.TIME_UNSET && j12 >= j11;
    }

    public boolean c() {
        return this.f11733b.d(true);
    }

    public final boolean d(long j11) {
        Long lJ = this.f11736e.j(j11);
        if (lJ == null || lJ.longValue() == this.f11739h) {
            return false;
        }
        this.f11739h = lJ.longValue();
        return true;
    }

    public final boolean e(long j11) {
        t0 t0VarJ = this.f11735d.j(j11);
        if (t0VarJ == null || t0VarJ.equals(t0.f9443e) || t0VarJ.equals(this.f11738g)) {
            return false;
        }
        this.f11738g = t0VarJ;
        return true;
    }

    public void f(long j11, long j12) throws ExoPlaybackException {
        while (!this.f11737f.b()) {
            long jA = this.f11737f.a();
            if (d(jA)) {
                this.f11733b.j();
            }
            int iC = this.f11733b.c(jA, j11, j12, this.f11739h, false, this.f11734c);
            if (iC == 0 || iC == 1) {
                this.f11740i = jA;
                g(iC == 0);
            } else if (iC != 2 && iC != 3 && iC != 4) {
                if (iC != 5) {
                    throw new IllegalStateException(String.valueOf(iC));
                }
                return;
            } else {
                this.f11740i = jA;
                a();
            }
        }
    }

    public final void g(boolean z11) {
        long jLongValue = ((Long) z3.a.i(Long.valueOf(this.f11737f.c()))).longValue();
        if (e(jLongValue)) {
            this.f11732a.onVideoSizeChanged(this.f11738g);
        }
        this.f11732a.h(z11 ? -1L : this.f11734c.g(), jLongValue, this.f11739h, this.f11733b.i());
    }

    public void h(float f11) {
        z3.a.a(f11 > 0.0f);
        this.f11733b.r(f11);
    }
}
