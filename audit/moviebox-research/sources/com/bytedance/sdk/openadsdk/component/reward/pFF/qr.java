package com.bytedance.sdk.openadsdk.component.reward.pFF;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.YIK;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr {
    @NonNull
    public static pFF sc(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        Sfl sfl = scVar.pFF;
        if ((sfl instanceof YIK) && ((YIK) sfl).Kv()) {
            return new TRI(scVar);
        }
        if (JPJ.wjp(sfl)) {
            return new WH(scVar);
        }
        if (Qj.sc(sfl) && !zY.sc(sfl)) {
            return new Qj(scVar);
        }
        if (Ol.sc(sfl)) {
            return new Ol(scVar);
        }
        if (WH.sc(sfl)) {
            return new WH(scVar);
        }
        if (We.sc(sfl)) {
            return new We(scVar);
        }
        return zY.sc(sfl) ? new zY(scVar) : new ExN(scVar);
    }
}
