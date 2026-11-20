package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT {
    private String Ol;
    private volatile long Qj;
    private com.bytedance.adsdk.ugeno.pFF.zY Ql;
    private com.bytedance.adsdk.ugeno.pFF.zY SR;
    private volatile long TRI;
    private boolean Xc;
    private final sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private volatile long f27850qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final com.bytedance.sdk.openadsdk.core.model.Sfl f27851sc;
    private FrameLayout zY;
    private final AtomicBoolean We = new AtomicBoolean(false);
    private final AtomicBoolean ExN = new AtomicBoolean(false);
    private final AtomicBoolean WH = new AtomicBoolean(false);
    private long UFX = 0;
    private long Tf = 0;
    private String BT = null;
    private boolean dE = false;

    public BT(sc scVar) {
        this.pFF = scVar;
        this.f27851sc = scVar.pFF;
        this.Ol = scVar.ExN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SR() {
        com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVarNT;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27851sc;
        if (sfl == null || (scVarNT = sfl.NT()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.UFX.zY.pFF pff = new com.bytedance.sdk.openadsdk.core.UFX.zY.pFF(this.pFF.CYO, this.f27851sc, scVarNT, this.Ol, new com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.BT.3
            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
            public void pFF(String str) {
                BT bt2 = BT.this;
                com.bytedance.sdk.openadsdk.We.zY.sc(bt2.f27851sc, true, bt2.Ol, "success", SystemClock.elapsedRealtime() - BT.this.Tf, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF
            public void sc() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF
            public void sc(int i11, String str) {
                BT.this.ExN.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
            public void sc(int i11, String str, String str2) {
                BT.this.ExN.set(false);
                BT bt2 = BT.this;
                com.bytedance.sdk.openadsdk.We.zY.sc(bt2.f27851sc, true, bt2.Ol, "fail", SystemClock.elapsedRealtime() - BT.this.Tf, str2, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF
            public void sc(com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
                BT.this.SR = zYVar;
                BT.this.ExN.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
            public void sc(String str) {
                BT.this.Tf = SystemClock.elapsedRealtime();
            }
        });
        pff.sc(new com.bytedance.sdk.openadsdk.core.UFX.ExN.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.BT.4
            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.sc
            public void pFF() {
                BT.this.dE = true;
                BT.this.pFF.BR.WH().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.sc
            public String sc() {
                return "overlay";
            }
        });
        pff.sc();
        pff.sc(this.pFF.BR.WH());
    }

    public void ExN() {
        this.TRI = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.We.zY.sc(this.f27851sc, this.Ol);
    }

    public void Ol() {
        if (this.Qj <= 0 || this.f27850qr <= 0 || this.WH.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.f27850qr - this.Qj, this.f27851sc, this.Ol, this.BT);
    }

    public void Qj() {
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.SR;
        if (zYVar != null) {
            this.zY.addView(zYVar.Ol(), new FrameLayout.LayoutParams(this.SR.Cb(), this.SR.OXF()));
        }
    }

    public boolean Ql() {
        return this.ExN.get();
    }

    public void TRI() {
        this.Qj = SystemClock.elapsedRealtime();
    }

    public boolean Tf() {
        return this.We.get();
    }

    public void UFX() {
        com.bytedance.sdk.openadsdk.We.zY.sc(SystemClock.elapsedRealtime() - this.Qj, this.f27851sc, this.Ol);
    }

    public void WH() {
        com.bytedance.sdk.openadsdk.We.zY.zY(this.f27851sc, this.Ol);
    }

    public boolean We() {
        return this.dE;
    }

    public void pFF() {
        this.zY = (FrameLayout) this.pFF.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.BT);
    }

    public void qr() {
        WH();
        Ol();
        com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.Ql;
        if (zYVar != null) {
            this.zY.addView(zYVar.Ol(), new FrameLayout.LayoutParams(this.Ql.Cb(), this.Ql.OXF()));
        }
    }

    public void sc() {
        if (this.Xc) {
            return;
        }
        this.Xc = true;
        pFF();
    }

    public void sc(int i11) {
        kX.sc((View) this.zY, i11);
    }

    public void zY() {
        com.bytedance.sdk.openadsdk.core.UFX.TRI.sc scVarCwg;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = this.f27851sc;
        if (sfl == null || (scVarCwg = sfl.Cwg()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.UFX.zY.pFF pff = new com.bytedance.sdk.openadsdk.core.UFX.zY.pFF(this.pFF.CYO, this.f27851sc, scVarCwg, this.Ol, new com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.BT.1
            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
            public void pFF(String str) {
                BT.this.BT = str;
                BT bt2 = BT.this;
                com.bytedance.sdk.openadsdk.We.zY.sc(bt2.f27851sc, false, bt2.Ol, "success", SystemClock.elapsedRealtime() - BT.this.UFX, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF
            public void sc() {
                BT.this.ExN();
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF
            public void sc(int i11, String str) {
                BT.this.We.set(false);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                BT bt2 = BT.this;
                com.bytedance.sdk.openadsdk.We.zY.sc(bt2.f27851sc, bt2.Ol, jElapsedRealtime - BT.this.TRI, i11, str, (String) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
            public void sc(int i11, String str, String str2) {
                BT.this.BT = str2;
                BT.this.We.set(false);
                BT bt2 = BT.this;
                com.bytedance.sdk.openadsdk.We.zY.sc(bt2.f27851sc, false, bt2.Ol, "fail", SystemClock.elapsedRealtime() - BT.this.UFX, str2, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, i11, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.pFF
            public void sc(com.bytedance.adsdk.ugeno.pFF.zY<View> zYVar) {
                BT.this.Ql = zYVar;
                BT.this.We.set(true);
                BT.this.f27850qr = SystemClock.elapsedRealtime();
                if (BT.this.pFF.Cb.cvk()) {
                    View viewWH = BT.this.pFF.BR.WH();
                    if (viewWH instanceof com.bytedance.sdk.openadsdk.core.ExN.We) {
                        ((com.bytedance.sdk.openadsdk.core.ExN.We) viewWH).setImageResource(com.bytedance.sdk.component.utils.Sfl.We(BT.this.pFF.f27911pc, "tt_skip_btn"));
                    }
                }
                BT.this.SR();
                BT.this.Ol();
                BT bt2 = BT.this;
                com.bytedance.sdk.openadsdk.We.zY.sc(bt2.f27851sc, bt2.Ol, BT.this.f27850qr - BT.this.TRI);
            }

            @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.zY
            public void sc(String str) {
                BT.this.UFX = SystemClock.elapsedRealtime();
            }
        });
        if (this.f27851sc.NT() != null) {
            pff.sc(new com.bytedance.sdk.openadsdk.core.UFX.ExN.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.BT.2
                @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.sc
                public void pFF() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.UFX.ExN.sc
                public String sc() {
                    return "normal";
                }
            });
        }
        pff.sc();
        pff.sc(this.pFF.BR.WH());
    }
}
