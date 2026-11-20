package v1;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f78698a = new d();

    @JvmStatic
    public static final void a(int i11, int i12) {
        if (i11 < 0 || i11 >= i12) {
            throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
        }
    }

    @JvmStatic
    public static final void b(int i11, int i12) {
        if (i11 < 0 || i11 > i12) {
            throw new IndexOutOfBoundsException("index: " + i11 + ", size: " + i12);
        }
    }

    @JvmStatic
    public static final void c(int i11, int i12, int i13) {
        if (i11 < 0 || i12 > i13) {
            throw new IndexOutOfBoundsException("fromIndex: " + i11 + ", toIndex: " + i12 + ", size: " + i13);
        }
        if (i11 <= i12) {
            return;
        }
        throw new IllegalArgumentException("fromIndex: " + i11 + " > toIndex: " + i12);
    }
}
