package com.mbridge.msdk.splash.c;

import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f47098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f47099b;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f47106a = new g();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a();

        void a(int i11);

        void a(String str);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f47107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f47108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CampaignEx f47109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f47110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f47111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f47112f;

        public final String a() {
            return this.f47110d;
        }

        public final void a(int i11) {
            this.f47112f = i11;
        }

        public final void a(CampaignEx campaignEx) {
            this.f47109c = campaignEx;
        }

        public final void a(String str) {
            this.f47110d = str;
        }

        public final void a(boolean z11) {
            this.f47111e = z11;
        }

        public final String b() {
            return this.f47107a;
        }

        public final void b(String str) {
            this.f47107a = str;
        }

        public final String c() {
            return this.f47108b;
        }

        public final void c(String str) {
            this.f47108b = str;
        }

        public final CampaignEx d() {
            return this.f47109c;
        }

        public final boolean e() {
            return this.f47111e;
        }

        public final int f() {
            return this.f47112f;
        }
    }

    private g() {
        this.f47098a = false;
        this.f47099b = false;
    }

    public final void a() {
        this.f47098a = false;
        this.f47099b = false;
    }

    public final void a(final MBSplashView mBSplashView, c cVar, final b bVar) {
        if (mBSplashView == null || cVar == null) {
            return;
        }
        final String strC = cVar.c();
        String strB = cVar.b();
        final CampaignEx campaignExD = cVar.d();
        String strA = cVar.a();
        boolean zE = cVar.e();
        int iF = cVar.f();
        MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
        if (splashWebview == null) {
            return;
        }
        com.mbridge.msdk.splash.signal.c cVar2 = new com.mbridge.msdk.splash.signal.c(mBSplashView.getContext(), strB, strC);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignExD);
        cVar2.a(arrayList);
        cVar2.a(zE ? 1 : 0);
        cVar2.b(iF);
        mBSplashView.setSplashSignalCommunicationImpl(cVar2);
        String requestIdNotice = TextUtils.isEmpty(campaignExD.getRequestId()) ? campaignExD.getRequestIdNotice() : campaignExD.getRequestId();
        String requestId = splashWebview.getRequestId();
        ad.b("WebViewRenderManager", "CampaignEx RequestId = " + requestIdNotice + " WebView RequestId = " + requestId);
        if (!TextUtils.isEmpty(requestId) && requestId.equals(requestIdNotice) && (this.f47098a || this.f47099b)) {
            mBSplashView.setH5Ready(true);
            if (bVar != null) {
                bVar.a(1);
                return;
            }
            return;
        }
        a();
        splashWebview.setRequestId(requestIdNotice);
        com.mbridge.msdk.splash.a.c cVarA = com.mbridge.msdk.splash.a.c.a().c(campaignExD.getId()).d(campaignExD.getRequestId()).g(campaignExD.getRequestIdNotice()).b(strC).a(campaignExD.isBidCampaign());
        if (cVarA != null) {
            cVarA.a("2000067");
            if (j.a().b()) {
                j.a().a(cVarA.b());
            } else {
                m.a(cVarA.b(), com.mbridge.msdk.foundation.controller.c.m().c(), strC);
            }
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        splashWebview.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.splash.c.g.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i11) {
                super.a(webView, i11);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(i11);
                }
                if (i11 == 1) {
                    g.this.f47098a = true;
                    mBSplashView.setH5Ready(true);
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExD, strC, "", jCurrentTimeMillis, 1);
                    com.mbridge.msdk.splash.e.a.a(campaignExD, strC);
                    return;
                }
                g.this.f47098a = false;
                mBSplashView.setH5Ready(false);
                com.mbridge.msdk.splash.e.a.a(campaignExD, "readyState 2", strC);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExD, strC, "readyState 2", jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i11, String str, String str2) {
                super.a(webView, i11, str, str2);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(str);
                }
                g.this.a();
                mBSplashView.setH5Ready(false);
                com.mbridge.msdk.splash.e.a.a(campaignExD, "error code:" + i11 + str, strC);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExD, strC, "error code:" + i11 + str, jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.a(webView, sslErrorHandler, sslError);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(sslError.toString());
                }
                g.this.a();
                mBSplashView.setH5Ready(false);
                com.mbridge.msdk.splash.e.a.a(campaignExD, "error url:" + sslError.getUrl(), strC);
                com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExD, strC, "error url:" + sslError.getUrl(), jCurrentTimeMillis, 3);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a();
                }
                g.this.f47099b = true;
                if (!campaignExD.isHasMBTplMark()) {
                    mBSplashView.setH5Ready(true);
                    com.mbridge.msdk.splash.e.a.a(campaignExD, strC);
                    com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExD, strC, "", jCurrentTimeMillis, 1);
                }
                com.mbridge.msdk.splash.signal.d.a(webView);
            }
        });
        if (!splashWebview.isDestoryed()) {
            splashWebview.loadUrl(strA);
        } else {
            mBSplashView.setH5Ready(false);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignExD, strC, "webview had destory", jCurrentTimeMillis, 3);
        }
    }
}
