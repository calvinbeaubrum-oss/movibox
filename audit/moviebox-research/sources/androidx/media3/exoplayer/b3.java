package androidx.media3.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b3 f10002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b3 f10003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b3 f10004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b3 f10005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b3 f10006g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10008b;

    static {
        b3 b3Var = new b3(0L, 0L);
        f10002c = b3Var;
        f10003d = new b3(Long.MAX_VALUE, Long.MAX_VALUE);
        f10004e = new b3(Long.MAX_VALUE, 0L);
        f10005f = new b3(0L, Long.MAX_VALUE);
        f10006g = b3Var;
    }

    public b3(long j11, long j12) {
        z3.a.a(j11 >= 0);
        z3.a.a(j12 >= 0);
        this.f10007a = j11;
        this.f10008b = j12;
    }

    public long a(long j11, long j12, long j13) {
        long j14 = this.f10007a;
        if (j14 == 0 && this.f10008b == 0) {
            return j11;
        }
        long jS1 = z3.u0.s1(j11, j14, Long.MIN_VALUE);
        long jB = z3.u0.b(j11, this.f10008b, Long.MAX_VALUE);
        boolean z11 = false;
        boolean z12 = jS1 <= j12 && j12 <= jB;
        if (jS1 <= j13 && j13 <= jB) {
            z11 = true;
        }
        if (z12 && z11) {
            return Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13;
        }
        if (z12) {
            return j12;
        }
        return z11 ? j13 : jS1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b3.class != obj.getClass()) {
            return false;
        }
        b3 b3Var = (b3) obj;
        return this.f10007a == b3Var.f10007a && this.f10008b == b3Var.f10008b;
    }

    public int hashCode() {
        return (((int) this.f10007a) * 31) + ((int) this.f10008b);
    }
}
