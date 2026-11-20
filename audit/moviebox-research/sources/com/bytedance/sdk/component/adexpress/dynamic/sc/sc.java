package com.bytedance.sdk.component.adexpress.dynamic.sc;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.We.TRI;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.cJ;
import com.bytedance.sdk.component.adexpress.pFF.Qj;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.bytedance.sdk.component.adexpress.pFF.SR;
import com.bytedance.sdk.component.adexpress.pFF.UFX;
import com.bytedance.sdk.component.adexpress.pFF.We;
import com.bytedance.sdk.component.adexpress.pFF.qr;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.zY;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements UFX, We<DynamicRootView> {
    private Qj ExN;
    private AtomicBoolean Qj = new AtomicBoolean(false);
    private Ql TRI;
    private qr We;
    private com.bytedance.sdk.component.adexpress.dynamic.ExN.Qj pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private ScheduledFuture<?> f26836qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private DynamicRootView f26837sc;
    private Context zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0257sc implements Runnable {
        private int pFF;

        public RunnableC0257sc(int i11) {
            this.pFF = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pFF == 2) {
                sc.this.f26837sc.callBackRenderFail(sc.this.pFF instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr ? 127 : 117, null);
            }
        }
    }

    public sc(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z11, com.bytedance.sdk.component.adexpress.dynamic.ExN.Qj qj2, Ql ql2, com.bytedance.sdk.component.adexpress.dynamic.TRI.sc scVar) {
        this.zY = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z11, ql2, scVar);
        this.f26837sc = dynamicRootView;
        this.pFF = qj2;
        this.TRI = ql2;
        dynamicRootView.setRenderListener(this);
        this.TRI = ql2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        try {
            ScheduledFuture<?> scheduledFuture = this.f26836qr;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.f26836qr.cancel(false);
            this.f26836qr = null;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TRI() {
        this.TRI.ExN().pFF(zY());
        JSONObject jSONObjectZY = this.TRI.zY();
        if (com.bytedance.sdk.component.adexpress.sc.pFF.pFF.sc(jSONObjectZY)) {
            this.pFF.sc(new com.bytedance.sdk.component.adexpress.dynamic.TRI.pFF() { // from class: com.bytedance.sdk.component.adexpress.dynamic.sc.sc.2
                @Override // com.bytedance.sdk.component.adexpress.dynamic.TRI.pFF
                public void sc(final com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
                    sc.this.Qj();
                    sc.this.TRI.ExN().zY(sc.this.zY());
                    sc.this.sc(qj2);
                    sc.this.pFF(qj2);
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        sc.this.zY(qj2);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.sc.sc.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                sc.this.zY(qj2);
                            }
                        });
                    }
                    if (sc.this.f26837sc == null || qj2 == null) {
                        return;
                    }
                    sc.this.f26837sc.setBgColor(qj2.sc());
                    sc.this.f26837sc.setBgMaterialCenterCalcColor(qj2.pFF());
                }
            });
            this.pFF.sc(this.TRI);
            return;
        }
        int i11 = this.pFF instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr ? 123 : 113;
        DynamicRootView dynamicRootView = this.f26837sc;
        StringBuilder sb2 = new StringBuilder("data null is ");
        sb2.append(jSONObjectZY == null);
        dynamicRootView.callBackRenderFail(i11, sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        float fQr;
        float fTRI;
        List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX;
        if (qj2 == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX2 = qj2.UFX();
        if (listUFX2 == null || listUFX2.size() <= 0) {
            fQr = 0.0f;
        } else {
            fQr = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3 : listUFX2) {
                if (qj3.qr() > qj2.qr() - qj3.Ol() || (listUFX = qj3.UFX()) == null || listUFX.size() <= 0) {
                    fTRI = 0.0f;
                } else {
                    fTRI = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj4 : listUFX) {
                        if (qj4.WH().pFF().equals("logo-union")) {
                            fTRI = qj4.WH().TRI();
                            fQr = (((-fTRI) + qj2.qr()) - qj3.qr()) + qj3.WH().ExN().Pu();
                        }
                    }
                }
                pFF(qj3);
                if (fTRI <= -15.0f) {
                    qj3.TRI(qj3.Ol() - fTRI);
                    qj3.We(qj3.qr() + fTRI);
                    for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj5 : qj3.UFX()) {
                        qj5.We(qj5.qr() - fTRI);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.We.Qj qjTf = qj2.Tf();
        if (qjTf == null) {
            return;
        }
        float fTRI2 = qj2.TRI() - qjTf.TRI();
        float fQr2 = qj2.qr() - qjTf.qr();
        qj2.zY(fTRI2);
        qj2.We(fQr2);
        if (fQr > 0.0f) {
            qj2.We(qj2.qr() - fQr);
            qj2.TRI(qj2.Ol() + fQr);
            for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj6 : qj2.UFX()) {
                qj6.We(qj6.qr() + fQr);
            }
        }
    }

    private boolean qr() {
        DynamicRootView dynamicRootView = this.f26837sc;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void sc(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 >= viewGroup.getChildCount()) {
                    break;
                }
                sc(viewGroup.getChildAt(i11));
                i11++;
            }
        }
        if (view instanceof cJ) {
            ((cJ) view).pFF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        List<com.bytedance.sdk.component.adexpress.dynamic.We.Qj> listUFX;
        if (qj2 == null || (listUFX = qj2.UFX()) == null || listUFX.size() <= 0) {
            return;
        }
        Collections.sort(listUFX, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.We.Qj>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.sc.sc.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3, com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj4) {
                TRI triExN = qj3.WH().ExN();
                TRI triExN2 = qj4.WH().ExN();
                if (triExN == null || triExN2 == null) {
                    return 0;
                }
                return triExN.gx() >= triExN2.gx() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj3 : listUFX) {
            if (qj3 != null) {
                sc(qj3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY(com.bytedance.sdk.component.adexpress.dynamic.We.Qj qj2) {
        if (qj2 == null) {
            this.f26837sc.callBackRenderFail(this.pFF instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.TRI.ExN().We(zY());
        try {
            this.f26837sc.render(qj2, zY());
        } catch (Exception e11) {
            int i11 = this.pFF instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr ? 128 : 118;
            this.f26837sc.callBackRenderFail(i11, "exception is " + e11.getMessage());
        }
    }

    public DynamicRootView We() {
        return this.f26837sc;
    }

    public void pFF() {
        sc(ExN());
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public DynamicRootView ExN() {
        return We();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.UFX
    public void sc(View view, int i11, zY zYVar) {
        Qj qj2 = this.ExN;
        if (qj2 != null) {
            qj2.sc(view, i11, zYVar);
        }
    }

    public void sc(Qj qj2) {
        this.ExN = qj2;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.UFX
    public void sc(SR sr2) {
        if (this.Qj.get()) {
            return;
        }
        this.Qj.set(true);
        if (!sr2.zY() || !qr()) {
            this.We.sc(sr2.UFX(), sr2.WH());
            return;
        }
        this.f26837sc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.We.sc(ExN(), sr2);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public void sc(qr qrVar) {
        this.We = qrVar;
        int iTRI = this.TRI.TRI();
        if (iTRI < 0) {
            this.f26837sc.callBackRenderFail(this.pFF instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr ? 127 : 117, "time is ".concat(String.valueOf(iTRI)));
            return;
        }
        this.f26836qr = com.bytedance.sdk.component.adexpress.We.We.sc(new RunnableC0257sc(2), iTRI, TimeUnit.MILLISECONDS);
        if (Looper.getMainLooper() != Looper.myLooper() || this.TRI.Ol() > 0) {
            com.bytedance.sdk.component.utils.qr.pFF().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.sc.sc.1
                @Override // java.lang.Runnable
                public void run() {
                    sc.this.TRI();
                }
            }, this.TRI.Ol());
        } else {
            TRI();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public int zY() {
        return this.pFF instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr ? 3 : 2;
    }
}
