package com.mbridge.msdk.reward.adapter;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ai;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f46778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f46779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f46780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.mbridge.msdk.videocommon.d.c f46781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f46782e;

    public d(String str, String str2, boolean z11, com.mbridge.msdk.videocommon.d.c cVar, String str3) {
        this.f46778a = str;
        this.f46779b = str2;
        this.f46780c = z11;
        this.f46781d = cVar;
        this.f46782e = str3;
    }

    public final e a(boolean z11, String str, int i11, String str2, String str3, String str4, String str5, boolean z12, int i12) {
        int iT;
        int iU;
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().k() + com.mbridge.msdk.foundation.controller.c.m().b());
        int i13 = z11 ? 2 : 3;
        com.mbridge.msdk.videocommon.d.c cVar = this.f46781d;
        if (cVar != null) {
            iT = cVar.t();
            iU = this.f46781d.u();
        } else {
            iT = 0;
            iU = 0;
        }
        String strA = com.mbridge.msdk.foundation.same.a.d.a(this.f46779b, "reward");
        int i14 = this.f46780c ? 287 : 94;
        e eVar = new e();
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "app_id", strK);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, this.f46779b);
        if (!TextUtils.isEmpty(this.f46778a)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, MBridgeConstans.PLACEMENT_ID, this.f46778a);
        }
        if (com.mbridge.msdk.f.b.a()) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ttc_ids", str4 == null ? "" : str4);
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "install_ids", str3 == null ? "" : str3);
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "req_type", String.valueOf(i13));
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ad_num", String.valueOf(iT));
        if (this.f46780c) {
            iU = 1;
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "tnum", String.valueOf(iU));
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, e.f44659d, strA);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, e.f44660e, str == null ? "" : str);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, CampaignEx.JSON_KEY_AD_SOURCE_ID, String.valueOf(1));
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, e.f44661f, str2 == null ? "" : str2);
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ad_type", String.valueOf(i14));
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "offset", String.valueOf(i11));
        if (!TextUtils.isEmpty(str5)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "token", str5);
        }
        if (this.f46780c) {
            if (i12 == com.mbridge.msdk.foundation.same.a.H || i12 == com.mbridge.msdk.foundation.same.a.G) {
                com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ivrwd", "1");
            } else {
                com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "ivrwd", "0");
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar2 = this.f46781d;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.k())) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "u_stid", this.f46781d.k());
        }
        com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
        if (aVarB != null && !TextUtils.isEmpty(aVarB.b())) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "r_stid", aVarB.b());
        }
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "rw_plus", z12 ? "1" : "0");
        String strD = ai.d(this.f46779b);
        if (!TextUtils.isEmpty(strD)) {
            com.mbridge.msdk.foundation.same.net.g.b.a(eVar, "j", strD);
        }
        String str6 = this.f46782e;
        com.mbridge.msdk.foundation.same.net.g.b.a(eVar, CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, str6 != null ? str6 : "");
        return eVar;
    }
}
