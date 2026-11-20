package com.mbridge.msdk.newreward.function.d.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.newreward.function.d.c.d;
import com.mbridge.msdk.newreward.function.d.c.f;
import com.mbridge.msdk.newreward.function.d.c.g;
import com.mbridge.msdk.newreward.function.d.c.h;
import com.mbridge.msdk.newreward.function.d.c.j;
import com.mbridge.msdk.newreward.function.d.c.k;
import com.mbridge.msdk.newreward.function.d.c.l;
import com.mbridge.msdk.newreward.function.d.c.m;
import com.mbridge.msdk.newreward.function.d.c.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f46271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f46272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f46273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f46274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f46275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d<?> f46276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private n f46277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d<?> f46278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f46279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f46280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private m f46281k;

    public a(b bVar) {
        this.f46271a = bVar;
    }

    public final m a() {
        CampaignEx.c rewardTemplateMode;
        m mVar = this.f46281k;
        if (mVar != null) {
            return mVar;
        }
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) {
            return null;
        }
        String strC = rewardTemplateMode.c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        if (this.f46281k == null) {
            this.f46281k = new m(this.f46271a, this, strC);
        }
        return this.f46281k;
    }

    public final void a(CampaignEx campaignEx) {
        this.f46272b = campaignEx;
    }

    public final void a(String str) {
        this.f46273c = str;
    }

    public final h b() {
        h hVar = this.f46280j;
        if (hVar != null) {
            return hVar;
        }
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getEndScreenUrl())) {
            return null;
        }
        if (this.f46280j == null) {
            this.f46280j = new h(this.f46271a, this);
        }
        return this.f46280j;
    }

    public final void b(String str) {
        this.f46274d = str;
    }

    public final d<?> c() {
        d<?> dVar = this.f46276f;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return null;
        }
        String strE = campaignEx.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        if (this.f46276f == null) {
            if (com.mbridge.msdk.newreward.function.h.a.b(strE)) {
                this.f46276f = new g(this.f46271a, this);
            } else {
                this.f46276f = new k(this.f46271a, this);
            }
        }
        return this.f46276f;
    }

    public final void c(String str) {
        this.f46275e = str;
    }

    public final n d() {
        n nVar = this.f46277g;
        if (nVar != null) {
            return nVar;
        }
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            return null;
        }
        if (this.f46277g == null) {
            this.f46277g = new n(this.f46271a, this);
        }
        return this.f46277g;
    }

    public final l e() {
        l lVar = this.f46279i;
        if (lVar != null) {
            return lVar;
        }
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getMraid())) {
            return null;
        }
        if (this.f46279i == null) {
            this.f46279i = new l(this.f46271a, this);
        }
        return this.f46279i;
    }

    public final d<?> f() {
        d<?> dVar = this.f46278h;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx == null) {
            return null;
        }
        String str = campaignEx.getendcard_url();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f46278h == null) {
            if (!com.mbridge.msdk.newreward.function.h.a.b(str) || ai.l(str)) {
                this.f46278h = new j(this.f46271a, this);
            } else {
                this.f46278h = new f(this.f46271a, this);
            }
        }
        return this.f46278h;
    }

    public final CampaignEx g() {
        return this.f46272b;
    }

    public final b h() {
        return this.f46271a;
    }

    public final boolean i() {
        CampaignEx campaignEx = this.f46272b;
        if (campaignEx != null) {
            return campaignEx.isMraid();
        }
        return false;
    }
}
