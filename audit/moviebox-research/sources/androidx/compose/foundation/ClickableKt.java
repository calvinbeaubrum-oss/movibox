package androidx.compose.foundation;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public final class ClickableKt {
    public static final androidx.compose.ui.f a(androidx.compose.ui.f fVar, o1.i iVar, final x xVar, final boolean z11, final String str, final androidx.compose.ui.semantics.i iVar2, final Function0<Unit> function0) {
        androidx.compose.ui.f fVarF;
        if (xVar instanceof b0) {
            fVarF = new ClickableElement(iVar, (b0) xVar, z11, str, iVar2, function0, null);
        } else if (xVar == null) {
            fVarF = new ClickableElement(iVar, null, z11, str, iVar2, function0, null);
        } else {
            fVarF = iVar != null ? IndicationKt.b(androidx.compose.ui.f.f3863a, iVar, xVar).f(new ClickableElement(iVar, null, z11, str, iVar2, function0, null)) : ComposedModifierKt.c(androidx.compose.ui.f.f3863a, null, new Function3<androidx.compose.ui.f, androidx.compose.runtime.i, Integer, androidx.compose.ui.f>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final androidx.compose.ui.f invoke(androidx.compose.ui.f fVar2, androidx.compose.runtime.i iVar3, int i11) {
                    iVar3.R(-1525724089);
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.S(-1525724089, i11, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
                    }
                    Object objY = iVar3.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        objY = o1.h.a();
                        iVar3.p(objY);
                    }
                    o1.i iVar4 = (o1.i) objY;
                    androidx.compose.ui.f fVarF2 = IndicationKt.b(androidx.compose.ui.f.f3863a, iVar4, xVar).f(new ClickableElement(iVar4, null, z11, str, iVar2, function0, null));
                    if (androidx.compose.runtime.k.J()) {
                        androidx.compose.runtime.k.R();
                    }
                    iVar3.L();
                    return fVarF2;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ androidx.compose.ui.f invoke(androidx.compose.ui.f fVar2, androidx.compose.runtime.i iVar3, Integer num) {
                    return invoke(fVar2, iVar3, num.intValue());
                }
            }, 1, null);
        }
        return fVar.f(fVarF);
    }

    public static final androidx.compose.ui.f c(androidx.compose.ui.f fVar, final boolean z11, final String str, final androidx.compose.ui.semantics.i iVar, final Function0<Unit> function0) {
        return ComposedModifierKt.b(fVar, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
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
                e1Var.b("clickable");
                e1Var.a().b("enabled", Boolean.valueOf(z11));
                e1Var.a().b("onClickLabel", str);
                e1Var.a().b("role", iVar);
                e1Var.a().b("onClick", function0);
            }
        } : InspectableValueKt.a(), new Function3<androidx.compose.ui.f, androidx.compose.runtime.i, Integer, androidx.compose.ui.f>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final androidx.compose.ui.f invoke(androidx.compose.ui.f fVar2, androidx.compose.runtime.i iVar2, int i11) {
                o1.i iVar3;
                iVar2.R(-756081143);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.S(-756081143, i11, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:112)");
                }
                x xVar = (x) iVar2.l(IndicationKt.a());
                if (xVar instanceof b0) {
                    iVar2.R(617140216);
                    iVar2.L();
                    iVar3 = null;
                } else {
                    iVar2.R(617248189);
                    Object objY = iVar2.y();
                    if (objY == androidx.compose.runtime.i.f3413a.a()) {
                        objY = o1.h.a();
                        iVar2.p(objY);
                    }
                    iVar3 = (o1.i) objY;
                    iVar2.L();
                }
                androidx.compose.ui.f fVarA = ClickableKt.a(androidx.compose.ui.f.f3863a, iVar3, xVar, z11, str, iVar, function0);
                if (androidx.compose.runtime.k.J()) {
                    androidx.compose.runtime.k.R();
                }
                iVar2.L();
                return fVarA;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ androidx.compose.ui.f invoke(androidx.compose.ui.f fVar2, androidx.compose.runtime.i iVar2, Integer num) {
                return invoke(fVar2, iVar2, num.intValue());
            }
        });
    }

    public static /* synthetic */ androidx.compose.ui.f d(androidx.compose.ui.f fVar, boolean z11, String str, androidx.compose.ui.semantics.i iVar, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            iVar = null;
        }
        return c(fVar, z11, str, iVar, function0);
    }

    public static final boolean e(m1 m1Var) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        n1.c(m1Var, androidx.compose.foundation.gestures.l.f2366q, new Function1<m1, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$hasScrollableContainer$1
            {
                super(1);
            }

            /* JADX WARN: Code duplicated, block: B:8:0x0017  */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(m1 m1Var2) {
                boolean z11;
                Ref.BooleanRef booleanRef2 = booleanRef;
                if (booleanRef2.element) {
                    z11 = true;
                } else {
                    Intrinsics.e(m1Var2, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode");
                    if (((androidx.compose.foundation.gestures.l) m1Var2).H1()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                booleanRef2.element = z11;
                return Boolean.valueOf(!booleanRef.element);
            }
        });
        return booleanRef.element;
    }
}
