package androidx.compose.ui.node;

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
public final class r0 {
    public static final androidx.compose.ui.f.c b(f fVar, int i11, int i12) {
        androidx.compose.ui.f.c cVarF1 = fVar.getNode().f1();
        if (cVarF1 == null || (cVarF1.e1() & i11) == 0) {
            return null;
        }
        while (cVarF1 != null) {
            int iJ1 = cVarF1.j1();
            if ((iJ1 & i12) != 0) {
                return null;
            }
            if ((iJ1 & i11) != 0) {
                return cVarF1;
            }
            cVarF1 = cVarF1.f1();
        }
        return null;
    }
}
