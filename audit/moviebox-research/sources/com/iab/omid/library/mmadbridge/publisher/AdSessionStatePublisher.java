package com.iab.omid.library.mmadbridge.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.mmadbridge.internal.g;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.push.PushConstants;
import java.util.Date;
import kn.d;
import nn.c;
import nn.f;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pn.b f42376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kn.a f42377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.iab.omid.library.mmadbridge.adsession.media.a f42378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f42379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f42380e;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        a();
        this.f42376a = new pn.b(null);
    }

    public void a() {
        this.f42380e = f.b();
        this.f42379d = a.AD_STATE_IDLE;
    }

    public void b(float f11) {
        g.a().c(v(), f11);
    }

    public void c(WebView webView) {
        this.f42376a = new pn.b(webView);
    }

    public void d(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f42378c = aVar;
    }

    public void e(String str) {
        g.a().f(v(), str, null);
    }

    public void f(String str, long j11) {
        if (j11 >= this.f42380e) {
            a aVar = this.f42379d;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f42379d = aVar2;
                g.a().d(v(), str);
            }
        }
    }

    public void g(String str, JSONObject jSONObject) {
        g.a().f(v(), str, jSONObject);
    }

    public void h(@NonNull Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
        g.a().o(v(), jSONObject);
    }

    public void i(kn.a aVar) {
        this.f42377b = aVar;
    }

    public void j(kn.c cVar) {
        g.a().j(v(), cVar.d());
    }

    public void k(kn.g gVar, d dVar) {
        l(gVar, dVar, null);
    }

    public void l(kn.g gVar, d dVar, JSONObject jSONObject) {
        String strV = gVar.v();
        JSONObject jSONObject2 = new JSONObject();
        c.i(jSONObject2, "environment", MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        c.i(jSONObject2, "adSessionType", dVar.c());
        c.i(jSONObject2, "deviceInfo", nn.b.d());
        c.i(jSONObject2, "deviceCategory", nn.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.i(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.i(jSONObject3, "partnerName", dVar.h().b());
        c.i(jSONObject3, "partnerVersion", dVar.h().c());
        c.i(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.i(jSONObject4, "libraryVersion", "1.4.2-Mmadbridge");
        c.i(jSONObject4, PushConstants.PROVIDER_FIELD_APP_ID, com.iab.omid.library.mmadbridge.internal.f.c().a().getApplicationContext().getPackageName());
        c.i(jSONObject2, MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject4);
        if (dVar.d() != null) {
            c.i(jSONObject2, "contentUrl", dVar.d());
        }
        if (dVar.e() != null) {
            c.i(jSONObject2, "customReferenceData", dVar.e());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (kn.f fVar : dVar.i()) {
            c.i(jSONObject5, fVar.d(), fVar.e());
        }
        g.a().g(v(), strV, jSONObject2, jSONObject5, jSONObject);
    }

    public void m(@NonNull JSONObject jSONObject) {
        g.a().n(v(), jSONObject);
    }

    public void n(boolean z11) {
        if (s()) {
            g.a().m(v(), z11 ? "foregrounded" : "backgrounded");
        }
    }

    public void o() {
        this.f42376a.clear();
    }

    public void p(String str, long j11) {
        if (j11 >= this.f42380e) {
            this.f42379d = a.AD_STATE_VISIBLE;
            g.a().d(v(), str);
        }
    }

    public kn.a q() {
        return this.f42377b;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a r() {
        return this.f42378c;
    }

    public boolean s() {
        return this.f42376a.get() != null;
    }

    public void t() {
        g.a().b(v());
    }

    public void u() {
        g.a().l(v());
    }

    public WebView v() {
        return this.f42376a.get();
    }

    public void w() {
    }
}
