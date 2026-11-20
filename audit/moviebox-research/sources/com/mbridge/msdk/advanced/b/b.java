package com.mbridge.msdk.advanced.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeAdvancedAdListener f42755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f42756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MBridgeIds f42757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f42758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f42759e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f42756b = cVar;
        this.f42757c = mBridgeIds;
        this.f42758d = mBridgeIds.getUnitId();
    }

    public final void a(com.mbridge.msdk.foundation.c.b bVar, int i11) {
        c cVar = this.f42756b;
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
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42755a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.f42757c, str);
        }
        this.f42756b.a(false);
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, this.f42758d, !TextUtils.isEmpty(this.f42759e), bVar != null ? bVar.c() : null);
    }

    public final void a(CampaignEx campaignEx, int i11) {
        c cVar;
        ad.b("NativeAdvancedLoadManager", "onLoadSuccessed: " + i11);
        c cVar2 = this.f42756b;
        if (cVar2 == null || !cVar2.a() || campaignEx == null) {
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42755a;
        if (nativeAdvancedAdListener != null && this.f42756b != null) {
            nativeAdvancedAdListener.onLoadSuccessed(this.f42757c);
        }
        this.f42756b.a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), arrayList, this.f42758d, campaignEx.isBidCampaign());
        if (i11 != 2 || (cVar = this.f42756b) == null) {
            return;
        }
        cVar.a(campaignEx, true);
    }

    public final void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.f42755a = nativeAdvancedAdListener;
    }

    public final void a(String str) {
        this.f42759e = str;
    }
}
