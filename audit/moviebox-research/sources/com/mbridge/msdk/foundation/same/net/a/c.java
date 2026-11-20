package com.mbridge.msdk.foundation.same.net.a;

import java.io.ByteArrayOutputStream;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends UrlRequest.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    BlockingQueue<b> f44538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ByteArrayOutputStream f44539b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.mbridge.msdk.foundation.same.net.f.b f44540c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    WritableByteChannel f44541d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AtomicBoolean f44542e = new AtomicBoolean(false);

    public c(BlockingQueue<b> blockingQueue) {
        this.f44538a = blockingQueue;
    }
}
