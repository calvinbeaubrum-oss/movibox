package androidx.media3.common;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f9089g = new c(null, new a[0], 0, C.TIME_UNSET, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f9090h = new a(0).i(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9091i = u0.E0(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9092j = u0.E0(2);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9093k = u0.E0(3);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9094l = u0.E0(4);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Deprecated
    public static final i<c> f9095m = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Object f9096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a[] f9101f;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f9102j = u0.E0(0);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f9103k = u0.E0(1);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f9104l = u0.E0(2);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f9105m = u0.E0(3);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f9106n = u0.E0(4);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f9107o = u0.E0(5);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f9108p = u0.E0(6);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f9109q = u0.E0(7);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f9110r = u0.E0(8);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Deprecated
        public static final i<a> f9111s = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public final Uri[] f9115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b0[] f9116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f9117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long[] f9118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f9119h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f9120i;

        public a(long j11) {
            this(j11, -1, -1, new int[0], new b0[0], new long[0], 0L, false);
        }

        public a(long j11, int i11, int i12, int[] iArr, b0[] b0VarArr, long[] jArr, long j12, boolean z11) {
            int i13 = 0;
            z3.a.a(iArr.length == b0VarArr.length);
            this.f9112a = j11;
            this.f9113b = i11;
            this.f9114c = i12;
            this.f9117f = iArr;
            this.f9116e = b0VarArr;
            this.f9118g = jArr;
            this.f9119h = j12;
            this.f9120i = z11;
            this.f9115d = new Uri[b0VarArr.length];
            while (true) {
                Uri[] uriArr = this.f9115d;
                if (i13 >= uriArr.length) {
                    return;
                }
                b0 b0Var = b0VarArr[i13];
                uriArr[i13] = b0Var == null ? null : ((b0.h) z3.a.e(b0Var.f8951b)).f9047a;
                i13++;
            }
        }

        @CheckResult
        public static long[] b(long[] jArr, int i11) {
            int length = jArr.length;
            int iMax = Math.max(i11, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, C.TIME_UNSET);
            return jArrCopyOf;
        }

        @CheckResult
        public static int[] c(int[] iArr, int i11) {
            int length = iArr.length;
            int iMax = Math.max(i11, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        public int d() {
            return e(-1);
        }

        public int e(int i11) {
            int i12;
            int i13 = i11 + 1;
            while (true) {
                int[] iArr = this.f9117f;
                if (i13 >= iArr.length || this.f9120i || (i12 = iArr[i13]) == 0 || i12 == 1) {
                    break;
                }
                i13++;
            }
            return i13;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f9112a == aVar.f9112a && this.f9113b == aVar.f9113b && this.f9114c == aVar.f9114c && Arrays.equals(this.f9116e, aVar.f9116e) && Arrays.equals(this.f9117f, aVar.f9117f) && Arrays.equals(this.f9118g, aVar.f9118g) && this.f9119h == aVar.f9119h && this.f9120i == aVar.f9120i;
        }

        public boolean f() {
            if (this.f9113b == -1) {
                return true;
            }
            for (int i11 = 0; i11 < this.f9113b; i11++) {
                int i12 = this.f9117f[i11];
                if (i12 == 0 || i12 == 1) {
                    return true;
                }
            }
            return false;
        }

        public final boolean g() {
            return this.f9120i && this.f9112a == Long.MIN_VALUE && this.f9113b == -1;
        }

        public boolean h() {
            return this.f9113b == -1 || d() < this.f9113b;
        }

        public int hashCode() {
            int i11 = ((this.f9113b * 31) + this.f9114c) * 31;
            long j11 = this.f9112a;
            int iHashCode = (((((((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + Arrays.hashCode(this.f9116e)) * 31) + Arrays.hashCode(this.f9117f)) * 31) + Arrays.hashCode(this.f9118g)) * 31;
            long j12 = this.f9119h;
            return ((iHashCode + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f9120i ? 1 : 0);
        }

        @CheckResult
        public a i(int i11) {
            int[] iArrC = c(this.f9117f, i11);
            long[] jArrB = b(this.f9118g, i11);
            return new a(this.f9112a, i11, this.f9114c, iArrC, (b0[]) Arrays.copyOf(this.f9116e, i11), jArrB, this.f9119h, this.f9120i);
        }
    }

    public c(@Nullable Object obj, a[] aVarArr, long j11, long j12, int i11) {
        this.f9096a = obj;
        this.f9098c = j11;
        this.f9099d = j12;
        this.f9097b = aVarArr.length + i11;
        this.f9101f = aVarArr;
        this.f9100e = i11;
    }

    public a a(int i11) {
        int i12 = this.f9100e;
        return i11 < i12 ? f9090h : this.f9101f[i11 - i12];
    }

    public int b(long j11, long j12) {
        if (j11 == Long.MIN_VALUE) {
            return -1;
        }
        if (j12 != C.TIME_UNSET && j11 >= j12) {
            return -1;
        }
        int i11 = this.f9100e;
        while (i11 < this.f9097b && ((a(i11).f9112a != Long.MIN_VALUE && a(i11).f9112a <= j11) || !a(i11).h())) {
            i11++;
        }
        if (i11 < this.f9097b) {
            return i11;
        }
        return -1;
    }

    public int c(long j11, long j12) {
        int i11 = this.f9097b - 1;
        int i12 = i11 - (d(i11) ? 1 : 0);
        while (i12 >= 0 && e(j11, j12, i12)) {
            i12--;
        }
        if (i12 < 0 || !a(i12).f()) {
            return -1;
        }
        return i12;
    }

    public boolean d(int i11) {
        return i11 == this.f9097b - 1 && a(i11).g();
    }

    public final boolean e(long j11, long j12, int i11) {
        if (j11 == Long.MIN_VALUE) {
            return false;
        }
        a aVarA = a(i11);
        long j13 = aVarA.f9112a;
        if (j13 == Long.MIN_VALUE) {
            return j12 == C.TIME_UNSET || (aVarA.f9120i && aVarA.f9113b == -1) || j11 < j12;
        }
        return j11 < j13;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return u0.c(this.f9096a, cVar.f9096a) && this.f9097b == cVar.f9097b && this.f9098c == cVar.f9098c && this.f9099d == cVar.f9099d && this.f9100e == cVar.f9100e && Arrays.equals(this.f9101f, cVar.f9101f);
    }

    public int hashCode() {
        int i11 = this.f9097b * 31;
        Object obj = this.f9096a;
        return ((((((((i11 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.f9098c)) * 31) + ((int) this.f9099d)) * 31) + this.f9100e) * 31) + Arrays.hashCode(this.f9101f);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AdPlaybackState(adsId=");
        sb2.append(this.f9096a);
        sb2.append(", adResumePositionUs=");
        sb2.append(this.f9098c);
        sb2.append(", adGroups=[");
        for (int i11 = 0; i11 < this.f9101f.length; i11++) {
            sb2.append("adGroup(timeUs=");
            sb2.append(this.f9101f[i11].f9112a);
            sb2.append(", ads=[");
            for (int i12 = 0; i12 < this.f9101f[i11].f9117f.length; i12++) {
                sb2.append("ad(state=");
                int i13 = this.f9101f[i11].f9117f[i12];
                if (i13 == 0) {
                    sb2.append('_');
                } else if (i13 == 1) {
                    sb2.append('R');
                } else if (i13 == 2) {
                    sb2.append('S');
                } else if (i13 == 3) {
                    sb2.append('P');
                } else if (i13 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(this.f9101f[i11].f9118g[i12]);
                sb2.append(')');
                if (i12 < this.f9101f[i11].f9117f.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i11 < this.f9101f.length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("])");
        return sb2.toString();
    }
}
