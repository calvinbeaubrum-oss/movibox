package com.cloud.hisavana.sdk.common.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ViewJson;
import com.cloud.hisavana.sdk.e1;
import java.io.File;
import java.lang.ref.WeakReference;
import w9.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class OfflineLandingActivity extends com.cloud.hisavana.sdk.common.activity.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f29262s;

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.b {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        @Nullable
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            AdsDTO adsDTO;
            com.cloud.hisavana.sdk.z.a().d("OfflineLandingActivity", "shouldInterceptRequest URL== " + str);
            WebResourceResponse webResourceResponseA = d0.a(str);
            if (webResourceResponseA == null || (adsDTO = OfflineLandingActivity.this.f29346i) == null || !adsDTO.isOfflineAd()) {
                return super.shouldInterceptRequest(webView, str);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            OfflineLandingActivity offlineLandingActivity = OfflineLandingActivity.this;
            AthenaTracker.w(offlineLandingActivity.f29346i, jCurrentTimeMillis - offlineLandingActivity.f29349l);
            return webResourceResponseA;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                return false;
            }
            com.cloud.hisavana.sdk.z.a().d("OfflineLandingActivity", "shouldOverrideUrlLoading url=" + webResourceRequest.getUrl().toString());
            return OfflineLandingActivity.this.m(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.cloud.hisavana.sdk.z.a().d("OfflineLandingActivity", "shouldOverrideUrlLoading url=" + str);
            return OfflineLandingActivity.this.m(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<Handler> f29264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29265b;

        private b(Handler handler, String str) {
            this.f29264a = new WeakReference<>(handler);
            this.f29265b = str;
        }

        public /* synthetic */ b(Handler handler, String str, a aVar) {
            this(handler, str);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                String strC = w9.f.c(e1.f(this.f29265b, 1));
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString(String.valueOf(1), strC);
                bundle.putString("load_offline_H5_res", this.f29265b);
                messageObtain.setData(bundle);
                Handler handler = this.f29264a.get();
                if (handler == null) {
                    return;
                }
                handler.sendMessage(messageObtain);
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<OfflineLandingActivity> f29266a;

        public c(OfflineLandingActivity offlineLandingActivity, Looper looper) {
            super(looper);
            this.f29266a = new WeakReference<>(offlineLandingActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            OfflineLandingActivity offlineLandingActivity = this.f29266a.get();
            if (offlineLandingActivity == null) {
                return;
            }
            if (message.what == 1) {
                offlineLandingActivity.r(message);
            } else {
                com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "handleMessage,wrong msg.what");
            }
        }
    }

    private void v() {
        String clickUrl = this.f29346i.getClickUrl();
        if (j(clickUrl)) {
            return;
        }
        p(clickUrl);
        t(this.f29347j);
    }

    private void w(String str) {
        com.cloud.sdk.commonutil.util.i.f30292a.e(new b(this.f29262s, str, null));
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a
    public WebViewClient g() {
        return new a();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setUrl("");
        }
        this.f29262s = new c(this, getMainLooper());
        v();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f29262s;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
        }
    }

    public final void r(Message message) {
        Bundle data = message.getData();
        if (data == null || this.f29345h == null) {
            return;
        }
        String string = data.getString(String.valueOf(message.what));
        String string2 = data.getString("load_offline_H5_res");
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "postLoadOfflineH5,dataString or resString is empty");
            this.f29345h.loadUrl(this.f29346i.getOfflineH5Url());
            return;
        }
        WebView webView = this.f29345h;
        if (webView != null) {
            webView.loadDataWithBaseURL(string2, string, "text/html; charset=UTF-8", "UTF-8", null);
        } else {
            com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "postLoadOfflineH5,webview is null");
            finish();
        }
    }

    public final void t(DownUpPointBean downUpPointBean) {
        AdsDTO adsDTO = this.f29346i;
        if (adsDTO == null) {
            com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "loadOfflineWeb,adsDto is null");
            finish();
            return;
        }
        ViewJson viewJsonData = adsDTO.getViewJsonData();
        if (viewJsonData == null || viewJsonData.getOffline() == null) {
            com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "loadOfflineWeb,viewJsonData or viewJsonData.getOffline() is null");
            finish();
        } else if (!TextUtils.isEmpty(viewJsonData.getOffline().getRes())) {
            w(viewJsonData.getOffline().getRes());
            AthenaTracker.H(a(downUpPointBean, this.f29346i), this.f29346i, Boolean.FALSE);
        } else if (TextUtils.isEmpty(viewJsonData.getOffline().getZipRes())) {
            com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "loadOfflineWeb,can not open landingPage");
            finish();
        } else {
            u(viewJsonData.getOffline().getZipRes(), this.f29346i.getAdCreativeId());
            AthenaTracker.H(a(downUpPointBean, this.f29346i), this.f29346i, Boolean.FALSE);
        }
    }

    public final void u(String str, String str2) {
        WebView webView;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(w9.f.b(com.cloud.sdk.commonutil.util.f.a()));
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append("offline_zip");
        sb2.append(str3);
        sb2.append(w9.q.c(str));
        sb2.append(str3);
        sb2.append("index.html");
        String string = sb2.toString();
        if (new File(string).exists() && (webView = this.f29345h) != null) {
            webView.loadUrl(string);
        } else {
            com.cloud.hisavana.sdk.z.a().e("OfflineLandingActivity", "loadOfflineZip file.exists() is false,or webview is null");
            finish();
        }
    }
}
