package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.Cb;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TRI {
    public int Ol;
    protected final Sfl Qj;
    protected com.bytedance.sdk.openadsdk.Tf.ExN Tf = new com.bytedance.sdk.openadsdk.Tf.ExN() { // from class: com.bytedance.sdk.openadsdk.activity.TRI.1
        @Override // com.bytedance.sdk.openadsdk.Tf.ExN
        public void sc() {
            TRI.this.SR();
        }
    };
    protected IListenerManager UFX;
    public boolean WH;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final pFF f27500sc;

    public TRI(pFF pff, Sfl sfl, int i11) {
        this.f27500sc = pff;
        this.Qj = sfl;
        this.Ol = i11;
    }

    private void pFF(final String str) {
        Cb.zY(new Qj("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TRI.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TRI.this.zY(1).executeFullVideoCallback(TRI.this.YIK(), str);
                } catch (Throwable th2) {
                    Tf.sc("Scene", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    private void sc(final String str, final boolean z11, final int i11, final String str2, final int i12, final String str3) {
        Cb.zY(new Qj("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.TRI.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TRI.this.zY(0).executeRewardVideoCallback(TRI.this.YIK(), str, z11, i11, str2, i12, str3);
                } catch (Throwable th2) {
                    Tf.sc("Scene", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th2);
                }
            }
        }, 5);
    }

    public void BT() {
    }

    public void ExN(Activity activity) {
    }

    public pFF FI() {
        return this.f27500sc;
    }

    public final void HJN() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdVideoBarClick");
        } else {
            this.f27500sc.UFX();
        }
    }

    public void II() {
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdClose");
        } else {
            this.f27500sc.Tf();
        }
    }

    public void McK() {
        if (this.f27500sc.dE()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            sc("onAdShow");
        } else {
            this.f27500sc.Ql();
        }
        this.f27500sc.Xc();
    }

    public void SR() {
    }

    public abstract boolean Sfl();

    public Activity WP() {
        return this.f27500sc.zY();
    }

    public void We(Activity activity) {
    }

    public void Xc() {
    }

    public abstract String YIK();

    public abstract boolean a_();

    public abstract String b_();

    public void cvk() {
        if (this.Qj != null) {
            com.bytedance.sdk.openadsdk.TRI.pFF.sc().sc("videoForceBreak", this.Qj);
        }
        this.f27500sc.sc(this);
    }

    public void pFF(Activity activity) {
    }

    public abstract void pFF(boolean z11);

    public abstract View sc();

    public void sc(Activity activity) {
    }

    public void sc(Activity activity, Bundle bundle) {
    }

    public void sc(Activity activity, pFF.ExN exN) {
    }

    public void sc(TRI tri, TRI tri2, pFF.ExN exN) {
    }

    public void sc(String str) {
        if (a_()) {
            sc(str, false, 0, "", 0, "");
        } else {
            pFF(str);
        }
    }

    public final void sc(boolean z11, int i11, String str, int i12, String str2) {
        if (this.f27500sc.SR()) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
            this.f27500sc.sc(this, z11, i11, str, i12, str2);
        } else {
            sc("onRewardVerify", z11, i11, str, i12, str2);
            this.f27500sc.BT();
        }
    }

    public void sc(boolean z11, boolean z12, boolean z13, int i11) {
        this.f27500sc.sc(this, z11, z12, z13, i11);
    }

    public abstract com.bytedance.sdk.openadsdk.component.reward.sc.sc uEA();

    public final IListenerManager zY(int i11) {
        if (this.UFX == null) {
            this.UFX = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(i11));
        }
        return this.UFX;
    }

    public void zY(Activity activity) {
    }
}
