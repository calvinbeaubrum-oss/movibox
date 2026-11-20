package com.cloud.hisavana.sdk.common.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.google.android.gms.ads.MobileAds;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import w9.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class OnlineLandingActivity extends com.cloud.hisavana.sdk.common.activity.a {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends x9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<OnlineLandingActivity> f29268b;

        public a(OnlineLandingActivity onlineLandingActivity) {
            this.f29268b = new WeakReference<>(onlineLandingActivity);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            OnlineLandingActivity onlineLandingActivity;
            super.onPageFinished(webView, str);
            if (webView == null || webView.getProgress() < 100 || this.f29267a <= 0 || (onlineLandingActivity = this.f29268b.get()) == null) {
                return;
            }
            AthenaTracker.e0(onlineLandingActivity.f29346i, this.f29267a);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebPageBean webPageBean;
            super.onPageStarted(webView, str, bitmap);
            OnlineLandingActivity onlineLandingActivity = this.f29268b.get();
            if (onlineLandingActivity == null || (webPageBean = onlineLandingActivity.f29355r) == null) {
                return;
            }
            webPageBean.setLoadStartTime(System.currentTimeMillis());
            if (TextUtils.isEmpty(str) || !a0.e(onlineLandingActivity.f29355r.getTargetUrl(), str) || onlineLandingActivity.f29352o) {
                return;
            }
            onlineLandingActivity.f29352o = true;
            AthenaTracker.p0(onlineLandingActivity.f29355r.getWebId(), onlineLandingActivity.f29355r.getUrl(), onlineLandingActivity.f29355r.getTargetUrl(), 0, onlineLandingActivity.f29355r.getRedirectType(), onlineLandingActivity.f29355r.getLoadTime());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            OnlineLandingActivity onlineLandingActivity;
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT >= 23 || (onlineLandingActivity = this.f29268b.get()) == null || onlineLandingActivity.f29355r == null || TextUtils.isEmpty(str2) || !a0.e(onlineLandingActivity.f29355r.getTargetUrl(), str2)) {
                return;
            }
            onlineLandingActivity.f29350m = true;
            onlineLandingActivity.f29355r.setErrorType("error");
            onlineLandingActivity.f29355r.setErrorCode(i11);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            OnlineLandingActivity onlineLandingActivity = this.f29268b.get();
            if (onlineLandingActivity == null || onlineLandingActivity.f29355r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !a0.e(onlineLandingActivity.f29355r.getTargetUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            onlineLandingActivity.f29350m = true;
            onlineLandingActivity.f29355r.setErrorType("error");
            onlineLandingActivity.f29355r.setErrorCode(webResourceError.getErrorCode());
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            OnlineLandingActivity onlineLandingActivity = this.f29268b.get();
            if (onlineLandingActivity == null || onlineLandingActivity.f29355r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !a0.e(onlineLandingActivity.f29355r.getTargetUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            onlineLandingActivity.f29350m = true;
            onlineLandingActivity.f29355r.setErrorType("error");
            onlineLandingActivity.f29355r.setErrorCode(webResourceResponse.getStatusCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebPageBean webPageBean;
            com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "sslerror " + sslError.getPrimaryError());
            OnlineLandingActivity onlineLandingActivity = this.f29268b.get();
            if (onlineLandingActivity != null && !TextUtils.isEmpty(sslError.getUrl()) && (webPageBean = onlineLandingActivity.f29355r) != null && a0.e(webPageBean.getTargetUrl(), sslError.getUrl())) {
                onlineLandingActivity.f29350m = true;
                onlineLandingActivity.f29355r.setErrorType("ssl");
                onlineLandingActivity.f29355r.setErrorCode(sslError.getPrimaryError());
            }
            this.f29267a++;
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            OnlineLandingActivity onlineLandingActivity;
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return false;
            }
            WeakReference<OnlineLandingActivity> weakReference = this.f29268b;
            if (weakReference != null && (onlineLandingActivity = weakReference.get()) != null) {
                if (TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                    return false;
                }
                com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "shouldOverrideUrlLoading url=" + webResourceRequest.getUrl().toString());
                return onlineLandingActivity.m(webResourceRequest.getUrl().toString());
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            OnlineLandingActivity onlineLandingActivity;
            com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "shouldOverrideUrlLoading url=" + str);
            WeakReference<OnlineLandingActivity> weakReference = this.f29268b;
            return (weakReference == null || (onlineLandingActivity = weakReference.get()) == null) ? super.shouldOverrideUrlLoading(webView, str) : onlineLandingActivity.m(str);
        }
    }

    private void r() {
        if (this.f29345h == null) {
            finish();
            com.cloud.hisavana.sdk.z.a().e("OnlineLandingActivity", "initPaw webview is null,finish");
            return;
        }
        try {
            com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "initPaw");
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.f29345h, true);
            MobileAds.class.getMethod("registerWebView", WebView.class).invoke(null, this.f29345h);
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e("OnlineLandingActivity", "initPaw " + Log.getStackTraceString(e11));
        }
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a
    public WebViewClient g() {
        return new a(this);
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r();
        s();
    }

    public final void s() {
        if (this.f29346i == null || this.f29345h == null) {
            finish();
            com.cloud.hisavana.sdk.z.a().e("OnlineLandingActivity", "loadLandingPage,ad is null,finish");
            return;
        }
        com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "loadLandingPage " + this.f29346i.getAdCreativeId());
        String strA = a(this.f29347j, this.f29346i);
        AthenaTracker.H(strA, this.f29346i, Boolean.FALSE);
        if (TextUtils.isEmpty(strA)) {
            finish();
            com.cloud.hisavana.sdk.z.a().e("OnlineLandingActivity", "loadLandingPage,click url is empty,finish");
            return;
        }
        if (j(strA)) {
            com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "loadLandingPage,click url is gp,go to gp,finish");
            finish();
            return;
        }
        if (f(strA)) {
            com.cloud.hisavana.sdk.z.a().e("OnlineLandingActivity", "loadLandingPage,checkDeepLink true finish");
            finish();
            return;
        }
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl(strA);
            AthenaTracker.q0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), "open");
        }
        HashMap map = new HashMap();
        map.put("Accept-Timezone", "UTC");
        p(strA);
        this.f29345h.loadUrl(strA, map);
        com.cloud.hisavana.sdk.z.a().d("OnlineLandingActivity", "loadLandingPage,url:" + strA);
    }
}
