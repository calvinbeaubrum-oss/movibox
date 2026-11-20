package com.bytedance.sdk.openadsdk.component.reward.sc;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.FI;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    public final com.bytedance.sdk.openadsdk.component.reward.view.WH BR;
    public boolean Bs;

    @NonNull
    public final Activity CYO;
    public final wjp Cb;
    public boolean DNB;
    public final String ExN;
    public final We FI;
    public final FI GI;
    public final zY Gb;
    public final TRI HJN;
    private long IEI;
    public final Tf II;

    @NonNull
    public final Xc JPJ;
    public final com.bytedance.sdk.openadsdk.component.reward.view.qr JoC;
    public final UFX McK;
    public final boolean MxZ;
    public com.bytedance.sdk.openadsdk.utils.Tf NP;
    public boolean NQ;
    public final BT OXF;
    private long PPh;
    public String QLv;
    public final int TRI;
    public final Qj WP;
    public final boolean We;
    public int Yhz;
    public int ZM;
    public com.bytedance.sdk.openadsdk.common.Ql bSP;
    public com.bytedance.sdk.openadsdk.Tf.Qj cD;

    @NonNull
    public final SR cJ;
    public final com.bytedance.sdk.openadsdk.component.reward.view.Qj cvk;

    @Nullable
    public com.bytedance.sdk.openadsdk.activity.TRI dix;

    /* JADX INFO: renamed from: eo, reason: collision with root package name */
    public boolean f27908eo;
    public boolean fT;

    /* JADX INFO: renamed from: ht, reason: collision with root package name */
    public int f27909ht;
    public boolean idT;
    public com.bytedance.sdk.openadsdk.component.reward.pFF.pFF kDg;
    public final ExN kX;

    /* JADX INFO: renamed from: ko, reason: collision with root package name */
    public float f27910ko;
    public com.bytedance.sdk.openadsdk.component.reward.top.zY mD;
    public boolean otH;
    public final com.bytedance.sdk.openadsdk.core.model.Sfl pFF;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    public final Context f27911pc;
    public final com.bytedance.sdk.openadsdk.core.Ql.We.pFF qKn;
    public boolean qfG;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public final boolean f27912qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final int f27913sc;
    public final boolean zY;
    public int Qj = 0;
    public int Ol = 0;
    public final AtomicBoolean WH = new AtomicBoolean(false);
    public final AtomicBoolean UFX = new AtomicBoolean(false);
    public final AtomicBoolean Tf = new AtomicBoolean(false);
    public final AtomicBoolean Ql = new AtomicBoolean(false);
    public final AtomicBoolean SR = new AtomicBoolean(false);
    public final AtomicBoolean BT = new AtomicBoolean(false);
    public final AtomicBoolean dE = new AtomicBoolean(false);
    public final AtomicBoolean Xc = new AtomicBoolean(false);
    public final AtomicBoolean wjp = new AtomicBoolean(false);
    public final AtomicBoolean Sfl = new AtomicBoolean(false);
    public final AtomicBoolean YIK = new AtomicBoolean(false);
    public final AtomicBoolean Dl = new AtomicBoolean(false);
    public final AtomicBoolean uEA = new AtomicBoolean(false);
    public boolean yL = false;
    public int OKY = 1;
    public long YdT = 0;

    public sc(@NonNull Activity activity, FI fi2, @NonNull com.bytedance.sdk.openadsdk.core.model.Sfl sfl, com.bytedance.sdk.openadsdk.core.Ql.We.pFF pff, int i11) {
        this.CYO = activity;
        this.qKn = pff;
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        this.f27911pc = contextSc;
        this.pFF = sfl;
        this.f27913sc = i11;
        this.MxZ = i11 == 0 || i11 == 2;
        this.DNB = i11 == 0 || i11 == 1;
        this.GI = fi2;
        boolean z11 = sfl.Cb().getDurationSlotType() == 7;
        this.We = z11;
        this.ExN = z11 ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.NQ = sfl.sc();
        this.f27912qr = com.bytedance.sdk.openadsdk.core.model.Xc.WH(sfl);
        int iQT = sfl.QT();
        this.TRI = iQT;
        this.f27908eo = com.bytedance.sdk.openadsdk.core.Xc.We().Xc(String.valueOf(iQT));
        this.zY = com.bytedance.sdk.openadsdk.core.settings.dE.ef().SR(String.valueOf(iQT));
        this.II = i11 == 2 ? new Ql(this) : new Tf(this);
        this.BR = i11 == 2 ? new com.bytedance.sdk.openadsdk.component.reward.view.UFX(this) : sfl.sc() ? new com.bytedance.sdk.openadsdk.component.reward.view.WH(this) : new com.bytedance.sdk.openadsdk.component.reward.view.Ol(this);
        this.JoC = new com.bytedance.sdk.openadsdk.component.reward.view.qr(this);
        this.JPJ = new Xc(this);
        this.FI = new We(this);
        this.WP = new Qj(this, sfl);
        this.cvk = new com.bytedance.sdk.openadsdk.component.reward.view.Qj(this);
        this.Cb = new wjp(this);
        this.OXF = new BT(this);
        this.cJ = new SR(this);
        this.kX = new ExN(this);
        this.McK = new UFX(this);
        this.HJN = new TRI(this);
        this.Gb = new zY(this);
        this.cD = new com.bytedance.sdk.openadsdk.Tf.Qj(contextSc);
        this.NP = com.bytedance.sdk.openadsdk.utils.qr.sc(activity, new com.bytedance.sdk.openadsdk.utils.qr.sc() { // from class: com.bytedance.sdk.openadsdk.component.reward.sc.sc.1
            @Override // com.bytedance.sdk.openadsdk.utils.qr.sc
            public void pFF() {
                SR sr2 = sc.this.cJ;
                if (sr2 != null) {
                    sr2.TRI();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.qr.sc
            public View sc() {
                com.bytedance.sdk.openadsdk.component.reward.view.WH wh2 = sc.this.BR;
                if (wh2 != null) {
                    return wh2.WH();
                }
                return null;
            }
        });
    }

    public void pFF() {
        if (this.IEI <= 0) {
            this.IEI = SystemClock.elapsedRealtime();
        }
        this.PPh += SystemClock.elapsedRealtime() - this.IEI;
    }

    public void sc() {
        this.IEI = SystemClock.elapsedRealtime();
    }

    public void sc(boolean z11) {
        this.fT = z11;
        this.cJ.We(z11);
    }

    public long zY() {
        return this.PPh + (SystemClock.elapsedRealtime() - this.IEI);
    }
}
