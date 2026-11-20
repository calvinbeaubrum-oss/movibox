package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SR {
    private boolean ExN = false;
    private boolean TRI;
    private final sc We;
    com.bytedance.sdk.component.adexpress.dynamic.We pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.component.reward.top.zY f27867sc;
    private final Activity zY;

    public SR(sc scVar) {
        this.zY = scVar.CYO;
        this.We = scVar;
    }

    public void ExN() {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = this.f27867sc;
        if (zYVar != null) {
            zYVar.clickSound();
        }
    }

    public void ExN(boolean z11) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setSkipEnable(z11);
    }

    public void TRI() {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setSkipInvisiable();
    }

    public void We() {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = this.f27867sc;
        if (zYVar != null) {
            zYVar.clickSkip();
        }
    }

    public void We(boolean z11) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setShowSkip(z11);
    }

    public void pFF() {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.showCountDownText();
    }

    public void pFF(boolean z11) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = this.f27867sc;
        if (zYVar != null) {
            zYVar.setSoundMute(z11);
        }
        com.bytedance.sdk.component.adexpress.dynamic.We we2 = this.pFF;
        if (we2 != null) {
            we2.setSoundMute(z11);
        }
    }

    public void sc() {
        if (this.ExN) {
            return;
        }
        this.ExN = true;
        sc scVar = this.We;
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = scVar.mD;
        if (zYVar != null) {
            this.f27867sc = zYVar;
            this.TRI = true;
        } else {
            this.f27867sc = (com.bytedance.sdk.openadsdk.component.reward.top.zY) scVar.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Vb);
        }
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar2 = this.f27867sc;
        if (zYVar2 != null) {
            zYVar2.sc(this.We.pFF);
            if (this.We.pFF.ymG()) {
                sc(false);
            } else {
                sc(this.We.pFF.vYl());
            }
        }
    }

    public void sc(int i11) {
        View viewFindViewById;
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = this.f27867sc;
        if (zYVar == null || zYVar.getITopLayout() == null || i11 == 0 || (viewFindViewById = this.f27867sc.getITopLayout().findViewById(520093713)) == null || !(viewFindViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || viewFindViewById.getWidth() <= 0 || viewFindViewById.getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int width = i11 - (iArr[0] + viewFindViewById.getWidth());
        if (width < kX.zY(this.zY, 16.0f)) {
            ((ViewGroup.MarginLayoutParams) viewFindViewById.getLayoutParams()).rightMargin += kX.zY(this.zY, 16.0f) - width;
            viewFindViewById.requestLayout();
        }
    }

    public void sc(com.bytedance.sdk.component.adexpress.dynamic.We we2) {
        this.pFF = we2;
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.top.pFF pff) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar = this.f27867sc;
        if (zYVar != null) {
            zYVar.setListener(pff);
        }
    }

    public void sc(CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setSkipText(charSequence);
    }

    public void sc(String str, CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setTime(String.valueOf(str), charSequence);
    }

    public void sc(boolean z11) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setShowDislike(z11);
    }

    public void zY() {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.showSkipButton();
    }

    public void zY(boolean z11) {
        com.bytedance.sdk.openadsdk.component.reward.top.zY zYVar;
        if (this.TRI || (zYVar = this.f27867sc) == null) {
            return;
        }
        zYVar.setShowSound(z11);
    }
}
