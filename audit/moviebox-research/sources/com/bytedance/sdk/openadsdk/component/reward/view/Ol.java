package com.bytedance.sdk.openadsdk.component.reward.view;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol extends WH {
    public Ol(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.WH
    public void sc(int i11, int i12) {
        super.sc(i11, i12);
        if (Sfl.ExN(this.We) && this.We.HJN() == 3 && this.We.Gb() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.zY.JoC.findViewById(SR.WH);
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.We.gx() == 1) {
                    int iZY = kX.zY(Xc.sc(), 90.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = iZY;
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.WH
    public boolean sc() {
        return false;
    }
}
