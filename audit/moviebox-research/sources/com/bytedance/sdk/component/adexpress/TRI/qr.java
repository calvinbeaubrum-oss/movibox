package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends uEA {
    private View pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private TextView f26717sc;
    private AnimatorSet zY;

    public qr(Context context) {
        super(context);
        this.zY = new AnimatorSet();
        pFF(context);
    }

    private void We() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pFF, "translationY", 0.0f, com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pFF, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.zY.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.zY.setDuration(1000L);
        this.zY.start();
    }

    private void pFF(Context context) {
        View viewSc = com.bytedance.sdk.component.adexpress.zY.sc.sc(context);
        this.pFF = viewSc;
        addView(viewSc);
        setClipChildren(false);
        this.f26717sc = (TextView) findViewById(2097610748);
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.uEA
    public void pFF() {
        this.zY.cancel();
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.uEA
    public void sc() {
        We();
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.uEA
    public void sc(Context context) {
    }

    public void setButtonText(String str) {
        if (this.f26717sc == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f26717sc.setText(str);
    }
}
