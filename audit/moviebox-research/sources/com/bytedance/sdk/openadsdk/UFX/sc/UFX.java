package com.bytedance.sdk.openadsdk.UFX.sc;

import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.openadsdk.core.HJN;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class UFX extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final HJN f27291sc;

    public UFX(HJN hjn) {
        this.f27291sc = hjn;
    }

    public static void sc(Xc xc2, HJN hjn) {
        xc2.sc("commonConvert", new UFX(hjn));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    public JSONObject sc(JSONObject jSONObject, com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        this.f27291sc.TRI(jSONObject);
        return null;
    }
}
