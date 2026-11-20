package m2;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import com.google.android.gms.common.api.Api;
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
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f70674a = new r1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f70675b = a(0, 0);

    public static final long a(int i11, int i12) {
        return u1.a((((long) i12) & 4294967295L) | (((long) i11) << 32));
    }

    public static final Paint.FontMetricsInt h(s1 s1Var, TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, n2.h[] hVarArr) {
        int iL = s1Var.l() - 1;
        if (s1Var.h().getLineStart(iL) != s1Var.h().getLineEnd(iL) || hVarArr == null || hVarArr.length == 0) {
            return null;
        }
        SpannableString spannableString = new SpannableString("\u200b");
        n2.h hVar = (n2.h) kotlin.collections.d.O(hVarArr);
        spannableString.setSpan(hVar.b(0, spannableString.length(), (iL == 0 || !hVar.e()) ? hVar.e() : false), 0, spannableString.length(), 33);
        StaticLayout staticLayoutA = m1.f70625a.a(spannableString, textPaint, Api.BaseClientBuilder.API_PRIORITY_OTHER, (2072512 & 8) != 0 ? 0 : 0, (2072512 & 16) != 0 ? spannableString.length() : spannableString.length(), (2072512 & 32) != 0 ? f0.f70602a.b() : textDirectionHeuristic, (2072512 & 64) != 0 ? f0.f70602a.a() : null, (2072512 & 128) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 0, (2072512 & 256) != 0 ? null : null, (2072512 & 512) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 0, (2072512 & 1024) != 0 ? 1.0f : 0.0f, (2072512 & 2048) != 0 ? 0.0f : 0.0f, (2072512 & 4096) != 0 ? 0 : 0, (2072512 & 8192) != 0 ? false : s1Var.g(), (2072512 & 16384) != 0 ? true : s1Var.d(), (32768 & 2072512) != 0 ? 0 : 0, (65536 & 2072512) != 0 ? 0 : 0, (131072 & 2072512) != 0 ? 0 : 0, (262144 & 2072512) != 0 ? 0 : 0, (524288 & 2072512) != 0 ? null : null, (2072512 & 1048576) != 0 ? null : null);
        Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
        fontMetricsInt.ascent = staticLayoutA.getLineAscent(0);
        fontMetricsInt.descent = staticLayoutA.getLineDescent(0);
        fontMetricsInt.top = staticLayoutA.getLineTop(0);
        fontMetricsInt.bottom = staticLayoutA.getLineBottom(0);
        return fontMetricsInt;
    }

    public static final long i(n2.h[] hVarArr) {
        int iMax = 0;
        int iMax2 = 0;
        for (n2.h hVar : hVarArr) {
            if (hVar.c() < 0) {
                iMax = Math.max(iMax, Math.abs(hVar.c()));
            }
            if (hVar.d() < 0) {
                iMax2 = Math.max(iMax, Math.abs(hVar.d()));
            }
        }
        return (iMax == 0 && iMax2 == 0) ? f70675b : a(iMax, iMax2);
    }

    public static final n2.h[] j(s1 s1Var) {
        if (!(s1Var.C() instanceof Spanned)) {
            return null;
        }
        CharSequence charSequenceC = s1Var.C();
        Intrinsics.e(charSequenceC, "null cannot be cast to non-null type android.text.Spanned");
        if (!o0.a((Spanned) charSequenceC, n2.h.class) && s1Var.C().length() > 0) {
            return null;
        }
        CharSequence charSequenceC2 = s1Var.C();
        Intrinsics.e(charSequenceC2, "null cannot be cast to non-null type android.text.Spanned");
        return (n2.h[]) ((Spanned) charSequenceC2).getSpans(0, s1Var.C().length(), n2.h.class);
    }

    public static final TextDirectionHeuristic k(int i11) {
        if (i11 == 0) {
            return TextDirectionHeuristics.LTR;
        }
        if (i11 == 1) {
            return TextDirectionHeuristics.RTL;
        }
        if (i11 == 2) {
            return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        if (i11 == 3) {
            return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        }
        if (i11 != 4) {
            return i11 != 5 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : TextDirectionHeuristics.LOCALE;
        }
        return TextDirectionHeuristics.ANYRTL_LTR;
    }

    public static final long l(s1 s1Var) {
        if (s1Var.g() || s1Var.D()) {
            return f70675b;
        }
        TextPaint paint = s1Var.h().getPaint();
        CharSequence text = s1Var.h().getText();
        Rect rectC = n0.c(paint, text, s1Var.h().getLineStart(0), s1Var.h().getLineEnd(0));
        int lineAscent = s1Var.h().getLineAscent(0);
        int i11 = rectC.top;
        int topPadding = i11 < lineAscent ? lineAscent - i11 : s1Var.h().getTopPadding();
        if (s1Var.l() != 1) {
            int iL = s1Var.l() - 1;
            rectC = n0.c(paint, text, s1Var.h().getLineStart(iL), s1Var.h().getLineEnd(iL));
        }
        int lineDescent = s1Var.h().getLineDescent(s1Var.l() - 1);
        int i12 = rectC.bottom;
        int bottomPadding = i12 > lineDescent ? i12 - lineDescent : s1Var.h().getBottomPadding();
        return (topPadding == 0 && bottomPadding == 0) ? f70675b : a(topPadding, bottomPadding);
    }

    public static final boolean m(Layout layout, int i11) {
        return layout.getEllipsisCount(i11) > 0;
    }
}
