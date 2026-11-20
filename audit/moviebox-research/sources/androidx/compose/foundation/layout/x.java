package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.k0;
import kotlin.Metadata;

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
public interface x {
    long a(int i11, int i12, int i13, int i14, boolean z11);

    void b(int i11, int[] iArr, int[] iArr2, androidx.compose.ui.layout.y yVar);

    androidx.compose.ui.layout.w d(k0[] k0VarArr, androidx.compose.ui.layout.y yVar, int i11, int[] iArr, int i12, int i13, int[] iArr2, int i14, int i15, int i16);

    int e(k0 k0Var);

    int f(k0 k0Var);
}
