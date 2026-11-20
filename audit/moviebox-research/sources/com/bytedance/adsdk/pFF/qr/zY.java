package com.bytedance.adsdk.pFF.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26181sc;

    public zY() {
        this(1.0f, 1.0f);
    }

    public zY(float f11, float f12) {
        this.f26181sc = f11;
        this.pFF = f12;
    }

    public float pFF() {
        return this.pFF;
    }

    public boolean pFF(float f11, float f12) {
        return this.f26181sc == f11 && this.pFF == f12;
    }

    public float sc() {
        return this.f26181sc;
    }

    public void sc(float f11, float f12) {
        this.f26181sc = f11;
        this.pFF = f12;
    }

    public String toString() {
        return sc() + "x" + pFF();
    }
}
