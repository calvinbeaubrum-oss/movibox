package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f48453a = "com.mbridge.msdk.videocommon.c.a";

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, int i12, String str) {
        try {
            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            d dVar = new d();
            dVar.a("key", "2000112");
            dVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.g.d.f().f44642s));
            dVar.a("result", Integer.valueOf(i11));
            dVar.a("type", Integer.valueOf(i12));
            dVar.a("url", com.mbridge.msdk.foundation.same.net.g.d.f().f44641r ? com.mbridge.msdk.foundation.same.net.g.d.f().J : com.mbridge.msdk.foundation.same.net.g.d.f().I);
            dVar.a("reason", str);
            bVar.a("2000112", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000112", bVar);
        } catch (Throwable th2) {
            ad.b(f48453a, th2.getMessage());
        }
    }

    public final void a(Context context, final String str, String str2) {
        e eVar = new e();
        eVar.a("app_id", str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            com.mbridge.msdk.videocommon.d.a aVarE = com.mbridge.msdk.videocommon.d.b.a().e();
            if (aVarE == null) {
                eVar.a("vtag", "");
            } else {
                String strA = aVarE.a();
                if (TextUtils.isEmpty(strA)) {
                    strA = "";
                }
                eVar.a("vtag", strA);
            }
        } catch (Throwable th2) {
            ad.b(f48453a, th2.getMessage());
        }
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.g.d.f().I, eVar, new com.mbridge.msdk.foundation.same.net.h.d() { // from class: com.mbridge.msdk.videocommon.c.a.1
            @Override // com.mbridge.msdk.foundation.same.net.h.d
            public final void a(String str3) {
                com.mbridge.msdk.videocommon.d.b.a().a(false);
                ad.b(a.f48453a, str3);
                a.this.a(2, 2, str3);
            }

            @Override // com.mbridge.msdk.foundation.same.net.h.d
            public final void a(JSONObject jSONObject) {
                try {
                    if (ai.a(jSONObject)) {
                        com.mbridge.msdk.videocommon.d.b.a().a(false);
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strG = com.mbridge.msdk.videocommon.d.b.a().g(str);
                            if (!TextUtils.isEmpty(strG)) {
                                try {
                                    jSONObject = h.a().a(new JSONObject(strG), jSONObject);
                                } catch (Exception e11) {
                                    ad.b(a.f48453a, e11.getMessage());
                                }
                            }
                        }
                        try {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            com.mbridge.msdk.videocommon.d.b.a().b(str, jSONObject.toString());
                        } catch (JSONException e12) {
                            ad.b(a.f48453a, e12.getMessage());
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().f(str);
                    }
                    a.this.a(1, 2, "");
                } catch (Throwable th3) {
                    ad.b(a.f48453a, th3.getMessage());
                }
            }
        });
        a(3, 2, "");
    }

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        e eVar = new e();
        eVar.a("app_id", str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        eVar.a("unit_ids", "[" + str3 + "]");
        try {
            com.mbridge.msdk.videocommon.d.c cVarE = com.mbridge.msdk.videocommon.d.b.a().e(str, str3);
            if (cVarE == null) {
                eVar.a("vtag", "");
            } else {
                String strJ = cVarE.j();
                if (TextUtils.isEmpty(strJ)) {
                    strJ = "";
                }
                eVar.a("vtag", strJ);
            }
        } catch (Throwable th2) {
            ad.b(f48453a, th2.getMessage());
        }
        com.mbridge.msdk.foundation.same.net.h.d dVar = new com.mbridge.msdk.foundation.same.net.h.d() { // from class: com.mbridge.msdk.videocommon.c.a.2
            @Override // com.mbridge.msdk.foundation.same.net.h.d
            public final void a(String str4) {
                try {
                    com.mbridge.msdk.videocommon.d.b.a().b(this.unitId);
                } catch (Exception e11) {
                    ad.b(a.f48453a, e11.getMessage());
                }
                if (TextUtils.isEmpty(str4)) {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.b("request error");
                    }
                } else {
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.b(str4);
                    }
                }
                a.this.a(2, 3, str4);
            }

            @Override // com.mbridge.msdk.foundation.same.net.h.d
            public final void a(final JSONObject jSONObject) {
                try {
                    try {
                        com.mbridge.msdk.videocommon.d.b.a().b(this.unitId);
                    } catch (Exception e11) {
                        ad.b(a.f48453a, e11.getMessage());
                    }
                    if (ai.a(jSONObject)) {
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String strD = com.mbridge.msdk.videocommon.d.b.a().d(str, this.unitId);
                            if (!TextUtils.isEmpty(strD)) {
                                try {
                                    jSONObject = h.a().a(new JSONObject(strD), jSONObject);
                                } catch (Exception e12) {
                                    ad.b(a.f48453a, e12.getMessage());
                                }
                            }
                        }
                        if (com.mbridge.msdk.videocommon.d.b.e(jSONObject.toString())) {
                            jSONObject.put("current_time", System.currentTimeMillis());
                            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.videocommon.c.a.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.mbridge.msdk.videocommon.d.b bVarA = com.mbridge.msdk.videocommon.d.b.a();
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    bVarA.a(str, anonymousClass2.unitId, jSONObject.toString());
                                }
                            };
                            com.mbridge.msdk.foundation.controller.d.a();
                            com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
                            c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.a("request success");
                            }
                        } else {
                            c cVar3 = cVar;
                            if (cVar3 != null) {
                                cVar3.b("data error");
                            }
                        }
                    } else {
                        com.mbridge.msdk.videocommon.d.b.a().c(str, this.unitId);
                    }
                    a.this.a(1, 3, "");
                } catch (Throwable th3) {
                    ad.b(a.f48453a, th3.getMessage());
                }
            }
        };
        dVar.setUnitId(str3);
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.g.d.f().I, eVar, dVar);
        a(3, 3, "");
    }
}
