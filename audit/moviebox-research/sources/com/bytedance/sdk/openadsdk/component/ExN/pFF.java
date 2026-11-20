package com.bytedance.sdk.openadsdk.component.ExN;

import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private int ExN;
    private String TRI;
    private com.bytedance.sdk.openadsdk.core.model.sc We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f27735qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f27736sc;
    private Sfl zY;

    public pFF(int i11, int i12, int i13, String str) {
        this.f27736sc = i11;
        this.pFF = i12;
        this.ExN = i13;
        this.TRI = str;
    }

    public pFF(int i11, int i12, Sfl sfl, com.bytedance.sdk.openadsdk.core.model.sc scVar) {
        this.f27736sc = i11;
        this.pFF = i12;
        this.zY = sfl;
        this.We = scVar;
    }

    public Sfl ExN() {
        return this.zY;
    }

    public int TRI() {
        return this.ExN;
    }

    public int We() {
        return this.pFF;
    }

    public boolean pFF() {
        return this.f27735qr;
    }

    public String qr() {
        return this.TRI;
    }

    public com.bytedance.sdk.openadsdk.core.model.sc sc() {
        return this.We;
    }

    public void sc(boolean z11) {
        this.f27735qr = z11;
    }

    public int zY() {
        return this.f27736sc;
    }
}
