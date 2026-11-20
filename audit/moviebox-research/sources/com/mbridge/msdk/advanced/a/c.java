package com.mbridge.msdk.advanced.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends a {
    public c(Context context, String str, String str2) {
        super(context, str, str2);
    }

    @Override // com.mbridge.msdk.advanced.a.a
    public final void a(final CampaignEx campaignEx, boolean z11, String str) {
        if (this.f42648d == null) {
            this.f42648d = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f42649e);
        }
        this.f42648d.a(new NativeListener.TrackingExListener() { // from class: com.mbridge.msdk.advanced.a.c.1
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
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, c.this.f42646b);
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final boolean onInterceptDefaultLoadingDialog() {
                return false;
            }

            @Override // com.mbridge.msdk.out.NativeListener.TrackingExListener
            public final void onLeaveApp() {
                c cVar = c.this;
                com.mbridge.msdk.advanced.b.d dVar = cVar.f42647c;
                if (dVar != null) {
                    dVar.d(cVar.f42650f);
                }
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str2) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, c.this.f42646b);
            }

            @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
            public final void onShowLoading(Campaign campaign) {
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str2) {
                ah.b(campaignEx, c.this.f42646b);
            }
        });
        if (z11 && !TextUtils.isEmpty(str)) {
            String str2 = this.f42649e;
            if (campaignEx != null) {
                try {
                    if (!TextUtils.isEmpty(str) && campaignEx.isMraid()) {
                        new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str2, str, campaignEx.isBidCampaign());
                    }
                } catch (Exception e11) {
                    ad.b("NativeAdvancedReport", e11.getMessage());
                }
            }
        }
        campaignEx.setCampaignUnitId(this.f42649e);
        this.f42648d.a(campaignEx);
        if (!this.f42645a.isReportClick()) {
            this.f42645a.setReportClick(true);
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (campaignEx.getNativeVideoTracking() != null && campaignEx.getNativeVideoTracking().l() != null) {
                com.mbridge.msdk.click.a.a(contextC, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().l(), false, false);
            }
        }
        com.mbridge.msdk.advanced.b.d dVar = this.f42647c;
        if (dVar != null) {
            dVar.b(this.f42650f);
        }
    }
}
