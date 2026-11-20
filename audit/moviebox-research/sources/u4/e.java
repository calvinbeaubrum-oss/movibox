package u4;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f78245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f78246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public c f78247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f78248d;

    /* JADX INFO: compiled from: source.java */
    public static class a implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f78249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f78250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f78251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f78252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f78253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f78254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f78255g;

        public a(d dVar, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f78249a = dVar;
            this.f78250b = j11;
            this.f78251c = j12;
            this.f78252d = j13;
            this.f78253e = j14;
            this.f78254f = j15;
            this.f78255g = j16;
        }

        @Override // u4.m0
        public long getDurationUs() {
            return this.f78250b;
        }

        @Override // u4.m0
        public m0.a getSeekPoints(long j11) {
            return new m0.a(new n0(j11, c.h(this.f78249a.a(j11), this.f78251c, this.f78252d, this.f78253e, this.f78254f, this.f78255g)));
        }

        public long h(long j11) {
            return this.f78249a.a(j11);
        }

        @Override // u4.m0
        public boolean isSeekable() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements d {
        @Override // u4.e.d
        public long a(long j11) {
            return j11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f78256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f78257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f78258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f78259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f78260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f78261f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f78262g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f78263h;

        public c(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
            this.f78256a = j11;
            this.f78257b = j12;
            this.f78259d = j13;
            this.f78260e = j14;
            this.f78261f = j15;
            this.f78262g = j16;
            this.f78258c = j17;
            this.f78263h = h(j12, j13, j14, j15, j16, j17);
        }

        public static long h(long j11, long j12, long j13, long j14, long j15, long j16) {
            if (j14 + 1 >= j15 || j12 + 1 >= j13) {
                return j14;
            }
            long j17 = (long) ((j11 - j12) * ((j15 - j14) / (j13 - j12)));
            return z3.u0.q(((j17 + j14) - j16) - (j17 / 20), j14, j15 - 1);
        }

        public final long i() {
            return this.f78262g;
        }

        public final long j() {
            return this.f78261f;
        }

        public final long k() {
            return this.f78263h;
        }

        public final long l() {
            return this.f78256a;
        }

        public final long m() {
            return this.f78257b;
        }

        public final void n() {
            this.f78263h = h(this.f78257b, this.f78259d, this.f78260e, this.f78261f, this.f78262g, this.f78258c);
        }

        public final void o(long j11, long j12) {
            this.f78260e = j11;
            this.f78262g = j12;
            n();
        }

        public final void p(long j11, long j12) {
            this.f78259d = j11;
            this.f78261f = j12;
            n();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        long a(long j11);
    }

    /* JADX INFO: renamed from: u4.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0862e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0862e f78264d = new C0862e(-3, C.TIME_UNSET, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f78265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f78266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f78267c;

        public C0862e(int i11, long j11, long j12) {
            this.f78265a = i11;
            this.f78266b = j11;
            this.f78267c = j12;
        }

        public static C0862e d(long j11, long j12) {
            return new C0862e(-1, j11, j12);
        }

        public static C0862e e(long j11) {
            return new C0862e(0, C.TIME_UNSET, j11);
        }

        public static C0862e f(long j11, long j12) {
            return new C0862e(-2, j11, j12);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a();

        C0862e b(t tVar, long j11) throws IOException;
    }

    public e(d dVar, f fVar, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.f78246b = fVar;
        this.f78248d = i11;
        this.f78245a = new a(dVar, j11, j12, j13, j14, j15, j16);
    }

    public c a(long j11) {
        return new c(j11, this.f78245a.h(j11), this.f78245a.f78251c, this.f78245a.f78252d, this.f78245a.f78253e, this.f78245a.f78254f, this.f78245a.f78255g);
    }

    public final m0 b() {
        return this.f78245a;
    }

    public int c(t tVar, l0 l0Var) throws IOException {
        while (true) {
            c cVar = (c) z3.a.i(this.f78247c);
            long j11 = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j11 <= this.f78248d) {
                e(false, j11);
                return g(tVar, j11, l0Var);
            }
            if (!i(tVar, jK)) {
                return g(tVar, jK, l0Var);
            }
            tVar.resetPeekPosition();
            C0862e c0862eB = this.f78246b.b(tVar, cVar.m());
            int i11 = c0862eB.f78265a;
            if (i11 == -3) {
                e(false, jK);
                return g(tVar, jK, l0Var);
            }
            if (i11 == -2) {
                cVar.p(c0862eB.f78266b, c0862eB.f78267c);
            } else {
                if (i11 != -1) {
                    if (i11 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(tVar, c0862eB.f78267c);
                    e(true, c0862eB.f78267c);
                    return g(tVar, c0862eB.f78267c, l0Var);
                }
                cVar.o(c0862eB.f78266b, c0862eB.f78267c);
            }
        }
    }

    public final boolean d() {
        return this.f78247c != null;
    }

    public final void e(boolean z11, long j11) {
        this.f78247c = null;
        this.f78246b.a();
        f(z11, j11);
    }

    public void f(boolean z11, long j11) {
    }

    public final int g(t tVar, long j11, l0 l0Var) {
        if (j11 == tVar.getPosition()) {
            return 0;
        }
        l0Var.f78322a = j11;
        return 1;
    }

    public final void h(long j11) {
        c cVar = this.f78247c;
        if (cVar == null || cVar.l() != j11) {
            this.f78247c = a(j11);
        }
    }

    public final boolean i(t tVar, long j11) throws IOException {
        long position = j11 - tVar.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        tVar.skipFully((int) position);
        return true;
    }
}
