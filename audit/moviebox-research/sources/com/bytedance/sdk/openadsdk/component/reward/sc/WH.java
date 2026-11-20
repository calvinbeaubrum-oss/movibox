package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.google.logging.type.LogSeverity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH implements com.bytedance.sdk.openadsdk.Tf.qr {
    protected boolean BT;

    @NonNull
    protected final com.bytedance.sdk.openadsdk.core.model.Sfl Ol;
    protected final Activity Qj;
    protected boolean Ql;
    protected boolean SR;
    protected boolean Tf;
    protected final sc UFX;
    protected final String WH;
    protected com.bytedance.sdk.openadsdk.Sfl.sc.sc Xc;
    protected FrameLayout dE;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected volatile boolean f27895qr;
    protected AtomicBoolean wjp = new AtomicBoolean(false);

    public WH(sc scVar) {
        this.UFX = scVar;
        this.Qj = scVar.CYO;
        this.WH = scVar.ExN;
        com.bytedance.sdk.openadsdk.core.model.Sfl sfl = scVar.pFF;
        this.Ol = sfl;
        this.Ql = JPJ.ExN(sfl);
    }

    private void qr() {
        int iJcs = this.Ol.jcs();
        if (iJcs == -1) {
            if (JPJ.Ol(this.Ol)) {
                com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Xc;
                if (scVar == null || !scVar.ExN()) {
                    this.UFX.kDg.FI();
                    return;
                } else {
                    this.UFX.Sfl.set(true);
                    this.UFX.kDg.BT();
                }
            } else {
                this.UFX.Sfl.set(true);
                this.UFX.kDg.BT();
            }
        } else {
            if (iJcs < 0) {
                return;
            }
            this.UFX.cJ.We(false);
            if (JPJ.Ol(this.Ol)) {
                com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar2 = this.Xc;
                if (scVar2 == null || !scVar2.ExN()) {
                    this.UFX.GI.sendEmptyMessageDelayed(1, iJcs);
                    return;
                }
                this.UFX.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, iJcs);
            } else {
                this.UFX.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, iJcs);
            }
        }
        com.bytedance.sdk.openadsdk.utils.Tf tf2 = this.UFX.NP;
        if (tf2 != null) {
            tf2.sc(iJcs);
        }
    }

    public void ExN() {
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar;
        if (!this.Ql || this.wjp.get() || (scVar = this.Xc) == null) {
            return;
        }
        scVar.zY();
    }

    public boolean Ol() {
        return false;
    }

    public void Qj() {
    }

    public void TRI() {
        if (this.Ql && !this.BT) {
            this.BT = true;
            com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Xc;
            if (scVar != null) {
                scVar.We();
            }
            FrameLayout frameLayout = this.dE;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            DeviceUtils.AudioInfoReceiver.pFF(this);
        }
    }

    public void UFX() {
        if (!this.wjp.compareAndSet(false, true)) {
            this.UFX.Cb.Ol();
            return;
        }
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Xc;
        if (scVar != null) {
            scVar.sc(true);
        }
        this.UFX.Cb.TRI(true);
        sc scVar2 = this.UFX;
        scVar2.kX.sc(true, scVar2.kDg);
        if (this.UFX.kX.qr()) {
            sc scVar3 = this.UFX;
            scVar3.NP.sc(scVar3.Qj);
            return;
        }
        sc scVar4 = this.UFX;
        scVar4.Cb.sc(scVar4.f27908eo, true);
        this.UFX.Cb.zY(true);
        this.UFX.Cb.pFF(true);
        this.UFX.GI.removeMessages(LogSeverity.CRITICAL_VALUE);
    }

    public boolean WH() {
        return this.f27895qr;
    }

    public void We() {
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar;
        if (!this.Ql || this.wjp.get() || (scVar = this.Xc) == null) {
            return;
        }
        scVar.pFF();
    }

    public com.bytedance.sdk.openadsdk.Tf.ExN pFF() {
        return new com.bytedance.sdk.openadsdk.Tf.ExN() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.WH.1
            @Override // com.bytedance.sdk.openadsdk.Tf.ExN
            public void sc() {
                WH.this.UFX.qKn.sc(false);
            }
        };
    }

    public void pFF(int i11) {
    }

    public void pFF(boolean z11) {
        if (this.Ql) {
            sc scVar = this.UFX;
            if (scVar.MxZ) {
                this.dE = (FrameLayout) scVar.JoC.findViewById(com.bytedance.sdk.openadsdk.utils.SR.Ay);
                sc(z11);
            }
        }
    }

    public void sc() {
        if (this.Ql && !this.Tf) {
            this.Tf = true;
            DeviceUtils.AudioInfoReceiver.sc(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Tf.qr
    public void sc(int i11) {
        if (this.UFX.cD.pFF()) {
            sc scVar = this.UFX;
            boolean z11 = scVar.f27908eo;
            scVar.cD.sc();
            if (i11 == 0) {
                this.UFX.cJ.pFF(true);
                zY(true);
                return;
            } else {
                this.UFX.cJ.pFF(false);
                zY(false);
                return;
            }
        }
        this.UFX.cD.sc(-1);
        sc scVar2 = this.UFX;
        boolean z12 = scVar2.f27908eo;
        scVar2.cD.sc();
        sc scVar3 = this.UFX;
        if (scVar3.yL) {
            if (i11 == 0) {
                scVar3.f27908eo = true;
                scVar3.cJ.pFF(true);
                zY(true);
            } else {
                scVar3.f27908eo = false;
                scVar3.cJ.pFF(false);
                zY(false);
            }
        }
    }

    public void sc(long j11) {
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar;
        if (this.Ql && (scVar = this.Xc) != null) {
            scVar.sc(exN);
        }
    }

    public void sc(boolean z11) {
        FrameLayout frameLayout = this.dE;
        if (frameLayout != null) {
            sc scVar = this.UFX;
            com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar2 = new com.bytedance.sdk.openadsdk.Sfl.sc.sc(scVar.f27911pc, this.Ol, scVar.OKY, z11, frameLayout);
            this.Xc = scVar2;
            scVar2.sc(this.UFX.qKn);
            this.Xc.sc(true, pFF());
        }
    }

    public void zY() {
        if (this.Ql) {
            this.f27895qr = true;
            zY(this.UFX.f27908eo);
            this.Xc.sc();
            qr();
            if (JPJ.WH(this.Ol)) {
                this.UFX.Cb.TRI();
            }
        }
    }

    public void zY(boolean z11) {
        if (this.Ql && this.Xc != null && this.f27895qr) {
            this.Xc.sc(z11);
        }
    }
}
