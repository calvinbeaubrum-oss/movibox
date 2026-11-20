package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface MBSplashLoadListener {
    void isSupportZoomOut(MBridgeIds mBridgeIds, boolean z11);

    void onLoadFailed(MBridgeIds mBridgeIds, String str, int i11);

    void onLoadSuccessed(MBridgeIds mBridgeIds, int i11);
}
