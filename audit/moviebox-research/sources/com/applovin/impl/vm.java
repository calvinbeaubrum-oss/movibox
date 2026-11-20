package com.applovin.impl;

import android.net.Uri;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class vm extends yl implements ze.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f23918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AppLovinAdLoadListener f23919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.applovin.impl.adview.b f23920j;

    /* JADX INFO: compiled from: source.java */
    public class b extends com.applovin.impl.adview.c {
        private b(com.applovin.impl.sdk.j jVar) {
            super(null, jVar);
        }

        private boolean a(String str, sj sjVar) {
            Iterator it = vm.this.f24689a.c(sjVar).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.applovin.impl.adview.c
        public boolean a(WebView webView, String str) {
            com.applovin.impl.sdk.n nVar = vm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                vm vmVar = vm.this;
                vmVar.f24691c.d(vmVar.f24690b, "Processing click on ad URL \"" + str + "\"");
            }
            if (str == null || !(webView instanceof com.applovin.impl.adview.b)) {
                return true;
            }
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (!a(scheme, sj.Z1)) {
                return true;
            }
            if (a(host, sj.f22913a2)) {
                com.applovin.impl.sdk.n nVar2 = vm.this.f24691c;
                if (com.applovin.impl.sdk.n.a()) {
                    vm vmVar2 = vm.this;
                    vmVar2.f24691c.a(vmVar2.f24690b, "Ad load succeeded");
                }
                if (vm.this.f23919i == null) {
                    return true;
                }
                vm.this.f23919i.adReceived(vm.this.f23918h);
                vm.this.f23919i = null;
                return true;
            }
            if (!a(host, sj.f22920b2)) {
                com.applovin.impl.sdk.n nVar3 = vm.this.f24691c;
                if (!com.applovin.impl.sdk.n.a()) {
                    return true;
                }
                vm vmVar3 = vm.this;
                vmVar3.f24691c.b(vmVar3.f24690b, "Unrecognized webview event");
                return true;
            }
            com.applovin.impl.sdk.n nVar4 = vm.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                vm vmVar4 = vm.this;
                vmVar4.f24691c.a(vmVar4.f24690b, "Ad load failed");
            }
            if (vm.this.f23919i == null) {
                return true;
            }
            vm.this.f23919i.failedToReceiveAd(204);
            vm.this.f23919i = null;
            return true;
        }
    }

    public vm(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessJavaScriptTagAd", jVar);
        this.f23918h = new com.applovin.impl.sdk.ad.a(jSONObject, jSONObject2, jVar);
        this.f23919i = appLovinAdLoadListener;
        jVar.S().a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        try {
            com.applovin.impl.adview.b bVar = new com.applovin.impl.adview.b(this.f24689a, a());
            this.f23920j = bVar;
            bVar.a(new b(this.f24689a));
            this.f23920j.loadDataWithBaseURL(this.f23918h.h(), this.f23918h.h1(), "text/html", null, "");
        } catch (Throwable th2) {
            this.f24689a.S().b(this);
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.a(this.f24690b, "Failed to initialize WebView", th2);
            }
            AppLovinAdLoadListener appLovinAdLoadListener = this.f23919i;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(-1);
                this.f23919i = null;
            }
        }
    }

    @Override // com.applovin.impl.ze.a
    public void a(ge geVar) {
        if (geVar.T().equalsIgnoreCase(this.f23918h.H())) {
            this.f24689a.S().b(this);
            AppLovinAdLoadListener appLovinAdLoadListener = this.f23919i;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f23918h);
                this.f23919i = null;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Rendering AppLovin ad #" + this.f23918h.getAdIdNumber());
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.x70
            @Override // java.lang.Runnable
            public final void run() {
                this.f24266a.e();
            }
        });
    }
}
