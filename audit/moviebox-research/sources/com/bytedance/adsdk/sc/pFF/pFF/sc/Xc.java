package com.bytedance.adsdk.sc.pFF.pFF.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Xc implements com.bytedance.adsdk.sc.pFF.pFF.sc {
    protected com.bytedance.adsdk.sc.pFF.pFF.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected com.bytedance.adsdk.sc.pFF.pFF.sc f26303sc;
    protected com.bytedance.adsdk.sc.pFF.We.zY zY;

    public Xc(com.bytedance.adsdk.sc.pFF.We.zY zYVar) {
        this.zY = zYVar;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public String pFF() {
        return this.f26303sc.pFF() + this.zY.sc() + this.pFF.pFF();
    }

    public void pFF(com.bytedance.adsdk.sc.pFF.pFF.sc scVar) {
        this.pFF = scVar;
    }

    @Override // com.bytedance.adsdk.sc.pFF.pFF.sc
    public com.bytedance.adsdk.sc.pFF.We.ExN sc() {
        return com.bytedance.adsdk.sc.pFF.We.TRI.OPERATOR_RESULT;
    }

    public void sc(com.bytedance.adsdk.sc.pFF.pFF.sc scVar) {
        this.f26303sc = scVar;
    }

    public String toString() {
        return pFF();
    }
}
