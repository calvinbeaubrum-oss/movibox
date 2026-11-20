package com.facebook.ads.redexgen.uinode;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O9 extends LinearLayout {
    public static byte[] A04;
    public static String[] A05 = {"lF8IVPZcS3mZAefsIaNZ6E9xMmjOqdH7", "idkW2", "HbWJiF6R60B06srsOI5ot4Pv3KsUxfPN", "7f3O1w3Qg3dv0DYXPvEPDd2nNc", "nnNATfNTHr6hSEkqMWy2MP3i9vksRg0T", "pai30RxYeYeDatKriEp6xPPXjxDmZE6E", "MhBAxeK5XElhMNsb", "N4hTYih9SgQSzhMEA04rsaAJRIerHLwS"};
    public static final float A06;
    public static final int A07;
    public static final int A08;
    public final TextView A00;
    public final TextView A01;
    public final TextView A02;
    public final boolean A03;

    static {
        A01();
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        A06 = f11;
        A08 = (int) (6.0f * f11);
        A07 = (int) (f11 * 8.0f);
    }

    public O9(C1795Yn c1795Yn, C1P c1p, boolean z11, int i11, int i12, int i13) {
        super(c1795Yn);
        setOrientation(1);
        TextView textView = new TextView(c1795Yn);
        this.A02 = textView;
        AbstractC1462Lo.A0X(textView, true, i11);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        int i14 = A08;
        textView.setLineSpacing(i14, 1.0f);
        TextView textView2 = new TextView(c1795Yn);
        this.A01 = textView2;
        TextView textView3 = new TextView(c1795Yn);
        this.A00 = textView3;
        AbstractC1462Lo.A0X(textView3, false, i12);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setLineSpacing(i14, 1.0f);
        boolean zA0y = C1384Ih.A0y(c1795Yn);
        this.A03 = zA0y;
        int i15 = zA0y ? -2 : -1;
        addView(textView, new LinearLayout.LayoutParams(i15, -2));
        addView(textView2, new LinearLayout.LayoutParams(i15, -2));
        textView2.setVisibility(8);
        A02(c1p, z11);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i15, -2);
        layoutParams.setMargins(0, i13, 0, 0);
        addView(textView3, layoutParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public O9(C1795Yn c1795Yn, C1P c1p, boolean z11, boolean z12, boolean z13) {
        int i11 = z12 ? 18 : 22;
        int i12 = z12 ? 14 : 16;
        int i13 = A07;
        this(c1795Yn, c1p, z11, i11, i12, z13 ? i13 / 2 : i13);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A05[4].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[7] = "1IRXFHeJ8iEaedLhZkECOAxJLr3083z4";
        strArr[2] = "dqFSPFlearJtxV8PFi6iCQhpIdVpxh77";
        A04 = new byte[]{-33, -30, -30, -29, -14, -33, -25, -22, -15};
    }

    public final void A02(C1P c1p, boolean z11) {
        this.A02.setTextColor(c1p.A06(z11));
        this.A01.setTextColor(c1p.A04(z11));
        this.A00.setTextColor(c1p.A05(z11));
    }

    public final void A03(String str, String str2, String str3, boolean z11, boolean z12) {
        int i11 = 1;
        boolean z13 = !TextUtils.isEmpty(str);
        boolean z14 = !TextUtils.isEmpty(str2);
        TextView textView = this.A02;
        if (!z13) {
            str = str2;
        }
        textView.setText(str);
        if (str3 != null) {
            this.A01.setText(str3);
        }
        TextView textView2 = this.A00;
        if (!z13) {
            str2 = A00(0, 0, 28);
        }
        textView2.setText(str2);
        if (A05[4].charAt(18) != 'y') {
            throw new RuntimeException();
        }
        A05[4] = "cGsHRNQKRzUTXMDBZCyzngEN4Bg1pclE";
        int i12 = 3;
        if (z13 && z14) {
            this.A02.setMaxLines(z11 ? 1 : 2);
            TextView textView3 = this.A00;
            if (!z11) {
                i11 = z12 ? 3 : 2;
            }
            textView3.setMaxLines(i11);
            return;
        }
        TextView textView4 = this.A02;
        if (z11) {
            i12 = 2;
        } else if (z12) {
            i12 = 4;
        }
        textView4.setMaxLines(i12);
    }

    public TextView getDescriptionTextView() {
        return this.A00;
    }

    public TextView getTitleTextView() {
        return this.A02;
    }

    public void setAlignment(int i11) {
        if (this.A03) {
            setGravity(i11);
        }
        this.A02.setGravity(i11);
        this.A00.setGravity(i11);
    }

    public void setCTAClickListener(ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl) {
        OH ohA03 = OI.A03(viewOnClickListenerC1667Tl, A00(0, 9, 57));
        this.A02.setOnClickListener(ohA03);
        this.A00.setOnClickListener(ohA03);
        this.A01.setOnClickListener(ohA03);
    }

    public void setDescriptionVisibility(int i11) {
        this.A00.setVisibility(i11);
    }
}
