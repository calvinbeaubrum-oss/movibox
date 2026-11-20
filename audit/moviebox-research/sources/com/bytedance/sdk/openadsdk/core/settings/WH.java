package com.bytedance.sdk.openadsdk.core.settings;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH extends BT {
    public WH() {
        super("tt_set_mediation.prop", null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ExN
    public void sc(JSONObject jSONObject) {
        if (jSONObject.has("mediation_init_conf")) {
            ExN.sc scVarSc = sc();
            scVarSc.sc("mediation_init_conf", jSONObject.optString("mediation_init_conf"));
            scVarSc.sc();
            We();
        }
    }
}
