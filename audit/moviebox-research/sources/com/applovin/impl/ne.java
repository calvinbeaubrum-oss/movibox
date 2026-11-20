package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ne extends ge {
    public ne(int i11, Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.g gVar, com.applovin.impl.sdk.j jVar) {
        super(i11, map, jSONObject, jSONObject2, gVar, jVar);
    }

    public float i0() {
        return b("viewability_min_alpha", ((Float) this.f21736a.a(sj.Q1)).floatValue() / 100.0f);
    }

    public int j0() {
        return a("viewability_min_pixels", -1);
    }

    public int k0() {
        sj sjVar;
        MaxAdFormat format = getFormat();
        if (format == MaxAdFormat.BANNER) {
            sjVar = sj.J1;
        } else if (format == MaxAdFormat.MREC) {
            sjVar = sj.L1;
        } else if (format == MaxAdFormat.LEADER) {
            sjVar = sj.N1;
        } else {
            sjVar = format == MaxAdFormat.NATIVE ? sj.P1 : null;
        }
        if (sjVar != null) {
            return a("viewability_min_height", ((Integer) this.f21736a.a(sjVar)).intValue());
        }
        return 0;
    }

    public float l0() {
        return b("viewability_min_percentage_dp", -1.0f);
    }

    public float m0() {
        return b("viewability_min_percentage_pixels", -1.0f);
    }

    public long n0() {
        return a("viewability_timer_min_visible_ms", ((Long) this.f21736a.a(sj.R1)).longValue());
    }

    public int o0() {
        sj sjVar;
        MaxAdFormat format = getFormat();
        if (format == MaxAdFormat.BANNER) {
            sjVar = sj.I1;
        } else if (format == MaxAdFormat.MREC) {
            sjVar = sj.K1;
        } else if (format == MaxAdFormat.LEADER) {
            sjVar = sj.M1;
        } else {
            sjVar = format == MaxAdFormat.NATIVE ? sj.O1 : null;
        }
        if (sjVar != null) {
            return a("viewability_min_width", ((Integer) this.f21736a.a(sjVar)).intValue());
        }
        return 0;
    }

    public boolean p0() {
        return j0() >= 0 || l0() >= 0.0f || m0() >= 0.0f;
    }
}
