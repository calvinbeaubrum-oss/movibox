package kotlin;

import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class UByte implements Comparable<UByte> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f68689b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f68690a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public /* synthetic */ UByte(byte b11) {
        this.f68690a = b11;
    }

    public static final /* synthetic */ UByte a(byte b11) {
        return new UByte(b11);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static byte b(byte b11) {
        return b11;
    }

    public static boolean c(byte b11, Object obj) {
        return (obj instanceof UByte) && b11 == ((UByte) obj).h();
    }

    public static int d(byte b11) {
        return b11;
    }

    public static String e(byte b11) {
        return String.valueOf(b11 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.i(h() & 255, uByte.h() & 255);
    }

    public boolean equals(Object obj) {
        return c(this.f68690a, obj);
    }

    public final /* synthetic */ byte h() {
        return this.f68690a;
    }

    public int hashCode() {
        return d(this.f68690a);
    }

    public String toString() {
        return e(this.f68690a);
    }
}
