package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O2 extends LinearLayout {
    public static String[] A05 = {"JiUd07qZ", "phaLMHqUBlp6P5RZzzm", "VtPMRXbuUkVLmtGCwM", "RgvNiIo52t", "FYi9K2JmgPw1hqWSXD3EPgcEPQmLRiB", "yPPKnDMDveXTdnfoUUkFxo3t2NtgVDwK", "Cr", "5lHXxybE2bQiDNmNKuHItJ8Sueck67l"};
    public int A00;
    public List<GradientDrawable> A01;
    public final int A02;
    public final int A03;
    public final int A04;

    public O2(C1795Yn c1795Yn, C1P c1p, int i11) {
        super(c1795Yn);
        this.A00 = -1;
        setOrientation(0);
        setGravity(17);
        float f11 = LD.A02;
        int i12 = (int) (8.0f * f11);
        int i13 = (int) (6.0f * f11);
        this.A02 = (int) (1.0f * f11);
        int iA04 = c1p.A04(false);
        this.A04 = iA04;
        this.A03 = AbstractC10112p.A01(iA04, 128);
        this.A01 = new ArrayList();
        for (int i14 = 0; i14 < i11; i14++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setSize(i12, i12);
            gradientDrawable.setStroke(this.A02, 0);
            ImageView imageView = new ImageView(c1795Yn);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, i13, 0);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(gradientDrawable);
            this.A01.add(gradientDrawable);
            addView(imageView);
        }
        A00(0);
    }

    public final void A00(int i11) {
        int i12;
        int i13;
        if (this.A00 == i11) {
            return;
        }
        this.A00 = i11;
        if (A05[2].length() == 22) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[4] = "BJqXxH8n0fuaHx3JVwGHjWVcPjmBGjI";
        strArr[7] = "ZUGfW6Md7SIL60yz7Eq8Bq3LU56iFcm";
        for (int i14 = 0; i14 < this.A01.size(); i14++) {
            if (i14 == i11) {
                i12 = this.A04;
                i13 = this.A04;
            } else {
                i12 = this.A03;
                i13 = 0;
            }
            this.A01.get(i14).setStroke(this.A02, i13);
            this.A01.get(i14).setColor(i12);
            this.A01.get(i14).invalidateSelf();
        }
    }
}
