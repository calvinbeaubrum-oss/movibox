package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

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
public final class h2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f3412a;

    public /* synthetic */ h2(i iVar) {
        this.f3412a = iVar;
    }

    public static final /* synthetic */ h2 a(i iVar) {
        return new h2(iVar);
    }

    public static <T> i b(i iVar) {
        return iVar;
    }

    public static boolean c(i iVar, Object obj) {
        return (obj instanceof h2) && Intrinsics.b(iVar, ((h2) obj).f());
    }

    public static int d(i iVar) {
        return iVar.hashCode();
    }

    public static String e(i iVar) {
        return "SkippableUpdater(composer=" + iVar + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f3412a, obj);
    }

    public final /* synthetic */ i f() {
        return this.f3412a;
    }

    public int hashCode() {
        return d(this.f3412a);
    }

    public String toString() {
        return e(this.f3412a);
    }
}
