package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.video.module.MBridgeClickMiniCardView;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBridgeClickMiniCardView f48021a;

    public g(MBridgeClickMiniCardView mBridgeClickMiniCardView, com.mbridge.msdk.video.module.a.a aVar) {
        super(aVar);
        this.f48021a = mBridgeClickMiniCardView;
    }

    @Override // com.mbridge.msdk.video.module.a.a.i, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i11, Object obj) {
        boolean z11 = false;
        switch (i11) {
            case 100:
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f48021a;
                if (mBridgeClickMiniCardView != null) {
                    mBridgeClickMiniCardView.webviewshow();
                    MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f48021a;
                    mBridgeClickMiniCardView2.onSelfConfigurationChanged(mBridgeClickMiniCardView2.getResources().getConfiguration());
                }
                break;
            case 101:
            case 102:
                z11 = true;
                break;
            case Worker.WHAT_SYNC_DATA /* 103 */:
                i11 = 107;
                break;
        }
        if (z11) {
            return;
        }
        super.a(i11, obj);
    }
}
