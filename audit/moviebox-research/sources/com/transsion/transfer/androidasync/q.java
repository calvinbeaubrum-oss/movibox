package com.transsion.transfer.androidasync;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class q implements ReadableByteChannel, ScatteringByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractSelectableChannel f58856a;

    public q(AbstractSelectableChannel abstractSelectableChannel) throws IOException {
        abstractSelectableChannel.configureBlocking(false);
        this.f58856a = abstractSelectableChannel;
    }

    public boolean a() {
        return false;
    }

    public abstract boolean b();

    public abstract SelectionKey c(Selector selector) throws ClosedChannelException;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f58856a.close();
    }

    public SelectionKey d(Selector selector, int i11) throws ClosedChannelException {
        return this.f58856a.register(selector, i11);
    }

    public abstract void e();

    public abstract int g(ByteBuffer[] byteBufferArr) throws IOException;

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f58856a.isOpen();
    }
}
