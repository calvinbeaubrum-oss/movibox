package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.NativeListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends d {
    public c(MBBannerView mBBannerView, com.mbridge.msdk.mbbanner.common.b.c cVar, String str, String str2, boolean z11, k kVar) {
        super(mBBannerView, cVar, str, str2, z11, kVar);
    }

    @Override // com.mbridge.msdk.mbbanner.common.c.d
    public final void a(CampaignEx campaignEx, boolean z11, String str) {
        if (this.f45325d) {
            if (this.f45327f == null) {
                this.f45327f = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f45326e);
            }
            this.f45327f.a(new NativeListener.TrackingExListener() { // from class: com.mbridge.msdk.mbbanner.common.c.c.1
                @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                public final void onDismissLoading(Campaign campaign) {
                }

                @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                public final void onDownloadFinish(Campaign campaign) {
                }

                @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                public final void onDownloadProgress(int i11) {
                }

                @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                public final void onDownloadStart(Campaign campaign) {
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onFinishRedirection(Campaign campaign, String str2) {
                    ah.a(campaign, c.this.f45324c);
                }

                @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                public final boolean onInterceptDefaultLoadingDialog() {
                    return false;
                }

                @Override // com.mbridge.msdk.out.NativeListener.TrackingExListener
                public final void onLeaveApp() {
                    com.mbridge.msdk.mbbanner.common.b.c cVar = c.this.f45322a;
                    if (cVar != null) {
                        cVar.b();
                    }
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onRedirectionFailed(Campaign campaign, String str2) {
                    ah.a(campaign, c.this.f45324c);
                }

                @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
                public final void onShowLoading(Campaign campaign) {
                }

                @Override // com.mbridge.msdk.out.BaseTrackingListener
                public final void onStartRedirection(Campaign campaign, String str2) {
                    ah.b(campaign, c.this.f45324c);
                }
            });
            campaignEx.setCampaignUnitId(this.f45326e);
            this.f45327f.a(campaignEx);
            if (!this.f45323b.isReportClick()) {
                this.f45323b.setReportClick(true);
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                if (campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
                    com.mbridge.msdk.click.a.a(contextC, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
                }
            }
            com.mbridge.msdk.mbbanner.common.b.c cVar = this.f45322a;
            if (cVar != null) {
                cVar.a();
            }
        }
    }
}
