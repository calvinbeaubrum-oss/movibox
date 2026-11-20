package androidx.compose.ui.layout;

import androidx.compose.runtime.f3;
import androidx.compose.runtime.h2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class LayoutKt {
    @PublishedApi
    @JvmName
    public static final Function3<h2<ComposeUiNode>, androidx.compose.runtime.i, Integer, Unit> a(final androidx.compose.ui.f fVar) {
        return androidx.compose.runtime.internal.b.c(-1586257396, true, new Function3<h2<ComposeUiNode>, androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$materializerOf$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(h2<ComposeUiNode> h2Var, androidx.compose.runtime.i iVar, Integer num) {
                m56invokeDeg8D_g(h2Var.f(), iVar, num.intValue());
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m56invokeDeg8D_g(androidx.compose.runtime.i iVar, androidx.compose.runtime.i iVar2, int i11) {
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-1586257396, i11, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:205)");
                }
                int iA = androidx.compose.runtime.g.a(iVar2, 0);
                androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVar2, fVar);
                iVar.x(509942095);
                androidx.compose.runtime.i iVarA = f3.a(iVar);
                ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
                f3.b(iVarA, fVarE, companion.d());
                Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
                if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
                    iVarA.p(Integer.valueOf(iA));
                    iVarA.k(Integer.valueOf(iA), function2B);
                }
                iVar.P();
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
            }
        });
    }
}
