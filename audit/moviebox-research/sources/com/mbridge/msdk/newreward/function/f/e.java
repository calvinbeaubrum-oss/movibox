package com.mbridge.msdk.newreward.function.f;

import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.a.b.k;
import com.mbridge.msdk.newreward.a.b.l;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f46480a = com.mbridge.msdk.foundation.controller.c.m().k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f46481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f46483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f46484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f46485f;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.c.e eVar, int i11, String str) {
        int i12;
        try {
            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("key", "2000112");
            dVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.g.d.f().f44642s));
            if (eVar == com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_START) {
                i12 = 3;
            } else if (eVar == com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_SUCCESS) {
                i12 = 1;
            } else {
                i12 = eVar == com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_FAIL ? 2 : 0;
            }
            dVar.a("result", Integer.valueOf(i12));
            dVar.a("type", Integer.valueOf(i11));
            dVar.a("url", com.mbridge.msdk.foundation.same.net.g.d.f().f44641r ? com.mbridge.msdk.foundation.same.net.g.d.f().J : com.mbridge.msdk.foundation.same.net.g.d.f().I);
            dVar.a("reason", str);
            bVar.a("2000112", dVar);
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000112", bVar);
        } catch (Throwable th2) {
            ad.b("SettingModel", th2.getMessage());
        }
    }

    public final com.mbridge.msdk.videocommon.d.a a() {
        return this.f46484e;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        try {
            if (TextUtils.isEmpty(this.f46481b) && (obj instanceof com.mbridge.msdk.newreward.function.g.c)) {
                this.f46481b = ((com.mbridge.msdk.newreward.function.g.c) obj).b();
            }
        } catch (Throwable th2) {
            ad.b("SettingModel", th2.getMessage());
        }
        try {
            this.f46483d = h.a().a(this.f46480a);
            com.mbridge.msdk.videocommon.d.a aVarE = com.mbridge.msdk.videocommon.d.b.a().e();
            this.f46484e = aVarE;
            if (aVarE == null) {
                this.f46484e = com.mbridge.msdk.videocommon.d.b.a().c();
            }
            com.mbridge.msdk.videocommon.d.c cVarE = com.mbridge.msdk.videocommon.d.b.a().e(this.f46480a, this.f46481b);
            this.f46485f = cVarE;
            if (cVarE == null) {
                this.f46485f = com.mbridge.msdk.videocommon.d.b.a().b(this.f46482c == 287);
            } else {
                com.mbridge.msdk.videocommon.d.b.a().c(this.f46481b);
            }
            bVar.a(this);
            if (obj instanceof com.mbridge.msdk.newreward.function.g.c) {
                com.mbridge.msdk.newreward.function.g.c cVar = (com.mbridge.msdk.newreward.function.g.c) obj;
                com.mbridge.msdk.videocommon.d.a aVar = this.f46484e;
                if (aVar != null) {
                    if (this.f46484e.i() + aVar.d() <= System.currentTimeMillis()) {
                        try {
                            new k().a(cVar, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.f.e.1
                                @Override // com.mbridge.msdk.newreward.a.b.b
                                public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
                                    e.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_FAIL, 2, bVar2.b());
                                }

                                @Override // com.mbridge.msdk.newreward.a.b.b
                                public final void a(Object obj2) {
                                    if (obj2 instanceof com.mbridge.msdk.videocommon.d.a) {
                                        e.this.f46484e = (com.mbridge.msdk.videocommon.d.a) obj2;
                                    }
                                    e.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_SUCCESS, 2, "");
                                }
                            });
                            a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_START, 2, "");
                        } catch (IOException e11) {
                            ad.b("SettingModel", e11.getMessage());
                        }
                    }
                } else {
                    new k().a(cVar, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.f.e.1
                        @Override // com.mbridge.msdk.newreward.a.b.b
                        public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
                            e.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_FAIL, 2, bVar2.b());
                        }

                        @Override // com.mbridge.msdk.newreward.a.b.b
                        public final void a(Object obj2) {
                            if (obj2 instanceof com.mbridge.msdk.videocommon.d.a) {
                                e.this.f46484e = (com.mbridge.msdk.videocommon.d.a) obj2;
                            }
                            e.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_SUCCESS, 2, "");
                        }
                    });
                    a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_START, 2, "");
                }
                com.mbridge.msdk.videocommon.d.a aVar2 = this.f46484e;
                if (aVar2 != null && this.f46485f != null) {
                    if (this.f46485f.x() + aVar2.e() > System.currentTimeMillis()) {
                        return;
                    }
                }
                try {
                    new l().a(cVar, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.f.e.2
                        @Override // com.mbridge.msdk.newreward.a.b.b
                        public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
                            e.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_FAIL, 3, bVar2.b());
                        }

                        @Override // com.mbridge.msdk.newreward.a.b.b
                        public final void a(Object obj2) {
                            if (obj2 instanceof com.mbridge.msdk.videocommon.d.c) {
                                e.this.f46485f = (com.mbridge.msdk.videocommon.d.c) obj2;
                            }
                            com.mbridge.msdk.videocommon.d.b.a().c(e.this.f46481b);
                            e.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_SUCCESS, 3, "");
                        }
                    });
                    a(com.mbridge.msdk.newreward.function.c.e.REPORT_SETTING_REQUEST_START, 3, "");
                } catch (IOException e12) {
                    ad.b("SettingModel", e12.getMessage());
                }
            }
        } catch (Throwable th3) {
            bVar.a(new com.mbridge.msdk.foundation.c.b(880000, "fetch setting fail : " + th3.getMessage()));
        }
    }

    public final com.mbridge.msdk.videocommon.d.c b() {
        return this.f46485f;
    }
}
