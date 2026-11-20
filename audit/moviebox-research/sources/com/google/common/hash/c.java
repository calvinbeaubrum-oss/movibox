package com.google.common.hash;

import com.google.common.base.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f38746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f38747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38748c;

    public c(int i11) {
        this(i11, i11);
    }

    public c(int i11, int i12) {
        m.d(i12 % i11 == 0);
        this.f38746a = ByteBuffer.allocate(i12 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f38747b = i12;
        this.f38748c = i11;
    }

    @Override // com.google.common.hash.e
    public final HashCode a() {
        l();
        g.a(this.f38746a);
        if (this.f38746a.remaining() > 0) {
            o(this.f38746a);
            ByteBuffer byteBuffer = this.f38746a;
            g.b(byteBuffer, byteBuffer.limit());
        }
        return k();
    }

    @Override // com.google.common.hash.b, com.google.common.hash.e
    public final e c(byte[] bArr, int i11, int i12) {
        return p(ByteBuffer.wrap(bArr, i11, i12).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.e
    public final e d(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return p(byteBuffer);
        } finally {
            byteBuffer.order(byteOrderOrder);
        }
    }

    @Override // com.google.common.hash.e
    public final e e(int i11) {
        this.f38746a.putInt(i11);
        m();
        return this;
    }

    @Override // com.google.common.hash.e
    public final e g(long j11) {
        this.f38746a.putLong(j11);
        m();
        return this;
    }

    @Override // com.google.common.hash.b
    public final e j(char c11) {
        this.f38746a.putChar(c11);
        m();
        return this;
    }

    public abstract HashCode k();

    public final void l() {
        g.a(this.f38746a);
        while (this.f38746a.remaining() >= this.f38748c) {
            n(this.f38746a);
        }
        this.f38746a.compact();
    }

    public final void m() {
        if (this.f38746a.remaining() < 8) {
            l();
        }
    }

    public abstract void n(ByteBuffer byteBuffer);

    public abstract void o(ByteBuffer byteBuffer);

    public final e p(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f38746a.remaining()) {
            this.f38746a.put(byteBuffer);
            m();
            return this;
        }
        int iPosition = this.f38747b - this.f38746a.position();
        for (int i11 = 0; i11 < iPosition; i11++) {
            this.f38746a.put(byteBuffer.get());
        }
        l();
        while (byteBuffer.remaining() >= this.f38748c) {
            n(byteBuffer);
        }
        this.f38746a.put(byteBuffer);
        return this;
    }
}
