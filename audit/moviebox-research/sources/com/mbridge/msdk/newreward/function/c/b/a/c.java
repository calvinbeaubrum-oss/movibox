package com.mbridge.msdk.newreward.function.c.b.a;

import com.mbridge.msdk.foundation.tools.ad;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.mbridge.msdk.newreward.function.c.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.f.b f46171a;

    public final Object a(Object obj) {
        if (this.f46171a != null || obj == null) {
            return null;
        }
        try {
            Map map = (Map) obj;
            com.mbridge.msdk.newreward.b.b bVar = (com.mbridge.msdk.newreward.b.b) map.get("controller_model");
            com.mbridge.msdk.newreward.function.c.c cVar = (com.mbridge.msdk.newreward.function.c.c) map.get("command_manager");
            com.mbridge.msdk.newreward.a.d dVar = (com.mbridge.msdk.newreward.a.d) map.get("adapter_manager");
            if (bVar != null && cVar != null && dVar != null) {
                com.mbridge.msdk.newreward.function.f.b bVar2 = new com.mbridge.msdk.newreward.function.f.b(bVar.e(), bVar.d(), bVar.c(), bVar.f());
                this.f46171a = bVar2;
                bVar2.a(cVar, dVar);
                return null;
            }
            return null;
        } catch (Exception e11) {
            ad.a("LoadCheckReceiver", "action", e11);
        }
    }
}
