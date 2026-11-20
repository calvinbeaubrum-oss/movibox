package com.bytedance.sdk.openadsdk.core.settings;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends BT {
    public sc() {
        super("tt_set_apm.prop", new BT.sc() { // from class: com.bytedance.sdk.openadsdk.core.settings.sc.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.BT.sc
            public void pFF() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.BT.sc
            public void sc() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ExN
    public void sc(JSONObject jSONObject) {
        ExN.sc scVarSc = sc();
        if (jSONObject.has("apm_url")) {
            scVarSc.sc("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("perf_con");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("perf_con_apm")) {
                    scVarSc.sc("perf_con_apm", jSONObjectOptJSONObject.optInt("perf_con_apm"));
                }
            } catch (Exception unused) {
            }
        }
        scVarSc.sc();
        We();
    }
}
