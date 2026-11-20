package com.bytedance.sdk.openadsdk.JPJ.pFF;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends pFF {
    private int We;

    public Qj(Integer num, View view, Sfl sfl, ExN.sc scVar) {
        super(num, view, sfl, 2000, scVar);
        this.We = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public int TRI() {
        return 200;
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public boolean Tf() {
        int i11 = this.We;
        boolean z11 = i11 == 2 || i11 == 0;
        if (z11) {
            this.zY.set(false);
        }
        return !z11 || super.Tf();
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public void We() {
        super.We();
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public void pFF(int i11) {
        if (Ol()) {
            return;
        }
        if (i11 == 6 || i11 == 5) {
            this.We = 0;
            Qj();
        }
        if (i11 == 3 || i11 == 2) {
            this.We = 2;
            Qj();
        }
        if (this.We == 1 || i11 != 0) {
            return;
        }
        this.We = 1;
        sc();
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public void sc() {
        if (this.We != 1) {
            return;
        }
        super.sc();
    }

    @Override // com.bytedance.sdk.openadsdk.JPJ.pFF.pFF
    public boolean zY() {
        return TRI.sc(this.f27093sc.get(), this.pFF.Zn()) && this.We == 1;
    }
}
