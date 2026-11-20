package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class en extends gn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f18756h;

    public en(com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        super("TaskReportAppLovinReward", jVar);
        this.f18756h = bVar;
    }

    @Override // com.applovin.impl.in
    public void a(int i11) {
        super.a(i11);
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "Failed to report reward for ad: " + this.f18756h + " - error code: " + i11);
        }
    }

    @Override // com.applovin.impl.in
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "zone_id", this.f18756h.getAdZone().e());
        JsonUtils.putInt(jSONObject, "fire_percent", this.f18756h.V());
        String clCode = this.f18756h.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    @Override // com.applovin.impl.gn
    public void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Reported reward successfully for ad: " + this.f18756h);
        }
    }

    @Override // com.applovin.impl.in
    public String f() {
        return "2.0/cr";
    }

    @Override // com.applovin.impl.gn
    public fh h() {
        return this.f18756h.f();
    }

    @Override // com.applovin.impl.gn
    public void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "No reward result was found for ad: " + this.f18756h);
        }
    }
}
