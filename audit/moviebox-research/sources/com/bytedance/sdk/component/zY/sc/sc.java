package com.bytedance.sdk.component.zY.sc;

import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    long ExN;
    long Qj;
    long TRI;
    long We;
    long pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    long f27044qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    long f27045sc = SystemClock.elapsedRealtime();
    long zY;

    public void BT() {
        this.pFF = SystemClock.elapsedRealtime();
    }

    public void ExN() {
        this.TRI = SystemClock.elapsedRealtime();
    }

    public long Ol() {
        return this.ExN;
    }

    public long Qj() {
        return this.We;
    }

    public void Ql() {
        this.Qj = SystemClock.elapsedRealtime();
    }

    public long SR() {
        return this.pFF;
    }

    public long TRI() {
        return this.TRI;
    }

    public long Tf() {
        return this.Qj;
    }

    public void UFX() {
        this.f27044qr = SystemClock.elapsedRealtime();
    }

    public long WH() {
        return this.f27044qr;
    }

    public long We() {
        return this.f27045sc;
    }

    public void pFF() {
        this.We = SystemClock.elapsedRealtime();
    }

    public long qr() {
        return this.zY;
    }

    public void sc() {
        this.zY = SystemClock.elapsedRealtime();
    }

    public String toString() {
        return "RequestHttpTime{requestBuildTs=" + this.f27045sc + ", asyncCallExecTs=" + this.pFF + ", requestStartExecTs=" + this.zY + ", requestConnectStartTs=" + this.We + ", requestConnectFinishTs=" + this.ExN + ", reqCallServerStartTs=" + this.f27044qr + ", reqCallServerFinishTs=" + this.Qj + '}';
    }

    public void zY() {
        this.ExN = SystemClock.elapsedRealtime();
    }
}
