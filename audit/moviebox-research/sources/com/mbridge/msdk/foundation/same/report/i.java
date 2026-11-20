package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.e.m f44861a;

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.mbridge.msdk.foundation.same.report.n
    public final void a(Context context, b.InterfaceC0492b interfaceC0492b, b bVar, com.mbridge.msdk.foundation.same.net.h.e eVar) throws Exception {
        com.mbridge.msdk.c.k kVarD;
        if (this.f44861a == null) {
            this.f44861a = l.a().d();
        }
        if (this.f44861a == null) {
            return;
        }
        if (bVar == null) {
            ad.b("EventLibraryReport", "reportEvent is null, report failed");
            if (interfaceC0492b != null) {
                interfaceC0492b.a(null, 0, "reportEvent is null");
                return;
            }
            return;
        }
        try {
            String strD = bVar.d();
            com.mbridge.msdk.e.e eVar2 = new com.mbridge.msdk.e.e(bVar.h());
            JSONObject jSONObjectA = a(strD);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            }
            try {
                long[] jArrG = this.f44861a.g();
                jSONObjectA.put("track_time", jArrG[0]);
                jSONObjectA.put("track_count", jArrG[1]);
                jSONObjectA.put("session_id", this.f44861a.b());
            } catch (Exception unused) {
            }
            String strK = bVar.k();
            if (!TextUtils.isEmpty(strK) && (kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), strK)) != null && !TextUtils.isEmpty(kVarD.a())) {
                jSONObjectA.put("u_stid", kVarD.a());
            }
            eVar2.a(jSONObjectA);
            eVar2.b(0);
            eVar2.a(0);
            this.f44861a.a(eVar2);
            if (interfaceC0492b != null) {
                interfaceC0492b.a(bVar);
            }
        } catch (Exception e11) {
            ad.b("EventLibraryReport", "report failed, exception: " + e11.getMessage());
            if (interfaceC0492b != null) {
                interfaceC0492b.a(bVar, 0, e11.getMessage());
            }
        }
    }
}
