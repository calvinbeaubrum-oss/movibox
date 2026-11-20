package com.mbridge.msdk.advanced.common;

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
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f42798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f42799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f42800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f42801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f42802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f42803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f42804k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f42805l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f42806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f42807n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f42808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f42809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f42810q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f42796c = "android";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f42794a = z.m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f42795b = z.v();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f42797d = e.c();

    public a(Context context) {
        int iL = z.l(context);
        this.f42798e = String.valueOf(iL);
        this.f42799f = z.a(context, iL);
        this.f42800g = z.f(context);
        this.f42801h = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f42802i = com.mbridge.msdk.foundation.controller.c.m().k();
        this.f42803j = String.valueOf(ai.f(context));
        this.f42804k = String.valueOf(ai.e(context));
        this.f42806m = String.valueOf(ai.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f42805l = "landscape";
        } else {
            this.f42805l = "portrait";
        }
        this.f42807n = z.n();
        this.f42808o = e.d();
        this.f42809p = e.a();
        this.f42810q = com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? 1 : 0;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f42794a);
                jSONObject.put("system_version", this.f42795b);
                jSONObject.put("network_type", this.f42798e);
                jSONObject.put("network_type_str", this.f42799f);
                jSONObject.put("device_ua", this.f42800g);
                jSONObject.put("has_wx", z.u(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("integrated_wx", z.y());
                jSONObject.put("opensdk_ver", z.t() + "");
                jSONObject.put("wx_api_ver", z.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
                jSONObject.put("mnc", z.k(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("mcc", z.j(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("adid_limit", this.f42809p);
                jSONObject.put("adid_limit_dev", this.f42810q);
            }
            jSONObject.put("plantform", this.f42796c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f42797d);
                jSONObject.put("az_aid_info", this.f42808o);
            }
            jSONObject.put("appkey", this.f42801h);
            jSONObject.put(PushConstants.PROVIDER_FIELD_APP_ID, this.f42802i);
            jSONObject.put("screen_width", this.f42803j);
            jSONObject.put("screen_height", this.f42804k);
            jSONObject.put("orientation", this.f42805l);
            jSONObject.put("scale", this.f42806m);
            if (z.q() != 0) {
                jSONObject.put("tun", z.q());
            }
            jSONObject.put("f", this.f42807n);
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e11) {
            ad.b("BaseDeviceInfo", e11.getMessage());
        }
        return jSONObject;
    }
}
