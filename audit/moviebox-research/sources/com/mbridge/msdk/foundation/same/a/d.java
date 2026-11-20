package com.mbridge.msdk.foundation.same.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c>> f44400d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f44401e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f44402f = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f44410n = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44397a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44398b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44399c = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44403g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44404h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44405i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44406j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Map<String, Long> f44407k = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44408l = new HashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> f44409m = new HashMap();

    public static String a(String str, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> mapD;
        List<com.mbridge.msdk.foundation.same.d.a> list;
        JSONArray jSONArray = new JSONArray();
        if (!TextUtils.isEmpty(str2)) {
            mapD = d(str2);
        } else if (f44405i.containsKey(str)) {
            mapD = f44405i;
        } else if (f44406j.containsKey(str)) {
            mapD = f44406j;
        } else if (f44403g.containsKey(str)) {
            mapD = f44403g;
        } else if (f44409m.containsKey(str)) {
            mapD = f44409m;
        } else if (f44404h.containsKey(str)) {
            mapD = f44404h;
        } else if (f44398b.containsKey(str)) {
            mapD = f44398b;
        } else if (f44408l.containsKey(str)) {
            mapD = f44408l;
        } else {
            mapD = f44399c.containsKey(str) ? f44399c : null;
        }
        if (mapD != null) {
            try {
                if (an.b(str) && mapD.containsKey(str) && (list = mapD.get(str)) != null && list.size() > 0) {
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("2", list.get(i11).a());
                        jSONObject.put("1", list.get(i11).c());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> a(String str) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c>> concurrentHashMap = f44400d;
        if (concurrentHashMap == null) {
            f fVarA = f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
            if (fVarA != null) {
                fVarA.d(str, "");
                f44400d = new ConcurrentHashMap<>();
            }
        } else if (concurrentHashMap.containsKey(str)) {
            return f44400d.get(str);
        }
        return null;
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        Map<String, List<com.mbridge.msdk.foundation.same.d.a>> mapD = d(str2);
        if (campaignEx == null || mapD == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(campaignEx.getId())) {
                return;
            }
            com.mbridge.msdk.foundation.same.d.a aVar = new com.mbridge.msdk.foundation.same.d.a(campaignEx.getId(), campaignEx.getRequestIdNotice());
            if (!mapD.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar);
                mapD.put(str, arrayList);
                return;
            }
            List<com.mbridge.msdk.foundation.same.d.a> list = mapD.get(str);
            if (list != null && list.size() == 20) {
                list.remove(0);
            }
            if (list != null) {
                list.add(aVar);
            }
        } catch (Throwable th2) {
            ad.a(f44410n, th2.getMessage(), th2);
        }
    }

    public static void a(String str, String str2, int i11) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f44402f == null) {
            f44402f = new ConcurrentHashMap<>();
        }
        try {
            if (f44402f.containsKey(str)) {
                copyOnWriteArrayList = f44402f.get(str);
                copyOnWriteArrayList.add(str2);
            } else {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                copyOnWriteArrayList2.add(str2);
                f44402f.put(str, copyOnWriteArrayList2);
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
            int size = copyOnWriteArrayList.size() - i11;
            if (size >= 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    copyOnWriteArrayList.remove(i12);
                }
            }
        } catch (Exception e11) {
            ad.a(f44410n, e11.getMessage());
        }
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (f44401e == null) {
                f44401e = new ConcurrentHashMap<>();
            }
            if (!f44401e.containsKey(str)) {
                ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
                concurrentHashMap.put(str2, str3);
                f44401e.put(str, concurrentHashMap);
            } else if (f44401e.get(str) == null) {
                ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.put(str2, str3);
                f44401e.put(str, concurrentHashMap2);
            }
        } catch (Exception e11) {
            ad.a(f44410n, e11.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, long j11, long j12, long j13) {
        if (f44400d == null) {
            f44400d = new ConcurrentHashMap<>();
        }
        try {
            if (!f44400d.containsKey(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str3);
                ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap = new ConcurrentHashMap<>();
                com.mbridge.msdk.foundation.entity.c cVar = new com.mbridge.msdk.foundation.entity.c();
                cVar.a(arrayList);
                cVar.a(j11);
                cVar.b(j12);
                cVar.c(j13);
                concurrentHashMap.put(str2, cVar);
                f44400d.put(str, concurrentHashMap);
                return;
            }
            ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap2 = f44400d.get(str);
            if (concurrentHashMap2 != null) {
                com.mbridge.msdk.foundation.entity.c cVar2 = concurrentHashMap2.get(str2);
                if (cVar2 != null) {
                    if (cVar2.c() != null) {
                        cVar2.a(j11);
                        cVar2.b(j12);
                        cVar2.c(j13);
                        cVar2.c().add(str3);
                        return;
                    }
                    return;
                }
                com.mbridge.msdk.foundation.entity.c cVar3 = new com.mbridge.msdk.foundation.entity.c();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str3);
                cVar3.a(arrayList2);
                cVar3.a(j11);
                cVar3.b(j12);
                cVar3.c(j13);
                concurrentHashMap2.put(str2, cVar3);
            }
        } catch (Throwable th2) {
            ad.b(f44410n, th2.getMessage());
        }
    }

    public static com.mbridge.msdk.foundation.entity.d b(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        com.mbridge.msdk.foundation.entity.d dVar = new com.mbridge.msdk.foundation.entity.d();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return dVar;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f44401e;
            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str) && (concurrentHashMap = f44401e.get(str)) != null && concurrentHashMap.containsKey(str2)) {
                dVar.a(1);
                dVar.c(concurrentHashMap.get(str2));
            }
        } catch (Exception e11) {
            ad.a(f44410n, e11.getMessage());
        }
        return dVar;
    }

    public static String b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        return (TextUtils.isEmpty(str) || (concurrentHashMap = f44402f) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f44402f.get(str)) == null || copyOnWriteArrayList.size() <= 0) ? "" : copyOnWriteArrayList.get(0);
    }

    public static void c(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap;
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f44402f) == null || !concurrentHashMap.containsKey(str) || (copyOnWriteArrayList = f44402f.get(str)) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        copyOnWriteArrayList.remove(0);
    }

    public static void c(String str, String str2) {
        ConcurrentHashMap<String, ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c>> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = f44400d) == null || !concurrentHashMap.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            f44400d.remove(str);
            return;
        }
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMap2 = f44400d.get(str);
        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str2)) {
            return;
        }
        concurrentHashMap2.remove(str2);
    }

    private static Map<String, List<com.mbridge.msdk.foundation.same.d.a>> d(String str) {
        str.hashCode();
        switch (str) {
            case "banner":
                return f44398b;
            case "native":
                return f44405i;
            case "reward":
                return f44406j;
            case "splash":
                return f44408l;
            case "h5_native":
                return f44399c;
            case "interstitial":
                return f44404h;
            case "interactive":
                return f44403g;
            default:
                return null;
        }
    }

    public static void d(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            ConcurrentHashMap<String, ConcurrentHashMap<String, String>> concurrentHashMap2 = f44401e;
            if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(str) || (concurrentHashMap = f44401e.get(str2)) == null || !concurrentHashMap.containsKey(str2)) {
                return;
            }
            concurrentHashMap.remove(str2);
        } catch (Exception e11) {
            ad.a(f44410n, e11.getMessage());
        }
    }
}
