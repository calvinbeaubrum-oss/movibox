package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class dE extends View {
    private Drawable ExN;
    private float TRI;
    private Drawable We;
    private final boolean pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Path f28547sc;
    private int zY;

    public dE(Context context) {
        this(context, false);
    }

    public dE(Context context, boolean z11) {
        super(context);
        this.f28547sc = new Path();
        this.pFF = z11;
        sc();
    }

    private void pFF() {
        int width = getWidth();
        int height = getHeight();
        if (this.TRI <= 0.0f || width <= 0 || height <= 0) {
            return;
        }
        this.f28547sc.reset();
        this.f28547sc.addRect(new RectF(0.0f, 0.0f, width * this.TRI, height), Path.Direction.CCW);
    }

    private void sc() {
        Context context = getContext();
        this.We = com.bytedance.sdk.component.utils.Sfl.zY(context, this.pFF ? "tt_star_thick_dark" : "tt_star_thick");
        this.ExN = com.bytedance.sdk.component.utils.Sfl.zY(context, "tt_star");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.zY <= 0) {
            return;
        }
        int iSave = canvas.save();
        for (int i11 = 0; i11 < 5; i11++) {
            this.We.draw(canvas);
            canvas.translate(this.zY, 0.0f);
        }
        canvas.restoreToCount(iSave);
        canvas.clipPath(this.f28547sc);
        for (int i12 = 0; i12 < 5; i12++) {
            this.ExN.draw(canvas);
            canvas.translate(this.zY, 0.0f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.zY * 5, 1073741824), View.MeasureSpec.makeMeasureSpec(this.zY, 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        pFF();
    }

    public void sc(double d11, int i11) {
        int iSc = (int) kX.sc(getContext(), i11, false);
        this.zY = iSc;
        this.We.setBounds(0, 0, iSc, iSc);
        Drawable drawable = this.ExN;
        int i12 = this.zY;
        drawable.setBounds(0, 0, i12, i12);
        this.TRI = ((float) d11) / 5.0f;
        pFF();
        requestLayout();
    }
}
