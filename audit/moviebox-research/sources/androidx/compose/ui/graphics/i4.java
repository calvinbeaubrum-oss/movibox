package androidx.compose.ui.graphics;

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
public final class i4 {
    public static final g4 a(int i11, int i12, int i13, boolean z11, androidx.compose.ui.graphics.colorspace.c cVar) {
        return q0.a(i11, i12, i13, z11, cVar);
    }

    public static /* synthetic */ g4 b(int i11, int i12, int i13, boolean z11, androidx.compose.ui.graphics.colorspace.c cVar, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i13 = h4.f4148b.b();
        }
        if ((i14 & 8) != 0) {
            z11 = true;
        }
        if ((i14 & 16) != 0) {
            cVar = androidx.compose.ui.graphics.colorspace.g.f4027a.w();
        }
        return a(i11, i12, i13, z11, cVar);
    }
}
