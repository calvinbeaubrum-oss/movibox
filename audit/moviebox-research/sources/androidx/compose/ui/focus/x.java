package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.y0;
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
public final class x {
    public static final y b(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNodeX0;
        y0 y0VarG0;
        k focusOwner;
        NodeCoordinator nodeCoordinatorG1 = focusTargetNode.getNode().g1();
        if (nodeCoordinatorG1 == null || (layoutNodeX0 = nodeCoordinatorG1.X0()) == null || (y0VarG0 = layoutNodeX0.g0()) == null || (focusOwner = y0VarG0.getFocusOwner()) == null) {
            return null;
        }
        return focusOwner.d();
    }

    public static final void c(FocusTargetNode focusTargetNode) {
        androidx.compose.ui.node.g.n(focusTargetNode).getFocusOwner().f(focusTargetNode);
    }

    public static final y d(FocusTargetNode focusTargetNode) {
        return androidx.compose.ui.node.g.n(focusTargetNode).getFocusOwner().d();
    }
}
