package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.redexgen.uinode.AbstractC1462Lo;
import com.facebook.ads.redexgen.uinode.C09701a;
import com.facebook.ads.redexgen.uinode.C09761g;
import com.facebook.ads.redexgen.uinode.C1475Mb;
import com.facebook.ads.redexgen.uinode.C1566Po;
import com.facebook.ads.redexgen.uinode.C1795Yn;
import com.facebook.ads.redexgen.uinode.C1P;
import com.facebook.ads.redexgen.uinode.EnumC1470Lw;
import com.facebook.ads.redexgen.uinode.JA;
import com.facebook.ads.redexgen.uinode.LD;
import com.facebook.ads.redexgen.uinode.M9;
import com.facebook.ads.redexgen.uinode.MA;
import com.facebook.ads.redexgen.uinode.MB;
import com.facebook.ads.redexgen.uinode.MC;
import com.facebook.ads.redexgen.uinode.ML;
import com.facebook.ads.redexgen.uinode.OI;
import com.facebook.ads.redexgen.uinode.ViewOnClickListenerC1667Tl;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends MB {
    public static byte[] A09;
    public static String[] A0A = {"elaUgpg", "xyZ5KhWZZkOCw26QnbyRE89VYXYHkT38", "j2Hg99bd5kkvFLrtwtqoGvtE7T", "FtK0h2Y990QReQxCoMrwn7Y", "09p430KvfvIa5D7TMMbG57be7BWhVuc0", "4K9Dg6G4rdQDm1ubILJxRl9GbBVTjarc", "MQsbPX4", "ODYsITK"};
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public M9 A00;
    public MA A01;
    public MA A02;
    public boolean A03;
    public final RelativeLayout A04;
    public final JA A05;
    public final MC A06;
    public final C1475Mb A07;
    public final C1566Po A08;

    static {
        A03();
        int i11 = (int) (LD.A02 * 10.0f);
        A0B = i11;
        int i12 = (int) (LD.A02 * 16.0f);
        A0F = i12;
        A0D = i12 - i11;
        A0E = (i12 * 2) - i11;
        A0C = (int) (LD.A02 * 4.0f);
    }

    public FullScreenAdToolbar(C1795Yn c1795Yn, MC mc2, JA ja2, int i11) {
        super(c1795Yn);
        this.A01 = null;
        this.A03 = true;
        this.A06 = mc2;
        this.A05 = ja2;
        setGravity(16);
        C1475Mb c1475Mb = new C1475Mb(c1795Yn, i11);
        this.A07 = c1475Mb;
        c1475Mb.setContentDescription(A02(0, 8, 50));
        c1475Mb.setActionClickListener(new ML(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i12 = A0D;
        layoutParams.setMargins(i12, i12, A0E, i12);
        addView(c1475Mb, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(c1795Yn);
        this.A04 = relativeLayout;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        C1566Po c1566Po = new C1566Po(c1795Yn);
        this.A08 = c1566Po;
        AbstractC1462Lo.A0G(PointerIconCompat.TYPE_CELL, c1566Po);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        c1566Po.setLayoutParams(layoutParams3);
        relativeLayout.addView(c1566Po);
        addView(relativeLayout, layoutParams2);
    }

    public FullScreenAdToolbar(C1795Yn c1795Yn, MC mc2, JA ja2, int i11, int i12) {
        this(c1795Yn, mc2, ja2, i11);
        A09(c1795Yn, i12);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A09 = new byte[]{-26, Ascii.SI, Ascii.DC2, Ascii.SYN, 8, -61, -28, 7, 56, 75, 86, 85, 88, 90, 6, 39, 74, 77, 72, 72, 69, 59, 58, 75};
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public final void A04() {
        MA ma2 = this.A01;
        if (ma2 != null) {
            this.A02 = ma2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public final void A05() {
        this.A01 = getToolbarListener();
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public final void A06(C1P c1p, boolean z11) {
        boolean z12 = this.A03;
        int iA04 = c1p.A04(z12);
        this.A08.A02(c1p.A0A(z12), iA04);
        this.A00.setIconColors(iA04);
        this.A00.setContentDescription(A02(8, 9, 117));
        this.A07.A02(c1p, z12, z11);
        if (!z12) {
            AbstractC1462Lo.A0M(this, 0);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
        gradientDrawable.setCornerRadius(0.0f);
        AbstractC1462Lo.A0S(this, gradientDrawable);
        AbstractC1462Lo.A0Q(this.A00, 0, ViewCompat.MEASURED_STATE_MASK, A0C);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public final boolean A07() {
        return this.A07.A03();
    }

    public final void A08(C09701a c09701a, String str, int i11) {
        this.A07.setInitialUnskippableSeconds(i11);
        M9 m11 = this.A00;
        if (m11 != null) {
            m11.setAdDetails(c09701a, str, this.A05, this.A06);
        }
    }

    public final void A09(C1795Yn c1795Yn, int i11) {
        M9 m11 = this.A00;
        if (m11 != null) {
            AbstractC1462Lo.A0J(m11);
            this.A00.removeAllViews();
        }
        this.A00 = new M9(c1795Yn, i11);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        int i12 = A0F;
        layoutParams.setMargins(0, i12 / 2, i12 / 2, i12 / 2);
        addView(this.A00, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public View getDetailsContainer() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public int getToolbarActionMode() {
        return this.A07.getToolbarActionMode();
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public int getToolbarHeight() {
        return MB.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public MA getToolbarListener() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setAdReportingVisible(boolean z11) {
        this.A00.setVisibility(z11 ? 0 : 8);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setCTAClickListener(View.OnClickListener onClickListener) {
        this.A08.setOnClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setCTAClickListener(ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl) {
        this.A08.setOnClickListener(OI.A03(viewOnClickListenerC1667Tl, A02(17, 7, 104)));
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setFullscreen(boolean z11) {
        this.A03 = z11;
    }

    public void setOnlyPageDetails(C09701a c09701a) {
        if (c09701a != null) {
            this.A08.setPageDetails(c09701a);
        } else {
            this.A08.A01();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setPageDetails(C09701a c09701a, String str, int i11, C09761g c09761g) {
        this.A07.setInitialUnskippableSeconds(i11);
        this.A08.setPageDetails(c09701a);
        M9 m11 = this.A00;
        if (m11 != null) {
            m11.setAdDetails(c09701a, str, this.A05, this.A06);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setPageDetailsVisible(boolean z11) {
        this.A04.removeAllViews();
        if (z11) {
            RelativeLayout relativeLayout = this.A04;
            C1566Po c1566Po = this.A08;
            if (A0A[4].charAt(4) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[2] = "uYrc95dj4mq6YR3RipRhNZPjST";
            strArr[3] = "ufyXPPKrvmASdIniU0CJIS9";
            relativeLayout.addView(c1566Po);
        }
        C1475Mb c1475Mb = this.A07;
        String[] strArr2 = A0A;
        if (strArr2[2].length() == strArr2[3].length()) {
            c1475Mb.setToolbarMessageEnabled(!z11);
        } else {
            A0A[1] = "RoBBOPMqmB8G6B1FErbRchWOJuWn3pgq";
            c1475Mb.setToolbarMessageEnabled(!z11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setProgress(float f11) {
        this.A07.setProgress(f11);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A07.setProgressClickListener(onClickListener);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setProgressImage(EnumC1470Lw enumC1470Lw) {
        this.A07.setProgressImage(enumC1470Lw);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setProgressImmediate(float f11) {
        this.A07.setProgressImmediate(f11);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setProgressSpinnerInvisible(boolean z11) {
        this.A07.setProgressSpinnerInvisible(z11);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setToolbarActionMessage(String str) {
        this.A07.setToolbarMessage(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setToolbarActionMode(int i11) {
        this.A07.setToolbarActionMode(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.MB
    public void setToolbarListener(MA ma2) {
        this.A02 = ma2;
    }
}
