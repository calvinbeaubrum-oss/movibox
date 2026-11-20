package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends pFF {
    private final Bitmap zY;
    private final Rect pFF = new Rect();
    private final Paint We = new Paint(1);

    public sc(Bitmap bitmap, pFF pff) {
        this.zY = bitmap;
        if (pff != null) {
            this.f26827sc = pff.f26827sc;
        }
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iHeight = rect.height();
        int iWidth = rect.width();
        int width = this.zY.getWidth();
        int height = this.zY.getHeight();
        this.pFF.set(0, 0, width, height);
        if (height >= iHeight && width >= iWidth) {
            if (width > iWidth) {
                Rect rect2 = this.pFF;
                int i11 = (width - iWidth) / 2;
                rect2.left = i11;
                rect2.right = i11 + iWidth;
            }
            if (height > iHeight) {
                Rect rect3 = this.pFF;
                int i12 = (height - iHeight) / 2;
                rect3.top = i12;
                rect3.bottom = i12 + iHeight;
                return;
            }
            return;
        }
        float f11 = iHeight;
        float f12 = f11 * 1.0f;
        float f13 = height;
        float f14 = f12 / f13;
        float f15 = iWidth;
        float f16 = 1.0f * f15;
        float f17 = width;
        if (Math.max(f14, f16 / f17) > f14) {
            int i13 = (int) ((f12 / f15) * f17);
            Rect rect4 = this.pFF;
            int i14 = (height - i13) / 2;
            rect4.top = i14;
            rect4.bottom = i14 + i13;
            return;
        }
        int i15 = (int) ((f16 / f11) * f13);
        Rect rect5 = this.pFF;
        int i16 = (width - i15) / 2;
        rect5.left = i16;
        rect5.right = i16 + i15;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pFF
    public void sc(Canvas canvas) {
        canvas.drawBitmap(this.zY, this.pFF, getBounds(), this.We);
    }
}
