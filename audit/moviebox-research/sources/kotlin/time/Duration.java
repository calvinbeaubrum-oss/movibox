package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.LongRange;
import kotlin.ranges.a;
import kotlin.text.StringsKt__StringsKt;
import l.p;
import okhttp3.internal.http2.Http2Connection;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@SinceKotlin
@Metadata
@JvmInline
@WasExperimental
@SourceDebugExtension
public final class Duration implements Comparable<Duration> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f69159b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f69160c = j(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f69161d = DurationKt.i(4611686018427387903L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f69162f = DurationKt.i(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f69163a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Duration.f69161d;
        }

        public final long b() {
            return Duration.f69162f;
        }

        public final long c() {
            return Duration.f69160c;
        }
    }

    public static final boolean A(long j11) {
        return (((int) j11) & 1) == 0;
    }

    public static final boolean B(long j11) {
        return j11 == f69161d || j11 == f69162f;
    }

    public static final boolean C(long j11) {
        return j11 < 0;
    }

    public static final long D(long j11, long j12) {
        return E(j11, H(j12));
    }

    public static final long E(long j11, long j12) {
        if (B(j11)) {
            if (y(j12) || (j12 ^ j11) >= 0) {
                return j11;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (B(j12)) {
            return j12;
        }
        if ((((int) j11) & 1) != (((int) j12) & 1)) {
            return z(j11) ? d(j11, w(j11), w(j12)) : d(j11, w(j12), w(j11));
        }
        long jW = w(j11) + w(j12);
        return A(j11) ? DurationKt.l(jW) : DurationKt.j(jW);
    }

    public static final long F(long j11, DurationUnit unit) {
        Intrinsics.g(unit, "unit");
        if (j11 == f69161d) {
            return Long.MAX_VALUE;
        }
        if (j11 == f69162f) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.a(w(j11), v(j11), unit);
    }

    public static String G(long j11) {
        if (j11 == 0) {
            return "0s";
        }
        if (j11 == f69161d) {
            return "Infinity";
        }
        if (j11 == f69162f) {
            return "-Infinity";
        }
        boolean zC = C(j11);
        StringBuilder sb2 = new StringBuilder();
        if (zC) {
            sb2.append('-');
        }
        long jM = m(j11);
        long jO = o(jM);
        int iN = n(jM);
        int iS = s(jM);
        int iU = u(jM);
        int iT = t(jM);
        int i11 = 0;
        boolean z11 = jO != 0;
        boolean z12 = iN != 0;
        boolean z13 = iS != 0;
        boolean z14 = (iU == 0 && iT == 0) ? false : true;
        if (z11) {
            sb2.append(jO);
            sb2.append('d');
            i11 = 1;
        }
        if (z12 || (z11 && (z13 || z14))) {
            int i12 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(iN);
            sb2.append('h');
            i11 = i12;
        }
        if (z13 || (z14 && (z12 || z11))) {
            int i13 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(iS);
            sb2.append('m');
            i11 = i13;
        }
        if (z14) {
            int i14 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            if (iU != 0 || z11 || z12 || z13) {
                e(j11, sb2, iU, iT, 9, "s", false);
            } else if (iT >= 1000000) {
                e(j11, sb2, iT / 1000000, iT % 1000000, 6, "ms", false);
            } else if (iT >= 1000) {
                e(j11, sb2, iT / 1000, iT % 1000, 3, "us", false);
            } else {
                sb2.append(iT);
                sb2.append("ns");
            }
            i11 = i14;
        }
        if (zC && i11 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String string = sb2.toString();
        Intrinsics.f(string, "toString(...)");
        return string;
    }

    public static final long H(long j11) {
        return DurationKt.h(-w(j11), ((int) j11) & 1);
    }

    public static final long d(long j11, long j12, long j13) {
        long jN = DurationKt.n(j13);
        long j14 = j12 + jN;
        if (!new LongRange(-4611686018426L, 4611686018426L).s(j14)) {
            return DurationKt.i(a.l(j14, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.k(DurationKt.m(j14) + (j13 - DurationKt.m(jN)));
    }

    public static final void e(long j11, StringBuilder sb2, int i11, int i12, int i13, String str, boolean z11) {
        sb2.append(i11);
        if (i12 != 0) {
            sb2.append('.');
            String strO0 = StringsKt__StringsKt.o0(String.valueOf(i12), i13, '0');
            int i14 = -1;
            int length = strO0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i15 = length - 1;
                    if (strO0.charAt(length) != '0') {
                        i14 = length;
                        break;
                    } else if (i15 < 0) {
                        break;
                    } else {
                        length = i15;
                    }
                }
            }
            int i16 = i14 + 1;
            if (z11 || i16 >= 3) {
                sb2.append((CharSequence) strO0, 0, ((i14 + 3) / 3) * 3);
                Intrinsics.f(sb2, "append(...)");
            } else {
                sb2.append((CharSequence) strO0, 0, i16);
                Intrinsics.f(sb2, "append(...)");
            }
        }
        sb2.append(str);
    }

    public static int i(long j11, long j12) {
        long j13 = j11 ^ j12;
        if (j13 < 0 || (((int) j13) & 1) == 0) {
            return Intrinsics.j(j11, j12);
        }
        int i11 = (((int) j11) & 1) - (((int) j12) & 1);
        return C(j11) ? -i11 : i11;
    }

    public static long j(long j11) {
        if (DurationJvmKt.a()) {
            if (A(j11)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).s(w(j11))) {
                    throw new AssertionError(w(j11) + " ns is out of nanoseconds range");
                }
            } else {
                if (!new LongRange(-4611686018427387903L, 4611686018427387903L).s(w(j11))) {
                    throw new AssertionError(w(j11) + " ms is out of milliseconds range");
                }
                if (new LongRange(-4611686018426L, 4611686018426L).s(w(j11))) {
                    throw new AssertionError(w(j11) + " ms is denormalized");
                }
            }
        }
        return j11;
    }

    public static boolean k(long j11, Object obj) {
        return (obj instanceof Duration) && j11 == ((Duration) obj).R();
    }

    public static final boolean l(long j11, long j12) {
        return j11 == j12;
    }

    public static final long m(long j11) {
        return C(j11) ? H(j11) : j11;
    }

    public static final int n(long j11) {
        if (B(j11)) {
            return 0;
        }
        return (int) (p(j11) % ((long) 24));
    }

    public static final long o(long j11) {
        return F(j11, DurationUnit.DAYS);
    }

    public static final long p(long j11) {
        return F(j11, DurationUnit.HOURS);
    }

    public static final long q(long j11) {
        return F(j11, DurationUnit.MINUTES);
    }

    public static final long r(long j11) {
        return F(j11, DurationUnit.SECONDS);
    }

    public static final int s(long j11) {
        if (B(j11)) {
            return 0;
        }
        return (int) (q(j11) % ((long) 60));
    }

    public static final int t(long j11) {
        if (B(j11)) {
            return 0;
        }
        return (int) (z(j11) ? DurationKt.m(w(j11) % ((long) 1000)) : w(j11) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
    }

    public static final int u(long j11) {
        if (B(j11)) {
            return 0;
        }
        return (int) (r(j11) % ((long) 60));
    }

    public static final DurationUnit v(long j11) {
        return A(j11) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static final long w(long j11) {
        return j11 >> 1;
    }

    public static int x(long j11) {
        return p.a(j11);
    }

    public static final boolean y(long j11) {
        return !B(j11);
    }

    public static final boolean z(long j11) {
        return (((int) j11) & 1) == 1;
    }

    public final /* synthetic */ long R() {
        return this.f69163a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return h(duration.R());
    }

    public boolean equals(Object obj) {
        return k(this.f69163a, obj);
    }

    public int h(long j11) {
        return i(this.f69163a, j11);
    }

    public int hashCode() {
        return x(this.f69163a);
    }

    public String toString() {
        return G(this.f69163a);
    }
}
