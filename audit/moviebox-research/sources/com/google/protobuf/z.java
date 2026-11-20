package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class z extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator<ByteBuffer> f41445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f41446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41447c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41448d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f41449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f41451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f41452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f41453j;

    public z(Iterable<ByteBuffer> iterable) {
        this.f41445a = iterable.iterator();
        for (ByteBuffer byteBuffer : iterable) {
            this.f41447c++;
        }
        this.f41448d = -1;
        if (a()) {
            return;
        }
        this.f41446b = y.f41438d;
        this.f41448d = 0;
        this.f41449f = 0;
        this.f41453j = 0L;
    }

    public final boolean a() {
        this.f41448d++;
        if (!this.f41445a.hasNext()) {
            return false;
        }
        ByteBuffer next = this.f41445a.next();
        this.f41446b = next;
        this.f41449f = next.position();
        if (this.f41446b.hasArray()) {
            this.f41450g = true;
            this.f41451h = this.f41446b.array();
            this.f41452i = this.f41446b.arrayOffset();
        } else {
            this.f41450g = false;
            this.f41453j = l1.k(this.f41446b);
            this.f41451h = null;
        }
        return true;
    }

    public final void b(int i11) {
        int i12 = this.f41449f + i11;
        this.f41449f = i12;
        if (i12 == this.f41446b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f41448d == this.f41447c) {
            return -1;
        }
        if (this.f41450g) {
            int i11 = this.f41451h[this.f41449f + this.f41452i] & 255;
            b(1);
            return i11;
        }
        int iW = l1.w(((long) this.f41449f) + this.f41453j) & 255;
        b(1);
        return iW;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f41448d == this.f41447c) {
            return -1;
        }
        int iLimit = this.f41446b.limit();
        int i13 = this.f41449f;
        int i14 = iLimit - i13;
        if (i12 > i14) {
            i12 = i14;
        }
        if (this.f41450g) {
            System.arraycopy(this.f41451h, i13 + this.f41452i, bArr, i11, i12);
            b(i12);
        } else {
            int iPosition = this.f41446b.position();
            this.f41446b.position(this.f41449f);
            this.f41446b.get(bArr, i11, i12);
            this.f41446b.position(iPosition);
            b(i12);
        }
        return i12;
    }
}
