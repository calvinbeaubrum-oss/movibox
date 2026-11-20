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
public final class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f74244b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f74245c = c(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f74246a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return p.f74245c;
        }
    }

    public /* synthetic */ p(long j11) {
        this.f74246a = j11;
    }

    public static final /* synthetic */ p b(long j11) {
        return new p(j11);
    }

    public static long c(long j11) {
        return j11;
    }

    public static final long d(long j11, int i11, int i12) {
        return c((((long) i11) << 32) | (((long) i12) & 4294967295L));
    }

    public static /* synthetic */ long e(long j11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = (int) (j11 >> 32);
        }
        if ((i13 & 2) != 0) {
            i12 = (int) (4294967295L & j11);
        }
        return d(j11, i11, i12);
    }

    public static boolean f(long j11, Object obj) {
        return (obj instanceof p) && j11 == ((p) obj).n();
    }

    public static final boolean g(long j11, long j12) {
        return j11 == j12;
    }

    public static final int h(long j11) {
        return (int) (j11 >> 32);
    }

    public static final int i(long j11) {
        return (int) (j11 & 4294967295L);
    }

    public static int j(long j11) {
        return l.p.a(j11);
    }

    public static final long k(long j11, long j12) {
        int i11 = ((int) (j11 >> 32)) - ((int) (j12 >> 32));
        return c((((long) (((int) (j11 & 4294967295L)) - ((int) (j12 & 4294967295L)))) & 4294967295L) | (((long) i11) << 32));
    }

    public static final long l(long j11, long j12) {
        int i11 = ((int) (j11 >> 32)) + ((int) (j12 >> 32));
        return c((((long) (((int) (j11 & 4294967295L)) + ((int) (j12 & 4294967295L)))) & 4294967295L) | (((long) i11) << 32));
    }

    public static String m(long j11) {
        return '(' + h(j11) + ", " + i(j11) + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f74246a, obj);
    }

    public int hashCode() {
        return j(this.f74246a);
    }

    public final /* synthetic */ long n() {
        return this.f74246a;
    }

    public String toString() {
        return m(this.f74246a);
    }
}
