package com.iab.omid.library.bytedance2.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.internal.g;
import com.iab.omid.library.bytedance2.internal.h;
import com.iab.omid.library.bytedance2.utils.c;
import com.iab.omid.library.bytedance2.utils.f;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f42288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f42289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f42290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f42291j;

    /* JADX INFO: compiled from: source.java */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (b.this.getWebView() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                b.this.a((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.iab.omid.library.bytedance2.publisher.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0468b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f42293a;

        public RunnableC0468b() {
            this.f42293a = b.this.f42288g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42293a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f42289h = null;
        this.f42290i = map;
        this.f42291j = str2;
    }

    @Override // com.iab.omid.library.bytedance2.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.bytedance2.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }

    @Override // com.iab.omid.library.bytedance2.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0468b(), Math.max(4000 - (this.f42289h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f42289h.longValue(), TimeUnit.NANOSECONDS)), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.f42288g = null;
    }

    @Override // com.iab.omid.library.bytedance2.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void j() {
        WebView webView = new WebView(g.b().a());
        this.f42288g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f42288g.getSettings().setAllowContentAccess(false);
        this.f42288g.getSettings().setAllowFileAccess(false);
        this.f42288g.setWebViewClient(new a());
        a(this.f42288g);
        h.a().c(this.f42288g, this.f42291j);
        for (String str : this.f42290i.keySet()) {
            h.a().c(this.f42288g, this.f42290i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f42289h = Long.valueOf(f.b());
    }
}
