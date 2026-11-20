package com.iab.omid.library.vungle.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import sn.c;
import sn.e;
import sn.f;
import un.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WebView f42452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f42453e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, e> f42454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f42455g;

    public b(Map<String, e> map, String str) {
        this.f42454f = map;
        this.f42455g = str;
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void a() {
        super.a();
        p();
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void f(f fVar, c cVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, e> mapE = cVar.e();
        for (String str : mapE.keySet()) {
            un.b.g(jSONObject, str, mapE.get(str));
        }
        g(fVar, cVar, jSONObject);
    }

    @Override // com.iab.omid.library.vungle.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        new Handler().postDelayed(new Runnable() { // from class: com.iab.omid.library.vungle.publisher.b.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final WebView f42457b;

            {
                this.f42457b = b.this.f42452d;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f42457b.destroy();
            }
        }, Math.max(4000 - (this.f42453e == null ? 4000L : TimeUnit.MILLISECONDS.convert(d.a() - this.f42453e.longValue(), TimeUnit.NANOSECONDS)), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.f42452d = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void p() {
        WebView webView = new WebView(com.iab.omid.library.vungle.b.d.a().c());
        this.f42452d = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        c(this.f42452d);
        com.iab.omid.library.vungle.b.e.a().j(this.f42452d, this.f42455g);
        for (String str : this.f42454f.keySet()) {
            com.iab.omid.library.vungle.b.e.a().d(this.f42452d, this.f42454f.get(str).a().toExternalForm(), str);
        }
        this.f42453e = Long.valueOf(d.a());
    }
}
