package com.facebook.ads.redexgen.uinode;

import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C3C extends C3P implements InterfaceC1564Pm {
    public static byte[] A07;
    public static String[] A08 = {"T7MK6mm4Fzbg8PTMnM4kcHpb21LLpIaw", "PTQtUxKdjysMmbj8hCZsGKEwd1IRWqqZ", "Zw8mt4VncD", "79VYCrnrWW", "2MnAMBnkkiKtyd2cP7mHhabJycDYuMiE", "jaMauIT7sdi", "OgIH7ZaBRtH9hoDgrnw", "xZmsCngT77DU5lblEiekqTVKPqNdsast"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public MM A04;
    public boolean A05;
    public final C1221Bg A06;

    static {
        A03();
    }

    public C3C(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C1221Bg(c1795Yn, new C1561Pj(), new C1560Pi());
        A02();
    }

    public C3C(C1795Yn c1795Yn, AttributeSet attributeSet) {
        super(c1795Yn, attributeSet);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C1221Bg(c1795Yn, new C1561Pj(), new C1560Pi());
        A02();
    }

    public C3C(C1795Yn c1795Yn, AttributeSet attributeSet, int i11) {
        super(c1795Yn, attributeSet, i11);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C1221Bg(c1795Yn, new C1561Pj(), new C1560Pi());
        A02();
    }

    private int A00(int i11) {
        int i12 = this.A00 * 2;
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - i12;
        int iA0E = getAdapter().A0E();
        int i13 = 0;
        int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        while (i14 > i11) {
            i13++;
            if (i13 >= iA0E) {
                return i11;
            }
            i14 = (int) ((measuredWidth - (i13 * i12)) / (i13 + 0.333f));
        }
        return i14;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    private void A02() {
        this.A06.A2A(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        AbstractC1462Lo.A0K(this);
    }

    public static void A03() {
        A07 = new byte[]{-6, -7, -37, -20, -14, -16, -50, -13, -20, -7, -14, -16, -17};
    }

    private void A04(int i11, int i12) {
        if (i11 == this.A03 && i12 == this.A02) {
            return;
        }
        this.A03 = i11;
        if (A08[1].charAt(11) == 'q') {
            throw new RuntimeException();
        }
        A08[6] = "hNBaptvkpj";
        this.A02 = i12;
        if (0 != 0) {
            throw new NullPointerException(A01(0, 13, 111));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C3P
    public final void A1y(int i11, boolean z11) {
        super.A1y(i11, z11);
        A04(i11, 0);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1564Pm
    public final int A7j(int i11) {
        int iAbs = Math.abs(i11);
        if (iAbs <= ((C3P) this).A06) {
            return 0;
        }
        int i12 = this.A01;
        if (i12 == 0) {
            return 1;
        }
        return 1 + (iAbs / i12);
    }

    public int getChildSpacing() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1278Eb, android.view.View
    public final void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int iA0E = this.A05 ? (((int) LD.A02) * C1384Ih.A0E(getContext())) + paddingTop : Math.round(getMeasuredWidth() / 1.91f);
        switch (View.MeasureSpec.getMode(i12)) {
            case Integer.MIN_VALUE:
                iA0E = Math.min(View.MeasureSpec.getSize(i12), iA0E);
                break;
            case 1073741824:
                iA0E = View.MeasureSpec.getSize(i12);
                break;
        }
        int i13 = iA0E - paddingTop;
        int iMin = this.A05 ? Math.min(MI.A09, i13) : A00(i13);
        setMeasuredDimension(getMeasuredWidth(), iMin + paddingTop);
        if (this.A05) {
            return;
        }
        setChildWidth((this.A00 * 2) + iMin);
    }

    @Override // com.facebook.ads.redexgen.uinode.C1278Eb
    public void setAdapter(AbstractC10494c abstractC10494c) {
        this.A06.A2H(abstractC10494c == null ? -1 : abstractC10494c.hashCode());
        super.setAdapter(abstractC10494c);
    }

    public void setChildSpacing(int i11) {
        this.A00 = i11;
    }

    public void setChildWidth(int i11) {
        this.A01 = i11;
        int measuredWidth = getMeasuredWidth();
        this.A06.A2I((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.A01) / 2);
        this.A06.A2G(((double) this.A01) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i11) {
        A1y(i11, false);
    }

    public void setOnPageChangedListener(MM mm2) {
        this.A04 = mm2;
    }

    public void setShowTextInCarousel(boolean z11) {
        this.A05 = z11;
    }
}
