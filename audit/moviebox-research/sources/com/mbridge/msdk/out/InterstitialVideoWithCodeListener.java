package com.mbridge.msdk.out;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.f.a;
import com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class InterstitialVideoWithCodeListener implements InterstitialVideoListener {
    @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
    public void onShowFail(MBridgeIds mBridgeIds, String str) {
        onShowFailWithCode(mBridgeIds, 3900, str);
    }

    public abstract void onShowFailWithCode(MBridgeIds mBridgeIds, int i11, String str);

    @Override // com.mbridge.msdk.interstitialvideo.out.InterstitialVideoListener
    public void onVideoLoadFail(MBridgeIds mBridgeIds, String str) {
        onVideoLoadFailWithCode(mBridgeIds, a.a(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, str), str);
    }

    public abstract void onVideoLoadFailWithCode(MBridgeIds mBridgeIds, int i11, String str);
}
