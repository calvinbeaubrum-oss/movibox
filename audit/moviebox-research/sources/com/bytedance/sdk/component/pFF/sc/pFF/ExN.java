package com.bytedance.sdk.component.pFF.sc.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ExN {
    boolean ExN;
    ExN TRI;
    boolean We;
    int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    ExN f26940qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final byte[] f26941sc;
    int zY;

    public ExN() {
        this.f26941sc = new byte[8192];
        this.ExN = true;
        this.We = false;
    }

    public ExN(byte[] bArr, int i11, int i12, boolean z11, boolean z12) {
        this.f26941sc = bArr;
        this.pFF = i11;
        this.zY = i12;
        this.We = z11;
        this.ExN = z12;
    }

    public final ExN pFF() {
        ExN exN = this.TRI;
        ExN exN2 = exN != this ? exN : null;
        ExN exN3 = this.f26940qr;
        if (exN3 != null) {
            exN3.TRI = exN;
        }
        ExN exN4 = this.TRI;
        if (exN4 != null) {
            exN4.f26940qr = exN3;
        }
        this.TRI = null;
        this.f26940qr = null;
        return exN2;
    }

    public final ExN sc() {
        this.We = true;
        return new ExN(this.f26941sc, this.pFF, this.zY, true, false);
    }

    public final ExN sc(ExN exN) {
        exN.f26940qr = this;
        exN.TRI = this.TRI;
        this.TRI.f26940qr = exN;
        this.TRI = exN;
        return exN;
    }
}
