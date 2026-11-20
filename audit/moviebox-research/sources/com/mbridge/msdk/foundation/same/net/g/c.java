package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f44610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f44611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f44612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f44613d;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f44614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f44615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f44616c;

        public a(long j11, int i11, String str) {
            this.f44616c = j11;
            this.f44614a = i11;
            this.f44615b = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f44617a = new c();
    }

    private c() {
        this.f44610a = "IDErrorUtil";
        this.f44612c = new ConcurrentHashMap<>();
        this.f44613d = new ArrayList<>();
        g gVarB = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB == null) {
            h.a();
            gVarB = i.a();
        }
        this.f44611b = gVarB.x() * 1000;
        if (gVarB.B() == null || gVarB.B().size() <= 0) {
            ad.b("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
            this.f44613d.addAll(Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616));
        } else {
            ad.b("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
            this.f44613d.addAll(gVarB.B());
        }
    }

    private synchronized a a(String str) {
        a aVar;
        ad.b("IDErrorUtil", "getErrorInfo : " + str);
        if (!this.f44612c.containsKey(str) || (aVar = this.f44612c.get(str)) == null) {
            return null;
        }
        if (aVar.f44614a == -1) {
            return aVar;
        }
        if (System.currentTimeMillis() <= aVar.f44616c + ((long) this.f44611b)) {
            ad.b("IDErrorUtil", "getErrorInfo : " + aVar.f44615b);
            return aVar;
        }
        this.f44612c.remove(str);
        if (this.f44612c.size() > 0) {
            for (Map.Entry<String, a> entry : this.f44612c.entrySet()) {
                ad.b("IDErrorUtil", "getErrorInfo : delete timeout entry");
                if (System.currentTimeMillis() - entry.getValue().f44616c > this.f44611b) {
                    this.f44612c.remove(entry.getKey());
                }
            }
        }
        return null;
    }

    public static c a() {
        return b.f44617a;
    }

    private k b(String str, String str2, String str3, String str4, String str5) {
        int i11;
        String str6 = str + "_" + str3 + "_" + str2 + "_" + str5;
        a aVarA = a(str6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mbridge.msdk.foundation.same.net.d.b("data_res_type", "1"));
        if (aVarA != null && !TextUtils.isEmpty(aVarA.f44615b)) {
            try {
                if (aVarA.f44614a != -1) {
                    return k.a(new JSONObject(aVarA.f44615b), new com.mbridge.msdk.foundation.same.net.f.c(200, aVarA.f44615b.getBytes(), arrayList));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (str5 != null && !TextUtils.isEmpty(str5) && (i11 = Integer.parseInt(str5)) != 287 && i11 != 94) {
                    if (System.currentTimeMillis() < ((long) (h.a().a(str, str2).n() * 1000)) + aVarA.f44616c) {
                        return k.a(new JSONObject(aVarA.f44615b), new com.mbridge.msdk.foundation.same.net.f.c(200, aVarA.f44615b.getBytes(), arrayList));
                    }
                    this.f44612c.remove(str6);
                    return null;
                }
            } catch (Exception e11) {
                ad.b("IDErrorUtil", e11.getMessage());
            }
        }
        ad.b("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }

    public final k a(e eVar) {
        String str = eVar.a().get("app_id");
        String str2 = eVar.a().get("placement_id");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String str3 = str2;
        return b(str, eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID), str3, eVar.a().get("token"), eVar.a().get("ad_type"));
    }

    public final k a(String str, String str2, String str3, String str4, String str5) {
        return b(str, str2, str3, str4, str5);
    }

    public final synchronized void a(String str, int i11, String str2, long j11) {
        if (this.f44612c.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f44613d.contains(Integer.valueOf(i11))) {
            ad.b("IDErrorUtil", "addErrorInfo : " + str + " " + str2);
            this.f44612c.put(str, new a(j11, i11, str2));
        }
    }
}
