package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class AcquireRewardPopViewParameters {
    public AcquireRewardPopViewBehaviourListener behaviourListener;
    public String failTip;
    public String failTitle;
    public String language;
    public String placementId;
    public List<String> rightAnswerList;
    public String slideSuccessTitle;
    public String slideTip;
    public String slideTitle;
    public String successTip;
    public String successTitle;
    public String tips;
    public String title;
    public String unitId;
    public int viewType;
    public List<String> wrongAnswerList;
    public int autoDismissTime = 5;
    public int reduceTime = 0;
    public boolean canClickMaskArea = true;
    public int viewBackLayerTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFC27A;
    public int viewBackLayerBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF932B;
    public int viewForegroundTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBE2;
    public int viewForegroundBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFE0B5;
    public int buttonBackgroundLightColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF8B00;
    public int buttonBackgroundDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_33EF7601;
    public int titleTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_E56F19;
    public int tipTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_89664C;
    public int buttonTextLightColor = -1;
    public int buttonTextDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_D26700;
    public int successTipTextColor = -1;
    public int failTipTextColor = -1;
    public int containerBackgroundColor = AcquireRewardPopViewConst.DEFAULT_COLOR_50000000;
    public int successTitleGradientStartColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
    public int successTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
    public int successTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
    public int successTitleTextSize = 40;
    public float successTitleShadowRadius = 3.0f;
    public float successTitleShadowDx = 1.5f;
    public float successTitleShadowDy = 1.8f;
    public int failTitleGradientStartColor = -1;
    public int failTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_8B6B45;
    public int failTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_3B3127;
    public int failTitleTextSize = 40;
    public float failTitleShadowRadius = 3.0f;
    public float failTitleShadowDx = 1.5f;
    public float failTitleShadowDy = 1.8f;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AcquireRewardPopViewParameters f43541a;

        /* JADX WARN: Code duplicated, block: B:17:0x0048  */
        public Builder(String str, String str2, int i11, String str3) {
            String str4;
            AcquireRewardPopViewParameters acquireRewardPopViewParameters = new AcquireRewardPopViewParameters();
            this.f43541a = acquireRewardPopViewParameters;
            acquireRewardPopViewParameters.placementId = str;
            acquireRewardPopViewParameters.unitId = str2;
            acquireRewardPopViewParameters.viewType = i11;
            acquireRewardPopViewParameters.language = str3;
            if (TextUtils.isEmpty(str3)) {
                str4 = "EN";
            } else if (str3.equalsIgnoreCase("CN")) {
                str4 = "ZH";
            } else if (str3.equalsIgnoreCase("UK")) {
                str4 = "EN";
            } else if (str3.equalsIgnoreCase("JP")) {
                str4 = "JA";
            } else if (str3.equalsIgnoreCase("KR")) {
                str4 = "KO";
            } else {
                str4 = "EN";
            }
            if (str4.equalsIgnoreCase("ZH")) {
                AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f43541a;
                acquireRewardPopViewParameters2.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_CN;
                acquireRewardPopViewParameters2.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_CN;
                acquireRewardPopViewParameters2.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_CN;
                acquireRewardPopViewParameters2.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_CN;
                acquireRewardPopViewParameters2.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_CN;
                acquireRewardPopViewParameters2.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_CN;
                acquireRewardPopViewParameters2.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_CN;
                acquireRewardPopViewParameters2.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_CN;
                acquireRewardPopViewParameters2.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_CN;
                acquireRewardPopViewParameters2.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_CN);
                return;
            }
            if (str4.equalsIgnoreCase("EN")) {
                AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f43541a;
                acquireRewardPopViewParameters3.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_EN;
                acquireRewardPopViewParameters3.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_EN;
                acquireRewardPopViewParameters3.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_EN;
                acquireRewardPopViewParameters3.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_EN;
                acquireRewardPopViewParameters3.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_EN;
                acquireRewardPopViewParameters3.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_EN;
                acquireRewardPopViewParameters3.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_EN;
                acquireRewardPopViewParameters3.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_EN;
                acquireRewardPopViewParameters3.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_EN;
                acquireRewardPopViewParameters3.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_EN);
                return;
            }
            if (str4.equalsIgnoreCase("JA")) {
                AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f43541a;
                acquireRewardPopViewParameters4.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_JP;
                acquireRewardPopViewParameters4.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_JP;
                acquireRewardPopViewParameters4.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_JP;
                acquireRewardPopViewParameters4.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_JP;
                acquireRewardPopViewParameters4.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_JP;
                acquireRewardPopViewParameters4.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_JP;
                acquireRewardPopViewParameters4.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_JP;
                acquireRewardPopViewParameters4.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_JP;
                acquireRewardPopViewParameters4.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_JP;
                acquireRewardPopViewParameters4.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_JP);
                return;
            }
            if (str4.equalsIgnoreCase("KO")) {
                AcquireRewardPopViewParameters acquireRewardPopViewParameters5 = this.f43541a;
                acquireRewardPopViewParameters5.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_KR;
                acquireRewardPopViewParameters5.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_KR;
                acquireRewardPopViewParameters5.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_KR;
                acquireRewardPopViewParameters5.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_KR;
                acquireRewardPopViewParameters5.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_KR;
                acquireRewardPopViewParameters5.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_KR;
                acquireRewardPopViewParameters5.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_KR;
                acquireRewardPopViewParameters5.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_KR;
                acquireRewardPopViewParameters5.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_KR;
                acquireRewardPopViewParameters5.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_KR);
            }
        }

        public AcquireRewardPopViewParameters build() {
            return this.f43541a;
        }

        public Builder setAutoDismissTime(int i11) {
            this.f43541a.autoDismissTime = i11;
            return this;
        }

        public Builder setBehaviourListener(AcquireRewardPopViewBehaviourListener acquireRewardPopViewBehaviourListener) {
            this.f43541a.behaviourListener = acquireRewardPopViewBehaviourListener;
            return this;
        }

        public Builder setButtonBackgroundDarkColor(int i11) {
            this.f43541a.buttonBackgroundDarkColor = i11;
            return this;
        }

        public Builder setButtonBackgroundLightColor(int i11) {
            this.f43541a.buttonBackgroundLightColor = i11;
            return this;
        }

        public Builder setButtonTextDarkColor(int i11) {
            this.f43541a.buttonTextDarkColor = i11;
            return this;
        }

        public Builder setButtonTextLightColor(int i11) {
            this.f43541a.buttonTextLightColor = i11;
            return this;
        }

        public Builder setCanClickMaskArea(boolean z11) {
            this.f43541a.canClickMaskArea = z11;
            return this;
        }

        public Builder setContainerBackgroundColor(int i11) {
            this.f43541a.containerBackgroundColor = i11;
            return this;
        }

        public Builder setFailTip(String str) {
            this.f43541a.failTip = str;
            return this;
        }

        public Builder setFailTipTextColor(int i11) {
            this.f43541a.failTipTextColor = i11;
            return this;
        }

        public Builder setFailTitle(String str) {
            this.f43541a.failTitle = str;
            return this;
        }

        public Builder setFailTitleGradientEndColor(int i11) {
            this.f43541a.failTitleGradientEndColor = i11;
            return this;
        }

        public Builder setFailTitleGradientStartColor(int i11) {
            this.f43541a.failTitleGradientStartColor = i11;
            return this;
        }

        public Builder setFailTitleShadowColor(int i11) {
            this.f43541a.failTitleShadowColor = i11;
            return this;
        }

        public Builder setFailTitleShadowDx(float f11) {
            this.f43541a.failTitleShadowDx = f11;
            return this;
        }

        public Builder setFailTitleShadowDy(float f11) {
            this.f43541a.failTitleShadowDy = f11;
            return this;
        }

        public Builder setFailTitleShadowRadius(float f11) {
            this.f43541a.failTitleShadowRadius = f11;
            return this;
        }

        public Builder setFailTitleTextSize(int i11) {
            this.f43541a.failTitleTextSize = i11;
            return this;
        }

        public Builder setReduceTime(int i11) {
            this.f43541a.reduceTime = i11;
            return this;
        }

        public Builder setRightAnswerList(ArrayList<String> arrayList) {
            this.f43541a.rightAnswerList = arrayList;
            return this;
        }

        public Builder setSlideSuccessTitle(String str) {
            this.f43541a.slideSuccessTitle = str;
            return this;
        }

        public Builder setSlideTip(String str) {
            this.f43541a.slideTip = str;
            return this;
        }

        public Builder setSlideTitle(String str) {
            this.f43541a.slideTitle = str;
            return this;
        }

        public Builder setSuccessTip(String str) {
            this.f43541a.successTip = str;
            return this;
        }

        public Builder setSuccessTipTextColor(int i11) {
            this.f43541a.successTipTextColor = i11;
            return this;
        }

        public Builder setSuccessTitle(String str) {
            this.f43541a.successTitle = str;
            return this;
        }

        public Builder setSuccessTitleGradientEndColor(int i11) {
            this.f43541a.successTitleGradientEndColor = i11;
            return this;
        }

        public Builder setSuccessTitleGradientStartColor(int i11) {
            this.f43541a.successTitleGradientStartColor = i11;
            return this;
        }

        public Builder setSuccessTitleShadowColor(int i11) {
            this.f43541a.successTitleShadowColor = i11;
            return this;
        }

        public Builder setSuccessTitleShadowDx(float f11) {
            this.f43541a.successTitleShadowDx = f11;
            return this;
        }

        public Builder setSuccessTitleShadowDy(float f11) {
            this.f43541a.successTitleShadowDy = f11;
            return this;
        }

        public Builder setSuccessTitleShadowRadius(float f11) {
            this.f43541a.successTitleShadowRadius = f11;
            return this;
        }

        public Builder setSuccessTitleTextSize(int i11) {
            this.f43541a.successTitleTextSize = i11;
            return this;
        }

        public Builder setTipTextColor(int i11) {
            this.f43541a.tipTextColor = i11;
            return this;
        }

        public Builder setTips(String str) {
            this.f43541a.tips = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.f43541a.title = str;
            return this;
        }

        public Builder setTitleTextColor(int i11) {
            this.f43541a.titleTextColor = i11;
            return this;
        }

        public Builder setViewBackLayerBottomColor(int i11) {
            this.f43541a.viewBackLayerBottomColor = i11;
            return this;
        }

        public Builder setViewBackLayerTopColor(int i11) {
            this.f43541a.viewBackLayerTopColor = i11;
            return this;
        }

        public Builder setViewForegroundBottomColor(int i11) {
            this.f43541a.viewForegroundBottomColor = i11;
            return this;
        }

        public Builder setViewForegroundTopColor(int i11) {
            this.f43541a.viewForegroundTopColor = i11;
            return this;
        }

        public Builder setWrongAnswerList(ArrayList<String> arrayList) {
            this.f43541a.wrongAnswerList = arrayList;
            return this;
        }
    }

    public static Builder builder(String str, String str2, int i11, String str3) {
        if (TextUtils.isEmpty(str2)) {
            ad.b("AcquireRewardPopViewParameters", "Unit id must not null.");
            return null;
        }
        if (i11 == 0) {
            i11 = 1;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "EN";
        }
        return new Builder(str, str2, i11, str3);
    }
}
