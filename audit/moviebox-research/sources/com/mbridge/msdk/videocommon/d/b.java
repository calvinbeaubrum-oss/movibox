package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile b f48475d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f48476c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f48477e = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, c> f48474b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f48473a = null;

    private b() {
    }

    public static b a() {
        if (f48475d == null) {
            synchronized (b.class) {
                try {
                    if (f48475d == null) {
                        f48475d = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48475d;
    }

    private final boolean a(c cVar) {
        a aVarB = b();
        if (aVarB == null || cVar == null) {
            return true;
        }
        return cVar.x() + aVarB.e() <= System.currentTimeMillis();
    }

    public static boolean e(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String strOptString = jSONArrayOptJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (jSONArrayOptJSONArray.length() > 0 && !TextUtils.isEmpty(strOptString)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private void f(String str, String str2) {
        if (this.f48476c) {
            return;
        }
        this.f48476c = true;
        new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2);
    }

    private void g(final String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            H5DownLoadManager.getInstance().downloadH5Res(new com.mbridge.msdk.foundation.same.report.d.b(true), str, new H5DownLoadManager.ZipDownloadListener() { // from class: com.mbridge.msdk.videocommon.d.b.1
                @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                public final void onFailed(String str3, String str4) {
                    q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, 2, str4);
                }

                @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
                public final void onSuccess(String str3, String str4, boolean z11) {
                    q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, 1, "");
                }
            });
            return;
        }
        q.a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, 2, "alert url is exception ,url:" + str);
    }

    public final c a(String str, String str2) {
        c cVar;
        boolean zA;
        String str3 = "reward_" + str + "_" + str2;
        if (!f48474b.containsKey(str3)) {
            c cVarC = c.c(com.mbridge.msdk.foundation.a.a.a.a().a(str3));
            if (a(cVarC)) {
                a(str, com.mbridge.msdk.foundation.controller.c.m().b(), str2, null);
                return null;
            }
            f48474b.put(str3, cVarC);
            return cVarC;
        }
        try {
            cVar = f48474b.get(str3);
            try {
                zA = a(cVar);
            } catch (Exception unused) {
                zA = false;
            }
        } catch (Exception unused2) {
            cVar = null;
        }
        if (zA) {
            a(str, com.mbridge.msdk.foundation.controller.c.m().b(), str2, null);
        }
        return cVar;
    }

    public final c a(String str, String str2, boolean z11) {
        c cVar;
        boolean zA;
        String str3 = "reward_" + str + "_" + str2;
        if (f48474b.containsKey(str3)) {
            try {
                cVar = f48474b.get(str3);
                try {
                    zA = a(cVar);
                } catch (Exception unused) {
                    zA = false;
                }
            } catch (Exception unused2) {
                cVar = null;
            }
            if (zA) {
                a(str, com.mbridge.msdk.foundation.controller.c.m().b(), str2, null);
            }
            return cVar;
        }
        c cVarC = c.c(com.mbridge.msdk.foundation.a.a.a.a().a(str3));
        if (!a(cVarC)) {
            f48474b.put(str3, cVarC);
            return cVarC;
        }
        if (cVarC != null) {
            return cVarC;
        }
        a(str, com.mbridge.msdk.foundation.controller.c.m().b(), str2, null);
        return b(z11);
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f48477e.add(str);
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f48474b.put(str4, c.c(str3));
        if (com.mbridge.msdk.f.b.a() || TextUtils.isEmpty(c.f48481a)) {
            return;
        }
        g(c.f48481a, str2);
    }

    public final void a(String str, String str2, String str3, com.mbridge.msdk.videocommon.c.c cVar) {
        try {
            if (!TextUtils.isEmpty(str3) && !this.f48477e.contains(str3)) {
                a(str3);
                new com.mbridge.msdk.videocommon.c.a().a(com.mbridge.msdk.foundation.controller.c.m().c(), str, str2, str3, cVar);
                return;
            }
            ad.a("test_reward_unit_setting", "unitID: " + str3 + " is requesting");
        } catch (Exception unused) {
        }
    }

    public final void a(boolean z11) {
        this.f48476c = z11;
    }

    public final a b() {
        a aVar = f48473a;
        if (aVar != null) {
            return aVar;
        }
        String strA = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + com.mbridge.msdk.foundation.controller.c.m().k());
        if (TextUtils.isEmpty(strA)) {
            f(com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b());
            return c();
        }
        a aVarA = a.a(strA);
        if (aVarA != null) {
            if (aVarA.i() + aVarA.d() > System.currentTimeMillis()) {
                return aVarA;
            }
        }
        f(com.mbridge.msdk.foundation.controller.c.m().k(), com.mbridge.msdk.foundation.controller.c.m().b());
        return c();
    }

    public final c b(boolean z11) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 60, null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.m(1);
            cVar.l(1);
            cVar.n(1);
            cVar.q(1);
            cVar.o(1);
            cVar.p(1);
            cVar.h(3);
            cVar.i(80);
            cVar.j(100);
            cVar.k(0);
            cVar.g(2);
            cVar.e(-1);
            cVar.x(70);
            cVar.d(2);
            if (z11) {
                cVar.c(5);
            } else {
                cVar.c(-1);
            }
            cVar.b(0);
            cVar.a(0);
            cVar.f(1);
            cVar.r(1);
            cVar.t(3);
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a(arrayList2);
            cVar.u(1);
            cVar.v(1);
            cVar.w(60);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return cVar;
    }

    public final void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f48477e.remove(str);
        } catch (Exception unused) {
        }
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str, str2);
        f48473a = a.a(str2);
    }

    public final a c() {
        a aVar = new a();
        HashMap map = new HashMap(5);
        map.put("1", 1000);
        map.put(PrepareException.ERROR_MINI_APP_CLOSE, 1000);
        map.put(PrepareException.ERROR_MANIFEST_INFO, 1000);
        HashMap map2 = new HashMap(3);
        map2.put("1", new com.mbridge.msdk.videocommon.b.c("Virtual Item", 1));
        aVar.a(map);
        aVar.b(map2);
        aVar.a(43200L);
        aVar.b(5400L);
        aVar.c(3600L);
        aVar.d(3600L);
        aVar.e(5L);
        aVar.a(1);
        return aVar;
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a().a(com.mbridge.msdk.foundation.controller.c.m().k(), str, false);
        String str2 = c.f48481a;
        if (TextUtils.isEmpty(str2) || !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str2))) {
            return;
        }
        g(str2, str);
    }

    public final void c(String str, String str2) {
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str + "_" + str2);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th2) {
            ad.b("RewardSettingManager", th2.getMessage());
        }
    }

    public final String d(String str, String str2) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str + "_" + str2);
    }

    public final boolean d() {
        return this.f48476c;
    }

    public final boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f48477e.contains(str);
    }

    public final a e() {
        String str = "reward_" + com.mbridge.msdk.foundation.controller.c.m().k();
        if (f48473a == null) {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
            if (!TextUtils.isEmpty(strA)) {
                a aVarA = a.a(strA);
                if (aVarA != null) {
                    f48473a = aVarA;
                }
                return aVarA;
            }
        }
        return f48473a;
    }

    public final c e(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (f48474b.containsKey(str3)) {
            return f48474b.get(str3);
        }
        c cVarC = c.c(com.mbridge.msdk.foundation.a.a.a.a().a(str3));
        if (cVarC != null) {
            f48474b.put(str3, cVarC);
        }
        return cVarC;
    }

    public final void f(String str) {
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.put("current_time", System.currentTimeMillis());
            b(str, jSONObject.toString());
        } catch (Throwable th2) {
            ad.b("RewardSettingManager", th2.getMessage());
        }
    }

    public final String g(String str) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str);
    }
}
