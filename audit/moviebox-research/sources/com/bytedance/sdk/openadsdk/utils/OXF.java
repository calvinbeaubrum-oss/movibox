package com.bytedance.sdk.openadsdk.utils;

import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class OXF {
    private long pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public long f28736sc;

    private OXF(boolean z11) {
        if (z11) {
            ExN();
        }
    }

    public static OXF pFF() {
        return new OXF(true);
    }

    public static OXF zY() {
        return new OXF(false);
    }

    public void ExN() {
        this.f28736sc = System.currentTimeMillis();
        this.pFF = SystemClock.elapsedRealtime();
    }

    public boolean TRI() {
        return this.pFF > 0;
    }

    public long We() {
        return SystemClock.elapsedRealtime() - this.pFF;
    }

    public long sc() {
        return this.pFF;
    }

    public long sc(OXF oxf) {
        return Math.abs(oxf.pFF - this.pFF);
    }

    public String toString() {
        return String.valueOf(this.f28736sc);
    }
}
