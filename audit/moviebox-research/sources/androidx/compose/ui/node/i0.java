package androidx.compose.ui.node;

import java.util.Map;
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
public final class i0 extends AlignmentLines {
    public i0(a aVar) {
        super(aVar, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public long d(NodeCoordinator nodeCoordinator, long j11) {
        j0 j0VarT1 = nodeCoordinator.T1();
        Intrinsics.d(j0VarT1);
        long jD1 = j0VarT1.d1();
        return y1.g.r(y1.h.a(q2.p.h(jD1), q2.p.i(jD1)), j11);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public Map<androidx.compose.ui.layout.a, Integer> e(NodeCoordinator nodeCoordinator) {
        j0 j0VarT1 = nodeCoordinator.T1();
        Intrinsics.d(j0VarT1);
        return j0VarT1.Y0().l();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public int i(NodeCoordinator nodeCoordinator, androidx.compose.ui.layout.a aVar) {
        j0 j0VarT1 = nodeCoordinator.T1();
        Intrinsics.d(j0VarT1);
        return j0VarT1.O0(aVar);
    }
}
