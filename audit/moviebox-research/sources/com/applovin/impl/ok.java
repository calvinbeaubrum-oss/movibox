package com.applovin.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ok implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f21568c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f21569d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p1.a f21570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private p1.a f21571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private p1.a f21572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private p1.a f21573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f21574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private nk f21575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ByteBuffer f21576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ShortBuffer f21577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ByteBuffer f21578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f21579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f21580o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f21581p;

    public ok() {
        p1.a aVar = p1.a.f21633e;
        this.f21570e = aVar;
        this.f21571f = aVar;
        this.f21572g = aVar;
        this.f21573h = aVar;
        ByteBuffer byteBuffer = p1.f21632a;
        this.f21576k = byteBuffer;
        this.f21577l = byteBuffer.asShortBuffer();
        this.f21578m = byteBuffer;
        this.f21567b = -1;
    }

    public long a(long j11) {
        if (this.f21580o < 1024) {
            return (long) (((double) this.f21568c) * j11);
        }
        long jC = this.f21579n - ((long) ((nk) b1.a(this.f21575j)).c());
        int i11 = this.f21573h.f21634a;
        int i12 = this.f21572g.f21634a;
        return i11 == i12 ? xp.c(j11, jC, this.f21580o) : xp.c(j11, jC * ((long) i11), this.f21580o * ((long) i12));
    }

    @Override // com.applovin.impl.p1
    public p1.a a(p1.a aVar) throws p1.b {
        if (aVar.f21636c != 2) {
            throw new p1.b(aVar);
        }
        int i11 = this.f21567b;
        if (i11 == -1) {
            i11 = aVar.f21634a;
        }
        this.f21570e = aVar;
        p1.a aVar2 = new p1.a(i11, aVar.f21635b, 2);
        this.f21571f = aVar2;
        this.f21574i = true;
        return aVar2;
    }

    public void a(float f11) {
        if (this.f21569d != f11) {
            this.f21569d = f11;
            this.f21574i = true;
        }
    }

    @Override // com.applovin.impl.p1
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            nk nkVar = (nk) b1.a(this.f21575j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f21579n += (long) iRemaining;
            nkVar.b(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.applovin.impl.p1
    public void b() {
        if (f()) {
            p1.a aVar = this.f21570e;
            this.f21572g = aVar;
            p1.a aVar2 = this.f21571f;
            this.f21573h = aVar2;
            if (this.f21574i) {
                this.f21575j = new nk(aVar.f21634a, aVar.f21635b, this.f21568c, this.f21569d, aVar2.f21634a);
            } else {
                nk nkVar = this.f21575j;
                if (nkVar != null) {
                    nkVar.a();
                }
            }
        }
        this.f21578m = p1.f21632a;
        this.f21579n = 0L;
        this.f21580o = 0L;
        this.f21581p = false;
    }

    public void b(float f11) {
        if (this.f21568c != f11) {
            this.f21568c = f11;
            this.f21574i = true;
        }
    }

    @Override // com.applovin.impl.p1
    public boolean c() {
        nk nkVar;
        return this.f21581p && ((nkVar = this.f21575j) == null || nkVar.b() == 0);
    }

    @Override // com.applovin.impl.p1
    public ByteBuffer d() {
        int iB;
        nk nkVar = this.f21575j;
        if (nkVar != null && (iB = nkVar.b()) > 0) {
            if (this.f21576k.capacity() < iB) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iB).order(ByteOrder.nativeOrder());
                this.f21576k = byteBufferOrder;
                this.f21577l = byteBufferOrder.asShortBuffer();
            } else {
                this.f21576k.clear();
                this.f21577l.clear();
            }
            nkVar.a(this.f21577l);
            this.f21580o += (long) iB;
            this.f21576k.limit(iB);
            this.f21578m = this.f21576k;
        }
        ByteBuffer byteBuffer = this.f21578m;
        this.f21578m = p1.f21632a;
        return byteBuffer;
    }

    @Override // com.applovin.impl.p1
    public void e() {
        nk nkVar = this.f21575j;
        if (nkVar != null) {
            nkVar.e();
        }
        this.f21581p = true;
    }

    @Override // com.applovin.impl.p1
    public boolean f() {
        return this.f21571f.f21634a != -1 && (Math.abs(this.f21568c - 1.0f) >= 1.0E-4f || Math.abs(this.f21569d - 1.0f) >= 1.0E-4f || this.f21571f.f21634a != this.f21570e.f21634a);
    }

    @Override // com.applovin.impl.p1
    public void reset() {
        this.f21568c = 1.0f;
        this.f21569d = 1.0f;
        p1.a aVar = p1.a.f21633e;
        this.f21570e = aVar;
        this.f21571f = aVar;
        this.f21572g = aVar;
        this.f21573h = aVar;
        ByteBuffer byteBuffer = p1.f21632a;
        this.f21576k = byteBuffer;
        this.f21577l = byteBuffer.asShortBuffer();
        this.f21578m = byteBuffer;
        this.f21567b = -1;
        this.f21574i = false;
        this.f21575j = null;
        this.f21579n = 0L;
        this.f21580o = 0L;
        this.f21581p = false;
    }
}
