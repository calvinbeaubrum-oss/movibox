package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.config.utils.ConstantsKt;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout;
import com.transsion.gslb.Utils;
import com.transsion.gslb.Worker;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f46532b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f46533a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f46534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f46535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f46536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f46537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile List<WindVaneWebView> f46538g;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f46573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f46574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f46575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f46576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f46577e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f46578f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f46579g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f46580h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f46581i;

        public a(boolean z11, boolean z12, int i11, int i12, String str, String str2, int i13, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f46573a = z11;
            this.f46574b = z12;
            this.f46575c = i11;
            this.f46576d = i12;
            this.f46577e = str;
            this.f46578f = str2;
            this.f46579g = i13;
            this.f46580h = copyOnWriteArrayList;
            this.f46581i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0511b extends com.mbridge.msdk.mbsignalcommon.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f46582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f46583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f46584c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f46585d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f46586e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f46587f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f46588g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f46589h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f46590i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private com.mbridge.msdk.videocommon.a.C0532a f46591j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private CampaignEx f46592k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f46593l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private com.mbridge.msdk.videocommon.d.c f46594m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private final j f46595n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f46596o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f46597p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f46598q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f46599r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f46600s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f46601t;

        public C0511b(boolean z11, Handler handler, Runnable runnable, boolean z12, boolean z13, int i11, String str, String str2, String str3, String str4, com.mbridge.msdk.videocommon.a.C0532a c0532a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z14, long j11) {
            this.f46582a = handler;
            this.f46583b = runnable;
            this.f46584c = z12;
            this.f46585d = z13;
            this.f46586e = i11;
            this.f46587f = str;
            this.f46589h = str2;
            this.f46588g = str3;
            this.f46590i = str4;
            this.f46591j = c0532a;
            this.f46592k = campaignEx;
            this.f46593l = copyOnWriteArrayList;
            this.f46594m = cVar;
            this.f46595n = jVar;
            this.f46596o = z14;
            this.f46600s = z11;
            this.f46601t = j11;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView) {
            if (webView != null) {
                try {
                    try {
                        LinkedHashMap<String, View> linkedHashMapB = com.mbridge.msdk.video.bt.a.d.c().b(this.f46588g, this.f46590i);
                        if (linkedHashMapB != null && !linkedHashMapB.isEmpty()) {
                            for (View view : linkedHashMapB.values()) {
                                if (view instanceof MBridgeBTContainer) {
                                    ((MBridgeBTContainer) view).addNativeCloseButtonWhenWebViewCrash();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        ad.b("OperateViews", th2.getMessage());
                    }
                } catch (Throwable th3) {
                    ad.b("RVWindVaneWebView", th3.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("type", 1);
                dVar.a("result", Integer.valueOf(i11));
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000155", this.f46592k, dVar);
            } catch (Throwable th2) {
                ad.b("RVWindVaneWebView", th2.getMessage());
            }
            if (this.f46598q) {
                return;
            }
            String str = this.f46588g + "_" + this.f46587f;
            if (i11 == 1) {
                if (this.f46596o) {
                    com.mbridge.msdk.videocommon.a.e(this.f46588g + "_" + this.f46590i);
                } else {
                    com.mbridge.msdk.videocommon.a.d(this.f46588g + "_" + this.f46590i);
                }
                com.mbridge.msdk.videocommon.a.a(this.f46588g + "_" + this.f46590i + "_" + this.f46587f, this.f46591j, true, this.f46596o);
                Handler handler = this.f46582a;
                if (handler != null && (runnable = this.f46583b) != null) {
                    handler.removeCallbacks(runnable);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46588g + "_" + this.f46590i + "_" + this.f46587f, true);
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46591j;
                if (c0532a != null) {
                    c0532a.a(true);
                }
                j jVar = this.f46595n;
                if (jVar != null) {
                    jVar.a(str, this.f46589h, this.f46588g, this.f46590i, this.f46587f, this.f46591j);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46588g + "_" + this.f46590i + "_" + this.f46587f, false);
                com.mbridge.msdk.videocommon.a.C0532a c0532a2 = this.f46591j;
                if (c0532a2 != null) {
                    c0532a2.a(false);
                }
                if (this.f46595n != null) {
                    this.f46595n.a(str, this.f46590i, this.f46587f, this.f46591j, b.b(880008, new MBridgeIds(this.f46589h, this.f46588g, this.f46590i), "readyState:" + i11, null, this.f46592k));
                }
            }
            this.f46598q = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46588g + "_" + this.f46590i + "_" + this.f46587f, false);
            if (this.f46595n != null) {
                String str3 = this.f46588g + "_" + this.f46587f;
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46591j;
                if (c0532a != null) {
                    c0532a.a(false);
                }
                this.f46595n.a(str3, this.f46590i, this.f46587f, this.f46591j, b.b(880008, new MBridgeIds(this.f46589h, this.f46588g, this.f46590i), "onReceivedError： " + i11 + "  " + str, null, this.f46592k));
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (this.f46597p) {
                return;
            }
            String str2 = this.f46588g + "_" + this.f46587f;
            if (!str.contains("wfr=1")) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46588g + "_" + this.f46590i + "_" + this.f46587f, true);
                Handler handler = this.f46582a;
                if (handler != null && (runnable = this.f46583b) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46591j;
                if (c0532a != null) {
                    c0532a.a(true);
                }
                j jVar = this.f46595n;
                if (jVar != null) {
                    jVar.a(str2, this.f46589h, this.f46588g, this.f46590i, this.f46587f, this.f46591j);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.f46597p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(WebView webView, String str, String str2, int i11, int i12) {
            boolean z11 = true;
            if (i11 == 1) {
                try {
                    com.mbridge.msdk.reward.b.a aVar = new com.mbridge.msdk.reward.b.a();
                    aVar.b(false);
                    if (i12 != 2) {
                        z11 = false;
                    }
                    aVar.a(z11);
                    aVar.b(str, str2);
                    aVar.a(new com.mbridge.msdk.video.bt.module.b.a(null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, i12, str2, true, 1));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RVWindVaneWebView", e11.getMessage());
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00fe A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #2 {all -> 0x00ad, blocks: (B:15:0x0066, B:17:0x006c, B:20:0x0074, B:22:0x0082, B:23:0x0087, B:28:0x00b3, B:30:0x00b7, B:32:0x00c2, B:34:0x00d0, B:36:0x00e0, B:37:0x00e6, B:38:0x00fe, B:39:0x0103, B:42:0x0129, B:44:0x012d), top: B:55:0x0066, inners: #0, #3 }] */
        @Override // com.mbridge.msdk.mbsignalcommon.b.a
        public final void a(Object obj, String str) {
            if (obj != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    final String strOptString = new JSONObject(str).optString("id");
                    com.mbridge.msdk.video.bt.a.d.c().a(obj, strOptString);
                    final String strC = com.mbridge.msdk.video.bt.a.d.c().c(strOptString);
                    final CampaignEx campaignExA = com.mbridge.msdk.video.bt.a.d.c().a(strOptString);
                    final com.mbridge.msdk.videocommon.d.c cVarB = com.mbridge.msdk.video.bt.a.d.c().b(strOptString);
                    final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(campaignExA);
                    final WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f45774b;
                    if (windVaneWebView != null) {
                        final b bVar = m.f46698a;
                        final boolean z11 = this.f46600s;
                        int i11 = this.f46599r == 0 ? 3 : 6;
                        if (campaignExA == null || cVarB == null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("id", strOptString);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("result", 2);
                                jSONObject2.put("error", ConstantsKt.ERROR_1000_MESSAGE);
                                jSONObject.put("data", jSONObject2);
                                com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                            } catch (Exception e11) {
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                                }
                            }
                        } else {
                            try {
                                if (campaignExA.getRewardTemplateMode() == null || TextUtils.isEmpty(strC)) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("id", strOptString);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("result", 2);
                                    jSONObject4.put("error", ConstantsKt.ERROR_1000_MESSAGE);
                                    jSONObject3.put("data", jSONObject4);
                                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                                } else if (TextUtils.isEmpty(campaignExA.getRewardTemplateMode().e())) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    try {
                                        jSONObject5.put("id", strOptString);
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("result", 1);
                                        jSONObject6.put("error", ConstantsKt.ERROR_1000_MESSAGE);
                                        jSONObject5.put("data", jSONObject6);
                                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject5.toString().getBytes(), 2));
                                    } catch (Exception e12) {
                                        if (MBridgeConstans.DEBUG) {
                                            ad.b("RewardCampaignsResourceManager", e12.getLocalizedMessage());
                                        }
                                    }
                                } else if (TextUtils.isEmpty(campaignExA.getRewardTemplateMode().e()) || !campaignExA.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.5
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            com.mbridge.msdk.video.signal.a.k kVar;
                                            boolean z12 = z11;
                                            WindVaneWebView windVaneWebView2 = windVaneWebView;
                                            String strE = campaignExA.getRewardTemplateMode().e();
                                            CampaignEx campaignEx = campaignExA;
                                            CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                                            String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignExA.getRewardTemplateMode().e());
                                            String str2 = strC;
                                            com.mbridge.msdk.videocommon.d.c cVar = cVarB;
                                            String str3 = strOptString;
                                            boolean z13 = b.this.f46534c;
                                            try {
                                                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                                                dVar.a("type", 2);
                                                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000154", campaignEx, dVar);
                                                com.mbridge.msdk.videocommon.a.C0532a c0532a = new com.mbridge.msdk.videocommon.a.C0532a();
                                                WindVaneWebView windVaneWebView3 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                                                if (campaignEx != null) {
                                                    windVaneWebView3.setLocalRequestId(campaignEx.getCurrentLocalRid());
                                                }
                                                windVaneWebView3.setTempTypeForMetrics(2);
                                                c0532a.a(windVaneWebView3);
                                                String requestId = "";
                                                if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                                                    kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx);
                                                    if (campaignEx != null) {
                                                        requestId = campaignEx.getRequestId();
                                                    }
                                                } else {
                                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(str2);
                                                    if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                                                        for (int i12 = 0; i12 < copyOnWriteArrayList2.size(); i12++) {
                                                            CampaignEx campaignEx2 = (CampaignEx) copyOnWriteArrayList2.get(i12);
                                                            for (CampaignEx campaignEx3 : copyOnWriteArrayListA) {
                                                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = copyOnWriteArrayListA;
                                                                if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                                                    campaignEx2.setReady(true);
                                                                    copyOnWriteArrayList2.set(i12, campaignEx2);
                                                                }
                                                                copyOnWriteArrayListA = copyOnWriteArrayList3;
                                                            }
                                                        }
                                                    }
                                                    kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx, copyOnWriteArrayList2);
                                                    requestId = ((CampaignEx) copyOnWriteArrayList2.get(0)).getRequestId();
                                                }
                                                String str4 = requestId;
                                                kVar.a(0);
                                                kVar.a(str2);
                                                kVar.c(str3);
                                                kVar.a(cVar);
                                                kVar.d(z12);
                                                windVaneWebView3.setWebViewListener(new l(str3, false, windVaneWebView2, strE, str2, c0532a, campaignEx, z13, str4));
                                                windVaneWebView3.setObject(kVar);
                                                windVaneWebView3.loadUrl(h5ResAddress);
                                                windVaneWebView3.setRid(str4);
                                            } catch (Exception e13) {
                                                if (MBridgeConstans.DEBUG) {
                                                    ad.b("RewardCampaignsResourceManager", e13.getLocalizedMessage());
                                                }
                                            }
                                        }
                                    }, i11 * 1000);
                                } else {
                                    ad.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        this.f46599r++;
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                }
                ad.b("RVWindVaneWebView", th.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements H5DownLoadManager.IH5SourceDownloadListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f46603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f46604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f46605d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f46606e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CampaignEx f46607f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private i f46608g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Handler f46609h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f46610i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f46602a = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final long f46611j = System.currentTimeMillis();

        public d(int i11, String str, String str2, String str3, CampaignEx campaignEx, i iVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f46603b = i11;
            this.f46604c = str;
            this.f46605d = str2;
            this.f46606e = str3;
            this.f46607f = campaignEx;
            this.f46608g = iVar;
            this.f46609h = handler;
            this.f46610i = copyOnWriteArrayList;
        }

        private void a(final int i11, final long j11, final String str, final String str2, final String str3) {
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.f46607f == null) {
                        return;
                    }
                    try {
                        n nVar = new n("m_download_end", i11, j11 + "", str, d.this.f46607f.getId(), d.this.f46605d, str2, "2");
                        nVar.f(d.this.f46607f.getRequestId());
                        nVar.s(d.this.f46607f.getCurrentLocalRid());
                        nVar.g(d.this.f46607f.getRequestIdNotice());
                        nVar.e(d.this.f46607f.getId());
                        nVar.c(d.this.f46607f.getAdSpaceT());
                        nVar.a("scenes", "1");
                        nVar.a("url", str);
                        if (d.this.f46607f.getAdType() == 287) {
                            nVar.d("3");
                        } else if (d.this.f46607f.getAdType() == 94) {
                            nVar.d("1");
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            nVar.t(str3);
                        }
                        b.a(nVar, d.this.f46607f);
                        com.mbridge.msdk.foundation.same.report.m.a(nVar, d.this.f46605d, d.this.f46607f);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        public final void a(boolean z11) {
            this.f46602a = z11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i11 = this.f46603b;
            if (i11 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46605d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46604c);
                bundle.putString(TrackingKey.REQUEST_ID, this.f46606e);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                messageObtain.setData(bundle);
                this.f46609h.sendMessage(messageObtain);
                return;
            }
            if (i11 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46605d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f46604c);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f46606e);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                messageObtain2.setData(bundle2);
                this.f46609h.sendMessage(messageObtain2);
                if (this.f46602a) {
                    a(3, System.currentTimeMillis() - this.f46611j, str, "url download failed", "");
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 205;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46605d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f46604c);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f46606e);
            bundle3.putString("message", str2);
            messageObtain3.setData(bundle3);
            this.f46609h.sendMessage(messageObtain3);
            if (this.f46608g != null) {
                try {
                    this.f46608g.a(str, this.f46606e, b.b(880006, new MBridgeIds(this.f46604c, this.f46605d, this.f46606e), str2, null, null));
                } catch (Exception e11) {
                    ad.b("RewardCampaignsResourceManager", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onSuccess(String str, String str2, boolean z11) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i11 = this.f46603b;
            if (i11 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46605d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46604c);
                bundle.putString(TrackingKey.REQUEST_ID, this.f46606e);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.f46609h.sendMessage(messageObtain);
                return;
            }
            if (i11 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46605d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f46604c);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f46606e);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.f46609h.sendMessage(messageObtain2);
                if (this.f46602a) {
                    a(1, System.currentTimeMillis() - this.f46611j, str, "", str2);
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 105;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46605d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f46604c);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f46606e);
            messageObtain3.setData(bundle3);
            this.f46609h.sendMessage(messageObtain3);
            i iVar = this.f46608g;
            if (iVar != null) {
                iVar.a(this.f46604c, this.f46605d, this.f46606e, str);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements com.mbridge.msdk.foundation.same.c.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f46618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f46619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f46620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f46621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f46622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CampaignEx f46623f;

        public e(Handler handler, int i11, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f46618a = handler;
            this.f46619b = i11;
            this.f46621d = str;
            this.f46620c = str2;
            this.f46622e = str3;
            this.f46623f = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(final String str, String str2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f46619b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46620c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46621d);
            bundle.putString(TrackingKey.REQUEST_ID, this.f46622e);
            messageObtain.setData(bundle);
            this.f46618a.sendMessage(messageObtain);
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (e.this.f46623f != null) {
                        try {
                            q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                            ad.a("RewardCampaignsResourceManager", "campaign is null");
                            n nVar = new n();
                            nVar.a("2000044");
                            nVar.a(z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
                            nVar.e(e.this.f46623f.getId());
                            nVar.p(e.this.f46623f.getImageUrl());
                            nVar.f(e.this.f46623f.getRequestId());
                            nVar.s(e.this.f46623f.getCurrentLocalRid());
                            nVar.g(e.this.f46623f.getRequestIdNotice());
                            nVar.c(e.this.f46620c);
                            nVar.h(str);
                            nVar.a("scenes", "1");
                            qVarA.a(nVar);
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                            }
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(Bitmap bitmap, String str) {
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = this.f46619b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46620c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46621d);
            bundle.putString(TrackingKey.REQUEST_ID, this.f46622e);
            messageObtain.setData(bundle);
            this.f46618a.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements com.mbridge.msdk.videocommon.listener.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f46626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f46627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f46628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f46629d;

        public f(Handler handler, String str, String str2, String str3) {
            this.f46626a = handler;
            this.f46628c = str;
            this.f46627b = str2;
            this.f46629d = str3;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46627b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46628c);
            bundle.putString(TrackingKey.REQUEST_ID, this.f46629d);
            bundle.putString("url", str);
            messageObtain.setData(bundle);
            this.f46626a.sendMessage(messageObtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public final void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message messageObtain = Message.obtain();
            messageObtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46627b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46628c);
            bundle.putString(TrackingKey.REQUEST_ID, this.f46629d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            messageObtain.setData(bundle);
            this.f46626a.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g implements H5DownLoadManager.ZipDownloadListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f46631b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f46632c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f46633d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f46634e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CampaignEx f46635f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f46636g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Handler f46637h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private i f46638i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f46639j;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f46630a = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f46640k = System.currentTimeMillis();

        public g(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i11, Handler handler, i iVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f46631b = context;
            this.f46633d = str;
            this.f46632c = str2;
            this.f46634e = str3;
            this.f46635f = campaignEx;
            this.f46636g = i11;
            this.f46637h = handler;
            this.f46638i = iVar;
            this.f46639j = copyOnWriteArrayList;
        }

        private void a(final int i11, final long j11, final String str, final String str2, final String str3) {
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.g.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f46635f == null) {
                        return;
                    }
                    try {
                        n nVar = new n("m_download_end", i11, j11 + "", str, g.this.f46635f.getId(), g.this.f46632c, str2, "1");
                        nVar.f(g.this.f46635f.getRequestId());
                        nVar.s(g.this.f46635f.getCurrentLocalRid());
                        nVar.g(g.this.f46635f.getRequestIdNotice());
                        nVar.e(g.this.f46635f.getId());
                        nVar.c(g.this.f46635f.getAdSpaceT());
                        nVar.t(str3);
                        nVar.a("scenes", "1");
                        if (g.this.f46635f.getAdType() == 287) {
                            nVar.d("3");
                        } else if (g.this.f46635f.getAdType() == 94) {
                            nVar.d("1");
                        }
                        nVar.a("url", str);
                        nVar.e(3);
                        b.a(nVar, g.this.f46635f);
                        com.mbridge.msdk.foundation.same.report.m.a(nVar, g.this.f46632c, g.this.f46635f);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        private void a(final int i11, final String str, final String str2, final String str3) {
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f46635f == null || g.this.f46631b == null) {
                        return;
                    }
                    try {
                        n nVar = new n();
                        nVar.a("m_download_end");
                        if (g.this.f46631b != null) {
                            nVar.a(z.l(g.this.f46631b.getApplicationContext()));
                        }
                        nVar.b(i11);
                        if (g.this.f46635f != null) {
                            nVar.e(g.this.f46635f.getId());
                            nVar.f(g.this.f46635f.getRequestId());
                            nVar.s(g.this.f46635f.getCurrentLocalRid());
                            nVar.g(g.this.f46635f.getRequestIdNotice());
                        }
                        nVar.q(str);
                        nVar.h(str2);
                        nVar.c(g.this.f46632c);
                        if (!TextUtils.isEmpty(str3)) {
                            nVar.t(str3);
                        }
                        nVar.e(2);
                        nVar.a("scenes", "1");
                        nVar.a("url", str);
                        b.a(nVar, g.this.f46635f);
                        com.mbridge.msdk.foundation.same.report.d.c.a().a(nVar, g.this.f46635f);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                        }
                    }
                }
            });
        }

        public final void a(boolean z11) {
            this.f46630a = z11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f46640k;
            int i11 = this.f46636g;
            if (i11 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46632c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46633d);
                bundle.putString(TrackingKey.REQUEST_ID, this.f46634e);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                messageObtain.setData(bundle);
                this.f46637h.sendMessage(messageObtain);
                return;
            }
            if (i11 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46632c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f46633d);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f46634e);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                messageObtain2.setData(bundle2);
                this.f46637h.sendMessage(messageObtain2);
                if (this.f46630a) {
                    a(3, jCurrentTimeMillis, str2, "zip download failed", "");
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = 203;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46632c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f46633d);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f46634e);
            bundle3.putString("url", str2);
            bundle3.putString("message", str);
            messageObtain3.setData(bundle3);
            this.f46637h.sendMessage(messageObtain3);
            if (this.f46638i != null) {
                try {
                    this.f46638i.a(str2, this.f46634e, b.b(880006, new MBridgeIds(this.f46633d, this.f46632c, this.f46634e), "", null, null));
                } catch (Exception e11) {
                    ad.b("RewardCampaignsResourceManager", e11.getMessage());
                }
            }
            a(3, str2, str, "");
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public final void onSuccess(String str, String str2, boolean z11) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f46640k;
            int i11 = this.f46636g;
            if (i11 == 313) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46632c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f46633d);
                bundle.putString(TrackingKey.REQUEST_ID, this.f46634e);
                bundle.putString("url", str);
                messageObtain.setData(bundle);
                this.f46637h.sendMessage(messageObtain);
                return;
            }
            if (i11 == 497) {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46632c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f46633d);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f46634e);
                bundle2.putString("url", str);
                messageObtain2.setData(bundle2);
                this.f46637h.sendMessage(messageObtain2);
                if (this.f46630a) {
                    a(1, jCurrentTimeMillis, str, "", str2);
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message messageObtain3 = Message.obtain();
            messageObtain3.what = Worker.WHAT_SYNC_DATA;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f46632c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f46633d);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f46634e);
            messageObtain3.setData(bundle3);
            this.f46637h.sendMessage(messageObtain3);
            i iVar = this.f46638i;
            if (iVar != null) {
                iVar.a(this.f46633d, this.f46632c, this.f46634e, str);
            }
            if (z11) {
                return;
            }
            a(1, str, "", str2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class h extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f46652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<String, c> f46653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f46654c;

        public h(Looper looper) {
            super(looper);
            this.f46653b = new ConcurrentHashMap<>();
            this.f46654c = new ConcurrentHashMap<>();
        }

        public final void a(Context context) {
            this.f46652a = context;
        }

        public final void a(String str, String str2, String str3, c cVar) {
            this.f46653b.put(str2 + "_" + str3, cVar);
        }

        public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f46654c.put(str, copyOnWriteArrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v12 */
        /* JADX WARN: Type inference failed for: r10v27 */
        /* JADX WARN: Type inference failed for: r10v28 */
        /* JADX WARN: Type inference failed for: r10v4, types: [int] */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r10v8 */
        /* JADX WARN: Type inference failed for: r15v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r15v15 */
        /* JADX WARN: Type inference failed for: r15v16 */
        /* JADX WARN: Type inference failed for: r15v2 */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARN: Type inference failed for: r15v4 */
        /* JADX WARN: Type inference failed for: r15v5 */
        /* JADX WARN: Type inference failed for: r15v7 */
        /* JADX WARN: Type inference failed for: r15v9 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            char c11;
            ?? r11;
            boolean z11;
            com.mbridge.msdk.videocommon.download.b bVar;
            String str;
            boolean z12;
            int i11;
            boolean z13;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString(TrackingKey.REQUEST_ID);
            String str2 = string2 + "_" + string3;
            a aVar = (a) b.f46532b.get(str2);
            c cVar = this.f46653b.get(str2);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.f46654c.get(str2);
            int i12 = message.what;
            ?? r15 = "RewardCampaignsResourceManager";
            switch (i12) {
                case 100:
                case 101:
                case 102:
                case Worker.WHAT_SYNC_DATA /* 103 */:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i12) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && cVar != null) {
                                String string4 = data.getString("message");
                                if (string4 == null) {
                                    string4 = "";
                                }
                                int i13 = message.what;
                                if (i13 == 200) {
                                    c11 = 28036;
                                } else if (i13 == 201) {
                                    c11 = 28039;
                                } else if (i13 != 203) {
                                    c11 = i13 != 205 ? (char) 28056 : (char) 28037;
                                } else {
                                    c11 = 28038;
                                }
                                String str3 = "resource download failed " + b.b(message.what) + " " + string4;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = aVar.f46580h;
                                int i14 = 0;
                                CampaignEx campaignEx = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : aVar.f46580h.get(0);
                                try {
                                    try {
                                        try {
                                            if (aVar.f46573a) {
                                                try {
                                                    if (aVar.f46581i != null) {
                                                        if (aVar.f46575c != 1) {
                                                            String string5 = data.getString("url");
                                                            int i15 = message.what;
                                                            if (i15 == 200) {
                                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                                    ad.c("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                                                } else {
                                                                    while (i14 < aVar.f46581i.size()) {
                                                                        if (aVar.f46581i.get(i14).getVideoUrlEncode().equals(string5)) {
                                                                            aVar.f46581i.remove(i14);
                                                                        }
                                                                        i14++;
                                                                    }
                                                                    b.f46532b.remove(str2);
                                                                    b.f46532b.put(str2, aVar);
                                                                }
                                                            } else if (i15 == 201) {
                                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                    ad.c("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                                } else {
                                                                    while (i14 < aVar.f46581i.size()) {
                                                                        CampaignEx campaignEx2 = aVar.f46581i.get(i14);
                                                                        if (campaignEx2.getRewardTemplateMode() != null && campaignEx2.getRewardTemplateMode().c().equals(string5)) {
                                                                            aVar.f46581i.remove(i14);
                                                                        }
                                                                        if (!TextUtils.isEmpty(campaignEx2.getendcard_url()) && campaignEx2.getendcard_url().equals(string5)) {
                                                                            aVar.f46581i.remove(i14);
                                                                        }
                                                                        i14++;
                                                                    }
                                                                    b.f46532b.remove(str2);
                                                                    b.f46532b.put(str2, aVar);
                                                                }
                                                            } else if (i15 == 203) {
                                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                    ad.c("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                                } else {
                                                                    while (i14 < aVar.f46581i.size()) {
                                                                        CampaignEx campaignEx3 = aVar.f46581i.get(i14);
                                                                        if (campaignEx3.getRewardTemplateMode() != null && campaignEx3.getRewardTemplateMode().e().equals(string5)) {
                                                                            aVar.f46581i.remove(i14);
                                                                        }
                                                                        i14++;
                                                                    }
                                                                    b.f46532b.remove(str2);
                                                                    b.f46532b.put(str2, aVar);
                                                                }
                                                            } else if (i15 == 205) {
                                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                    ad.c("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                                } else {
                                                                    aVar.f46581i.clear();
                                                                    b.f46532b.remove(str2);
                                                                    b.f46532b.put(str2, aVar);
                                                                }
                                                            }
                                                            com.mbridge.msdk.videocommon.download.b bVar2 = com.mbridge.msdk.videocommon.download.b.getInstance();
                                                            String str4 = aVar.f46577e;
                                                            boolean z14 = aVar.f46574b;
                                                            int i16 = aVar.f46576d;
                                                            boolean z15 = aVar.f46573a;
                                                            int i17 = aVar.f46575c;
                                                            boolean z16 = c11 == true ? 1 : 0;
                                                            try {
                                                                if (bVar2.a(94, str4, z14, i16, z15, i17, copyOnWriteArrayList)) {
                                                                    try {
                                                                        cVar.a(string, string2, string3, aVar.f46580h);
                                                                        this.f46653b.remove(str2);
                                                                        b.f46532b.remove(str2);
                                                                        this.f46654c.remove(str2);
                                                                    } catch (Exception e11) {
                                                                        e = e11;
                                                                        r11 = z16 ? 1 : 0;
                                                                    }
                                                                } else if (aVar.f46581i.size() == 0) {
                                                                    MBridgeIds mBridgeIds = new MBridgeIds(string, string2, string3);
                                                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = aVar.f46580h;
                                                                    boolean z17 = z16 ? 1 : 0;
                                                                    cVar.a(copyOnWriteArrayList3, b.b(z17 ? 1 : 0, mBridgeIds, str3, null, null));
                                                                    this.f46653b.remove(str2);
                                                                    b.f46532b.remove(str2);
                                                                    this.f46654c.remove(str2);
                                                                    r15 = z17;
                                                                }
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                r15 = z16 ? 1 : 0;
                                                                r11 = r15;
                                                            }
                                                            break;
                                                        } else {
                                                            if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                                int i18 = message.what;
                                                                if (i18 != 200) {
                                                                    if (i18 != 201) {
                                                                        if (i18 != 203) {
                                                                            if (i18 == 205) {
                                                                                if (!campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList4 = aVar.f46580h;
                                                                                    if (copyOnWriteArrayList4 != null && copyOnWriteArrayList4.size() > 0) {
                                                                                        CampaignEx campaignEx4 = aVar.f46580h.get(0);
                                                                                        if (campaignEx4.getCMPTEntryUrl().equals(campaignEx4.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                                        }
                                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                                    }
                                                                } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                                }
                                                            }
                                                            try {
                                                                cVar.a(aVar.f46580h, b.b(c11 == true ? 1 : 0, new MBridgeIds(string, string2, string3), str3, null, null));
                                                                this.f46653b.remove(str2);
                                                                b.f46532b.remove(str2);
                                                                this.f46654c.remove(str2);
                                                            } catch (Exception e13) {
                                                                e = e13;
                                                                r11 = c11;
                                                            }
                                                        }
                                                        cVar.a(aVar.f46580h, b.b(r11, new MBridgeIds(string, string2, string3), str3, e, null));
                                                    }
                                                } catch (Exception e14) {
                                                    e = e14;
                                                    r15 = c11 == true ? 1 : 0;
                                                }
                                            }
                                            if (bVar.a(94, str, z12, i11, z13, aVar.f46575c, copyOnWriteArrayList)) {
                                                cVar.a(string, string2, string3, aVar.f46580h);
                                            } else {
                                                if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                                                    int i19 = message.what;
                                                    if (i19 != 200) {
                                                        if (i19 != 201) {
                                                            if (i19 != 203) {
                                                                if (i19 == 205 && campaignEx.getRsIgnoreCheckRule().contains(3)) {
                                                                }
                                                            } else if (campaignEx.getRsIgnoreCheckRule().contains(1)) {
                                                            }
                                                        } else if (campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                                        }
                                                    } else if (campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                                    }
                                                }
                                                cVar.a(aVar.f46580h, b.b(z11 ? 1 : 0, new MBridgeIds(string, string2, string3), str3, null, null));
                                            }
                                            this.f46653b.remove(str2);
                                            b.f46532b.remove(str2);
                                            this.f46654c.remove(str2);
                                            r15 = z13;
                                        } catch (Exception e15) {
                                            e = e15;
                                            r11 = z11 ? 1 : 0;
                                        }
                                        z11 = c11 == true ? 1 : 0;
                                        bVar = com.mbridge.msdk.videocommon.download.b.getInstance();
                                        str = aVar.f46577e;
                                        z12 = aVar.f46574b;
                                        i11 = aVar.f46576d;
                                        z13 = aVar.f46573a;
                                    } catch (Exception e16) {
                                        e = e16;
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    r11 = c11;
                                }
                                break;
                            }
                            break;
                    }
                    return;
            }
            if (aVar == null || cVar == null) {
                return;
            }
            try {
                try {
                    if (com.mbridge.msdk.videocommon.download.b.getInstance().a(94, aVar.f46577e, aVar.f46574b, aVar.f46576d, aVar.f46573a, aVar.f46575c, copyOnWriteArrayList)) {
                        cVar.a(string, string2, string3, aVar.f46580h);
                        this.f46653b.remove(str2);
                        b.f46532b.remove(str2);
                        this.f46654c.remove(str2);
                    }
                } catch (Exception e18) {
                    e = e18;
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            } catch (Exception e19) {
                e = e19;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface i {
        void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    /* JADX INFO: compiled from: source.java */
    public interface j {
        void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, com.mbridge.msdk.videocommon.a.C0532a c0532a);
    }

    /* JADX INFO: compiled from: source.java */
    public static class k extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f46655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f46656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f46657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f46658d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f46659e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final j f46660f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final WindVaneWebView f46661g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f46662h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f46663i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f46664j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.a.C0532a f46665k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final CampaignEx f46666l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f46667m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private long f46668n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f46669o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f46670p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final Runnable f46671q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final Runnable f46672r;

        public k(Handler handler, Runnable runnable, boolean z11, boolean z12, final String str, final j jVar, WindVaneWebView windVaneWebView, final String str2, final String str3, final String str4, final com.mbridge.msdk.videocommon.a.C0532a c0532a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j11) {
            this.f46655a = handler;
            this.f46656b = runnable;
            this.f46657c = z11;
            this.f46658d = z12;
            this.f46659e = str;
            this.f46660f = jVar;
            this.f46661g = windVaneWebView;
            this.f46662h = str2;
            this.f46663i = str4;
            this.f46664j = str3;
            this.f46665k = c0532a;
            this.f46666l = campaignEx;
            this.f46667m = copyOnWriteArrayList;
            this.f46668n = j11;
            Runnable runnable2 = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    com.mbridge.msdk.videocommon.a.C0532a c0532a2;
                    if (jVar != null && (c0532a2 = c0532a) != null) {
                        c0532a2.a(true);
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str4 + "_" + str + "_" + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append("_");
                        sb2.append(str2);
                        jVar2.a(sb2.toString(), str3, str4, str, str2, c0532a);
                    }
                    com.mbridge.msdk.videocommon.a.C0532a c0532a3 = c0532a;
                    if (c0532a3 == null || (windVaneWebViewA = c0532a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("WindVaneWebView", e11.getMessage());
                        }
                    }
                }
            };
            this.f46672r = runnable2;
            this.f46671q = new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.k.2
                @Override // java.lang.Runnable
                public final void run() {
                    WindVaneWebView windVaneWebViewA;
                    com.mbridge.msdk.videocommon.a.C0532a c0532a2;
                    if (jVar != null && (c0532a2 = c0532a) != null) {
                        c0532a2.a(true);
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str4 + "_" + str + "_" + str2, true);
                        j jVar2 = jVar;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str4);
                        sb2.append("_");
                        sb2.append(str2);
                        jVar2.a(sb2.toString(), str3, str4, str, str2, c0532a);
                    }
                    com.mbridge.msdk.videocommon.a.C0532a c0532a3 = c0532a;
                    if (c0532a3 == null || (windVaneWebViewA = c0532a3.a()) == null) {
                        return;
                    }
                    try {
                        windVaneWebViewA.release();
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("WindVaneWebView", e11.getMessage());
                        }
                    }
                }
            };
            if (handler != null) {
                handler.postDelayed(runnable2, 5000L);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i11);
            Handler handler2 = this.f46655a;
            if (handler2 != null && (runnable2 = this.f46671q) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f46655a;
            if (handler3 != null && (runnable = this.f46672r) != null) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("type", 2);
                dVar.a("result", Integer.valueOf(i11));
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000155", this.f46666l, dVar);
            } catch (Throwable th2) {
                ad.b("WindVaneWebView", th2.getMessage());
            }
            if (this.f46670p) {
                return;
            }
            String str = this.f46663i + "_" + this.f46662h;
            if (i11 == 1) {
                Runnable runnable3 = this.f46656b;
                if (runnable3 != null && (handler = this.f46655a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46663i + "_" + this.f46659e + "_" + this.f46662h, true);
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46665k;
                if (c0532a != null) {
                    c0532a.a(true);
                }
                if (this.f46657c) {
                    if (this.f46658d) {
                        com.mbridge.msdk.videocommon.a.a(287, this.f46666l.getRequestIdNotice(), this.f46665k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, this.f46666l.getRequestIdNotice(), this.f46665k);
                    }
                } else if (this.f46658d) {
                    com.mbridge.msdk.videocommon.a.a(94, this.f46666l.getRequestIdNotice(), this.f46665k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f46666l.getRequestIdNotice(), this.f46665k);
                }
                j jVar = this.f46660f;
                if (jVar != null) {
                    jVar.a(str, this.f46664j, this.f46663i, this.f46659e, this.f46662h, this.f46665k);
                }
            } else if (this.f46660f != null) {
                this.f46660f.a(str, this.f46659e, this.f46662h, this.f46665k, b.b(880009, new MBridgeIds(this.f46664j, this.f46663i, this.f46659e), "readyState:" + i11, null, this.f46666l));
            }
            this.f46670p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46663i + "_" + this.f46659e + "_" + this.f46662h, false);
            Handler handler = this.f46655a;
            if (handler != null) {
                if (this.f46671q != null) {
                    handler.removeCallbacks(this.f46672r);
                }
                Runnable runnable = this.f46671q;
                if (runnable != null) {
                    this.f46655a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.f46663i + "_" + this.f46662h;
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46665k;
                if (c0532a != null) {
                    c0532a.a(false);
                }
                if (this.f46660f != null) {
                    this.f46660f.a(str3, this.f46659e, str2, this.f46665k, b.b(880009, new MBridgeIds(this.f46664j, this.f46663i, this.f46659e), i11 + Utils.SEPARATOR + str, null, this.f46666l));
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("WindVaneWebView", e11.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46663i + "_" + this.f46659e + "_" + this.f46662h, false);
            Handler handler = this.f46655a;
            if (handler != null) {
                if (this.f46671q != null) {
                    handler.removeCallbacks(this.f46672r);
                }
                Runnable runnable = this.f46671q;
                if (runnable != null) {
                    this.f46655a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.f46663i + "_" + this.f46662h;
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46665k;
                if (c0532a != null) {
                    c0532a.a(false);
                }
                if (this.f46660f != null) {
                    MBridgeIds mBridgeIds = new MBridgeIds(this.f46664j, this.f46663i, this.f46659e);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onReceivedSslError:");
                    sb2.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
                    this.f46660f.a(str, this.f46659e, this.f46662h, this.f46665k, b.b(880009, mBridgeIds, sb2.toString(), null, this.f46666l));
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("WindVaneWebView", e11.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f46655a;
            if (handler2 != null && (runnable2 = this.f46672r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.f46669o) {
                return;
            }
            if (str.contains("wfr=1")) {
                Handler handler3 = this.f46655a;
                if (handler3 != null && (runnable = this.f46671q) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            } else {
                String str2 = this.f46663i + "_" + this.f46662h;
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46663i + "_" + this.f46659e + "_" + this.f46662h, true);
                Runnable runnable3 = this.f46656b;
                if (runnable3 != null && (handler = this.f46655a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46665k;
                if (c0532a != null) {
                    c0532a.a(true);
                }
                if (this.f46657c) {
                    if (this.f46666l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.f46666l.getRequestIdNotice(), this.f46665k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(287, this.f46666l.getRequestIdNotice(), this.f46665k);
                    }
                } else if (this.f46666l.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.f46666l.getRequestIdNotice(), this.f46665k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f46666l.getRequestIdNotice(), this.f46665k);
                }
                j jVar = this.f46660f;
                if (jVar != null) {
                    jVar.a(str2, this.f46664j, this.f46663i, this.f46659e, this.f46662h, this.f46665k);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.f46669o = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class l extends com.mbridge.msdk.mbsignalcommon.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f46687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f46688b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WindVaneWebView f46689c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f46690d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f46691e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.mbridge.msdk.videocommon.a.C0532a f46692f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final CampaignEx f46693g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f46694h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f46695i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f46696j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f46697k;

        public l(String str, boolean z11, WindVaneWebView windVaneWebView, String str2, String str3, com.mbridge.msdk.videocommon.a.C0532a c0532a, CampaignEx campaignEx, boolean z12, String str4) {
            this.f46688b = z11;
            this.f46689c = windVaneWebView;
            this.f46690d = str2;
            this.f46691e = str3;
            this.f46692f = c0532a;
            this.f46693g = campaignEx;
            this.f46687a = str;
            this.f46694h = z12;
            this.f46695i = str4;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11) {
            try {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("type", 2);
                dVar.a("result", Integer.valueOf(i11));
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000155", this.f46693g, dVar);
            } catch (Throwable th2) {
                ad.b("WindVaneWebView", th2.getMessage());
            }
            if (this.f46697k) {
                return;
            }
            if (this.f46689c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f46687a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i11);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f46689c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("WindVaneWebView", e11.getLocalizedMessage());
                    }
                }
            }
            String str = this.f46691e + "_" + this.f46693g.getId() + "_" + this.f46693g.getRequestId() + "_" + this.f46690d;
            if (i11 == 1) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46691e + "_" + this.f46695i + "_" + this.f46690d, true);
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46692f;
                if (c0532a != null) {
                    c0532a.a(true);
                }
                if (this.f46688b) {
                    if (this.f46693g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f46692f, false, this.f46694h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f46692f, false, this.f46694h);
                    }
                } else if (this.f46693g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(str, this.f46692f, false, this.f46694h);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str, this.f46692f, false, this.f46694h);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46691e + "_" + this.f46695i + "_" + this.f46690d, false);
                com.mbridge.msdk.videocommon.a.C0532a c0532a2 = this.f46692f;
                if (c0532a2 != null) {
                    c0532a2.a(false);
                }
            }
            this.f46697k = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i11, String str, String str2) {
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46691e + "_" + this.f46695i + "_" + this.f46690d, false);
            com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46692f;
            if (c0532a != null) {
                c0532a.a(false);
            }
            if (this.f46689c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f46687a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f46689c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("WindVaneWebView", e11.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) {
            if (this.f46696j) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.f46689c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f46687a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f46689c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("WindVaneWebView", e11.getLocalizedMessage());
                        }
                    }
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46691e + "_" + this.f46695i + "_" + this.f46690d, true);
                com.mbridge.msdk.videocommon.a.C0532a c0532a = this.f46692f;
                if (c0532a != null) {
                    c0532a.a(true);
                }
                String str2 = this.f46691e + "_" + this.f46693g.getId() + "_" + this.f46693g.getRequestId() + "_" + this.f46690d;
                if (this.f46688b) {
                    if (this.f46693g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(287, this.f46693g.getRequestIdNotice(), this.f46692f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f46692f, false, this.f46694h);
                    }
                } else if (this.f46693g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.f46693g.getRequestIdNotice(), this.f46692f);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str2, this.f46692f, false, this.f46694h);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(webView);
            this.f46696j = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f46698a = new b();
    }

    private b() {
        this.f46535d = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.f46536e = "down_type";
        this.f46537f = "h3c";
        this.f46538g = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f46532b = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f46533a = new h(handlerThread.getLooper());
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th2) {
            ad.b("RewardCampaignsResourceManager", th2.getMessage());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.b a(CampaignEx campaignEx, int i11) {
        com.mbridge.msdk.foundation.same.report.d.b bVarB = campaignEx != null ? com.mbridge.msdk.foundation.same.report.d.c.a().b(campaignEx.getCurrentLocalRid()) : null;
        if (bVarB == null) {
            bVarB = new com.mbridge.msdk.foundation.same.report.d.b();
        }
        bVarB.a(campaignEx);
        bVarB.c(a(campaignEx));
        bVarB.a(i11);
        return bVarB;
    }

    public static b a() {
        return m.f46698a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i11, final CampaignEx campaignEx, String str, String str2) {
        com.mbridge.msdk.foundation.tools.n.a(i11, str, str2, new com.mbridge.msdk.foundation.tools.n.a() { // from class: com.mbridge.msdk.reward.adapter.b.2
            @Override // com.mbridge.msdk.foundation.tools.n.a
            public final void a(String str3, DownloadError downloadError) {
                String message = "";
                if (downloadError != null) {
                    try {
                        if (downloadError.getException() != null) {
                            message = downloadError.getException().getMessage();
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                n nVar = new n();
                int i12 = i11;
                if (i12 == 0) {
                    nVar.e(1);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i12 == 1) {
                    nVar.e(2);
                    nVar.b(3);
                    nVar.a("m_download_end");
                } else if (i12 == 2) {
                    nVar.e(3);
                    nVar.b(3);
                    nVar.a("m_download_end");
                    nVar.d(campaignEx.isMraid() ? n.f44338a : n.f44339b);
                    nVar.o("1");
                }
                b.a(nVar, campaignEx);
                nVar.g(campaignEx.getRequestIdNotice());
                nVar.h(message);
                nVar.a("scenes", "1");
                nVar.a("url", str3);
                com.mbridge.msdk.foundation.same.report.d.c.a().a(nVar, campaignEx);
            }

            @Override // com.mbridge.msdk.foundation.tools.n.a
            public final void a(String str3, String str4, String str5, String str6, boolean z11) {
                if (z11) {
                    return;
                }
                try {
                    n nVar = new n();
                    int i12 = i11;
                    if (i12 == 0) {
                        nVar.e(1);
                        nVar.b(1);
                        nVar.a("m_download_end");
                    } else if (i12 == 1) {
                        nVar.e(2);
                        nVar.b(1);
                        nVar.a("m_download_end");
                    } else if (i12 == 2) {
                        nVar.e(3);
                        nVar.b(1);
                        nVar.a("m_download_end");
                        nVar.d(campaignEx.isMraid() ? n.f44338a : n.f44339b);
                        nVar.o("1");
                    }
                    nVar.g(campaignEx.getRequestIdNotice());
                    nVar.a("url", str3);
                    nVar.a("scenes", "1");
                    com.mbridge.msdk.foundation.same.report.d.c.a().a(nVar, campaignEx);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardCampaignsResourceManager", e11.getMessage());
                    }
                }
            }
        }, campaignEx);
    }

    public static /* synthetic */ void a(n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), campaignEx.getCampaignUnitId());
            if (cVarA != null) {
                nVar.v(cVarA.l());
            }
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB != null) {
                nVar.u(aVarB.c());
            }
        } catch (Exception e11) {
            ad.b("RewardCampaignsResourceManager", e11.getMessage());
        }
    }

    public static /* synthetic */ void a(b bVar, final Context context, final int i11, final CampaignEx campaignEx, final String str, final String str2, final String str3, final String str4) {
        com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.4
            @Override // java.lang.Runnable
            public final void run() {
                if (campaignEx == null || context == null) {
                    return;
                }
                try {
                    n nVar = new n();
                    nVar.a("m_download_end");
                    Context context2 = context;
                    if (context2 != null) {
                        nVar.a(z.l(context2.getApplicationContext()));
                    }
                    nVar.b(i11);
                    CampaignEx campaignEx2 = campaignEx;
                    if (campaignEx2 != null) {
                        nVar.e(campaignEx2.getId());
                        nVar.f(campaignEx.getRequestId());
                        nVar.s(campaignEx.getCurrentLocalRid());
                        nVar.g(campaignEx.getRequestIdNotice());
                    }
                    nVar.q(str);
                    nVar.h(str2);
                    nVar.c(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        nVar.t(str4);
                    }
                    nVar.e(1);
                    nVar.a("scenes", "1");
                    com.mbridge.msdk.foundation.same.report.d.c.a().a(nVar.a(), campaignEx);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                    }
                }
            }
        });
    }

    public static /* synthetic */ void a(b bVar, Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, i iVar, CopyOnWriteArrayList copyOnWriteArrayList) {
        if (TextUtils.isEmpty(str4) || campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.d.b bVarA = bVar.a(campaignEx, 3);
        if (str4.contains(".zip") && str4.contains(ResourceManager.KEY_MD5FILENAME)) {
            boolean zIsEmpty = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str4));
            try {
                g gVar = new g(context, str, str2, str3, campaignEx, 497, bVar.f46533a, iVar, copyOnWriteArrayList);
                gVar.a(zIsEmpty);
                H5DownLoadManager.getInstance().downloadH5Res(bVarA, str4, gVar);
                return;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean zIsEmpty2 = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str4));
        try {
            d dVar = new d(497, str, str2, str3, campaignEx, iVar, bVar.f46533a, copyOnWriteArrayList);
            dVar.a(zIsEmpty2);
            H5DownLoadManager.getInstance().downloadH5Res(bVarA, str4, dVar);
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardCampaignsResourceManager", e12.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.c.b b(int i11, MBridgeIds mBridgeIds, String str, Throwable th2, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(i11);
        bVar.a(mBridgeIds);
        bVar.a(th2);
        bVar.a(str);
        bVar.a(campaignEx);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized String b(int i11) {
        if (i11 == 200) {
            return "video";
        }
        if (i11 == 201) {
            return "zip/html";
        }
        if (i11 != 203) {
            return i11 != 205 ? AppLovinMediationProvider.UNKNOWN : "tpl";
        }
        return "temp";
    }

    public final synchronized void a(final Context context, final CampaignEx campaignEx, final String str, final String str2, final String str3, final i iVar) {
        try {
            this.f46533a.a(context);
            if (campaignEx != null) {
                String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                if (campaignEx.isDynamicView()) {
                    if (ai.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, cMPTEntryUrl)) {
                        a(0, campaignEx, campaignEx.getMof_tplid() + "", cMPTEntryUrl);
                    }
                    ResDownloadCheckManager.getInstance().setZipDownloadDone(cMPTEntryUrl, true);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 105;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(TrackingKey.REQUEST_ID, str3);
                    bundle.putString("url", cMPTEntryUrl);
                    messageObtain.setData(bundle);
                    this.f46533a.sendMessage(messageObtain);
                    if (iVar != null) {
                        iVar.a(str, str2, str3, cMPTEntryUrl);
                    }
                    return;
                }
            }
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                try {
                    com.mbridge.msdk.foundation.same.report.d.b bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(campaignEx.getCurrentLocalRid());
                    if (bVarB == null) {
                        bVarB = new com.mbridge.msdk.foundation.same.report.d.b();
                    }
                    com.mbridge.msdk.foundation.same.report.d.b bVar = bVarB;
                    bVar.a(campaignEx);
                    bVar.a(1);
                    bVar.c(a(campaignEx));
                    H5DownLoadManager.getInstance().downloadH5Res(bVar, campaignEx.getCMPTEntryUrl(), new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.reward.adapter.b.3
                        /* JADX WARN: Code duplicated, block: B:32:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                        public final void onFailed(String str4, String str5) {
                            Exception exc;
                            String str6;
                            String str7 = "RewardCampaignsResourceManager";
                            try {
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str5, false);
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 205;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle2.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle2.putString(TrackingKey.REQUEST_ID, str3);
                                bundle2.putString("url", str5);
                                bundle2.putString("message", str4);
                                messageObtain2.setData(bundle2);
                                b.this.f46533a.sendMessage(messageObtain2);
                                if (iVar != null) {
                                    try {
                                        iVar.a(str5, str3, b.b(880005, new MBridgeIds(str, str2, str3), "", null, null));
                                    } catch (Exception e11) {
                                        try {
                                            ad.b("RewardCampaignsResourceManager", e11.getMessage());
                                        } catch (Exception e12) {
                                            exc = e12;
                                            str7 = "RewardCampaignsResourceManager";
                                            ResDownloadCheckManager.getInstance().setZipDownloadDone(str5, false);
                                            Message messageObtain3 = Message.obtain();
                                            messageObtain3.what = 105;
                                            Bundle bundle3 = new Bundle();
                                            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                            bundle3.putString(MBridgeConstans.PLACEMENT_ID, str);
                                            bundle3.putString(TrackingKey.REQUEST_ID, str3);
                                            bundle3.putString("url", str5);
                                            bundle3.putString("message", exc.getMessage());
                                            messageObtain3.setData(bundle3);
                                            b.this.f46533a.sendMessage(messageObtain3);
                                            if (iVar != null) {
                                                try {
                                                    iVar.a(str5, str3, b.b(880005, new MBridgeIds(str, str2, str3), "", exc, null));
                                                } catch (Exception e13) {
                                                    str6 = str7;
                                                    ad.b(str6, e13.getMessage());
                                                    ad.b(str6, exc.getLocalizedMessage());
                                                }
                                            }
                                            str6 = str7;
                                            ad.b(str6, exc.getLocalizedMessage());
                                        }
                                    }
                                }
                                try {
                                    b.a(b.this, context, 3, campaignEx, str5, str4, str2, "");
                                } catch (Exception e14) {
                                    e = e14;
                                    exc = e;
                                    ResDownloadCheckManager.getInstance().setZipDownloadDone(str5, false);
                                    Message messageObtain4 = Message.obtain();
                                    messageObtain4.what = 105;
                                    Bundle bundle4 = new Bundle();
                                    bundle4.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                    bundle4.putString(MBridgeConstans.PLACEMENT_ID, str);
                                    bundle4.putString(TrackingKey.REQUEST_ID, str3);
                                    bundle4.putString("url", str5);
                                    bundle4.putString("message", exc.getMessage());
                                    messageObtain4.setData(bundle4);
                                    b.this.f46533a.sendMessage(messageObtain4);
                                    if (iVar != null) {
                                        iVar.a(str5, str3, b.b(880005, new MBridgeIds(str, str2, str3), "", exc, null));
                                    }
                                    str6 = str7;
                                    ad.b(str6, exc.getLocalizedMessage());
                                }
                            } catch (Exception e15) {
                                e = e15;
                            }
                        }

                        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                        public final void onSuccess(String str4, String str5, boolean z11) {
                            try {
                                ad.a("RewardCampaignsResourceManager", "zip btl template download success");
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str4, true);
                                Message messageObtain2 = Message.obtain();
                                messageObtain2.what = 105;
                                Bundle bundle2 = new Bundle();
                                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle2.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle2.putString(TrackingKey.REQUEST_ID, str3);
                                bundle2.putString("url", str4);
                                messageObtain2.setData(bundle2);
                                b.this.f46533a.sendMessage(messageObtain2);
                                i iVar2 = iVar;
                                if (iVar2 != null) {
                                    iVar2.a(str, str2, str3, str4);
                                }
                                if (z11) {
                                    return;
                                }
                                b.a(b.this, context, 1, campaignEx, str4, "", str2, str5);
                            } catch (Exception e11) {
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str4, false);
                                Message messageObtain3 = Message.obtain();
                                messageObtain3.what = 205;
                                Bundle bundle3 = new Bundle();
                                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle3.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle3.putString(TrackingKey.REQUEST_ID, str3);
                                bundle3.putString("url", str4);
                                messageObtain3.setData(bundle3);
                                b.this.f46533a.sendMessage(messageObtain3);
                                if (iVar != null) {
                                    try {
                                        iVar.a(str4, str3, b.b(880005, new MBridgeIds(str, str2, str3), "", e11, null));
                                    } catch (Exception e12) {
                                        ad.b("RewardCampaignsResourceManager", e12.getMessage());
                                    }
                                }
                                b.a(b.this, context, 3, campaignEx, str4, e11.getLocalizedMessage(), str2, str5);
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                                }
                            }
                        }
                    });
                } catch (Exception e11) {
                    ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void a(final Context context, boolean z11, int i11, boolean z12, final int i12, final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, c cVar, final i iVar) {
        String str4 = str2 + "_" + str3;
        f46532b.put(str4, new a(z11, z12, i11, copyOnWriteArrayList.size(), str2, str3, i12, copyOnWriteArrayList));
        this.f46533a.a(str, str2, str3, cVar);
        this.f46533a.a(context);
        this.f46533a.a(str4, copyOnWriteArrayList);
        this.f46533a.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.b.1
            /* JADX WARN: Code duplicated, block: B:110:0x02bd  */
            /* JADX WARN: Code duplicated, block: B:112:0x02c7  */
            /* JADX WARN: Code duplicated, block: B:139:0x035d  */
            /* JADX WARN: Code duplicated, block: B:142:0x0365  */
            /* JADX WARN: Code duplicated, block: B:147:0x0375  */
            /* JADX WARN: Code duplicated, block: B:171:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:175:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:189:0x025d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:204:0x037d A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:208:0x036f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:59:0x0168  */
            /* JADX WARN: Code duplicated, block: B:60:0x0172  */
            /* JADX WARN: Code duplicated, block: B:76:0x01cf A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:77:0x01d1  */
            /* JADX WARN: Code duplicated, block: B:78:0x01e4  */
            /* JADX WARN: Code duplicated, block: B:79:0x01e7 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:80:0x01e9  */
            /* JADX WARN: Code duplicated, block: B:81:0x01fd  */
            /* JADX WARN: Code duplicated, block: B:90:0x023b  */
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it;
                CharSequence charSequence;
                CampaignEx.c cVar2;
                AnonymousClass1 anonymousClass1;
                String str5;
                String str6;
                boolean zIsDynamicView;
                boolean zL;
                CampaignEx campaignEx;
                String iconUrl;
                String imageUrl;
                String strC;
                CampaignEx campaignEx2;
                List<CampaignEx.c.a> listA;
                List<String> list;
                int i13;
                AnonymousClass1 anonymousClass2 = this;
                String str7 = "RewardCampaignsResourceManager";
                CopyOnWriteArrayList copyOnWriteArrayList2 = copyOnWriteArrayList;
                if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                    try {
                        ResDownloadCheckManager.getInstance().setCampaignList(copyOnWriteArrayList);
                        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(context, str2, copyOnWriteArrayList, i12, new f(b.this.f46533a, str, str2, str3));
                        com.mbridge.msdk.videocommon.download.b.getInstance().load(str2);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                        }
                    }
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (it2.hasNext()) {
                        CampaignEx campaignEx3 = (CampaignEx) it2.next();
                        if (campaignEx3 != null) {
                            try {
                                Message messageObtain = Message.obtain();
                                messageObtain.what = 106;
                                Bundle bundle = new Bundle();
                                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                                bundle.putString(TrackingKey.REQUEST_ID, str3);
                                messageObtain.setData(bundle);
                                b.this.f46533a.sendMessage(messageObtain);
                            } catch (Exception unused) {
                            }
                            CampaignEx.c rewardTemplateMode = campaignEx3.getRewardTemplateMode();
                            String str8 = "";
                            String str9 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                            if (rewardTemplateMode != null) {
                                String strE = rewardTemplateMode.e();
                                int iF = rewardTemplateMode.f();
                                if (campaignEx3.isDynamicView() && ai.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, strE)) {
                                    b.this.a(1, campaignEx3, iF + "", strE);
                                } else if (!TextUtils.isEmpty(strE) && !strE.contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                                    com.mbridge.msdk.foundation.same.report.d.b bVarA = b.this.a(campaignEx3, 2);
                                    if (strE.contains(".zip")) {
                                        try {
                                            H5DownLoadManager h5DownLoadManager = H5DownLoadManager.getInstance();
                                            Context context2 = context;
                                            String str10 = str;
                                            String str11 = str2;
                                            String str12 = str3;
                                            it = it2;
                                            try {
                                                h hVar = b.this.f46533a;
                                                try {
                                                    i iVar2 = iVar;
                                                    cVar2 = rewardTemplateMode;
                                                    try {
                                                        CopyOnWriteArrayList copyOnWriteArrayList3 = copyOnWriteArrayList;
                                                        str7 = str7;
                                                        campaignEx3 = campaignEx3;
                                                        str8 = "";
                                                        str9 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                        charSequence = ".zip";
                                                        try {
                                                            h5DownLoadManager.downloadH5Res(bVarA, strE, new g(context2, str10, str11, str12, campaignEx3, 859, hVar, iVar2, copyOnWriteArrayList3));
                                                            anonymousClass1 = this;
                                                            str5 = str7;
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            if (MBridgeConstans.DEBUG) {
                                                                str5 = str7;
                                                                ad.b(str5, e.getLocalizedMessage());
                                                            } else {
                                                                str5 = str7;
                                                            }
                                                            anonymousClass1 = this;
                                                        }
                                                    } catch (Exception e13) {
                                                        e = e13;
                                                        charSequence = ".zip";
                                                        if (MBridgeConstans.DEBUG) {
                                                            str5 = str7;
                                                            ad.b(str5, e.getLocalizedMessage());
                                                        } else {
                                                            str5 = str7;
                                                        }
                                                        anonymousClass1 = this;
                                                        str6 = campaignEx3.getendcard_url();
                                                        zIsDynamicView = campaignEx3.isDynamicView();
                                                        zL = ai.l(str6);
                                                        if (TextUtils.isEmpty(str6)) {
                                                            campaignEx = campaignEx3;
                                                        } else {
                                                            if (!zIsDynamicView) {
                                                                b.a(b.this, context, str, str2, str3, campaignEx3, str6, iVar, copyOnWriteArrayList);
                                                            } else if (zL) {
                                                                b.a(b.this, context, str, str2, str3, campaignEx3, str6, iVar, copyOnWriteArrayList);
                                                            } else if (ai.a(str9, str6)) {
                                                                try {
                                                                    i13 = Integer.parseInt(ao.a(str6, "ecid"));
                                                                } catch (Throwable th2) {
                                                                    ad.b(str5, th2.getMessage());
                                                                    i13 = 404;
                                                                }
                                                                campaignEx = campaignEx3;
                                                                b.this.a(2, campaignEx, i13 + str8, str6);
                                                            }
                                                            campaignEx = campaignEx3;
                                                        }
                                                        if (!TextUtils.isEmpty(campaignEx.getEndScreenUrl())) {
                                                            H5DownLoadManager.getInstance().download(b.this.a(campaignEx, 6), campaignEx.getEndScreenUrl());
                                                        }
                                                        iconUrl = campaignEx.getIconUrl();
                                                        if (!TextUtils.isEmpty(iconUrl)) {
                                                            try {
                                                                com.mbridge.msdk.foundation.same.c.b.a(context).a(iconUrl, new e(b.this.f46533a, 0, str, str2, str3, campaignEx));
                                                            } catch (Exception e14) {
                                                                if (MBridgeConstans.DEBUG) {
                                                                    ad.b(str5, e14.getLocalizedMessage());
                                                                }
                                                            }
                                                        }
                                                        imageUrl = campaignEx.getImageUrl();
                                                        if (!TextUtils.isEmpty(imageUrl)) {
                                                            try {
                                                                com.mbridge.msdk.foundation.same.c.b.a(context).a(imageUrl, new e(b.this.f46533a, 0, str, str2, str3, campaignEx));
                                                            } catch (Exception e15) {
                                                                if (MBridgeConstans.DEBUG) {
                                                                    ad.b(str5, e15.getLocalizedMessage());
                                                                }
                                                            }
                                                        }
                                                        if (cVar2 != null) {
                                                            strC = cVar2.c();
                                                            if (TextUtils.isEmpty(strC)) {
                                                                campaignEx2 = campaignEx;
                                                            } else {
                                                                campaignEx2 = campaignEx;
                                                            }
                                                            listA = cVar2.a();
                                                            if (listA != null) {
                                                                while (r2.hasNext()) {
                                                                    if (aVar == null) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        str7 = str5;
                                                        anonymousClass2 = anonymousClass1;
                                                        it2 = it;
                                                    }
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    cVar2 = rewardTemplateMode;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                                str9 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                str8 = "";
                                                charSequence = ".zip";
                                                campaignEx3 = campaignEx3;
                                                cVar2 = rewardTemplateMode;
                                                if (MBridgeConstans.DEBUG) {
                                                    str5 = str7;
                                                    ad.b(str5, e.getLocalizedMessage());
                                                } else {
                                                    str5 = str7;
                                                }
                                                anonymousClass1 = this;
                                                str6 = campaignEx3.getendcard_url();
                                                zIsDynamicView = campaignEx3.isDynamicView();
                                                zL = ai.l(str6);
                                                if (TextUtils.isEmpty(str6)) {
                                                    campaignEx = campaignEx3;
                                                } else {
                                                    if (!zIsDynamicView) {
                                                        b.a(b.this, context, str, str2, str3, campaignEx3, str6, iVar, copyOnWriteArrayList);
                                                    } else if (zL) {
                                                        b.a(b.this, context, str, str2, str3, campaignEx3, str6, iVar, copyOnWriteArrayList);
                                                    } else if (ai.a(str9, str6)) {
                                                        i13 = Integer.parseInt(ao.a(str6, "ecid"));
                                                        campaignEx = campaignEx3;
                                                        b.this.a(2, campaignEx, i13 + str8, str6);
                                                    }
                                                    campaignEx = campaignEx3;
                                                }
                                                if (!TextUtils.isEmpty(campaignEx.getEndScreenUrl())) {
                                                    H5DownLoadManager.getInstance().download(b.this.a(campaignEx, 6), campaignEx.getEndScreenUrl());
                                                }
                                                iconUrl = campaignEx.getIconUrl();
                                                if (!TextUtils.isEmpty(iconUrl)) {
                                                    com.mbridge.msdk.foundation.same.c.b.a(context).a(iconUrl, new e(b.this.f46533a, 0, str, str2, str3, campaignEx));
                                                }
                                                imageUrl = campaignEx.getImageUrl();
                                                if (!TextUtils.isEmpty(imageUrl)) {
                                                    com.mbridge.msdk.foundation.same.c.b.a(context).a(imageUrl, new e(b.this.f46533a, 0, str, str2, str3, campaignEx));
                                                }
                                                if (cVar2 != null) {
                                                    strC = cVar2.c();
                                                    if (TextUtils.isEmpty(strC)) {
                                                        campaignEx2 = campaignEx;
                                                    } else {
                                                        campaignEx2 = campaignEx;
                                                    }
                                                    listA = cVar2.a();
                                                    if (listA != null) {
                                                        while (r2.hasNext()) {
                                                            if (aVar == null) {
                                                            }
                                                        }
                                                    }
                                                }
                                                str7 = str5;
                                                anonymousClass2 = anonymousClass1;
                                                it2 = it;
                                            }
                                        } catch (Exception e18) {
                                            e = e18;
                                            it = it2;
                                        }
                                    } else {
                                        str5 = str7;
                                        it = it2;
                                        str9 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                        str8 = "";
                                        charSequence = ".zip";
                                        campaignEx3 = campaignEx3;
                                        cVar2 = rewardTemplateMode;
                                        ad.a(str5, "开始下载 html 类型的 template");
                                        try {
                                            anonymousClass1 = this;
                                            try {
                                                H5DownLoadManager.getInstance().downloadH5Res(bVarA, strE, new d(859, str, str2, str3, campaignEx3, iVar, b.this.f46533a, copyOnWriteArrayList));
                                            } catch (Exception e19) {
                                                e = e19;
                                                if (MBridgeConstans.DEBUG) {
                                                    ad.b(str5, e.getLocalizedMessage());
                                                }
                                            }
                                        } catch (Exception e21) {
                                            e = e21;
                                            anonymousClass1 = this;
                                        }
                                    }
                                }
                                it = it2;
                                str9 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                str8 = "";
                                charSequence = ".zip";
                                campaignEx3 = campaignEx3;
                                cVar2 = rewardTemplateMode;
                                anonymousClass1 = anonymousClass2;
                                str5 = str7;
                            } else {
                                it = it2;
                                str9 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                str8 = "";
                                charSequence = ".zip";
                                campaignEx3 = campaignEx3;
                                cVar2 = rewardTemplateMode;
                                anonymousClass1 = anonymousClass2;
                                str5 = str7;
                            }
                            str6 = campaignEx3.getendcard_url();
                            zIsDynamicView = campaignEx3.isDynamicView();
                            zL = ai.l(str6);
                            if (TextUtils.isEmpty(str6)) {
                                campaignEx = campaignEx3;
                            } else {
                                if (!zIsDynamicView) {
                                    b.a(b.this, context, str, str2, str3, campaignEx3, str6, iVar, copyOnWriteArrayList);
                                } else if (zL) {
                                    b.a(b.this, context, str, str2, str3, campaignEx3, str6, iVar, copyOnWriteArrayList);
                                } else if (ai.a(str9, str6)) {
                                    i13 = Integer.parseInt(ao.a(str6, "ecid"));
                                    campaignEx = campaignEx3;
                                    b.this.a(2, campaignEx, i13 + str8, str6);
                                }
                                campaignEx = campaignEx3;
                            }
                            if (!TextUtils.isEmpty(campaignEx.getEndScreenUrl()) && !campaignEx.isDynamicView()) {
                                H5DownLoadManager.getInstance().download(b.this.a(campaignEx, 6), campaignEx.getEndScreenUrl());
                            }
                            iconUrl = campaignEx.getIconUrl();
                            if (!TextUtils.isEmpty(iconUrl)) {
                                com.mbridge.msdk.foundation.same.c.b.a(context).a(iconUrl, new e(b.this.f46533a, 0, str, str2, str3, campaignEx));
                            }
                            imageUrl = campaignEx.getImageUrl();
                            if (!TextUtils.isEmpty(imageUrl)) {
                                com.mbridge.msdk.foundation.same.c.b.a(context).a(imageUrl, new e(b.this.f46533a, 0, str, str2, str3, campaignEx));
                            }
                            if (cVar2 != null) {
                                strC = cVar2.c();
                                if (TextUtils.isEmpty(strC) || campaignEx.isDynamicView()) {
                                    campaignEx2 = campaignEx;
                                } else {
                                    int i14 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
                                    com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b(true);
                                    bVar.c(i14);
                                    if (strC.contains(charSequence)) {
                                        ad.a(str5, "开始下载 zip 类型的 pause");
                                        try {
                                            campaignEx2 = campaignEx;
                                            try {
                                                H5DownLoadManager.getInstance().downloadH5Res(bVar, strC, new g(context, str, str2, str3, campaignEx, 313, b.this.f46533a, iVar, copyOnWriteArrayList));
                                            } catch (Exception e22) {
                                                e = e22;
                                                if (MBridgeConstans.DEBUG) {
                                                    ad.b(str5, e.getLocalizedMessage());
                                                }
                                            }
                                        } catch (Exception e23) {
                                            e = e23;
                                            campaignEx2 = campaignEx;
                                        }
                                    } else {
                                        campaignEx2 = campaignEx;
                                        try {
                                            H5DownLoadManager.getInstance().downloadH5Res(bVar, strC, new d(313, str, str2, str3, campaignEx2, iVar, b.this.f46533a, copyOnWriteArrayList));
                                        } catch (Exception e24) {
                                            if (MBridgeConstans.DEBUG) {
                                                ad.b(str5, e24.getLocalizedMessage());
                                            }
                                        }
                                    }
                                }
                                listA = cVar2.a();
                                if (listA != null && listA.size() > 0) {
                                    for (CampaignEx.c.a aVar : listA) {
                                        if (aVar == null && (list = aVar.f44239a) != null && list.size() > 0) {
                                            for (String str13 : aVar.f44239a) {
                                                if (!TextUtils.isEmpty(str13)) {
                                                    try {
                                                        com.mbridge.msdk.foundation.same.c.b.a(context).a(str13, new e(b.this.f46533a, 1, str, str2, str3, campaignEx2));
                                                    } catch (Exception e25) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            ad.b(str5, e25.getLocalizedMessage());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            str7 = str5;
                            anonymousClass2 = anonymousClass1;
                            it2 = it;
                        }
                    }
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:67:0x01c4 A[Catch: all -> 0x003c, TryCatch #9 {, blocks: (B:4:0x000b, B:5:0x0023, B:8:0x002b, B:16:0x0047, B:26:0x008c, B:29:0x0092, B:31:0x0098, B:34:0x00a7, B:36:0x00dd, B:38:0x00f3, B:65:0x01c0, B:67:0x01c4, B:69:0x01cf, B:33:0x00a1, B:48:0x0118, B:50:0x0128, B:52:0x013a, B:62:0x0176), top: B:84:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01cf A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #9 {, blocks: (B:4:0x000b, B:5:0x0023, B:8:0x002b, B:16:0x0047, B:26:0x008c, B:29:0x0092, B:31:0x0098, B:34:0x00a7, B:36:0x00dd, B:38:0x00f3, B:65:0x01c0, B:67:0x01c4, B:69:0x01cf, B:33:0x00a1, B:48:0x0118, B:50:0x0128, B:52:0x013a, B:62:0x0176), top: B:84:0x000b }] */
    public final synchronized void a(boolean z11, Handler handler, boolean z12, boolean z13, WindVaneWebView windVaneWebView, String str, int i11, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, String str4, String str5, String str6, com.mbridge.msdk.videocommon.d.c cVar, j jVar) {
        String str7;
        com.mbridge.msdk.videocommon.a.C0532a c0532a;
        String str8;
        String str9;
        String str10 = str5;
        synchronized (this) {
            String str11 = str4 + "_" + str;
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                if (ai.i(str)) {
                    if (jVar != null) {
                        jVar.a(str11, str3, str4, str5, str, null);
                    }
                    return;
                }
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("type", 2);
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000154", campaignEx, dVar);
                com.mbridge.msdk.videocommon.a.C0532a c0532a2 = new com.mbridge.msdk.videocommon.a.C0532a();
                try {
                    try {
                        try {
                            try {
                                try {
                                    WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                                    if (campaignEx != null) {
                                        try {
                                            windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
                                        } catch (Exception unused) {
                                            c0532a = c0532a2;
                                            str8 = str4;
                                            str9 = str;
                                            if (jVar != null) {
                                                c0532a.a(true);
                                                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str8 + "_" + str10 + "_" + str9, true);
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str8);
                                                sb2.append("_");
                                                sb2.append(str9);
                                                jVar.a(sb2.toString(), str3, str4, str5, str, c0532a);
                                            }
                                            return;
                                        } catch (Throwable unused2) {
                                            if (jVar != null) {
                                                c0532a2.a(true);
                                                ResDownloadCheckManager resDownloadCheckManager = ResDownloadCheckManager.getInstance();
                                                StringBuilder sb3 = new StringBuilder();
                                                str7 = str4;
                                                try {
                                                    sb3.append(str7);
                                                    sb3.append("_");
                                                    sb3.append(str10);
                                                    sb3.append("_");
                                                    sb3.append(str);
                                                    resDownloadCheckManager.setTemplatePreLoadDone(sb3.toString(), true);
                                                    jVar.a(str7 + "_" + str, str3, str4, str5, str, c0532a2);
                                                } catch (Exception e11) {
                                                    e = e11;
                                                    if (MBridgeConstans.DEBUG) {
                                                        ad.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                                    }
                                                    if (jVar != null) {
                                                        jVar.a(str11, str5, str, null, b(880009, new MBridgeIds(str3, str7, str10), "", e, campaignEx));
                                                    }
                                                }
                                            }
                                            return;
                                        }
                                    }
                                    windVaneWebView2.setTempTypeForMetrics(2);
                                    try {
                                        c0532a2.a(windVaneWebView2);
                                        com.mbridge.msdk.video.signal.a.k kVar = (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? new com.mbridge.msdk.video.signal.a.k(null, campaignEx) : new com.mbridge.msdk.video.signal.a.k(null, campaignEx, copyOnWriteArrayList);
                                        kVar.a(i11);
                                        kVar.a(str4);
                                        kVar.a(cVar);
                                        kVar.d(z11);
                                        try {
                                            windVaneWebView2.setWebViewListener(new k(handler, null, z12, z13, str5, jVar, windVaneWebView, str, str3, str4, c0532a2, campaignEx, copyOnWriteArrayList, jCurrentTimeMillis));
                                            windVaneWebView2.setObject(kVar);
                                            windVaneWebView2.loadUrl(str2);
                                            windVaneWebView2.setRid(str5);
                                        } catch (Exception e12) {
                                            e = e12;
                                            str10 = str5;
                                            str7 = str4;
                                            if (MBridgeConstans.DEBUG) {
                                                ad.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                            }
                                            if (jVar != null) {
                                                jVar.a(str11, str5, str, null, b(880009, new MBridgeIds(str3, str7, str10), "", e, campaignEx));
                                            }
                                        }
                                    } catch (Exception e13) {
                                        e = e13;
                                        str10 = str10;
                                    }
                                } catch (Exception unused3) {
                                    c0532a = c0532a2;
                                    str9 = str;
                                    str8 = str4;
                                }
                            } catch (Exception unused4) {
                                c0532a = c0532a2;
                                str8 = str4;
                                str9 = str;
                            }
                        } catch (Throwable unused5) {
                        }
                    } catch (Exception e14) {
                        e = e14;
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                        if (jVar != null) {
                            jVar.a(str11, str5, str, null, b(880009, new MBridgeIds(str3, str7, str10), "", e, campaignEx));
                        }
                    }
                } catch (Exception e15) {
                    e = e15;
                }
            } catch (Exception e16) {
                e = e16;
                str10 = str10;
                str7 = str4;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x01db A[Catch: all -> 0x0046, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x000d, B:7:0x0033, B:13:0x004b, B:15:0x007e, B:18:0x008b, B:20:0x00a6, B:22:0x00ac, B:24:0x00b6, B:27:0x00bd, B:29:0x00c3, B:30:0x00cd, B:32:0x00d3, B:34:0x00e7, B:36:0x00f5, B:38:0x00fe, B:39:0x0102, B:42:0x0113, B:44:0x0161, B:46:0x0175, B:48:0x0195, B:57:0x01db, B:58:0x01fd, B:60:0x0201, B:41:0x010c), top: B:67:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0201 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x000d, B:7:0x0033, B:13:0x004b, B:15:0x007e, B:18:0x008b, B:20:0x00a6, B:22:0x00ac, B:24:0x00b6, B:27:0x00bd, B:29:0x00c3, B:30:0x00cd, B:32:0x00d3, B:34:0x00e7, B:36:0x00f5, B:38:0x00fe, B:39:0x0102, B:42:0x0113, B:44:0x0161, B:46:0x0175, B:48:0x0195, B:57:0x01db, B:58:0x01fd, B:60:0x0201, B:41:0x010c), top: B:67:0x000d }] */
    public final synchronized void a(boolean z11, Handler handler, boolean z12, boolean z13, String str, String str2, String str3, String str4, String str5, int i11, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str6, String str7, com.mbridge.msdk.videocommon.d.c cVar, j jVar, boolean z14) {
        String str8;
        String str9;
        com.mbridge.msdk.video.signal.a.k kVar;
        this.f46534c = z14;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str10 = str4 + "_" + str5;
        this.f46534c = z14;
        if (ai.i(str5)) {
            if (jVar != null) {
                jVar.a(str10, str3, str4, str, str5, null);
            }
            return;
        }
        try {
            ad.a("RewardCampaignsResourceManager", "开始预加载大模板资源");
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("type", 1);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000154", campaignEx, dVar);
            com.mbridge.msdk.videocommon.a.C0532a c0532a = new com.mbridge.msdk.videocommon.a.C0532a();
            WindVaneWebView windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().c());
            if (campaignEx != null) {
                windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
            }
            windVaneWebView.setTempTypeForMetrics(1);
            c0532a.a(windVaneWebView);
            String strA = com.mbridge.msdk.video.bt.a.d.c().a();
            String strA2 = com.mbridge.msdk.video.bt.a.d.c().a();
            c0532a.a(strA2);
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx);
            } else {
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(str4);
                if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0) {
                    for (int i12 = 0; i12 < copyOnWriteArrayList.size(); i12++) {
                        CampaignEx campaignEx2 = copyOnWriteArrayList.get(i12);
                        for (CampaignEx campaignEx3 : copyOnWriteArrayListA) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i12, campaignEx2);
                            }
                        }
                    }
                }
                kVar = new com.mbridge.msdk.video.signal.a.k(null, campaignEx, copyOnWriteArrayList);
            }
            com.mbridge.msdk.video.signal.a.k kVar2 = kVar;
            kVar2.a(i11);
            kVar2.a(str7);
            kVar2.c(strA2);
            kVar2.d(strA);
            kVar2.c(true);
            kVar2.a(cVar);
            kVar2.d(z11);
            try {
                windVaneWebView.setWebViewListener(new C0511b(z11, handler, null, z12, z13, i11, str5, str3, str4, str, c0532a, campaignEx, copyOnWriteArrayList, cVar, jVar, z14, jCurrentTimeMillis));
                windVaneWebView.setObject(kVar2);
                windVaneWebView.loadUrl(str6);
                str9 = str;
                try {
                    windVaneWebView.setRid(str9);
                    MBridgeBTRootLayout mBridgeBTRootLayout = new MBridgeBTRootLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                    mBridgeBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    mBridgeBTRootLayout.setInstanceId(strA);
                    str8 = str4;
                    try {
                        mBridgeBTRootLayout.setUnitId(str8);
                        MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().c());
                        mBridgeBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        mBridgeBTLayout.setInstanceId(strA2);
                        mBridgeBTLayout.setUnitId(str8);
                        mBridgeBTLayout.setWebView(windVaneWebView);
                        AbstractMap abstractMapB = com.mbridge.msdk.video.bt.a.d.c().b(str8, str9);
                        abstractMapB.put(strA2, mBridgeBTLayout);
                        abstractMapB.put(strA, mBridgeBTRootLayout);
                        mBridgeBTRootLayout.addView(mBridgeBTLayout, new FrameLayout.LayoutParams(-1, -1));
                    } catch (Exception e11) {
                        e = e11;
                        if (jVar != null) {
                            jVar.a(str10, str, str5, null, b(880008, new MBridgeIds(str3, str8, str9), "", e, campaignEx));
                        }
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    str8 = str4;
                    if (jVar != null) {
                        jVar.a(str10, str, str5, null, b(880008, new MBridgeIds(str3, str8, str9), "", e, campaignEx));
                    }
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            } catch (Exception e13) {
                e = e13;
                str9 = str;
            }
        } catch (Exception e14) {
            e = e14;
            str8 = str4;
            str9 = str;
        }
    }
}
