package com.iab.omid.library.vungle.publisher;

import android.webkit.WebView;
import com.iab.omid.library.vungle.b.d;
import com.iab.omid.library.vungle.b.e;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import sn.c;
import sn.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vn.b f42445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f42446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f42447c;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        n();
        this.f42445a = new vn.b(null);
    }

    public void a() {
    }

    public void b(float f11) {
        e.a().c(m(), f11);
    }

    public void c(WebView webView) {
        this.f42445a = new vn.b(webView);
    }

    public void d(String str, long j11) {
        if (j11 >= this.f42447c) {
            this.f42446b = a.AD_STATE_VISIBLE;
            e.a().k(m(), str);
        }
    }

    public void e(sn.b bVar) {
        e.a().h(m(), bVar.b());
    }

    public void f(f fVar, c cVar) {
        g(fVar, cVar, null);
    }

    public void g(f fVar, c cVar, JSONObject jSONObject) {
        String strJ = fVar.j();
        JSONObject jSONObject2 = new JSONObject();
        un.b.g(jSONObject2, "environment", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        un.b.g(jSONObject2, "adSessionType", cVar.b());
        un.b.g(jSONObject2, "deviceInfo", un.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        un.b.g(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        un.b.g(jSONObject3, "partnerName", cVar.g().b());
        un.b.g(jSONObject3, "partnerVersion", cVar.g().c());
        un.b.g(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        un.b.g(jSONObject4, "libraryVersion", "1.3.21-Vungle");
        un.b.g(jSONObject4, PushConstants.PROVIDER_FIELD_APP_ID, d.a().c().getApplicationContext().getPackageName());
        un.b.g(jSONObject2, MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject4);
        if (cVar.c() != null) {
            un.b.g(jSONObject2, "contentUrl", cVar.c());
        }
        if (cVar.d() != null) {
            un.b.g(jSONObject2, "customReferenceData", cVar.d());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (sn.e eVar : cVar.h()) {
            un.b.g(jSONObject5, eVar.b(), eVar.c());
        }
        e.a().e(m(), strJ, jSONObject2, jSONObject5, jSONObject);
    }

    public void h(boolean z11) {
        if (k()) {
            e.a().l(m(), z11 ? "foregrounded" : "backgrounded");
        }
    }

    public void i() {
        this.f42445a.clear();
    }

    public void j(String str, long j11) {
        if (j11 >= this.f42447c) {
            a aVar = this.f42446b;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f42446b = aVar2;
                e.a().k(m(), str);
            }
        }
    }

    public boolean k() {
        return this.f42445a.get() != null;
    }

    public void l() {
        e.a().b(m());
    }

    public WebView m() {
        return this.f42445a.get();
    }

    public void n() {
        this.f42447c = un.d.a();
        this.f42446b = a.AD_STATE_IDLE;
    }
}
