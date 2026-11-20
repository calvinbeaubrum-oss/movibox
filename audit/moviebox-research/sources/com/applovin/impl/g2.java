package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class g2 extends p5 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f19150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f19151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f19152l;

    public g2() {
        super(2);
        this.f19152l = 32;
    }

    private boolean b(p5 p5Var) {
        ByteBuffer byteBuffer;
        if (!m()) {
            return true;
        }
        if (this.f19151k >= this.f19152l || p5Var.d() != d()) {
            return false;
        }
        ByteBuffer byteBuffer2 = p5Var.f21655c;
        return byteBuffer2 == null || (byteBuffer = this.f21655c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public boolean a(p5 p5Var) {
        b1.a(!p5Var.h());
        b1.a(!p5Var.c());
        b1.a(!p5Var.e());
        if (!b(p5Var)) {
            return false;
        }
        int i11 = this.f19151k;
        this.f19151k = i11 + 1;
        if (i11 == 0) {
            this.f21657f = p5Var.f21657f;
            if (p5Var.f()) {
                e(1);
            }
        }
        if (p5Var.d()) {
            e(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = p5Var.f21655c;
        if (byteBuffer != null) {
            g(byteBuffer.remaining());
            this.f21655c.put(byteBuffer);
        }
        this.f19150j = p5Var.f21657f;
        return true;
    }

    @Override // com.applovin.impl.p5, com.applovin.impl.l2
    public void b() {
        super.b();
        this.f19151k = 0;
    }

    public void i(int i11) {
        b1.a(i11 > 0);
        this.f19152l = i11;
    }

    public long j() {
        return this.f21657f;
    }

    public long k() {
        return this.f19150j;
    }

    public int l() {
        return this.f19151k;
    }

    public boolean m() {
        return this.f19151k > 0;
    }
}
