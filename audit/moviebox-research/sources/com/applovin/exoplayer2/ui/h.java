package com.applovin.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.impl.ac;
import com.applovin.impl.b1;
import com.applovin.impl.b5;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class h {
    public static float a(int i11, float f11, int i12, int i13) {
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

    private static void a(Spannable spannable, Predicate predicate) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static void a(b5.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.a(SpannableString.valueOf(bVar.e()));
            }
            a((Spannable) b1.a(bVar.e()), new Predicate() { // from class: com.applovin.exoplayer2.ui.s
                @Override // com.applovin.exoplayer2.common.base.Predicate
                public final boolean apply(Object obj) {
                    return h.a(obj);
                }
            });
        }
        b(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Object obj) {
        return !(obj instanceof ac);
    }

    public static void b(b5.b bVar) {
        bVar.b(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.a(SpannableString.valueOf(bVar.e()));
            }
            a((Spannable) b1.a(bVar.e()), new Predicate() { // from class: com.applovin.exoplayer2.ui.r
                @Override // com.applovin.exoplayer2.common.base.Predicate
                public final boolean apply(Object obj) {
                    return h.b(obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }
}
