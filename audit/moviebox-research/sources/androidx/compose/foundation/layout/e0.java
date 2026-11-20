package androidx.compose.foundation.layout;

import androidx.compose.runtime.f3;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class e0 {
    public static final void a(androidx.compose.ui.f fVar, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-72882467, i11, -1, "androidx.compose.foundation.layout.Spacer (Spacer.kt:38)");
        }
        SpacerMeasurePolicy spacerMeasurePolicy = SpacerMeasurePolicy.f2434a;
        int iA = androidx.compose.runtime.g.a(iVar, 0);
        androidx.compose.ui.f fVarE = ComposedModifierKt.e(iVar, fVar);
        androidx.compose.runtime.s sVarN = iVar.n();
        ComposeUiNode.Companion companion = ComposeUiNode.f4919a8;
        Function0<ComposeUiNode> function0A = companion.a();
        if (!(iVar.i() instanceof androidx.compose.runtime.f)) {
            androidx.compose.runtime.g.b();
        }
        iVar.D();
        if (iVar.e()) {
            iVar.G(function0A);
        } else {
            iVar.o();
        }
        androidx.compose.runtime.i iVarA = f3.a(iVar);
        f3.b(iVarA, spacerMeasurePolicy, companion.c());
        f3.b(iVarA, sVarN, companion.e());
        f3.b(iVarA, fVarE, companion.d());
        Function2<ComposeUiNode, Integer, Unit> function2B = companion.b();
        if (iVarA.e() || !Intrinsics.b(iVarA.y(), Integer.valueOf(iA))) {
            iVarA.p(Integer.valueOf(iA));
            iVarA.k(Integer.valueOf(iA), function2B);
        }
        iVar.r();
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
    }
}
