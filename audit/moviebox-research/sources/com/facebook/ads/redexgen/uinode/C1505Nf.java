package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1505Nf extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public C1505Nf(C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A03 = new ImageView(c1795Yn);
        this.A02 = new ImageView(c1795Yn);
        A00();
    }

    public C1505Nf(C1795Yn c1795Yn, AttributeSet attributeSet) {
        super(c1795Yn, attributeSet);
        this.A03 = new ImageView(c1795Yn, attributeSet);
        this.A02 = new ImageView(c1795Yn, attributeSet);
        A00();
    }

    public C1505Nf(C1795Yn c1795Yn, AttributeSet attributeSet, int i11) {
        super(c1795Yn, attributeSet, i11);
        this.A03 = new ImageView(c1795Yn, attributeSet, i11);
        this.A02 = new ImageView(c1795Yn, attributeSet, i11);
        A00();
    }

    public C1505Nf(C1795Yn c1795Yn, AttributeSet attributeSet, int i11, int i12) {
        super(c1795Yn, attributeSet, i11, i12);
        this.A03 = new ImageView(c1795Yn, attributeSet, i11, i12);
        this.A02 = new ImageView(c1795Yn, attributeSet, i11, i12);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        LI.A04(this.A03, LI.A0A);
        setId(AbstractC1462Lo.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        int i16 = this.A01;
        if (i16 <= 0 || (i15 = this.A00) <= 0) {
            super.onLayout(z11, i11, i12, i13, i14);
            return;
        }
        int i17 = i13 - i11;
        int i18 = i14 - i12;
        float fMin = Math.min(i17 / i16, i18 / i15);
        int i19 = (int) (this.A01 * fMin);
        int i21 = (int) (this.A00 * fMin);
        this.A02.layout(i11, i12, i13, i14);
        int i22 = (i17 / 2) + i11;
        int i23 = (i18 / 2) + i12;
        this.A03.layout(i22 - (i19 / 2), i23 - (i21 / 2), (i19 / 2) + i22, i23 + (i21 / 2));
        this.A02.setVisibility(0);
    }

    public void setImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            AbstractC1462Lo.A0S(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            AbstractC1462Lo.A0M(this.A02, 0);
        }
        if (bitmap == null) {
            this.A03.setImageDrawable(null);
            return;
        }
        this.A01 = bitmap.getWidth();
        this.A00 = bitmap.getHeight();
        this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
    }
}
