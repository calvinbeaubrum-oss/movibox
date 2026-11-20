package com.facebook.ads.redexgen.uinode;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C3P extends C1278Eb implements View.OnTouchListener {
    public static byte[] A07;
    public static String[] A08 = {"y4Urxqcv9RCHCbRsxOihNkmZ9cqKDFdZ", "LGqXjwU2H5uaBf0UptGCT7ZDInUwl5IV", "fkBbKznr2zH2OwfKJXQ1DdYWN1N", "HFNULQ3MobNCNeOVkX9dtbi8574Dr14V", "KPqvTm6ScHx6bbBibk9kuRT9nwj9YcDc", "WIY3Unb14PjE3ayNyWd6XWPIVw0Az9uS", "ZZL8YXP6wYj9", "tbuIO4j0iRDkkCNXzrivmX4Au5offJfR"};
    public int A00;
    public C1821Zo A01;
    public InterfaceC1564Pm A02;
    public boolean A03;
    public boolean A04;
    public int A05;
    public final int A06;

    static {
        A0A();
    }

    public C3P(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public C3P(C1795Yn c1795Yn, AttributeSet attributeSet) {
        super(c1795Yn, attributeSet);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    public C3P(C1795Yn c1795Yn, AttributeSet attributeSet, int i11) {
        super(c1795Yn, attributeSet, i11);
        this.A05 = 0;
        this.A00 = 0;
        this.A03 = true;
        this.A04 = false;
        this.A06 = A05();
        setOnTouchListener(this);
    }

    private int A05() {
        return ((int) getContext().getResources().getDisplayMetrics().density) * 10;
    }

    private int A06(int i11) {
        int i12 = this.A00 - i11;
        int iA7j = this.A02.A7j(i12);
        int i13 = this.A06;
        if (i12 > i13) {
            return A08(this.A05, iA7j);
        }
        return i12 < (-i13) ? A07(this.A05, iA7j) : this.A05;
    }

    private int A07(int i11, int i12) {
        return Math.max(i11 - i12, 0);
    }

    private int A08(int i11, int i12) {
        return Math.min(i11 + i12, getItemCount() - 1);
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 62);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{-53, -26, -39, -24, -54, -35, -37, -15, -37, -28, -35, -22, -50, -31, -35, -17, -104, -25, -26, -28, -15, -104, -21, -19, -24, -24, -25, -22, -20, -21, -104, -60, -31, -26, -35, -39, -22, -60, -39, -15, -25, -19, -20, -59, -39, -26, -39, -33, -35, -22};
    }

    private int getItemCount() {
        if (getAdapter() == null) {
            return 0;
        }
        return getAdapter().A0E();
    }

    public void A1y(int i11, boolean z11) {
        if (getAdapter() == null) {
            return;
        }
        this.A05 = i11;
        if (z11) {
            A1W(i11);
        } else {
            A1V(i11);
        }
    }

    public int getCurrentPosition() {
        return this.A05;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3 || actionMasked == 4) {
            if (this.A04) {
                A1y(A06(rawX), true);
            }
            this.A03 = true;
            this.A04 = false;
            return true;
        }
        if (actionMasked == 0 || actionMasked == 5 || (this.A03 && actionMasked == 2)) {
            this.A00 = rawX;
            String[] strArr = A08;
            if (strArr[5].charAt(14) == strArr[4].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[5] = "MxKeEan5PHYt2nmJnSz3xsZ38eI3mGgL";
            strArr2[4] = "utg9fSYK4sdWKYxBX5KGIJ2pCeKuK2tx";
            if (this.A03) {
                this.A03 = false;
            }
            this.A04 = true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1278Eb
    public void setLayoutManager(AbstractC10614o abstractC10614o) {
        if (!(abstractC10614o instanceof C1821Zo)) {
            throw new IllegalArgumentException(A09(0, 50, 58));
        }
        super.setLayoutManager(abstractC10614o);
        this.A01 = (C1821Zo) abstractC10614o;
    }

    public void setSnapDelegate(InterfaceC1564Pm interfaceC1564Pm) {
        this.A02 = interfaceC1564Pm;
    }
}
