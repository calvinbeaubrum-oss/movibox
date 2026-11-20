package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj extends uEA {
    private int ExN;
    private AnimatorSet TRI;
    private ImageView We;
    private ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private TextView f26676sc;
    private ImageView zY;

    public Qj(Context context) {
        super(context);
        this.TRI = new AnimatorSet();
        pFF(context);
    }

    private void We() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    private void pFF(Context context) {
        addView(com.bytedance.sdk.component.adexpress.zY.sc.pFF(context));
        this.pFF = (ImageView) findViewById(2097610751);
        this.zY = (ImageView) findViewById(2097610750);
        this.We = (ImageView) findViewById(2097610749);
        this.f26676sc = (TextView) findViewById(2097610748);
    }

    public float getAlphaColor() {
        return this.ExN;
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.uEA
    public void pFF() {
        this.TRI.cancel();
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.uEA
    public void sc() {
        We();
    }

    @Override // com.bytedance.sdk.component.adexpress.TRI.uEA
    public void sc(Context context) {
    }

    public void setAlphaColor(int i11) {
        if (i11 < 0 || i11 > 60) {
            return;
        }
        int i12 = i11 + 195;
        ImageView imageView = this.We;
        int iRgb = Color.rgb(i12, i12, i12);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        imageView.setColorFilter(iRgb, mode);
        int i13 = ((i11 + 20) % 60) + 195;
        this.zY.setColorFilter(Color.rgb(i13, i13, i13), mode);
        int i14 = ((i11 + 40) % 60) + 195;
        this.pFF.setColorFilter(Color.rgb(i14, i14, i14), mode);
    }

    public void setButtonText(String str) {
        if (this.f26676sc == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f26676sc.setText(str);
    }
}
