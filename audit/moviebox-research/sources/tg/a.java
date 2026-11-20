package tg;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0852a f76967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f76968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public c f76969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f76970d;

    /* JADX INFO: renamed from: tg.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0852a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f76971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f76972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f76973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f76974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f76975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f76976f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f76977g;

        public C0852a(d dVar, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f76971a = dVar;
            this.f76972b = j11;
            this.f76973c = j12;
            this.f76974d = j13;
            this.f76975e = j14;
            this.f76976f = j15;
            this.f76977g = j16;
        }

        public long g(long j11) {
            return this.f76971a.a(j11);
        }

        @Override // tg.b0
        public long getDurationUs() {
            return this.f76972b;
        }

        @Override // tg.b0
        public b0.a getSeekPoints(long j11) {
            return new b0.a(new c0(j11, c.h(this.f76971a.a(j11), this.f76973c, this.f76974d, this.f76975e, this.f76976f, this.f76977g)));
        }

        @Override // tg.b0
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements d {
        @Override // tg.a.d
        public long a(long j11) {
            return j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f76978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f76979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f76980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f76981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f76982e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f76983f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f76984g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f76985h;

        public c(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
            this.f76978a = j11;
            this.f76979b = j12;
            this.f76981d = j13;
            this.f76982e = j14;
            this.f76983f = j15;
            this.f76984g = j16;
            this.f76980c = j17;
            this.f76985h = h(j12, j13, j14, j15, j16, j17);
        }

        public static long h(long j11, long j12, long j13, long j14, long j15, long j16) {
            if (j14 + 1 >= j15 || j12 + 1 >= j13) {
                return j14;
            }
            long j17 = (long) ((j11 - j12) * ((j15 - j14) / (j13 - j12)));
            return o0.r(((j17 + j14) - j16) - (j17 / 20), j14, j15 - 1);
        }

        public final long i() {
            return this.f76984g;
        }

        public final long j() {
            return this.f76983f;
        }

        public final long k() {
            return this.f76985h;
        }

        public final long l() {
            return this.f76978a;
        }

        public final long m() {
            return this.f76979b;
        }

        public final void n() {
            this.f76985h = h(this.f76979b, this.f76981d, this.f76982e, this.f76983f, this.f76984g, this.f76980c);
        }

        public final void o(long j11, long j12) {
            this.f76982e = j11;
            this.f76984g = j12;
            n();
        }

        public final void p(long j11, long j12) {
            this.f76981d = j11;
            this.f76983f = j12;
            n();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        long a(long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f76986d = new e(-3, C.TIME_UNSET, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f76987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f76988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f76989c;

        public e(int i11, long j11, long j12) {
            this.f76987a = i11;
            this.f76988b = j11;
            this.f76989c = j12;
        }

        public static e d(long j11, long j12) {
            return new e(-1, j11, j12);
        }

        public static e e(long j11) {
            return new e(0, C.TIME_UNSET, j11);
        }

        public static e f(long j11, long j12) {
            return new e(-2, j11, j12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a();

        e b(m mVar, long j11) throws IOException;
    }

    public a(d dVar, f fVar, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.f76968b = fVar;
        this.f76970d = i11;
        this.f76967a = new C0852a(dVar, j11, j12, j13, j14, j15, j16);
    }

    public c a(long j11) {
        return new c(j11, this.f76967a.g(j11), this.f76967a.f76973c, this.f76967a.f76974d, this.f76967a.f76975e, this.f76967a.f76976f, this.f76967a.f76977g);
    }

    public final b0 b() {
        return this.f76967a;
    }

    public int c(m mVar, a0 a0Var) throws IOException {
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.util.a.i(this.f76969c);
            long j11 = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j11 <= this.f76970d) {
                e(false, j11);
                return g(mVar, j11, a0Var);
            }
            if (!i(mVar, jK)) {
                return g(mVar, jK, a0Var);
            }
            mVar.resetPeekPosition();
            e eVarB = this.f76968b.b(mVar, cVar.m());
            int i11 = eVarB.f76987a;
            if (i11 == -3) {
                e(false, jK);
                return g(mVar, jK, a0Var);
            }
            if (i11 == -2) {
                cVar.p(eVarB.f76988b, eVarB.f76989c);
            } else {
                if (i11 != -1) {
                    if (i11 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(mVar, eVarB.f76989c);
                    e(true, eVarB.f76989c);
                    return g(mVar, eVarB.f76989c, a0Var);
                }
                cVar.o(eVarB.f76988b, eVarB.f76989c);
            }
        }
    }

    public final boolean d() {
        return this.f76969c != null;
    }

    public final void e(boolean z11, long j11) {
        this.f76969c = null;
        this.f76968b.a();
        f(z11, j11);
    }

    public void f(boolean z11, long j11) {
    }

    public final int g(m mVar, long j11, a0 a0Var) {
        if (j11 == mVar.getPosition()) {
            return 0;
        }
        a0Var.f76990a = j11;
        return 1;
    }

    public final void h(long j11) {
        c cVar = this.f76969c;
        if (cVar == null || cVar.l() != j11) {
            this.f76969c = a(j11);
        }
    }

    public final boolean i(m mVar, long j11) throws IOException {
        long position = j11 - mVar.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        mVar.skipFully((int) position);
        return true;
    }
}
