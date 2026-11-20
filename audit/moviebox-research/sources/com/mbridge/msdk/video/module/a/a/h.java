package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends k {
    public h(CampaignEx campaignEx, com.mbridge.msdk.videocommon.download.a aVar, com.mbridge.msdk.videocommon.b.c cVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i11, boolean z11) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z11);
    }

    @Override // com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i11, Object obj) {
        if (i11 == 100) {
            g();
            f();
            e();
            a(2);
        } else if (i11 == 109) {
            b(2);
        } else if (i11 == 122) {
            a();
        } else if (i11 != 129) {
            String str = "";
            if (i11 == 118) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(3, str);
            } else if (i11 == 119) {
                if (obj != null && (obj instanceof String)) {
                    str = (String) obj;
                }
                a(4, str);
            }
        } else {
            CampaignEx campaignEx = this.f48025b;
            if (campaignEx != null && campaignEx.getPlayable_ads_without_video() == 2) {
                g();
                f();
                e();
                a(1);
            }
        }
        super.a(i11, obj);
    }
}
