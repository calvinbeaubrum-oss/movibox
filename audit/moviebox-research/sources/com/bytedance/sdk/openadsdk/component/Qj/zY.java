package com.bytedance.sdk.openadsdk.component.Qj;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.We.ExN.pFF.BT;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import t8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc {
    private boolean ExN = false;
    private pFF We;
    private FrameLayout pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f27750sc;
    private Sfl zY;

    public zY(Context context) {
        this.f27750sc = context.getApplicationContext();
    }

    public boolean ExN() {
        pFF pff = this.We;
        return (pff == null || pff.Tf() == null || !this.We.Tf().qr()) ? false : true;
    }

    public void Ol() {
        pFF pff = this.We;
        if (pff == null) {
            return;
        }
        pff.zY();
        this.We = null;
    }

    public void Qj() {
        try {
            if (ExN()) {
                WH();
            }
        } catch (Throwable th2) {
            Tf.sc("TTAppOpenVideoManager", "onContinue throw Exception :" + th2.getMessage());
        }
    }

    public long Ql() {
        pFF pff = this.We;
        if (pff != null) {
            return pff.TRI();
        }
        return 0L;
    }

    public long SR() {
        pFF pff = this.We;
        if (pff != null) {
            return pff.Qj() + this.We.TRI();
        }
        return 0L;
    }

    public boolean TRI() {
        pFF pff = this.We;
        return pff != null && pff.dE();
    }

    public long Tf() {
        pFF pff = this.We;
        if (pff != null) {
            return pff.ExN();
        }
        return 0L;
    }

    public void UFX() {
        pFF pff = this.We;
        if (pff == null) {
            return;
        }
        this.f27750sc = null;
        pff.zY();
        this.We = null;
    }

    public void WH() {
        pFF pff = this.We;
        if (pff != null) {
            pff.pFF();
        }
    }

    public boolean We() {
        pFF pff = this.We;
        return (pff == null || pff.Tf() == null || !this.We.Tf().TRI()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc
    public long getVideoProgress() {
        return Tf();
    }

    public boolean pFF() {
        return this.ExN;
    }

    public void qr() {
        try {
            if (We()) {
                this.We.sc();
            }
        } catch (Throwable th2) {
            Tf.sc("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th2.getMessage());
        }
    }

    public void sc(int i11) {
        if (this.We != null) {
            BT.sc scVar = new BT.sc();
            scVar.sc(Tf());
            scVar.zY(SR());
            scVar.pFF(Ql());
            scVar.zY(i11);
            scVar.We(this.We.qr());
            this.We.sc(scVar);
        }
    }

    public void sc(FrameLayout frameLayout, Sfl sfl) {
        this.pFF = frameLayout;
        this.zY = sfl;
        this.We = new pFF(this.f27750sc, frameLayout, sfl);
    }

    public void sc(c.InterfaceC0849c interfaceC0849c) {
        pFF pff = this.We;
        if (pff != null) {
            pff.sc(interfaceC0849c);
        }
    }

    public void sc(boolean z11) {
        this.ExN = z11;
    }

    public boolean sc() {
        String strSc;
        if (Build.VERSION.SDK_INT >= 23) {
            strSc = CacheDirFactory.getICacheDir(0).pFF();
        } else {
            try {
                strSc = com.bytedance.sdk.openadsdk.component.qr.sc.sc();
            } catch (Throwable unused) {
                strSc = "";
            }
        }
        com.bytedance.sdk.openadsdk.core.Ql.sc.pFF pffSc = Sfl.sc(strSc, this.zY);
        pffSc.pFF(this.zY.kDg());
        pffSc.sc(this.pFF.getWidth());
        pffSc.pFF(this.pFF.getHeight());
        pffSc.zY(this.zY.mD());
        pffSc.sc(0L);
        pffSc.sc(true);
        return this.We.sc(pffSc);
    }

    public boolean sc(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.sc scVar, Sfl sfl) {
        sc(frameLayout, sfl);
        sc(scVar);
        try {
            return sc();
        } catch (Throwable th2) {
            Tf.sc("TTAppOpenVideoManager", "open_ad", "ttAppOpenAd playVideo error: " + th2.getMessage());
            return false;
        }
    }

    public boolean zY() {
        pFF pff = this.We;
        return (pff == null || pff.Tf() == null || !this.We.Tf().pFF()) ? false : true;
    }
}
