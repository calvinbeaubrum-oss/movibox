package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.utils.YIK;
import com.bytedance.sdk.openadsdk.utils.kX;
import com.google.logging.type.LogSeverity;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {
    private final com.bytedance.sdk.openadsdk.component.reward.view.TRI pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc f27856sc;
    private sc zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void dE();

        void sc(boolean z11, boolean z12, boolean z13, com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff, int i11);
    }

    public ExN(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.f27856sc = scVar;
        this.pFF = new com.bytedance.sdk.openadsdk.component.reward.view.TRI(scVar);
    }

    private void Ol() {
        if (JPJ.Sfl(this.f27856sc.pFF)) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27856sc;
            if (scVar.f27908eo) {
                scVar.cJ.pFF(true);
                this.f27856sc.cD.sc(true);
            }
        }
    }

    private int Qj() {
        int iHC = this.f27856sc.pFF.HC();
        if (iHC <= 5000 && iHC >= 0) {
            if (iHC < 1000) {
                iHC += 1000;
            }
            int iSc = com.bytedance.sdk.openadsdk.core.Xc.We().sc(this.f27856sc.pFF.QT());
            if (iSc <= 5000 && iSc >= 0) {
                if (iSc < 1000) {
                    iSc += 1000;
                }
                return Math.min(iHC, iSc);
            }
        }
        return -1;
    }

    private boolean pFF(boolean z11) {
        com.bytedance.sdk.openadsdk.component.reward.view.pFF pffSc;
        if (!com.bytedance.sdk.openadsdk.core.model.Xc.zY(this.f27856sc.pFF) || (pffSc = this.f27856sc.cvk.sc()) == null || pffSc.We != 0 || z11) {
            return true;
        }
        this.f27856sc.cJ.zY(false);
        return false;
    }

    public boolean ExN() {
        com.bytedance.sdk.openadsdk.component.reward.view.TRI tri = this.pFF;
        if (tri != null) {
            return tri.ExN();
        }
        return false;
    }

    public sc TRI() {
        return this.zY;
    }

    public void We() {
        sc(true);
    }

    public void pFF() {
        this.pFF.zY();
    }

    public void pFF(com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        int iJcs = this.f27856sc.pFF.jcs();
        if (JPJ.wjp(this.f27856sc.pFF)) {
            iJcs = (this.f27856sc.pFF.ds() + 1) * 1000;
        }
        if (iJcs == -1) {
            if (JPJ.Qj(this.f27856sc.pFF)) {
                if (JPJ.JPJ(this.f27856sc.pFF) && this.f27856sc.WP.qr()) {
                    pff.BT();
                    return;
                } else {
                    pff.FI();
                    return;
                }
            }
            pff.BT();
        } else {
            if (iJcs < 0) {
                return;
            }
            this.f27856sc.cJ.We(false);
            if (!JPJ.Qj(this.f27856sc.pFF)) {
                this.f27856sc.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, iJcs);
            } else {
                if (!JPJ.JPJ(this.f27856sc.pFF) || !this.f27856sc.WP.qr()) {
                    this.f27856sc.GI.sendEmptyMessageDelayed(1, iJcs);
                    return;
                }
                this.f27856sc.GI.sendEmptyMessageDelayed(LogSeverity.CRITICAL_VALUE, iJcs);
            }
        }
        com.bytedance.sdk.openadsdk.utils.Tf tf2 = this.f27856sc.NP;
        if (tf2 != null) {
            tf2.sc(iJcs);
        }
    }

    public boolean qr() {
        return this.pFF.TRI();
    }

    public void sc() {
        this.pFF.sc();
    }

    public void sc(com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        this.f27856sc.Cb.sc(0.0f);
        this.f27856sc.BR.sc(0.0f);
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.f27856sc.pFF)) {
            this.f27856sc.Cb.pFF(8);
            this.f27856sc.OXF.sc(0);
            this.f27856sc.OXF.qr();
        } else {
            this.f27856sc.OXF.sc(8);
            this.f27856sc.Cb.pFF(0);
            this.f27856sc.Cb.qKn();
        }
        if (this.f27856sc.f27912qr) {
            kX.sc((View) pff.SR, 0);
            this.f27856sc.BR.ExN(8);
        }
        this.f27856sc.BR.zY(8);
        this.f27856sc.BR.qr();
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.f27856sc.pFF)) {
            this.f27856sc.GI.sendEmptyMessageDelayed(LogSeverity.EMERGENCY_VALUE, 100L);
            return;
        }
        this.f27856sc.GI.sendEmptyMessageDelayed(500, 100L);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27856sc;
        scVar.Cb.sc(scVar.f27908eo, true);
        this.f27856sc.Cb.zY(true);
        this.f27856sc.Cb.pFF(true);
        HJN hjnTf = this.f27856sc.Cb.Tf();
        if (hjnTf != null) {
            hjnTf.sc("prerender_page_show", (JSONObject) null);
        }
    }

    public void sc(sc scVar) {
        this.zY = scVar;
    }

    public void sc(com.bytedance.sdk.openadsdk.core.pFF.ExN exN) {
        this.pFF.sc(exN);
    }

    public void sc(boolean z11) {
        if (!com.bytedance.sdk.openadsdk.core.model.Sfl.We(this.f27856sc.pFF)) {
            this.f27856sc.Cb.sc(false, TTAdConstant.DOWNLOAD_URL_CODE, "end_card_timeout");
        }
        this.f27856sc.Cb.cD();
        this.f27856sc.Cb.pFF(8);
        this.f27856sc.OXF.sc(8);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27856sc;
        if (scVar.f27912qr) {
            kX.sc((View) scVar.kDg.SR, 8);
            this.f27856sc.BR.ExN(0);
        }
        this.f27856sc.BR.zY(8);
        if (!this.f27856sc.pFF.ymG()) {
            com.bytedance.sdk.openadsdk.activity.TRI tri = this.f27856sc.dix;
            if (tri != null) {
                this.pFF.sc(tri.FI().qr());
            }
            this.pFF.pFF();
        } else if (!this.pFF.sc(this.f27856sc.JPJ)) {
            this.f27856sc.CYO.finish();
        }
        this.f27856sc.BR.qr();
        if (z11) {
            zY(this.f27856sc.kDg);
        }
        this.f27856sc.cJ.zY(false);
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27856sc;
        scVar2.McK.sc(scVar2.pFF.xP());
    }

    public void sc(boolean z11, com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        BT bt2;
        if (JPJ.wjp(this.f27856sc.pFF)) {
            return;
        }
        this.f27856sc.wjp.set(z11);
        pff.SR();
        if (this.f27856sc.pFF.ymG()) {
            this.f27856sc.cJ.We(false);
        } else {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27856sc;
            scVar.cJ.We(JPJ.wjp(scVar.pFF));
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27856sc;
        scVar2.cJ.zY(JPJ.qr(scVar2.pFF));
        if (this.f27856sc.pFF.sc() && JPJ.qr(this.f27856sc.pFF) && z11) {
            this.f27856sc.cJ.We(true);
        }
        this.f27856sc.Cb.HJN();
        com.bytedance.sdk.openadsdk.core.model.Xc xc2 = this.f27856sc.BR.BT;
        if (xc2 != null) {
            xc2.ExN();
        }
        this.f27856sc.BR.zY();
        com.bytedance.sdk.openadsdk.component.reward.view.Qj qj2 = this.f27856sc.cvk;
        if (qj2 != null) {
            qj2.TRI();
        }
        Qj qj3 = this.f27856sc.WP;
        if (qj3 != null) {
            qj3.qr(Qj.pFF);
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27856sc;
        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.Sfl.sc(scVar3.f27911pc, scVar3.pFF))) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.f27856sc;
            YIK.sc(scVar4.CYO, JPJ.Ql(scVar4.pFF), this.f27856sc.pFF, com.bytedance.sdk.openadsdk.We.pFF.sc.zY);
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.f27856sc.pFF) && (bt2 = this.f27856sc.OXF) != null) {
            bt2.TRI();
        }
        if (!com.bytedance.sdk.openadsdk.core.model.Sfl.sc(this.f27856sc.pFF) && (com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.f27856sc.pFF) || !this.f27856sc.Cb.CYO())) {
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar5 = this.f27856sc;
            if (com.bytedance.sdk.openadsdk.core.model.Sfl.sc(scVar5.pFF, scVar5.Cb.wjp(), this.f27856sc.Cb.GI(), this.f27856sc.OXF.Tf(), this.f27856sc.Cb.Gb()) || JPJ.qr(this.f27856sc.pFF)) {
                if (!com.bytedance.sdk.openadsdk.core.model.Sfl.We(this.f27856sc.pFF) && !JPJ.qr(this.f27856sc.pFF) && !com.bytedance.sdk.openadsdk.core.model.Sfl.zY(this.f27856sc.pFF)) {
                    this.f27856sc.Cb.sc(true, 0, (String) null);
                }
                if (!JPJ.qr(this.f27856sc.pFF)) {
                    zY(pff);
                } else {
                    if (JPJ.JPJ(this.f27856sc.pFF) && !this.f27856sc.Cb.BR()) {
                        if (!this.f27856sc.Cb.wjp()) {
                            if (this.f27856sc.WP.We() != null) {
                                this.f27856sc.WP.We().sc(2);
                            }
                            this.f27856sc.WP.ExN();
                            return;
                        } else {
                            if (this.f27856sc.WP.We() != null) {
                                this.f27856sc.WP.We().sc(-1);
                            }
                            this.f27856sc.WP.TRI();
                            this.f27856sc.cJ.We(false);
                            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar6 = this.f27856sc;
                            scVar6.WP.sc(scVar6.McK.ExN());
                            return;
                        }
                    }
                    if (this.f27856sc.Cb.BR() && this.f27856sc.WP.We() != null) {
                        this.f27856sc.WP.We().sc(1);
                    }
                    pFF(pff);
                }
                sc(pff);
                return;
            }
        }
        We();
    }

    public void sc(boolean z11, boolean z12, boolean z13, com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff, int i11) {
        int i12;
        if (this.f27856sc != null) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("videoForceBreak", this.f27856sc.pFF);
            com.bytedance.sdk.openadsdk.JPJ.sc.zY.pFF(this.f27856sc.pFF);
        }
        Objects.toString(pff);
        if (this.f27856sc.CYO.isFinishing() || pff == null) {
            return;
        }
        this.f27856sc.BR.Tf();
        if (z12) {
            this.f27856sc.BT.set(true);
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27856sc;
        boolean z14 = false;
        if (scVar.DNB && !scVar.dE.get() && !com.bytedance.sdk.openadsdk.core.model.Xc.Ol(this.f27856sc.pFF) && (!com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.f27856sc.pFF) || !this.f27856sc.BT.get() || !this.f27856sc.Xc.get())) {
            if ((com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.f27856sc.pFF) && z13) || !pFF(z12)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.f27856sc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.We(this.f27856sc.pFF) || com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.f27856sc.pFF)) {
                this.f27856sc.cJ.zY(false);
                pff.BT();
                return;
            }
        }
        if (this.f27856sc.CYO.isDestroyed() || this.f27856sc.CYO.isFinishing()) {
            return;
        }
        if (this.f27856sc.pFF.ixT()) {
            com.bytedance.sdk.openadsdk.component.reward.view.Qj qj2 = this.f27856sc.cvk;
            com.bytedance.sdk.openadsdk.core.Qj.zY brandBannerController = (qj2 == null || qj2.sc() == null) ? null : qj2.sc().getBrandBannerController();
            if (brandBannerController != null) {
                brandBannerController.pFF();
            }
            this.f27856sc.CYO.finish();
            return;
        }
        sc scVar2 = this.zY;
        if (scVar2 != null) {
            scVar2.sc(z11, z12, z13, pff, i11);
            return;
        }
        this.f27856sc.JPJ.Ql();
        this.f27856sc.Cb.McK();
        this.f27856sc.UFX.set(false);
        this.f27856sc.Tf.set(false);
        this.f27856sc.Gb.sc();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27856sc;
        SR sr2 = scVar3.cJ;
        if (!scVar3.f27912qr && scVar3.pFF.vYl()) {
            z14 = true;
        }
        sr2.sc(z14);
        if (this.f27856sc.WH.getAndSet(true)) {
            return;
        }
        if (JPJ.pFF(this.f27856sc.pFF)) {
            HashMap map = new HashMap();
            if (this.f27856sc.Cb.BR()) {
                i12 = 1;
            } else {
                i12 = !this.f27856sc.Cb.Sfl() ? -1 : 2;
            }
            map.put("webview_state", Integer.valueOf(i12));
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.f27856sc;
            com.bytedance.sdk.openadsdk.We.zY.sc(scVar4.pFF, scVar4.ExN, z11, z12, z13, scVar4.CYO.isFinishing(), i11, map);
        }
        if (this.f27856sc.pFF.sc() && JPJ.qr(this.f27856sc.pFF) && z11) {
            this.f27856sc.cJ.We(true);
        }
        if (JPJ.qr(this.f27856sc.pFF)) {
            this.f27856sc.cJ.zY(true);
        }
        Ol();
        if (!JPJ.ExN(this.f27856sc.pFF)) {
            sc(z11, pff);
            return;
        }
        this.f27856sc.cJ.zY(true);
        this.f27856sc.BR.zY();
        com.bytedance.sdk.openadsdk.component.reward.view.Qj qj3 = this.f27856sc.cvk;
        if (qj3 != null) {
            qj3.TRI();
        }
        this.f27856sc.WP.wjp();
    }

    public void zY() {
        this.pFF.We();
    }

    public boolean zY(com.bytedance.sdk.openadsdk.component.reward.pFF.pFF pff) {
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar;
        com.bytedance.sdk.openadsdk.utils.Tf tf2;
        this.f27856sc.Qj = Qj();
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27856sc;
        int i11 = scVar2.Qj;
        boolean z11 = false;
        if (scVar2.pFF.ExN()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar3 = this.f27856sc;
        int i12 = scVar3.Qj;
        if (i12 == -1) {
            if (JPJ.Qj(scVar3.pFF) && this.f27856sc.Cb.wjp()) {
                pff.FI();
            } else if (JPJ.WH(this.f27856sc.pFF) && this.f27856sc.Cb.wjp()) {
                pff.FI();
            } else {
                pff.BT();
                z11 = true;
            }
        } else if (i12 >= 0) {
            scVar3.Dl.set(false);
            Message messageObtain = Message.obtain();
            messageObtain.what = LogSeverity.ALERT_VALUE;
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar4 = this.f27856sc;
            messageObtain.arg1 = scVar4.Qj;
            scVar4.GI.sendMessage(messageObtain);
            if (!JPJ.Ol(this.f27856sc.pFF)) {
                z11 = true;
            }
        }
        if (!this.f27856sc.Cb.cvk() && z11 && (tf2 = (scVar = this.f27856sc).NP) != null) {
            tf2.sc(scVar.Qj);
        }
        return true;
    }
}
