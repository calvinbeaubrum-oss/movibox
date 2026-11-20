package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface MBSplashShowListener {
    void onAdClicked(MBridgeIds mBridgeIds);

    void onAdTick(MBridgeIds mBridgeIds, long j11);

    void onDismiss(MBridgeIds mBridgeIds, int i11);

    void onShowFailed(MBridgeIds mBridgeIds, String str);

    void onShowSuccessed(MBridgeIds mBridgeIds);

    void onZoomOutPlayFinish(MBridgeIds mBridgeIds);

    void onZoomOutPlayStart(MBridgeIds mBridgeIds);
}
