package com.transsion.transfer.androidasync;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class AsyncDatagramSocket$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ ByteBuffer val$buffer;
    final /* synthetic */ String val$host;
    final /* synthetic */ int val$port;

    public AsyncDatagramSocket$1(a aVar, String str, int i11, ByteBuffer byteBuffer) {
        this.val$host = str;
        this.val$port = i11;
        this.val$buffer = byteBuffer;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw null;
    }
}
