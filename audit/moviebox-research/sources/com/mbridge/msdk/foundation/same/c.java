package com.mbridge.msdk.foundation.same;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {
    public static int a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return -1;
        }
        try {
            return !TextUtils.isEmpty(campaignEx.getMof_template_url()) ? ai.b(campaignEx.getMof_template_url()) : ai.b(str);
        } catch (Exception e11) {
            ad.b("SameTools", e11.getMessage());
            return -1;
        }
    }
}
