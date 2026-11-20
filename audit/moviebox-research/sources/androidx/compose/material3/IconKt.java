package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.graphics.d4;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.n;
import androidx.compose.ui.semantics.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class IconKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.compose.ui.f f3194a = SizeKt.j(androidx.compose.ui.f.f3863a, q1.c.f74150a.a());

    public static final void a(final Painter painter, final String str, androidx.compose.ui.f fVar, long j11, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        long jU;
        int i13;
        androidx.compose.ui.f fVarC;
        Intrinsics.g(painter, "painter");
        androidx.compose.runtime.i iVarG = iVar.g(-2142239481);
        androidx.compose.ui.f fVar2 = (i12 & 4) != 0 ? androidx.compose.ui.f.f3863a : fVar;
        if ((i12 & 8) != 0) {
            i13 = i11 & (-7169);
            jU = ((w1) iVarG.l(ContentColorKt.a())).u();
        } else {
            jU = j11;
            i13 = i11;
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-2142239481, i13, -1, "androidx.compose.material3.Icon (Icon.kt:131)");
        }
        x1 x1VarB = w1.m(jU, w1.f4564b.e()) ? null : x1.a.b(x1.f4581b, jU, 0, 2, null);
        iVarG.x(69356817);
        if (str != null) {
            androidx.compose.ui.f.a aVar = androidx.compose.ui.f.f3863a;
            iVarG.x(1157296644);
            boolean zQ = iVarG.Q(str);
            Object objY = iVarG.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new Function1<q, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$semantics$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(q qVar) {
                        invoke2(qVar);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(q semantics) {
                        Intrinsics.g(semantics, "$this$semantics");
                        SemanticsPropertiesKt.v(semantics, str);
                        SemanticsPropertiesKt.B(semantics, androidx.compose.ui.semantics.i.f5649b.d());
                    }
                };
                iVarG.p(objY);
            }
            iVarG.P();
            fVarC = n.c(aVar, false, (Function1) objY, 1, null);
        } else {
            fVarC = androidx.compose.ui.f.f3863a;
        }
        androidx.compose.ui.f fVar3 = fVarC;
        iVarG.P();
        final long j12 = jU;
        BoxKt.a(androidx.compose.ui.draw.k.b(b(d4.c(fVar2), painter), painter, false, null, androidx.compose.ui.layout.f.f4870a.a(), 0.0f, x1VarB, 22, null).f(fVar3), iVarG, 0);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        final androidx.compose.ui.f fVar4 = fVar2;
        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.IconKt$Icon$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.runtime.i iVar2, int i14) {
                IconKt.a(painter, str, fVar4, j12, iVar2, v1.a(i11 | 1), i12);
            }
        });
    }

    public static final androidx.compose.ui.f b(androidx.compose.ui.f fVar, Painter painter) {
        return fVar.f((y1.m.f(painter.h(), y1.m.f81091b.a()) || c(painter.h())) ? f3194a : androidx.compose.ui.f.f3863a);
    }

    public static final boolean c(long j11) {
        return Float.isInfinite(y1.m.i(j11)) && Float.isInfinite(y1.m.g(j11));
    }
}
