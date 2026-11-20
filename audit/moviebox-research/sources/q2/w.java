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
public final class w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74257b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y[] f74258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f74259d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74260a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return w.f74259d;
        }
    }

    static {
        y.a aVar = y.f74261b;
        f74258c = new y[]{y.d(aVar.c()), y.d(aVar.b()), y.d(aVar.a())};
        f74259d = x.e(0L, Float.NaN);
    }

    public /* synthetic */ w(long j11) {
        this.f74260a = j11;
    }

    public static final /* synthetic */ w b(long j11) {
        return new w(j11);
    }

    public static long c(long j11) {
        return j11;
    }

    public static boolean d(long j11, Object obj) {
        return (obj instanceof w) && j11 == ((w) obj).k();
    }

    public static final boolean e(long j11, long j12) {
        return j11 == j12;
    }

    public static final long f(long j11) {
        return j11 & 1095216660480L;
    }

    public static final long g(long j11) {
        return f74258c[(int) (f(j11) >>> 32)].j();
    }

    public static final float h(long j11) {
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static int i(long j11) {
        return l.p.a(j11);
    }

    public static String j(long j11) {
        long jG = g(j11);
        y.a aVar = y.f74261b;
        if (y.g(jG, aVar.c())) {
            return "Unspecified";
        }
        if (y.g(jG, aVar.b())) {
            return h(j11) + ".sp";
        }
        if (!y.g(jG, aVar.a())) {
            return "Invalid";
        }
        return h(j11) + ".em";
    }

    public boolean equals(Object obj) {
        return d(this.f74260a, obj);
    }

    public int hashCode() {
        return i(this.f74260a);
    }

    public final /* synthetic */ long k() {
        return this.f74260a;
    }

    public String toString() {
        return j(this.f74260a);
    }
}
