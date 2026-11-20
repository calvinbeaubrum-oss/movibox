package com.bytedance.sdk.openadsdk.UFX.sc;

import com.bytedance.sdk.component.sc.Xc;
import com.bytedance.sdk.openadsdk.core.HJN;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends com.bytedance.sdk.component.sc.ExN<JSONObject, JSONObject> {
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final HJN f27289sc;

    public Qj(HJN hjn, String str) {
        this.f27289sc = hjn;
        this.pFF = str;
    }

    public static void sc(Xc xc2, HJN hjn) {
        xc2.sc("endcardDynamicCreatives", new Qj(hjn, "endcardDynamicCreatives"));
        xc2.sc("multiOpenCovert", new Qj(hjn, "multiOpenCovert"));
        xc2.sc("skipToNextAd", new Qj(hjn, "skipToNextAd"));
    }

    @Override // com.bytedance.sdk.component.sc.ExN
    public JSONObject sc(JSONObject jSONObject, com.bytedance.sdk.component.sc.TRI tri) throws Exception {
        if ("endcardDynamicCreatives".equals(this.pFF)) {
            return this.f27289sc.qr(jSONObject);
        }
        if ("multiOpenCovert".equals(this.pFF)) {
            this.f27289sc.Qj(jSONObject);
            return null;
        }
        if (!"skipToNextAd".equals(this.pFF)) {
            return null;
        }
        this.f27289sc.sc(jSONObject, this.pFF);
        return null;
    }
}
