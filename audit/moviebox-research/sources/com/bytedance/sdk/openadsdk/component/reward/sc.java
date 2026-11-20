package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public static void sc(final Sfl sfl, final boolean z11, final boolean z12) {
        com.bytedance.sdk.openadsdk.core.SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.1
            @Override // java.lang.Runnable
            public void run() {
                if (sfl == null) {
                    return;
                }
                try {
                    Context contextSc = Xc.sc();
                    AdSlot adSlotCb = sfl.Cb();
                    if (adSlotCb != null) {
                        int iPFF = ExN.pFF();
                        if (iPFF == 0 || iPFF == 2) {
                            if (z12) {
                                Tf.sc(contextSc).sc(adSlotCb.getCodeId(), sfl);
                            } else {
                                ExN.sc(contextSc).sc(adSlotCb.getCodeId(), sfl);
                            }
                        }
                        if (z11) {
                            if (z12) {
                                Tf.sc(contextSc).sc(adSlotCb);
                            } else {
                                ExN.sc(contextSc).sc(adSlotCb);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.sc scVar, int i11, boolean z11) {
        if (scVar == null || scVar.We() == null || scVar.We().size() <= 0) {
            return;
        }
        if (i11 >= scVar.We().size()) {
            i11 = 0;
        }
        Sfl sfl = scVar.We().get(i11);
        Context contextSc = Xc.sc();
        sc(sfl, !TextUtils.isEmpty(z11 ? UFX.sc(contextSc).sc(sfl) : We.sc(contextSc).sc(sfl)), z11);
    }
}
