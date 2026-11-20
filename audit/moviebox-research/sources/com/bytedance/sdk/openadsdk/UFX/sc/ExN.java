package com.bytedance.sdk.openadsdk.UFX.sc;

import com.bytedance.sdk.component.sc.Xc;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private JSONObject f27287sc;

    public ExN(JSONObject jSONObject) {
        this.f27287sc = jSONObject;
    }

    public static void sc(Xc xc2, JSONObject jSONObject) {
        xc2.sc("getData", new ExN(jSONObject));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    public JSONObject sc(JSONObject jSONObject, com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        return com.bytedance.sdk.openadsdk.core.Qj.sc.pFF.sc(this.f27287sc, jSONObject);
    }
}
