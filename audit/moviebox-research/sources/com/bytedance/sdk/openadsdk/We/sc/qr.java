package com.bytedance.sdk.openadsdk.We.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class qr implements com.bytedance.sdk.component.TRI.sc.ExN.zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.qr.pFF.pFF f27410sc;

    public qr() {
        com.bytedance.sdk.component.qr.pFF.pFF pffZY = com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().zY();
        this.f27410sc = pffZY;
        pffZY.sc(7);
        pffZY.sc("track_url");
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN.zY
    public com.bytedance.sdk.component.TRI.sc.ExN.We sc() {
        return new Ol(this.f27410sc.sc());
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN.zY
    public void sc(String str) {
        this.f27410sc.pFF(str);
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN.zY
    public void sc(String str, String str2) {
        this.f27410sc.pFF(str, str2);
    }
}
