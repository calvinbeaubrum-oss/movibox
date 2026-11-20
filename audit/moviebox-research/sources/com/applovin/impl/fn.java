package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class fn extends gn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ie f19027h;

    public fn(ie ieVar, com.applovin.impl.sdk.j jVar) {
        super("TaskReportMaxReward", jVar);
        this.f19027h = ieVar;
    }

    @Override // com.applovin.impl.in
    public void a(int i11) {
        super.a(i11);
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Failed to report reward for mediated ad: " + this.f19027h + " - error code: " + i11);
        }
    }

    @Override // com.applovin.impl.in
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f19027h.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f19027h.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f19027h.e());
        String strR0 = this.f19027h.r0();
        if (!StringUtils.isValidString(strR0)) {
            strR0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strR0);
        String strC = this.f19027h.C();
        if (!StringUtils.isValidString(strC)) {
            strC = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strC);
    }

    @Override // com.applovin.impl.gn
    public void b(JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Reported reward successfully for mediated ad: " + this.f19027h);
        }
    }

    @Override // com.applovin.impl.in
    public String f() {
        return "2.0/mcr";
    }

    @Override // com.applovin.impl.gn
    public fh h() {
        return this.f19027h.n0();
    }

    @Override // com.applovin.impl.gn
    public void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.b(this.f24690b, "No reward result was found for mediated ad: " + this.f19027h);
        }
    }
}
