package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.transsion.api.gateway.utils.SafeStringUtils;
import java.io.File;
import java.net.URLEncoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44889a = "o";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f44890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44891c;

    public o(Context context) {
        this.f44891c = 0;
        this.f44890b = context.getApplicationContext();
    }

    public o(Context context, int i11) {
        this.f44890b = context;
        this.f44891c = i11;
    }

    public final void a() {
        try {
            if (q.a()) {
                com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(strK);
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = com.mbridge.msdk.c.i.a();
                }
                int iK = gVarB.K();
                String str = "key=2000053&Appid=" + strK + "&uptips2=" + gVarB.at() + "&info_status=" + com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().h() + "&iseu=" + iK;
                String strC = com.mbridge.msdk.foundation.tools.e.c();
                if (!TextUtils.isEmpty(strC)) {
                    str = str + "&gaid=" + strC;
                }
                String str2 = str + "&GDPR_area=" + gVarB.aG() + "&GDPR_consent=" + com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().g();
                if (j.a().b()) {
                    j.a().a(str2);
                    return;
                }
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(str2, this.f44890b, ""), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.6
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str3) {
                    }
                });
                q.b();
            }
        } catch (Throwable th2) {
            ad.b(f44889a, th2.getMessage());
        }
    }

    public final void a(int i11, int i12, String str, String str2, String str3) {
        Context context = this.f44890b;
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(context);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000058", "utf-8"));
            sb2.append("&");
            sb2.append(SafeStringUtils.SP_APPID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(com.mbridge.msdk.foundation.controller.c.m().k(), "utf-8"));
            sb2.append("&");
            sb2.append("dl_type");
            sb2.append("=");
            sb2.append(URLEncoder.encode(i11 + "", "utf-8"));
            sb2.append("&");
            sb2.append("dl_link_type");
            sb2.append("=");
            sb2.append(URLEncoder.encode(i12 + "", "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str, "utf-8"));
            sb2.append("&");
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str2, "utf-8"));
            sb2.append("&");
            sb2.append(BidResponsedEx.KEY_CID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str3, "utf-8"));
            sb2.append("&");
            sb2.append("tgt_v");
            sb2.append("=");
            sb2.append(URLEncoder.encode(z.t(context) + "", "utf-8"));
            sb2.append("&");
            sb2.append("app_v_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(z.p(context) + "", "utf-8"));
            sb2.append("&");
            sb2.append("app_v_c");
            sb2.append("=");
            sb2.append(URLEncoder.encode(z.q(context) + "", "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(sb2.toString(), context, ""), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.p.1
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str4) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str4) {
                    }
                });
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("ReportControllerDiff", e11.getMessage());
            }
        }
    }

    public final void a(int i11, String str) {
        new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(NotificationCompat.CATEGORY_EVENT, q.a((Campaign) null, i11, PermissionConstant.ACTION_REQUEST), this.f44890b, str), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.7
            @Override // com.mbridge.msdk.foundation.same.report.e.b
            public final void onFailed(String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.report.e.b
            public final void onSuccess(String str2) {
            }
        });
    }

    public final void a(com.mbridge.msdk.foundation.entity.l lVar) {
    }

    public final void a(final com.mbridge.msdk.foundation.entity.l lVar, final Boolean bool) {
        if (lVar != null) {
            if (lVar.b().equals("GET")) {
                new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b).get(0, lVar.f(), null, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.3
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str) {
                        com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.o.3.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    if (o.this.f44890b != null) {
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        if (lVar == null) {
                                            return;
                                        }
                                        com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(o.this.f44890b)).a(lVar.f());
                                        if (!bool.booleanValue() || com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(o.this.f44890b)).b() <= 20) {
                                            return;
                                        }
                                        com.mbridge.msdk.foundation.controller.d.a().b();
                                    }
                                } catch (Exception e11) {
                                    if (MBridgeConstans.DEBUG) {
                                        ad.a(o.f44889a, "reportNetError", e11);
                                    }
                                }
                            }
                        });
                    }
                });
                return;
            }
            if (lVar.b().equals("POST")) {
                com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
                if (TextUtils.isEmpty(lVar.a())) {
                    return;
                }
                com.mbridge.msdk.foundation.same.net.h.e eVarA = q.a(lVar.a(), this.f44890b, lVar.e());
                if (lVar.d() > 0) {
                    eVarA.a("retry", lVar.d() + "");
                }
                aVar.post(0, lVar.f(), eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.4
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str) {
                        com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.o.4.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (o.this.f44890b != null) {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    if (lVar == null) {
                                        return;
                                    }
                                    com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(o.this.f44890b)).a(lVar);
                                }
                            }
                        });
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str) {
                        com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.o.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (o.this.f44890b != null) {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    if (lVar == null) {
                                        return;
                                    }
                                    try {
                                        com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(o.this.f44890b)).a(lVar.a(), lVar.f(), lVar.c());
                                        if (!bool.booleanValue() || com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(o.this.f44890b)).a() <= 0) {
                                            return;
                                        }
                                        com.mbridge.msdk.foundation.controller.d.a().b();
                                    } catch (Exception e11) {
                                        if (MBridgeConstans.DEBUG) {
                                            ad.a(o.f44889a, "reportNetError", e11);
                                        }
                                    }
                                }
                            }
                        });
                    }
                });
            }
        }
    }

    public final void a(String str, com.mbridge.msdk.foundation.entity.e eVar, String str2) {
        com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
        String strA = com.mbridge.msdk.foundation.entity.e.a(eVar);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        if (j.a().b()) {
            j.a().a(strA);
        } else {
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(strA, this.f44890b, str2), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.9
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(String str3) {
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str3) {
                }
            });
        }
    }

    public final void a(String str, final File file) {
        new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(this.f44890b, str), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.11
            @Override // com.mbridge.msdk.foundation.same.report.e.b
            public final void onFailed(String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.report.e.b
            public final void onSuccess(String str2) {
                File file2 = file;
                if (file2 != null) {
                    file2.delete();
                }
            }
        });
    }

    public final void a(String str, String str2, String str3) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
            String str4 = "click_type=" + URLEncoder.encode("1", "utf-8") + "&" + BidResponsedEx.KEY_CID + "=" + URLEncoder.encode(str, "utf-8") + "&" + MBridgeConstans.PROPERTIES_UNIT_ID + "=" + URLEncoder.encode(str2, "utf-8") + "&key=" + URLEncoder.encode("2000027", "utf-8") + "&http_url=" + URLEncoder.encode(str3, "utf-8");
            if (j.a().b()) {
                j.a().a(str4);
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(str4, this.f44890b, str2), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.8
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str5) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str5) {
                    }
                });
            }
        } catch (Exception e11) {
            ad.b(f44889a, e11.getMessage());
        }
    }

    public final void a(final String str, String str2, String str3, Frame frame) {
        com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
        com.mbridge.msdk.foundation.same.net.h.e eVarA = q.a(str2, this.f44890b, str3);
        if (frame != null) {
            eVarA.a("session_id", frame.getSessionId());
            eVarA.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_PARENT_SESSION_ID, frame.getParentSessionId());
        }
        aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.10
            @Override // com.mbridge.msdk.foundation.same.report.e.b
            public final void onFailed(String str4) {
            }

            @Override // com.mbridge.msdk.foundation.same.report.e.b
            public final void onSuccess(String str4) {
                if ("click_duration".equals(str) || "load_duration".equals(str)) {
                    com.mbridge.msdk.foundation.same.f.b.g().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.o.10.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.foundation.controller.d.a().b();
                        }
                    });
                }
            }
        });
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
            StringBuilder sb2 = new StringBuilder();
            int iL = z.l(this.f44890b);
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000071", "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str, "utf-8"));
            sb2.append("&");
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str2, "utf-8"));
            sb2.append("&");
            sb2.append(BidResponsedEx.KEY_CID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str3, "utf-8"));
            sb2.append("&");
            sb2.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str4, "utf-8"));
            sb2.append("&");
            sb2.append("reason");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str5, "utf-8"));
            sb2.append("&");
            sb2.append("network_type");
            sb2.append("=");
            sb2.append(URLEncoder.encode(iL + "", "utf-8"));
            sb2.append("&");
            sb2.append("result");
            sb2.append("=");
            sb2.append(URLEncoder.encode("0", "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(sb2.toString(), this.f44890b, str4), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.5
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str6) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str6) {
                    }
                });
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z11) {
        try {
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
            StringBuilder sb2 = new StringBuilder();
            if (z11) {
                sb2.append("hb=");
                sb2.append(1);
                sb2.append("&");
            }
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000065", "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str, "utf-8"));
            sb2.append("&");
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str2, "utf-8"));
            sb2.append("&");
            sb2.append(BidResponsedEx.KEY_CID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str3, "utf-8"));
            sb2.append("&");
            sb2.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str4, "utf-8"));
            sb2.append("&");
            sb2.append(CampaignEx.JSON_KEY_CLICK_URL);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str5, "utf-8"));
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(sb2.toString(), this.f44890b, str4), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.1
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str6) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str6) {
                    }
                });
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void b(String str, String str2, String str3, String str4, String str5, boolean z11) {
        try {
            if (TextUtils.isEmpty(str5)) {
                return;
            }
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(this.f44890b);
            StringBuilder sb2 = new StringBuilder();
            if (z11) {
                sb2.append("hb=");
                sb2.append(1);
                sb2.append("&");
            }
            sb2.append("key");
            sb2.append("=");
            sb2.append(URLEncoder.encode("2000066", "utf-8"));
            sb2.append("&");
            sb2.append("rid");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str, "utf-8"));
            sb2.append("&");
            sb2.append("rid_n");
            sb2.append("=");
            sb2.append(URLEncoder.encode(str2, "utf-8"));
            sb2.append("&");
            sb2.append(BidResponsedEx.KEY_CID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str3, "utf-8"));
            sb2.append("&");
            sb2.append(MBridgeConstans.PROPERTIES_UNIT_ID);
            sb2.append("=");
            sb2.append(URLEncoder.encode(str4, "utf-8"));
            sb2.append("&");
            sb2.append("err_method");
            sb2.append("=");
            sb2.append(str5);
            if (j.a().b()) {
                j.a().a(sb2.toString());
            } else {
                aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, q.a(sb2.toString(), this.f44890b, str4), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.o.2
                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onFailed(String str6) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.e.b
                    public final void onSuccess(String str6) {
                    }
                });
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }
}
