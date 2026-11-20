package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
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
public final class s {
    public static final androidx.compose.ui.node.j0 a(androidx.compose.ui.node.j0 j0Var) {
        LayoutNode layoutNodeX0 = j0Var.X0();
        while (true) {
            LayoutNode layoutNodeH0 = layoutNodeX0.h0();
            if ((layoutNodeH0 != null ? layoutNodeH0.V() : null) == null) {
                androidx.compose.ui.node.j0 j0VarT1 = layoutNodeX0.f0().T1();
                Intrinsics.d(j0VarT1);
                return j0VarT1;
            }
            LayoutNode layoutNodeH1 = layoutNodeX0.h0();
            LayoutNode layoutNodeV = layoutNodeH1 != null ? layoutNodeH1.V() : null;
            Intrinsics.d(layoutNodeV);
            if (layoutNodeV.H0()) {
                layoutNodeX0 = layoutNodeX0.h0();
                Intrinsics.d(layoutNodeX0);
            } else {
                LayoutNode layoutNodeH2 = layoutNodeX0.h0();
                Intrinsics.d(layoutNodeH2);
                layoutNodeX0 = layoutNodeH2.V();
                Intrinsics.d(layoutNodeX0);
            }
        }
    }
}
