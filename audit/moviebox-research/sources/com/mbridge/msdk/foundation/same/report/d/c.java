package com.mbridge.msdk.foundation.same.report.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.m;
import com.mbridge.msdk.e.o;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.t;
import com.mbridge.msdk.foundation.same.report.u;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f44845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile m f44846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, d> f44847c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinkedHashMap<String, b> f44848d = new LinkedHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, d> f44849e = new HashMap();

    private c() {
        if (this.f44846b == null) {
            this.f44846b = m.a("metrics_sdk", com.mbridge.msdk.foundation.controller.c.m().c(), c());
        }
        JSONObject jSONObjectA = g.a();
        if (this.f44846b != null) {
            this.f44846b.a(jSONObjectA);
            this.f44846b.a();
        }
    }

    public static c a() {
        if (f44845a == null) {
            synchronized (c.class) {
                try {
                    if (f44845a == null) {
                        f44845a = new c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44845a;
    }

    private void b(String str, b bVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        try {
            if (Arrays.asList(a.f44811c).contains(str)) {
                bVar.m(str);
            }
            Map<String, d> map = this.f44849e;
            if (map != null && map.containsKey(str)) {
                bVar.a(str, this.f44849e.get(str));
            }
            new e().a(str, this.f44846b, bVar, aVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private w c() {
        try {
            int iA = af.a().a("metrics", "t_m_e_t", af.a().a("t_m_e_t", 604800000));
            int iA2 = af.a().a("metrics", "t_m_e_s", af.a().a("t_m_e_s", 50));
            int iA3 = af.a().a("metrics", "t_m_r_c", af.a().a("t_m_r_c", 50));
            int iA4 = af.a().a("metrics", "t_m_t", af.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS));
            int iA5 = af.a().a("metrics", "t_m_r_t_s", af.a().a("t_m_r_t_s", 2));
            int iA6 = af.a().a("metrics", "t_r_t", af.a().a("t_r_t", 1));
            if (iA6 != 0 && iA6 != 1) {
                iA6 = 0;
            }
            return new w.a().e(iA).a(iA2).d(iA3).b(iA4).c(iA5).a(new h()).a(g.b()).a(new u()).a(iA6, iA6 == 1 ? new o(new t((byte) 2), com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m) : new o(new com.mbridge.msdk.e.a.a.g(), DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS, 0)).a();
        } catch (Exception e11) {
            ad.b("EventLibraryReport", "configTrackManager error: " + e11.getMessage());
            return null;
        }
    }

    public final d a(int i11, int i12, String str, boolean z11, int i13) {
        d dVar = new d();
        try {
            dVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(i11));
            dVar.a("adtp", Integer.valueOf(i12));
            dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            if (z11) {
                dVar.a("auto_load", Integer.valueOf(i13));
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return dVar;
    }

    public final d a(String str) {
        Map<String, d> map;
        d dVar = new d();
        try {
            return (TextUtils.isEmpty(str) || (map = this.f44847c) == null || !map.containsKey(str)) ? dVar : this.f44847c.get(str);
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return dVar;
            }
            e11.printStackTrace();
            return dVar;
        }
    }

    public final void a(n nVar, CampaignEx campaignEx) {
        d dVar = new d();
        dVar.a("result", Integer.valueOf(nVar.m()));
        dVar.a("scenes", nVar.b("scenes", ""));
        dVar.a("resource_type", Integer.valueOf(nVar.A()));
        dVar.a("url", nVar.b("url", ""));
        dVar.a("reason", nVar.h());
        dVar.a("mraid_type", Integer.valueOf(nVar.y()));
        a().a(nVar.a(), campaignEx, dVar);
    }

    public final void a(b bVar) {
        if (bVar != null) {
            try {
                if (this.f44847c != null) {
                    d dVar = new d();
                    dVar.a("rs_rid", bVar.k());
                    dVar.a("r_stid", bVar.m());
                    dVar.a("rus_rid", bVar.l());
                    dVar.a("u_stid", bVar.t());
                    this.f44847c.put(bVar.i(), dVar);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void a(String str, CampaignEx campaignEx) {
        String currentLocalRid = "";
        if (campaignEx != null) {
            try {
                currentLocalRid = campaignEx.getCurrentLocalRid();
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        b bVar = this.f44848d.get(currentLocalRid);
        if (bVar == null) {
            bVar = new b();
        }
        bVar.a(campaignEx);
        bVar.c(currentLocalRid);
        b(str, bVar, null);
    }

    public final void a(String str, CampaignEx campaignEx, d dVar) {
        b bVar;
        String localRequestId = "";
        if (campaignEx != null) {
            try {
                localRequestId = campaignEx.getLocalRequestId();
                bVar = this.f44848d.get(localRequestId);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            bVar = null;
        }
        if (bVar == null) {
            bVar = new b();
        } else if (Arrays.asList(a.f44816h).contains(str)) {
            bVar = b(bVar);
        }
        bVar.a(campaignEx);
        bVar.c(localRequestId);
        bVar.a(str, dVar);
        b(str, bVar, null);
    }

    public final void a(String str, b bVar) {
        try {
            Map<String, d> map = this.f44849e;
            if (map != null && map.containsKey(str)) {
                bVar.a(str, this.f44849e.get(str));
            }
            new e().a(str, this.f44846b, bVar, null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(String str, b bVar, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (bVar == null) {
                bVar = new b();
            }
            d dVar = new d();
            dVar.a("st", Long.valueOf(System.currentTimeMillis()));
            if (campaignEx != null) {
                dVar.a(BidResponsedEx.KEY_CID, campaignEx.getId());
                dVar.a("lrid", campaignEx.getLocalRequestId());
                dVar.a("rid", campaignEx.getRequestId());
                dVar.a("rid_n", campaignEx.getRequestIdNotice());
                dVar.a("adtp", Integer.valueOf(campaignEx.getAdType()));
                if (!dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                    dVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                }
                dVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(campaignEx.isBidCampaign() ? 1 : 0));
                dVar.a("bid_tk", campaignEx.getBidToken());
            }
            if (context != null) {
                dVar.a("network_type", Integer.valueOf(z.l(context)));
            }
            bVar.a(str, dVar);
            b(str, bVar, aVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(String str, b bVar, com.mbridge.msdk.foundation.same.report.d.a.a aVar) {
        b(str, bVar, aVar);
    }

    public final void a(String str, d dVar) {
        Map<String, d> map = this.f44849e;
        if (map != null) {
            map.put(str, dVar);
        }
    }

    public final void a(String str, List<CampaignEx> list, d dVar) {
        CampaignEx campaignEx;
        String currentLocalRid = "";
        if (list != null) {
            try {
                if (list.size() > 0 && (campaignEx = list.get(0)) != null) {
                    currentLocalRid = campaignEx.getCurrentLocalRid();
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        b bVar = this.f44848d.get(currentLocalRid);
        if (bVar == null) {
            bVar = new b();
        }
        bVar.b(list);
        if (list != null && list.size() > 0) {
            bVar.c(list.get(0).getCurrentLocalRid());
        }
        bVar.a(str, dVar);
        b(str, bVar, null);
    }

    public final b b(b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            return (b) bVar.clone();
        } catch (CloneNotSupportedException e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e11.printStackTrace();
            return null;
        }
    }

    public final b b(String str) {
        LinkedHashMap<String, b> linkedHashMap;
        try {
            if (!TextUtils.isEmpty(str) && (linkedHashMap = this.f44848d) != null && linkedHashMap.containsKey(str)) {
                return this.f44848d.get(str);
            }
            return null;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return null;
        }
    }

    public final LinkedHashMap<String, b> b() {
        return this.f44848d;
    }

    public final void b(String str, d dVar) {
        try {
            b bVar = new b();
            if (dVar.b(MBridgeConstans.PROPERTIES_UNIT_ID) != null) {
                bVar.d(String.valueOf(dVar.b(MBridgeConstans.PROPERTIES_UNIT_ID)));
            }
            if (dVar.b("lrid") != null && (dVar.b("lrid") instanceof String)) {
                bVar.c(String.valueOf(dVar.b("lrid")));
            }
            bVar.a(str, dVar);
            new e().b(str, this.f44846b, bVar, null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void c(String str) {
        LinkedHashMap<String, b> linkedHashMap;
        try {
            if (!TextUtils.isEmpty(str) && (linkedHashMap = this.f44848d) != null && linkedHashMap.containsKey(str)) {
                this.f44848d.remove(str);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
