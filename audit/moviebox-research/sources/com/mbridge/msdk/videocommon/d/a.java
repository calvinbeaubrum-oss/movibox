package com.mbridge.msdk.videocommon.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f48461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.videocommon.b.c> f48462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f48463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f48464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f48465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f48466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f48467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f48468h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f48470j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f48469i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f48471k = "";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f48472l = "";

    public static a a(String str) {
        a aVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                a aVar2 = new a();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("caplist");
                    aVar2.f48470j = jSONObject.optString("ab_id", "");
                    aVar2.f48472l = jSONObject.optString("rid", "");
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        HashMap map = new HashMap();
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys != null && itKeys.hasNext()) {
                            String next = itKeys.next();
                            int iIntValue = Integer.valueOf(jSONObjectOptJSONObject.optInt(next, 1000)).intValue();
                            if (!TextUtils.isEmpty(next)) {
                                if (TextUtils.isEmpty(next) || iIntValue != 0) {
                                    map.put(next, Integer.valueOf(iIntValue));
                                } else {
                                    map.put(next, 1000);
                                }
                            }
                        }
                        aVar2.f48461a = map;
                    }
                    aVar2.f48462b = com.mbridge.msdk.videocommon.b.c.a(jSONObject.optJSONArray("reward"));
                    aVar2.f48463c = jSONObject.optLong("getpf", 43200L);
                    aVar2.f48464d = jSONObject.optLong("ruct", 5400L);
                    aVar2.f48465e = jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L);
                    aVar2.f48466f = jSONObject.optLong("dlct", 3600L);
                    aVar2.f48467g = jSONObject.optLong("vcct", 5L);
                    aVar2.f48468h = jSONObject.optLong("current_time");
                    aVar2.f48471k = jSONObject.optString("vtag", "");
                    return aVar2;
                } catch (Exception e11) {
                    e = e11;
                    aVar = aVar2;
                    e.printStackTrace();
                    return aVar;
                }
            } catch (Exception e12) {
                e = e12;
            }
        }
        return aVar;
    }

    public final String a() {
        return this.f48471k;
    }

    public final void a(int i11) {
        this.f48469i = i11;
    }

    public final void a(long j11) {
        this.f48463c = j11;
    }

    public final void a(Map<String, Integer> map) {
        this.f48461a = map;
    }

    public final String b() {
        return this.f48470j;
    }

    public final void b(long j11) {
        this.f48464d = j11;
    }

    public final void b(Map<String, com.mbridge.msdk.videocommon.b.c> map) {
        this.f48462b = map;
    }

    public final String c() {
        return this.f48472l;
    }

    public final void c(long j11) {
        this.f48465e = j11;
    }

    public final long d() {
        return this.f48463c * 1000;
    }

    public final void d(long j11) {
        this.f48466f = j11;
    }

    public final long e() {
        return this.f48464d * 1000;
    }

    public final void e(long j11) {
        this.f48467g = j11;
    }

    public final long f() {
        return this.f48465e * 1000;
    }

    public final long g() {
        return this.f48466f;
    }

    public final long h() {
        return this.f48467g;
    }

    public final long i() {
        return this.f48468h;
    }

    public final Map<String, com.mbridge.msdk.videocommon.b.c> j() {
        return this.f48462b;
    }

    public final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.f48461a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.f48461a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            Map<String, com.mbridge.msdk.videocommon.b.c> map2 = this.f48462b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.mbridge.msdk.videocommon.b.c> entry2 : this.f48462b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.mbridge.msdk.videocommon.b.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.a());
                            jSONObject3.put("amount", value.b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.f48463c);
            jSONObject.put("ruct", this.f48464d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.f48465e);
            jSONObject.put("dlct", this.f48466f);
            jSONObject.put("vcct", this.f48467g);
            jSONObject.put("current_time", this.f48468h);
            jSONObject.put("vtag", this.f48471k);
            jSONObject.put("isDefault", this.f48469i);
            return jSONObject;
        } catch (Exception e13) {
            e13.printStackTrace();
            return jSONObject;
        }
    }
}
