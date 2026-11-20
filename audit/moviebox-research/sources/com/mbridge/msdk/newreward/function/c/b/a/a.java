package com.mbridge.msdk.newreward.function.c.b.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.mbridge.msdk.newreward.function.c.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.b.a f46170a;

    public final Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        Map map = (Map) obj;
        com.mbridge.msdk.foundation.c.b bVar = map.get("reason") != null ? (com.mbridge.msdk.foundation.c.b) map.get("reason") : null;
        com.mbridge.msdk.newreward.a.e eVar = map.get("adapter_model") != null ? (com.mbridge.msdk.newreward.a.e) map.get("adapter_model") : null;
        com.mbridge.msdk.newreward.function.c.c cVar = map.get("command_manager") != null ? (com.mbridge.msdk.newreward.function.c.c) map.get("command_manager") : null;
        if (eVar != null && cVar != null) {
            int iIntValue = map.get("candidate_type") != null ? ((Integer) map.get("candidate_type")).intValue() : 0;
            if (this.f46170a == null) {
                this.f46170a = new com.mbridge.msdk.newreward.function.b.a(eVar.y(), eVar.n() == 287, cVar);
            }
            com.mbridge.msdk.foundation.same.report.d.b bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
            bVar2.c(eVar.x());
            if (iIntValue == 0) {
                String strA = eVar.A();
                if (TextUtils.isEmpty(strA)) {
                    return null;
                }
                try {
                    com.mbridge.msdk.newreward.function.a.b bVarA = this.f46170a.a(bVar2, bVar, eVar, 2);
                    this.f46170a.a(bVar2, strA, bVarA, null, null, eVar, 3);
                    return bVarA;
                } catch (Exception e11) {
                    ad.b("CandidateReceiver", "load error" + e11.getMessage());
                    return null;
                }
            }
            if (iIntValue == 1) {
                String strA2 = eVar.A();
                if (TextUtils.isEmpty(strA2)) {
                    return Boolean.FALSE;
                }
                try {
                    return Boolean.valueOf(this.f46170a.a(strA2));
                } catch (Exception e12) {
                    ad.b("CandidateReceiver", "loadCallBack error" + e12.getMessage());
                    return Boolean.FALSE;
                }
            }
            if (iIntValue == 2) {
                String strA3 = eVar.A();
                if (TextUtils.isEmpty(strA3)) {
                    return null;
                }
                try {
                    com.mbridge.msdk.newreward.function.a.b bVarA2 = this.f46170a.a(bVar2, bVar, eVar, 2);
                    com.mbridge.msdk.newreward.function.b.a aVar = this.f46170a;
                    if (aVar != null) {
                        aVar.a(bVar2, strA3, bVarA2, null, null, eVar, 1);
                    }
                    return bVarA2;
                } catch (Exception e13) {
                    ad.b("CandidateReceiver", "loadCallBack error" + e13.getMessage());
                    return null;
                }
            }
            if (TextUtils.isEmpty(eVar.A())) {
                return null;
            }
            try {
                return this.f46170a.a(bVar2, bVar, eVar, 2);
            } catch (Exception e14) {
                ad.b("CandidateReceiver", "load error" + e14.getMessage());
            }
        }
        return null;
    }
}
