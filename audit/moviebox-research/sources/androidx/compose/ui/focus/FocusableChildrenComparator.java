package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    private final androidx.compose.runtime.collection.b<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        androidx.compose.runtime.collection.b<LayoutNode> bVar = new androidx.compose.runtime.collection.b<>(new LayoutNode[16], 0);
        while (layoutNode != null) {
            bVar.a(0, layoutNode);
            layoutNode = layoutNode.h0();
        }
        return bVar;
    }

    @Override // java.util.Comparator
    public int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        int i11 = 0;
        if (!z.g(focusTargetNode) || !z.g(focusTargetNode2)) {
            if (z.g(focusTargetNode)) {
                return -1;
            }
            return z.g(focusTargetNode2) ? 1 : 0;
        }
        LayoutNode layoutNodeM = androidx.compose.ui.node.g.m(focusTargetNode);
        LayoutNode layoutNodeM2 = androidx.compose.ui.node.g.m(focusTargetNode2);
        if (Intrinsics.b(layoutNodeM, layoutNodeM2)) {
            return 0;
        }
        androidx.compose.runtime.collection.b<LayoutNode> bVarPathFromRoot = pathFromRoot(layoutNodeM);
        androidx.compose.runtime.collection.b<LayoutNode> bVarPathFromRoot2 = pathFromRoot(layoutNodeM2);
        int iMin = Math.min(bVarPathFromRoot.r() - 1, bVarPathFromRoot2.r() - 1);
        if (iMin >= 0) {
            while (Intrinsics.b(bVarPathFromRoot.q()[i11], bVarPathFromRoot2.q()[i11])) {
                if (i11 != iMin) {
                    i11++;
                }
            }
            return Intrinsics.i(bVarPathFromRoot.q()[i11].i0(), bVarPathFromRoot2.q()[i11].i0());
        }
        throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
    }
}
