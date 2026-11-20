package com.mbridge.msdk.video.module.a.a;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.gslb.Worker;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d extends k {
    public d(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i11, boolean z11) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z11);
    }

    @Override // com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i11, Object obj) {
        super.a(i11, obj);
        if (this.f48024a) {
            try {
                CampaignEx campaignEx = this.f48025b;
                if (campaignEx != null && campaignEx.getDynamicTempCode() == 5) {
                    b(obj.toString());
                }
            } catch (Exception unused) {
            }
            if (i11 != 105 && i11 != 106 && i11 != 113) {
                if (i11 == 122) {
                    a();
                    return;
                }
                switch (i11) {
                    case 109:
                        b(2);
                        a(2);
                        break;
                    case Worker.WHAT_QUIT /* 110 */:
                        b(1);
                        a(1);
                        break;
                    case 111:
                        a(1);
                        break;
                }
            }
            com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
            if (i11 != 105) {
                String noticeUrl = this.f48025b.getNoticeUrl();
                if (!TextUtils.isEmpty(noticeUrl)) {
                    if (noticeUrl.contains(com.mbridge.msdk.foundation.same.a.f44377m)) {
                        noticeUrl = noticeUrl.replace(com.mbridge.msdk.foundation.same.a.f44377m + "=" + Uri.parse(noticeUrl).getQueryParameter(com.mbridge.msdk.foundation.same.a.f44377m), com.mbridge.msdk.foundation.same.a.f44377m + "=2");
                    } else {
                        noticeUrl = noticeUrl + "&" + com.mbridge.msdk.foundation.same.a.f44377m + "=2";
                    }
                }
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b, this.f48030g, noticeUrl, true, false, com.mbridge.msdk.click.a.a.f43074i);
            }
        }
    }
}
