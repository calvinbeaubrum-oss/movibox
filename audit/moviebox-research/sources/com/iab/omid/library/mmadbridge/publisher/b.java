package com.iab.omid.library.mmadbridge.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kn.d;
import kn.f;
import kn.g;
import nn.c;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WebView f42385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f42386g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, f> f42387h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f42388i;

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f42389a;

        public a() {
            this.f42389a = b.this.f42385f;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42389a.destroy();
        }
    }

    public b(Map<String, f> map, String str) {
        this.f42387h = map;
        this.f42388i = str;
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher
    public void k(g gVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, f> mapF = dVar.f();
        for (String str : mapF.keySet()) {
            c.i(jSONObject, str, mapF.get(str).f());
        }
        l(gVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher
    public void o() {
        super.o();
        new Handler().postDelayed(new a(), Math.max(4000 - (this.f42386g == null ? 4000L : TimeUnit.MILLISECONDS.convert(nn.f.b() - this.f42386g.longValue(), TimeUnit.NANOSECONDS)), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.f42385f = null;
    }

    @Override // com.iab.omid.library.mmadbridge.publisher.AdSessionStatePublisher
    public void w() {
        super.w();
        y();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void y() {
        WebView webView = new WebView(com.iab.omid.library.mmadbridge.internal.f.c().a());
        this.f42385f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f42385f.getSettings().setAllowContentAccess(false);
        c(this.f42385f);
        com.iab.omid.library.mmadbridge.internal.g.a().p(this.f42385f, this.f42388i);
        for (String str : this.f42387h.keySet()) {
            com.iab.omid.library.mmadbridge.internal.g.a().e(this.f42385f, this.f42387h.get(str).c().toExternalForm(), str);
        }
        this.f42386g = Long.valueOf(nn.f.b());
    }
}
