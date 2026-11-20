package com.transsion.transfer.androidasync;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class AsyncDatagramSocket$2 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ InetSocketAddress val$address;
    final /* synthetic */ ByteBuffer val$buffer;

    public AsyncDatagramSocket$2(a aVar, InetSocketAddress inetSocketAddress, ByteBuffer byteBuffer) {
        this.val$address = inetSocketAddress;
        this.val$buffer = byteBuffer;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw null;
    }
}
