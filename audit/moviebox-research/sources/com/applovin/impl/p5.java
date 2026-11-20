package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class p5 extends l2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f21654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f21655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21656d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ByteBuffer f21658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f21659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f21660i;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends IllegalStateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21662b;

        public a(int i11, int i12) {
            super("Buffer too small (" + i11 + " < " + i12 + ")");
            this.f21661a = i11;
            this.f21662b = i12;
        }
    }

    public p5(int i11) {
        this(i11, 0);
    }

    public p5(int i11, int i12) {
        this.f21654b = new a5();
        this.f21659h = i11;
        this.f21660i = i12;
    }

    private ByteBuffer f(int i11) {
        int i12 = this.f21659h;
        if (i12 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i12 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.f21655c;
        throw new a(byteBuffer == null ? 0 : byteBuffer.capacity(), i11);
    }

    public static p5 i() {
        return new p5(0);
    }

    @Override // com.applovin.impl.l2
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.f21655c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f21658g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f21656d = false;
    }

    public final void g() {
        ByteBuffer byteBuffer = this.f21655c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f21658g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public void g(int i11) {
        int i12 = i11 + this.f21660i;
        ByteBuffer byteBuffer = this.f21655c;
        if (byteBuffer == null) {
            this.f21655c = f(i12);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i13 = i12 + iPosition;
        if (iCapacity >= i13) {
            this.f21655c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferF = f(i13);
        byteBufferF.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferF.put(byteBuffer);
        }
        this.f21655c = byteBufferF;
    }

    public void h(int i11) {
        ByteBuffer byteBuffer = this.f21658g;
        if (byteBuffer == null || byteBuffer.capacity() < i11) {
            this.f21658g = ByteBuffer.allocate(i11);
        } else {
            this.f21658g.clear();
        }
    }

    public final boolean h() {
        return d(1073741824);
    }
}
