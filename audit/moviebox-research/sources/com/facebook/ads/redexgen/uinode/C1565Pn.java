package com.facebook.ads.redexgen.uinode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1565Pn extends RelativeLayout {
    public final Paint A00;
    public final RectF A01;

    public C1565Pn(C1795Yn c1795Yn, String str) {
        super(c1795Yn);
        float f11 = c1795Yn.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(c1795Yn);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(16.0f);
        textView.setText(str);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        int i11 = (int) (6.0f * f11);
        textView.setPadding(i11, i11, i11, i11);
        addView(textView);
        Paint paint = new Paint();
        this.A00 = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1);
        this.A01 = new RectF();
        AbstractC1462Lo.A0M(this, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f11 = getContext().getResources().getDisplayMetrics().density;
        this.A01.set(0.0f, 0.0f, getWidth(), getHeight());
        canvas.drawRoundRect(this.A01, f11 * 10.0f, 10.0f * f11, this.A00);
        super.onDraw(canvas);
    }
}
