package com.bytedance.sdk.openadsdk.core.Qj;

import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class YIK extends com.bytedance.sdk.component.adexpress.pFF.sc<sc> {
    private com.bytedance.sdk.component.adexpress.pFF.qr ExN;
    private final com.bytedance.sdk.component.adexpress.pFF.Ql TRI;
    private com.bytedance.sdk.component.adexpress.pFF.zY We;
    private sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    AtomicBoolean f28084sc = new AtomicBoolean(false);
    private final View zY;

    public YIK(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.pFF.Ql ql2) {
        this.zY = view;
        this.TRI = ql2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF() {
        if (this.f28084sc.get()) {
            return;
        }
        com.bytedance.sdk.component.adexpress.pFF.zY zYVar = this.We;
        if (zYVar == null || !zYVar.sc((Sfl) this.zY, 0)) {
            this.ExN.sc(107, "backup false");
            return;
        }
        this.TRI.ExN().qr();
        sc scVar = (sc) this.zY.findViewWithTag("tt_express_backup_fl_tag_26");
        this.pFF = scVar;
        if (scVar == null) {
            this.ExN.sc(107, "backupview is null");
            return;
        }
        com.bytedance.sdk.component.adexpress.pFF.SR sr2 = new com.bytedance.sdk.component.adexpress.pFF.SR();
        sc scVar2 = this.pFF;
        float realWidth = scVar2 == null ? 0.0f : scVar2.getRealWidth();
        sc scVar3 = this.pFF;
        float realHeight = scVar3 != null ? scVar3.getRealHeight() : 0.0f;
        sr2.sc(true);
        sr2.sc(realWidth);
        sr2.pFF(realHeight);
        this.ExN.sc(this.pFF, sr2);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public sc ExN() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.We
    public void sc(com.bytedance.sdk.component.adexpress.pFF.qr qrVar) {
        this.ExN = qrVar;
        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Qj.YIK.1
            @Override // java.lang.Runnable
            public void run() {
                YIK.this.pFF();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.sc
    public void sc(com.bytedance.sdk.component.adexpress.pFF.zY zYVar) {
        this.We = zYVar;
    }
}
