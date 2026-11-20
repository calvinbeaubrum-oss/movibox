package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import l.p;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2592a;

    public /* synthetic */ a(long j11) {
        this.f2592a = j11;
    }

    public static final /* synthetic */ a a(long j11) {
        return new a(j11);
    }

    public static boolean b(long j11, Object obj) {
        return (obj instanceof a) && j11 == ((a) obj).e();
    }

    public static int c(long j11) {
        return p.a(j11);
    }

    public static String d(long j11) {
        return "GridItemSpan(packedValue=" + j11 + ')';
    }

    public final /* synthetic */ long e() {
        return this.f2592a;
    }

    public boolean equals(Object obj) {
        return b(this.f2592a, obj);
    }

    public int hashCode() {
        return c(this.f2592a);
    }

    public String toString() {
        return d(this.f2592a);
    }
}
