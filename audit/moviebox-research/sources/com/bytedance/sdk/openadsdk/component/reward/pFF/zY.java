package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends pFF {
    public zY(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
    }

    private static com.bytedance.sdk.component.Ol.We pFF(Context context) {
        com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(context, true);
        we2.setId(SR.Dl);
        we2.setLayerType(2, null);
        we2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return we2;
    }

    private void pFF(com.bytedance.sdk.openadsdk.component.reward.view.qr qrVar) {
        if (qrVar == null) {
            return;
        }
        Context context = qrVar.getContext();
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(1);
        qrVar.addView(exN, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar.setId(SR.OXF);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 100.0f;
        exN.addView(zYVar, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar2.setId(SR.WH);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        zYVar.addView(zYVar2, layoutParams2);
        zYVar2.addView(pFF.sc(context));
        if (this.pFF.dix() != 3 && this.pFF.dix() != 5) {
            com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
            we2.setId(SR.yQN);
            we2.setVisibility(8);
            we2.setBackground(com.bytedance.sdk.openadsdk.core.widget.We.sc());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(kX.zY(context, 28.0f), kX.zY(context, 28.0f));
            layoutParams3.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
            layoutParams3.rightMargin = kX.zY(context, 20.0f);
            layoutParams3.bottomMargin = kX.zY(context, 10.0f);
            zYVar.addView(we2, layoutParams3);
        }
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar3 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar3.setId(SR.YIK);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 0.0f;
        exN.addView(zYVar3, layoutParams4);
        zYVar3.addView(pFF(context));
        com.bytedance.sdk.openadsdk.component.reward.view.We.sc(zYVar3);
        com.bytedance.sdk.openadsdk.component.reward.view.We.pFF(zYVar);
    }

    public static boolean sc(Sfl sfl) {
        Xc.zY(sfl);
        return Xc.zY(sfl);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean ExN() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean TRI() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void qr() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(com.bytedance.sdk.openadsdk.component.reward.view.qr qrVar) {
        pFF(qrVar);
    }
}
