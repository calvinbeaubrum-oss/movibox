package androidx.compose.ui.graphics.colorspace;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4018a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f4019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f4020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f4021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f4022e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return b.f4021d;
        }

        public final long b() {
            return b.f4019b;
        }

        public final long c() {
            return b.f4020c;
        }
    }

    static {
        long j11 = 3;
        long j12 = j11 << 32;
        f4019b = d((((long) 0) & 4294967295L) | j12);
        f4020c = d((((long) 1) & 4294967295L) | j12);
        f4021d = d(j12 | (((long) 2) & 4294967295L));
        f4022e = d((j11 & 4294967295L) | (((long) 4) << 32));
    }

    public static long d(long j11) {
        return j11;
    }

    public static final boolean e(long j11, long j12) {
        return j11 == j12;
    }

    public static final int f(long j11) {
        return (int) (j11 >> 32);
    }

    public static int g(long j11) {
        return l.p.a(j11);
    }

    public static String h(long j11) {
        if (e(j11, f4019b)) {
            return "Rgb";
        }
        if (e(j11, f4020c)) {
            return "Xyz";
        }
        if (e(j11, f4021d)) {
            return "Lab";
        }
        return e(j11, f4022e) ? "Cmyk" : "Unknown";
    }
}
