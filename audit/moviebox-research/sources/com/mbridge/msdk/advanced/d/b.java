package com.mbridge.msdk.advanced.d;

import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.out.Frame;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f42823a;

    public b(int i11) {
        this.f42823a = i11;
    }

    public abstract void a(int i11, String str);

    public abstract void a(CampaignUnit campaignUnit, int i11);

    @Override // com.mbridge.msdk.advanced.d.d
    public final void a(List<Frame> list) {
    }

    @Override // com.mbridge.msdk.advanced.d.d
    public final void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, CampaignUnit campaignUnit) {
        a(campaignUnit, this.f42823a);
    }

    @Override // com.mbridge.msdk.advanced.d.d
    public final void b(int i11, String str) {
        a(i11, str);
    }
}
