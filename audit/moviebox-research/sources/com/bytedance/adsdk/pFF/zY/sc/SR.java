package com.bytedance.adsdk.pFF.zY.sc;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class SR<V, O> implements Ql<V, O> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final List<com.bytedance.adsdk.pFF.qr.sc<V>> f26265sc;

    public SR(List<com.bytedance.adsdk.pFF.qr.sc<V>> list) {
        this.f26265sc = list;
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public boolean pFF() {
        return this.f26265sc.isEmpty() || (this.f26265sc.size() == 1 && this.f26265sc.get(0).ExN());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (!this.f26265sc.isEmpty()) {
            sb2.append("values=");
            sb2.append(Arrays.toString(this.f26265sc.toArray()));
        }
        return sb2.toString();
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public List<com.bytedance.adsdk.pFF.qr.sc<V>> zY() {
        return this.f26265sc;
    }
}
