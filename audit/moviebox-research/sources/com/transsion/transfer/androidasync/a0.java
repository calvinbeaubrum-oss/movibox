package com.transsion.transfer.androidasync;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServerSocketChannel f58486b;

    public a0(ServerSocketChannel serverSocketChannel) throws IOException {
        super(serverSocketChannel);
        this.f58486b = serverSocketChannel;
    }

    @Override // com.transsion.transfer.androidasync.q
    public boolean b() {
        return false;
    }

    @Override // com.transsion.transfer.androidasync.q
    public SelectionKey c(Selector selector) throws ClosedChannelException {
        return this.f58486b.register(selector, 16);
    }

    @Override // com.transsion.transfer.androidasync.q
    public void e() {
    }

    @Override // com.transsion.transfer.androidasync.q
    public int g(ByteBuffer[] byteBufferArr) throws IOException {
        throw new IOException("Can't write ServerSocketChannel");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }

    @Override // java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i11, int i12) throws IOException {
        throw new IOException("Can't read ServerSocketChannel");
    }
}
