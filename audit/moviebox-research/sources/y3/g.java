package y3;

import android.text.Spannable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static void a(Spannable spannable, Object obj, int i11, int i12, int i13) {
        for (Object obj2 : spannable.getSpans(i11, i12, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i11 && spannable.getSpanEnd(obj2) == i12 && spannable.getSpanFlags(obj2) == i13) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i11, i12, i13);
    }
}
