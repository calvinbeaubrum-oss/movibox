package com.bytedance.sdk.component.adexpress.pFF;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements WH {
    private Ql ExN;
    private int TRI;
    private Qj We;
    private com.bytedance.sdk.component.adexpress.dynamic.sc.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26892sc;
    private ThemeStatusBroadcastReceiver zY;

    public pFF(Context context, Ql ql2, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z11, com.bytedance.sdk.component.adexpress.dynamic.ExN.Qj qj2, Qj qj3, com.bytedance.sdk.component.adexpress.dynamic.TRI.sc scVar, com.bytedance.sdk.component.adexpress.dynamic.sc.sc scVar2) {
        this.f26892sc = context;
        this.ExN = ql2;
        this.zY = themeStatusBroadcastReceiver;
        this.We = qj3;
        if (scVar2 != null) {
            this.pFF = scVar2;
        } else {
            this.pFF = new com.bytedance.sdk.component.adexpress.dynamic.sc.sc(context, themeStatusBroadcastReceiver, z11, qj2, ql2, scVar);
        }
        this.pFF.sc(this.We);
        if (qj2 instanceof com.bytedance.sdk.component.adexpress.dynamic.ExN.qr) {
            this.TRI = 3;
        } else {
            this.TRI = 2;
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.We pFF() {
        com.bytedance.sdk.component.adexpress.dynamic.sc.sc scVar = this.pFF;
        if (scVar != null) {
            return scVar.We();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public void sc() {
        com.bytedance.sdk.component.adexpress.dynamic.sc.sc scVar = this.pFF;
        if (scVar != null) {
            scVar.pFF();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public boolean sc(final WH.sc scVar) {
        this.ExN.ExN().sc(this.TRI);
        this.pFF.sc(new qr() { // from class: com.bytedance.sdk.component.adexpress.pFF.pFF.1
            @Override // com.bytedance.sdk.component.adexpress.pFF.qr
            public void sc(int i11, String str) {
                pFF.this.ExN.ExN().sc(pFF.this.TRI, i11, str, scVar.pFF(pFF.this));
                if (scVar.pFF(pFF.this)) {
                    scVar.sc(pFF.this);
                    return;
                }
                BT btPFF = scVar.pFF();
                if (btPFF == null) {
                    return;
                }
                btPFF.a_(i11);
            }

            @Override // com.bytedance.sdk.component.adexpress.pFF.qr
            public void sc(View view, SR sr2) {
                if (scVar.zY()) {
                    return;
                }
                pFF.this.ExN.ExN().ExN(pFF.this.TRI);
                pFF.this.ExN.ExN().TRI(pFF.this.TRI);
                pFF.this.ExN.ExN().WH();
                BT btPFF = scVar.pFF();
                if (btPFF == null) {
                    return;
                }
                btPFF.sc(pFF.this.pFF, sr2);
                scVar.sc(true);
            }
        });
        return true;
    }
}
