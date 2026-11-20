package rh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final i f75457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f75458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f75459c;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f75460d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f75461e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final List<d> f75462f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f75463g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f75464h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f75465i;

        public a(@Nullable i iVar, long j11, long j12, long j13, long j14, @Nullable List<d> list, long j15, long j16, long j17) {
            super(iVar, j11, j12);
            this.f75460d = j13;
            this.f75461e = j14;
            this.f75462f = list;
            this.f75465i = j15;
            this.f75463g = j16;
            this.f75464h = j17;
        }

        public long c(long j11, long j12) {
            long jG = g(j11);
            return jG != -1 ? jG : (int) (i((j12 - this.f75464h) + this.f75465i, j11) - d(j11, j12));
        }

        public long d(long j11, long j12) {
            if (g(j11) == -1) {
                long j13 = this.f75463g;
                if (j13 != C.TIME_UNSET) {
                    return Math.max(e(), i((j12 - this.f75464h) - j13, j11));
                }
            }
            return e();
        }

        public long e() {
            return this.f75460d;
        }

        public long f(long j11, long j12) {
            if (this.f75462f != null) {
                return C.TIME_UNSET;
            }
            long jD = d(j11, j12) + c(j11, j12);
            return (j(jD) + h(jD, j11)) - this.f75465i;
        }

        public abstract long g(long j11);

        public final long h(long j11, long j12) {
            List<d> list = this.f75462f;
            if (list != null) {
                return (list.get((int) (j11 - this.f75460d)).f75471b * 1000000) / this.f75458b;
            }
            long jG = g(j12);
            return (jG == -1 || j11 != (e() + jG) - 1) ? (this.f75461e * 1000000) / this.f75458b : j12 - j(j11);
        }

        public long i(long j11, long j12) {
            long jE = e();
            long jG = g(j12);
            if (jG == 0) {
                return jE;
            }
            if (this.f75462f == null) {
                long j13 = this.f75460d + (j11 / ((this.f75461e * 1000000) / this.f75458b));
                if (j13 < jE) {
                    return jE;
                }
                return jG == -1 ? j13 : Math.min(j13, (jE + jG) - 1);
            }
            long j14 = (jG + jE) - 1;
            long j15 = jE;
            while (j15 <= j14) {
                long j16 = ((j14 - j15) / 2) + j15;
                long j17 = j(j16);
                if (j17 < j11) {
                    j15 = j16 + 1;
                } else {
                    if (j17 <= j11) {
                        return j16;
                    }
                    j14 = j16 - 1;
                }
            }
            return j15 == jE ? j15 : j14;
        }

        public final long j(long j11) {
            List<d> list = this.f75462f;
            return o0.O0(list != null ? list.get((int) (j11 - this.f75460d)).f75470a - this.f75459c : (j11 - this.f75460d) * this.f75461e, 1000000L, this.f75458b);
        }

        public abstract i k(j jVar, long j11);

        public boolean l() {
            return this.f75462f != null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public final List<i> f75466j;

        public b(i iVar, long j11, long j12, long j13, long j14, @Nullable List<d> list, long j15, @Nullable List<i> list2, long j16, long j17) {
            super(iVar, j11, j12, j13, j14, list, j15, j16, j17);
            this.f75466j = list2;
        }

        @Override // rh.k.a
        public long g(long j11) {
            return this.f75466j.size();
        }

        @Override // rh.k.a
        public i k(j jVar, long j11) {
            return this.f75466j.get((int) (j11 - this.f75460d));
        }

        @Override // rh.k.a
        public boolean l() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public final n f75467j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final n f75468k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f75469l;

        public c(i iVar, long j11, long j12, long j13, long j14, long j15, @Nullable List<d> list, long j16, @Nullable n nVar, @Nullable n nVar2, long j17, long j18) {
            super(iVar, j11, j12, j13, j15, list, j16, j17, j18);
            this.f75467j = nVar;
            this.f75468k = nVar2;
            this.f75469l = j14;
        }

        @Override // rh.k
        @Nullable
        public i a(j jVar) {
            n nVar = this.f75467j;
            if (nVar == null) {
                return super.a(jVar);
            }
            m1 m1Var = jVar.f75444b;
            return new i(nVar.a(m1Var.f33434a, 0L, m1Var.f33441i, 0L), 0L, -1L);
        }

        @Override // rh.k.a
        public long g(long j11) {
            List<d> list = this.f75462f;
            if (list != null) {
                return list.size();
            }
            long j12 = this.f75469l;
            if (j12 != -1) {
                return (j12 - this.f75460d) + 1;
            }
            if (j11 != C.TIME_UNSET) {
                return com.google.common.math.a.a(BigInteger.valueOf(j11).multiply(BigInteger.valueOf(this.f75458b)), BigInteger.valueOf(this.f75461e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // rh.k.a
        public i k(j jVar, long j11) {
            List<d> list = this.f75462f;
            long j12 = list != null ? list.get((int) (j11 - this.f75460d)).f75470a : (j11 - this.f75460d) * this.f75461e;
            n nVar = this.f75468k;
            m1 m1Var = jVar.f75444b;
            return new i(nVar.a(m1Var.f33434a, j11, m1Var.f33441i, j12), 0L, -1L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f75470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f75471b;

        public d(long j11, long j12) {
            this.f75470a = j11;
            this.f75471b = j12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f75470a == dVar.f75470a && this.f75471b == dVar.f75471b;
        }

        public int hashCode() {
            return (((int) this.f75470a) * 31) + ((int) this.f75471b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f75472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f75473e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public e(@Nullable i iVar, long j11, long j12, long j13, long j14) {
            super(iVar, j11, j12);
            this.f75472d = j13;
            this.f75473e = j14;
        }

        @Nullable
        public i c() {
            long j11 = this.f75473e;
            if (j11 <= 0) {
                return null;
            }
            return new i(null, this.f75472d, j11);
        }
    }

    public k(@Nullable i iVar, long j11, long j12) {
        this.f75457a = iVar;
        this.f75458b = j11;
        this.f75459c = j12;
    }

    @Nullable
    public i a(j jVar) {
        return this.f75457a;
    }

    public long b() {
        return o0.O0(this.f75459c, 1000000L, this.f75458b);
    }
}
