package q2;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74266b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f74267c = c(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74268a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return z.f74267c;
        }
    }

    public /* synthetic */ z(long j11) {
        this.f74268a = j11;
    }

    public static final /* synthetic */ z b(long j11) {
        return new z(j11);
    }

    public static long c(long j11) {
        return j11;
    }

    public static final long d(long j11, float f11, float f12) {
        return c((((long) Float.floatToRawIntBits(f11)) << 32) | (((long) Float.floatToRawIntBits(f12)) & 4294967295L));
    }

    public static /* synthetic */ long e(long j11, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Float.intBitsToFloat((int) (j11 >> 32));
        }
        if ((i11 & 2) != 0) {
            f12 = Float.intBitsToFloat((int) (4294967295L & j11));
        }
        return d(j11, f11, f12);
    }

    public static boolean f(long j11, Object obj) {
        return (obj instanceof z) && j11 == ((z) obj).n();
    }

    public static final boolean g(long j11, long j12) {
        return j11 == j12;
    }

    public static final float h(long j11) {
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final float i(long j11) {
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static int j(long j11) {
        return l.p.a(j11);
    }

    public static final long k(long j11, long j12) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) - Float.intBitsToFloat((int) (j12 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) - Float.intBitsToFloat((int) (j12 & 4294967295L));
        return c((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static final long l(long j11, long j12) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j11 >> 32)) + Float.intBitsToFloat((int) (j12 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j11 & 4294967295L)) + Float.intBitsToFloat((int) (j12 & 4294967295L));
        return c((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L));
    }

    public static String m(long j11) {
        return '(' + h(j11) + ", " + i(j11) + ") px/sec";
    }

    public boolean equals(Object obj) {
        return f(this.f74268a, obj);
    }

    public int hashCode() {
        return j(this.f74268a);
    }

    public final /* synthetic */ long n() {
        return this.f74268a;
    }

    public String toString() {
        return m(this.f74268a);
    }
}
