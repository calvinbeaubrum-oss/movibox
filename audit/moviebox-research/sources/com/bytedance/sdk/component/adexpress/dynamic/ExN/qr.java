package com.bytedance.sdk.component.adexpress.dynamic.ExN;

import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr implements Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.TRI.pFF f26745sc;

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(Ql ql2) {
        try {
            JSONObject jSONObjectZY = ql2.zY();
            JSONObject jSONObject = new JSONObject(jSONObjectZY.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectZY.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.We.Qj qjSc = new TRI(jSONObject, jSONObjectOptJSONObject, jSONObjectZY.optJSONObject("AdSize"), new JSONObject(jSONObjectZY.optString("diff_template_Plugin"))).sc(ql2.pFF(), ql2.WH(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), ql2);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                qjSc.sc(jSONObject2.optString(TtmlNode.ATTR_TTS_COLOR));
                qjSc.sc(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.f26745sc.sc(qjSc);
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ExN.Qj
    public void sc(com.bytedance.sdk.component.adexpress.dynamic.TRI.pFF pff) {
        this.f26745sc = pff;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ExN.Qj
    public void sc(final Ql ql2) {
        if (ql2.Tf() == 1) {
            pFF(ql2);
        } else {
            com.bytedance.sdk.component.adexpress.We.We.sc(new com.bytedance.sdk.component.Qj.Qj("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.ExN.qr.1
                @Override // java.lang.Runnable
                public void run() {
                    qr.this.pFF(ql2);
                }
            }, 5);
        }
    }
}
