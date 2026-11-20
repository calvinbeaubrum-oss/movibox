package com.mbridge.msdk.click;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f43168a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f43169d = "m";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f43170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f43171c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43173f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.c.g f43175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f43176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f43177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f43178k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private WebView f43179l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f43180m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f43181n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f43182o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f43184q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f43183p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Runnable f43185r = new Runnable() { // from class: com.mbridge.msdk.click.m.4
        @Override // java.lang.Runnable
        public final void run() {
            m.this.f43183p = true;
            m.this.f43182o = 1;
            m.m(m.this);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f43186s = new Runnable() { // from class: com.mbridge.msdk.click.m.5
        @Override // java.lang.Runnable
        public final void run() {
            m.this.f43183p = true;
            m.this.f43182o = 2;
            m.m(m.this);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f43174g = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(int i11, String str, String str2, String str3);

        void a(String str, boolean z11, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public m() {
        this.f43172e = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        this.f43173f = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        this.f43175h = gVarB;
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            this.f43175h = com.mbridge.msdk.c.i.a();
        }
        this.f43180m = this.f43175h.aI();
        this.f43172e = (int) this.f43175h.aq();
        this.f43173f = (int) this.f43175h.aq();
    }

    private void a(final Context context, final String str, final String str2) {
        WebView webView = new WebView(context);
        this.f43179l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f43179l.getSettings().setCacheMode(2);
        this.f43179l.getSettings().setLoadsImagesAutomatically(false);
        this.f43179l.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.click.m.2
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str3) {
                super.onPageFinished(webView2, str3);
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str3, Bitmap bitmap) {
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (m.this.f43184q) {
                        m.this.f43182o = 0;
                        m.c(m.this);
                        return;
                    }
                    m.this.f43171c = false;
                    if (webView2.getTag() == null) {
                        webView2.setTag("has_first_started");
                    } else {
                        m.this.f43170b = true;
                    }
                    synchronized (m.f43169d) {
                        try {
                            m.this.f43177j = str3;
                            if (m.this.f43176i == null || !m.this.f43176i.a(str3)) {
                                m.e(m.this);
                            } else {
                                m.this.f43184q = true;
                                m.c(m.this);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i11, String str3, String str4) {
                synchronized (m.f43169d) {
                    m.this.f43184q = true;
                    m.this.b();
                    m.c(m.this);
                }
                if (m.this.f43176i != null) {
                    m.this.f43176i.a(i11, webView2.getUrl(), str3, m.this.f43181n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    new com.mbridge.msdk.foundation.same.report.o(context).a(str, str2, webView2.getUrl());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                try {
                    synchronized (m.f43169d) {
                        m.this.f43184q = true;
                        m.this.b();
                        m.c(m.this);
                    }
                    if (m.this.f43176i != null) {
                        m.this.f43176i.a(-1, webView2.getUrl(), "WebView render process crash.", m.this.f43181n);
                    }
                    if (webView2 != null) {
                        webView2.destroy();
                    }
                    return true;
                } catch (Throwable th2) {
                    ad.b(m.f43169d, th2.getMessage());
                    return true;
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                synchronized (m.f43169d) {
                    try {
                        m mVar = m.this;
                        mVar.f43171c = true;
                        mVar.d();
                        if (m.this.f43184q) {
                            m.this.c();
                            m.c(m.this);
                            return true;
                        }
                        m.this.f43177j = str3;
                        if (m.this.f43176i != null && m.this.f43176i.b(str3)) {
                            m.this.f43184q = true;
                            m.this.c();
                            m.c(m.this);
                            return true;
                        }
                        if (m.this.f43180m) {
                            HashMap map = new HashMap();
                            if (m.this.f43179l.getUrl() != null) {
                                map.put("Referer", m.this.f43179l.getUrl());
                            }
                            m.this.f43179l.loadUrl(str3, map);
                        } else {
                            m.this.f43179l.loadUrl(str3);
                        }
                        return true;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        });
        this.f43179l.setWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.click.m.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str3, String str4, String str5, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i11) {
                if (i11 == 100) {
                    try {
                        webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!m.this.f43184q) {
                            m mVar = m.this;
                            if (!mVar.f43171c) {
                                m.l(mVar);
                            }
                        }
                        if (m.this.f43176i != null) {
                            m.this.f43176i.c(webView2.getUrl());
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    private void a(final String str, final String str2, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, context, this.f43177j);
        } else {
            this.f43174g.post(new Runnable() { // from class: com.mbridge.msdk.click.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    m mVar = m.this;
                    mVar.a(str, str2, context, mVar.f43177j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.f43178k)) {
                this.f43179l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f43173f = 2000;
                this.f43172e = 2000;
                ad.c(f43169d, this.f43178k);
                this.f43179l.loadDataWithBaseURL(str3, this.f43178k, "*/*", "utf-8", str3);
                return;
            }
            if (!this.f43180m) {
                this.f43179l.loadUrl(str3);
                return;
            }
            HashMap map = new HashMap();
            if (this.f43179l.getUrl() != null) {
                map.put("Referer", this.f43179l.getUrl());
            }
            this.f43179l.loadUrl(str3, map);
        } catch (Throwable th2) {
            try {
                a aVar = this.f43176i;
                if (aVar != null) {
                    aVar.a(0, this.f43177j, th2.getMessage(), this.f43181n);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f43174g.removeCallbacks(this.f43186s);
    }

    public static /* synthetic */ void c(m mVar) {
        synchronized (f43169d) {
            try {
                try {
                    try {
                        mVar.b();
                        a aVar = mVar.f43176i;
                        if (aVar != null) {
                            aVar.a(mVar.f43177j, mVar.f43183p, mVar.f43181n);
                        }
                    } catch (Throwable th2) {
                        ad.b(f43169d, th2.getMessage());
                    }
                } catch (Exception e11) {
                    ad.b(f43169d, e11.getMessage());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f43174g.removeCallbacks(this.f43185r);
    }

    public static /* synthetic */ void e(m mVar) {
        mVar.c();
        mVar.f43174g.postDelayed(mVar.f43186s, mVar.f43172e);
    }

    public static /* synthetic */ void l(m mVar) {
        mVar.d();
        mVar.f43174g.postDelayed(mVar.f43185r, mVar.f43173f);
    }

    public static /* synthetic */ void m(m mVar) {
        synchronized (f43169d) {
            try {
                try {
                    mVar.b();
                    mVar.f43179l.destroy();
                    a aVar = mVar.f43176i;
                    if (aVar != null) {
                        aVar.a(mVar.f43177j, mVar.f43183p, mVar.f43181n);
                    }
                } catch (Exception e11) {
                    ad.b(f43169d, e11.getMessage());
                } catch (Throwable th2) {
                    ad.b(f43169d, th2.getMessage());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void a(String str, String str2, Context context, String str3, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.f43177j = str3;
        this.f43176i = aVar;
        a(str, str2, context);
    }

    public final void a(String str, String str2, Context context, String str3, String str4, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.f43178k = str4;
        this.f43177j = str3;
        this.f43176i = aVar;
        a(str, str2, context);
    }
}
