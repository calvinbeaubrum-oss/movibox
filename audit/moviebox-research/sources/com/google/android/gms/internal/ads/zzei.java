package com.google.android.gms.internal.ads;

import android.text.Spannable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzei {
    public static void zza(Spannable spannable, Object obj, int i11, int i12, int i13) {
        for (Object obj2 : spannable.getSpans(i11, i12, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i11 && spannable.getSpanEnd(obj2) == i12 && spannable.getSpanFlags(obj2) == 33) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i11, i12, 33);
    }
}
