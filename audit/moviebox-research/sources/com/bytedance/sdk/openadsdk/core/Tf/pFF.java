package com.bytedance.sdk.openadsdk.core.Tf;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends zY {
    private long UFX;
    private long WH;

    public pFF(int i11, int i12, long j11, long j12, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.EnumC0293sc enumC0293sc, com.bytedance.sdk.openadsdk.core.Tf.zY.sc.pFF pff, String str, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list, List<com.bytedance.sdk.openadsdk.core.Tf.pFF.zY> list2, String str2) {
        super(i11, i12, enumC0293sc, pff, str, list, list2, str2);
        this.WH = j11;
        this.UFX = j12;
        this.Ol = "icon_click";
    }

    public static pFF sc(JSONObject jSONObject) {
        zY zYVarPFF = zY.pFF(jSONObject);
        if (zYVarPFF == null) {
            return null;
        }
        return new pFF(zYVarPFF.f28241sc, zYVarPFF.pFF, jSONObject.optLong("offset", -1L), jSONObject.optLong("duration", -1L), zYVarPFF.zY, zYVarPFF.We, zYVarPFF.ExN, zYVarPFF.TRI, zYVarPFF.f28240qr, zYVarPFF.Qj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Tf.zY
    public JSONObject sc() throws JSONException {
        JSONObject jSONObjectSc = super.sc();
        if (jSONObjectSc != null) {
            jSONObjectSc.put("offset", this.WH);
            jSONObjectSc.put("duration", this.UFX);
        }
        return jSONObjectSc;
    }
}
