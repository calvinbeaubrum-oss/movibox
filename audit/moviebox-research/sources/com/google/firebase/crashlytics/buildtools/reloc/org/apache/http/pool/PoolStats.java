package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.pool;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class PoolStats implements Serializable {
    private static final long serialVersionUID = -2807686144795228544L;
    private final int available;
    private final int leased;
    private final int max;
    private final int pending;

    public PoolStats(int i11, int i12, int i13, int i14) {
        this.leased = i11;
        this.pending = i12;
        this.available = i13;
        this.max = i14;
    }

    public int getAvailable() {
        return this.available;
    }

    public int getLeased() {
        return this.leased;
    }

    public int getMax() {
        return this.max;
    }

    public int getPending() {
        return this.pending;
    }

    public String toString() {
        return "[leased: " + this.leased + "; pending: " + this.pending + "; available: " + this.available + "; max: " + this.max + "]";
    }
}
