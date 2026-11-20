package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f27875sc;

    public TRI(sc scVar) {
        this.f27875sc = scVar;
    }

    public void sc(float[] fArr, final com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff, final com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff2) {
        com.bytedance.sdk.openadsdk.activity.TRI tri;
        com.bytedance.sdk.openadsdk.component.reward.view.Qj qj2;
        Arrays.toString(fArr);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(String.valueOf(this.f27875sc.pFF.QT())).setExpressViewAcceptedSize(fArr[0], fArr[1]).build();
        sc scVar = this.f27875sc;
        scVar.cvk.sc(adSlotBuild, scVar.BR.BT);
        sc scVar2 = this.f27875sc;
        SR sr2 = scVar2.cJ;
        if (sr2 != null && (qj2 = scVar2.cvk) != null) {
            sr2.sc(qj2.sc());
        }
        this.f27875sc.cvk.sc(new com.bytedance.sdk.openadsdk.core.Qj.SR() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.1
            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void ExN() {
                TRI.this.f27875sc.Gb.sc(pff2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public int We() {
                if (TRI.this.f27875sc.cvk.zY()) {
                    return 4;
                }
                if (TRI.this.f27875sc.cvk.We()) {
                    return 5;
                }
                if (TRI.this.f27875sc.JPJ.ExN()) {
                    return 1;
                }
                if (TRI.this.f27875sc.JPJ.pFF()) {
                    return 2;
                }
                TRI.this.f27875sc.JPJ.We();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void pFF() {
                if (TRI.this.f27875sc.BR == null || TRI.this.f27875sc.BR.WH() == null) {
                    return;
                }
                TRI.this.f27875sc.BR.WH().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void pFF(int i11) {
                TRI.this.f27875sc.Yhz = i11;
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void sc() {
                TRI.this.f27875sc.cJ.We();
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void sc(int i11) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        TRI.this.f27875sc.JPJ.cvk();
                        return;
                    }
                    if (i11 == 3) {
                        TRI.this.f27875sc.JPJ.sc(pff);
                        return;
                    } else if (i11 == 4) {
                        TRI.this.f27875sc.JPJ.Tf();
                        return;
                    } else if (i11 != 5) {
                        return;
                    }
                }
                if (TRI.this.f27875sc.JPJ.pFF() || TRI.this.f27875sc.JPJ.We()) {
                    return;
                }
                pff.sc(0L, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void sc(int i11, com.bytedance.sdk.component.adexpress.pFF.SR sr3) {
                TRI.this.f27875sc.BR.sc(i11, sr3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void sc(int i11, String str) {
                TRI.this.f27875sc.JPJ.sc(i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void sc(String str, JSONObject jSONObject) {
                if (TRI.this.f27875sc == null || TRI.this.f27875sc.qKn == null) {
                    return;
                }
                TRI.this.f27875sc.qKn.sc(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public void sc(boolean z11) {
                if (TRI.this.f27875sc.f27908eo != z11) {
                    TRI.this.f27875sc.cJ.ExN();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.Qj.SR
            public long zY() {
                return TRI.this.f27875sc.JPJ.Qj();
            }
        });
        this.f27875sc.cvk.sc(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
            public void onAdClicked() {
                if (TRI.this.f27875sc == null || TRI.this.f27875sc.pFF == null || !TRI.this.f27875sc.pFF.Pu()) {
                    return;
                }
                pff.c_();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdShow(View view, int i11) {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i11) {
                if (!TRI.this.f27875sc.pFF.ixT()) {
                    TRI.this.f27875sc.Cb.sc(true);
                    TRI.this.f27875sc.Cb.ExN();
                }
                TRI.this.f27875sc.cvk.ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pff2.sc(false, false, false, 90);
                    }
                });
                TRI.this.f27875sc.BR.Ql();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f11, float f12) {
                com.bytedance.sdk.openadsdk.core.model.Xc xc2;
                if (JPJ.wjp(TRI.this.f27875sc.pFF)) {
                    return;
                }
                if (!TRI.this.f27875sc.pFF.ixT()) {
                    if (TRI.this.f27875sc.cvk.Qj()) {
                        pff2.sc(true);
                        TRI.this.f27875sc.JPJ.We(false);
                    } else {
                        TRI.this.f27875sc.JPJ.We(true);
                    }
                    TRI.this.f27875sc.BR.sc(8);
                    TRI.this.f27875sc.Cb.sc(true);
                    TRI.this.f27875sc.Cb.ExN();
                    if (TRI.this.f27875sc.cvk.Qj()) {
                        TRI.this.f27875sc.cvk.pFF().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        pff2.sc(TRI.this.f27875sc.BR.TRI());
                    } else if (TRI.this.f27875sc.pFF.GI() != null && pff2.sc()) {
                        TRI.this.f27875sc.qfG = true;
                    }
                }
                pff2.cvk();
                if (com.bytedance.sdk.openadsdk.core.model.Xc.zY(TRI.this.f27875sc.pFF) && (xc2 = TRI.this.f27875sc.BR.BT) != null) {
                    xc2.zY();
                }
                if (pff2 instanceof com.bytedance.sdk.openadsdk.component.reward.pFF.TRI) {
                    com.bytedance.sdk.openadsdk.component.reward.pFF.TRI.sc(TRI.this.f27875sc.pFF, TRI.this.f27875sc.cvk.Qj(), TRI.this.f27875sc.ExN);
                    if (!TRI.this.f27875sc.cvk.Qj()) {
                        TRI.this.f27875sc.qKn.TRI();
                    }
                }
                TRI.this.f27875sc.BR.Ql();
            }
        });
        sc scVar3 = this.f27875sc;
        Activity activity = scVar3.CYO;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar3.pFF;
        String str = scVar3.ExN;
        com.bytedance.sdk.openadsdk.core.Qj.Ol ol2 = new com.bytedance.sdk.openadsdk.core.Qj.Ol(activity, sfl, str, cJ.sc(str)) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.3
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                super.sc(view, f11, f12, f13, f14, sparseArray, z11);
            }
        };
        ol2.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.4
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                pff.c_();
            }
        });
        HashMap map = new HashMap();
        if (JPJ.wjp(this.f27875sc.pFF)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        sc scVar4 = this.f27875sc;
        if (scVar4.otH && (tri = scVar4.dix) != null) {
            map.put("ad_show_order", Integer.valueOf(tri.Ol + 1));
        }
        ol2.sc(map);
        sc scVar5 = this.f27875sc;
        Activity activity2 = scVar5.CYO;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl2 = scVar5.pFF;
        String str2 = scVar5.ExN;
        com.bytedance.sdk.openadsdk.core.Qj.Qj qj3 = new com.bytedance.sdk.openadsdk.core.Qj.Qj(activity2, sfl2, str2, cJ.sc(str2)) { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.5
            @Override // com.bytedance.sdk.openadsdk.core.pFF.sc, com.bytedance.sdk.openadsdk.core.pFF.pFF, com.bytedance.sdk.openadsdk.core.pFF.zY
            public void sc(View view, float f11, float f12, float f13, float f14, SparseArray<com.bytedance.sdk.openadsdk.core.pFF.zY.sc> sparseArray, boolean z11) {
                HashMap map2 = new HashMap();
                map2.put("duration", Long.valueOf(TRI.this.f27875sc.JPJ.qr()));
                sc(map2);
                super.sc(view, f11, f12, f13, f14, sparseArray, z11);
            }
        };
        qj3.sc(new com.bytedance.sdk.openadsdk.core.pFF.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.TRI.6
            @Override // com.bytedance.sdk.openadsdk.core.pFF.pFF.sc
            public void sc(View view, int i11) {
                pff.c_();
            }
        });
        HashMap map2 = new HashMap();
        if (JPJ.wjp(this.f27875sc.pFF)) {
            map2.put("click_scence", 3);
        } else {
            map2.put("click_scence", 1);
        }
        qj3.sc(map2);
        this.f27875sc.cvk.sc(ol2, qj3);
        FrameLayout.LayoutParams layoutParams = (this.f27875sc.pFF.ixT() || com.bytedance.sdk.openadsdk.core.UFX.zY.sc(this.f27875sc.pFF.cvk()) || com.bytedance.sdk.openadsdk.core.model.Xc.zY(this.f27875sc.pFF)) ? new FrameLayout.LayoutParams(-1, -1) : new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f27875sc.BR.TRI().addView(this.f27875sc.cvk.sc(), layoutParams);
        if (!this.f27875sc.cvk.Qj()) {
            pff2.sc(false);
        }
        this.f27875sc.cvk.UFX();
    }
}
