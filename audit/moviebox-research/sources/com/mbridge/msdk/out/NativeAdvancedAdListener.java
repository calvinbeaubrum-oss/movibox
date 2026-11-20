package com.mbridge.msdk.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface NativeAdvancedAdListener {
    void closeFullScreen(MBridgeIds mBridgeIds);

    void onClick(MBridgeIds mBridgeIds);

    void onClose(MBridgeIds mBridgeIds);

    void onLeaveApp(MBridgeIds mBridgeIds);

    void onLoadFailed(MBridgeIds mBridgeIds, String str);

    void onLoadSuccessed(MBridgeIds mBridgeIds);

    void onLogImpression(MBridgeIds mBridgeIds);

    void showFullScreen(MBridgeIds mBridgeIds);
}
