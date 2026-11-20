package com.bytedance.sdk.component.ExN.We;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf extends sc {
    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "raw_cache";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        byte[] bArrSc = zYVar.Sfl().pFF(zYVar.YIK()).sc(zYVar.WH());
        if (bArrSc == null) {
            zYVar.sc(new TRI());
        } else {
            zYVar.sc(new pFF(bArrSc, null));
        }
    }
}
