package com.bytedance.sdk.component.adexpress.pFF;

import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI implements WH {
    private sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26886sc;
    private Ql zY;

    public TRI(Context context, Ql ql2, sc scVar) {
        this.f26886sc = context;
        this.pFF = scVar;
        this.zY = ql2;
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public void sc() {
    }

    public void sc(zY zYVar) {
        this.pFF.sc(zYVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.pFF.WH
    public boolean sc(final WH.sc scVar) {
        this.zY.ExN().TRI();
        this.pFF.sc(new qr() { // from class: com.bytedance.sdk.component.adexpress.pFF.TRI.1
            @Override // com.bytedance.sdk.component.adexpress.pFF.qr
            public void sc(int i11, String str) {
                BT btPFF = scVar.pFF();
                if (btPFF != null) {
                    btPFF.a_(i11);
                }
            }

            @Override // com.bytedance.sdk.component.adexpress.pFF.qr
            public void sc(View view, SR sr2) {
                if (scVar.zY()) {
                    return;
                }
                BT btPFF = scVar.pFF();
                if (btPFF != null) {
                    btPFF.sc(TRI.this.pFF, sr2);
                }
                scVar.sc(true);
            }
        });
        return true;
    }
}
