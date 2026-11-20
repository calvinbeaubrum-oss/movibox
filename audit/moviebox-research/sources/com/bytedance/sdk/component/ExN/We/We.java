package com.bytedance.sdk.component.ExN.We;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "cache_policy";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        com.bytedance.sdk.component.ExN.pFF pffYIK = zYVar.YIK();
        if (pffYIK != null) {
            if (pffYIK.zY()) {
                zYVar.sc(new WH());
                return;
            } else if (pffYIK.We()) {
                zYVar.sc(new TRI());
                return;
            }
        }
        zYVar.sc(new UFX());
    }
}
