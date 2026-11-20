package com.mbridge.msdk.newreward.function.c.b.a;

import com.mbridge.msdk.foundation.tools.ad;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements com.mbridge.msdk.newreward.function.c.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.foundation.c.b f46196a;

    private static void a(com.mbridge.msdk.newreward.a.b.b bVar, com.mbridge.msdk.foundation.c.b bVar2) {
        if (bVar != null) {
            try {
                bVar.a(bVar2);
            } catch (Exception e11) {
                ad.a("SmartLoadReceiver", "handlerCandidateFailed", e11);
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.function.c.b.a
    public final void a(com.mbridge.msdk.newreward.function.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        if (bVar == null || bVar.b() == null) {
            a(bVar2, new com.mbridge.msdk.foundation.c.b(-1, "command or object is null"));
            return;
        }
        try {
            Map map = (Map) bVar.b();
            this.f46196a = (com.mbridge.msdk.foundation.c.b) map.get("reason");
            com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            com.mbridge.msdk.newreward.function.c.c cVar = (com.mbridge.msdk.newreward.function.c.c) map.get("command_manager");
            map.put("candidate_type", 0);
            map.put("scene", 2);
            com.mbridge.msdk.newreward.function.a.b bVar3 = (com.mbridge.msdk.newreward.function.a.b) cVar.b(map);
            if (!com.mbridge.msdk.newreward.function.h.a.c(eVar.A())) {
                a(bVar2, this.f46196a);
                return;
            }
            eVar.e(true);
            if (bVar3 == null) {
                a(bVar2, this.f46196a);
                return;
            }
            if (bVar3.h() != com.mbridge.msdk.newreward.function.a.b.f46152d) {
                a(bVar2, new com.mbridge.msdk.foundation.c.b(bVar3.g(), bVar3.b()));
                return;
            }
            eVar.v().a(bVar3.a());
            if (bVar2 != null) {
                try {
                    bVar2.a(bVar3.a());
                } catch (Exception e11) {
                    ad.a("SmartLoadReceiver", "handlerCandidateSuccess", e11);
                }
            }
        } catch (Exception e12) {
            ad.a("SmartLoadReceiver", "action", e12);
            if (bVar2 != null) {
                com.mbridge.msdk.foundation.c.b bVar4 = this.f46196a;
                if (bVar4 == null) {
                    a(bVar2, new com.mbridge.msdk.foundation.c.b(-1, "SmartLoadReceiver action exception"));
                } else {
                    a(bVar2, bVar4);
                }
            }
        }
    }
}
