package com.bytedance.adsdk.pFF.zY.pFF;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class dE implements zY {
    private final List<zY> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26252sc;
    private final boolean zY;

    public dE(String str, List<zY> list, boolean z11) {
        this.f26252sc = str;
        this.pFF = list;
        this.zY = z11;
    }

    public List<zY> pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new com.bytedance.adsdk.pFF.sc.sc.We(ol2, scVar, this, qrVar);
    }

    public String sc() {
        return this.f26252sc;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f26252sc + "' Shapes: " + Arrays.toString(this.pFF.toArray()) + '}';
    }

    public boolean zY() {
        return this.zY;
    }
}
