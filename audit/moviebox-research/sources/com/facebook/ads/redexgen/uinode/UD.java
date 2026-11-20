package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UD extends RelativeLayout implements MD {
    public static byte[] A0X;
    public static String[] A0Y = {"57rzzR6raHrat8cHk0n2c9utIvWN6OL8", "vZo4DQACnHxpUIABCEPhLIrXR", "3pKkUgRnbq5D8", "3oPHUcYdGBLGT6sjvwgTS6nCZs8dHXKK", "yMOWmEDq6oq3Yf8aoY", "BRjJ0geTmUVj6Aeo1VqVThKYcHpwhF7A", "bCnfD5Zsza6fNT9UI62TNCVdI9Gt63Qd", "0XbQU4AacrxlEwxF12eBigHvJ8"};
    public static final int A0Z;
    public static final int A0a;
    public static final int A0b;
    public static final int A0c;
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public static final RelativeLayout.LayoutParams A0i;
    public View A00;
    public RelativeLayout A01;
    public RelativeLayout A02;
    public Toast A03;
    public C5V A04;
    public L9 A05;
    public ViewOnClickListenerC1667Tl A06;
    public Q0 A07;
    public Q7 A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public final AbstractC1898b5 A0F;
    public final C09721c A0G;
    public final C5T A0H;
    public final C1795Yn A0I;
    public final J2 A0J;
    public final JA A0K;
    public final L9 A0L;
    public final ViewOnSystemUiVisibilityChangeListenerC1449Lb A0M;
    public final MC A0N;
    public final InterfaceC1483Mj A0O;
    public final O0 A0P;
    public final O1 A0Q;
    public final Q5 A0R;
    public final AtomicBoolean A0S;
    public final AtomicBoolean A0T;
    public final boolean A0U;
    public final boolean A0V;
    public final MB A0W;

    static {
        A0N();
        A0g = (int) (LD.A02 * 64.0f);
        A0b = (int) (LD.A02 * 16.0f);
        A0h = (int) (LD.A02 * 12.0f);
        A0Z = (int) (LD.A02 * 10.0f);
        A0i = new RelativeLayout.LayoutParams(-1, -1);
        A0c = (int) (LD.A02 * 48.0f);
        A0d = (int) (LD.A02 * 16.0f);
        A0f = (int) (LD.A02 * 14.0f);
        A0e = AbstractC10112p.A01(-1, 77);
        A0a = (int) (LD.A02 * 8.0f);
    }

    public UD(C1795Yn c1795Yn, J2 j11, MC mc2, AbstractC1898b5 abstractC1898b5, String str, InterfaceC1483Mj interfaceC1483Mj) {
        super(c1795Yn);
        this.A0H = new UK(this);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.A0T = atomicBoolean;
        this.A0S = new AtomicBoolean(false);
        this.A0C = false;
        this.A0E = true;
        this.A0A = false;
        this.A09 = false;
        this.A0I = c1795Yn;
        this.A0N = mc2;
        this.A0J = j11;
        this.A0F = abstractC1898b5;
        C09721c c09721cA06 = abstractC1898b5.A0x().A0D().A06();
        this.A0G = c09721cA06;
        this.A0K = new JA(abstractC1898b5.A12(), j11);
        this.A0O = interfaceC1483Mj;
        this.A08 = new Q7(c1795Yn, interfaceC1483Mj, str, mc2);
        this.A0B = abstractC1898b5.A0x().A0M() && abstractC1898b5.A0x().A0D().A02() > 0;
        boolean zA0A = abstractC1898b5.A0x().A0D().A0A();
        this.A0V = zA0A;
        if (c09721cA06 == null) {
            mc2.A43(interfaceC1483Mj.A6y());
            mc2.A43(interfaceC1483Mj.A6u());
        }
        int iA02 = (this.A0B && zA0A) ? abstractC1898b5.A0x().A0D().A02() : c09721cA06.A07();
        atomicBoolean.set(!c09721cA06.A0I());
        UK uk2 = null;
        this.A0L = new L9(iA02, new UF(this, uk2));
        this.A0U = C1384Ih.A0j(c1795Yn);
        FullScreenAdToolbar fullScreenAdToolbarA07 = A07();
        this.A0W = fullScreenAdToolbarA07;
        this.A0R = new Q5(c1795Yn, j11, abstractC1898b5);
        OA.A00(c1795Yn, this, abstractC1898b5.A0x().A0D().A07());
        ViewOnSystemUiVisibilityChangeListenerC1449Lb viewOnSystemUiVisibilityChangeListenerC1449Lb = new ViewOnSystemUiVisibilityChangeListenerC1449Lb(this);
        this.A0M = viewOnSystemUiVisibilityChangeListenerC1449Lb;
        viewOnSystemUiVisibilityChangeListenerC1449Lb.A05(EnumC1448La.A03);
        if (C1384Ih.A1q(c1795Yn)) {
            fullScreenAdToolbarA07.setProgressSpinnerInvisible(true);
        }
        HashMap map = new HashMap();
        map.put(A0D(56, 9, 61), interfaceC1483Mj.A7f());
        this.A07 = new Q0(c1795Yn, abstractC1898b5, c09721cA06, j11, new UE(this, uk2), map);
        A0K();
        mc2.A3U(this, new RelativeLayout.LayoutParams(-1, -1));
        A0H();
        UJ uj2 = new UJ(this);
        this.A0P = uj2;
        this.A0Q = new O1(c1795Yn, fullScreenAdToolbarA07, abstractC1898b5, (SA) null, mc2, uj2, this.A06, this.A01, this.A07);
    }

    private FullScreenAdToolbar A07() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A0I, this.A0N, this.A0K, 0, this.A0F.A0r());
        fullScreenAdToolbar.setFullscreen(true);
        fullScreenAdToolbar.A06(this.A0F.A0w().A01(), ViewOnClickListenerC1667Tl.A08(this.A0F));
        fullScreenAdToolbar.setPageDetailsVisible(false);
        fullScreenAdToolbar.setPageDetails(this.A0F.A10(), this.A0F.A12(), this.A0G.A07(), this.A0F.A11());
        fullScreenAdToolbar.setToolbarListener(new UG(this));
        return fullScreenAdToolbar;
    }

    private ViewOnClickListenerC1667Tl A09() {
        Q0 q11 = this.A07;
        if (q11 == null || q11.getViewabilityChecker() == null || this.A07.getTouchDataRecorder() == null) {
            return null;
        }
        ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = new ViewOnClickListenerC1667Tl(this.A0I, this.A0O.A6R(), this.A0F.A0w().A01(), this.A0J, this.A0N, this.A07.getViewabilityChecker(), this.A07.getTouchDataRecorder(), this.A0F.A0y());
        AbstractC1462Lo.A0K(viewOnClickListenerC1667Tl);
        viewOnClickListenerC1667Tl.setText(this.A0F.A0x().A0F().A04());
        viewOnClickListenerC1667Tl.setTextSize(14.0f);
        viewOnClickListenerC1667Tl.setIncludeFontPadding(false);
        int i11 = A0Z;
        viewOnClickListenerC1667Tl.setPadding(i11, i11, i11, i11);
        viewOnClickListenerC1667Tl.setOnClickListener(new MS(this));
        return viewOnClickListenerC1667Tl;
    }

    private O9 A0B() {
        O9 o11 = new O9(this.A0I, this.A0F.A0w().A01(), true, 16, 14, 0);
        o11.A03(this.A0F.A0x().A0E().A06(), this.A0F.A0x().A0E().A05(), null, false, true);
        TextView descriptionTextView = o11.getDescriptionTextView();
        descriptionTextView.setAlpha(0.8f);
        descriptionTextView.setMaxLines(1);
        descriptionTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextView titleTextView = o11.getTitleTextView();
        titleTextView.setMaxLines(1);
        titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        return o11;
    }

    public static String A0D(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0X, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0G() {
        int i11 = A0c;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i11, i11);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        O3 o11 = new O3(this.A0I);
        AbstractC1462Lo.A0M(o11, 0);
        AbstractC1462Lo.A0K(o11);
        new AsyncTaskC1672Tq(o11, this.A0I).A05(i11, i11).A07(this.A0F.A10().A01());
        TextView textView = new TextView(this.A0I);
        AbstractC1462Lo.A0K(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(this.A0F.A0w().A01().A06(true));
        textView.setText(this.A0F.A0x().A0E().A06());
        textView.setTextSize(16.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        O5 o12 = new O5(this.A0I, A0f, 5, A0e, -1);
        o12.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        TextView textView2 = new TextView(this.A0I);
        textView2.setTextColor(this.A0F.A0w().A01().A06(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        int i12 = A0a;
        layoutParams3.leftMargin = i12;
        LinearLayout linearLayout = new LinearLayout(this.A0I);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0d);
        layoutParams4.topMargin = i12 / 2;
        layoutParams4.addRule(3, textView.getId());
        linearLayout.addView(o12, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = i12;
        layoutParams5.addRule(1, o11.getId());
        layoutParams5.addRule(15);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(linearLayout, layoutParams4);
        relativeLayout.addView(textView);
        RelativeLayout relativeLayout2 = this.A02;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
            RelativeLayout relativeLayout3 = this.A02;
            if (A0Y[4].length() != 18) {
                throw new RuntimeException();
            }
            A0Y[4] = "bsFsSO04IJ4eZVQxRT";
            relativeLayout3.addView(relativeLayout, layoutParams5);
            this.A02.addView(o11, layoutParams);
        }
        if (TextUtils.isEmpty(this.A0F.A0x().A0E().A03())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        o12.setRating(Float.parseFloat(this.A0F.A0x().A0E().A03()));
        if (this.A0F.A0x().A0E().A02() != null) {
            textView2.setText(A0D(0, 1, 66) + NumberFormat.getNumberInstance().format(Integer.parseInt(this.A0F.A0x().A0E().A02())) + A0D(1, 1, 78));
        }
    }

    private void A0H() {
        if (this.A0G.A0I()) {
            A0J();
        } else {
            A0M();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.A0M.A05(EnumC1448La.A04);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0I() {
        this.A0D = true;
        if (this.A0F.A0x().A0M()) {
            this.A08.A05();
            this.A0N.A44(this.A0O.A5s(), new C9H(0, 0));
        }
    }

    private void A0J() {
        C1558Pg c1558PgA0B = new C1556Pe(this.A0I, this.A0F.A0x().A0E(), this.A0F.A10()).A08(this.A0F.A0w().A01()).A0A(this.A0G.A0G()).A09(this.A0G.A0D()).A07(2000).A0B();
        JC.A04(c1558PgA0B, this.A0K, J9.A0U);
        addView(c1558PgA0B, A0i);
        c1558PgA0B.A04(new UI(this));
    }

    private void A0K() {
        this.A06 = A09();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.A01 = relativeLayout;
        AbstractC1462Lo.A0K(relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i11 = A0b;
        int i12 = A0h;
        layoutParams.setMargins(i11, i12, i11, i12);
        layoutParams.addRule(12);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        this.A02 = relativeLayout2;
        AbstractC1462Lo.A0K(relativeLayout2);
        if (this.A0U) {
            A0G();
        } else {
            this.A02.addView(A0B(), new RelativeLayout.LayoutParams(-2, -2));
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, i11, 0);
        this.A01.addView(this.A02, layoutParams2);
        ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = this.A06;
        if (viewOnClickListenerC1667Tl != null) {
            layoutParams2.addRule(0, viewOnClickListenerC1667Tl.getId());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(6, this.A02.getId());
            layoutParams3.addRule(8, this.A02.getId());
            this.A01.addView(this.A06, layoutParams3);
        }
        AbstractC1462Lo.A0K(this.A0W);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(10);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.setMargins(i11, 0, i11, 0);
        layoutParams5.addRule(3, this.A0W.getId());
        layoutParams5.addRule(2, this.A01.getId());
        this.A0W.setVisibility(4);
        this.A07.setVisibility(4);
        this.A01.setVisibility(4);
        addView(this.A0W, layoutParams4);
        addView(this.A07, layoutParams5);
        addView(this.A01, layoutParams);
        if (this.A0G.A0J()) {
            this.A07.A0B();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        new JA(this.A0F.A12(), this.A0J).A04(J9.A0r, null);
        this.A0S.set(true);
        AbstractC1462Lo.A0T(this);
        AbstractC1462Lo.A0H(this.A07);
        AbstractC1462Lo.A0a(this.A0Q, this.A00, this.A07);
        AbstractC1462Lo.A0L(this.A0W);
        AbstractC1462Lo.A0L(this.A06);
        Pair<Q4, View> pairA03 = this.A0R.A03(this.A06);
        this.A00 = (View) pairA03.second;
        switch (MT.A00[((Q4) pairA03.first).ordinal()]) {
            case 1:
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, this.A0W.getToolbarHeight(), 0, 0);
                AbstractC1462Lo.A0L(this.A01);
                RelativeLayout relativeLayout = this.A01;
                if (relativeLayout != null) {
                    int id2 = relativeLayout.getId();
                    if (A0Y[5].charAt(2) == 'm') {
                        throw new RuntimeException();
                    }
                    A0Y[0] = "6k4i0rLafWNu6HrnPvo1bAEbeaagXJGg";
                    layoutParams.addRule(2, id2);
                }
                addView(this.A00, layoutParams);
                return;
            case 2:
                RelativeLayout relativeLayout2 = this.A01;
                if (relativeLayout2 != null) {
                    AbstractC1462Lo.A0a(relativeLayout2);
                }
                addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0M() {
        AbstractC1462Lo.A0T(this);
        if (!this.A0G.A0J()) {
            Q0 q11 = this.A07;
            if (A0Y[4].length() != 18) {
                throw new RuntimeException();
            }
            String[] strArr = A0Y;
            strArr[1] = "xj34PAIXy0BC0JvFurkBkOtWc";
            strArr[2] = "hWQrQPNffHRqy";
            q11.A0B();
        }
        this.A0W.setVisibility(0);
        this.A07.setVisibility(0);
        RelativeLayout relativeLayout = this.A01;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        if (this.A06 != null && this.A0F.A0u() > 0 && this.A05 == null) {
            L9 l11 = new L9(this.A0F.A0u(), new UH(this));
            this.A05 = l11;
            l11.A07();
        }
        this.A0L.A07();
    }

    public static void A0N() {
        A0X = new byte[]{-110, -97, -94, -70, -84, -86, -70, -92, 4, Ascii.CR, 10, 4, Ascii.FF, 0, Ascii.DLE, 19, 10, 8, 10, Ascii.SI, -77, -68, -71, -77, -69, -81, -61, -65, -59, -62, -77, -75, -11, -6, 0, -15, -2, -1, 0, -11, 0, -11, -19, -8, -55, -68, -49, -60, -47, -64, -70, -66, -57, -60, -66, -58, -43, -47, -58, -56, -54, -46, -54, -45, -39, -65, -78, -60, -82, -65, -79, -78, -79, -84, -61, -74, -79, -78, -68, -80, -98, -101, -81, -94, -98, -80, -104, -100, -91, -94, -100, -92};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(int i11) {
        AbstractC1462Lo.A0Y(this.A03, this.A0G.A0C().replace(A0D(2, 6, 31), String.valueOf(i11)), 49, 0, A0g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0U(boolean z11, String str) {
        this.A0A = true;
        HashMap map = new HashMap();
        map.put(A0D(8, 12, 121), z11 ? A0D(79, 13, 17) : A0D(44, 12, 51));
        map.put(A0D(20, 12, 40), str);
        new C1517Nr(this.A0I, this.A0O.A6R(), this.A07.getViewabilityChecker(), this.A07.getTouchDataRecorder(), this.A0J, this.A0F.A0y(), this.A0N).A07(this.A0F.A12(), this.A0F.A0x().A0F().A05(), map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0V() {
        if (!this.A0F.A0P().equals(A0D(65, 14, 37))) {
            if (this.A0F.A0P().equals(A0D(32, 12, 100))) {
                AbstractC1898b5 abstractC1898b5 = this.A0F;
                if (A0Y[4].length() != 18) {
                    throw new RuntimeException();
                }
                A0Y[0] = "r5y7OBqhAYVA47bIfl4AlIWKO2XfiX80";
                if (abstractC1898b5.A0x().A0O()) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0W() {
        return this.A0V && !this.A0C && !this.A0E && this.A0G.A07() < this.A0F.A0x().A0D().A02();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void A9Q(Intent intent, Bundle bundle, C5V c5v) {
        this.A04 = c5v;
        c5v.A0N(this.A0H);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
        this.A0L.A06();
        this.A09 = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
        if (this.A0V && this.A0E) {
            return;
        }
        boolean z12 = this.A0C;
        if (A0Y[5].charAt(2) == 'm') {
            throw new RuntimeException();
        }
        A0Y[0] = "UQp6GtSKm4mkcrS1rXAjxFqYQJcA6U4M";
        if (z12 || !this.A0T.get() || this.A0L.A05()) {
            return;
        }
        this.A0L.A07();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void AFT(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public String getCurrentClientToken() {
        return this.A0F.A12();
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final boolean onActivityResult(int i11, int i12, Intent intent) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
        this.A0M.A03();
        C5V c5v = this.A04;
        if (c5v != null) {
            c5v.A0O(this.A0H);
        }
        if (this.A07 != null) {
            AbstractC1898b5 abstractC1898b5 = this.A0F;
            if (A0Y[0].charAt(29) == 'D') {
                throw new RuntimeException();
            }
            A0Y[0] = "voPpcOtL9PQSCLq1wYvqOCQr8JaLbGKq";
            if (!TextUtils.isEmpty(abstractC1898b5.A12())) {
                this.A0J.A9X(this.A0F.A12(), new C1508Ni().A03(this.A07.getViewabilityChecker()).A02(this.A07.getTouchDataRecorder()).A05());
            }
            this.A07.A0C();
        }
        this.A0L.A06();
        this.A0W.setToolbarListener(null);
        this.A03 = null;
        this.A04 = null;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            ACu(false);
        } else {
            ACW(false);
        }
    }

    public void setListener(MC mc2) {
    }

    public void setServerSideRewardHandler(Q7 q11) {
        this.A08 = q11;
    }
}
