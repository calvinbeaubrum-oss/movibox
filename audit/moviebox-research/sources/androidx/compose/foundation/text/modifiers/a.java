package androidx.compose.foundation.text.modifiers;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0044a f2935a = new C0044a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f2936b = b(Float.NaN, Float.NaN);

    /* JADX INFO: renamed from: androidx.compose.foundation.text.modifiers.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0044a {
        public C0044a() {
        }

        public /* synthetic */ C0044a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f2936b;
        }
    }

    public static long b(float f11, float f12) {
        return c((((long) Float.floatToRawIntBits(f12)) & 4294967295L) | (Float.floatToRawIntBits(f11) << 32));
    }

    public static long c(long j11) {
        return j11;
    }

    public static long d(q2.e eVar) {
        return b(eVar.getDensity(), eVar.M0());
    }

    public static final boolean e(long j11, long j12) {
        return j11 == j12;
    }

    public static final float f(long j11) {
        return Float.intBitsToFloat((int) (j11 >> 32));
    }

    public static final float g(long j11) {
        return Float.intBitsToFloat((int) (j11 & 4294967295L));
    }

    public static String h(long j11) {
        return "InlineDensity(density=" + f(j11) + ", fontScale=" + g(j11) + ')';
    }
}
