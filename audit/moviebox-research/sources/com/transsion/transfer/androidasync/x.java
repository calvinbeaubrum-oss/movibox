package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class x implements fy.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Charset f58883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBufferList f58884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f58885c;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(String str);
    }

    public x() {
        this(null);
    }

    public x(Charset charset) {
        this.f58884b = new ByteBufferList();
        this.f58883a = charset;
    }

    @Override // fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferList.C());
        while (byteBufferList.C() > 0) {
            byte bE = byteBufferList.e();
            if (bE == 10) {
                byteBufferAllocate.flip();
                this.f58884b.a(byteBufferAllocate);
                this.f58885c.a(this.f58884b.z(this.f58883a));
                this.f58884b = new ByteBufferList();
                return;
            }
            byteBufferAllocate.put(bE);
        }
        byteBufferAllocate.flip();
        this.f58884b.a(byteBufferAllocate);
    }

    public void a(a aVar) {
        this.f58885c = aVar;
    }
}
