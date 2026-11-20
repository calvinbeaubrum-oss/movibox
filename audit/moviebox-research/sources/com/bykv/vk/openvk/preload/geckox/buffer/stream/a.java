package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.buffer.a f25752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f25753b;

    public a(com.bykv.vk.openvk.preload.geckox.buffer.a aVar) {
        this.f25752a = aVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jB = this.f25752a.b() - this.f25752a.c();
        return jB > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) jB;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i11) {
        this.f25753b = i11;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return this.f25752a.d();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return this.f25752a.b(bArr);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        return this.f25752a.b(bArr, i11, i12);
    }

    @Override // java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.f25752a.b(this.f25753b);
    }

    @Override // java.io.InputStream
    public final long skip(long j11) throws IOException {
        return this.f25752a.a(j11);
    }
}
