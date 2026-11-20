package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a.i;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.a.m;
import com.mbridge.msdk.video.signal.a.n;
import com.mbridge.msdk.video.signal.a.o;
import com.mbridge.msdk.video.signal.a.q;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Activity f48422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WebView f48423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MBridgeVideoView f48424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MBridgeContainerView f48425k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CampaignEx f48426l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MBridgeBTContainer f48427m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.video.signal.a.InterfaceC0530a f48428n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f48429o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List<CampaignEx> f48430p;

    public b(Activity activity) {
        this.f48422h = activity;
    }

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a) {
        this.f48422h = activity;
        this.f48423i = webView;
        this.f48424j = mBridgeVideoView;
        this.f48425k = mBridgeContainerView;
        this.f48426l = campaignEx;
        this.f48428n = interfaceC0530a;
        this.f48429o = mBridgeVideoView.getUnitId();
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.f48422h = activity;
        this.f48427m = mBridgeBTContainer;
        this.f48423i = webView;
    }

    public final void a(k kVar) {
        this.f48416b = kVar;
    }

    public final void a(List<CampaignEx> list) {
        this.f48430p = list;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.b getActivityProxy() {
        WebView webView = this.f48423i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.f48415a == null) {
            this.f48415a = new i(webView);
        }
        return this.f48415a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.i getIJSRewardVideoV1() {
        Activity activity;
        MBridgeContainerView mBridgeContainerView = this.f48425k;
        if (mBridgeContainerView == null || (activity = this.f48422h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f48420f == null) {
            this.f48420f = new o(activity, mBridgeContainerView);
        }
        return this.f48420f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final c getJSBTModule() {
        if (this.f48422h == null || this.f48427m == null) {
            return super.getJSBTModule();
        }
        if (this.f48421g == null) {
            this.f48421g = new j(this.f48422h, this.f48427m);
        }
        return this.f48421g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final d getJSCommon() {
        CampaignEx campaignEx;
        List<CampaignEx> list;
        Activity activity = this.f48422h;
        if (activity == null || (campaignEx = this.f48426l) == null) {
            return super.getJSCommon();
        }
        if (this.f48416b == null) {
            this.f48416b = new k(activity, campaignEx);
        }
        if (this.f48426l.getDynamicTempCode() == 5 && (list = this.f48430p) != null) {
            d dVar = this.f48416b;
            if (dVar instanceof k) {
                ((k) dVar).a(list);
            }
        }
        this.f48416b.a(this.f48422h);
        this.f48416b.a(this.f48429o);
        this.f48416b.a(this.f48428n);
        return this.f48416b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final f getJSContainerModule() {
        MBridgeContainerView mBridgeContainerView = this.f48425k;
        if (mBridgeContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.f48419e == null) {
            this.f48419e = new m(mBridgeContainerView);
        }
        return this.f48419e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final g getJSNotifyProxy() {
        WebView webView = this.f48423i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.f48418d == null) {
            this.f48418d = new n(webView);
        }
        return this.f48418d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.j getJSVideoModule() {
        MBridgeVideoView mBridgeVideoView = this.f48424j;
        if (mBridgeVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.f48417c == null) {
            this.f48417c = new q(mBridgeVideoView);
        }
        return this.f48417c;
    }
}
