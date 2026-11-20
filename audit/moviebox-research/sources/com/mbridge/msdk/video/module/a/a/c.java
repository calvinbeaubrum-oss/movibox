package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private IJSFactory f48015k;

    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i11, boolean z11) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z11);
        this.f48015k = iJSFactory;
        if (iJSFactory == null) {
            this.f48024a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.a.a.d, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i11, Object obj) {
        if (this.f48024a) {
            if (i11 != 8) {
                if (i11 == 105) {
                    this.f48015k.getJSNotifyProxy().a(3, obj.toString());
                    i11 = -1;
                } else if (i11 == 107) {
                    this.f48015k.getJSContainerModule().showVideoClickView(-1);
                    this.f48015k.getJSVideoModule().setCover(false);
                    this.f48015k.getJSVideoModule().setMiniEndCardState(false);
                    this.f48015k.getJSVideoModule().videoOperate(1);
                } else if (i11 == 112) {
                    this.f48015k.getJSVideoModule().setCover(true);
                    this.f48015k.getJSVideoModule().setMiniEndCardState(true);
                    this.f48015k.getJSVideoModule().videoOperate(2);
                } else if (i11 == 115) {
                    com.mbridge.msdk.video.signal.j jSVideoModule = this.f48015k.getJSVideoModule();
                    this.f48015k.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
                }
            } else if (this.f48015k.getJSContainerModule().showAlertWebView()) {
                this.f48015k.getJSVideoModule().alertWebViewShowed();
            } else {
                this.f48015k.getJSVideoModule().showAlertView();
            }
        }
        super.a(i11, obj);
    }
}
