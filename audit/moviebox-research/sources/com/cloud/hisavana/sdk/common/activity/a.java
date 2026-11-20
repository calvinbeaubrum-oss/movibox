package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.webview.ActionWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.hisavana.sdk.o1;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f29339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f29340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f29341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f29342d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f29343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f29344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WebView f29345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AdsDTO f29346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DownUpPointBean f29347j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f29349l;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public WebPageBean f29355r;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f29348k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f29350m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f29351n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f29352o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f29353p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f29354q = false;

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.activity.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0323a extends WebChromeClient {
        public C0323a() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i11) {
            ProgressBar progressBar = a.this.f29339a;
            if (progressBar == null) {
                return;
            }
            int i12 = 8;
            if (i11 == 100) {
                progressBar.setVisibility(i12);
            } else if (8 == progressBar.getVisibility()) {
                progressBar = a.this.f29339a;
                i12 = 0;
                progressBar.setVisibility(i12);
            }
            a aVar = a.this;
            if (aVar.f29355r == null || aVar.f29354q) {
                return;
            }
            if (a.this.f29351n || i11 != 100) {
                if (a.this.f29353p || a.this.f29351n || i11 < 50 || i11 >= 100) {
                    return;
                }
                a.this.f29355r.setSpendEndTime(System.currentTimeMillis());
                a.this.f29353p = true;
                AthenaTracker.p0(a.this.f29355r.getWebId(), a.this.f29355r.getUrl(), a.this.f29355r.getTargetUrl(), 50, a.this.f29355r.getRedirectType(), a.this.f29355r.getSpendTime());
                return;
            }
            a.this.f29355r.setSpendEndTime(System.currentTimeMillis());
            a.this.f29351n = true;
            AthenaTracker.p0(a.this.f29355r.getWebId(), a.this.f29355r.getUrl(), a.this.f29355r.getTargetUrl(), 100, a.this.f29355r.getRedirectType(), a.this.f29355r.getSpendTime());
            String webId = a.this.f29355r.getWebId();
            String url = a.this.f29355r.getUrl();
            String targetUrl = a.this.f29355r.getTargetUrl();
            int redirectType = a.this.f29355r.getRedirectType();
            a aVar2 = a.this;
            boolean z11 = aVar2.f29350m;
            String str = z11 ? "fail" : "success";
            String errorType = z11 ? aVar2.f29355r.getErrorType() : "succeed";
            a aVar3 = a.this;
            AthenaTracker.o0(webId, url, targetUrl, redirectType, str, errorType, aVar3.f29350m ? aVar3.f29355r.getErrorCode() : 8000, -1L);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            com.cloud.hisavana.sdk.z.a().d("TBaseLandingActivity", "onReceivedTitle " + str);
            if (str == null || str.isEmpty() || webView.getUrl() == null || webView.getUrl().contains(str) || a.this.f29344g == null || TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f29344g.setText(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.onBackPressed();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.isFinishing() || a.this.isDestroyed()) {
                return;
            }
            a.this.finish();
            com.cloud.hisavana.sdk.z.a().e("TBaseLandingActivity", "goToNext ,post finish");
        }
    }

    public String a(DownUpPointBean downUpPointBean, AdsDTO adsDTO) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getClickUrl())) {
            com.cloud.hisavana.sdk.z.a().d("TBaseLandingActivity", "processServerClickUrl --> null == url || null == pointBean");
            return "";
        }
        if (downUpPointBean == null || adsDTO.getDspType().intValue() == 2 || adsDTO.getSource() == 4) {
            return adsDTO.getClickUrl();
        }
        String strC = o1.c(downUpPointBean, adsDTO, true, Boolean.FALSE);
        if (TextUtils.isEmpty(strC)) {
            return "";
        }
        if (!strC.contains("?")) {
            return strC;
        }
        return strC + o1.d(adsDTO);
    }

    public final void b() {
        new Handler(getMainLooper()).postDelayed(new c(), 1000L);
    }

    public final void c(int i11) {
        WebPageBean webPageBean;
        if (this.f29352o || (webPageBean = this.f29355r) == null) {
            return;
        }
        webPageBean.setRedirectType(i11);
        AthenaTracker.p0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), 0, i11, this.f29355r.getLoadTime());
    }

    public boolean f(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("http://") && !str.startsWith(AgentPageJsBridge.HTTPS)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(ASTNode.DEOP);
                startActivity(intent);
                com.cloud.hisavana.sdk.z.a().d("TBaseLandingActivity", "open deeplink");
                return true;
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e("TBaseLandingActivity", "checkDeepLink finish," + Log.getStackTraceString(e11));
                finish();
            }
        }
        return false;
    }

    public WebViewClient g() {
        return new x9.b();
    }

    public boolean j(String str) {
        if (str == null) {
            return false;
        }
        if (str.contains("play.google.com/store/apps/")) {
            q(str.replaceAll("https://play.google.com/store/apps/", "market://").replaceAll("http://play.google.com/store/apps/", "market://"));
            return true;
        }
        if (!str.startsWith("market://")) {
            return false;
        }
        q(str);
        return true;
    }

    public WebPageBean k() {
        return this.f29355r;
    }

    public boolean m(String str) {
        WebPageBean webPageBean;
        com.cloud.hisavana.sdk.z.a().d("TBaseLandingActivity", "webview get redirect url is:" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!this.f29352o && (webPageBean = this.f29355r) != null) {
            webPageBean.setTargetUrl(str);
            this.f29355r.setLoadStartTime(System.currentTimeMillis());
        }
        if (str.startsWith("intent://")) {
            c(2);
            if (!e1.K(this, str)) {
                o(str);
            } else if (!isFinishing() && !isDestroyed()) {
                finish();
            }
            return true;
        }
        if ((str.contains("play.google.com") || str.startsWith("market://")) && e1.A(this, str, "com.android.vending")) {
            AthenaTracker.r0(this.f29346i);
            p(str);
            c(1);
            if (!isFinishing() && !isDestroyed()) {
                finish();
            }
            return true;
        }
        if (e1.z(this, str)) {
            c(2);
            b();
            return true;
        }
        if (!str.startsWith(AgentPageJsBridge.HTTPS) && !str.startsWith("http://")) {
            return true;
        }
        this.f29355r.setRedirectType(0);
        AthenaTracker.r0(this.f29346i);
        p(str);
        return false;
    }

    public final void n() {
        if (getIntent() == null) {
            com.cloud.hisavana.sdk.z.a().e("TBaseLandingActivity", "initWebView intent is null");
            finish();
            return;
        }
        Parcelable parcelableExtra = getIntent().getParcelableExtra("tag_ad_bean");
        AdsDTO adsDTO = parcelableExtra instanceof AdsDTO ? (AdsDTO) parcelableExtra : null;
        this.f29346i = adsDTO;
        if (adsDTO == null) {
            com.cloud.hisavana.sdk.z.a().e("TBaseLandingActivity", "initWebView,adsDto is null");
            finish();
            return;
        }
        WebPageBean webPageBean = this.f29355r;
        if (webPageBean != null) {
            webPageBean.setPageClickTime(this.f29349l);
        }
        try {
            this.f29345h = new ActionWebView(this);
            ((FrameLayout) findViewById(R$id.fl_webview)).addView(this.f29345h);
            WebView webView = this.f29345h;
            if (webView != null) {
                webView.getSettings().setJavaScriptEnabled(true);
                this.f29345h.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                this.f29345h.getSettings().setSupportZoom(true);
                this.f29345h.getSettings().setUseWideViewPort(true);
                this.f29345h.getSettings().setLoadWithOverviewMode(true);
                this.f29345h.getSettings().setDisplayZoomControls(true);
                this.f29345h.getSettings().setCacheMode(-1);
                this.f29345h.getSettings().setDomStorageEnabled(true);
                this.f29345h.setWebChromeClient(new C0323a());
                this.f29345h.setWebViewClient(g());
            }
            if (AdManager.h()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            WebPageBean webPageBean2 = this.f29355r;
            if (webPageBean2 != null) {
                webPageBean2.setInitEndTime(System.currentTimeMillis());
                AthenaTracker.p0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), -1, -1, this.f29355r.getInitTime());
            }
            this.f29347j = (DownUpPointBean) getIntent().getParcelableExtra("pointBean");
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().e("TBaseLandingActivity", "create webview error: " + Log.getStackTraceString(th2));
            this.f29345h = null;
            finish();
        }
    }

    public final void o(String str) {
        try {
            String stringExtra = Intent.parseUri(str, 1).getStringExtra("browser_fallback_url");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (e1.z(this, stringExtra)) {
                finish();
            } else if (stringExtra.startsWith(AgentPageJsBridge.HTTPS) || stringExtra.startsWith("http://")) {
                p(stringExtra);
                this.f29345h.loadUrl(stringExtra);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WebPageBean webPageBean;
        WebView webView;
        if (this.f29348k && (webView = this.f29345h) != null && webView.canGoBack()) {
            this.f29345h.goBack();
            return;
        }
        if (!this.f29351n && (webPageBean = this.f29355r) != null) {
            this.f29354q = true;
            webPageBean.setJumpTime(System.currentTimeMillis());
            AthenaTracker.o0(this.f29355r.getWebId(), this.f29355r.getUrl(), this.f29355r.getTargetUrl(), -1, "fail", "jump", 9000, this.f29355r.getWaitTime());
        }
        try {
            super.onBackPressed();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (AdManager.f() == 1) {
            setRequestedOrientation(1);
        } else if (AdManager.f() == 0) {
            setRequestedOrientation(0);
        }
        super.onCreate(bundle);
        this.f29349l = System.currentTimeMillis();
        setContentView(R$layout.tad_exposure_activity);
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        this.f29355r = new WebPageBean();
        this.f29339a = (ProgressBar) findViewById(R$id.pb_progress);
        this.f29340b = (LinearLayout) findViewById(R$id.main_content);
        this.f29341c = (FrameLayout) findViewById(R$id.layout_title);
        this.f29342d = (FrameLayout) findViewById(R$id.layout_content);
        FrameLayout frameLayout = this.f29341c;
        if (frameLayout != null) {
            this.f29343f = (ImageView) frameLayout.findViewById(R$id.im_back);
            this.f29344g = (TextView) this.f29341c.findViewById(R$id.tv_title);
        }
        n();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            WebView webView = this.f29345h;
            if (webView != null) {
                ViewParent parent = webView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f29345h);
                }
                this.f29345h.stopLoading();
                this.f29345h.getSettings().setJavaScriptEnabled(false);
                this.f29345h.setWebChromeClient(null);
                this.f29345h.clearHistory();
                this.f29345h.removeAllViews();
                this.f29345h.destroy();
            }
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().d("TBaseLandingActivity", Log.getStackTraceString(th2));
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        WebView webView;
        if (i11 != 4 || (webView = this.f29345h) == null || !webView.canGoBack()) {
            return super.onKeyDown(i11, keyEvent);
        }
        this.f29345h.goBack();
        return true;
    }

    public void p(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (this.f29341c != null) {
            if (str.contains("isNativeHeader=false")) {
                this.f29341c.setVisibility(8);
            } else {
                this.f29341c.setVisibility(0);
            }
        }
        if (str.contains("isBackPage=false")) {
            this.f29348k = false;
        }
        if (this.f29339a != null) {
            if (str.contains("isNativeLoading=false")) {
                this.f29339a.setVisibility(8);
            } else {
                this.f29339a.setVisibility(0);
            }
        }
        ImageView imageView = this.f29343f;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
    }

    public final void q(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setPackage("com.android.vending");
            intent.setFlags(ASTNode.DEOP);
            com.cloud.sdk.commonutil.util.f.a().startActivity(intent);
            finish();
            com.cloud.hisavana.sdk.z.a().d("TBaseLandingActivity", "open gp link " + str);
        } catch (Throwable th2) {
            com.cloud.hisavana.sdk.z.a().e("TBaseLandingActivity", "startGp " + Log.getStackTraceString(th2));
            finish();
        }
    }
}
