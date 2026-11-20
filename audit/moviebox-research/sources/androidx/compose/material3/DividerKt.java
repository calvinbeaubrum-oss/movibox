package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.g2;
import androidx.compose.runtime.v1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class DividerKt {
    public static final void a(androidx.compose.ui.f fVar, float f11, long j11, androidx.compose.runtime.i iVar, final int i11, final int i12) {
        int i13;
        androidx.compose.runtime.i iVarG = iVar.g(1562471785);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            i13 = (iVarG.Q(fVar) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        int i15 = i12 & 2;
        if (i15 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            i13 |= iVarG.b(f11) ? 32 : 16;
        }
        if ((i11 & 896) == 0) {
            i13 |= ((i12 & 4) == 0 && iVarG.d(j11)) ? 256 : 128;
        }
        if ((i13 & 731) == 146 && iVarG.h()) {
            iVarG.H();
        } else {
            iVarG.B();
            if ((i11 & 1) == 0 || iVarG.J()) {
                if (i14 != 0) {
                    fVar = androidx.compose.ui.f.f3863a;
                }
                if (i15 != 0) {
                    f11 = d.f3223a.b();
                }
                if ((i12 & 4) != 0) {
                    j11 = d.f3223a.a(iVarG, 6);
                }
            } else {
                iVarG.H();
            }
            iVarG.s();
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.S(1562471785, i11, -1, "androidx.compose.material3.Divider (Divider.kt:43)");
            }
            iVarG.x(1232935509);
            float fH = q2.i.j(f11, q2.i.f74232b.a()) ? q2.i.h(1.0f / ((q2.e) iVarG.l(CompositionLocalsKt.c())).getDensity()) : f11;
            iVarG.P();
            BoxKt.a(BackgroundKt.b(SizeKt.e(SizeKt.d(fVar, 0.0f, 1, null), fH), j11, null, 2, null), iVarG, 0);
            if (androidx.compose.runtime.k.J()) {
                androidx.compose.runtime.k.R();
            }
        }
        final androidx.compose.ui.f fVar2 = fVar;
        final float f12 = f11;
        final long j12 = j11;
        g2 g2VarJ = iVarG.j();
        if (g2VarJ == null) {
            return;
        }
        g2VarJ.a(new Function2<androidx.compose.runtime.i, Integer, Unit>() { // from class: androidx.compose.material3.DividerKt$Divider$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.runtime.i iVar2, Integer num) {
                invoke(iVar2, num.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.runtime.i iVar2, int i16) {
                DividerKt.a(fVar2, f12, j12, iVar2, v1.a(i11 | 1), i12);
            }
        });
    }
}
