package com.bytedance.sdk.openadsdk.component.reward.top;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.core.ExN.ExN;
import com.bytedance.sdk.openadsdk.core.ExN.Qj;
import com.bytedance.sdk.openadsdk.core.ExN.We;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.core.widget.qr;
import com.bytedance.sdk.openadsdk.utils.Ol;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TopLayoutDislike2 extends ExN implements sc<TopLayoutDislike2> {
    private boolean hasCutDown;
    private boolean hasShowClose;
    private boolean isVast;
    private We mCloseBtn;
    private View mImgDislike;
    private ImageView mImgSound;
    private boolean mIsSoundMute;
    private CharSequence mProgressStr;
    private ImageView mSkipIV;
    private TextView mTextViewCountDown;
    private pFF mTopListener;
    private boolean shouldShowSkipTime;
    private int skipTime;
    private int videoDuration;

    public TopLayoutDislike2(@NonNull Context context) {
        this(context, null);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mProgressStr = "";
        setOrientation(0);
    }

    private ImageView getCommonRingBGImageView() {
        We we2 = new We(getContext());
        int iZY = kX.zY(getContext(), 5.0f);
        we2.setPadding(iZY, iZY, iZY, iZY);
        we2.setScaleType(ImageView.ScaleType.CENTER);
        we2.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.sc());
        return we2;
    }

    private void initListener() {
        View view = this.mImgDislike;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.zY(view2);
                    }
                }
            });
        }
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Drawable drawableSc;
                    TopLayoutDislike2 topLayoutDislike2 = TopLayoutDislike2.this;
                    topLayoutDislike2.mIsSoundMute = !topLayoutDislike2.mIsSoundMute;
                    if (TopLayoutDislike2.this.mSkipIV != null) {
                        drawableSc = TopLayoutDislike2.this.mIsSoundMute ? Sfl.zY(TopLayoutDislike2.this.getContext(), "tt_reward_full_mute") : Sfl.zY(TopLayoutDislike2.this.getContext(), "tt_reward_full_unmute");
                    } else {
                        drawableSc = TopLayoutDislike2.this.mIsSoundMute ? Ol.sc(TopLayoutDislike2.this.getContext(), "tt_mute_wrapper") : Ol.sc(TopLayoutDislike2.this.getContext(), "tt_unmute_wrapper");
                    }
                    TopLayoutDislike2.this.mImgSound.setImageDrawable(drawableSc);
                    if (TopLayoutDislike2.this.mImgSound.getDrawable() != null) {
                        TopLayoutDislike2.this.mImgSound.getDrawable().setAutoMirrored(true);
                    }
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.pFF(view2);
                    }
                }
            });
        }
        ImageView imageView2 = this.mSkipIV;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.sc(view2);
                    }
                }
            });
        } else {
            TextView textView = this.mTextViewCountDown;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TopLayoutDislike2.this.mTopListener != null) {
                            TopLayoutDislike2.this.mTopListener.sc(view2);
                        }
                    }
                });
            }
        }
        We we2 = this.mCloseBtn;
        if (we2 != null) {
            we2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.We(view2);
                    }
                }
            });
        }
    }

    private void initView() {
        int iZY = kX.zY(getContext(), 16.0f);
        int iZY2 = kX.zY(getContext(), 20.0f);
        int iZY3 = kX.zY(getContext(), 28.0f);
        this.mImgSound = getCommonRingBGImageView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iZY3, iZY3);
        layoutParams.leftMargin = iZY;
        layoutParams.topMargin = iZY2;
        this.mImgSound.setLayoutParams(layoutParams);
        ImageView commonRingBGImageView = getCommonRingBGImageView();
        this.mImgDislike = commonRingBGImageView;
        commonRingBGImageView.setId(520093713);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(iZY3, iZY3);
        layoutParams2.topMargin = iZY2;
        layoutParams2.leftMargin = iZY;
        this.mImgDislike.setLayoutParams(layoutParams2);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        view.setLayoutParams(layoutParams3);
        Qj qj2 = new Qj(getContext());
        this.mTextViewCountDown = qj2;
        qj2.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.pFF());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, kX.zY(getContext(), 28.0f));
        layoutParams4.topMargin = kX.zY(getContext(), 20.0f);
        int iZY4 = kX.zY(getContext(), 16.0f);
        layoutParams2.rightMargin = iZY4;
        layoutParams4.rightMargin = iZY4;
        int iZY5 = kX.zY(getContext(), 12.0f);
        kX.zY(getContext(), 5.0f);
        this.mTextViewCountDown.setPadding(iZY5, 0, iZY5, 0);
        this.mTextViewCountDown.setLayoutParams(layoutParams4);
        this.mTextViewCountDown.setGravity(17);
        this.mTextViewCountDown.setTextColor(-1);
        this.mTextViewCountDown.setTextSize(14.0f);
        this.mTextViewCountDown.setVisibility(8);
        ImageView commonRingBGImageView2 = getCommonRingBGImageView();
        this.mSkipIV = commonRingBGImageView2;
        commonRingBGImageView2.setId(520093714);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(iZY3, iZY3);
        layoutParams5.topMargin = iZY2;
        layoutParams5.rightMargin = iZY;
        this.mSkipIV.setLayoutParams(layoutParams5);
        this.mSkipIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        We wePFF = qr.pFF(getContext());
        this.mCloseBtn = wePFF;
        wePFF.setId(520093708);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
        layoutParams6.topMargin = kX.zY(getContext(), 20.0f);
        layoutParams6.rightMargin = kX.zY(getContext(), 24.0f);
        this.mCloseBtn.setLayoutParams(layoutParams6);
        this.mCloseBtn.setContentDescription(Sfl.sc(getContext(), "tt_ad_close_text"));
        this.mCloseBtn.setVisibility(8);
        addView(this.mImgSound);
        addView(this.mImgDislike);
        addView(view);
        addView(this.mTextViewCountDown);
        addView(this.mSkipIV);
        addView(this.mCloseBtn);
    }

    private void updateTime(boolean z11) {
        if (this.hasShowClose) {
            return;
        }
        if (this.shouldShowSkipTime) {
            this.mSkipIV.setVisibility(8);
            this.mTextViewCountDown.setVisibility(0);
        } else if (z11) {
            this.mTextViewCountDown.setVisibility(0);
            this.mSkipIV.setVisibility(8);
        } else {
            this.mTextViewCountDown.setVisibility(8);
            this.mSkipIV.setVisibility(0);
        }
    }

    public void clickDislike() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void clickSkip() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.performClick();
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void clickSound() {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public View getCloseButton() {
        return this.mCloseBtn;
    }

    public TopLayoutDislike2 load(@NonNull com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        initView();
        this.mImgDislike.setVisibility(0);
        ((ImageView) this.mImgDislike).setImageResource(Sfl.We(Xc.sc(), "tt_reward_full_feedback"));
        if (!dE.ef().SR(String.valueOf(sfl.QT())) || sfl.Xc() == 5 || sfl.Xc() == 6) {
            this.mSkipIV.setImageResource(Sfl.We(Xc.sc(), "tt_close_btn"));
        } else {
            this.mSkipIV.setImageResource(Sfl.We(Xc.sc(), "tt_skip_btn"));
        }
        if (this.mSkipIV.getDrawable() != null) {
            this.mSkipIV.getDrawable().setAutoMirrored(true);
        }
        this.mSkipIV.setVisibility(8);
        this.videoDuration = sfl.GI() == null ? 0 : ((int) sfl.GI().m()) * sfl.GI().J();
        if (com.bytedance.sdk.openadsdk.core.model.Xc.We(sfl) && sfl.Ol() != null) {
            this.videoDuration = (int) sfl.Ol().pFF();
        } else if (com.bytedance.sdk.openadsdk.core.model.Xc.ExN(sfl) && sfl.Ol() != null) {
            this.videoDuration = (int) sfl.Ol().We();
        }
        if (this.videoDuration <= 0) {
            this.videoDuration = 10;
        }
        if (sfl.qY() != 8 || sfl.Cb() == null) {
            this.skipTime = Xc.We().WH(sfl.Cb().getCodeId());
        } else {
            this.skipTime = Xc.We().Sfl(sfl.Cb().getCodeId());
        }
        if (JPJ.zY(sfl)) {
            this.skipTime = Xc.We().sc(String.valueOf(sfl.QT()), sfl.xP());
            this.videoDuration = sfl.ds();
        }
        int i11 = this.skipTime;
        this.shouldShowSkipTime = i11 == -1 || i11 >= this.videoDuration;
        if (sfl.ymG()) {
            this.mImgDislike.setVisibility(8);
            this.isVast = true;
        }
        this.mTextViewCountDown.setVisibility(4);
        this.mTextViewCountDown.setText("");
        this.mTextViewCountDown.setEnabled(false);
        this.mTextViewCountDown.setClickable(false);
        initListener();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setListener(pFF pff) {
        this.mTopListener = pff;
    }

    public void setShouldShowSkipTime(boolean z11) {
        this.shouldShowSkipTime = z11;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setShowDislike(boolean z11) {
        View view = this.mImgDislike;
        if (view == null || this.isVast) {
            return;
        }
        view.setVisibility(z11 ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setShowSkip(boolean z11) {
        TextView textView = this.mTextViewCountDown;
        if (textView == null) {
            return;
        }
        if (!z11) {
            textView.setText("");
        }
        if (this.mSkipIV.getVisibility() == 4) {
            return;
        }
        this.hasShowClose = !z11;
        this.mSkipIV.setVisibility((z11 && this.hasCutDown) ? 0 : 8);
        this.mTextViewCountDown.setVisibility(z11 & (TextUtils.isEmpty(this.mTextViewCountDown.getText()) ^ true) ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setShowSound(boolean z11) {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setVisibility(z11 ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSkipEnable(boolean z11) {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setEnabled(z11);
            this.mSkipIV.setClickable(z11);
            return;
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.setEnabled(z11);
            this.mTextViewCountDown.setClickable(z11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSkipInvisiable() {
        this.mTextViewCountDown.setWidth(20);
        this.mTextViewCountDown.setVisibility(4);
        this.mSkipIV.setVisibility(4);
        this.hasShowClose = true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSkipText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.mTextViewCountDown.setText(charSequence);
        if (this.mTextViewCountDown.getVisibility() != 0) {
            this.mTextViewCountDown.setVisibility(0);
        }
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void setSoundMute(boolean z11) {
        Drawable drawableSc;
        this.mIsSoundMute = z11;
        if (this.mSkipIV != null) {
            drawableSc = z11 ? Sfl.zY(getContext(), "tt_reward_full_mute") : Sfl.zY(getContext(), "tt_reward_full_unmute");
        } else {
            drawableSc = z11 ? Ol.sc(getContext(), "tt_mute_wrapper") : Ol.sc(getContext(), "tt_unmute_wrapper");
        }
        this.mImgSound.setImageDrawable(drawableSc);
        if (this.mImgSound.getDrawable() != null) {
            this.mImgSound.getDrawable().setAutoMirrored(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    @SuppressLint({"SetTextI18n"})
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.mProgressStr = charSequence;
        }
        if (this.mSkipIV == null) {
            return;
        }
        this.hasCutDown = true;
        if (this.shouldShowSkipTime) {
            this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
            updateTime(false);
            return;
        }
        String str = (String) this.mProgressStr;
        try {
            int i11 = this.skipTime;
            int i12 = i11 == 0 ? Integer.parseInt(str) : i11 - (this.videoDuration - Integer.parseInt(str));
            if (i12 <= 0) {
                this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
                updateTime(false);
                return;
            }
            if (this.skipTime == 0) {
                updateTime(false);
                return;
            }
            this.mTextViewCountDown.setText(i12 + "s");
            updateTime(true);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void showCloseButton() {
        setSkipInvisiable();
        this.mSkipIV.setVisibility(8);
        this.mCloseBtn.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void showCountDownText() {
        this.mTextViewCountDown.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.sc
    public void showSkipButton() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.mTextViewCountDown.setVisibility(8);
    }
}
