package com.bytedance.sdk.component.ExN.We;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends sc {
    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "generate_key";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        if (TextUtils.isEmpty(zYVar.ExN())) {
            com.bytedance.sdk.component.ExN.Tf tfExN = zYVar.Sfl().ExN();
            zYVar.pFF(tfExN.sc(zYVar));
            zYVar.sc(tfExN.pFF(zYVar));
        }
        zYVar.sc(new qr());
    }
}
