package com.bytedance.sdk.component.adexpress.pFF;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE implements WH {
    private ScheduledFuture<?> ExN;
    private AtomicBoolean TRI = new AtomicBoolean(false);
    private Ql We;
    private com.bytedance.sdk.component.adexpress.ExN.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26889sc;
    private Qj zY;

    /* JADX INFO: compiled from: source.java */
    public class sc implements Runnable {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        WH.sc f26891sc;
        private int zY;

        public sc(int i11, WH.sc scVar) {
            this.zY = i11;
            this.f26891sc = scVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zY == 1) {
                dE.this.pFF.sc(true);
                dE.this.sc(this.f26891sc, 107, null);
            }
        }
    }

    public dE(Context context, Ql ql2, com.bytedance.sdk.component.adexpress.ExN.sc scVar, Qj qj2) {
        this.f26889sc = context;
        this.We = ql2;
        this.zY = qj2;
        this.pFF = scVar;
        scVar.sc(this.zY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(WH.sc scVar, int i11, String str) {
        BT btPFF;
        if (scVar.zY() || this.TRI.get()) {
            return;
        }
        zY();
        this.We.ExN().sc(i11, str);
        if (scVar.pFF(this)) {
            scVar.sc(this);
        } else {
            if (scVar.zY() || (btPFF = scVar.pFF()) == null) {
                return;
            }
            scVar.sc(true);
            btPFF.a_(i11);
        }
        this.TRI.getAndSet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ExN;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ExN.cancel(false);
            this.ExN = null;
        } catch (Throwable unused) {
        }
    }

    public com.bytedance.sdk.component.adexpress.ExN.sc pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public void sc() {
        this.pFF.We();
        zY();
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public boolean sc(final WH.sc scVar) {
        int iTRI = this.We.TRI();
        if (iTRI < 0) {
            sc(scVar, 107, "time is ".concat(String.valueOf(iTRI)));
        } else {
            this.ExN = com.bytedance.sdk.component.adexpress.We.We.sc(new sc(1, scVar), iTRI, TimeUnit.MILLISECONDS);
            this.pFF.sc(new qr() { // from class: com.bytedance.sdk.component.adexpress.pFF.dE.1
                @Override // com.bytedance.sdk.component.adexpress.pFF.qr
                public void sc(int i11, String str) {
                    dE.this.sc(scVar, i11, str);
                }

                @Override // com.bytedance.sdk.component.adexpress.pFF.qr
                public void sc(View view, SR sr2) {
                    BT btPFF;
                    dE.this.zY();
                    if (scVar.zY() || (btPFF = scVar.pFF()) == null) {
                        return;
                    }
                    btPFF.sc(dE.this.pFF, sr2);
                    scVar.sc(true);
                }
            });
        }
        return true;
    }
}
