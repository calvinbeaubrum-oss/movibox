package com.applovin.impl;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AppLovinAdBase f21156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f21157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f21158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f21159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f21160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected AdSession f21161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected AdEvents f21162g;

    public mg(AppLovinAdBase appLovinAdBase) {
        this.f21156a = appLovinAdBase;
        this.f21157b = appLovinAdBase.getSdk();
        this.f21158c = appLovinAdBase.getSdk().J();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        if (StringUtils.isValidString(appLovinAdBase.getDspName())) {
            str = str + ":" + appLovinAdBase.getDspName();
        }
        this.f21159d = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, List list) {
        this.f21161f.registerAdView(view);
        this.f21161f.removeAllFriendlyObstructions();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            og ogVar = (og) it.next();
            if (ogVar.c() != null) {
                try {
                    this.f21161f.addFriendlyObstruction(ogVar.c(), ogVar.b(), ogVar.a());
                } catch (Throwable th2) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f21158c.a(this.f21159d, "Failed to add friendly obstruction (" + ogVar + ")", th2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        this.f21161f.error(ErrorType.VIDEO, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        try {
            if (this.f21160e) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21158c.a(this.f21159d, "Running operation: " + str);
                }
                runnable.run();
            }
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.a(this.f21159d, "Failed to run operation: " + str, th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f21160e = false;
        this.f21161f.finish();
        this.f21161f = null;
        this.f21162g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        AdSessionContext adSessionContextA;
        if (!this.f21156a.isOpenMeasurementEnabled()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.d(this.f21159d, "Skip starting session - Open Measurement disabled");
                return;
            }
            return;
        }
        if (this.f21161f != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.k(this.f21159d, "Attempting to start session again for ad: " + this.f21156a);
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f21158c.a(this.f21159d, "Starting session");
        }
        AdSessionConfiguration adSessionConfigurationA = a();
        if (adSessionConfigurationA == null || (adSessionContextA = a(webView)) == null) {
            return;
        }
        try {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationA, adSessionContextA);
            this.f21161f = adSessionCreateAdSession;
            try {
                this.f21162g = AdEvents.createAdEvents(adSessionCreateAdSession);
                a(this.f21161f);
                this.f21161f.start();
                this.f21160e = true;
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21158c.a(this.f21159d, "Session started");
                }
            } catch (Throwable th2) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21158c.a(this.f21159d, "Failed to create ad events", th2);
                }
            }
        } catch (Throwable th3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21158c.a(this.f21159d, "Failed to create session", th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f21162g.impressionOccurred();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f21162g.loaded();
    }

    public abstract AdSessionConfiguration a();

    public abstract AdSessionContext a(WebView webView);

    public void a(View view) {
        b(view, Collections.emptyList());
    }

    public void a(AdSession adSession) {
    }

    public void b(final View view, final List list) {
        b("update main view: " + view, new Runnable() { // from class: com.applovin.impl.b00
            @Override // java.lang.Runnable
            public final void run() {
                this.f17810a.a(view, list);
            }
        });
    }

    public void b(final String str) {
        b("track error", new Runnable() { // from class: com.applovin.impl.zz
            @Override // java.lang.Runnable
            public final void run() {
                this.f24932a.a(str);
            }
        });
    }

    public void b(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.a00
            @Override // java.lang.Runnable
            public final void run() {
                this.f17413a.a(str, runnable);
            }
        });
    }

    public void c(final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.d00
            @Override // java.lang.Runnable
            public final void run() {
                this.f18333a.b(webView);
            }
        });
    }

    public void e() {
        c((WebView) null);
    }

    public void f() {
        b("stop session", new Runnable() { // from class: com.applovin.impl.yz
            @Override // java.lang.Runnable
            public final void run() {
                this.f24729a.b();
            }
        });
    }

    public void g() {
        b("track impression event", new Runnable() { // from class: com.applovin.impl.c00
            @Override // java.lang.Runnable
            public final void run() {
                this.f18073a.c();
            }
        });
    }

    public void h() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.e00
            @Override // java.lang.Runnable
            public final void run() {
                this.f18518a.d();
            }
        });
    }
}
