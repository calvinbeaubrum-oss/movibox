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
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74237b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f74238c = b(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f74239d = b(9205357640488583168L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74240a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ k(long j11) {
        this.f74240a = j11;
    }

    public static final /* synthetic */ k a(long j11) {
        return new k(j11);
    }

    public static long b(long j11) {
        return j11;
    }

    public static boolean c(long j11, Object obj) {
        return (obj instanceof k) && j11 == ((k) obj).h();
    }

    public static final float d(long j11) {
        return i.h(Float.intBitsToFloat((int) (j11 >> 32)));
    }

    public static final float e(long j11) {
        return i.h(Float.intBitsToFloat((int) (j11 & 4294967295L)));
    }

    public static int f(long j11) {
        return l.p.a(j11);
    }

    public static String g(long j11) {
        if (j11 == 9205357640488583168L) {
            return "DpOffset.Unspecified";
        }
        return '(' + ((Object) i.l(d(j11))) + ", " + ((Object) i.l(e(j11))) + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f74240a, obj);
    }

    public final /* synthetic */ long h() {
        return this.f74240a;
    }

    public int hashCode() {
        return f(this.f74240a);
    }

    public String toString() {
        return g(this.f74240a);
    }
}
