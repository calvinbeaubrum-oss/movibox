package com.bytedance.adsdk.pFF.zY.pFF;

import com.bytedance.adsdk.pFF.sc.sc.Dl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Sfl implements zY {
    private final com.bytedance.adsdk.pFF.zY.sc.pFF ExN;
    private final boolean TRI;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF We;
    private final sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26241sc;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static sc sc(int i11) {
            if (i11 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i11 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i11)));
        }
    }

    public Sfl(String str, sc scVar, com.bytedance.adsdk.pFF.zY.sc.pFF pff, com.bytedance.adsdk.pFF.zY.sc.pFF pff2, com.bytedance.adsdk.pFF.zY.sc.pFF pff3, boolean z11) {
        this.f26241sc = str;
        this.pFF = scVar;
        this.zY = pff;
        this.We = pff2;
        this.ExN = pff3;
        this.TRI = z11;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF ExN() {
        return this.ExN;
    }

    public boolean TRI() {
        return this.TRI;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF We() {
        return this.zY;
    }

    public sc pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new Dl(scVar, this);
    }

    public String sc() {
        return this.f26241sc;
    }

    public String toString() {
        return "Trim Path: {start: " + this.zY + ", end: " + this.We + ", offset: " + this.ExN + "}";
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF zY() {
        return this.We;
    }
}
