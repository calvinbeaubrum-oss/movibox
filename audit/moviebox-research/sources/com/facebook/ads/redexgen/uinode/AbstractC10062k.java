package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10062k {
    public static TypedValue A00;
    public static final Object A01 = new Object();

    public static final Drawable A00(Context context, int i11) {
        int i12;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i11);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i11);
        }
        synchronized (A01) {
            if (A00 == null) {
                A00 = new TypedValue();
            }
            context.getResources().getValue(i11, A00, true);
            i12 = A00.resourceId;
        }
        return context.getResources().getDrawable(i12);
    }
}
