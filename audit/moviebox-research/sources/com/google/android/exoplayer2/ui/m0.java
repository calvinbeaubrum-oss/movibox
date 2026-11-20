package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m0 {
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof zh.b);
    }

    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(vh.b.C0875b c0875b) {
        c0875b.b();
        if (c0875b.e() instanceof Spanned) {
            if (!(c0875b.e() instanceof Spannable)) {
                c0875b.o(SpannableString.valueOf(c0875b.e()));
            }
            g((Spannable) com.google.android.exoplayer2.util.a.e(c0875b.e()), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.ui.l0
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return m0.c(obj);
                }
            });
        }
        f(c0875b);
    }

    public static void f(vh.b.C0875b c0875b) {
        c0875b.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (c0875b.e() instanceof Spanned) {
            if (!(c0875b.e() instanceof Spannable)) {
                c0875b.o(SpannableString.valueOf(c0875b.e()));
            }
            g((Spannable) com.google.android.exoplayer2.util.a.e(c0875b.e()), new com.google.common.base.n() { // from class: com.google.android.exoplayer2.ui.k0
                @Override // com.google.common.base.n
                public final boolean apply(Object obj) {
                    return m0.d(obj);
                }
            });
        }
    }

    public static void g(Spannable spannable, com.google.common.base.n<Object> nVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (nVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i11, float f11, int i12, int i13) {
        float f12;
        if (f11 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i11 == 0) {
            f12 = i13;
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    return -3.4028235E38f;
                }
                return f11;
            }
            f12 = i12;
        }
        return f11 * f12;
    }
}
