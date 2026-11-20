package com.mbridge.msdk.newreward.function.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeRefactor {
    private static final boolean DEFAULT_REFACTOR_AVAILABLE = false;
    public static final String REFACTOR_SWITCH_NEW_INTERSTITIAL_VIDEO = "new_bridge_new_interstitial_video";
    public static final String REFACTOR_SWITCH_REWARD_VIDEO = "new_bridge_reward_video";
    private static volatile MBridgeRefactor instance;
    private Boolean isRewardVideoRefactorAvailable = null;
    private Boolean isNewInterstitialVideoRefactorAvailable = null;

    private MBridgeRefactor() {
    }

    public static MBridgeRefactor getInstance() {
        if (instance == null) {
            synchronized (MBridgeRefactor.class) {
                try {
                    if (instance == null) {
                        instance = new MBridgeRefactor();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return instance;
    }

    private boolean isNewInterstitialVideoRefactorAvailable() {
        Boolean bool = this.isNewInterstitialVideoRefactorAvailable;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(af.a().a(REFACTOR_SWITCH_NEW_INTERSTITIAL_VIDEO, false));
        this.isNewInterstitialVideoRefactorAvailable = boolValueOf;
        return boolValueOf.booleanValue();
    }

    private boolean isRewardVideoRefactorAvailable() {
        Boolean bool = this.isRewardVideoRefactorAvailable;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean boolValueOf = Boolean.valueOf(af.a().a(REFACTOR_SWITCH_REWARD_VIDEO, false));
        this.isRewardVideoRefactorAvailable = boolValueOf;
        return boolValueOf.booleanValue();
    }

    public boolean isAvailable(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals(REFACTOR_SWITCH_REWARD_VIDEO)) {
            return isRewardVideoRefactorAvailable();
        }
        if (str.equals(REFACTOR_SWITCH_NEW_INTERSTITIAL_VIDEO)) {
            return isNewInterstitialVideoRefactorAvailable();
        }
        return false;
    }
}
