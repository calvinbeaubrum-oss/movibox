package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.u;
import androidx.compose.ui.text.font.x;
import androidx.compose.ui.text.g0;
import androidx.compose.ui.text.h0;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.y;
import java.util.List;
import kotlin.Metadata;
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
public final class a {
    public static final void a(SpannableString spannableString, y yVar, int i11, int i12, q2.e eVar, androidx.compose.ui.text.font.i.b bVar) {
        SpannableExtensions_androidKt.k(spannableString, yVar.g(), i11, i12);
        SpannableExtensions_androidKt.o(spannableString, yVar.k(), eVar, i11, i12);
        if (yVar.n() != null || yVar.l() != null) {
            u uVarN = yVar.n();
            if (uVarN == null) {
                uVarN = u.f5860b.a();
            }
            androidx.compose.ui.text.font.q qVarL = yVar.l();
            spannableString.setSpan(new StyleSpan(androidx.compose.ui.text.font.e.c(uVarN, qVarL != null ? qVarL.i() : androidx.compose.ui.text.font.q.f5850b.b())), i11, i12, 33);
        }
        if (yVar.i() != null) {
            if (yVar.i() instanceof x) {
                spannableString.setSpan(new TypefaceSpan(((x) yVar.i()).f()), i11, i12, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                androidx.compose.ui.text.font.i iVarI = yVar.i();
                androidx.compose.ui.text.font.r rVarM = yVar.m();
                Object value = androidx.compose.ui.text.font.j.a(bVar, iVarI, null, 0, rVarM != null ? rVarM.j() : androidx.compose.ui.text.font.r.f5854b.a(), 6, null).getValue();
                Intrinsics.e(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(h.f6021a.a((Typeface) value), i11, i12, 33);
            }
        }
        if (yVar.s() != null) {
            androidx.compose.ui.text.style.i iVarS = yVar.s();
            androidx.compose.ui.text.style.i.a aVar = androidx.compose.ui.text.style.i.f6110b;
            if (iVarS.d(aVar.c())) {
                spannableString.setSpan(new UnderlineSpan(), i11, i12, 33);
            }
            if (yVar.s().d(aVar.a())) {
                spannableString.setSpan(new StrikethroughSpan(), i11, i12, 33);
            }
        }
        if (yVar.u() != null) {
            spannableString.setSpan(new ScaleXSpan(yVar.u().b()), i11, i12, 33);
        }
        SpannableExtensions_androidKt.s(spannableString, yVar.p(), i11, i12);
        SpannableExtensions_androidKt.h(spannableString, yVar.d(), i11, i12);
    }

    public static final SpannableString b(AnnotatedString annotatedString, q2.e eVar, androidx.compose.ui.text.font.i.b bVar, s sVar) {
        SpannableString spannableString = new SpannableString(annotatedString.i());
        List<AnnotatedString.b<y>> listH = annotatedString.h();
        if (listH != null) {
            int size = listH.size();
            for (int i11 = 0; i11 < size; i11++) {
                AnnotatedString.b<y> bVar2 = listH.get(i11);
                y yVarA = bVar2.a();
                a(spannableString, y.b(yVarA, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65503, null), bVar2.b(), bVar2.c(), eVar, bVar);
            }
        }
        List<AnnotatedString.b<g0>> listJ = annotatedString.j(0, annotatedString.length());
        int size2 = listJ.size();
        for (int i12 = 0; i12 < size2; i12++) {
            AnnotatedString.b<g0> bVar3 = listJ.get(i12);
            g0 g0VarA = bVar3.a();
            spannableString.setSpan(androidx.compose.ui.text.platform.extensions.g.a(g0VarA), bVar3.b(), bVar3.c(), 33);
        }
        List<AnnotatedString.b<h0>> listK = annotatedString.k(0, annotatedString.length());
        int size3 = listK.size();
        for (int i13 = 0; i13 < size3; i13++) {
            AnnotatedString.b<h0> bVar4 = listK.get(i13);
            h0 h0VarA = bVar4.a();
            spannableString.setSpan(sVar.c(h0VarA), bVar4.b(), bVar4.c(), 33);
        }
        List<AnnotatedString.b<androidx.compose.ui.text.f>> listD = annotatedString.d(0, annotatedString.length());
        int size4 = listD.size();
        for (int i14 = 0; i14 < size4; i14++) {
            AnnotatedString.b<androidx.compose.ui.text.f> bVar5 = listD.get(i14);
            if (bVar5.f() != bVar5.d()) {
                androidx.compose.ui.text.f fVarE = bVar5.e();
                if (fVarE instanceof androidx.compose.ui.text.f.b) {
                    fVarE.a();
                    spannableString.setSpan(sVar.b(c(bVar5)), bVar5.f(), bVar5.d(), 33);
                } else {
                    spannableString.setSpan(sVar.a(bVar5), bVar5.f(), bVar5.d(), 33);
                }
            }
        }
        return spannableString;
    }

    public static final AnnotatedString.b<androidx.compose.ui.text.f.b> c(AnnotatedString.b<androidx.compose.ui.text.f> bVar) {
        androidx.compose.ui.text.f fVarE = bVar.e();
        Intrinsics.e(fVarE, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new AnnotatedString.b<>((androidx.compose.ui.text.f.b) fVarE, bVar.f(), bVar.d());
    }
}
