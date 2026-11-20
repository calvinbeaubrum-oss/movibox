package com.bytedance.sdk.openadsdk.core.UFX.pFF;

import android.content.Context;
import android.view.View;
import com.bytedance.adsdk.ugeno.core.SR;
import com.bytedance.sdk.component.adexpress.pFF.BT;
import com.bytedance.sdk.component.adexpress.pFF.Qj;
import com.bytedance.sdk.component.adexpress.pFF.Ql;
import com.bytedance.sdk.component.adexpress.pFF.WH;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr implements WH {
    private AtomicBoolean ExN = new AtomicBoolean(false);
    private ScheduledFuture<?> We;
    private com.bytedance.sdk.openadsdk.core.UFX.We.zY pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f28286sc;
    private Ql zY;

    /* JADX INFO: compiled from: source.java */
    public class sc implements Runnable {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        WH.sc f28288sc;
        private int zY;

        public sc(int i11, WH.sc scVar) {
            this.zY = i11;
            this.f28288sc = scVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zY == 1) {
                qr.this.pFF.sc(true);
                qr.this.sc(this.f28288sc, 137, "real time out" + qr.this.zY.TRI());
            }
        }
    }

    public qr(Context context, com.bytedance.sdk.openadsdk.core.UFX.We.zY zYVar, Qj qj2, Ql ql2) {
        this.f28286sc = context;
        this.pFF = zYVar;
        this.zY = ql2;
        this.pFF.sc(qj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF() {
        try {
            ScheduledFuture<?> scheduledFuture = this.We;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.We.cancel(false);
            this.We = null;
        } catch (Throwable th2) {
            Tf.sc("RenderInterceptor", "remove ugen time out task fail", th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(WH.sc scVar, int i11, String str) {
        BT btPFF;
        if (scVar.zY() || this.ExN.get()) {
            return;
        }
        pFF();
        SR sr2 = new SR();
        sr2.sc(i11);
        sr2.sc(str);
        ((com.bytedance.sdk.openadsdk.core.UFX.We.sc) this.zY).HJN().sc(sr2);
        if (scVar.pFF(this)) {
            scVar.sc(this);
        } else {
            if (scVar.zY() || (btPFF = scVar.pFF()) == null) {
                return;
            }
            scVar.sc(true);
            btPFF.a_(i11);
        }
        this.ExN.getAndSet(true);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public void sc() {
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public boolean sc(final WH.sc scVar) {
        int iTRI = this.zY.TRI();
        if (iTRI < 0) {
            sc(scVar, 137, "time is ".concat(String.valueOf(iTRI)));
        } else {
            this.We = Cb.sc().schedule(new sc(1, scVar), iTRI, TimeUnit.MILLISECONDS);
            this.pFF.sc(new com.bytedance.sdk.component.adexpress.pFF.qr() { // from class: com.bytedance.sdk.openadsdk.core.UFX.pFF.qr.1
                @Override // com.bytedance.sdk.component.adexpress.pFF.qr
                public void sc(int i11, String str) {
                    qr.this.sc(scVar, i11, str);
                }

                @Override // com.bytedance.sdk.component.adexpress.pFF.qr
                public void sc(View view, com.bytedance.sdk.component.adexpress.pFF.SR sr2) {
                    qr.this.pFF();
                    if (scVar.zY()) {
                        return;
                    }
                    SR sr3 = new SR();
                    sr3.sc(0);
                    ((com.bytedance.sdk.openadsdk.core.UFX.We.sc) qr.this.zY).HJN().sc(sr3);
                    qr.this.zY.ExN().WH();
                    BT btPFF = scVar.pFF();
                    if (btPFF == null) {
                        return;
                    }
                    btPFF.sc(qr.this.pFF, sr2);
                    scVar.sc(true);
                }
            });
        }
        return true;
    }
}
