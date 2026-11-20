package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MBridgeVideoView f48013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MBridgeContainerView f48014l;

    public b(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i11, boolean z11) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z11);
        this.f48013k = mBridgeVideoView;
        this.f48014l = mBridgeContainerView;
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f48024a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.a.a.d, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i11, Object obj) {
        if (this.f48024a) {
            if (i11 == 8) {
                MBridgeContainerView mBridgeContainerView = this.f48014l;
                if (mBridgeContainerView == null) {
                    MBridgeVideoView mBridgeVideoView = this.f48013k;
                    if (mBridgeVideoView != null) {
                        mBridgeVideoView.showAlertView();
                    }
                } else if (mBridgeContainerView.showAlertWebView()) {
                    MBridgeVideoView mBridgeVideoView2 = this.f48013k;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.alertWebViewShowed();
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView3 = this.f48013k;
                    if (mBridgeVideoView3 != null) {
                        mBridgeVideoView3.showAlertView();
                    }
                }
            } else if (i11 == 107) {
                this.f48014l.showVideoClickView(-1);
                this.f48013k.setCover(false);
                this.f48013k.setMiniEndCardState(false);
                this.f48013k.videoOperate(1);
            } else if (i11 == 112) {
                this.f48013k.setCover(true);
                this.f48013k.setMiniEndCardState(true);
                this.f48013k.videoOperate(2);
            } else if (i11 == 115) {
                this.f48014l.resizeMiniCard(this.f48013k.getBorderViewWidth(), this.f48013k.getBorderViewHeight(), this.f48013k.getBorderViewRadius());
            }
        }
        super.a(i11, obj);
    }
}
