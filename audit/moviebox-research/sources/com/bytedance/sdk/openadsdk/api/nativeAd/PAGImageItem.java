package com.bytedance.sdk.openadsdk.api.nativeAd;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGImageItem {
    private float We;
    private final int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f27674sc;
    private final String zY;

    public PAGImageItem(int i11, int i12, String str) {
        this(i11, i12, str, 0.0f);
    }

    public PAGImageItem(int i11, int i12, String str, float f11) {
        this.f27674sc = i11;
        this.pFF = i12;
        this.zY = str;
        this.We = f11;
    }

    public float getDuration() {
        return this.We;
    }

    public int getHeight() {
        return this.f27674sc;
    }

    public String getImageUrl() {
        return this.zY;
    }

    public int getWidth() {
        return this.pFF;
    }
}
