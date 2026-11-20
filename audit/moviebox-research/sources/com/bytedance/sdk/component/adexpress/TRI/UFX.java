package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX extends FrameLayout {
    private final RotateAnimation We;
    private final ImageView pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final TextView f26692sc;
    private final Tf zY;

    public UFX(@NonNull Context context) {
        super(context);
        addView(com.bytedance.sdk.component.adexpress.zY.sc.We(context));
        this.f26692sc = (TextView) findViewById(2097610742);
        this.pFF = (ImageView) findViewById(2097610745);
        this.zY = (Tf) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.We = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.UFX.1
            @Override // java.lang.Runnable
            public void run() {
                UFX.this.pFF.startAnimation(UFX.this.We);
                UFX.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.UFX.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        UFX.this.zY.sc(4);
                    }
                }, 100L);
                UFX.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.TRI.UFX.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        UFX.this.zY.sc(4);
                    }
                }, 300L);
                UFX ufx = UFX.this;
                ufx.postDelayed(ufx.getHaloAnimation(), 1200L);
            }
        };
    }

    public void pFF() {
        this.We.cancel();
    }

    public void sc() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.f26692sc;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
