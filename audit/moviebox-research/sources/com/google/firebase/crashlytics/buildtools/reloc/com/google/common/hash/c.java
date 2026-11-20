package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f39833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f39834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f39835c;

    public c(int i11) {
        this(i11, i11);
    }

    public c(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(i12 % i11 == 0);
        this.f39833a = ByteBuffer.allocate(i12 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f39834b = i12;
        this.f39835c = i11;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public final HashCode a() {
        l();
        this.f39833a.flip();
        if (this.f39833a.remaining() > 0) {
            o(this.f39833a);
            ByteBuffer byteBuffer = this.f39833a;
            byteBuffer.position(byteBuffer.limit());
        }
        return k();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.b, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public final i c(byte[] bArr, int i11, int i12) {
        return p(ByteBuffer.wrap(bArr, i11, i12).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public final i d(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return p(byteBuffer);
        } finally {
            byteBuffer.order(byteOrderOrder);
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public final i e(int i11) {
        this.f39833a.putInt(i11);
        m();
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public final i g(long j11) {
        this.f39833a.putLong(j11);
        m();
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.b
    public final i j(char c11) {
        this.f39833a.putChar(c11);
        m();
        return this;
    }

    public abstract HashCode k();

    public final void l() {
        this.f39833a.flip();
        while (this.f39833a.remaining() >= this.f39835c) {
            n(this.f39833a);
        }
        this.f39833a.compact();
    }

    public final void m() {
        if (this.f39833a.remaining() < 8) {
            l();
        }
    }

    public abstract void n(ByteBuffer byteBuffer);

    public abstract void o(ByteBuffer byteBuffer);

    public final i p(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f39833a.remaining()) {
            this.f39833a.put(byteBuffer);
            m();
            return this;
        }
        int iPosition = this.f39834b - this.f39833a.position();
        for (int i11 = 0; i11 < iPosition; i11++) {
            this.f39833a.put(byteBuffer.get());
        }
        l();
        while (byteBuffer.remaining() >= this.f39835c) {
            n(byteBuffer);
        }
        this.f39833a.put(byteBuffer);
        return this;
    }
}
