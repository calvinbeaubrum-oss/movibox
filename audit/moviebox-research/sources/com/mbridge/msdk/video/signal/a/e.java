package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e implements com.mbridge.msdk.video.signal.f, com.mbridge.msdk.video.signal.h {
    @Override // com.mbridge.msdk.video.signal.f
    public void configurationChanged(int i11, int i12, int i13) {
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean endCardShowing() {
        ad.a("DefaultJSContainerModule", "endCardShowing");
        return true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void hideAlertWebview() {
        ad.a("DefaultJSContainerModule", "hideAlertWebview ,msg=");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void ivRewardAdsWithoutVideo(String str) {
        ad.a("DefaultJSContainerModule", "ivRewardAdsWithoutVideo,params=");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean miniCardShowing() {
        ad.a("DefaultJSContainerModule", "miniCardShowing");
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        ad.a("DefaultJSContainerModule", "notifyCloseBtn:state = " + i11);
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void readyStatus(int i11) {
        ad.a("DefaultJSContainerModule", "readyStatus:isReady=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void resizeMiniCard(int i11, int i12, int i13) {
        ad.a("DefaultJSContainerModule", "showMiniCard width = " + i11 + " height = " + i12 + " radius = " + i13);
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean showAlertWebView() {
        ad.a("DefaultJSContainerModule", "showAlertWebView ,msg=");
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showEndcard(int i11) {
        ad.a("DefaultJSContainerModule", "showEndcard,type=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showMiniCard(int i11, int i12, int i13, int i14, int i15) {
        ad.a("DefaultJSContainerModule", "showMiniCard top = " + i11 + " left = " + i12 + " width = " + i13 + " height = " + i14 + " radius = " + i15);
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoClickView(int i11) {
        ad.a("DefaultJSContainerModule", "showVideoClickView:" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoEndCover() {
        ad.a("DefaultJSContainerModule", "showVideoEndCover");
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        ad.a("DefaultJSContainerModule", "toggleCloseBtn:state=" + i11);
    }
}
