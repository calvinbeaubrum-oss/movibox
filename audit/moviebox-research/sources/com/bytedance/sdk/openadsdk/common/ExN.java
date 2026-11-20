package com.bytedance.sdk.openadsdk.common;

import com.bytedance.sdk.openadsdk.api.PAGErrorCode;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f27687sc = false;

    public static ISDKTypeFactory sc(PAGLoadListener pAGLoadListener) {
        if (f27687sc) {
            if (pAGLoadListener != null) {
                pAGLoadListener.onError(-1, PAGErrorCode.LOAD_SDK_DISABLE_MSG);
            }
            return null;
        }
        ISDKTypeFactory sdkTypeFactory = SDKTypeConfig.getSdkTypeFactory();
        if (sdkTypeFactory != null) {
            return sdkTypeFactory;
        }
        if (pAGLoadListener != null) {
            pAGLoadListener.onError(5000, PAGErrorCode.LOAD_FACTORY_NULL_MSG);
        }
        return null;
    }

    public static void sc(boolean z11) {
        f27687sc = z11;
    }

    public static boolean sc() {
        return f27687sc;
    }
}
