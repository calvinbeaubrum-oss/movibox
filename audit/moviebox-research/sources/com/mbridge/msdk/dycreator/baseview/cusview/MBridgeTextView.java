package com.mbridge.msdk.dycreator.baseview.cusview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBridgeTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f43502a;

    public MBridgeTextView(Context context) {
        super(context);
    }

    public MBridgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBridgeTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ObjectAnimator objectAnimator = this.f43502a;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f43502a;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void setObjectAnimator(ObjectAnimator objectAnimator) {
        this.f43502a = objectAnimator;
    }
}
