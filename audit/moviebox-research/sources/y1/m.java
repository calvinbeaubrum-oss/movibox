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
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f81091b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f81092c = d(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f81093d = d(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f81094a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return m.f81093d;
        }

        public final long b() {
            return m.f81092c;
        }
    }

    public /* synthetic */ m(long j11) {
        this.f81094a = j11;
    }

    public static final /* synthetic */ m c(long j11) {
        return new m(j11);
    }

    public static long d(long j11) {
        return j11;
    }

    public static boolean e(long j11, Object obj) {
        return (obj instanceof m) && j11 == ((m) obj).m();
    }

    public static final boolean f(long j11, long j12) {
        return j11 == j12;
    }

    public static final float g(long j11) {
        if (j11 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static final float h(long j11) {
        if (j11 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        return Math.min(Float.intBitsToFloat((int) ((j11 >> 32) & 2147483647L)), Float.intBitsToFloat((int) (j11 & 2147483647L)));
    }

    public static final float i(long j11) {
        if (j11 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static int j(long j11) {
        return p.a(j11);
    }

    public static final boolean k(long j11) {
        if (j11 == 9205357640488583168L) {
            d.a("Size is unspecified");
        }
        long j12 = j11 & (~((((-9223372034707292160L) & j11) >>> 31) * ((long) (-1))));
        return ((j12 & 4294967295L) & (j12 >>> 32)) == 0;
    }

    public static String l(long j11) {
        if (j11 == 9205357640488583168L) {
            return "Size.Unspecified";
        }
        return "Size(" + c.a(i(j11), 1) + ", " + c.a(g(j11), 1) + ')';
    }

    public boolean equals(Object obj) {
        return e(this.f81094a, obj);
    }

    public int hashCode() {
        return j(this.f81094a);
    }

    public final /* synthetic */ long m() {
        return this.f81094a;
    }

    public String toString() {
        return l(this.f81094a);
    }
}
