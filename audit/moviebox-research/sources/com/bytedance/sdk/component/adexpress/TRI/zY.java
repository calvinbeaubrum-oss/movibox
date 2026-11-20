package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends FrameLayout {
    private Xc ExN;
    private AnimatorSet TRI;
    private TextView We;
    private ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26730sc;
    private ImageView zY;

    public zY(@NonNull Context context) {
        super(context);
        this.TRI = new AnimatorSet();
        this.f26730sc = context;
        ExN();
        TRI();
    }

    private void ExN() {
        FrameLayout frameLayout = new FrameLayout(this.f26730sc);
        this.ExN = new Xc(this.f26730sc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26730sc, 95.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26730sc, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.ExN, layoutParams);
        this.pFF = new ImageView(this.f26730sc);
        int iSc = com.bytedance.sdk.component.utils.WP.sc(this.f26730sc, 60.0f);
        this.pFF.setImageDrawable(com.bytedance.sdk.component.adexpress.We.Ol.sc(1, null, null, new int[]{iSc, iSc}, Integer.valueOf(com.bytedance.sdk.component.utils.WP.sc(this.f26730sc, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26730sc, 75.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26730sc, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.pFF, layoutParams2);
        this.zY = new ImageView(this.f26730sc);
        int iSc2 = com.bytedance.sdk.component.utils.WP.sc(this.f26730sc, 50.0f);
        this.zY.setImageDrawable(com.bytedance.sdk.component.adexpress.We.Ol.sc(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iSc2, iSc2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26730sc, 63.0f), (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.f26730sc, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.zY, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.f26730sc);
        this.We = textView;
        textView.setTextColor(-1);
        this.We.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.We, layoutParams4);
    }

    private void TRI() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.zY, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.zY, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.TRI.setDuration(800L);
        this.TRI.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void We() {
        this.ExN.pFF();
        this.ExN.zY();
    }

    public void pFF() {
        this.TRI.cancel();
    }

    public void sc() {
        this.TRI.start();
    }

    public void setGuideText(String str) {
        this.We.setText(str);
    }

    public void zY() {
        this.ExN.sc();
    }
}
