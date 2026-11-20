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
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4711a;

    public /* synthetic */ j0(int i11) {
        this.f4711a = i11;
    }

    public static final /* synthetic */ j0 a(int i11) {
        return new j0(i11);
    }

    public static int b(int i11) {
        return i11;
    }

    public static boolean c(int i11, Object obj) {
        return (obj instanceof j0) && i11 == ((j0) obj).f();
    }

    public static int d(int i11) {
        return i11;
    }

    public static String e(int i11) {
        return "PointerKeyboardModifiers(packedValue=" + i11 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f4711a, obj);
    }

    public final /* synthetic */ int f() {
        return this.f4711a;
    }

    public int hashCode() {
        return d(this.f4711a);
    }

    public String toString() {
        return e(this.f4711a);
    }
}
