package com.bytedance.sdk.component.adexpress.ExN;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.pFF.Qj;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.bytedance.sdk.component.adexpress.pFF.SR;
import com.bytedance.sdk.component.adexpress.pFF.UFX;
import com.bytedance.sdk.component.adexpress.pFF.qr;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.transsion.gslb.Worker;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc implements UFX, com.bytedance.sdk.component.adexpress.pFF.We<com.bytedance.sdk.component.Ol.We>, com.bytedance.sdk.component.adexpress.sc, com.bytedance.sdk.component.adexpress.theme.sc {
    private volatile qr Ol;
    private String Qj;
    private boolean Ql;
    private int SR;
    private Context TRI;
    private Ql Tf;
    private Qj UFX;
    private boolean WH;
    protected boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private String f26655qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected JSONObject f26656sc;
    protected com.bytedance.sdk.component.Ol.We zY;
    protected int We = 8;
    protected AtomicBoolean ExN = new AtomicBoolean(false);
    private boolean BT = false;

    public sc(Context context, Ql ql2, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.WH = false;
        this.TRI = context;
        this.Tf = ql2;
        this.f26655qr = ql2.We();
        themeStatusBroadcastReceiver.sc(this);
        if (com.bytedance.sdk.component.adexpress.We.pFF()) {
            Tf();
            return;
        }
        com.bytedance.sdk.component.Ol.We weQl = Ql();
        this.zY = weQl;
        if (weQl != null) {
            this.WH = true;
        } else if (com.bytedance.sdk.component.adexpress.We.sc() != null) {
            this.zY = new com.bytedance.sdk.component.Ol.We(com.bytedance.sdk.component.adexpress.We.sc());
        }
    }

    private com.bytedance.sdk.component.Ol.We Ql() {
        return this.Tf.JPJ() ? ExN.sc().sc(this.TRI, this.f26655qr) : ExN.sc().pFF(this.TRI, this.f26655qr);
    }

    private void SR() {
        if (this.Tf.JPJ()) {
            ExN.sc().pFF(this.zY);
        } else {
            ExN.sc().zY(this.zY);
        }
    }

    private void Tf() {
        if (this.TRI == null && com.bytedance.sdk.component.adexpress.We.sc() != null) {
            this.TRI = com.bytedance.sdk.component.adexpress.We.sc();
        }
        if (this.TRI != null) {
            com.bytedance.sdk.component.Ol.We weQl = Ql();
            this.zY = weQl;
            if (weQl == null) {
                this.zY = new com.bytedance.sdk.component.Ol.We(new MutableContextWrapper(this.TRI.getApplicationContext()));
            } else {
                this.WH = true;
            }
        }
    }

    private int pFF(Activity activity) {
        return activity.hashCode();
    }

    private void sc(float f11, float f12) {
        this.Tf.ExN().ExN();
        if (zY() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sc().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            sc().setLayoutParams(layoutParams);
            return;
        }
        int iSc = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.TRI, f11);
        int iSc2 = (int) com.bytedance.sdk.component.adexpress.We.Qj.sc(this.TRI, f12);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) sc().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(iSc, iSc2);
        }
        layoutParams2.width = iSc;
        layoutParams2.height = iSc2;
        sc().setLayoutParams(layoutParams2);
    }

    private void sc(int i11, String str) {
        if (this.Ol != null) {
            this.Ol.sc(i11, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(SR sr2, float f11, float f12) {
        sr2.UFX();
        boolean z11 = this.pFF;
        if (!z11 || this.Ql) {
            if (!z11) {
                ExN.sc().ExN(this.zY);
            }
            sc(sr2.UFX(), sr2.WH());
        } else {
            sc(f11, f12);
            sc(this.We);
            if (this.Ol != null) {
                this.Ol.sc(sc(), sr2);
            }
        }
    }

    public void Ol() {
    }

    public void Qj() {
        Ol();
        Activity activitySc = com.bytedance.sdk.component.utils.pFF.sc(this.zY);
        if (activitySc != null) {
            this.SR = pFF(activitySc);
        }
    }

    public void TRI() {
        if (sc() == null) {
            return;
        }
        try {
            sc().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public Ql UFX() {
        return this.Tf;
    }

    public void WH() {
    }

    public void We() {
        if (this.ExN.get()) {
            return;
        }
        this.ExN.set(true);
        qr();
        if (this.zY.getParent() != null) {
            ((ViewGroup) this.zY.getParent()).removeView(this.zY);
        }
        if (this.pFF) {
            SR();
        } else {
            ExN.sc().ExN(this.zY);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.Ol.We ExN() {
        return sc();
    }

    public void pFF(boolean z11) {
        this.BT = z11;
    }

    public abstract void qr();

    public com.bytedance.sdk.component.Ol.We sc() {
        return this.zY;
    }

    public abstract void sc(int i11);

    @Override // com.bytedance.sdk.component.adexpress.sc
    public void sc(Activity activity) {
        if (this.SR == 0 || activity == null || activity.hashCode() != this.SR) {
            return;
        }
        We();
        WH();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.UFX
    public void sc(View view, int i11, com.bytedance.sdk.component.adexpress.zY zYVar) {
        Qj qj2 = this.UFX;
        if (qj2 != null) {
            qj2.sc(view, i11, zYVar);
        }
    }

    public void sc(Qj qj2) {
        this.UFX = qj2;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.UFX
    public void sc(final SR sr2) {
        if (sr2 == null) {
            if (this.Ol != null) {
                this.Ol.sc(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean zZY = sr2.zY();
        final float fWe = (float) sr2.We();
        final float fExN = (float) sr2.ExN();
        if (zY() != 0 || (fWe > 0.0f && fExN > 0.0f)) {
            this.pFF = zZY;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                sc(sr2, fWe, fExN);
                return;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ExN.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sc.this.sc(sr2, fWe, fExN);
                    }
                });
                return;
            }
        }
        if (this.Ol != null) {
            this.Ol.sc(105, "width is " + fWe + "height is " + fExN);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public void sc(qr qrVar) {
        this.Ol = qrVar;
        if (sc() == null || sc().getWebView() == null) {
            qr qrVar2 = this.Ol;
            StringBuilder sb2 = new StringBuilder("SSWebview null is ");
            sb2.append(sc() == null);
            sb2.append(" or Webview is null");
            qrVar2.sc(102, sb2.toString());
            return;
        }
        if (TextUtils.isEmpty(this.Qj)) {
            this.Ol.sc(102, "url is empty");
            return;
        }
        if (this.Tf.JPJ()) {
            if (zY() == 9 && !com.bytedance.sdk.component.adexpress.sc.pFF.pFF.pFF(this.f26656sc)) {
                qr qrVar3 = this.Ol;
                StringBuilder sb3 = new StringBuilder("data null is ");
                sb3.append(this.f26656sc == null);
                qrVar3.sc(Worker.WHAT_SYNC_DATA, sb3.toString());
                return;
            }
        } else {
            if (!this.BT && !com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc(this.f26656sc)) {
                qr qrVar4 = this.Ol;
                StringBuilder sb4 = new StringBuilder("data null is ");
                sb4.append(this.f26656sc == null);
                qrVar4.sc(Worker.WHAT_SYNC_DATA, sb4.toString());
                return;
            }
            if (this.BT && !com.bytedance.sdk.component.adexpress.sc.pFF.pFF.zY(this.f26656sc)) {
                qr qrVar5 = this.Ol;
                StringBuilder sb5 = new StringBuilder("choice ad data null is ");
                sb5.append(this.f26656sc == null);
                qrVar5.sc(Worker.WHAT_SYNC_DATA, sb5.toString());
                return;
            }
        }
        this.Tf.ExN().sc(this.WH);
        if (!this.WH) {
            com.bytedance.sdk.component.Ol.We weSc = sc();
            weSc.Ql();
            this.Tf.ExN();
            weSc.a_(this.Qj);
            return;
        }
        try {
            this.zY.Ql();
            this.Tf.ExN();
            com.bytedance.sdk.component.utils.UFX.sc(this.zY.getWebView(), "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();");
        } catch (Exception e11) {
            ExN.sc().ExN(this.zY);
            this.Ol.sc(102, "load exception is " + e11.getMessage());
        }
    }

    public void sc(String str) {
        this.Qj = str;
    }

    public void sc(JSONObject jSONObject) {
        this.f26656sc = jSONObject;
    }

    public void sc(boolean z11) {
        this.Ql = z11;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public int zY() {
        return 0;
    }
}
