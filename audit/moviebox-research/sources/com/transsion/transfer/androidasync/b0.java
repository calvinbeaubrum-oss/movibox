package com.transsion.transfer.androidasync;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SocketChannel f58487b;

    public b0(SocketChannel socketChannel) throws IOException {
        super(socketChannel);
        this.f58487b = socketChannel;
    }

    @Override // com.transsion.transfer.androidasync.q
    public boolean b() {
        return this.f58487b.isConnected();
    }

    @Override // com.transsion.transfer.androidasync.q
    public SelectionKey c(Selector selector) throws ClosedChannelException {
        return d(selector, 8);
    }

    @Override // com.transsion.transfer.androidasync.q
    public void e() {
        try {
            this.f58487b.socket().shutdownOutput();
        } catch (Exception unused) {
        }
    }

    @Override // com.transsion.transfer.androidasync.q
    public int g(ByteBuffer[] byteBufferArr) throws IOException {
        return (int) this.f58487b.write(byteBufferArr);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.f58487b.read(byteBuffer);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        return this.f58487b.read(byteBufferArr);
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i11, int i12) throws IOException {
        return this.f58487b.read(byteBufferArr, i11, i12);
    }
}
