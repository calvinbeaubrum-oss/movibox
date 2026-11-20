package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.model.Xc;
import com.bytedance.sdk.openadsdk.core.widget.UFX;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.Tf;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends pFF {
    public We(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
    }

    private static ImageView We(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setScaleType(ImageView.ScaleType.FIT_XY);
        we2.setImageResource(Sfl.We(context, "tt_up_slide"));
        we2.setId(SR.JPJ);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kX.zY(context, 18.0f), kX.zY(context, 16.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = kX.zY(context, 45.0f);
        we2.setLayoutParams(layoutParams);
        return we2;
    }

    private static com.bytedance.sdk.component.Ol.We pFF(Context context) {
        com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(context, true);
        we2.setId(SR.Dl);
        we2.setLayerType(2, null);
        we2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return we2;
    }

    public static void pFF(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setOrientation(1);
        frameLayout.addView(exN, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar.setId(SR.OXF);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        exN.addView(zYVar, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar2.setId(SR.WH);
        zYVar.addView(zYVar2, new FrameLayout.LayoutParams(-1, -1));
        zYVar2.addView(pFF.sc(context));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar3 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar3.setId(SR.wjp);
        zYVar3.setVisibility(8);
        zYVar3.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        zYVar2.addView(zYVar3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setId(SR.Sfl);
        we2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        zYVar3.addView(we2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.We.pFF(zYVar);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar4 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar4.setId(SR.YIK);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.0f;
        exN.addView(zYVar4, layoutParams3);
        zYVar4.addView(pFF(context));
        LinearLayout linearLayoutZY = zY(context);
        linearLayoutZY.setBackgroundColor(Color.parseColor("#70161823"));
        zYVar4.addView(linearLayoutZY);
        linearLayoutZY.addView(We(context));
        com.bytedance.sdk.openadsdk.component.reward.view.We.sc(zYVar4);
    }

    public static void sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        if (Xc.pFF(sfl)) {
            pFF(frameLayout);
        } else if (Xc.We(sfl) || Xc.ExN(sfl)) {
            zY(frameLayout);
        } else {
            pFF.sc(frameLayout, scVar);
        }
    }

    public static boolean sc(com.bytedance.sdk.openadsdk.core.model.Sfl sfl) {
        return Xc.pFF(sfl) || Xc.We(sfl) || Xc.ExN(sfl);
    }

    private static LinearLayout zY(Context context) {
        com.bytedance.sdk.openadsdk.core.ExN.ExN exN = new com.bytedance.sdk.openadsdk.core.ExN.ExN(context);
        exN.setId(SR.uEA);
        exN.setOrientation(1);
        exN.setVisibility(8);
        exN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return exN;
    }

    public static void zY(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar.setId(SR.YIK);
        frameLayout.addView(zYVar, new FrameLayout.LayoutParams(-1, -1));
        zYVar.addView(pFF(context));
        LinearLayout linearLayoutZY = zY(context);
        linearLayoutZY.setBackgroundColor(Color.parseColor("#99161823"));
        zYVar.addView(linearLayoutZY);
        linearLayoutZY.addView(We(context));
        com.bytedance.sdk.openadsdk.component.reward.view.We.sc(zYVar);
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar2 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar2.setId(SR.OXF);
        frameLayout.addView(zYVar2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar3 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar3.setId(SR.WH);
        zYVar2.addView(zYVar3, new FrameLayout.LayoutParams(-1, -1));
        zYVar3.addView(pFF.sc(context));
        com.bytedance.sdk.openadsdk.core.ExN.zY zYVar4 = new com.bytedance.sdk.openadsdk.core.ExN.zY(context);
        zYVar4.setId(SR.wjp);
        zYVar4.setVisibility(8);
        zYVar4.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        zYVar3.addView(zYVar4, layoutParams);
        com.bytedance.sdk.openadsdk.core.ExN.We we2 = new com.bytedance.sdk.openadsdk.core.ExN.We(context);
        we2.setId(SR.Sfl);
        we2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        zYVar4.addView(we2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.We.pFF(zYVar2);
        View ufx = new UFX(context);
        ufx.setId(SR.cJ);
        ufx.setClickable(true);
        ufx.setFocusable(true);
        frameLayout.addView(ufx, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean ExN() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public RFEndCardBackUpLayout Qj() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void Ql() {
        com.bytedance.sdk.openadsdk.component.reward.view.WH wh2;
        Xc xc2;
        if (Xc.pFF(this.f27845sc.pFF) && (wh2 = this.f27845sc.BR) != null && (xc2 = wh2.BT) != null) {
            if (xc2.We()) {
                this.f27845sc.BR.pFF(0);
                this.f27845sc.dE.set(true);
            } else {
                this.f27845sc.Xc.set(true);
                sc(true, false, true, 80);
            }
        }
        if (Xc.We(this.f27845sc.pFF) || Xc.ExN(this.f27845sc.pFF)) {
            sc(true, false, true, 70);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean TRI() {
        if (Xc.pFF(this.f27845sc.pFF)) {
            return true;
        }
        return (Xc.We(this.f27845sc.pFF) || Xc.ExN(this.f27845sc.pFF)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void qr() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar;
        Tf tf2;
        if (!Xc.We(this.f27845sc.pFF) || (tf2 = (scVar = this.f27845sc).NP) == null) {
            return;
        }
        tf2.sc(scVar.pFF.Ol().pFF() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(com.bytedance.sdk.openadsdk.component.reward.view.qr qrVar) {
        sc(this.pFF, qrVar, this.f27845sc);
    }
}
