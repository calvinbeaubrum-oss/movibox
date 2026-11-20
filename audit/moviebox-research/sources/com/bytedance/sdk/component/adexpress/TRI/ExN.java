package com.bytedance.sdk.component.adexpress.TRI;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends FrameLayout {
    private AnimatorSet pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private ImageView f26668sc;

    public ExN(Context context) {
        super(context);
        zY();
        We();
    }

    private void We() {
        this.pFF = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f26668sc, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f26668sc, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.pFF.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void zY() {
        ImageView imageView = new ImageView(getContext());
        this.f26668sc = imageView;
        imageView.setImageResource(com.bytedance.sdk.component.utils.Sfl.We(getContext(), "tt_white_hand"));
        int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iSc, iSc);
        layoutParams.gravity = 17;
        addView(this.f26668sc, layoutParams);
    }

    public void pFF() {
        AnimatorSet animatorSet = this.pFF;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void sc() {
        AnimatorSet animatorSet = this.pFF;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }
}
