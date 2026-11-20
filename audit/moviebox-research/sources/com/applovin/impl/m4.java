package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class m4 extends j4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f20573c;

    public m4(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jVar);
    }

    public Map e() {
        return this.f20573c;
    }

    public String f() {
        return JsonUtils.getString(this.f19838b, "name", null);
    }

    @Override // com.applovin.impl.j4
    public String toString() {
        return "ConsentFlowState{id=" + b() + "type=" + c() + "isInitialState=" + d() + "name=" + f() + "}";
    }
}
