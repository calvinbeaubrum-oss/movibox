package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Deprecated;
import kotlin.Metadata;

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
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [int] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.view.inputmethod.CursorAnchorInfo$Builder] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final CursorAnchorInfo.Builder a(CursorAnchorInfo.Builder builder, int i11, int i12, v vVar, androidx.compose.ui.text.a0 a0Var, y1.i iVar) {
        ?? r11;
        int i13 = i11;
        int iA = vVar.a(i13);
        int iA2 = vVar.a(i12);
        float[] fArr = new float[(iA2 - iA) * 4];
        a0Var.v().a(androidx.compose.ui.text.d0.b(iA, iA2), fArr, 0);
        while (i13 < i12) {
            int iA3 = vVar.a(i13);
            int i14 = (iA3 - iA) * 4;
            y1.i iVar2 = new y1.i(fArr[i14], fArr[i14 + 1], fArr[i14 + 2], fArr[i14 + 3]);
            boolean zO = iVar.o(iVar2);
            if (!c(iVar, iVar2.f(), iVar2.i()) || !c(iVar, iVar2.g(), iVar2.c())) {
                r11 = zO;
                r11 = (zO ? 1 : 0) | 2;
            }
            r11 = zO;
            builder.addCharacterBounds(i13, iVar2.f(), iVar2.i(), iVar2.g(), iVar2.c(), a0Var.c(iA3) == ResolvedTextDirection.Rtl ? r11 | 4 : r11);
            i13++;
        }
        return builder;
    }

    @Deprecated
    public static final CursorAnchorInfo b(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, v vVar, androidx.compose.ui.text.a0 a0Var, Matrix matrix, y1.i iVar, y1.i iVar2, boolean z11, boolean z12, boolean z13, boolean z14) {
        builder.reset();
        builder.setMatrix(matrix);
        int iJ = androidx.compose.ui.text.c0.j(textFieldValue.c());
        builder.setSelectionRange(iJ, androidx.compose.ui.text.c0.i(textFieldValue.c()));
        if (z11) {
            d(builder, iJ, vVar, a0Var, iVar);
        }
        if (z12) {
            androidx.compose.ui.text.c0 c0VarB = textFieldValue.b();
            int iJ2 = c0VarB != null ? androidx.compose.ui.text.c0.j(c0VarB.n()) : -1;
            androidx.compose.ui.text.c0 c0VarB2 = textFieldValue.b();
            int i11 = c0VarB2 != null ? androidx.compose.ui.text.c0.i(c0VarB2.n()) : -1;
            if (iJ2 >= 0 && iJ2 < i11) {
                builder.setComposingText(iJ2, textFieldValue.d().subSequence(iJ2, i11));
                a(builder, iJ2, i11, vVar, a0Var, iVar);
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 33 && z13) {
            g.a(builder, iVar2);
        }
        if (i12 >= 34 && z14) {
            i.a(builder, a0Var, iVar);
        }
        return builder.build();
    }

    public static final boolean c(y1.i iVar, float f11, float f12) {
        float f13 = iVar.f();
        if (f11 <= iVar.g() && f13 <= f11) {
            float fI = iVar.i();
            if (f12 <= iVar.c() && fI <= f12) {
                return true;
            }
        }
        return false;
    }

    public static final CursorAnchorInfo.Builder d(CursorAnchorInfo.Builder builder, int i11, v vVar, androidx.compose.ui.text.a0 a0Var, y1.i iVar) {
        if (i11 < 0) {
            return builder;
        }
        int iA = vVar.a(i11);
        y1.i iVarE = a0Var.e(iA);
        float fJ = kotlin.ranges.a.j(iVarE.f(), 0.0f, q2.t.g(a0Var.y()));
        boolean zC = c(iVar, fJ, iVarE.i());
        boolean zC2 = c(iVar, fJ, iVarE.c());
        boolean z11 = a0Var.c(iA) == ResolvedTextDirection.Rtl;
        int i12 = (zC || zC2) ? 1 : 0;
        if (!zC || !zC2) {
            i12 |= 2;
        }
        builder.setInsertionMarkerLocation(fJ, iVarE.i(), iVarE.c(), iVarE.c(), z11 ? i12 | 4 : i12);
        return builder;
    }
}
