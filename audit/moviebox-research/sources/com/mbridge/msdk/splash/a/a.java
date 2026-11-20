package com.mbridge.msdk.splash.a;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.z;
import com.transsion.push.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f46942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f46943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f46944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f46945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f46946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f46947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f46948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f46949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f46950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f46951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f46952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f46953p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f46954q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f46940c = "android";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f46938a = z.m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f46939b = z.v();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f46941d = e.c();

    public a(Context context) {
        int iL = z.l(context);
        this.f46942e = String.valueOf(iL);
        this.f46943f = z.a(context, iL);
        this.f46944g = z.f(context);
        this.f46945h = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f46946i = com.mbridge.msdk.foundation.controller.c.m().k();
        this.f46947j = String.valueOf(ai.f(context));
        this.f46948k = String.valueOf(ai.e(context));
        this.f46950m = String.valueOf(ai.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f46949l = "landscape";
        } else {
            this.f46949l = "portrait";
        }
        this.f46951n = z.n();
        this.f46952o = e.d();
        this.f46953p = e.a();
        this.f46954q = com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? 1 : 0;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f46938a);
                jSONObject.put("system_version", this.f46939b);
                jSONObject.put("network_type", this.f46942e);
                jSONObject.put("network_type_str", this.f46943f);
                jSONObject.put("device_ua", this.f46944g);
                jSONObject.put("has_wx", z.u(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("integrated_wx", z.y());
                jSONObject.put("mnc", z.k(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("mcc", z.j(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("adid_limit", this.f46953p);
                jSONObject.put("adid_limit_dev", this.f46954q);
            }
            jSONObject.put("plantform", this.f46940c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f46941d);
                jSONObject.put("az_aid_info", this.f46952o);
            }
            jSONObject.put("appkey", this.f46945h);
            jSONObject.put(PushConstants.PROVIDER_FIELD_APP_ID, this.f46946i);
            jSONObject.put("screen_width", this.f46947j);
            jSONObject.put("screen_height", this.f46948k);
            jSONObject.put("orientation", this.f46949l);
            jSONObject.put("scale", this.f46950m);
            if (z.q() != 0) {
                jSONObject.put("tun", z.q());
            }
            jSONObject.put("f", this.f46951n);
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e11) {
            ad.b("BaseDeviceInfo", e11.getMessage());
        }
        return jSONObject;
    }
}
