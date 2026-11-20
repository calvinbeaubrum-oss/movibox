package y1;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import l.p;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
@SourceDebugExtension
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f81070b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f81071c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f81072d = e(9187343241974906880L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f81073e = e(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f81074a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return g.f81072d;
        }

        public final long b() {
            return g.f81073e;
        }

        public final long c() {
            return g.f81071c;
        }
    }

    public /* synthetic */ g(long j11) {
        this.f81074a = j11;
    }

    public static final /* synthetic */ g d(long j11) {
        return new g(j11);
    }

    public static long e(long j11) {
        return j11;
    }

    public static final long f(long j11, float f11, float f12) {
        return e((((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f12)) & 4294967295L));
    }

    public static /* synthetic */ long g(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Float.intBitsToFloat((int) (j11 >> 32));
        }
        if ((i11 & 2) != 0) {
            f12 = Float.intBitsToFloat((int) (4294967295L & j11));
        }
        return f(j11, f11, f12);
    }

    public static final long h(long j11, float f11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) / f11;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) / f11;
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static boolean i(long j11, Object obj) {
        return (obj instanceof g) && j11 == ((g) obj).v();
    }

    public static final boolean j(long j11, long j12) {
        return j11 == j12;
    }

    public static final float k(long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2));
    }

    public static final float l(long j11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L));
        return (fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2);
    }

    public static final float m(long j11) {
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final float n(long j11) {
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static int o(long j11) {
        return p.a(j11);
    }

    public static final boolean p(long j11) {
        long j12 = j11 & 9223372034707292159L;
        return (((~j12) & (j12 - 9187343246269874177L)) & (-9223372034707292160L)) == -9223372034707292160L;
    }

    public static final long q(long j11, long j12) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) - Float.intBitsToFloat((int) (j12 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) - Float.intBitsToFloat((int) (j12 & 4294967295L));
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long r(long j11, long j12) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat((int) (j12 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat((int) (j12 & 4294967295L));
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long s(long j11, float f11) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) * f11;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) * f11;
        return e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static String t(long j11) {
        if (!h.c(j11)) {
            return "Offset.Unspecified";
        }
        return "Offset(" + c.a(m(j11), 1) + ", " + c.a(n(j11), 1) + ')';
    }

    public static final long u(long j11) {
        return e(j11 ^ (-9223372034707292160L));
    }

    public boolean equals(Object obj) {
        return i(this.f81074a, obj);
    }

    public int hashCode() {
        return o(this.f81074a);
    }

    public String toString() {
        return t(this.f81074a);
    }

    public final /* synthetic */ long v() {
        return this.f81074a;
    }
}
