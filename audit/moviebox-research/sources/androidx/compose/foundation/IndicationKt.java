package androidx.compose.foundation;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
public final class IndicationKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<x> f2249a = CompositionLocalKt.f(new Function0<x>() { // from class: androidx.compose.foundation.IndicationKt$LocalIndication$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x invoke() {
            return DefaultDebugIndication.f2222a;
        }
    });

    public static final s1<x> a() {
        return f2249a;
    }

    public static final androidx.compose.ui.f b(androidx.compose.ui.f fVar, final o1.g gVar, final x xVar) {
        if (xVar == null) {
            return fVar;
        }
        if (xVar instanceof b0) {
            return fVar.f(new IndicationModifierElement(gVar, (b0) xVar));
        }
        return ComposedModifierKt.b(fVar, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.IndicationKt$indication$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                invoke2(e1Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e1 e1Var) {
                e1Var.b("indication");
                e1Var.a().b("interactionSource", gVar);
                e1Var.a().b("indication", xVar);
            }
        } : InspectableValueKt.a(), new Function3<androidx.compose.ui.f, androidx.compose.runtime.i, Integer, androidx.compose.ui.f>() { // from class: androidx.compose.foundation.IndicationKt$indication$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final androidx.compose.ui.f invoke(androidx.compose.ui.f fVar2, androidx.compose.runtime.i iVar, int i11) {
                iVar.R(-353972293);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-353972293, i11, -1, "androidx.compose.foundation.indication.<anonymous> (Indication.kt:182)");
                }
                y yVarB = xVar.b(gVar, iVar, 0);
                boolean zQ = iVar.Q(yVarB);
                Object objY = iVar.y();
                if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                    objY = new z(yVarB);
                    iVar.p(objY);
                }
                z zVar = (z) objY;
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                iVar.L();
                return zVar;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ androidx.compose.ui.f invoke(androidx.compose.ui.f fVar2, androidx.compose.runtime.i iVar, Integer num) {
                return invoke(fVar2, iVar, num.intValue());
            }
        });
    }
}
