package com.hisavana.common.interfacz;

import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class TAdditionalListener {
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onClosed(int i11) {
    }

    public void onClosed(TAdNativeInfo tAdNativeInfo) {
    }

    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onRewarded() {
    }

    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onShowed(AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onTrigger(AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }

    public void onTriggerShow(AdditionalInfo additionalInfo) {
        Intrinsics.g(additionalInfo, "additionalInfo");
    }
}
