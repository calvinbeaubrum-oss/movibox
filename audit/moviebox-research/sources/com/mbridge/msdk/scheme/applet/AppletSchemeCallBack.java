package com.mbridge.msdk.scheme.applet;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AppletSchemeCallBack implements IAppletSchemeCallBack {
    private static final String TAG = "AppletSchemeCallBack";

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onAppletSchemeRequestFailed(int i11, String str, String str2) {
        try {
            onRequestFailed(i11, str, str2);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(TAG, e11.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onAppletSchemeRequestStart() {
        try {
            onRequestStart();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(TAG, e11.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onAppletSchemeRequestSuccess(String str) {
        try {
            onRequestSuccess(str);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(TAG, e11.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.IAppletSchemeCallBack
    public void onNetworkError(int i11, String str, String str2) {
        try {
            onRequestFailed(i11, str, str2);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(TAG, e11.getMessage());
            }
        }
    }

    public abstract void onRequestFailed(int i11, String str, String str2);

    public abstract void onRequestStart();

    public abstract void onRequestSuccess(String str);
}
