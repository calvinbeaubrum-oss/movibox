package com.bytedance.adsdk.pFF.TRI;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26154sc;

    public void sc(float f11) {
        float f12 = this.f26154sc + f11;
        this.f26154sc = f12;
        int i11 = this.pFF + 1;
        this.pFF = i11;
        if (i11 == Integer.MAX_VALUE) {
            this.f26154sc = f12 / 2.0f;
            this.pFF = i11 / 2;
        }
    }
}
