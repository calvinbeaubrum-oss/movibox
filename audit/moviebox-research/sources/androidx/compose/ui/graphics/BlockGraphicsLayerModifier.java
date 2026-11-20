package androidx.compose.ui.graphics;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class BlockGraphicsLayerModifier extends androidx.compose.ui.f.c implements androidx.compose.ui.node.x {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super e4, Unit> f3943o;

    public BlockGraphicsLayerModifier(Function1<? super e4, Unit> function1) {
        this.f3943o = function1;
    }

    @Override // androidx.compose.ui.node.x
    public androidx.compose.ui.layout.w C(androidx.compose.ui.layout.y yVar, androidx.compose.ui.layout.t tVar, long j11) {
        final androidx.compose.ui.layout.k0 k0VarL = tVar.L(j11);
        return androidx.compose.ui.layout.x.b(yVar, k0VarL.s0(), k0VarL.g0(), null, new Function1<androidx.compose.ui.layout.k0.a, Unit>() { // from class: androidx.compose.ui.graphics.BlockGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.layout.k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(androidx.compose.ui.layout.k0.a aVar) {
                androidx.compose.ui.layout.k0.a.t(aVar, k0VarL, 0, 0, 0.0f, this.H1(), 4, null);
            }
        }, 4, null);
    }

    public final Function1<e4, Unit> H1() {
        return this.f3943o;
    }

    public final void I1() {
        NodeCoordinator nodeCoordinatorY1 = androidx.compose.ui.node.g.h(this, androidx.compose.ui.node.s0.a(2)).Y1();
        if (nodeCoordinatorY1 != null) {
            nodeCoordinatorY1.L2(this.f3943o, true);
        }
    }

    public final void J1(Function1<? super e4, Unit> function1) {
        this.f3943o = function1;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return false;
    }

    public String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.f3943o + ')';
    }
}
