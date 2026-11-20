package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q5 {
    public ViewOnClickListenerC1667Tl A00;
    public final C1C A01;
    public final C1N A02;
    public final C1R A03;
    public final C09701a A04;
    public final C1795Yn A05;
    public final JA A06;
    public static String[] A07 = {"67PC1vS7qkP", "IjFo3BG6VwtzNtFBLMxB3hm7uxcMitzp", "CicRHWg02u8tYTVNboa", "Lc1HqPOOGgkkm0o4iF185HVfJQb2Oy4J", "rfUiy7qGv2cTTJD", "veTQu7RBhk0w6DuY7Y8JViB1PkIKs", "nFnk8VxBkehLa6QhTm5QccOE2IAl", "l0nPd7gOfqjUiTZVoVDHfvPfOU4VPF8e"};
    public static final int A0A = (int) (LD.A02 * 4.0f);
    public static final int A08 = (int) (LD.A02 * 72.0f);
    public static final int A09 = (int) (LD.A02 * 8.0f);

    public Q5(C1795Yn c1795Yn, J2 j11, AbstractC1898b5 abstractC1898b5) {
        this.A05 = c1795Yn;
        this.A06 = new JA(abstractC1898b5.A12(), j11);
        this.A01 = abstractC1898b5.A0w();
        this.A02 = abstractC1898b5.A0x().A0E();
        this.A04 = abstractC1898b5.A10();
        this.A03 = abstractC1898b5.A0x().A0G();
    }

    private View A00(ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl) {
        O9 o11 = new O9(this.A05, this.A01.A01(), true, false, false);
        o11.A03(this.A02.A06(), this.A02.A01(), null, false, true);
        o11.setAlignment(17);
        O3 o12 = new O3(this.A05);
        AbstractC1462Lo.A0M(o12, 0);
        o12.setRadius(50);
        new AsyncTaskC1672Tq(o12, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i11 = A08;
        linearLayout.addView(o12, new LinearLayout.LayoutParams(i11, i11));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i12 = A09;
        layoutParams.setMargins(0, i12, 0, i12);
        linearLayout.addView(o11, layoutParams);
        if (viewOnClickListenerC1667Tl != null) {
            AbstractC1462Lo.A0J(viewOnClickListenerC1667Tl);
            linearLayout.addView(viewOnClickListenerC1667Tl, layoutParams);
            if (TextUtils.isEmpty(viewOnClickListenerC1667Tl.getText())) {
                AbstractC1462Lo.A0H(viewOnClickListenerC1667Tl);
            }
        }
        return linearLayout;
    }

    private C1278Eb A01() {
        C1278Eb c1278Eb = new C1278Eb(this.A05);
        c1278Eb.setLayoutManager(new C1821Zo(this.A05, 0, false));
        c1278Eb.setAdapter(new SM(this.A05, this.A03.A01(), A0A, this.A00));
        return c1278Eb;
    }

    private final Q4 A02() {
        if (!this.A03.A01().isEmpty()) {
            return Q4.A04;
        }
        Q4 q11 = Q4.A03;
        String[] strArr = A07;
        if (strArr[3].charAt(8) == strArr[7].charAt(8)) {
            throw new RuntimeException();
        }
        A07[4] = "qwlEjiYhEcV8j1J";
        return q11;
    }

    public final Pair<Q4, View> A03(ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl) {
        View viewA01;
        this.A00 = viewOnClickListenerC1667Tl;
        Q4 q4A02 = A02();
        switch (Q3.A00[q4A02.ordinal()]) {
            case 1:
                viewA01 = A01();
                break;
            default:
                ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl2 = this.A00;
                if (A07[4].length() != 15) {
                    throw new RuntimeException();
                }
                String[] strArr = A07;
                strArr[3] = "Oe6IO8Uak3tx5GvHWoKp5mKUb4E2rtDt";
                strArr[7] = "t7tx5cDm578ghKblxCWBuUm65hKnqcQl";
                viewA01 = A00(viewOnClickListenerC1667Tl2);
                break;
        }
        JC.A04(viewA01, this.A06, J9.A0S);
        return new Pair<>(q4A02, viewA01);
    }
}
