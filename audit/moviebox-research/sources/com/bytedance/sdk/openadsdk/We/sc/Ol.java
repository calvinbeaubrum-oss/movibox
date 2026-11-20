package com.bytedance.sdk.openadsdk.We.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class Ol implements com.bytedance.sdk.component.TRI.sc.ExN.We {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.qr.pFF f27383sc;

    public Ol(com.bytedance.sdk.component.qr.pFF pff) {
        this.f27383sc = pff;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN.We
    public int pFF() {
        com.bytedance.sdk.component.qr.pFF pff = this.f27383sc;
        if (pff != null) {
            return pff.sc();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN.We
    public boolean sc() {
        com.bytedance.sdk.component.qr.pFF pff = this.f27383sc;
        if (pff != null) {
            return pff.TRI();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.ExN.We
    public String zY() {
        com.bytedance.sdk.component.qr.pFF pff = this.f27383sc;
        return pff != null ? pff.pFF() : "";
    }
}
