package com.mbridge.msdk.out;

import com.mbridge.msdk.f.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MBSplashLoadWithCodeListener implements MBSplashLoadListener {
    @Override // com.mbridge.msdk.out.MBSplashLoadListener
    public void onLoadFailed(MBridgeIds mBridgeIds, String str, int i11) {
        onLoadFailedWithCode(mBridgeIds, a.a(5000, str), str, i11);
    }

    public abstract void onLoadFailedWithCode(MBridgeIds mBridgeIds, int i11, String str, int i12);
}
