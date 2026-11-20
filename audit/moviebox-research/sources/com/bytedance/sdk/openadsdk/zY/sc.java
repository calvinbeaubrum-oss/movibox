package com.bytedance.sdk.openadsdk.zY;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.sdk.openadsdk.core.ExN.Qj {
    private int We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Paint f28824sc;
    private boolean zY;

    public sc(Context context) {
        super(context);
        sc();
    }

    private float sc(float f11, String str) {
        this.f28824sc.setTextSize(f11);
        return this.f28824sc.measureText(str);
    }

    private void sc() {
        this.pFF = kX.sc(getContext(), 8.0f);
        this.f28824sc = new Paint();
    }

    private void sc(String str, int i11) {
        if (!this.zY && i11 > 0) {
            float textSize = getTextSize();
            this.f28824sc.set(getPaint());
            int paddingLeft = (i11 - getPaddingLeft()) - getPaddingRight();
            float fSc = sc(textSize, str);
            while (fSc > paddingLeft) {
                textSize -= 1.0f;
                this.f28824sc.setTextSize(textSize);
                if (textSize <= this.pFF) {
                    break;
                } else {
                    fSc = sc(textSize, str);
                }
            }
            setTextSize(0, textSize);
            this.zY = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sc(getText().toString(), getWidth());
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.Qj, android.widget.TextView, android.view.View
    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.We = getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, this.We);
        } else {
            layoutParams.height = this.We;
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ExN.Qj, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        int i11 = this.We;
        if (i11 == 0 || layoutParams == null) {
            return;
        }
        layoutParams.height = i11;
    }

    public void setMinTextSize(float f11) {
        if (f11 <= 0.0f) {
            return;
        }
        this.pFF = f11;
    }
}
