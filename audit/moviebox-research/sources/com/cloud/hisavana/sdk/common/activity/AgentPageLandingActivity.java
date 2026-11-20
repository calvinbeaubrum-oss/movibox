package com.cloud.hisavana.sdk.common.activity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient;
import com.cloud.hisavana.sdk.internal.agentpage.bean.AgentPageCurrentAd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AgentPageLandingActivity extends com.cloud.hisavana.sdk.common.activity.a {

    /* JADX INFO: compiled from: source.java */
    public class a implements AgentPageWebViewClient.OverrideListener {
        public a() {
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public boolean OnOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebPageBean webPageBeanK;
            String string;
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                return false;
            }
            com.cloud.hisavana.sdk.z.a().d("AgentPageLandingActivity", "shouldOverrideUrlLoading url=" + webResourceRequest.getUrl().toString());
            Uri url = webResourceRequest.getUrl();
            if (TextUtils.isEmpty(url.getAuthority()) || !url.getAuthority().contains("googleads")) {
                webPageBeanK = AgentPageLandingActivity.this.k();
                string = "";
            } else {
                webPageBeanK = AgentPageLandingActivity.this.k();
                string = webResourceRequest.getUrl().toString();
            }
            webPageBeanK.setUrl(string);
            return AgentPageLandingActivity.this.m(webResourceRequest.getUrl().toString());
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public boolean OnOverrideUrlLoading(WebView webView, String str) {
            com.cloud.hisavana.sdk.z.a().d("AgentPageLandingActivity", "shouldOverrideUrlLoading url=" + str);
            if (TextUtils.isEmpty(str) || !str.contains("googleads")) {
                AgentPageLandingActivity.this.k().setUrl("");
            } else {
                AgentPageLandingActivity.this.k().setUrl(str);
            }
            return AgentPageLandingActivity.this.m(str);
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public void onError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (Build.VERSION.SDK_INT >= 23) {
                com.cloud.hisavana.sdk.z.a().e("AgentPageLandingActivity", "onError for:" + webResourceRequest.getUrl() + ",error code: " + webResourceError.getErrorCode());
            }
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public void onPageFinished(WebView webView, String str) {
            com.cloud.hisavana.sdk.z.a().d("AgentPageLandingActivity", "onPageFinished for:" + str);
        }
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a
    public WebViewClient g() {
        return new AgentPageWebViewClient(new a());
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl("");
        }
        r();
    }

    public final void r() {
        if (this.f29346i == null) {
            com.cloud.hisavana.sdk.z.a().e("AgentPageLandingActivity", "loadAgentPageWeb,adsDto is null");
            finish();
            return;
        }
        AgentPageJsBridge agentPageJsBridge = new AgentPageJsBridge();
        agentPageJsBridge.setCurrentAdInfo(new AgentPageCurrentAd("", "", ""));
        agentPageJsBridge.setWebview(this.f29345h);
        this.f29345h.addJavascriptInterface(agentPageJsBridge, AgentPageJsBridge.INTERFACE_NAME);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.f29345h, true);
        this.f29345h.getSettings().setMediaPlaybackRequiresUserGesture(false);
        String clickUrl = this.f29346i.getClickUrl();
        p(clickUrl);
        s(clickUrl);
    }

    public final void s(String str) {
        if (!str.contains(AgentPageJsBridge.AGENT_PAGE_INFO)) {
            com.cloud.hisavana.sdk.z.a().e("AgentPageLandingActivity", "loadAgentPageWeb, url is not legal");
            finish();
            return;
        }
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl(str);
            AthenaTracker.q0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), "open");
        }
        this.f29345h.loadUrl(str);
    }
}
