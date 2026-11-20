package com.mbridge.msdk.splash.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MBSplashLoadListener f47113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f47114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f47116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MBridgeIds f47117e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f47114b = cVar;
        this.f47117e = mBridgeIds;
        if (mBridgeIds != null) {
            this.f47115c = mBridgeIds.getUnitId();
        }
    }

    public final void a(com.mbridge.msdk.foundation.c.b bVar, int i11) {
        c cVar = this.f47114b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        String str = "";
        if (bVar != null) {
            String strB = bVar.b();
            if (!TextUtils.isEmpty(strB)) {
                str = strB;
            }
        }
        MBSplashLoadListener mBSplashLoadListener = this.f47113a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.f47117e, str, i11);
        }
        this.f47114b.a(false);
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, this.f47115c, !TextUtils.isEmpty(this.f47116d), bVar != null ? bVar.c() : null);
    }

    public final void a(CampaignEx campaignEx, int i11) {
        c cVar;
        c cVar2 = this.f47114b;
        if (cVar2 == null || !cVar2.a() || campaignEx == null) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.f47113a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadSuccessed(this.f47117e, i11);
            this.f47113a.isSupportZoomOut(this.f47117e, campaignEx.getFlb() == 1);
        }
        this.f47114b.a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), arrayList, this.f47115c, campaignEx.isBidCampaign());
        if (i11 != 2 || (cVar = this.f47114b) == null) {
            return;
        }
        cVar.a(campaignEx, 0, true);
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        this.f47113a = mBSplashLoadListener;
    }

    public final void a(String str) {
        this.f47116d = str;
    }
}
