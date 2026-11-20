package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTAdDislikeToast extends com.bytedance.sdk.openadsdk.core.ExN.zY {
    private static String sDislikeSendTip;
    private static String sDislikeTip;
    private static String sSkipText;
    private final Handler mHandler;
    private TextView mTextView;

    public TTAdDislikeToast(Context context) {
        this(context, null);
    }

    public TTAdDislikeToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTAdDislikeToast(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mHandler = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        initToast(context);
    }

    public static String getDislikeSendTip() {
        if (sDislikeSendTip == null) {
            Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
            sDislikeSendTip = Sfl.sc(contextSc, "tt_feedback_thank_text") + "\n" + Sfl.sc(contextSc, "tt_feedback_experience_text");
        }
        return sDislikeSendTip;
    }

    public static String getDislikeTip() {
        if (sDislikeTip == null) {
            sDislikeTip = Sfl.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), "tt_feedback_submit_text");
        }
        return sDislikeTip;
    }

    public static String getSkipText() {
        if (sSkipText == null) {
            sSkipText = Sfl.sc(com.bytedance.sdk.openadsdk.core.Xc.sc(), "tt_reward_screen_skip_tx");
        }
        return sSkipText;
    }

    private void initToast(Context context) {
        TextView textView = new TextView(context);
        this.mTextView = textView;
        textView.setClickable(false);
        this.mTextView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = kX.zY(getContext(), 75.0f);
        int iZY = kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc(), 16.0f);
        int iZY2 = kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc(), 12.0f);
        this.mTextView.setPadding(iZY, iZY2, iZY, iZY2);
        this.mTextView.setLayoutParams(layoutParams);
        this.mTextView.setTextColor(-1);
        this.mTextView.setTextSize(16.0f);
        this.mTextView.setGravity(GravityCompat.START);
        Drawable drawableZY = Sfl.zY(getContext(), "tt_dislike_toast");
        int iZY3 = kX.zY(getContext(), 16.0f);
        drawableZY.setBounds(0, 0, iZY3, iZY3);
        this.mTextView.setCompoundDrawablePadding(iZY3 / 2);
        this.mTextView.setCompoundDrawables(drawableZY, null, null, null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.argb(209, 37, 37, 37));
        gradientDrawable.setCornerRadius(kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc(), 12.0f));
        this.mTextView.setBackground(gradientDrawable);
        addView(this.mTextView);
    }

    public static void onResourceUpdated() {
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        sSkipText = Sfl.sc(contextSc, "tt_reward_screen_skip_tx");
        sDislikeTip = Sfl.sc(contextSc, "tt_feedback_submit_text");
        sDislikeSendTip = Sfl.sc(contextSc, "tt_feedback_thank_text") + "\n" + Sfl.sc(contextSc, "tt_feedback_experience_text");
    }

    public void hide() {
        setVisibility(8);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onDestroy() {
        setVisibility(8);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void show(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.TTAdDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTAdDislikeToast.this.mTextView != null) {
                    TTAdDislikeToast.this.mTextView.setText(String.valueOf(str));
                }
                TTAdDislikeToast.this.setVisibility(0);
            }
        });
        this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.TTAdDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTAdDislikeToast.this.setVisibility(8);
            }
        }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }
}
