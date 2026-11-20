package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ln extends mn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ie f20486h;

    public ln(ie ieVar, com.applovin.impl.sdk.j jVar) {
        super("TaskValidateMaxReward", jVar);
        this.f20486h = ieVar;
    }

    @Override // com.applovin.impl.in
    public void a(int i11) {
        super.a(i11);
        this.f20486h.a(fh.a((i11 < 400 || i11 >= 500) ? "network_timeout" : "rejected"));
    }

    @Override // com.applovin.impl.mn
    public void a(fh fhVar) {
        this.f20486h.a(fhVar);
    }

    @Override // com.applovin.impl.in
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.f20486h.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.f20486h.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.f20486h.e());
        JsonUtils.putString(jSONObject, "ad_format", this.f20486h.getFormat().getLabel());
        String strR0 = this.f20486h.r0();
        if (!StringUtils.isValidString(strR0)) {
            strR0 = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", strR0);
        String strC = this.f20486h.C();
        if (!StringUtils.isValidString(strC)) {
            strC = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", strC);
    }

    @Override // com.applovin.impl.in
    public String f() {
        return "2.0/mvr";
    }

    @Override // com.applovin.impl.mn
    public boolean h() {
        return this.f20486h.u0();
    }
}
