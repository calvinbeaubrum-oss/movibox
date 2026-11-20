package com.bytedance.sdk.openadsdk.core.model;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f28451sc = 10000;
    private long pFF = 10000;
    private long zY = 10;
    private long We = 20;
    private String ExN = "";

    public String ExN() {
        return this.ExN;
    }

    public long We() {
        return this.We;
    }

    public void We(long j11) {
        if (j11 < 0) {
            this.We = 20L;
        } else {
            this.We = j11;
        }
    }

    public long pFF() {
        return this.pFF;
    }

    public void pFF(long j11) {
        if (j11 < 0) {
            this.pFF = 20L;
        } else {
            this.pFF = j11;
        }
    }

    public long sc() {
        return this.f28451sc;
    }

    public void sc(long j11) {
        if (j11 <= 0) {
            this.f28451sc = 10L;
        } else {
            this.f28451sc = j11;
        }
    }

    public void sc(String str) {
        this.ExN = str;
    }

    public long zY() {
        return this.zY;
    }

    public void zY(long j11) {
        if (j11 <= 0) {
            this.zY = 10L;
        } else {
            this.zY = j11;
        }
    }
}
