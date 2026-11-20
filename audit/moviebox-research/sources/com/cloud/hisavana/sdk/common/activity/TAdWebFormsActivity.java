package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.request.FormBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.o1;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.google.logging.type.LogSeverity;
import java.lang.ref.WeakReference;
import w9.a0;
import w9.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TAdWebFormsActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AdsDTO f29322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DownUpPointBean f29323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f29324d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f29325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f29326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebView f29327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f29328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f29329j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f29321a = LogSeverity.EMERGENCY_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f29330k = new c(this, Looper.getMainLooper());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WebViewClient f29331l = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WebChromeClient f29332m = new WebChromeClient();

    /* JADX INFO: compiled from: source.java */
    public class a extends x9.b {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // x9.b, android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT > 26) {
                return false;
            }
            if (webView != TAdWebFormsActivity.this.f29327h || TAdWebFormsActivity.this.f29327h == null) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            ((ViewGroup) TAdWebFormsActivity.this.f29327h.getParent()).removeView(TAdWebFormsActivity.this.f29327h);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            com.cloud.hisavana.sdk.z.a().d("TAdWebFormsActivity", "shouldInterceptRequest URL== " + str);
            WebResourceResponse webResourceResponseA = d0.a(str);
            if (webResourceResponseA == null || TAdWebFormsActivity.this.f29322b == null || !TAdWebFormsActivity.this.f29322b.isOfflineAd()) {
                return super.shouldInterceptRequest(webView, str);
            }
            AthenaTracker.w(TAdWebFormsActivity.this.f29322b, System.currentTimeMillis() - TAdWebFormsActivity.this.f29329j);
            return webResourceResponseA;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<TAdWebFormsActivity> f29334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference<AdsDTO> f29335b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WeakReference<Handler> f29336c;

        private b(TAdWebFormsActivity tAdWebFormsActivity, AdsDTO adsDTO, Handler handler) {
            this.f29334a = new WeakReference<>(tAdWebFormsActivity);
            this.f29335b = new WeakReference<>(adsDTO);
            this.f29336c = new WeakReference<>(handler);
        }

        public /* synthetic */ b(TAdWebFormsActivity tAdWebFormsActivity, AdsDTO adsDTO, Handler handler, a aVar) {
            this(tAdWebFormsActivity, adsDTO, handler);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            TAdWebFormsActivity tAdWebFormsActivity = this.f29334a.get();
            AdsDTO adsDTO = this.f29335b.get();
            if (adsDTO == null || tAdWebFormsActivity == null) {
                return;
            }
            try {
                if (adsDTO.isOfflineAd()) {
                    tAdWebFormsActivity.f29325f = e1.f(tAdWebFormsActivity.f29324d, 1);
                }
                if (TextUtils.isEmpty(tAdWebFormsActivity.f29325f)) {
                    tAdWebFormsActivity.d();
                    return;
                }
                String strC = w9.f.c(tAdWebFormsActivity.f29325f);
                if (TextUtils.isEmpty(strC)) {
                    tAdWebFormsActivity.d();
                    return;
                }
                Handler handler = this.f29336c.get();
                if (handler == null) {
                    return;
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("load_runnable_data", strC);
                messageObtain.setData(bundle);
                handler.sendMessage(messageObtain);
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TAdWebFormsActivity> f29337a;

        public c(TAdWebFormsActivity tAdWebFormsActivity, Looper looper) {
            super(looper);
            this.f29337a = new WeakReference<>(tAdWebFormsActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            TAdWebFormsActivity tAdWebFormsActivity;
            if (message.what != 1 || (tAdWebFormsActivity = this.f29337a.get()) == null) {
                return;
            }
            try {
                WebView webView = tAdWebFormsActivity.f29327h;
                if (webView == null || message.getData() == null) {
                    tAdWebFormsActivity.d();
                } else {
                    webView.loadDataWithBaseURL(tAdWebFormsActivity.f29324d, message.getData().getString("load_runnable_data"), "text/html; charset=utf-8", "utf-8", null);
                }
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(e11));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TAdWebFormsActivity> f29338a;

        public d(TAdWebFormsActivity tAdWebFormsActivity) {
            this.f29338a = new WeakReference<>(tAdWebFormsActivity);
        }

        @JavascriptInterface
        public void close() {
            com.cloud.hisavana.sdk.z.a().d("ssp", "SspWebWindow-----> close");
            WeakReference<TAdWebFormsActivity> weakReference = this.f29338a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f29338a.get().d();
        }

        @JavascriptInterface
        public void submitForm(String str) {
            com.cloud.hisavana.sdk.z.a().d("ssp", "SspWebWindow-----> submitForm");
            TAdWebFormsActivity tAdWebFormsActivity = this.f29338a.get();
            if (tAdWebFormsActivity != null) {
                tAdWebFormsActivity.e(str);
            }
        }
    }

    public final int a(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void d() {
        if (m()) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }

    public void e(String str) {
        com.cloud.hisavana.sdk.z.a().d("ssp", "SspWebWindow-----> submitForm    " + str);
        try {
            FormBean formBean = (FormBean) GsonUtil.a(str, FormBean.class);
            formBean.setGaid(DeviceUtil.e());
            formBean.setFormId(this.f29326g);
            formBean.setIpAddress(DeviceUtil.h());
            if (NetStateManager.checkNetworkState()) {
                e1.H(GsonUtil.d(formBean), 0);
            } else {
                AthenaTracker.Q(this.f29322b, formBean);
            }
        } catch (GsonUtil.GsonParseException e11) {
            com.cloud.hisavana.sdk.z.a().d("ssp", "SspWebWindow-----> submitForm    " + e11.getMessage());
        }
    }

    public final void g() {
        if (this.f29327h == null) {
            d();
            return;
        }
        this.f29324d = getIntent().getStringExtra("ad_web_form_url");
        this.f29325f = getIntent().getStringExtra("ad_web_form_file_path");
        this.f29322b = (AdsDTO) getIntent().getParcelableExtra("ad_web_form_dto");
        this.f29323c = (DownUpPointBean) getIntent().getParcelableExtra("ad_web_form_point");
        if (TextUtils.isEmpty(this.f29324d)) {
            d();
            return;
        }
        AdsDTO adsDTO = this.f29322b;
        if (adsDTO != null && !adsDTO.isOfflineAd() && TextUtils.isEmpty(this.f29325f)) {
            d();
            return;
        }
        h();
        try {
            o();
        } catch (Exception e11) {
            com.cloud.hisavana.sdk.z.a().e(Log.getStackTraceString(e11));
        }
    }

    public final void h() {
        String strC = a0.c("height", this.f29324d);
        int iMin = LogSeverity.EMERGENCY_VALUE;
        try {
            this.f29326g = Integer.parseInt(a0.c("formId", this.f29324d));
            int i11 = Integer.parseInt(strC);
            iMin = Math.min(i11 == 0 ? LogSeverity.EMERGENCY_VALUE : a(i11), (com.cloud.sdk.commonutil.util.f.a().getResources().getDisplayMetrics().heightPixels * 4) / 5);
        } catch (NumberFormatException unused) {
        }
        try {
            FrameLayout frameLayout = this.f29328i;
            if (frameLayout == null || this.f29327h == null) {
                d();
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = (com.cloud.sdk.commonutil.util.f.a().getResources().getDisplayMetrics().widthPixels * 4) / 5;
            layoutParams.height = iMin;
            layoutParams.gravity = 17;
            this.f29328i.setLayoutParams(layoutParams);
            this.f29328i.removeAllViews();
            this.f29328i.addView(this.f29327h);
        } catch (Exception unused2) {
            d();
        }
    }

    public final void k() {
        try {
            WebView webView = new WebView(this);
            this.f29327h = webView;
            webView.setVisibility(0);
            this.f29327h.setBackgroundColor(0);
            WebSettings settings = this.f29327h.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setMixedContentMode(0);
            settings.setLoadsImagesAutomatically(true);
            settings.setSupportMultipleWindows(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setNeedInitialFocus(true);
            settings.setDisplayZoomControls(false);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            this.f29327h.addJavascriptInterface(new d(this), "sspWebView");
            this.f29327h.setWebViewClient(this.f29331l);
            this.f29327h.setWebChromeClient(this.f29332m);
            this.f29327h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().e("TAdWebFormsActivity", "create webview error: " + Log.getStackTraceString(th2));
            this.f29327h = null;
            d();
        }
    }

    public final boolean m() {
        return com.cloud.sdk.commonutil.util.m.a();
    }

    public final void o() {
        o1.g(this.f29323c, this.f29322b, Boolean.FALSE);
        com.cloud.sdk.commonutil.util.i.f30292a.e(new b(this, this.f29322b, this.f29330k, null));
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        setTitle((CharSequence) null);
        if (AdManager.f() == 1) {
            setRequestedOrientation(1);
        } else if (AdManager.f() == 0) {
            setRequestedOrientation(0);
        }
        super.onCreate(bundle);
        setTheme(com.cloud.sdk.commonutil.util.j.e() == 2 ? R$style.AppCompatTranscutes : R$style.TranslucentStyle);
        setContentView(R$layout.activity_t_ad_web_forms);
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        com.cloud.hisavana.sdk.z.a().d("TAdWebFormsActivity", "展示form表单页面");
        p();
        g();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout = this.f29328i;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        WebView webView = this.f29327h;
        if (webView != null) {
            webView.stopLoading();
            this.f29327h.removeJavascriptInterface("");
            this.f29327h.getSettings().setJavaScriptEnabled(false);
            this.f29327h.setWebChromeClient(null);
            this.f29327h.setWebViewClient(null);
            this.f29327h.clearHistory();
            try {
                this.f29327h.freeMemory();
                this.f29327h.destroy();
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().d("TAdWebFormsActivity", Log.getStackTraceString(e11));
            }
            this.f29327h = null;
        }
        this.f29330k.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        g();
    }

    public final void p() {
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
        this.f29328i = (FrameLayout) findViewById(R$id.fl_content);
        this.f29329j = System.currentTimeMillis();
        k();
    }
}
