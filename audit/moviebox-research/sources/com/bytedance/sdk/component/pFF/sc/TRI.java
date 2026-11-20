package com.bytedance.sdk.component.pFF.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String[] f26932sc;

    public TRI(String[] strArr) {
        this.f26932sc = strArr;
    }

    public String pFF(int i11) {
        return this.f26932sc[(i11 * 2) + 1];
    }

    public int sc() {
        return this.f26932sc.length / 2;
    }

    public String sc(int i11) {
        return this.f26932sc[i11 * 2];
    }
}
