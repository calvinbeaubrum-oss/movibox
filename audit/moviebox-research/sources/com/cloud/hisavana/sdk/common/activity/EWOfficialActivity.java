package com.cloud.hisavana.sdk.common.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import w9.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class EWOfficialActivity extends com.cloud.hisavana.sdk.common.activity.a {

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.b {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebPageBean webPageBean = EWOfficialActivity.this.f29355r;
            if (webPageBean == null) {
                return;
            }
            webPageBean.setLoadStartTime(System.currentTimeMillis());
            if (TextUtils.isEmpty(str) || !a0.e(EWOfficialActivity.this.f29355r.getUrl(), str)) {
                return;
            }
            EWOfficialActivity eWOfficialActivity = EWOfficialActivity.this;
            if (eWOfficialActivity.f29352o) {
                return;
            }
            eWOfficialActivity.f29352o = true;
            AthenaTracker.p0(eWOfficialActivity.f29355r.getWebId(), EWOfficialActivity.this.f29355r.getUrl(), EWOfficialActivity.this.f29355r.getTargetUrl(), 0, EWOfficialActivity.this.f29355r.getRedirectType(), EWOfficialActivity.this.f29355r.getLoadTime());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT < 23 && EWOfficialActivity.this.f29355r != null && !TextUtils.isEmpty(str2) && a0.e(EWOfficialActivity.this.f29355r.getUrl(), str2)) {
                EWOfficialActivity eWOfficialActivity = EWOfficialActivity.this;
                eWOfficialActivity.f29350m = true;
                eWOfficialActivity.f29355r.setErrorType("error");
                EWOfficialActivity.this.f29355r.setErrorCode(i11);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (EWOfficialActivity.this.f29355r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !a0.e(EWOfficialActivity.this.f29355r.getUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            EWOfficialActivity eWOfficialActivity = EWOfficialActivity.this;
            eWOfficialActivity.f29350m = true;
            eWOfficialActivity.f29355r.setErrorType("error");
            EWOfficialActivity.this.f29355r.setErrorCode(webResourceError.getErrorCode());
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (EWOfficialActivity.this.f29355r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !a0.e(EWOfficialActivity.this.f29355r.getUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            EWOfficialActivity eWOfficialActivity = EWOfficialActivity.this;
            eWOfficialActivity.f29350m = true;
            eWOfficialActivity.f29355r.setErrorType("error");
            EWOfficialActivity.this.f29355r.setErrorCode(webResourceResponse.getStatusCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (EWOfficialActivity.this.f29355r == null || TextUtils.isEmpty(sslError.getUrl()) || !a0.e(EWOfficialActivity.this.f29355r.getUrl(), sslError.getUrl())) {
                return;
            }
            EWOfficialActivity eWOfficialActivity = EWOfficialActivity.this;
            eWOfficialActivity.f29350m = true;
            eWOfficialActivity.f29355r.setErrorType("ssl");
            EWOfficialActivity.this.f29355r.setErrorCode(sslError.getPrimaryError());
        }
    }

    private void r() {
        AdsDTO adsDTO = this.f29346i;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getAdChoiceClickUrl()) || this.f29345h == null) {
            com.cloud.hisavana.sdk.z.a().e("EWOfficialActivity", "loadAdChoiceUrl ad or adChoiceUrl is null");
            finish();
            return;
        }
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl(this.f29346i.getAdChoiceClickUrl());
            AthenaTracker.q0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), "open");
        }
        p(this.f29346i.getAdChoiceClickUrl());
        this.f29345h.loadUrl(this.f29346i.getAdChoiceClickUrl());
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a
    public WebViewClient g() {
        return new a();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r();
    }
}
