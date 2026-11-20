package com.mbridge.msdk.advanced.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected NativeAdvancedAdListener f42788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected CampaignEx f42789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected c f42790c;

    public d(c cVar, NativeAdvancedAdListener nativeAdvancedAdListener, CampaignEx campaignEx) {
        this.f42790c = cVar;
        this.f42788a = nativeAdvancedAdListener;
        this.f42789b = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.f42790c;
        if (cVar != null) {
            cVar.f42761a = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("load_to=");
        stringBuffer.append("0");
        stringBuffer.append("&");
        stringBuffer.append("allow_skip=");
        stringBuffer.append(this.f42790c.c());
        stringBuffer.append("&");
        q.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f42789b, mBridgeIds.getUnitId(), stringBuffer.toString());
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42788a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLogImpression(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f42789b, mBridgeIds.getUnitId(), str);
    }

    public final void b(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42788a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onClick(mBridgeIds);
        }
    }

    public final void c(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42788a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onClose(mBridgeIds);
            c cVar = this.f42790c;
            if (cVar != null) {
                cVar.f42761a = false;
            }
        }
    }

    public final void d(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42788a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLeaveApp(mBridgeIds);
        }
    }

    public final void e(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42788a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.showFullScreen(mBridgeIds);
        }
    }

    public final void f(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f42788a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.closeFullScreen(mBridgeIds);
        }
    }
}
