package com.facebook.ads.redexgen.uinode;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ji, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1407Ji {
    public static EnumC1405Jg A00(DisplayMetrics displayMetrics) {
        int i11 = (int) (displayMetrics.widthPixels / displayMetrics.density);
        int i12 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (LE.A04(i11, i12)) {
            return EnumC1405Jg.A0H;
        }
        return i12 > i11 ? EnumC1405Jg.A0J : EnumC1405Jg.A0G;
    }

    public static void A01(DisplayMetrics displayMetrics, View view, EnumC1403Je enumC1403Je) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= enumC1403Je.A03() ? displayMetrics.widthPixels : (int) Math.ceil(enumC1403Je.A03() * displayMetrics.density), (int) Math.ceil(enumC1403Je.A02() * displayMetrics.density));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
