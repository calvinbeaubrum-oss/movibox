package com.mbridge.msdk.dycreator.f;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements com.mbridge.msdk.dycreator.f.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DyOption f43677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f43678b;

    public a(DyOption dyOption) {
        this.f43677a = dyOption;
        this.f43678b = dyOption.getCampaignEx();
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public final CampaignEx getBindData() {
        return this.f43678b;
    }

    @Override // com.mbridge.msdk.dycreator.f.a.a
    public final DyOption getEffectData() {
        return this.f43677a;
    }
}
