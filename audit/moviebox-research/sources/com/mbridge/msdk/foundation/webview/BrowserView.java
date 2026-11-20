package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BrowserView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CampaignEx f45122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f45124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebView f45125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ProgressBar f45126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ToolBar f45127f;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void a(WebView webView, int i11, String str, String str2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);

        boolean b(WebView webView, String str);

        void c(WebView webView, String str);
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BrowserView(Context context, CampaignEx campaignEx) {
        super(context);
        this.f45122a = campaignEx;
        init();
    }

    private WebView a() {
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable th2) {
                    ad.b("BrowserView", th2.getMessage());
                }
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
                try {
                    settings.setMixedContentMode(0);
                } catch (Exception e11) {
                    ad.b("BrowserView", e11.getMessage());
                }
                settings.setDatabaseEnabled(true);
                String path = getContext().getDir("database", 0).getPath();
                settings.setDatabasePath(path);
                settings.setGeolocationEnabled(true);
                settings.setGeolocationDatabasePath(path);
                try {
                    Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(settings, Boolean.FALSE);
                } catch (Exception e12) {
                    ad.b("BrowserView", e12.getMessage());
                }
            } else {
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
                settings.setMixedContentMode(0);
                settings.setDatabaseEnabled(true);
                String path2 = getContext().getDir("database", 0).getPath();
                settings.setDatabasePath(path2);
                settings.setGeolocationEnabled(true);
                settings.setGeolocationDatabasePath(path2);
                Method declaredMethod2 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(settings, Boolean.FALSE);
            }
        } catch (Throwable th3) {
            ad.b("BrowserView", th3.getMessage());
        }
        webView.setDownloadListener(new com.mbridge.msdk.foundation.same.g.a(this.f45122a));
        webView.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onLoadResource(WebView webView2, String str) {
                super.onLoadResource(webView2, str);
                ad.c("BrowserView", "onLoadResource 开始! = " + str);
                if (BrowserView.this.f45124c != null) {
                    BrowserView.this.f45124c.a(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str) {
                if (BrowserView.this.f45124c != null) {
                    BrowserView.this.f45124c.c(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                ad.c("BrowserView", "开始! = " + str);
                BrowserView.this.f45123b = str;
                if (BrowserView.this.f45124c != null) {
                    BrowserView.this.f45124c.a(webView2, str, bitmap);
                }
                BrowserView.this.f45126e.setVisible(true);
                BrowserView.this.f45126e.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i11, String str, String str2) {
                if (BrowserView.this.f45124c != null) {
                    BrowserView.this.f45124c.a(webView2, i11, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (webView2 != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView2.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView2);
                        }
                        webView2.destroy();
                    } catch (Throwable th4) {
                        ad.b("BrowserView", th4.getMessage());
                        return true;
                    }
                }
                if (BrowserView.this.f45124c != null) {
                    BrowserView.this.f45124c.a();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                ad.c("BrowserView", "js大跳! = " + str);
                BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
                if (BrowserView.this.f45124c != null) {
                    return BrowserView.this.f45124c.b(webView2, str);
                }
                return false;
            }
        });
        webView.setWebChromeClient(z.r() <= 10 ? new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i11) {
                if (i11 == 100) {
                    BrowserView.this.f45126e.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.f45126e.setVisible(false);
                        }
                    }, 200L);
                }
            }
        } : new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i11) {
                if (i11 == 100) {
                    BrowserView.this.f45126e.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.f45126e.setVisible(false);
                        }
                    }, 200L);
                }
            }
        });
        return webView;
    }

    public void destroy() {
        WebView webView = this.f45125d;
        if (webView != null) {
            webView.stopLoading();
            this.f45125d.setWebViewClient(null);
            this.f45125d.destroy();
            this.f45125d = null;
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f45126e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f45125d == null) {
                this.f45125d = a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f45125d.setLayoutParams(layoutParams);
        } catch (Throwable th2) {
            ad.a("BrowserView", "webview is error", th2);
        }
        this.f45127f = new ToolBar(getContext());
        this.f45127f.setLayoutParams(new LinearLayout.LayoutParams(-1, ai.a(getContext(), 40.0f)));
        this.f45127f.setBackgroundColor(-1);
        addView(this.f45126e);
        WebView webView = this.f45125d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f45127f);
        this.f45126e.initResource(true);
        this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(false);
        this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
        this.f45127f.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BrowserView.this.f45125d != null) {
                    BrowserView.this.f45125d.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z11 = false;
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD)) {
                    BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(true);
                    if (BrowserView.this.f45125d != null && BrowserView.this.f45125d.canGoBack()) {
                        BrowserView.this.f45125d.goBack();
                    }
                    View item = BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD);
                    if (BrowserView.this.f45125d != null && BrowserView.this.f45125d.canGoBack()) {
                        z11 = true;
                    }
                    item.setEnabled(z11);
                    return;
                }
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD)) {
                    BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                    if (BrowserView.this.f45125d != null && BrowserView.this.f45125d.canGoForward()) {
                        BrowserView.this.f45125d.goForward();
                    }
                    View item2 = BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                    if (BrowserView.this.f45125d != null && BrowserView.this.f45125d.canGoForward()) {
                        z11 = true;
                    }
                    item2.setEnabled(z11);
                    return;
                }
                if (!TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.REFRESH)) {
                    if (!TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.EXITS) || BrowserView.this.f45124c == null) {
                        return;
                    }
                    BrowserView.this.f45124c.a();
                    return;
                }
                BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(BrowserView.this.f45125d != null && BrowserView.this.f45125d.canGoBack());
                View item3 = BrowserView.this.f45127f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                if (BrowserView.this.f45125d != null && BrowserView.this.f45125d.canGoForward()) {
                    z11 = true;
                }
                item3.setEnabled(z11);
                if (BrowserView.this.f45125d != null) {
                    BrowserView.this.f45125d.loadUrl(BrowserView.this.f45123b);
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f45125d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(a aVar) {
        this.f45124c = aVar;
    }

    public void setWebView(WebView webView) {
        this.f45125d = webView;
    }
}
