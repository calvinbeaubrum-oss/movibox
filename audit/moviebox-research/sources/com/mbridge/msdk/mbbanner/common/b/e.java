package com.mbridge.msdk.mbbanner.common.b;

import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e implements H5DownLoadManager.IH5SourceDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45270a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.c.b f45271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f45272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CampaignEx f45273d;

    public e(com.mbridge.msdk.mbbanner.common.c.b bVar, String str, CampaignEx campaignEx) {
        this.f45271b = bVar;
        this.f45272c = str;
        this.f45273d = campaignEx;
    }

    @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
    public void onFailed(String str, String str2) {
        ad.c(f45270a, "DownloadBannerUrlListener HTML FAIL:" + str);
        com.mbridge.msdk.mbbanner.common.c.b bVar = this.f45271b;
        if (bVar != null) {
            bVar.a(this.f45272c, 3, str, false, this.f45273d);
        }
    }

    @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
    public void onSuccess(String str, String str2, boolean z11) {
        ad.c(f45270a, "DownloadBannerUrlListener HTML SUCCESS:" + str);
        com.mbridge.msdk.mbbanner.common.c.b bVar = this.f45271b;
        if (bVar != null) {
            bVar.a(this.f45272c, 3, str, true, this.f45273d);
        }
    }
}
