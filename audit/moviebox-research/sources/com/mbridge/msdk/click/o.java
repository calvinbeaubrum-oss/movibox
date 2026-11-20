package com.mbridge.msdk.click;

import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ah;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o {
    public static boolean a(String str, CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult) {
        if (campaignEx != null) {
            campaignEx.getLinkType();
        }
        if (!ah.a.b(str)) {
            jumpLoaderResult.setCode(2);
            jumpLoaderResult.setUrl(str);
            return false;
        }
        jumpLoaderResult.setCode(1);
        jumpLoaderResult.setUrl(str);
        jumpLoaderResult.setjumpDone(true);
        return true;
    }
}
