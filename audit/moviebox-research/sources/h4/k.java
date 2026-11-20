package h4;

import androidx.annotation.Nullable;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final i f66315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f66316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f66317c;

    /* JADX INFO: compiled from: source.java */
    public static abstract class a extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f66318d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f66319e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public final List<d> f66320f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f66321g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f66322h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f66323i;

        public a(@Nullable i iVar, long j11, long j12, long j13, long j14, @Nullable List<d> list, long j15, long j16, long j17) {
            super(iVar, j11, j12);
            this.f66318d = j13;
            this.f66319e = j14;
            this.f66320f = list;
            this.f66323i = j15;
            this.f66321g = j16;
            this.f66322h = j17;
        }

        public long c(long j11, long j12) {
            long jG = g(j11);
            return jG != -1 ? jG : (int) (i((j12 - this.f66322h) + this.f66323i, j11) - d(j11, j12));
        }

        public long d(long j11, long j12) {
            if (g(j11) == -1) {
                long j13 = this.f66321g;
                if (j13 != C.TIME_UNSET) {
                    return Math.max(e(), i((j12 - this.f66322h) - j13, j11));
                }
            }
            return e();
        }

        public long e() {
            return this.f66318d;
        }

        public long f(long j11, long j12) {
            if (this.f66320f != null) {
                return C.TIME_UNSET;
            }
            long jD = d(j11, j12) + c(j11, j12);
            return (j(jD) + h(jD, j11)) - this.f66323i;
        }

        public abstract long g(long j11);

        public final long h(long j11, long j12) {
            List<d> list = this.f66320f;
            if (list != null) {
                return (list.get((int) (j11 - this.f66318d)).f66329b * 1000000) / this.f66316b;
            }
            long jG = g(j12);
            return (jG == -1 || j11 != (e() + jG) - 1) ? (this.f66319e * 1000000) / this.f66316b : j12 - j(j11);
        }

        public long i(long j11, long j12) {
            long jE = e();
            long jG = g(j12);
            if (jG == 0) {
                return jE;
            }
            if (this.f66320f == null) {
                long j13 = this.f66318d + (j11 / ((this.f66319e * 1000000) / this.f66316b));
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
            List<d> list = this.f66320f;
            return u0.f1(list != null ? list.get((int) (j11 - this.f66318d)).f66328a - this.f66317c : (j11 - this.f66318d) * this.f66319e, 1000000L, this.f66316b);
        }

        public abstract i k(j jVar, long j11);

        public boolean l() {
            return this.f66320f != null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public final List<i> f66324j;

        public b(i iVar, long j11, long j12, long j13, long j14, @Nullable List<d> list, long j15, @Nullable List<i> list2, long j16, long j17) {
            super(iVar, j11, j12, j13, j14, list, j15, j16, j17);
            this.f66324j = list2;
        }

        @Override // h4.k.a
        public long g(long j11) {
            return this.f66324j.size();
        }

        @Override // h4.k.a
        public i k(j jVar, long j11) {
            return this.f66324j.get((int) (j11 - this.f66318d));
        }

        @Override // h4.k.a
        public boolean l() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public final n f66325j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        public final n f66326k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final long f66327l;

        public c(i iVar, long j11, long j12, long j13, long j14, long j15, @Nullable List<d> list, long j16, @Nullable n nVar, @Nullable n nVar2, long j17, long j18) {
            super(iVar, j11, j12, j13, j15, list, j16, j17, j18);
            this.f66325j = nVar;
            this.f66326k = nVar2;
            this.f66327l = j14;
        }

        @Override // h4.k
        @Nullable
        public i a(j jVar) {
            n nVar = this.f66325j;
            if (nVar == null) {
                return super.a(jVar);
            }
            y yVar = jVar.f66302b;
            return new i(nVar.a(yVar.f9489a, 0L, yVar.f9497i, 0L), 0L, -1L);
        }

        @Override // h4.k.a
        public long g(long j11) {
            List<d> list = this.f66320f;
            if (list != null) {
                return list.size();
            }
            long j12 = this.f66327l;
            if (j12 != -1) {
                return (j12 - this.f66318d) + 1;
            }
            if (j11 != C.TIME_UNSET) {
                return com.google.common.math.a.a(BigInteger.valueOf(j11).multiply(BigInteger.valueOf(this.f66316b)), BigInteger.valueOf(this.f66319e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // h4.k.a
        public i k(j jVar, long j11) {
            List<d> list = this.f66320f;
            long j12 = list != null ? list.get((int) (j11 - this.f66318d)).f66328a : (j11 - this.f66318d) * this.f66319e;
            n nVar = this.f66326k;
            y yVar = jVar.f66302b;
            return new i(nVar.a(yVar.f9489a, j11, yVar.f9497i, j12), 0L, -1L);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f66328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f66329b;

        public d(long j11, long j12) {
            this.f66328a = j11;
            this.f66329b = j12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f66328a == dVar.f66328a && this.f66329b == dVar.f66329b;
        }

        public int hashCode() {
            return (((int) this.f66328a) * 31) + ((int) this.f66329b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends k {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f66330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f66331e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public e(@Nullable i iVar, long j11, long j12, long j13, long j14) {
            super(iVar, j11, j12);
            this.f66330d = j13;
            this.f66331e = j14;
        }

        @Nullable
        public i c() {
            long j11 = this.f66331e;
            if (j11 <= 0) {
                return null;
            }
            return new i(null, this.f66330d, j11);
        }
    }

    public k(@Nullable i iVar, long j11, long j12) {
        this.f66315a = iVar;
        this.f66316b = j11;
        this.f66317c = j12;
    }

    @Nullable
    public i a(j jVar) {
        return this.f66315a;
    }

    public long b() {
        return u0.f1(this.f66317c, 1000000L, this.f66316b);
    }
}
