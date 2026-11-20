package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class he extends ne {
    public he(int i11, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(i11, map, jSONObject, jSONObject2, null, jVar);
    }

    private he(he heVar, com.applovin.impl.mediation.g gVar) {
        super(heVar.K(), heVar.i(), heVar.a(), heVar.g(), gVar, heVar.f21736a);
    }

    @Override // com.applovin.impl.ge
    public ge a(com.applovin.impl.mediation.g gVar) {
        return new he(this, gVar);
    }

    public long q0() {
        long jA = a("ad_refresh_ms", -1L);
        return jA >= 0 ? jA : b("ad_refresh_ms", ((Long) this.f21736a.a(ve.S6)).longValue());
    }

    public long r0() {
        return yp.d(a("bg_color", (String) null));
    }

    public int s0() {
        int iA = a("ad_view_height", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public long t0() {
        return a("viewability_imp_delay_ms", ((Long) this.f21736a.a(sj.H1)).longValue());
    }

    public int u0() {
        int iA = a("ad_view_width", -2);
        if (iA != -2) {
            return iA;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public boolean v0() {
        return q0() >= 0;
    }

    public boolean w0() {
        return a("proe", (Boolean) this.f21736a.a(ve.f23896s7)).booleanValue();
    }
}
