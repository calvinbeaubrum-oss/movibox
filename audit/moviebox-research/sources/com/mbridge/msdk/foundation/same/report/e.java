package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e implements n {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends com.mbridge.msdk.foundation.same.report.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f44851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f44852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.foundation.same.net.h.e f44853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f44854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final b.InterfaceC0492b f44855e;

        private a(Context context, b.InterfaceC0492b interfaceC0492b, b bVar, com.mbridge.msdk.foundation.same.net.h.e eVar) {
            this.f44851a = context;
            this.f44855e = interfaceC0492b;
            this.f44854d = bVar;
            this.f44853c = eVar;
            this.f44852b = bVar.m();
        }

        @Override // com.mbridge.msdk.foundation.same.report.e.b
        public final void onFailed(String str) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CommonReport", "report failed: " + str + " and isRetry = " + this.f44852b);
            }
            b bVar = this.f44854d;
            if (bVar == null || !this.f44852b || this.f44851a == null) {
                return;
            }
            final String strD = bVar.d();
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            final long j11 = this.f44854d.j();
            if (j11 <= 0) {
                j11 = System.currentTimeMillis();
            }
            final Context context = this.f44851a;
            this.f44854d.p().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.e.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (TextUtils.isEmpty(strD) || context == null) {
                        return;
                    }
                    try {
                        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l();
                        lVar.a(strD);
                        lVar.a(j11);
                        lVar.a(0);
                        lVar.b("POST");
                        lVar.c(com.mbridge.msdk.foundation.same.net.g.d.f().f44626c);
                        com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("CommonReport", "createReportDataThread error: " + e11.getMessage());
                        }
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.same.report.e.b
        public final void onSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonReport", "report success: " + str);
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.same.report.n
    public final void a(Context context, b.InterfaceC0492b interfaceC0492b, b bVar, com.mbridge.msdk.foundation.same.net.h.e eVar) throws Exception {
        if (bVar == null || eVar == null) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CommonReport", "reportEvent or params or reportEvent is null");
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(context);
        if (bVar.i() == null) {
            new com.mbridge.msdk.foundation.same.net.b();
        }
        if (bVar.l()) {
            if (!j.a().b() || TextUtils.isEmpty(bVar.d())) {
                aVar.postFocusReport(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, eVar, new a(context, interfaceC0492b, bVar, eVar));
            } else {
                j.a().a(bVar.d());
            }
        } else if (!j.a().b() || TextUtils.isEmpty(bVar.d())) {
            aVar.post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, eVar, new a(context, interfaceC0492b, bVar, eVar));
        } else {
            j.a().a(bVar.d());
        }
        if (MBridgeConstans.DEBUG) {
            ad.a("CommonReport", "report: key = " + bVar.h() + " retry = " + bVar.m() + " isFocusReport = " + bVar.l() + " isTimer = " + bVar.n() + "\ndata = " + bVar.d());
        }
    }
}
