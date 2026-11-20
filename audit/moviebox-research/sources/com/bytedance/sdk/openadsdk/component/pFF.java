package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Qj.Ol;
import com.bytedance.sdk.openadsdk.core.Qj.Qj;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends zY {
    private com.bytedance.sdk.openadsdk.component.Ol.qr BT;
    private com.bytedance.sdk.openadsdk.component.Ol.pFF Ql;
    private boolean SR;
    private final com.bytedance.sdk.openadsdk.component.TRI.pFF Tf;

    public pFF(Activity activity, Sfl sfl, FrameLayout frameLayout, sc scVar, int i11, boolean z11, com.bytedance.sdk.openadsdk.component.Qj.sc scVar2, com.bytedance.sdk.openadsdk.component.TRI.pFF pff) {
        super(activity, sfl, frameLayout, scVar, i11, z11, scVar2);
        this.Tf = pff;
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public void ExN() {
        com.bytedance.sdk.openadsdk.component.Ol.pFF pff = this.Ql;
        if (pff != null) {
            pff.Qj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public int We() {
        return this.Ql.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public void pFF() {
        this.Ql.Ol();
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public JSONObject sc(JSONObject jSONObject) {
        return this.Ql.sc(jSONObject, this.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public void sc() {
        Ol olSc = com.bytedance.sdk.openadsdk.component.sc.pFF.sc(this.pFF, this.f27988sc, this.UFX, this.Ql);
        olSc.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.component.pFF.2
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                pFF.this.ExN.ExN();
            }
        });
        this.Ql.setClickListener(olSc);
        Qj qjPFF = com.bytedance.sdk.openadsdk.component.sc.pFF.pFF(this.pFF, this.f27988sc, this.UFX, this.Ql);
        this.Ql.setClickCreativeListener(qjPFF);
        qjPFF.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.component.pFF.3
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                pFF.this.ExN.ExN();
            }
        });
        super.TRI();
        this.Ql.setBackupListener(new com.bytedance.sdk.component.adexpress.pFF.zY() { // from class: com.bytedance.sdk.openadsdk.component.pFF.4
            @Override // com.bytedance.sdk.component.adexpress.pFF.zY
            public boolean sc(ViewGroup viewGroup, int i11) {
                StringBuilder sb2 = new StringBuilder("isUseBackup() called with: view = [");
                sb2.append(viewGroup);
                sb2.append("], errCode = [");
                sb2.append(i11);
                sb2.append("]");
                try {
                    ((com.bytedance.sdk.openadsdk.core.Qj.Sfl) viewGroup).Tf();
                    new com.bytedance.sdk.openadsdk.component.Ol.sc(pFF.this.f27988sc).sc((com.bytedance.sdk.openadsdk.core.Qj.Sfl) pFF.this.Ql);
                    return true;
                } catch (Exception e11) {
                    Log.e("AppOpenAdExpressManager", "", e11);
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public void sc(int i11, int i12, boolean z11) {
        super.sc(i11, i12, z11);
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public void sc(ViewGroup viewGroup) {
        Pair<Float, Float> pairSc = com.bytedance.sdk.openadsdk.core.Qj.sc.sc.sc(this.f27988sc.getWindow(), this.f27987qr);
        com.bytedance.sdk.openadsdk.component.Ol.pFF pff = new com.bytedance.sdk.openadsdk.component.Ol.pFF(this.f27988sc, this.pFF, new AdSlot.Builder().setCodeId(String.valueOf(this.pFF.QT())).setExpressViewAcceptedSize(((Float) pairSc.first).floatValue(), ((Float) pairSc.second).floatValue()).build(), "open_ad", this.ExN, this.Tf, this.UFX);
        this.Ql = pff;
        pff.setTopListener(this.ExN);
        this.Ql.setExpressVideoListenerProxy(this.ExN);
        this.Ql.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.pFF.1
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
                pFF.this.ExN.We();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f11, float f12) {
                if (pFF.this.Ql.Ql()) {
                    pFF.this.SR = true;
                    if (pFF.this.BT != null) {
                        pFF pff2 = pFF.this;
                        if (pff2.We == pff2.BT.getParent()) {
                            pFF pff3 = pFF.this;
                            pff3.We.removeView(pff3.BT);
                        }
                    }
                    pFF pff4 = pFF.this;
                    pFF.super.sc((ViewGroup) pff4.We);
                    pFF.super.sc();
                    pFF.super.pFF();
                    return;
                }
                if (pFF.this.pFF.LVf()) {
                    pFF.this.ExN.zY();
                    return;
                }
                pFF pff5 = pFF.this;
                if (!pff5.zY) {
                    pff5.ExN.zY();
                } else if (!pff5.sc(pff5.Ql.getVideoFrameLayout())) {
                    pFF.this.ExN.We();
                } else {
                    pFF.this.Ql.setVideoManager(pFF.this.qr());
                    pFF.this.ExN.zY();
                }
            }
        });
        this.pFF.Qj(1);
        this.We.addView(this.Ql, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.Ol.qr qrVar = new com.bytedance.sdk.openadsdk.component.Ol.qr(this.f27988sc);
        this.BT = qrVar;
        this.We.addView(qrVar);
        this.Ol = this.BT.getTopDislike();
        com.bytedance.sdk.openadsdk.core.ExN.We topSkip = this.BT.getTopSkip();
        this.WH = topSkip;
        topSkip.setVisibility(4);
    }

    @Override // com.bytedance.sdk.openadsdk.component.zY
    public void zY() {
        super.zY();
        com.bytedance.sdk.openadsdk.component.Ol.pFF pff = this.Ql;
        if (pff != null) {
            pff.UFX();
        }
    }
}
