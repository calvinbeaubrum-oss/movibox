package com.bytedance.sdk.openadsdk.api.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGErrorModel {
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final int f27673sc;

    public PAGErrorModel(int i11, String str) {
        this.f27673sc = i11;
        this.pFF = str;
    }

    public int getErrorCode() {
        return this.f27673sc;
    }

    public String getErrorMessage() {
        return this.pFF;
    }
}
