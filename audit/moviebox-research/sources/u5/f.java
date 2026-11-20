package u5;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Map;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static void a(Spannable spannable, int i11, int i12, g gVar, @Nullable c cVar, Map<String, g> map, int i13) {
        c cVarE;
        g gVarF;
        int i14;
        if (gVar.l() != -1) {
            spannable.setSpan(new StyleSpan(gVar.l()), i11, i12, 33);
        }
        if (gVar.s()) {
            spannable.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (gVar.t()) {
            spannable.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (gVar.q()) {
            y3.g.a(spannable, new ForegroundColorSpan(gVar.c()), i11, i12, 33);
        }
        if (gVar.p()) {
            y3.g.a(spannable, new BackgroundColorSpan(gVar.b()), i11, i12, 33);
        }
        if (gVar.d() != null) {
            y3.g.a(spannable, new TypefaceSpan(gVar.d()), i11, i12, 33);
        }
        if (gVar.o() != null) {
            b bVar = (b) z3.a.e(gVar.o());
            int i15 = bVar.f78420a;
            if (i15 == -1) {
                i15 = (i13 == 2 || i13 == 1) ? 3 : 1;
                i14 = 1;
            } else {
                i14 = bVar.f78421b;
            }
            int i16 = bVar.f78422c;
            if (i16 == -2) {
                i16 = 1;
            }
            y3.g.a(spannable, new y3.h(i15, i14, i16), i11, i12, 33);
        }
        int iJ = gVar.j();
        if (iJ == 2) {
            c cVarD = d(cVar, map);
            if (cVarD != null && (cVarE = e(cVarD, map)) != null) {
                if (cVarE.g() != 1 || cVarE.f(0).f78424b == null) {
                    o.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) u0.i(cVarE.f(0).f78424b);
                    g gVarF2 = f(cVarE.f78428f, cVarE.l(), map);
                    int i17 = gVarF2 != null ? gVarF2.i() : -1;
                    if (i17 == -1 && (gVarF = f(cVarD.f78428f, cVarD.l(), map)) != null) {
                        i17 = gVarF.i();
                    }
                    spannable.setSpan(new y3.f(str, i17), i11, i12, 33);
                }
            }
        } else if (iJ == 3 || iJ == 4) {
            spannable.setSpan(new a(), i11, i12, 33);
        }
        if (gVar.n()) {
            y3.g.a(spannable, new y3.d(), i11, i12, 33);
        }
        int iF = gVar.f();
        if (iF == 1) {
            y3.g.a(spannable, new AbsoluteSizeSpan((int) gVar.e(), true), i11, i12, 33);
        } else if (iF == 2) {
            y3.g.a(spannable, new RelativeSizeSpan(gVar.e()), i11, i12, 33);
        } else {
            if (iF != 3) {
                return;
            }
            y3.g.a(spannable, new RelativeSizeSpan(gVar.e() / 100.0f), i11, i12, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    @Nullable
    public static c d(@Nullable c cVar, Map<String, g> map) {
        while (cVar != null) {
            g gVarF = f(cVar.f78428f, cVar.l(), map);
            if (gVarF != null && gVarF.j() == 1) {
                return cVar;
            }
            cVar = cVar.f78432j;
        }
        return null;
    }

    @Nullable
    public static c e(c cVar, Map<String, g> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(cVar);
        while (!arrayDeque.isEmpty()) {
            c cVar2 = (c) arrayDeque.pop();
            g gVarF = f(cVar2.f78428f, cVar2.l(), map);
            if (gVarF != null && gVarF.j() == 3) {
                return cVar2;
            }
            for (int iG = cVar2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(cVar2.f(iG));
            }
        }
        return null;
    }

    @Nullable
    public static g f(@Nullable g gVar, @Nullable String[] strArr, Map<String, g> map) {
        int i11 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i11 < length) {
                    gVar2.a(map.get(strArr[i11]));
                    i11++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i11 < length2) {
                    gVar.a(map.get(strArr[i11]));
                    i11++;
                }
            }
        }
        return gVar;
    }
}
