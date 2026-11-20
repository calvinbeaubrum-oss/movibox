package com.cloud.hisavana.sdk.common.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSToastUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import w9.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PersonalCloseAdActivity extends com.cloud.hisavana.sdk.common.activity.a {

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.b {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebPageBean webPageBean = PersonalCloseAdActivity.this.f29355r;
            if (webPageBean == null) {
                return;
            }
            webPageBean.setLoadStartTime(System.currentTimeMillis());
            if (TextUtils.isEmpty(str) || !a0.e(PersonalCloseAdActivity.this.f29355r.getUrl(), str)) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            if (personalCloseAdActivity.f29352o) {
                return;
            }
            personalCloseAdActivity.f29352o = true;
            AthenaTracker.p0(personalCloseAdActivity.f29355r.getWebId(), PersonalCloseAdActivity.this.f29355r.getUrl(), PersonalCloseAdActivity.this.f29355r.getTargetUrl(), 0, PersonalCloseAdActivity.this.f29355r.getRedirectType(), PersonalCloseAdActivity.this.f29355r.getLoadTime());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT < 23 && PersonalCloseAdActivity.this.f29355r != null && !TextUtils.isEmpty(str2) && a0.e(PersonalCloseAdActivity.this.f29355r.getUrl(), str2)) {
                PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
                personalCloseAdActivity.f29350m = true;
                personalCloseAdActivity.f29355r.setErrorType("error");
                PersonalCloseAdActivity.this.f29355r.setErrorCode(i11);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (PersonalCloseAdActivity.this.f29355r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !a0.e(PersonalCloseAdActivity.this.f29355r.getUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            personalCloseAdActivity.f29350m = true;
            personalCloseAdActivity.f29355r.setErrorType("error");
            PersonalCloseAdActivity.this.f29355r.setErrorCode(webResourceError.getErrorCode());
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (PersonalCloseAdActivity.this.f29355r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !a0.e(PersonalCloseAdActivity.this.f29355r.getUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            personalCloseAdActivity.f29350m = true;
            personalCloseAdActivity.f29355r.setErrorType("error");
            PersonalCloseAdActivity.this.f29355r.setErrorCode(webResourceResponse.getStatusCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (PersonalCloseAdActivity.this.f29355r == null || TextUtils.isEmpty(sslError.getUrl()) || !a0.e(PersonalCloseAdActivity.this.f29355r.getUrl(), sslError.getUrl())) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            personalCloseAdActivity.f29350m = true;
            personalCloseAdActivity.f29355r.setErrorType("ssl");
            PersonalCloseAdActivity.this.f29355r.setErrorCode(sslError.getPrimaryError());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalCloseAdActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f29271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AdsDTO f29272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f29273c;

        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {
            public a() {
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                com.cloud.hisavana.sdk.h.p().e(c.this.f29273c);
                Activity activity = (Activity) c.this.f29271a.get();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                activity.onBackPressed();
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b implements Preconditions.a {
            public b() {
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                Activity activity = (Activity) c.this.f29271a.get();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                activity.onBackPressed();
            }
        }

        public c(Activity activity, AdsDTO adsDTO) {
            this.f29271a = new WeakReference<>(activity);
            this.f29272b = adsDTO;
        }

        @JavascriptInterface
        public void athenaTrack(String str, String str2) {
            com.cloud.hisavana.sdk.z.a().d("PersonalCloseAdActivity", "athenaTrack -----> eventName = " + str + "  params = " + str2);
            AthenaTracker.R(this.f29272b, str, str2);
        }

        public void b(int i11) {
            this.f29273c = i11;
        }

        @JavascriptInterface
        public void closePage(String str, String str2) {
            Preconditions.d(new b());
        }

        @JavascriptInterface
        public void personaliseCallback() {
            com.cloud.hisavana.sdk.z.a().d("PersonalCloseAdActivity", "personaliseCallback");
            Preconditions.d(new a());
        }
    }

    private void r() {
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl(aa.a.a());
            AthenaTracker.q0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), "open");
            this.f29350m = true;
            this.f29355r.setErrorType("error");
            this.f29355r.setErrorCode(-2);
            String webId = this.f29355r.getWebId();
            String url = this.f29355r.getUrl();
            String targetUrl = this.f29355r.getTargetUrl();
            int redirectType = this.f29355r.getRedirectType();
            boolean z11 = this.f29350m;
            AthenaTracker.o0(webId, url, targetUrl, redirectType, z11 ? "fail" : "success", z11 ? this.f29355r.getErrorType() : "succeed", this.f29350m ? this.f29355r.getErrorCode() : 8000, -1L);
        }
    }

    private void s() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.layout_title);
        this.f29341c = frameLayout;
        frameLayout.setVisibility(0);
        HSToastUtil.f(getString(R$string.toast_no_network));
        ImageView imageView = this.f29343f;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a
    public WebViewClient g() {
        return new a();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (NetStateManager.checkNetworkState()) {
            t();
            return;
        }
        r();
        this.f29342d.setVisibility(8);
        findViewById(R$id.layout_no_net).setVisibility(0);
        s();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout = this.f29342d;
        if (frameLayout == null || frameLayout.getVisibility() != 8) {
            return;
        }
        com.cloud.hisavana.sdk.h.p().d();
    }

    public final void t() {
        if (this.f29345h == null) {
            return;
        }
        c cVar = new c(this, this.f29346i);
        this.f29345h.addJavascriptInterface(cVar, "sspWebView");
        cVar.b(getIntent().getIntExtra("close_hash_code", 0));
        u();
    }

    public final void u() {
        if (this.f29346i == null || this.f29345h == null) {
            return;
        }
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl(aa.a.a());
            AthenaTracker.q0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), "open");
        }
        StringBuilder sb2 = new StringBuilder(aa.a.a());
        sb2.append("?gaid=");
        sb2.append(DeviceUtil.e());
        sb2.append("&oneid=");
        sb2.append(DeviceUtil.j());
        sb2.append("&ad_creative_id=");
        sb2.append(this.f29346i.getAdCreativeId());
        sb2.append("&industry_id=");
        sb2.append(this.f29346i.getIndustryId());
        sb2.append("&app_id=");
        String str = AdManager.f29117b;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append("&code_seat_id=");
        sb2.append(this.f29346i.getCodeSeatId());
        sb2.append("&trigger_id=");
        sb2.append(this.f29346i.getTriggerId());
        sb2.append("&request_id=");
        sb2.append(this.f29346i.getRid());
        sb2.append("&advertiser_id=");
        sb2.append(this.f29346i.getAdvertiserId());
        String string = sb2.toString();
        com.cloud.hisavana.sdk.z.a().d("PersonalCloseAdActivity", "ad close url == " + string);
        p(string);
        this.f29345h.loadUrl(string);
    }
}
