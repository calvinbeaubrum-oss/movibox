package com.mbridge.msdk.newreward.a.a;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.c.c;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends a {
    public b(c cVar) {
        super(cVar);
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public final void a(com.mbridge.msdk.foundation.c.b bVar) {
        if (bVar != null && this.f46001c != null) {
            try {
                if (bVar.i() == -1) {
                    this.f46001c.c(System.currentTimeMillis());
                }
                this.f46001c.a(bVar.i() + "");
                com.mbridge.msdk.foundation.same.net.g.c.a().a(this.f46001c.t() + "_" + this.f46001c.u() + "_" + this.f46001c.y() + "_" + this.f46001c.n(), bVar.i(), bVar.k(), System.currentTimeMillis());
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
        if (this.f46001c.j() || this.f46001c.k() || this.f46001c.l()) {
            a(this.f46000b, bVar);
        } else {
            b(bVar);
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public final void a(Object obj) {
        Map map = (Map) obj;
        a(((Integer) map.get("type")).intValue(), map.get("object"));
    }
}
