package com.mbridge.msdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f43021a = "j";

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, int i12, String str) {
        String strB;
        try {
            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("key", "2000112");
            dVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.g.d.f().f44642s));
            dVar.a("result", Integer.valueOf(i11));
            dVar.a("type", Integer.valueOf(i12));
            if (i12 == 0) {
                strB = b();
            } else {
                strB = com.mbridge.msdk.foundation.same.net.g.d.f().f44641r ? com.mbridge.msdk.foundation.same.net.g.d.f().H : com.mbridge.msdk.foundation.same.net.g.d.f().G;
            }
            dVar.a("url", strB);
            dVar.a("reason", str);
            bVar.a("2000112", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000112", bVar);
        } catch (Throwable th2) {
            ad.b(f43021a, th2.getMessage());
        }
    }

    public static /* synthetic */ void a(j jVar) {
        try {
            new o(com.mbridge.msdk.foundation.controller.c.m().c()).a();
        } catch (Throwable th2) {
            ad.b(f43021a, th2.getMessage());
        }
    }

    public static /* synthetic */ void a(j jVar, Context context, String str) {
        g gVarB;
        h hVarA = h.a();
        if (hVarA != null && (gVarB = hVarA.b(str)) != null) {
            MBridgeConstans.OMID_JS_SERVICE_URL = gVarB.W();
            MBridgeConstans.OMID_JS_H5_URL = gVarB.V();
        }
        com.mbridge.msdk.a.b.a(context);
        com.mbridge.msdk.a.b.b(context);
    }

    private String b() {
        String str = com.mbridge.msdk.foundation.same.net.g.d.f().f44641r ? com.mbridge.msdk.foundation.same.net.g.d.f().H : com.mbridge.msdk.foundation.same.net.g.d.f().G;
        try {
            if (!com.mbridge.msdk.foundation.same.net.g.d.f().f44641r || !com.mbridge.msdk.foundation.same.net.g.d.f().f44640q || com.mbridge.msdk.foundation.same.net.g.d.f().f44645v >= com.mbridge.msdk.foundation.same.net.g.d.f().f44646w.size()) {
                return str;
            }
            String str2 = com.mbridge.msdk.foundation.same.net.g.d.f().f44646w.get(com.mbridge.msdk.foundation.same.net.g.d.f().f44645v);
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (!str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && !str2.startsWith("https")) {
                return str;
            }
            return str2 + "/setting";
        } catch (Throwable th2) {
            ad.b(f43021a, th2.getMessage());
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final String str, final String str2) {
        if (!(!com.mbridge.msdk.foundation.same.net.g.d.f().a())) {
            a(context, str, str2);
            return;
        }
        try {
            if (com.mbridge.msdk.foundation.same.net.g.d.f().f44640q) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.g.d.f().f44640q = true;
            if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.a.a.a.a().b("mkey_spare_host_ts").longValue() + ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                String strA = com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host");
                if (!TextUtils.isEmpty(strA)) {
                    for (String str3 : strA.split("\n")) {
                        if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.g.d.f().f44643t.contains(str3.trim())) {
                            com.mbridge.msdk.foundation.same.net.g.d.f().f44643t.add(str3.trim());
                            com.mbridge.msdk.foundation.same.net.g.d.f().f44646w.add(str3.trim());
                        }
                    }
                    b(context, str, str2);
                    return;
                }
            }
            new com.mbridge.msdk.foundation.same.net.h.c(context.getApplicationContext()).get(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44625b, new com.mbridge.msdk.foundation.same.net.h.e(), new com.mbridge.msdk.foundation.same.net.c.a() { // from class: com.mbridge.msdk.c.j.2
                @Override // com.mbridge.msdk.foundation.same.net.c.a
                public final void a(String str4) {
                    com.mbridge.msdk.foundation.same.net.g.d.f().f44640q = false;
                    ad.a(j.f43021a, "fetch CNDSettingHost failed, errorCode = " + str4);
                }

                @Override // com.mbridge.msdk.foundation.same.net.c.a
                public final void b(String str4) {
                    ad.a(j.f43021a, "fetch CNDSettingHost success, content = " + str4);
                    if (TextUtils.isEmpty(str4)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host_ts", System.currentTimeMillis());
                    com.mbridge.msdk.foundation.a.a.a.a().a("mkey_spare_host", str4);
                    for (String str5 : str4.split("\n")) {
                        if (!TextUtils.isEmpty(str5.trim()) && !com.mbridge.msdk.foundation.same.net.g.d.f().f44643t.contains(str5.trim())) {
                            com.mbridge.msdk.foundation.same.net.g.d.f().f44643t.add(str5.trim());
                            com.mbridge.msdk.foundation.same.net.g.d.f().f44646w.add(str5.trim());
                        }
                    }
                    j.this.b(context, str, str2);
                }
            });
        } catch (Throwable th2) {
            com.mbridge.msdk.foundation.same.net.g.d.f().f44640q = false;
            ad.b(f43021a, th2.getMessage());
        }
    }

    public final void a(final Context context, final String str, final String str2) {
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.h.e eVar = new com.mbridge.msdk.foundation.same.net.h.e();
        eVar.a("app_id", str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            String strAx = h.a().a(str).ax();
            if (TextUtils.isEmpty(strAx)) {
                strAx = "";
            }
            eVar.a("vtag", strAx);
        } catch (Throwable th2) {
            ad.b(f43021a, th2.getMessage());
        }
        if (com.mbridge.msdk.foundation.same.net.g.d.f().f44640q) {
            eVar.a("st_net", com.mbridge.msdk.foundation.same.net.g.d.f().f44642s + "");
        }
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d() { // from class: com.mbridge.msdk.c.j.1
            @Override // com.mbridge.msdk.foundation.same.net.h.d
            public final void a(String str3) {
                try {
                    j.this.a(2, 0, str3);
                } catch (Throwable th3) {
                    ad.b(j.f43021a, th3.getMessage());
                }
                if (com.mbridge.msdk.foundation.same.net.g.d.f().f44641r) {
                    com.mbridge.msdk.foundation.same.net.g.d.f().f44645v++;
                } else {
                    com.mbridge.msdk.foundation.same.net.g.d.f().f44644u++;
                }
                j.this.b(context, str, str2);
                j.a(j.this);
                ad.b(j.f43021a, "get app setting error" + str3);
            }

            @Override // com.mbridge.msdk.foundation.same.net.h.d
            public final void a(JSONObject jSONObject) {
                try {
                    j.this.a(1, 0, "");
                } catch (Throwable th3) {
                    ad.b(j.f43021a, th3.getMessage());
                }
                try {
                    if (ai.a(jSONObject)) {
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strG = h.a().g(str);
                            if (!TextUtils.isEmpty(strG)) {
                                try {
                                    jSONObject = h.a().a(new JSONObject(strG), jSONObject);
                                } catch (Exception e11) {
                                    ad.b(j.f43021a, e11.getMessage());
                                }
                            }
                        }
                        jSONObject.put("current_time", System.currentTimeMillis());
                        if (com.mbridge.msdk.foundation.same.net.g.d.f().f44641r) {
                            if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                                jSONObject.put("hst_st_t", com.mbridge.msdk.foundation.same.net.g.d.f().f44635l);
                            }
                        } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                            jSONObject.put("hst_st", com.mbridge.msdk.foundation.same.net.g.d.f().f44631h);
                        }
                        h.a().g(str, jSONObject.toString());
                        com.mbridge.msdk.foundation.same.net.g.d.f().e();
                        try {
                            if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                                com.mbridge.msdk.c.b.a.a().a(context, jSONObject.optString("mraid_js"));
                            }
                        } catch (Exception e12) {
                            ad.b(j.f43021a, e12.getMessage());
                        }
                        if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                            com.mbridge.msdk.c.b.b.a().a(context, jSONObject.optString("web_env_url"));
                        }
                        j.a(j.this, context, str);
                    } else {
                        h.a().f(str);
                    }
                    j.a(j.this);
                } catch (Exception e13) {
                    ad.b(j.f43021a, e13.getMessage());
                }
            }
        };
        com.mbridge.msdk.c.a.c cVar = new com.mbridge.msdk.c.a.c(context);
        String str3 = com.mbridge.msdk.foundation.same.net.g.d.f().G;
        try {
            if (com.mbridge.msdk.foundation.same.net.g.d.f().f44641r && com.mbridge.msdk.foundation.same.net.g.d.f().f44640q && com.mbridge.msdk.foundation.same.net.g.d.f().f44645v < com.mbridge.msdk.foundation.same.net.g.d.f().f44646w.size()) {
                String str4 = com.mbridge.msdk.foundation.same.net.g.d.f().f44646w.get(com.mbridge.msdk.foundation.same.net.g.d.f().f44645v);
                if (!TextUtils.isEmpty(str4) && (str4.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || str4.startsWith("https"))) {
                    str3 = str4 + "/setting";
                }
            }
        } catch (Throwable th3) {
            ad.b(f43021a, th3.getMessage());
        }
        cVar.get(1, str3, eVar, dVar);
        a(3, 0, "");
    }

    public final void a(Context context, final String str, String str2, final String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.c.m().k();
            str2 = com.mbridge.msdk.foundation.controller.c.m().b();
        }
        if (h.a().e(str3, str) && h.a().a(str, 2, str3)) {
            com.mbridge.msdk.foundation.same.net.h.e eVar = new com.mbridge.msdk.foundation.same.net.h.e();
            String str4 = "[" + str3 + "]";
            eVar.a("unit_ids", str4);
            eVar.a("app_id", str);
            eVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String strT = h.a().c(str, str4).t();
                if (TextUtils.isEmpty(strT)) {
                    strT = "";
                }
                eVar.a("vtag", strT);
            } catch (Throwable th2) {
                ad.b(f43021a, th2.getMessage());
            }
            new com.mbridge.msdk.c.a.c(context).get(1, com.mbridge.msdk.foundation.same.net.g.d.f().G, eVar, new com.mbridge.msdk.foundation.same.net.h.d() { // from class: com.mbridge.msdk.c.j.3
                @Override // com.mbridge.msdk.foundation.same.net.h.d
                public final void a(String str5) {
                    j.this.a(2, 1, "");
                }

                @Override // com.mbridge.msdk.foundation.same.net.h.d
                public final void a(JSONObject jSONObject) {
                    try {
                        if (ai.a(jSONObject)) {
                            String strOptString = jSONObject.optString("vtag", "");
                            String strOptString2 = jSONObject.optString("rid", "");
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
                                if (jSONObject.optInt("vtag_status", 0) == 1) {
                                    h.a();
                                    String strA = com.mbridge.msdk.foundation.a.a.a.a().a(str + "_" + str3);
                                    if (!TextUtils.isEmpty(strA)) {
                                        try {
                                            jSONObjectOptJSONObject = h.a().a(new JSONObject(strA), jSONObjectOptJSONObject);
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                                jSONObjectOptJSONObject.put("current_time", System.currentTimeMillis());
                                jSONObjectOptJSONObject.put("vtag", strOptString);
                                jSONObjectOptJSONObject.put("rid", strOptString2);
                                h.a().a(str, str3, jSONObjectOptJSONObject.toString());
                            }
                        } else {
                            h.a().h(str, str3);
                        }
                        j.this.a(1, 1, "");
                    } catch (Exception e12) {
                        ad.b(j.f43021a, e12.getMessage());
                    }
                }
            });
            a(3, 1, "");
        }
    }
}
