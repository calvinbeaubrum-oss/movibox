package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.Qj.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    private pFF Ol;
    private final String Qj;
    private final Activity TRI;
    private boolean UFX;
    private final com.bytedance.sdk.openadsdk.component.reward.sc.sc WH;
    Handler pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final Sfl f27952qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI f27953sc;
    boolean zY = false;
    boolean We = false;
    boolean ExN = false;

    public Qj(com.bytedance.sdk.openadsdk.component.reward.sc.sc scVar) {
        this.WH = scVar;
        this.TRI = scVar.CYO;
        this.f27952qr = scVar.pFF;
        this.Qj = scVar.ExN;
    }

    private com.bytedance.sdk.openadsdk.wjp.sc.sc.TRI sc(Sfl sfl) {
        if (sfl.QLv() == 4) {
            return com.bytedance.sdk.openadsdk.wjp.sc.sc.qr.sc(this.TRI, sfl, this.Qj);
        }
        return null;
    }

    public Handler ExN() {
        if (this.pFF == null) {
            this.pFF = new Handler(Looper.getMainLooper());
        }
        return this.pFF;
    }

    public int Ol() {
        pFF pff = this.Ol;
        if (pff != null) {
            return pff.getDynamicShowType();
        }
        return 0;
    }

    public boolean Qj() {
        pFF pff = this.Ol;
        if (pff == null) {
            return false;
        }
        return pff.Ql();
    }

    public void TRI() {
        if (this.UFX) {
            return;
        }
        this.UFX = true;
        pFF pff = this.Ol;
        if (pff != null) {
            pff.UFX();
        }
        Handler handler = this.pFF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void Tf() {
        if (Sfl.ExN(this.f27952qr) && this.f27952qr.HJN() == 3 && this.f27952qr.Gb() == 0) {
            try {
                if (this.f27952qr.gx() == 1) {
                    int iZY = kX.zY(Xc.sc(), 90.0f);
                    FrameLayout frameLayout = (FrameLayout) this.Ol.getBackupContainerBackgroundView();
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.bottomMargin = iZY;
                        frameLayout.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void UFX() {
        pFF pff = this.Ol;
        if (pff == null) {
            return;
        }
        pff.Ol();
        this.Ol.WH();
    }

    public void WH() {
        pFF pff = this.Ol;
        if (pff == null) {
            return;
        }
        pff.Qj();
    }

    public boolean We() {
        return this.We;
    }

    public FrameLayout pFF() {
        pFF pff = this.Ol;
        if (pff == null) {
            return null;
        }
        FrameLayout videoFrameLayout = pff.getVideoFrameLayout();
        if (this.Ol.Ql()) {
            Tf();
        }
        return videoFrameLayout;
    }

    public void pFF(boolean z11) {
        this.We = z11;
    }

    public void qr() {
        pFF pff = this.Ol;
        if (pff != null) {
            pff.WH();
        }
    }

    public pFF sc() {
        return this.Ol;
    }

    public JSONObject sc(JSONObject jSONObject) {
        pFF pff = this.Ol;
        if (pff != null) {
            return pff.sc(jSONObject, this.WH.pFF);
        }
        return null;
    }

    public void sc(int i11, String str) {
        pFF pff = this.Ol;
        if (pff != null) {
            pff.pFF(i11, str);
        }
    }

    public void sc(int i11, boolean z11) {
        pFF pff = this.Ol;
        if (pff != null) {
            pff.sc(i11, z11, false);
        }
    }

    public void sc(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Xc xc2) {
        if (this.ExN) {
            return;
        }
        this.ExN = true;
        pFF pff = new pFF(this.WH, adSlot, this.Qj);
        this.Ol = pff;
        xc2.sc(pff, pff.getVideoFrameLayout());
    }

    public void sc(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        pFF pff = this.Ol;
        if (pff == null) {
            return;
        }
        pff.setExpressInteractionListener(pAGExpressAdWrapperListener);
    }

    public void sc(com.bytedance.sdk.openadsdk.core.Qj.Ol ol2, com.bytedance.sdk.openadsdk.core.Qj.Qj qj2) {
        Sfl sfl;
        if (this.Ol == null || (sfl = this.f27952qr) == null) {
            return;
        }
        this.f27953sc = sc(sfl);
        ol2.sc(this.Ol);
        ol2.sc(this.f27953sc);
        this.Ol.setClickListener(ol2);
        qj2.sc((View) this.Ol);
        qj2.sc(this.f27953sc);
        this.Ol.setClickCreativeListener(qj2);
    }

    public void sc(SR sr2) {
        pFF pff = this.Ol;
        if (pff == null) {
            return;
        }
        pff.setExpressVideoListenerProxy(sr2);
    }

    public void sc(boolean z11) {
        this.zY = z11;
    }

    public boolean zY() {
        return this.zY;
    }
}
