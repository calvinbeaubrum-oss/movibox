package com.mbridge.msdk.video.bt.module.b;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f47514a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f47515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f47516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f47518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f47519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f47520i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47521j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47522k = false;

    /* JADX WARN: Code duplicated, block: B:10:0x0042  */
    public d(Context context, boolean z11, com.mbridge.msdk.videocommon.d.c cVar, CampaignEx campaignEx, h hVar, String str, String str2) {
        long jAc;
        this.f47514a = hVar;
        this.f47515d = cVar;
        this.f47516e = str2;
        this.f47517f = str;
        this.f47518g = z11;
        this.f47519h = context;
        try {
            String strK = com.mbridge.msdk.foundation.controller.c.m().k();
            if (TextUtils.isEmpty(strK)) {
                jAc = 0;
            } else {
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(strK);
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = i.a();
                }
                if (gVarB != null) {
                    jAc = gVarB.ac() * 1000;
                } else {
                    jAc = 0;
                }
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (campaignEx != null) {
                if (!campaignEx.isSpareOffer(jF, jAc)) {
                    campaignEx.setSpareOfferFlag(0);
                    campaignEx.setCbt(0);
                    return;
                }
                campaignEx.setSpareOfferFlag(1);
                if (cVar.y() == 1) {
                    campaignEx.setCbt(1);
                } else {
                    campaignEx.setCbt(0);
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        super.a(bVar);
        h hVar = this.f47514a;
        if (hVar == null || this.f47520i) {
            return;
        }
        this.f47520i = true;
        this.f47511c = true;
        hVar.a(bVar);
        this.f47514a.a(2, this.f47517f, this.f47516e);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str) {
        super.a(bVar, str);
        h hVar = this.f47514a;
        if (hVar == null || this.f47521j) {
            return;
        }
        this.f47521j = true;
        this.f47511c = true;
        hVar.a(bVar, str);
        this.f47514a.a(4, this.f47517f, this.f47516e);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, boolean z11, com.mbridge.msdk.videocommon.b.c cVar) {
        super.a(bVar, z11, cVar);
        h hVar = this.f47514a;
        if (hVar == null || this.f47522k) {
            return;
        }
        this.f47522k = true;
        hVar.a(7, this.f47517f, this.f47516e);
        this.f47514a.a(bVar, z11, cVar);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(String str, String str2) {
        super.a(str, str2);
        h hVar = this.f47514a;
        if (hVar != null) {
            hVar.a(str, str2);
            this.f47514a.a(5, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z11, int i11) {
        super.a(z11, i11);
        h hVar = this.f47514a;
        if (hVar == null || this.f47522k) {
            return;
        }
        hVar.a(z11, i11);
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void a(boolean z11, String str, String str2) {
        super.a(z11, str, str2);
        h hVar = this.f47514a;
        if (hVar != null) {
            hVar.a(z11, str, str2);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
    public final void b(String str, String str2) {
        super.b(str, str2);
        h hVar = this.f47514a;
        if (hVar != null) {
            hVar.b(str, str2);
            this.f47514a.a(6, str, str2);
        }
    }
}
