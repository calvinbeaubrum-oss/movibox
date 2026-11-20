package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeVideoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class q extends r {
    public q(MBridgeVideoView mBridgeVideoView) {
        this.f48116a = mBridgeVideoView;
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void alertWebViewShowed() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.alertWebViewShowed();
        } else {
            super.alertWebViewShowed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void closeVideoOperate(int i11, int i12) {
        super.closeVideoOperate(i11, i12);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.closeVideoOperate(i11, i12);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void dismissAllAlert() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.dismissAllAlert();
        } else {
            super.dismissAllAlert();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewHeight() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewHeight() : super.getBorderViewHeight();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewLeft() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewLeft() : super.getBorderViewLeft();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewRadius() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewRadius() : super.getBorderViewRadius();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewTop() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewTop() : super.getBorderViewTop();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewWidth() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewWidth() : super.getBorderViewWidth();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final String getCurrentProgress() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.getCurrentProgress() : super.getCurrentProgress();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void hideAlertView(int i11) {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.hideAlertView(i11);
        } else {
            super.hideAlertView(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final boolean isH5Canvas() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        return mBridgeVideoView != null ? mBridgeVideoView.isH5Canvas() : super.isH5Canvas();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void progressBarOperate(int i11) {
        super.progressBarOperate(i11);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressBarOperate(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void progressOperate(int i11, int i12) {
        super.progressOperate(i11, i12);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressOperate(i11, i12);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setCover(boolean z11) {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(z11);
        } else {
            super.setCover(z11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setMiniEndCardState(boolean z11) {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setMiniEndCardState(z11);
        } else {
            super.setMiniEndCardState(z11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setScaleFitXY(int i11) {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setScaleFitXY(i11);
        } else {
            super.setScaleFitXY(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setVisible(int i11) {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVisible(i11);
        } else {
            super.setVisible(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void showAlertView() {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showAlertView();
        } else {
            super.showAlertView();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void showIVRewardAlertView(String str) {
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showIVRewardAlertView(str);
        } else {
            super.showIVRewardAlertView(str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void showVideoLocation(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        super.showVideoLocation(i11, i12, i13, i14, i15, i16, i17, i18, i19);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showVideoLocation(i11, i12, i13, i14, i15, i16, i17, i18, i19);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void soundOperate(int i11, int i12) {
        super.soundOperate(i11, i12);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i11, i12);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void soundOperate(int i11, int i12, String str) {
        super.soundOperate(i11, i12, str);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i11, i12, str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void videoOperate(int i11) {
        super.videoOperate(i11);
        MBridgeVideoView mBridgeVideoView = this.f48116a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.videoOperate(i11);
        }
    }
}
