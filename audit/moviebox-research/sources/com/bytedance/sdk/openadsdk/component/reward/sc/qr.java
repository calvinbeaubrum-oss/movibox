package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends WH implements Handler.Callback {
    int ExN;
    private final Handler Sfl;
    boolean TRI;
    int We;
    long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    boolean f27906sc;
    int zY;

    public qr(sc scVar) {
        super(scVar);
        this.Sfl = new Handler(this);
        this.f27906sc = false;
        this.pFF = 0L;
        this.zY = 0;
        this.We = 0;
        this.ExN = 0;
        this.TRI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        boolean z11 = (1.0f - (((float) this.zY) / ((float) this.We))) * 100.0f >= ((float) com.bytedance.sdk.openadsdk.core.Xc.We().II(String.valueOf(this.UFX.TRI)).TRI);
        int iSc = com.bytedance.sdk.openadsdk.core.Xc.We().sc(String.valueOf(this.UFX.TRI));
        if (iSc == 0) {
            com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Xc;
            boolean zTRI = scVar != null ? scVar.TRI() : false;
            if (this.SR) {
                zTRI = true;
            }
            if (!z11 || !zTRI) {
                return;
            }
        } else if (iSc != 1 || !z11) {
            return;
        }
        this.UFX.qKn.sc(true);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void ExN() {
        if (this.Ql) {
            super.ExN();
            if (JPJ.zY(this.UFX.pFF)) {
                this.UFX.GI.removeMessages(LogSeverity.CRITICAL_VALUE);
            }
            this.Sfl.removeMessages(900);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public boolean Ol() {
        return this.TRI;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void Qj() {
        if (this.Ql) {
            this.Sfl.removeMessages(900);
            this.Sfl.removeMessages(LogSeverity.CRITICAL_VALUE);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void TRI() {
        if (this.Ql && !this.BT) {
            super.TRI();
            this.Sfl.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void We() {
        com.bytedance.sdk.openadsdk.core.widget.pFF pff;
        if (this.Ql) {
            super.We();
            if (DeviceUtils.qr() == 0) {
                this.UFX.f27908eo = true;
            }
            sc scVar = this.UFX;
            if (scVar.f27908eo) {
                scVar.cJ.pFF(true);
                zY(true);
            }
            com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff2 = this.UFX.kDg;
            if ((pff2 == null || (pff = pff2.Ql) == null || !pff.isShowing()) && qr() > 0) {
                sc(0L);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 900 && this.f27895qr && JPJ.zY(this.UFX.pFF) && !this.wjp.get()) {
            int i11 = message.arg1;
            if (i11 > 0) {
                this.UFX.cJ.We(true);
                int i12 = this.ExN - (this.We - i11);
                if (i12 == i11) {
                    this.UFX.cJ.sc(String.valueOf(i11), null);
                } else if (i12 > 0) {
                    this.UFX.cJ.sc(String.valueOf(i11), String.format(com.bytedance.sdk.component.utils.Sfl.sc(this.UFX.CYO.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(i12)));
                } else {
                    this.TRI = true;
                    if (JPJ.WH(this.UFX.pFF)) {
                        this.UFX.cJ.zY();
                        this.UFX.cJ.ExN(true);
                    } else {
                        this.UFX.Sfl.set(true);
                        this.UFX.kDg.BT();
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 900;
                int i13 = i11 - 1;
                messageObtain.arg1 = i13;
                this.Sfl.sendMessageDelayed(messageObtain, 1000L);
                this.zY = i13;
            } else {
                this.TRI = true;
                if (!JPJ.WH(this.Ol) || (JPJ.JPJ(this.Ol) && this.Xc.ExN())) {
                    this.UFX.cJ.We(false);
                    this.UFX.Sfl.set(true);
                    this.UFX.kDg.BT();
                } else {
                    this.UFX.cJ.zY();
                    this.UFX.cJ.ExN(true);
                }
                com.bytedance.sdk.openadsdk.Sfl.sc.sc scVar = this.Xc;
                if (scVar == null || scVar.ExN()) {
                    this.SR = true;
                }
            }
            Tf();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public com.bytedance.sdk.openadsdk.Tf.ExN pFF() {
        return new com.bytedance.sdk.openadsdk.Tf.ExN() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.qr.1
            @Override // com.bytedance.sdk.openadsdk.Tf.ExN
            public void sc() {
                qr.this.Tf();
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void pFF(int i11) {
        this.zY = i11;
    }

    public int qr() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void sc() {
        if (this.Ql && !this.Tf) {
            super.sc();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void sc(long j11) {
        if (this.Ql && this.f27895qr) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            messageObtain.arg1 = qr();
            this.Sfl.sendMessageDelayed(messageObtain, j11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void sc(boolean z11) {
        if (this.dE != null) {
            try {
                com.bytedance.sdk.openadsdk.Sfl.sc.pFF pffSc = com.bytedance.sdk.openadsdk.Sfl.sc.We.sc().sc(this.Ol, this.dE, pFF());
                this.Xc = pffSc;
                pffSc.sc(this.UFX.qKn);
            } catch (Throwable unused) {
                com.bytedance.sdk.component.utils.Tf.sc("RVIVPlayableNewManager", "PreRender injection exception");
            }
            if (this.Xc == null) {
                super.sc(z11);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.sc.WH
    public void zY() {
        if (this.Ql) {
            this.f27895qr = true;
            this.Xc.sc();
            if (JPJ.WH(this.Ol)) {
                this.UFX.Cb.TRI();
            }
            this.We = this.Ol.ds();
            this.ExN = com.bytedance.sdk.openadsdk.core.Xc.We().sc(String.valueOf(this.UFX.TRI), this.Ol.xP());
            this.pFF = System.currentTimeMillis();
            Handler handler = this.Sfl;
            handler.sendMessage(handler.obtainMessage(900, this.We, 0));
            this.UFX.qKn.UFX();
        }
    }
}
