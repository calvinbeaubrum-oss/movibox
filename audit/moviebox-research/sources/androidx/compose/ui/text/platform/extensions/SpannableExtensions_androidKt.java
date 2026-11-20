package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LocaleSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.graphics.a5;
import androidx.compose.ui.graphics.b5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.y1;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.i;
import androidx.compose.ui.text.font.q;
import androidx.compose.ui.text.font.r;
import androidx.compose.ui.text.font.u;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.n;
import n2.l;
import n2.o;
import q2.w;
import q2.x;
import q2.y;
import z1.h;

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
public final class SpannableExtensions_androidKt {
    public static final MetricAffectingSpan a(long j11, q2.e eVar) {
        long jG = w.g(j11);
        y.a aVar = y.f74261b;
        if (y.g(jG, aVar.b())) {
            return new n2.f(eVar.p0(j11));
        }
        if (y.g(jG, aVar.a())) {
            return new n2.e(w.h(j11));
        }
        return null;
    }

    public static final void b(androidx.compose.ui.text.y yVar, List<AnnotatedString.b<androidx.compose.ui.text.y>> list, Function3<? super androidx.compose.ui.text.y, ? super Integer, ? super Integer, Unit> function3) {
        if (list.size() <= 1) {
            if (!list.isEmpty()) {
                function3.invoke(f(yVar, list.get(0).e()), Integer.valueOf(list.get(0).f()), Integer.valueOf(list.get(0).d()));
                return;
            }
            return;
        }
        int size = list.size();
        int i11 = size * 2;
        Integer[] numArr = new Integer[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            numArr[i12] = 0;
        }
        int size2 = list.size();
        for (int i13 = 0; i13 < size2; i13++) {
            AnnotatedString.b<androidx.compose.ui.text.y> bVar = list.get(i13);
            numArr[i13] = Integer.valueOf(bVar.f());
            numArr[i13 + size] = Integer.valueOf(bVar.d());
        }
        ArraysKt___ArraysJvmKt.B(numArr);
        int iIntValue = ((Number) kotlin.collections.d.O(numArr)).intValue();
        for (int i14 = 0; i14 < i11; i14++) {
            int iIntValue2 = numArr[i14].intValue();
            if (iIntValue2 != iIntValue) {
                int size3 = list.size();
                androidx.compose.ui.text.y yVarF = yVar;
                for (int i15 = 0; i15 < size3; i15++) {
                    AnnotatedString.b<androidx.compose.ui.text.y> bVar2 = list.get(i15);
                    if (bVar2.f() != bVar2.d() && androidx.compose.ui.text.d.f(iIntValue, iIntValue2, bVar2.f(), bVar2.d())) {
                        yVarF = f(yVarF, bVar2.e());
                    }
                }
                if (yVarF != null) {
                    function3.invoke(yVarF, Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2));
                }
                iIntValue = iIntValue2;
            }
        }
    }

    public static final boolean c(androidx.compose.ui.text.y yVar) {
        long jG = w.g(yVar.o());
        y.a aVar = y.f74261b;
        return y.g(jG, aVar.b()) || y.g(w.g(yVar.o()), aVar.a());
    }

    public static final boolean d(e0 e0Var) {
        return f.d(e0Var.M()) || e0Var.n() != null;
    }

    public static final boolean e(q2.e eVar) {
        return ((double) eVar.M0()) > 1.05d;
    }

    public static final androidx.compose.ui.text.y f(androidx.compose.ui.text.y yVar, androidx.compose.ui.text.y yVar2) {
        return yVar == null ? yVar2 : yVar.x(yVar2);
    }

    public static final float g(long j11, float f11, q2.e eVar) {
        float fH;
        long jG = w.g(j11);
        y.a aVar = y.f74261b;
        if (y.g(jG, aVar.b())) {
            if (!e(eVar)) {
                return eVar.p0(j11);
            }
            fH = w.h(j11) / w.h(eVar.X(f11));
        } else {
            if (!y.g(jG, aVar.a())) {
                return Float.NaN;
            }
            fH = w.h(j11);
        }
        return fH * f11;
    }

    public static final void h(Spannable spannable, long j11, int i11, int i12) {
        if (j11 != 16) {
            u(spannable, new BackgroundColorSpan(y1.j(j11)), i11, i12);
        }
    }

    public static final void i(Spannable spannable, androidx.compose.ui.text.style.a aVar, int i11, int i12) {
        if (aVar != null) {
            u(spannable, new n2.a(aVar.h()), i11, i12);
        }
    }

    public static final void j(Spannable spannable, l1 l1Var, float f11, int i11, int i12) {
        if (l1Var != null) {
            if (l1Var instanceof d5) {
                k(spannable, ((d5) l1Var).b(), i11, i12);
            } else if (l1Var instanceof a5) {
                u(spannable, new ShaderBrushSpan((a5) l1Var, f11), i11, i12);
            }
        }
    }

    public static final void k(Spannable spannable, long j11, int i11, int i12) {
        if (j11 != 16) {
            u(spannable, new ForegroundColorSpan(y1.j(j11)), i11, i12);
        }
    }

    public static final void l(Spannable spannable, h hVar, int i11, int i12) {
        if (hVar != null) {
            u(spannable, new androidx.compose.ui.text.platform.style.a(hVar), i11, i12);
        }
    }

    public static final void m(final Spannable spannable, e0 e0Var, List<AnnotatedString.b<androidx.compose.ui.text.y>> list, final Function4<? super i, ? super u, ? super q, ? super r, ? extends Typeface> function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.b<androidx.compose.ui.text.y> bVar = list.get(i11);
            AnnotatedString.b<androidx.compose.ui.text.y> bVar2 = bVar;
            if (f.d(bVar2.e()) || bVar2.e().m() != null) {
                arrayList.add(bVar);
            }
        }
        b(d(e0Var) ? new androidx.compose.ui.text.y(0L, 0L, e0Var.o(), e0Var.m(), e0Var.n(), e0Var.j(), null, 0L, null, null, null, 0L, null, null, null, null, 65475, null) : null, arrayList, new Function3<androidx.compose.ui.text.y, Integer, Integer, Unit>() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$setFontAttributes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.ui.text.y yVar, Integer num, Integer num2) {
                invoke(yVar, num.intValue(), num2.intValue());
                return Unit.f68710a;
            }

            public final void invoke(androidx.compose.ui.text.y yVar, int i12, int i13) {
                Spannable spannable2 = spannable;
                Function4<i, u, q, r, Typeface> function5 = function4;
                i iVarI = yVar.i();
                u uVarN = yVar.n();
                if (uVarN == null) {
                    uVarN = u.f5860b.a();
                }
                q qVarL = yVar.l();
                q qVarC = q.c(qVarL != null ? qVarL.i() : q.f5850b.b());
                r rVarM = yVar.m();
                spannable2.setSpan(new o(function5.invoke(iVarI, uVarN, qVarC, r.b(rVarM != null ? rVarM.j() : r.f5854b.a()))), i12, i13, 33);
            }
        });
    }

    public static final void n(Spannable spannable, String str, int i11, int i12) {
        if (str != null) {
            u(spannable, new n2.b(str), i11, i12);
        }
    }

    public static final void o(Spannable spannable, long j11, q2.e eVar, int i11, int i12) {
        long jG = w.g(j11);
        y.a aVar = y.f74261b;
        if (y.g(jG, aVar.b())) {
            u(spannable, new AbsoluteSizeSpan(a20.b.d(eVar.p0(j11)), false), i11, i12);
        } else if (y.g(jG, aVar.a())) {
            u(spannable, new RelativeSizeSpan(w.h(j11)), i11, i12);
        }
    }

    public static final void p(Spannable spannable, m mVar, int i11, int i12) {
        if (mVar != null) {
            u(spannable, new ScaleXSpan(mVar.b()), i11, i12);
            u(spannable, new n2.m(mVar.c()), i11, i12);
        }
    }

    public static final void q(Spannable spannable, long j11, float f11, q2.e eVar, androidx.compose.ui.text.style.g gVar) {
        float fG = g(j11, f11, eVar);
        if (Float.isNaN(fG)) {
            return;
        }
        u(spannable, new n2.h(fG, 0, (spannable.length() == 0 || n.f1(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), androidx.compose.ui.text.style.g.c.e(gVar.c()), androidx.compose.ui.text.style.g.c.f(gVar.c()), gVar.b()), 0, spannable.length());
    }

    public static final void r(Spannable spannable, long j11, float f11, q2.e eVar) {
        float fG = g(j11, f11, eVar);
        if (Float.isNaN(fG)) {
            return;
        }
        u(spannable, new n2.g(fG), 0, spannable.length());
    }

    public static final void s(Spannable spannable, p2.i iVar, int i11, int i12) {
        Object localeSpan;
        if (iVar != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                localeSpan = d.f6020a.a(iVar);
            } else {
                localeSpan = new LocaleSpan((iVar.isEmpty() ? p2.h.f73510b.a() : iVar.f(0)).a());
            }
            u(spannable, localeSpan, i11, i12);
        }
    }

    public static final void t(Spannable spannable, b5 b5Var, int i11, int i12) {
        if (b5Var != null) {
            u(spannable, new l(y1.j(b5Var.c()), y1.g.m(b5Var.d()), y1.g.n(b5Var.d()), f.b(b5Var.b())), i11, i12);
        }
    }

    public static final void u(Spannable spannable, Object obj, int i11, int i12) {
        spannable.setSpan(obj, i11, i12, 33);
    }

    public static final void v(Spannable spannable, AnnotatedString.b<androidx.compose.ui.text.y> bVar, q2.e eVar) {
        int iF = bVar.f();
        int iD = bVar.d();
        androidx.compose.ui.text.y yVarE = bVar.e();
        i(spannable, yVarE.e(), iF, iD);
        k(spannable, yVarE.g(), iF, iD);
        j(spannable, yVarE.f(), yVarE.c(), iF, iD);
        x(spannable, yVarE.s(), iF, iD);
        o(spannable, yVarE.k(), eVar, iF, iD);
        n(spannable, yVarE.j(), iF, iD);
        p(spannable, yVarE.u(), iF, iD);
        s(spannable, yVarE.p(), iF, iD);
        h(spannable, yVarE.d(), iF, iD);
        t(spannable, yVarE.r(), iF, iD);
        l(spannable, yVarE.h(), iF, iD);
    }

    public static final void w(Spannable spannable, e0 e0Var, List<AnnotatedString.b<androidx.compose.ui.text.y>> list, q2.e eVar, Function4<? super i, ? super u, ? super q, ? super r, ? extends Typeface> function4) {
        MetricAffectingSpan metricAffectingSpanA;
        m(spannable, e0Var, list, function4);
        int size = list.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.b<androidx.compose.ui.text.y> bVar = list.get(i11);
            int iF = bVar.f();
            int iD = bVar.d();
            if (iF >= 0 && iF < spannable.length() && iD > iF && iD <= spannable.length()) {
                v(spannable, bVar, eVar);
                if (c(bVar.e())) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            int size2 = list.size();
            for (int i12 = 0; i12 < size2; i12++) {
                AnnotatedString.b<androidx.compose.ui.text.y> bVar2 = list.get(i12);
                int iF2 = bVar2.f();
                int iD2 = bVar2.d();
                androidx.compose.ui.text.y yVarE = bVar2.e();
                if (iF2 >= 0 && iF2 < spannable.length() && iD2 > iF2 && iD2 <= spannable.length() && (metricAffectingSpanA = a(yVarE.o(), eVar)) != null) {
                    u(spannable, metricAffectingSpanA, iF2, iD2);
                }
            }
        }
    }

    public static final void x(Spannable spannable, androidx.compose.ui.text.style.i iVar, int i11, int i12) {
        if (iVar != null) {
            androidx.compose.ui.text.style.i.a aVar = androidx.compose.ui.text.style.i.f6110b;
            u(spannable, new n2.n(iVar.d(aVar.c()), iVar.d(aVar.a())), i11, i12);
        }
    }

    public static final void y(Spannable spannable, androidx.compose.ui.text.style.n nVar, float f11, q2.e eVar) {
        float fH;
        if (nVar != null) {
            if ((w.e(nVar.b(), x.c(0)) && w.e(nVar.c(), x.c(0))) || x.d(nVar.b()) || x.d(nVar.c())) {
                return;
            }
            long jG = w.g(nVar.b());
            y.a aVar = y.f74261b;
            float fH2 = 0.0f;
            if (y.g(jG, aVar.b())) {
                fH = eVar.p0(nVar.b());
            } else {
                fH = y.g(jG, aVar.a()) ? w.h(nVar.b()) * f11 : 0.0f;
            }
            long jG2 = w.g(nVar.c());
            if (y.g(jG2, aVar.b())) {
                fH2 = eVar.p0(nVar.c());
            } else if (y.g(jG2, aVar.a())) {
                fH2 = w.h(nVar.c()) * f11;
            }
            u(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fH), (int) Math.ceil(fH2)), 0, spannable.length());
        }
    }
}
