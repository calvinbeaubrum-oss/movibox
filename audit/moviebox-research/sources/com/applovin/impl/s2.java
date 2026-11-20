package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f22227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f22228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22229c;

    private long a(long j11) {
        return this.f22227a + Math.max(0L, ((this.f22228b - 529) * 1000000) / j11);
    }

    public long a(f9 f9Var) {
        return a(f9Var.A);
    }

    public long a(f9 f9Var, p5 p5Var) {
        if (this.f22228b == 0) {
            this.f22227a = p5Var.f21657f;
        }
        if (this.f22229c) {
            return p5Var.f21657f;
        }
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(p5Var.f21655c);
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            i11 = (i11 << 8) | (byteBuffer.get(i12) & 255);
        }
        int iD = tf.d(i11);
        if (iD != -1) {
            long jA = a(f9Var.A);
            this.f22228b += (long) iD;
            return jA;
        }
        this.f22229c = true;
        this.f22228b = 0L;
        this.f22227a = p5Var.f21657f;
        pc.d("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return p5Var.f21657f;
    }

    public void a() {
        this.f22227a = 0L;
        this.f22228b = 0L;
        this.f22229c = false;
    }
}
