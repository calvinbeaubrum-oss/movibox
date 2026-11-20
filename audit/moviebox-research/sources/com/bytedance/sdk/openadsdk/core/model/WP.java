package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.utils.OXF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WP {
    private long ExN;
    private long Ol;
    private long Qj;
    private long TRI;
    private int UFX;
    private long WH;
    public long pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f28413qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public boolean f28414sc;
    private OXF zY = OXF.zY();
    private OXF We = OXF.zY();

    public long ExN() {
        return this.Qj;
    }

    public int Qj() {
        return this.UFX;
    }

    public long TRI() {
        return this.Ol;
    }

    public long We() {
        return this.f28413qr;
    }

    public long pFF() {
        return this.ExN;
    }

    public void pFF(OXF oxf) {
        this.We = oxf;
        this.Ol = oxf.sc(this.zY);
    }

    public long qr() {
        return this.WH;
    }

    public OXF sc() {
        return this.zY;
    }

    public void sc(int i11) {
        this.UFX = i11;
    }

    public void sc(long j11) {
        this.WH = j11;
    }

    public void sc(OXF oxf) {
        this.zY = oxf;
    }

    public void sc(OXF oxf, OXF oxf2, int i11, OXF oxf3) {
        this.ExN = oxf.sc(this.zY);
        this.TRI = oxf2.sc(oxf);
        this.f28413qr = i11;
        this.Qj = oxf3.sc(oxf2);
    }

    public long zY() {
        return this.TRI;
    }
}
