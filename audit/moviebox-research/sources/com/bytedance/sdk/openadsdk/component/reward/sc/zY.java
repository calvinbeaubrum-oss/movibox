package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private com.bytedance.sdk.openadsdk.common.BT pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f27943sc;
    private TTAdDislikeToast zY;

    public zY(sc scVar) {
        this.f27943sc = scVar;
    }

    private void pFF(final com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        if (this.pFF == null) {
            sc scVar = this.f27943sc;
            com.bytedance.sdk.openadsdk.common.BT bt2 = new com.bytedance.sdk.openadsdk.common.BT(scVar.CYO, scVar.pFF);
            this.pFF = bt2;
            bt2.setCallback(new com.bytedance.sdk.openadsdk.common.BT.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.zY.1
                @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                public void pFF(View view) {
                    zY.this.f27943sc.UFX.set(false);
                    if (zY.this.f27943sc.JPJ.ExN) {
                        if (zY.this.f27943sc.cvk != null) {
                            zY.this.f27943sc.cvk.sc(0, true);
                        }
                    } else {
                        zY.this.f27943sc.JPJ.sc(pff);
                        if (zY.this.f27943sc.JPJ.We()) {
                            zY.this.f27943sc.JPJ.SR();
                        }
                        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(zY.this.f27943sc.pFF, 4);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                public void sc(View view) {
                    zY.this.f27943sc.UFX.set(true);
                    String str = "landing_page";
                    if (!com.bytedance.sdk.openadsdk.core.model.Xc.pFF(zY.this.f27943sc.pFF) && !com.bytedance.sdk.openadsdk.core.model.Xc.We(zY.this.f27943sc.pFF) && !com.bytedance.sdk.openadsdk.core.model.Xc.ExN(zY.this.f27943sc.pFF)) {
                        if (!zY.this.f27943sc.WH.get()) {
                            str = "video_player";
                        } else if (JPJ.pFF(zY.this.f27943sc.pFF)) {
                            str = "playable";
                        } else if (!zY.this.f27943sc.pFF.kX()) {
                            str = CampaignEx.JSON_NATIVE_VIDEO_ENDCARD;
                        }
                    }
                    zY.this.pFF.setDislikeSource(str);
                    if (zY.this.f27943sc.JPJ.ExN) {
                        if (zY.this.f27943sc.cvk != null) {
                            zY.this.f27943sc.cvk.sc(8, false);
                        }
                    } else {
                        pff.dE();
                        if (zY.this.f27943sc.JPJ.pFF()) {
                            zY.this.f27943sc.JPJ.BT();
                        }
                        com.bytedance.sdk.openadsdk.JPJ.sc.zY.sc(zY.this.f27943sc.pFF, 8);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.common.BT.sc
                public void sc(FilterWord filterWord) {
                    if (zY.this.f27943sc.Tf.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    zY.this.f27943sc.Tf.set(true);
                    zY.this.zY();
                }
            });
            ((FrameLayout) this.f27943sc.CYO.findViewById(R.id.content)).addView(this.pFF);
        }
        if (this.zY == null) {
            this.zY = new TTAdDislikeToast(this.f27943sc.CYO);
            ((FrameLayout) this.f27943sc.CYO.findViewById(R.id.content)).addView(this.zY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        this.zY.show(TTAdDislikeToast.getDislikeSendTip());
    }

    public void pFF() {
        TTAdDislikeToast tTAdDislikeToast = this.zY;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.onDestroy();
        }
    }

    public void sc() {
        TTAdDislikeToast tTAdDislikeToast = this.zY;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.hide();
        }
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        if (this.f27943sc.CYO.isFinishing()) {
            return;
        }
        if (this.f27943sc.Tf.get()) {
            this.zY.show(TTAdDislikeToast.getDislikeTip());
            return;
        }
        if (this.pFF == null) {
            try {
                pFF(pff);
            } catch (Throwable th2) {
                ApmHelper.reportCustomError("initDislike error", "RewardFullDislikeManager", th2);
            }
        }
        com.bytedance.sdk.openadsdk.common.BT bt2 = this.pFF;
        if (bt2 != null) {
            bt2.sc();
        }
    }
}
