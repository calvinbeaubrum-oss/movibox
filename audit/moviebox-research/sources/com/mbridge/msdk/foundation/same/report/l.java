package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile l f44884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f44885b = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.report.l.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName("mb-common-report-thread");
            return threadNewThread;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile com.mbridge.msdk.e.m f44886c;

    public static l a() {
        if (f44884a == null) {
            synchronized (l.class) {
                try {
                    if (f44884a == null) {
                        f44884a = new l();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44884a;
    }

    private boolean a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2) || (!str2.equals(BidResponsed.KEY_BID_ID) && !str2.equals("buyer_id") && !str2.equals("roas") && !str2.equals("InitSDK") && !str2.equals("CronetEnv"))) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                int i11 = Integer.parseInt(str);
                if (i11 == 94 || i11 == 279 || i11 == 287 || i11 == 288 || i11 == 295) {
                    return af.a().a("r_l_b_m_t_r_i", true);
                }
                if (i11 != 296) {
                    return false;
                }
                return af.a().a("r_l_b_m_t_b", false);
            }
            return true;
        } catch (Exception e11) {
            ad.b("MetricsReportUtil", e11.getMessage());
            return false;
        }
    }

    private w e() {
        int iA = af.a().a("metrics", "t_m_e_t", af.a().a("t_m_e_t", 604800000));
        int iA2 = af.a().a("metrics", "t_m_e_s", af.a().a("t_m_e_s", 50));
        int iA3 = af.a().a("metrics", "t_m_r_c", af.a().a("t_m_r_c", 50));
        int iA4 = af.a().a("metrics", "t_m_t", af.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS));
        int iA5 = af.a().a("metrics", "t_m_r_t_s", af.a().a("t_m_r_t_s", 2));
        int iA6 = af.a().a("metrics", "t_r_t", af.a().a("t_r_t", 1));
        if (iA6 != 0 && iA6 != 1) {
            iA6 = 0;
        }
        try {
            return new w.a().e(iA).a(iA2).d(iA3).b(iA4).c(iA5).a(new h()).a(g.b()).a(new u()).a(iA6, iA6 == 1 ? new com.mbridge.msdk.e.o(new t((byte) 2), com.mbridge.msdk.foundation.same.net.g.d.f().f44632i, com.mbridge.msdk.foundation.same.net.g.d.f().f44636m) : new com.mbridge.msdk.e.o(new com.mbridge.msdk.e.a.a.g(), DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS, 0)).a();
        } catch (Exception e11) {
            ad.b("EventLibraryReport", "configTrackManager error: " + e11.getMessage());
            return null;
        }
    }

    public final void a(Context context, String str, String str2, String str3, String str4, int i11) {
        com.mbridge.msdk.e.m mVarD = a().d();
        if (mVarD == null) {
            return;
        }
        if (!mVarD.a("2000105")) {
            ad.a("MetricsReportUtil", "reportClickImpException can not track");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put("url", "");
            } else {
                jSONObject.put("url", URLEncoder.encode(str2, "utf-8"));
            }
            jSONObject.put("type", i11);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("rid", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("rid_n", str4);
            }
            try {
                long[] jArrG = mVarD.g();
                jSONObject.put("track_time", jArrG[0]);
                jSONObject.put("track_count", jArrG[1]);
                jSONObject.put("session_id", mVarD.b());
            } catch (Exception unused) {
            }
            jSONObject.put("reason", URLEncoder.encode(str, "utf-8"));
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("2000105");
            eVar.a(jSONObject);
            eVar.b(0);
            eVar.a(0);
            eVar.a(g.c());
            mVarD.a(eVar);
        } catch (Exception e11) {
            ad.b("MetricsReportUtil", e11.getMessage());
        }
    }

    public final void a(String str, String str2, String str3, String str4, Map<String, String> map) {
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (TextUtils.isEmpty(str) || contextC == null || !a(str4, str2)) {
            return;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e11) {
                ad.a("MetricsReportUtil", e11.getMessage());
                return;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        map.put("ts", String.valueOf(jCurrentTimeMillis));
        b.a aVarA = b.a(str, str2).a(contextC).c(str3).b(com.mbridge.msdk.foundation.controller.c.m().k()).a(str4).a(false).a(jCurrentTimeMillis).a(this.f44885b);
        if (aVarA == null) {
            return;
        }
        aVarA.a(map);
        b bVarA = aVarA.a();
        if (bVarA == null) {
            return;
        }
        bVarA.o();
    }

    public final void b() {
        if (this.f44886c != null) {
            this.f44886c.e();
        }
    }

    public final void c() {
        if (af.a().a("metrics", "e_t_l", af.a().a("e_t_l", 1)) == 1) {
            d().e();
        }
    }

    public final com.mbridge.msdk.e.m d() {
        if (this.f44886c == null) {
            this.f44886c = com.mbridge.msdk.e.m.a("mtg_sdk", com.mbridge.msdk.foundation.controller.c.m().c(), e());
            this.f44886c.a(g.a());
            this.f44886c.a();
        }
        return this.f44886c;
    }
}
