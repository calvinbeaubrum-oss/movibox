package com.bytedance.sdk.openadsdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTImage {
    private double We;
    private final int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f27285sc;
    private final String zY;

    public TTImage(int i11, int i12, String str) {
        this(i11, i12, str, 0.0d);
    }

    public TTImage(int i11, int i12, String str, double d11) {
        this.f27285sc = i11;
        this.pFF = i12;
        this.zY = str;
        this.We = d11;
    }

    public double getDuration() {
        return this.We;
    }

    public int getHeight() {
        return this.f27285sc;
    }

    public String getImageUrl() {
        return this.zY;
    }

    public int getWidth() {
        return this.pFF;
    }

    public boolean isValid() {
        String str;
        return this.f27285sc > 0 && this.pFF > 0 && (str = this.zY) != null && str.length() > 0;
    }
}
