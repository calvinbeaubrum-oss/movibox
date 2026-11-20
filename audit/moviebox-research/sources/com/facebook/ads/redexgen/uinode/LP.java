package com.facebook.ads.redexgen.uinode;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LP implements Closeable {
    public LO A00;
    public boolean A01;
    public final LN A02;
    public final Runnable A03;

    public LP(long j11, Runnable runnable) {
        LN ln2 = new LN(j11);
        this.A02 = ln2;
        ln2.A02();
        this.A03 = runnable;
        this.A01 = false;
    }

    private final synchronized void A03() {
        if (this.A00 == null && !this.A01) {
            this.A00 = new LO(this);
        }
    }

    public final LN A04() {
        return this.A02;
    }

    public final synchronized void A05() {
        if (this.A01) {
            return;
        }
        if (this.A00 == null) {
            this.A00 = new LO(this);
        }
        this.A00.A00();
    }

    public final synchronized void A06() {
        if (this.A02.A05() && !this.A01) {
            A03();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        LO lo2;
        synchronized (this) {
            this.A01 = true;
            lo2 = this.A00;
        }
        if (lo2 != null) {
            lo2.close();
        }
    }
}
