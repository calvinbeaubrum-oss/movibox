package com.bytedance.sdk.openadsdk.JPJ.pFF;

import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.cJ;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    public static void sc(final Sfl sfl, final sc scVar, final ExN.sc scVar2) {
        sfl.pCa();
        Cb.zY(new com.bytedance.sdk.component.Qj.Qj("mrc_report") { // from class: com.bytedance.sdk.openadsdk.JPJ.pFF.We.1
            @Override // java.lang.Runnable
            public void run() {
                if (sfl.ag()) {
                    if (sfl.ixT()) {
                        com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.sc(sfl.idT(), new com.bytedance.sdk.openadsdk.core.Tf.pFF.zY.pFF("show_urls", sfl));
                    } else {
                        com.bytedance.sdk.openadsdk.We.zY.sc(sfl);
                    }
                }
                String strSc = cJ.sc(sfl);
                JSONObject jSONObject = new JSONObject();
                sc scVar3 = scVar;
                if (scVar3 != null) {
                    try {
                        jSONObject.put("root_view", sc.sc(scVar3));
                        ExN.sc scVar4 = scVar2;
                        if (scVar4 != null) {
                            int i11 = scVar4.f27090sc;
                            if (i11 != -1) {
                                jSONObject.put("dynamic_show_type", i11);
                            }
                            int i12 = scVar2.pFF;
                            if (i12 != -1) {
                                jSONObject.put("ad_show_order", i12 + 1);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                com.bytedance.sdk.openadsdk.We.zY.pFF(sfl, strSc, "mrc_show", jSONObject);
            }
        });
    }
}
