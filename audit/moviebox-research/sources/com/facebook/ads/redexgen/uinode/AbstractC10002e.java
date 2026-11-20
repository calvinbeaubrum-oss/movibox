package com.facebook.ads.redexgen.uinode;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC10002e extends FrameLayout {
    public static final float A08;
    public static final int A09;
    public static final InterfaceC10022g A0A;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final Rect A04;
    public final Rect A05;
    public final InterfaceC10012f A06;
    public static String[] A07 = {"jVZ1Tu881vaZhMQc7G1YnAdrBZwLOzLZ", "MIZgMzLB91QWfj9gVmnmcTG9oR84Ntwz", "DCbfL76gOTURmFCUeHCsoybhclYkmTay", "EMPd0g2FUYEiLKskd4o9XcZgPaWME7KU", "G2pxhAodnNK6EDlWmu9QTAPYKMlMfLOc", "qEeDuFDfyNwl7ByTckOuFZ9zHyfaVY7D", "VB67ht075LyAy5nhvmM9NplNYlVRYF1n", "i4ARItf07QURagRfhioscqF5iwXVDFyZ"};
    public static final int[] A0B = {R.attr.colorBackground};

    static {
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        A08 = f11;
        A09 = (int) (f11 * 1.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            A0A = new C1840a9();
        } else if (Build.VERSION.SDK_INT >= 17) {
            A0A = new F6();
        } else {
            A0A = new C1838a7();
        }
        A0A.A8r();
    }

    public AbstractC10002e(Context context) {
        this(context, null);
    }

    public AbstractC10002e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractC10002e(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Rect rect = new Rect();
        this.A04 = rect;
        this.A05 = new Rect();
        C1842aB c1842aB = new C1842aB(this);
        this.A06 = c1842aB;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(A0B);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        Color.colorToHSV(color, new float[3]);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(-328966);
        this.A02 = false;
        this.A03 = true;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        float f11 = 10.0f > 50.0f ? 10.0f : 50.0f;
        this.A01 = 0;
        this.A00 = 0;
        A0A.A8s(c1842aB, context, colorStateListValueOf, 10.0f, 10.0f, f11);
    }

    public ColorStateList getCardBackgroundColor() {
        return A0A.A66(this.A06);
    }

    public float getCardElevation() {
        return A0A.A6t(this.A06);
    }

    public int getContentPaddingBottom() {
        return this.A04.bottom;
    }

    public int getContentPaddingLeft() {
        return this.A04.left;
    }

    public int getContentPaddingRight() {
        return this.A04.right;
    }

    public int getContentPaddingTop() {
        return this.A04.top;
    }

    public float getMaxCardElevation() {
        return A0A.A7M(this.A06);
    }

    public boolean getPreventCornerOverlap() {
        return this.A03;
    }

    public float getRadius() {
        return A0A.A7m(this.A06);
    }

    public boolean getUseCompatPadding() {
        return this.A02;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i11, int i12) {
        InterfaceC10022g interfaceC10022g = A0A;
        if (interfaceC10022g instanceof C1840a9) {
            super.onMeasure(i11, i12);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                double dCeil = Math.ceil(interfaceC10022g.A7S(this.A06));
                if (A07[1].charAt(21) != 'T') {
                    throw new RuntimeException();
                }
                A07[1] = "CoEZjfZf0TpQ2BZBlHTi5T6DWNYutRLI";
                i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) dCeil, View.MeasureSpec.getSize(i11)), mode);
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i12);
        switch (mode2) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i12 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(interfaceC10022g.A7R(this.A06)), View.MeasureSpec.getSize(i12)), mode2);
                break;
        }
        super.onMeasure(i11, i12);
    }

    public void setCardBackgroundColor(int i11) {
        A0A.AFt(this.A06, ColorStateList.valueOf(i11));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        A0A.AFt(this.A06, colorStateList);
    }

    public void setCardElevation(float f11) {
        A0A.AFz(this.A06, f11);
    }

    public void setMaxCardElevation(float f11) {
        A0A.AG6(this.A06, f11);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i11) {
        this.A00 = i11;
        super.setMinimumHeight(i11);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i11) {
        this.A01 = i11;
        super.setMinimumWidth(i11);
    }

    @Override // android.view.View
    public final void setPadding(int i11, int i12, int i13, int i14) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i11, int i12, int i13, int i14) {
    }

    public void setPreventCornerOverlap(boolean z11) {
        if (z11 != this.A03) {
            this.A03 = z11;
            String[] strArr = A07;
            if (strArr[5].charAt(25) == strArr[2].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[5] = "AF11DlndTIGSrqZz8tUh3XTR3YFTmMvs";
            strArr2[2] = "M7b5sm4OMM6QoyOKa0AwC0c4wRmpSBfx";
            A0A.ACk(this.A06);
        }
    }

    public void setRadius(float f11) {
        A0A.AGC(this.A06, f11);
    }

    public void setUseCompatPadding(boolean z11) {
        if (this.A02 != z11) {
            this.A02 = z11;
            A0A.AB7(this.A06);
        }
    }
}
