package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends com.bytedance.sdk.openadsdk.core.ExN.We {
    public zY(Context context) {
        super(context);
        sc();
    }

    private void sc() {
        setVisibility(8);
        setId(com.bytedance.sdk.openadsdk.utils.SR.ofL);
    }

    public void sc(int i11, com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        if (sfl.ymG() || (sfl.Pu() && sfl.Qj())) {
            kX.sc((View) this, 0);
            com.bytedance.sdk.openadsdk.Xc.zY.sc().sc((int) kX.sc(getContext(), i11, true), this, sfl);
        }
    }
}
