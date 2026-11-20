package com.transsion.transfer.androidasync.stream;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.r;
import fy.d;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements d, fy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OutputStream f58860a;

    public a(OutputStream outputStream) {
        this.f58860a = outputStream;
    }

    @Override // fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        while (byteBufferList.E() > 0) {
            try {
                try {
                    ByteBuffer byteBufferD = byteBufferList.D();
                    this.f58860a.write(byteBufferD.array(), byteBufferD.arrayOffset() + byteBufferD.position(), byteBufferD.remaining());
                    ByteBufferList.A(byteBufferD);
                } catch (Exception e11) {
                    i(e11);
                }
            } catch (Throwable th2) {
                byteBufferList.B();
                throw th2;
            }
        }
        byteBufferList.B();
    }

    @Override // fy.a
    public void i(Exception exc) {
        exc.printStackTrace();
    }
}
