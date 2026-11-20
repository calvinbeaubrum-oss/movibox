package com.mbridge.msdk.splash.d;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBSplashShowListener f47148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f47149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f47150c;

    public d(c cVar, MBSplashShowListener mBSplashShowListener, CampaignEx campaignEx) {
        this.f47150c = cVar;
        this.f47148a = mBSplashShowListener;
        this.f47149b = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.f47150c;
        if (cVar != null) {
            cVar.f47119a = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("load_to=");
        stringBuffer.append(this.f47150c.b());
        stringBuffer.append("&");
        stringBuffer.append("allow_skip=");
        stringBuffer.append(this.f47150c.c() ? 1 : 0);
        stringBuffer.append("&");
        stringBuffer.append("countdown=");
        stringBuffer.append(this.f47150c.d());
        stringBuffer.append("&");
        q.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47149b, mBridgeIds.getUnitId(), stringBuffer.toString());
        MBSplashShowListener mBSplashShowListener = this.f47148a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowSuccessed(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i11) {
        com.mbridge.msdk.splash.a.c cVarA;
        MBSplashShowListener mBSplashShowListener = this.f47148a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onDismiss(mBridgeIds, i11);
        }
        c cVar = this.f47150c;
        if (cVar != null) {
            cVar.f47119a = false;
        }
        if (i11 == 6 || i11 == 4 || i11 == 5) {
            CampaignEx campaignEx = this.f47149b;
            String unitId = mBridgeIds.getUnitId();
            if (campaignEx != null) {
                try {
                    cVarA = com.mbridge.msdk.splash.a.c.a().b(unitId).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).c(campaignEx.getId()).e(campaignEx.getCreativeId() + "").a(campaignEx.isBidCampaign());
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                        return;
                    }
                    return;
                }
            } else {
                cVarA = null;
            }
            com.mbridge.msdk.splash.e.a.a(cVarA, unitId, i11);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i11, int i12, int i13) {
        MBSplashShowListener mBSplashShowListener = this.f47148a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayStart(mBridgeIds);
        }
        try {
            q.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47149b, mBridgeIds.getUnitId(), "flb_size=" + i12 + "x" + i11 + "&flb_type=" + i13 + "&");
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(MBridgeIds mBridgeIds, long j11) {
        MBSplashShowListener mBSplashShowListener = this.f47148a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdTick(mBridgeIds, j11);
        }
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        c cVar = this.f47150c;
        if (cVar != null) {
            cVar.f47119a = false;
        }
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47149b, mBridgeIds.getUnitId(), str);
        MBSplashShowListener mBSplashShowListener = this.f47148a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(mBridgeIds, str);
        }
    }

    public final void b(MBridgeIds mBridgeIds) {
        MBSplashShowListener mBSplashShowListener = this.f47148a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdClicked(mBridgeIds);
        }
    }
}
