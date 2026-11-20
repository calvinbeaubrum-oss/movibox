package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import java.util.ArrayList;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ToolBar f45690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ToolBar f45691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ProgressBar f45692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected BaseWebView f45693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f45694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f45695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RelativeLayout f45696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View.OnClickListener f45697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.commonwebview.b f45698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.commonwebview.a f45699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View.OnClickListener f45700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View.OnClickListener f45701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View.OnClickListener f45702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View.OnClickListener f45703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Handler f45704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f45705p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private WebViewClient f45706q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f45707r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b f45708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f45709t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Runnable f45710u;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(String str);
    }

    public CommonWebView(Context context) {
        super(context);
        this.f45710u = new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.1
            @Override // java.lang.Runnable
            public final void run() {
                ad.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f45705p + "ms");
                if (CommonWebView.this.f45708s != null) {
                    CommonWebView.this.f45709t = false;
                    CommonWebView.this.f45708s.a(CommonWebView.this.f45707r);
                }
            }
        };
        init();
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45710u = new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.1
            @Override // java.lang.Runnable
            public final void run() {
                ad.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f45705p + "ms");
                if (CommonWebView.this.f45708s != null) {
                    CommonWebView.this.f45709t = false;
                    CommonWebView.this.f45708s.a(CommonWebView.this.f45707r);
                }
            }
        };
        init();
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f45710u = new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.1
            @Override // java.lang.Runnable
            public final void run() {
                ad.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f45705p + "ms");
                if (CommonWebView.this.f45708s != null) {
                    CommonWebView.this.f45709t = false;
                    CommonWebView.this.f45708s.a(CommonWebView.this.f45707r);
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f45704o.postDelayed(this.f45710u, this.f45705p);
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z11) {
        if (this.f45690a != null) {
            return;
        }
        ToolBar.a aVar = new ToolBar.a();
        aVar.f45721a = 40;
        ToolBar.a.f45719b = 80;
        ToolBar toolBar = new ToolBar(getContext(), aVar, arrayList);
        this.f45690a = toolBar;
        toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
        if (!z11) {
            this.f45690a.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f45694e));
            addView(this.f45690a, 0);
        } else {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45694e);
            layoutParams.addRule(10);
            this.f45690a.setLayoutParams(layoutParams);
            this.f45696g.addView(this.f45690a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri uri = Uri.parse(str);
            if (!uri.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) && !uri.getScheme().equals("https")) {
                if (uri.getScheme().equals("intent")) {
                    Intent uri2 = Intent.parseUri(str, 1);
                    try {
                        String str2 = uri2.getPackage();
                        if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            uri2.setFlags(ASTNode.DEOP);
                            getContext().startActivity(uri2);
                            return true;
                        }
                        try {
                            String stringExtra = uri2.getStringExtra("browser_fallback_url");
                            if (!TextUtils.isEmpty(stringExtra)) {
                                Uri uri3 = Uri.parse(str);
                                if (!uri3.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) && !uri3.getScheme().equals("https")) {
                                    str = stringExtra;
                                }
                                webView.loadUrl(stringExtra);
                                return false;
                            }
                        } catch (Throwable th2) {
                            ad.b("CommonWebView", th2.getMessage());
                        }
                    } catch (Throwable th3) {
                        ad.b("CommonWebView", th3.getMessage());
                    }
                    ad.b("CommonWebView", th.getMessage());
                    return false;
                }
                if (c.d(getContext(), str)) {
                    ad.b("CommonWebView", "openDeepLink");
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    return !(str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https"));
                }
            }
            return false;
        } catch (Throwable th4) {
            ad.b("CommonWebView", th4.getMessage());
            return false;
        }
    }

    public static /* synthetic */ void k(CommonWebView commonWebView) {
        commonWebView.f45704o.removeCallbacks(commonWebView.f45710u);
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.f45699j.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.f45698i.a(webViewClient);
    }

    public View findToolBarButton(String str) {
        ToolBar toolBar;
        ToolBar toolBar2 = this.f45690a;
        View item = toolBar2 != null ? toolBar2.getItem(str) : null;
        return (item != null || (toolBar = this.f45691b) == null) ? item : toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.f45693d;
        return baseWebView == null ? "" : baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.f45693d;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.f45690a;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.f45691b;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View viewFindToolBarButton = findToolBarButton(str);
        if (viewFindToolBarButton != null) {
            viewFindToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.f45690a.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.f45696g = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.f45696g, layoutParams);
        this.f45694e = ai.a(getContext(), 40.0f);
        this.f45695f = ai.a(getContext(), 40.0f);
        this.f45698i = new com.mbridge.msdk.mbsignalcommon.commonwebview.b();
        this.f45699j = new com.mbridge.msdk.mbsignalcommon.commonwebview.a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.f45693d == null) {
                this.f45693d = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.f45693d.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.f45693d;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.f45698i);
            this.f45693d.setWebChromeClient(this.f45699j);
            addWebViewClient(bVar);
        } catch (Throwable th2) {
            ad.a("CommonWebView", "webview is error", th2);
        }
        this.f45696g.addView(this.f45693d);
    }

    public void loadUrl(String str) {
        this.f45693d.loadUrl(str);
        if (this.f45706q != null) {
            a();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.f45700k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.f45701l = onClickListener;
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.f45703n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.f45702m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.f45699j.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.f45698i.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.f45690a.getParent()).removeView(this.f45690a);
        this.f45696g.addView(this.f45690a);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.f45690a.getParent()).removeView(this.f45690a);
        addView(this.f45690a, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.f45697h = onClickListener;
    }

    public void setPageLoadTimtout(int i11) {
        this.f45705p = i11;
        if (this.f45704o == null) {
            this.f45704o = new Handler(Looper.getMainLooper());
        }
        if (this.f45706q == null) {
            WebViewClient webViewClient = new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.7
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                    CommonWebView.this.f45709t = false;
                    CommonWebView.k(CommonWebView.this);
                }

                @Override // android.webkit.WebViewClient
                public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    CommonWebView.this.f45707r = str;
                    if (CommonWebView.this.f45709t) {
                        return;
                    }
                    CommonWebView.this.f45709t = true;
                    CommonWebView.this.a();
                }

                @Override // android.webkit.WebViewClient
                public final void onReceivedError(WebView webView, int i12, String str, String str2) {
                    CommonWebView.this.f45709t = false;
                    CommonWebView.k(CommonWebView.this);
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    CommonWebView.this.f45707r = str;
                    if (CommonWebView.this.f45709t) {
                        CommonWebView.k(CommonWebView.this);
                    }
                    CommonWebView.this.f45709t = true;
                    CommonWebView.this.a();
                    return false;
                }
            };
            this.f45706q = webViewClient;
            addWebViewClient(webViewClient);
        }
    }

    public void setPageLoadTimtoutListener(b bVar) {
        this.f45708s = bVar;
    }

    public void setToolBarTitle(String str) {
        this.f45690a.setTitle(str);
    }

    public void setToolBarTitle(String str, int i11) {
        this.f45690a.setTitle(str, i11);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.f45690a;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.f45691b;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View viewFindToolBarButton = findToolBarButton(str);
        if (viewFindToolBarButton != null) {
            viewFindToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.f45690a.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z11) {
        a(arrayList, z11);
    }

    public void useDeeplink() {
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.6
            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (ah.a.b(str)) {
                    ah.a.a(CommonWebView.this.getContext(), str, null);
                }
                return CommonWebView.this.a(webView, str);
            }
        });
    }

    public void useDefaultToolBar() {
        if (this.f45691b != null) {
            return;
        }
        this.f45691b = new ToolBar(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f45695f);
        layoutParams.bottomMargin = 0;
        this.f45691b.setLayoutParams(layoutParams);
        this.f45691b.setBackgroundColor(-1);
        this.f45691b.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseWebView baseWebView = CommonWebView.this.f45693d;
                if (baseWebView != null) {
                    baseWebView.stopLoading();
                    String str = (String) view.getTag();
                    if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                        CommonWebView.this.f45691b.getItem(ToolBar.FORWARD).setEnabled(true);
                        if (CommonWebView.this.f45693d.canGoBack()) {
                            CommonWebView.this.f45693d.goBack();
                        }
                        CommonWebView.this.f45691b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f45693d.canGoBack());
                        if (CommonWebView.this.f45700k != null) {
                            CommonWebView.this.f45700k.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(str, ToolBar.FORWARD)) {
                        CommonWebView.this.f45691b.getItem(ToolBar.BACKWARD).setEnabled(true);
                        if (CommonWebView.this.f45693d.canGoForward()) {
                            CommonWebView.this.f45693d.goForward();
                        }
                        CommonWebView.this.f45691b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f45693d.canGoForward());
                        if (CommonWebView.this.f45701l != null) {
                            CommonWebView.this.f45701l.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(str, ToolBar.REFRESH)) {
                        CommonWebView.this.f45691b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f45693d.canGoBack());
                        CommonWebView.this.f45691b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f45693d.canGoForward());
                        CommonWebView.this.f45693d.reload();
                        if (CommonWebView.this.f45702m != null) {
                            CommonWebView.this.f45702m.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(str, ToolBar.EXITS)) {
                        if (CommonWebView.this.f45697h != null) {
                            CommonWebView.this.f45697h.onClick(view);
                        }
                    } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                        if (CommonWebView.this.f45703n != null) {
                            CommonWebView.this.f45703n.onClick(view);
                        }
                        c.c(CommonWebView.this.getContext(), CommonWebView.this.f45693d.getUrl());
                    }
                }
            }
        });
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.5
            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                CommonWebView.this.f45691b.getItem(ToolBar.BACKWARD).setEnabled(true);
                CommonWebView.this.f45691b.getItem(ToolBar.FORWARD).setEnabled(false);
                return false;
            }
        });
        addView(this.f45691b);
    }

    public void useProgressBar() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f45692c = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                ad.c("CommonWebView", "newProgress! 开始! = " + str);
                CommonWebView.this.f45692c.setVisible(true);
                CommonWebView.this.f45692c.setProgressState(5);
            }
        });
        addWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.3
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i11) {
                ad.c("CommonWebView", "newProgress! = " + i11);
                if (i11 == 100) {
                    CommonWebView.this.f45692c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommonWebView.this.f45692c.setVisible(false);
                        }
                    }, 200L);
                }
            }
        });
        addView(this.f45692c);
        this.f45692c.initResource(true);
    }
}
