package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH extends pFF {
    public WH(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
    }

    public static boolean sc(Sfl sfl) {
        return JPJ.qr(sfl) || JPJ.wjp(sfl);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void Dl() {
        super.Dl();
        if (JPJ.wjp(this.f27845sc.pFF)) {
            this.WH.removeMessages(LogSeverity.CRITICAL_VALUE);
            this.f27845sc.WP.zY("go_background");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean ExN() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void Sfl() {
        if (this.f27845sc.WP.Qj(com.bytedance.sdk.openadsdk.component.reward.sc.Qj.zY) && JPJ.wjp(this.f27845sc.pFF)) {
            this.f27845sc.WP.zY("return_foreground");
            com.bytedance.sdk.openadsdk.core.widget.pFF pff = this.Ql;
            if ((pff == null || !pff.isShowing()) && this.f27845sc.WP.pFF() >= 0.0f) {
                this.f27845sc.WP.ExN(0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean TRI() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void Xc() {
        if (JPJ.Qj(this.pFF) && this.f27845sc.Cb.JoC() && !this.f27845sc.Cb.pc()) {
            wjp();
        }
        if (JPJ.qr(this.f27845sc.pFF)) {
            if (DeviceUtils.qr() == 0) {
                this.f27845sc.f27908eo = true;
            }
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            if (scVar.f27908eo) {
                scVar.cJ.pFF(true);
                this.f27845sc.cD.sc(true);
            }
        }
        this.f27845sc.NP.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void YIK() {
        super.YIK();
        if (JPJ.wjp(this.f27845sc.pFF)) {
            this.WH.removeMessages(LogSeverity.CRITICAL_VALUE);
            this.f27845sc.WP.zY("go_background");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void qr() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(FrameLayout frameLayout) {
    }
}
