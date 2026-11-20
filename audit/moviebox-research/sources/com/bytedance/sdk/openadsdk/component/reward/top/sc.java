package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface sc<T extends View> {
    void clickSkip();

    void clickSound();

    View getCloseButton();

    void setListener(pFF pff);

    void setShowDislike(boolean z11);

    void setShowSkip(boolean z11);

    void setShowSound(boolean z11);

    void setSkipEnable(boolean z11);

    void setSkipInvisiable();

    void setSkipText(CharSequence charSequence);

    void setSoundMute(boolean z11);

    void setTime(CharSequence charSequence, CharSequence charSequence2);

    void showCloseButton();

    void showCountDownText();

    void showSkipButton();
}
