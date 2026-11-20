package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.out.BaseTrackingListener;
import java.util.ArrayList;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements BrowserView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f45161a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f45162b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f45164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f45165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseTrackingListener f45166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BrowserView f45167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CampaignEx f45168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.click.a f45169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f45170j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private JumpLoaderResult f45172l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f45175o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45163c = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f45173m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Runnable f45174n = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.1
        @Override // java.lang.Runnable
        public final void run() {
            ad.b(a.f45161a, "webview js！超时上限：" + a.this.f45162b + "ms");
            if (a.this.f45169i != null && a.this.f45172l != null) {
                a.this.f45172l.setSuccess(false);
                a.this.f45172l.setUrl(a.this.f45164d);
                a.this.f45172l.setType(2);
                a.this.f45172l.setExceptionMsg("linktype 8 time out");
                a.this.f45169i.a(a.this.f45172l, a.this.f45168h, 1, false);
            }
            a aVar = a.this;
            if (aVar.d(null, aVar.f45164d) && !a.this.f45173m) {
                a.this.f45173m = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.f45170j, a.this.f45164d, a.this.f45168h);
            }
            if (a.this.f45166f != null) {
                a.this.f45166f.onFinishRedirection(a.this.f45168h, a.this.f45164d);
            }
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f45171k = new Handler(Looper.getMainLooper());

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.f45162b = 10000;
        this.f45172l = null;
        this.f45170j = context;
        this.f45168h = campaignEx;
        this.f45167g = browserView;
        this.f45166f = baseTrackingListener;
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
        }
        this.f45169i = aVar;
        this.f45172l = new JumpLoaderResult();
        this.f45162b = (int) gVarB.aq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context == null) {
            return;
        }
        if (campaignEx != null) {
            campaignEx.getCurrentLocalRid();
        }
        try {
            int i11 = MBCommonActivity.f42643d;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.f45184a.put(str, this.f45167g);
            if (ah.a.a(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            intent.putExtra("url", str);
            ad.c("url", "webview url = " + str);
            intent.setFlags(805306368);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            ah.a(context, str, this.f45166f, campaignEx, new ArrayList());
        }
    }

    private void c() {
        this.f45171k.removeCallbacks(this.f45174n);
    }

    private void d() {
        this.f45171k.postDelayed(this.f45174n, this.f45162b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri uri = Uri.parse(str);
            if (!uri.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) && !uri.getScheme().equals("https")) {
                if (uri.getScheme().equals("intent")) {
                    Intent uri2 = Intent.parseUri(str, 1);
                    try {
                        String str2 = uri2.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.f45170j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            return false;
                        }
                    } catch (Throwable th2) {
                        ad.b(f45161a, th2.getMessage());
                    }
                    try {
                        String stringExtra = uri2.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri uri3 = Uri.parse(str);
                            if (uri3.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) || uri3.getScheme().equals("https")) {
                                return true;
                            }
                            str = stringExtra;
                        }
                    } catch (Throwable th3) {
                        ad.b(f45161a, th3.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(this.f45170j, str)) {
                    ad.b(f45161a, "openDeepLink");
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            ad.b(f45161a, th4.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
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
                        if (!TextUtils.isEmpty(str2) && this.f45170j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            uri2.setFlags(ASTNode.DEOP);
                            this.f45170j.startActivity(uri2);
                            this.f45173m = true;
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
                            ad.b(f45161a, th2.getMessage());
                        }
                    } catch (Throwable th3) {
                        ad.b(f45161a, th3.getMessage());
                    }
                    ad.b(f45161a, th.getMessage());
                    return false;
                }
                if (com.mbridge.msdk.click.c.d(this.f45170j, str)) {
                    ad.b(f45161a, "openDeepLink");
                    this.f45173m = true;
                    return true;
                }
            }
            return false;
        } catch (Throwable th4) {
            ad.b(f45161a, th4.getMessage());
            return false;
        }
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a() {
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, int i11, final String str, final String str2) {
        ad.d(f45161a, str);
        c();
        com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.f45166f != null) {
                    a.this.f45166f.onFinishRedirection(a.this.f45168h, str2);
                }
                if (a.this.f45169i == null || a.this.f45172l == null) {
                    return;
                }
                a.this.f45172l.setSuccess(false);
                a.this.f45172l.setUrl(str2);
                a.this.f45172l.setType(2);
                a.this.f45172l.setExceptionMsg(str);
                a.this.f45169i.a(a.this.f45172l, a.this.f45168h, 1, true);
            }
        });
        if (!d(webView, str2) || this.f45173m) {
            return;
        }
        this.f45173m = true;
        a(this.f45170j, str2, this.f45168h);
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, String str) {
        if (this.f45175o == 0) {
            this.f45175o = System.currentTimeMillis();
            if (!this.f45165e) {
                this.f45165e = true;
                d();
            }
        }
        this.f45164d = str;
        this.f45163c = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.f45175o == 0) {
            this.f45175o = System.currentTimeMillis();
            if (!this.f45165e) {
                this.f45165e = true;
                d();
            }
            this.f45173m = false;
        }
        this.f45164d = str;
        this.f45163c = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final boolean b(WebView webView, final String str) {
        ad.b(f45161a, "shouldOverrideUrlLoading1  " + str);
        this.f45163c = false;
        if (ah.a.b(str) && ah.a.a(this.f45170j, str, null)) {
            this.f45173m = true;
        }
        boolean zE = e(webView, str);
        if (zE) {
            this.f45175o = 0L;
            this.f45163c = false;
            c();
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f45169i != null && a.this.f45172l != null) {
                        a.this.f45172l.setSuccess(true);
                        a.this.f45172l.setUrl(str);
                        a.this.f45172l.setType(2);
                        a.this.f45169i.a(a.this.f45172l, a.this.f45168h, 1, true);
                    }
                    if (a.this.f45166f != null) {
                        a.this.f45166f.onFinishRedirection(a.this.f45168h, str);
                    }
                }
            });
        }
        return zE;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void c(WebView webView, final String str) {
        ad.b(f45161a, "onPageFinished1  " + str);
        if (this.f45163c) {
            this.f45175o = 0L;
            this.f45163c = false;
            com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f45166f != null) {
                        a.this.f45166f.onFinishRedirection(a.this.f45168h, str);
                    }
                    if (a.this.f45169i == null || a.this.f45172l == null) {
                        return;
                    }
                    a.this.f45172l.setSuccess(true);
                    a.this.f45172l.setUrl(str);
                    a.this.f45172l.setType(2);
                    a.this.f45169i.a(a.this.f45172l, a.this.f45168h, 1, true);
                }
            });
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c();
            Uri uri = Uri.parse(str);
            if ((uri.getScheme().equals(HttpHost.DEFAULT_SCHEME_NAME) || uri.getScheme().equals("https")) && !this.f45173m) {
                this.f45173m = true;
                a(this.f45170j, str, this.f45168h);
            }
        }
    }
}
