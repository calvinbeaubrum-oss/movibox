package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmInline
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4769a;

    public /* synthetic */ y(long j11) {
        this.f4769a = j11;
    }

    public static final /* synthetic */ y a(long j11) {
        return new y(j11);
    }

    public static long b(long j11) {
        return j11;
    }

    public static boolean c(long j11, Object obj) {
        return (obj instanceof y) && j11 == ((y) obj).g();
    }

    public static final boolean d(long j11, long j12) {
        return j11 == j12;
    }

    public static int e(long j11) {
        return l.p.a(j11);
    }

    public static String f(long j11) {
        return "PointerId(value=" + j11 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f4769a, obj);
    }

    public final /* synthetic */ long g() {
        return this.f4769a;
    }

    public int hashCode() {
        return e(this.f4769a);
    }

    public String toString() {
        return f(this.f4769a);
    }
}
