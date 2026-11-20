package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.transsion.push.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f45029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f45030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f45031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f45032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f45033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f45034h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f45036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f45037k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f45039m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f45040n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f45041o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f45042p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f45044r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f45045s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f45046t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f45048v;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f45043q = "android";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f45035i = z.m();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f45047u = z.v();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f45038l = e.c();

    public c(Context context) {
        int iL = z.l(context);
        this.f45040n = String.valueOf(iL);
        this.f45041o = z.a(context, iL);
        this.f45036j = z.f(context);
        this.f45031e = com.mbridge.msdk.foundation.controller.c.m().b();
        this.f45030d = com.mbridge.msdk.foundation.controller.c.m().k();
        this.f45046t = String.valueOf(ai.f(context));
        this.f45045s = String.valueOf(ai.e(context));
        this.f45044r = String.valueOf(ai.d(context));
        this.f45048v = com.mbridge.msdk.foundation.controller.c.m().i().toString();
        this.f45033g = z.w();
        this.f45039m = ai.a();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.f45042p = "landscape";
        } else {
            this.f45042p = "portrait";
        }
        this.f45032f = com.mbridge.msdk.foundation.same.a.U;
        this.f45034h = com.mbridge.msdk.foundation.same.a.f44371g;
        this.f45037k = z.n();
        this.f45029c = e.d();
        this.f45027a = e.a();
        this.f45028b = com.mbridge.msdk.foundation.controller.authoritycontroller.b.b() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("device", this.f45035i);
                jSONObject.put("system_version", this.f45047u);
                jSONObject.put("network_type", this.f45040n);
                jSONObject.put("network_type_str", this.f45041o);
                jSONObject.put("device_ua", this.f45036j);
                jSONObject.put("has_wx", z.u(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("integrated_wx", z.y());
                jSONObject.put("opensdk_ver", z.t() + "");
                jSONObject.put("wx_api_ver", z.c(com.mbridge.msdk.foundation.controller.c.m().h()) + "");
                jSONObject.put("brand", this.f45033g);
                jSONObject.put("mnc", z.k(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("mcc", z.j(com.mbridge.msdk.foundation.controller.c.m().c()));
                jSONObject.put("adid_limit", this.f45027a);
                jSONObject.put("adid_limit_dev", this.f45028b);
            }
            jSONObject.put("plantform", this.f45043q);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.f45038l);
                jSONObject.put("az_aid_info", this.f45029c);
            }
            jSONObject.put("appkey", this.f45031e);
            jSONObject.put(PushConstants.PROVIDER_FIELD_APP_ID, this.f45030d);
            jSONObject.put("screen_width", this.f45046t);
            jSONObject.put("screen_height", this.f45045s);
            jSONObject.put("orientation", this.f45042p);
            jSONObject.put("scale", this.f45044r);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.f45032f);
            jSONObject.put("c", this.f45034h);
            jSONObject.put("web_env", this.f45048v);
            jSONObject.put("f", this.f45037k);
            jSONObject.put("misk_spt", this.f45039m);
            if (z.q() != 0) {
                jSONObject.put("tun", z.q());
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.net.h.e.f44658c, com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().f() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("adid_limit", this.f45027a);
                jSONObject2.put("adid_limit_dev", this.f45028b);
                jSONObject.put("dvi", x.b(jSONObject2.toString()));
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.a()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }
}
