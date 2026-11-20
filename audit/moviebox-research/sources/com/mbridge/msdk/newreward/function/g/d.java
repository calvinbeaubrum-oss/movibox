package com.mbridge.msdk.newreward.function.g;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.same.net.h.f;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.j;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.CustomInfoManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f46497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f46498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f46499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f46500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f46501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46502h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f46495a = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f46503i = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f46496b = com.mbridge.msdk.foundation.controller.c.m().c();

    public d(int i11, String str, String str2, boolean z11, String str3) {
        this.f46497c = i11;
        this.f46498d = str;
        this.f46499e = str2;
        this.f46500f = z11;
        this.f46501g = str3;
    }

    public final void a(int i11) {
        this.f46502h = i11;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46495a.put(e.f44660e, str);
    }

    public final void a(boolean z11) {
        this.f46503i = z11;
    }

    public final int b() {
        return this.f46497c;
    }

    public final void b(int i11) {
        this.f46495a.put("offset", String.valueOf(i11));
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str) || !com.mbridge.msdk.f.b.a()) {
            return;
        }
        this.f46495a.put("install_ids", str);
    }

    public final String c() {
        return this.f46498d;
    }

    public final void c(int i11) {
        this.f46495a.put("req_type", String.valueOf(i11));
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str) && com.mbridge.msdk.f.b.a() && com.mbridge.msdk.f.b.a()) {
            this.f46495a.put("ttc_ids", str);
        }
    }

    public final String d() {
        return this.f46499e;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46495a.put(e.f44661f, str);
    }

    public final String e() {
        return this.f46501g;
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f46495a.put(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str);
    }

    public final Map<String, String> f() {
        int iT;
        int iU;
        Map<String, String> mapA = a();
        if (mapA != null) {
            this.f46495a.putAll(mapA);
        }
        e eVar = new e(this.f46495a);
        if (com.mbridge.msdk.f.b.a()) {
            eVar.a("gp_version", j.c(this.f46496b));
        }
        eVar.a("version_flag", "1");
        if (com.mbridge.msdk.f.b.a()) {
            com.mbridge.msdk.foundation.controller.authoritycontroller.c.c(true);
        }
        eVar.a("misk_spt", String.valueOf(ai.a()));
        String strC = ai.c();
        if (!TextUtils.isEmpty(strC)) {
            eVar.a("misk_spt_det", strC);
        }
        String str = this.f46499e;
        if (str != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str, this.f46500f ? 7 : 8);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str);
            if (kVarD != null && !TextUtils.isEmpty(kVarD.a())) {
                eVar.a("u_stid", kVarD.a());
            }
        }
        String strA = com.mbridge.msdk.foundation.same.a.d.a(this.f46499e, "reward");
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f46499e);
        if (!TextUtils.isEmpty(this.f46498d)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f46498d);
        }
        com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f46499e);
        if (cVarA != null) {
            iT = cVarA.t();
            iU = cVarA.u();
        } else {
            iT = 0;
            iU = 0;
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ad_num", String.valueOf(iT));
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "tnum", String.valueOf(this.f46497c != 287 ? iU : 1));
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, e.f44659d, strA);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, "1");
        String str2 = e.f44661f;
        String str3 = MBridgeGlobalCommon.SESSION_ID;
        if (str3 == null) {
            str3 = "";
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, str2, str3);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ad_type", String.valueOf(this.f46497c));
        if (!TextUtils.isEmpty(this.f46501g)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "token", this.f46501g);
        }
        if (this.f46497c == 287) {
            int i11 = this.f46502h;
            if (i11 == com.mbridge.msdk.foundation.same.a.H || i11 == com.mbridge.msdk.foundation.same.a.G) {
                com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ivrwd", "1");
            } else {
                com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ivrwd", "0");
            }
        }
        if (cVarA != null && !TextUtils.isEmpty(cVarA.k())) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "u_stid", cVarA.k());
        }
        com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
        if (aVarB != null && !TextUtils.isEmpty(aVarB.b())) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "r_stid", aVarB.b());
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "rw_plus", this.f46503i ? "1" : "0");
        String strD = ai.d(this.f46499e);
        if (!TextUtils.isEmpty(strD)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "j", strD);
        }
        f.a(eVar, this.f46496b);
        f.a(eVar);
        f.c(eVar);
        f.e(eVar);
        f.f(eVar);
        return eVar.a();
    }
}
