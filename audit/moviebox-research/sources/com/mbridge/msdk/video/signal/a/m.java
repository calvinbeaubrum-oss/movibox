package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeContainerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBridgeContainerView f48112a;

    public m(MBridgeContainerView mBridgeContainerView) {
        this.f48112a = mBridgeContainerView;
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void configurationChanged(int i11, int i12, int i13) {
        super.configurationChanged(i11, i12, i13);
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.configurationChanged(i11, i12, i13);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final boolean endCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.endCardShowing();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return super.endCardShowing();
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void hideAlertWebview() {
        super.hideAlertWebview();
        MBridgeContainerView mBridgeContainerView = this.f48112a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.hideAlertWebview();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void ivRewardAdsWithoutVideo(String str) {
        super.ivRewardAdsWithoutVideo(str);
        MBridgeContainerView mBridgeContainerView = this.f48112a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.ivRewardAdsWithoutVideo(str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final boolean miniCardShowing() {
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                return mBridgeContainerView.miniCardShowing();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return super.miniCardShowing();
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void readyStatus(int i11) {
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.readyStatus(i11);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.readyStatus(i11);
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void resizeMiniCard(int i11, int i12, int i13) {
        super.resizeMiniCard(i11, i12, i13);
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.resizeMiniCard(i11, i12, i13);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final boolean showAlertWebView() {
        super.showAlertWebView();
        MBridgeContainerView mBridgeContainerView = this.f48112a;
        if (mBridgeContainerView != null) {
            return mBridgeContainerView.showAlertWebView();
        }
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void showEndcard(int i11) {
        super.showEndcard(i11);
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showEndcard(i11);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void showMiniCard(int i11, int i12, int i13, int i14, int i15) {
        super.showMiniCard(i11, i12, i13, i14, i15);
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showMiniCard(i11, i12, i13, i14, i15);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void showVideoClickView(int i11) {
        super.showVideoClickView(i11);
        MBridgeContainerView mBridgeContainerView = this.f48112a;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.showVideoClickView(i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.f
    public final void showVideoEndCover() {
        super.showVideoEndCover();
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.showVideoEndCover();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.e, com.mbridge.msdk.video.signal.h
    public final void toggleCloseBtn(int i11) {
        super.toggleCloseBtn(i11);
        try {
            MBridgeContainerView mBridgeContainerView = this.f48112a;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.toggleCloseBtn(i11);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
