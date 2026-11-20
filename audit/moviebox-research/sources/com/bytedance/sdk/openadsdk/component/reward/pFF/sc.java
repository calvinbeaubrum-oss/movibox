package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.openadsdk.component.reward.sc.SR;
import com.bytedance.sdk.openadsdk.component.reward.sc.Xc;
import com.bytedance.sdk.openadsdk.component.reward.sc.wjp;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    protected final Xc ExN;
    protected com.bytedance.sdk.openadsdk.core.Ql.We.pFF Ol;
    protected final SR Qj;
    protected final com.bytedance.sdk.openadsdk.component.reward.view.WH TRI;
    protected FI WH;
    protected int We;
    protected Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected final wjp f27844qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.component.reward.sc.sc f27845sc;
    protected int zY;

    public sc(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.f27845sc = scVar;
        this.pFF = scVar.pFF;
        this.zY = scVar.f27909ht;
        this.We = scVar.ZM;
        this.ExN = scVar.JPJ;
        this.TRI = scVar.BR;
        this.f27844qr = scVar.Cb;
        this.Qj = scVar.cJ;
    }

    public boolean pFF() {
        if (!com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.f27845sc.pFF) || !this.f27845sc.Sfl.get()) {
            return (this.f27845sc.WH.get() || this.f27845sc.UFX.get() || JPJ.wjp(this.f27845sc.pFF)) ? false : true;
        }
        FrameLayout frameLayoutTRI = this.f27845sc.BR.TRI();
        frameLayoutTRI.setVisibility(4);
        frameLayoutTRI.setVisibility(0);
        return false;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff, FI fi2) {
        this.Ol = pff;
        this.WH = fi2;
    }

    public void sc(boolean z11) {
        if (this.f27845sc.WH.get()) {
            return;
        }
        Sfl sfl = this.pFF;
        if (sfl != null && sfl.ixT()) {
            this.Qj.zY(false);
            this.Qj.sc(true);
            this.f27845sc.BR.pFF(8);
            this.f27845sc.BR.zY(8);
            return;
        }
        if (z11) {
            this.Qj.sc(this.f27845sc.pFF.vYl());
            if (JPJ.wjp(this.f27845sc.pFF) || sc()) {
                this.Qj.zY(true);
            }
            if (sc() || ((this instanceof Qj) && this.f27845sc.pFF.sc())) {
                this.Qj.We(true);
            } else {
                this.Qj.TRI();
                this.f27845sc.BR.ExN(0);
            }
        } else {
            this.Qj.zY(false);
            this.Qj.sc(false);
            this.Qj.We(false);
            this.f27845sc.BR.ExN(8);
        }
        if (!z11) {
            this.f27845sc.BR.pFF(4);
            this.f27845sc.BR.zY(8);
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        if (scVar.f27910ko != com.bytedance.sdk.openadsdk.component.reward.view.pFF.f27964sc) {
            scVar.BR.pFF(8);
            this.f27845sc.BR.zY(8);
        } else {
            scVar.BR.pFF(0);
            this.f27845sc.BR.zY(0);
        }
    }

    public boolean sc() {
        return this.f27845sc.pFF.ymG() || this.f27845sc.pFF.dix() == 15 || this.f27845sc.pFF.dix() == 5 || this.f27845sc.pFF.dix() == 50;
    }

    public void zY() {
        if (JPJ.pFF(this.f27845sc.pFF) && DeviceUtils.qr() == 0) {
            this.f27845sc.f27908eo = true;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
        scVar.cJ.pFF(scVar.f27908eo);
    }
}
