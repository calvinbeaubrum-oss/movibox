package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.e1;
import androidx.compose.ui.unit.LayoutDirection;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
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
public final class PaddingKt {
    public static final t a(float f11) {
        return new u(f11, f11, f11, f11, null);
    }

    public static final t b(float f11, float f12) {
        return new u(f11, f12, f11, f12, null);
    }

    public static /* synthetic */ t c(float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = q2.i.h(0);
        }
        if ((i11 & 2) != 0) {
            f12 = q2.i.h(0);
        }
        return b(f11, f12);
    }

    public static final float d(t tVar, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? tVar.c(layoutDirection) : tVar.b(layoutDirection);
    }

    public static final float e(t tVar, LayoutDirection layoutDirection) {
        return layoutDirection == LayoutDirection.Ltr ? tVar.b(layoutDirection) : tVar.c(layoutDirection);
    }

    public static final androidx.compose.ui.f f(androidx.compose.ui.f fVar, final float f11, final float f12) {
        return fVar.f(new PaddingElement(f11, f12, f11, f12, true, new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$2
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
                e1Var.b("padding");
                e1Var.a().b("horizontal", q2.i.c(f11));
                e1Var.a().b("vertical", q2.i.c(f12));
            }
        }, null));
    }

    public static /* synthetic */ androidx.compose.ui.f g(androidx.compose.ui.f fVar, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = q2.i.h(0);
        }
        if ((i11 & 2) != 0) {
            f12 = q2.i.h(0);
        }
        return f(fVar, f11, f12);
    }

    public static final androidx.compose.ui.f h(androidx.compose.ui.f fVar, final float f11, final float f12, final float f13, final float f14) {
        return fVar.f(new PaddingElement(f11, f12, f13, f14, true, new Function1<e1, Unit>() { // from class: androidx.compose.foundation.layout.PaddingKt$padding$1
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
                e1Var.b("padding");
                e1Var.a().b("start", q2.i.c(f11));
                e1Var.a().b("top", q2.i.c(f12));
                e1Var.a().b(TtmlNode.END, q2.i.c(f13));
                e1Var.a().b("bottom", q2.i.c(f14));
            }
        }, null));
    }

    public static /* synthetic */ androidx.compose.ui.f i(androidx.compose.ui.f fVar, float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = q2.i.h(0);
        }
        if ((i11 & 2) != 0) {
            f12 = q2.i.h(0);
        }
        if ((i11 & 4) != 0) {
            f13 = q2.i.h(0);
        }
        if ((i11 & 8) != 0) {
            f14 = q2.i.h(0);
        }
        return h(fVar, f11, f12, f13, f14);
    }
}
