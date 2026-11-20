package androidx.media3.exoplayer.video;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f11656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11658d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11661g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11659e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f11660f = C.TIME_UNSET;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11662h = C.TIME_UNSET;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11663i = C.TIME_UNSET;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11664j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z3.d f11665k = z3.d.f81767a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11666a = C.TIME_UNSET;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11667b = C.TIME_UNSET;

        public long f() {
            return this.f11666a;
        }

        public long g() {
            return this.f11667b;
        }

        public final void h() {
            this.f11666a = C.TIME_UNSET;
            this.f11667b = C.TIME_UNSET;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean j(long j11, long j12);

        boolean k(long j11, long j12, long j13, boolean z11, boolean z12) throws ExoPlaybackException;

        boolean o(long j11, long j12, boolean z11);
    }

    public p(Context context, b bVar, long j11) {
        this.f11655a = bVar;
        this.f11657c = j11;
        this.f11656b = new r(context);
    }

    public void a() {
        if (this.f11659e == 0) {
            this.f11659e = 1;
        }
    }

    public final long b(long j11, long j12, long j13) {
        long j14 = (long) ((j13 - j11) / ((double) this.f11664j));
        return this.f11658d ? j14 - (u0.S0(this.f11665k.elapsedRealtime()) - j12) : j14;
    }

    public int c(long j11, long j12, long j13, long j14, boolean z11, a aVar) throws ExoPlaybackException {
        aVar.h();
        if (this.f11660f == C.TIME_UNSET) {
            this.f11660f = j12;
        }
        if (this.f11662h != j11) {
            this.f11656b.h(j11);
            this.f11662h = j11;
        }
        aVar.f11666a = b(j12, j13, j11);
        if (s(j12, aVar.f11666a, j14)) {
            return 0;
        }
        if (!this.f11658d || j12 == this.f11660f) {
            return 5;
        }
        long jNanoTime = this.f11665k.nanoTime();
        aVar.f11667b = this.f11656b.b((aVar.f11666a * 1000) + jNanoTime);
        aVar.f11666a = (aVar.f11667b - jNanoTime) / 1000;
        boolean z12 = this.f11663i != C.TIME_UNSET;
        if (this.f11655a.k(aVar.f11666a, j12, j13, z11, z12)) {
            return 4;
        }
        if (this.f11655a.o(aVar.f11666a, j13, z11)) {
            return z12 ? 3 : 2;
        }
        return aVar.f11666a > 50000 ? 5 : 1;
    }

    public boolean d(boolean z11) {
        if (z11 && this.f11659e == 3) {
            this.f11663i = C.TIME_UNSET;
            return true;
        }
        if (this.f11663i == C.TIME_UNSET) {
            return false;
        }
        if (this.f11665k.elapsedRealtime() < this.f11663i) {
            return true;
        }
        this.f11663i = C.TIME_UNSET;
        return false;
    }

    public void e() {
        this.f11663i = this.f11657c > 0 ? this.f11665k.elapsedRealtime() + this.f11657c : C.TIME_UNSET;
    }

    public final void f(int i11) {
        this.f11659e = Math.min(this.f11659e, i11);
    }

    public void g() {
        f(0);
    }

    public void h(boolean z11) {
        this.f11659e = z11 ? 1 : 0;
    }

    public boolean i() {
        boolean z11 = this.f11659e != 3;
        this.f11659e = 3;
        this.f11661g = u0.S0(this.f11665k.elapsedRealtime());
        return z11;
    }

    public void j() {
        f(2);
    }

    public void k() {
        this.f11658d = true;
        this.f11661g = u0.S0(this.f11665k.elapsedRealtime());
        this.f11656b.k();
    }

    public void l() {
        this.f11658d = false;
        this.f11663i = C.TIME_UNSET;
        this.f11656b.l();
    }

    public void m() {
        this.f11656b.j();
        this.f11662h = C.TIME_UNSET;
        this.f11660f = C.TIME_UNSET;
        f(1);
        this.f11663i = C.TIME_UNSET;
    }

    public void n(int i11) {
        this.f11656b.o(i11);
    }

    public void o(z3.d dVar) {
        this.f11665k = dVar;
    }

    public void p(float f11) {
        this.f11656b.g(f11);
    }

    public void q(@Nullable Surface surface) {
        this.f11656b.m(surface);
        f(1);
    }

    public void r(float f11) {
        this.f11664j = f11;
        this.f11656b.i(f11);
    }

    public final boolean s(long j11, long j12, long j13) {
        if (this.f11663i != C.TIME_UNSET) {
            return false;
        }
        int i11 = this.f11659e;
        if (i11 == 0) {
            return this.f11658d;
        }
        if (i11 == 1) {
            return true;
        }
        if (i11 == 2) {
            return j11 >= j13;
        }
        if (i11 == 3) {
            return this.f11658d && this.f11655a.j(j12, u0.S0(this.f11665k.elapsedRealtime()) - this.f11661g);
        }
        throw new IllegalStateException();
    }
}
