package com.bytedance.sdk.component.Qj.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pFF implements Comparable<pFF>, Runnable {
    private long ExN;
    private long TRI;
    private long We;
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26580sc;
    private Runnable zY;

    public pFF(int i11, String str) {
        this.f26580sc = i11;
        this.pFF = str;
    }

    public pFF(String str) {
        this.f26580sc = 5;
        this.pFF = str;
    }

    public pFF(String str, Runnable runnable) {
        this.f26580sc = 5;
        this.pFF = str;
        this.zY = runnable;
    }

    public long ExN() {
        return this.TRI;
    }

    public Runnable Qj() {
        return this.zY;
    }

    public long TRI() {
        return this.ExN - this.We;
    }

    public long We() {
        return this.ExN;
    }

    public String pFF() {
        return this.pFF;
    }

    public void pFF(long j11) {
        this.ExN = j11;
    }

    public long qr() {
        return this.TRI - this.ExN;
    }

    public int sc() {
        return this.f26580sc;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(pFF pff) {
        if (sc() < pff.sc()) {
            return 1;
        }
        return sc() >= pff.sc() ? -1 : 0;
    }

    public void sc(int i11) {
        this.f26580sc = i11;
    }

    public void sc(long j11) {
        this.We = j11;
    }

    public long zY() {
        return this.We;
    }

    public void zY(long j11) {
        this.TRI = j11;
    }
}
