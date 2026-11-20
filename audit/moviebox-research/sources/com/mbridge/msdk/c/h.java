package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43017a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f43018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f43019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashMap<String, k> f43020d = new HashMap<>();

    private h() {
    }

    public static h a() {
        if (f43018b == null) {
            synchronized (h.class) {
                try {
                    if (f43018b == null) {
                        f43018b = new h();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43018b;
    }

    public static void a(Context context, String str) {
        FastKV fastKVBuild;
        com.mbridge.msdk.foundation.controller.d.a();
        Map<String, Object> all = null;
        try {
            fastKVBuild = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
        } catch (Exception unused) {
            fastKVBuild = null;
        }
        if (fastKVBuild == null) {
            try {
                Map<String, ?> all2 = context.getSharedPreferences("mbridge", 0).getAll();
                for (String str2 : all2.keySet()) {
                    if (str2.startsWith(str + "_")) {
                        f43020d.put(str2, k.g((String) all2.get(str2)));
                    }
                }
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        try {
            all = fastKVBuild.getAll();
        } catch (Exception unused2) {
        }
        if (all != null) {
            try {
                for (String str3 : all.keySet()) {
                    if (str3.startsWith(str + "_")) {
                        f43020d.put(str3, k.g((String) all.get(str3)));
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }

    private k i(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.c.m().k();
        }
        String str3 = str + "_" + str2;
        if (f43020d.containsKey(str3)) {
            return f43020d.get(str3);
        }
        k kVarG = null;
        try {
            kVarG = k.g(com.mbridge.msdk.foundation.a.a.a.a().a(str3));
            f43020d.put(str3, kVarG);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return kVarG;
    }

    public final g a(String str) {
        g gVarB;
        try {
            return (TextUtils.isEmpty(str) || (gVarB = b(str)) == null) ? i.a() : gVarB;
        } catch (Exception unused) {
            return i.a();
        }
    }

    public final k a(String str, String str2) {
        k kVarI = i(str, str2);
        return kVarI == null ? k.y() : kVarI;
    }

    public final JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (jSONObject2 != null && jSONObject2.length() != 0) {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    if ("unitSetting".equals(next) && jSONObject.has("unitSetting")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                        jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                        jSONObject.put(next, jSONArray);
                    } else {
                        jSONObject.put(next, jSONObject2.opt(next));
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        f43020d.put(str4, k.g(str3));
    }

    public final boolean a(String str, int i11, String str2) {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            String str3 = str + "_" + i11 + "_" + str2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j11 = 0;
            long jLongValue = ((Long) al.a(contextC, str3, 0L)).longValue();
            g gVarB = b(str);
            if (gVarB == null) {
                a();
                gVarB = i.a();
            } else {
                j11 = jLongValue;
            }
            if (j11 + (gVarB.an() * 1000) > jCurrentTimeMillis) {
                return false;
            }
            al.b(contextC, str3, Long.valueOf(jCurrentTimeMillis));
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final g b(String str) {
        if (f43019c == null) {
            try {
                String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject = new JSONObject(strA);
                    if (jSONObject.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObject.remove(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    f43019c = g.e(jSONObject.toString());
                    if (f43019c != null) {
                        f43019c.aK();
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return f43019c;
    }

    public final k b(String str, String str2) {
        return i(str, str2);
    }

    public final k c(String str, String str2) {
        k kVarD = d(str, str2);
        return kVarD == null ? k.y() : kVarD;
    }

    public final String c(String str) {
        return com.mbridge.msdk.foundation.a.a.a.a().a("ivreward_" + str);
    }

    public final k d(String str, String str2) {
        k kVarI = i(str, str2);
        if (kVarI != null && kVarI.v() == 0) {
            kVarI.a(1);
        }
        return kVarI;
    }

    public final boolean d(String str) {
        g gVarB = b(str);
        if (gVarB != null) {
            long jE = gVarB.E() * 1000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jA = gVarB.A() + jE;
            if (jA > jCurrentTimeMillis) {
                ad.c(f43017a, "app setting nexttime is not ready  [settingNextRequestTime= " + jA + " currentTime = " + jCurrentTimeMillis + "]");
                return false;
            }
        }
        ad.c(f43017a, "app setting timeout or not exists");
        return true;
    }

    public final void e(String str) {
        com.mbridge.msdk.foundation.a.a.a.a().c("ivreward_" + str);
    }

    public final boolean e(String str, String str2) {
        g gVarB = b(str2);
        if (d(str2) && a(str2, 1, str)) {
            new j().a(com.mbridge.msdk.foundation.controller.c.m().c(), str2, com.mbridge.msdk.foundation.controller.c.m().b());
        }
        k kVarD = d(str2, str);
        if (gVarB != null && kVarD != null) {
            long jAs = gVarB.as() * 1000;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jI = kVarD.i() + jAs;
            if (jI > jCurrentTimeMillis) {
                ad.c(f43017a, "unit setting  nexttime is not ready  [settingNextRequestTime= " + jI + " currentTime = " + jCurrentTimeMillis + "]");
                return false;
            }
        }
        ad.c(f43017a, "unit setting timeout or not exists");
        return true;
    }

    public final void f(String str) {
        try {
            String strG = g(str);
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strG);
            jSONObject.put("current_time", System.currentTimeMillis());
            g(str, jSONObject.toString());
        } catch (Throwable th2) {
            ad.b(f43017a, th2.getMessage());
        }
    }

    public final void f(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("ivreward_" + str, str2);
    }

    public final String g(String str) {
        if (str == null) {
            return "";
        }
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str);
            return strA == null ? "" : strA;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return "";
        }
    }

    public final void g(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a(str, str2);
        f43019c = g.e(str2);
        if (f43019c != null) {
            f43019c.aK();
        }
    }

    public final void h(String str, String str2) {
        try {
            String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str + "_" + str2);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th2) {
            ad.b(f43017a, th2.getMessage());
        }
    }
}
