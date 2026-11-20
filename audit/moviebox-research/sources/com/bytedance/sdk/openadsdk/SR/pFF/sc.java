package com.bytedance.sdk.openadsdk.SR.pFF;

import com.bytedance.sdk.component.Qj.zY;
import com.bytedance.sdk.openadsdk.SR.pFF;
import com.bytedance.sdk.openadsdk.SR.sc.We;
import com.bytedance.sdk.openadsdk.core.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements zY {
    @Override // com.bytedance.sdk.component.Qj.zY
    public void sc(final com.bytedance.sdk.component.Qj.pFF.sc scVar) {
        com.bytedance.sdk.openadsdk.SR.zY.sc();
        com.bytedance.sdk.openadsdk.SR.zY.sc("stats_sdk_thread_num", false, new pFF() { // from class: com.bytedance.sdk.openadsdk.SR.pFF.sc.1
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                com.bytedance.sdk.component.Qj.pFF.sc scVar2;
                if (!Xc.We().qfG() || (scVar2 = scVar) == null || scVar2.sc() == null) {
                    return null;
                }
                return We.pFF().sc("stats_sdk_thread_num").pFF(scVar.sc().toString());
            }
        });
    }
}
