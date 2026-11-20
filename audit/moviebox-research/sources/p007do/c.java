package p007do;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.util.a;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.google.common.base.f;
import com.google.common.base.p;
import com.polygamma.ogm.z;
import io.e;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends WebViewClient {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f63432g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f63433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f63434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f63435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f63436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WebView f63437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Runnable f63438f;

    public c(m mVar, Activity activity, a aVar, f fVar) {
        this.f63433a = mVar;
        this.f63434b = activity;
        this.f63435c = aVar;
        this.f63436d = fVar;
        WebView webView = new WebView(activity == null ? mVar.q() : activity);
        this.f63437e = webView;
        this.f63438f = e.b(this, new z(mVar.w(), webView));
    }

    public final /* synthetic */ void a() {
        this.f63435c.accept(this);
    }

    public final /* synthetic */ byte[] b(Uri uri) {
        return (byte[]) this.f63436d.apply(uri);
    }

    public final void c() {
        WebSettings settings = this.f63437e.getSettings();
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        settings.setDomStorageEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            settings.setSafeBrowsingEnabled(false);
        }
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        this.f63437e.setWillNotDraw(true);
        this.f63437e.setWebViewClient(this);
        this.f63437e.setWebChromeClient(new h0(this));
        if (i11 >= 29) {
            this.f63437e.setWebViewRenderProcessClient(new i0(this));
        }
        this.f63437e.loadUrl("about:blank");
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        webView.clearHistory();
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        webView.clearHistory();
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        webResourceRequest.getUrl();
        webResourceError.getDescription();
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        this.f63435c.accept(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        byte[] bytes;
        final Uri url = webResourceRequest.getUrl();
        if (!"GET".equalsIgnoreCase(webResourceRequest.getMethod()) || !"ogm-sdk-svc".equalsIgnoreCase(url.getHost())) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        try {
            if (p.e(url.getPath()).equalsIgnoreCase("/reset")) {
                this.f63433a.n().schedule(new Runnable() { // from class: do.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63427a.a();
                    }
                }, 50L, TimeUnit.MILLISECONDS);
                bytes = "OK".getBytes(StandardCharsets.UTF_8);
            } else {
                bytes = (byte[]) this.f63433a.n().submit(new Callable() { // from class: do.b
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f63429a.b(url);
                    }
                }).get(1L, TimeUnit.MINUTES);
            }
        } catch (Exception unused) {
            bytes = "ERROR".getBytes(StandardCharsets.UTF_8);
        }
        HashMap map = new HashMap();
        map.put(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        map.put(OSSHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, OPTIONS");
        map.put(OSSHeaders.ACCESS_CONTROL_MAX_AGE, "600");
        map.put(OSSHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Accept, Content-Type");
        int i11 = bytes == null ? 204 : 200;
        if (bytes == null) {
            bytes = new byte[0];
        }
        return new WebResourceResponse(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, "utf-8", i11, "OK", map, new ByteArrayInputStream(bytes));
    }
}
