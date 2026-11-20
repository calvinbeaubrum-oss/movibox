package androidx.compose.material;

import androidx.compose.ui.layout.k0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.y;
import androidx.compose.ui.node.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class MinimumInteractiveModifierNode extends androidx.compose.ui.f.c implements androidx.compose.ui.node.d, x {
    @Override // androidx.compose.ui.node.x
    public w C(y yVar, t tVar, long j11) {
        boolean z11 = o1() && ((Boolean) androidx.compose.ui.node.e.a(this, InteractiveComponentSizeKt.b())).booleanValue();
        long j12 = InteractiveComponentSizeKt.f3038c;
        final k0 k0VarL = tVar.L(j11);
        final int iMax = z11 ? Math.max(k0VarL.s0(), yVar.k0(q2.l.d(j12))) : k0VarL.s0();
        final int iMax2 = z11 ? Math.max(k0VarL.g0(), yVar.k0(q2.l.c(j12))) : k0VarL.g0();
        return androidx.compose.ui.layout.x.b(yVar, iMax, iMax2, null, new Function1<k0.a, Unit>() { // from class: androidx.compose.material.MinimumInteractiveModifierNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar) {
                k0.a.h(aVar, k0VarL, a20.b.d((iMax - k0VarL.s0()) / 2.0f), a20.b.d((iMax2 - k0VarL.g0()) / 2.0f), 0.0f, 4, null);
            }
        }, 4, null);
    }
}
