package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v f46354c;

    public j(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar) {
        super(bVar, aVar);
        this.f46354c = new v(a(), b(), this);
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.c
    public final boolean a_() {
        if (b() == null) {
            return false;
        }
        CampaignEx campaignExG = b().g();
        if (campaignExG == null || TextUtils.isEmpty(campaignExG.getendcard_url())) {
            return true;
        }
        ArrayList<Integer> rsIgnoreCheckRule = campaignExG.getRsIgnoreCheckRule();
        if (rsIgnoreCheckRule != null && rsIgnoreCheckRule.size() != 0) {
            try {
                return rsIgnoreCheckRule.contains(2);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.o
    public final int h() {
        return 4;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final String j() {
        CampaignEx campaignExG;
        return (b() == null || (campaignExG = b().g()) == null || TextUtils.isEmpty(campaignExG.getendcard_url())) ? "" : campaignExG.getendcard_url();
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.a, com.mbridge.msdk.newreward.function.d.c.o
    public final q k() {
        return this.f46354c;
    }
}
