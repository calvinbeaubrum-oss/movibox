package com.bytedance.sdk.openadsdk.sc.pFF.sc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.core.Qj.Sfl;
import com.bytedance.sdk.openadsdk.core.Qj.wjp;
import com.bytedance.sdk.openadsdk.sc.pFF.Qj;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY extends Qj {
    protected AdSlot Ol;
    protected final Context Qj;
    private boolean Tf;
    protected String UFX;
    protected Sfl WH;

    public zY(@NonNull Context context, com.bytedance.sdk.openadsdk.core.model.Sfl sfl, AdSlot adSlot) {
        super(context, sfl, 5, true);
        this.UFX = "embeded_ad";
        this.Tf = false;
        this.pFF.Qj(1);
        this.We.sc(this);
        this.Qj = context;
        this.Ol = adSlot;
        sc();
        pFF();
    }

    private void pFF() {
        Sfl sfl = this.WH;
        if (sfl != null) {
            sfl.setBackupListener(new com.bytedance.sdk.component.adexpress.pFF.zY() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.zY.1
                @Override // com.bytedance.sdk.component.adexpress.pFF.zY
                public boolean sc(ViewGroup viewGroup, int i11) {
                    sc scVar = new sc(zY.this.WH.getContext());
                    scVar.setExtraFuncationHelper(((Qj) zY.this).We);
                    scVar.sc(zY.this.WH);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(float f11, float f12) {
        Sfl sfl = this.WH;
        if (sfl != null && com.bytedance.sdk.openadsdk.core.UFX.zY.sc(sfl.getDynamicShowType())) {
            ViewGroup.LayoutParams layoutParams = this.WH.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.WH.setLayoutParams(layoutParams);
            return;
        }
        int iZY = kX.zY(this.Qj, f11);
        int iZY2 = kX.zY(this.Qj, f12);
        ViewGroup.LayoutParams layoutParams2 = this.WH.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(iZY, iZY2);
        } else {
            layoutParams2.width = iZY;
            layoutParams2.height = iZY2;
        }
        this.WH.setLayoutParams(layoutParams2);
    }

    public void ExN() {
        Sfl sfl = this.WH;
        if (sfl != null) {
            sfl.Ol();
        }
    }

    public Sfl We() {
        return this.WH;
    }

    public void sc() {
        this.WH = new Sfl(this.Qj, this.pFF, this.Ol, this.UFX);
        zY();
    }

    public void sc(boolean z11) {
        this.Tf = z11;
    }

    public void zY() {
        Sfl sfl = this.WH;
        if (sfl != null) {
            sfl.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.sc.zY.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i11) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i11) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f11, float f12) {
                    if (!zY.this.WH.Ql()) {
                        zY.this.sc(f11, f12);
                        if (zY.this.Tf) {
                            zY.this.WH.Qj();
                            return;
                        }
                        return;
                    }
                    zY zYVar = zY.this;
                    Context context = zYVar.Qj;
                    com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = ((Qj) zYVar).pFF;
                    zY zYVar2 = zY.this;
                    com.bytedance.sdk.openadsdk.sc.pFF.pFF pff = new com.bytedance.sdk.openadsdk.sc.pFF.pFF(context, sfl2, 5, zYVar2.Ol, ((Qj) zYVar2).We, ((Qj) zY.this).f28677sc);
                    zY zYVar3 = zY.this;
                    if (zYVar3 instanceof pFF) {
                        pff.sc(((wjp) zYVar3.We()).getVideoAdListener());
                    }
                    ((Qj) zY.this).We.sc((com.bytedance.sdk.openadsdk.core.pFF.sc) zY.this.WH.getClickCreativeListener());
                    PAGMediaView pAGMediaViewOl = ((Qj) zY.this).We.Ol();
                    if (pAGMediaViewOl == null) {
                        pAGMediaViewOl = new PAGMediaView(zY.this.Qj);
                    }
                    zY.this.WH.addView(pAGMediaViewOl);
                }
            });
        }
    }
}
