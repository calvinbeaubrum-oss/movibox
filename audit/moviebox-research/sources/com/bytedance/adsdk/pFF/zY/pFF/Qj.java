package com.bytedance.adsdk.pFF.zY.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {
    private final boolean We;
    private final com.bytedance.adsdk.pFF.zY.sc.Qj pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f26237sc;
    private final com.bytedance.adsdk.pFF.zY.sc.We zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Qj(sc scVar, com.bytedance.adsdk.pFF.zY.sc.Qj qj2, com.bytedance.adsdk.pFF.zY.sc.We we2, boolean z11) {
        this.f26237sc = scVar;
        this.pFF = qj2;
        this.zY = we2;
        this.We = z11;
    }

    public boolean We() {
        return this.We;
    }

    public com.bytedance.adsdk.pFF.zY.sc.Qj pFF() {
        return this.pFF;
    }

    public sc sc() {
        return this.f26237sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.We zY() {
        return this.zY;
    }
}
