package com.applovin.impl;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zj extends pe {
    public zj(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(map, jSONObject, jSONObject2, jVar);
    }

    public boolean A() {
        return a("use_cached_adapter", Boolean.TRUE).booleanValue();
    }

    @Override // com.applovin.impl.pe
    public String toString() {
        return "SignalProviderSpec{adObject=" + a() + '}';
    }

    public xj.b u() {
        return xj.b.values()[a("signal_cache_level", ((Integer) this.f21736a.a(ve.f23886i7)).intValue())];
    }

    public long v() {
        return a("signal_expiration_ms", ((Long) this.f21736a.a(ve.f23885h7)).longValue());
    }

    public boolean w() {
        return a("only_collect_signal_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean x() {
        return a("prefer_collect_signal_when_initialized", Boolean.TRUE).booleanValue();
    }

    public boolean y() {
        return a("fail_collection_for_empty_signal", (Boolean) this.f21736a.a(ve.R7)).booleanValue();
    }

    public boolean z() {
        return a("initialize_before_collecting_signal", Boolean.TRUE).booleanValue();
    }
}
