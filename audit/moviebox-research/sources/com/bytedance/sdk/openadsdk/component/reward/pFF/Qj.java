package com.bytedance.sdk.openadsdk.component.reward.pFF;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.JPJ;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.SR;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends pFF {
    private final int BT;
    private com.bytedance.sdk.openadsdk.component.reward.view.ExN Xc;
    private ViewGroup dE;
    private String wjp;

    public Qj(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        super(scVar);
        this.wjp = "fullscreen_interstitial_ad";
        this.BT = this.pFF.dix();
    }

    private boolean Cb() {
        Sfl sfl = this.pFF;
        return sfl != null && sfl.JPJ() == 2;
    }

    private void Gb() {
        if (this.dE == null) {
            return;
        }
        sc((View) this.Xc);
    }

    private void HJN() {
        FrameLayout frameLayout = new FrameLayout(this.f27845sc.CYO);
        this.dE = frameLayout;
        frameLayout.setId(SR.JK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.dE.setLayoutParams(layoutParams);
        View viewUFX = this.f27845sc.BR.UFX();
        if (viewUFX != null) {
            layoutParams.bottomMargin = viewUFX.getHeight();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.ExN exN = new com.bytedance.sdk.openadsdk.component.reward.view.ExN(this.f27845sc.CYO);
        this.Xc = exN;
        exN.setId(SR.WMT);
        FrameLayout.LayoutParams layoutParams2 = this.f27845sc.pFF.gx() == 1 ? new FrameLayout.LayoutParams(-1, -2) : new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        this.Xc.setLayoutParams(layoutParams2);
        this.dE.addView(this.Xc);
        Gb();
    }

    private void cD() {
        BT bt2;
        List<BT> listHt = this.pFF.ht();
        if (listHt == null || listHt.size() <= 0 || (bt2 = listHt.get(0)) == null) {
            return;
        }
        try {
            int iPFF = bt2.pFF();
            int iZY = bt2.zY();
            if (iPFF != 0 && iZY != 0) {
                this.Xc.setRatio(iPFF / iZY);
                return;
            }
            int i11 = this.BT;
            if (i11 == 33) {
                this.Xc.setRatio(1.0f);
            } else if (i11 == 3) {
                this.Xc.setRatio(1.91f);
            } else {
                this.Xc.setRatio(0.56f);
            }
        } catch (Exception e11) {
            Tf.sc("TTAD.RFTI", e11.getMessage());
        }
    }

    private void pFF(Sfl sfl) {
        if (sfl == null || this.Xc == null) {
            return;
        }
        cD();
        sc((ImageView) this.Xc);
    }

    private void sc(ImageView imageView) {
        List<BT> listHt;
        BT bt2;
        Sfl sfl = this.pFF;
        if (sfl == null || (listHt = sfl.ht()) == null || listHt.size() <= 0 || (bt2 = listHt.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Ol.We.sc(listHt.get(0)).zY(2).sc(com.bytedance.sdk.openadsdk.Ol.zY.sc(this.pFF, bt2.sc(), imageView));
    }

    public static boolean sc(Sfl sfl) {
        return !Sfl.ExN(sfl) && sfl.AZJ() == 100.0f;
    }

    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI zY(Sfl sfl) {
        if (sfl.QLv() == 4) {
            return new com.bytedance.sdk.openadsdk.wjp.sc.sc.We(Xc.sc(), sfl, this.wjp);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean ExN() {
        return Cb() || JPJ.qr(this.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public boolean TRI() {
        return Cb();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void qr() {
        if (com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.pFF)) {
            this.TRI.pFF(8);
        }
        this.Qj.zY(false);
        this.Qj.We(false);
        if (this.pFF.JPJ() == 2) {
            this.Qj.sc(false);
            this.TRI.ExN(8);
            return;
        }
        this.Qj.sc(this.pFF.vYl());
        if (this.f27845sc.DNB) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 900;
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            int iMcK = (int) (scVar.JPJ.McK() * 1000.0d);
            scVar.Ol = iMcK;
            messageObtain.arg1 = iMcK;
            this.f27845sc.GI.sendMessage(messageObtain);
        }
    }

    public void sc(View view) {
        if (view == null || this.f27845sc.CYO == null || this.pFF == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pFF.pFF scVar = this.Tf;
        if (scVar == null) {
            Activity activity = this.f27845sc.CYO;
            Sfl sfl = this.pFF;
            String str = this.wjp;
            scVar = new com.bytedance.sdk.openadsdk.core.pFF.sc(activity, sfl, str, cJ.sc(str));
            scVar.sc(zY(this.pFF));
            HashMap map = new HashMap();
            if (JPJ.wjp(this.pFF)) {
                map.put("click_scence", 3);
            } else {
                map.put("click_scence", 1);
            }
            scVar.sc(map);
        }
        Activity activity2 = this.f27845sc.CYO;
        if (activity2 != null) {
            scVar.sc(activity2);
        }
        view.setOnTouchListener(scVar);
        view.setOnClickListener(scVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(FrameLayout frameLayout) {
        try {
            HJN();
            pFF(this.pFF);
            frameLayout.addView(this.dE);
        } catch (Exception e11) {
            Log.e("TTAD.RFTI", "bindAd: ", e11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.pFF.pFF
    public void sc(com.bytedance.sdk.openadsdk.component.reward.view.qr qrVar) {
        if (com.bytedance.sdk.openadsdk.core.model.Xc.pFF(this.pFF)) {
            We.pFF(qrVar);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar = this.f27845sc;
            scVar.NP.sc((long) (scVar.JPJ.McK() * 1000.0d));
        } else {
            if (!com.bytedance.sdk.openadsdk.core.model.Xc.We(this.pFF) && !com.bytedance.sdk.openadsdk.core.model.Xc.ExN(this.pFF)) {
                super.sc(qrVar);
                return;
            }
            We.zY(qrVar);
            com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar2 = this.f27845sc;
            scVar2.NP.sc((long) (scVar2.JPJ.McK() * 1000.0d));
        }
    }
}
