package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ar;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class DomainMBCommonActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f42634a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BrowserView.a f42635b = new BrowserView.a() { // from class: com.mbridge.msdk.activity.DomainMBCommonActivity.1
        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, int i11, String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str, Bitmap bitmap) {
            ad.b("MBCommonActivity", "onPageStarted  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final boolean b(WebView webView, String str) {
            ad.b("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (ah.a.b(str) && ah.a.a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void c(WebView webView, String str) {
            ad.b("MBCommonActivity", "onPageFinished  " + str);
        }
    };
    protected BrowserView browserView;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CampaignEx f42636c;

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
                        if (!TextUtils.isEmpty(str2) && getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            uri2.setFlags(ASTNode.DEOP);
                            startActivityForResult(uri2, 0);
                            finish();
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
                            ad.b("MBCommonActivity", th2.getMessage());
                        }
                    } catch (Throwable th3) {
                        ad.b("MBCommonActivity", th3.getMessage());
                    }
                    ad.b("MBCommonActivity", th.getMessage());
                    return false;
                }
                if (c.d(this, str)) {
                    ad.b("MBCommonActivity", "openDeepLink");
                    finish();
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    return !(str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str.startsWith("https"));
                }
            }
            return false;
        } catch (Throwable th4) {
            ad.b("MBCommonActivity", th4.getMessage());
            return false;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th2) {
            ad.b("MBCommonActivity", th2.getMessage());
        }
        if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            com.mbridge.msdk.foundation.controller.c.m().b(getApplicationContext());
        }
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        String stringExtra = getIntent().getStringExtra("url");
        this.f42634a = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f42636c = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
        if (b.f45184a.containsKey(this.f42634a)) {
            BrowserView browserView = b.f45184a.get(this.f42634a);
            this.browserView = browserView;
            if (browserView != null) {
                browserView.setListener(this.f42635b);
            }
        } else {
            BrowserView browserView2 = new BrowserView(this, this.f42636c);
            this.browserView = browserView2;
            browserView2.setListener(this.f42635b);
            this.browserView.loadUrl(this.f42634a);
        }
        BrowserView browserView3 = this.browserView;
        if (browserView3 != null) {
            ar.a(browserView3);
            setContentView(this.browserView);
        }
    }
}
