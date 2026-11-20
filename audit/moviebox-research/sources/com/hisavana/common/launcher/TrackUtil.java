package com.hisavana.common.launcher;

import android.view.View;
import com.hisavana.common.bean.NativeAdWrapper;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.interfacz.AdShowListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TrackUtil {
    public static void handleClick(TAdNativeInfo tAdNativeInfo) {
        NativeAdWrapper nativeAdWrapper;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null) {
            return;
        }
        nativeAdWrapper.handleClick();
    }

    public static void registerViewForInteraction(TAdNativeInfo tAdNativeInfo, View view, AdShowListener adShowListener) {
        NativeAdWrapper nativeAdWrapper;
        if (tAdNativeInfo == null || (nativeAdWrapper = tAdNativeInfo.getNativeAdWrapper()) == null) {
            return;
        }
        nativeAdWrapper.registerViewForInteraction(view, adShowListener);
    }
}
