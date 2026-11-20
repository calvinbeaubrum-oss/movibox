package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class h implements com.mbridge.msdk.video.signal.j {
    @Override // com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        ad.a("DefaultJSVideoModule", "alertWebViewShowed:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i11, int i12) {
        ad.a("DefaultJSVideoModule", "closeOperte:close=" + i11 + "closeViewVisible=" + i12);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        ad.a("DefaultJSVideoModule", "dismissAllAlert");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        ad.a("DefaultJSVideoModule", "getCurrentProgress");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i11) {
        ad.a("DefaultJSVideoModule", "hideAlertView:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void notifyCloseBtn(int i11) {
        ad.a("DefaultJSVideoModule", "notifyCloseBtn:" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i11) {
        ad.a("DefaultJSVideoModule", "progressBarOperate:progressViewVisible=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressOperate(int i11, int i12) {
        ad.a("DefaultJSVideoModule", "progressOperate:progress=" + i11 + "progressViewVisible=" + i12);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setCover(boolean z11) {
        ad.a("DefaultJSVideoModule", "setCover:" + z11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z11) {
        ad.a("DefaultJSVideoModule", "setMiniEndCardState");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i11) {
        ad.a("DefaultJSVideoModule", "setScaleFitXY:" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setVisible(int i11) {
        ad.a("DefaultJSVideoModule", "setVisible:" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        ad.a("DefaultJSVideoModule", "showAlertView:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        ad.a("DefaultJSVideoModule", "showAlertView:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        ad.a("DefaultJSVideoModule", "showVideoLocation:marginTop=" + i11 + ",marginLeft=" + i12 + ",width=" + i13 + ",height=" + i14 + ",radius=" + i15 + ",borderTop=" + i16 + ",borderTop=" + i16 + ",borderLeft=" + i17 + ",borderWidth=" + i18 + ",borderHeight=" + i19);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i11, int i12) {
        ad.a("DefaultJSVideoModule", "soundOperate:mute=" + i11 + ",soundViewVisible=" + i12);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i11, int i12, String str) {
        ad.a("DefaultJSVideoModule", "soundOperate:mute=" + i11 + ",soundViewVisible=" + i12 + ",pt=" + str);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void videoOperate(int i11) {
        ad.a("DefaultJSVideoModule", "videoOperate:" + i11);
    }
}
