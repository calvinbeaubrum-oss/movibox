package com.applovin.impl;

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
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class ip {
    private static gp a(gp gpVar, Map map) {
        while (gpVar != null) {
            jp jpVarA = a(gpVar.f19282f, gpVar.c(), map);
            if (jpVarA != null && jpVarA.i() == 1) {
                return gpVar;
            }
            gpVar = gpVar.f19286j;
        }
        return null;
    }

    public static jp a(jp jpVar, String[] strArr, Map map) {
        int i11 = 0;
        if (jpVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (jp) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                jp jpVar2 = new jp();
                int length = strArr.length;
                while (i11 < length) {
                    jpVar2.a((jp) map.get(strArr[i11]));
                    i11++;
                }
                return jpVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return jpVar.a((jp) map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i11 < length2) {
                    jpVar.a((jp) map.get(strArr[i11]));
                    i11++;
                }
            }
        }
        return jpVar;
    }

    public static String a(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void a(Spannable spannable, int i11, int i12, jp jpVar, gp gpVar, Map map, int i13) {
        gp gpVarB;
        jp jpVarA;
        int i14;
        if (jpVar.k() != -1) {
            spannable.setSpan(new StyleSpan(jpVar.k()), i11, i12, 33);
        }
        if (jpVar.q()) {
            spannable.setSpan(new StrikethroughSpan(), i11, i12, 33);
        }
        if (jpVar.r()) {
            spannable.setSpan(new UnderlineSpan(), i11, i12, 33);
        }
        if (jpVar.p()) {
            pk.a(spannable, new ForegroundColorSpan(jpVar.b()), i11, i12, 33);
        }
        if (jpVar.o()) {
            pk.a(spannable, new BackgroundColorSpan(jpVar.a()), i11, i12, 33);
        }
        if (jpVar.c() != null) {
            pk.a(spannable, new TypefaceSpan(jpVar.c()), i11, i12, 33);
        }
        if (jpVar.n() != null) {
            xn xnVar = (xn) b1.a(jpVar.n());
            int i15 = xnVar.f24369a;
            if (i15 == -1) {
                i15 = (i13 == 2 || i13 == 1) ? 3 : 1;
                i14 = 1;
            } else {
                i14 = xnVar.f24370b;
            }
            int i16 = xnVar.f24371c;
            if (i16 == -2) {
                i16 = 1;
            }
            pk.a(spannable, new yn(i15, i14, i16), i11, i12, 33);
        }
        int i17 = jpVar.i();
        if (i17 == 2) {
            gp gpVarA = a(gpVar, map);
            if (gpVarA != null && (gpVarB = b(gpVarA, map)) != null) {
                if (gpVarB.a() != 1 || gpVarB.a(0).f19278b == null) {
                    pc.c("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) xp.a((Object) gpVarB.a(0).f19278b);
                    jp jpVarA2 = a(gpVarB.f19282f, gpVarB.c(), map);
                    int iH = jpVarA2 != null ? jpVarA2.h() : -1;
                    if (iH == -1 && (jpVarA = a(gpVarA.f19282f, gpVarA.c(), map)) != null) {
                        iH = jpVarA.h();
                    }
                    spannable.setSpan(new zi(str, iH), i11, i12, 33);
                }
            }
        } else if (i17 == 3 || i17 == 4) {
            spannable.setSpan(new o6(), i11, i12, 33);
        }
        if (jpVar.m()) {
            pk.a(spannable, new pa(), i11, i12, 33);
        }
        int iE = jpVar.e();
        if (iE == 1) {
            pk.a(spannable, new AbsoluteSizeSpan((int) jpVar.d(), true), i11, i12, 33);
        } else if (iE == 2) {
            pk.a(spannable, new RelativeSizeSpan(jpVar.d()), i11, i12, 33);
        } else {
            if (iE != 3) {
                return;
            }
            pk.a(spannable, new RelativeSizeSpan(jpVar.d() / 100.0f), i11, i12, 33);
        }
    }

    public static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static gp b(gp gpVar, Map map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gpVar);
        while (!arrayDeque.isEmpty()) {
            gp gpVar2 = (gp) arrayDeque.pop();
            jp jpVarA = a(gpVar2.f19282f, gpVar2.c(), map);
            if (jpVarA != null && jpVarA.i() == 3) {
                return gpVar2;
            }
            for (int iA = gpVar2.a() - 1; iA >= 0; iA--) {
                arrayDeque.push(gpVar2.a(iA));
            }
        }
        return null;
    }
}
