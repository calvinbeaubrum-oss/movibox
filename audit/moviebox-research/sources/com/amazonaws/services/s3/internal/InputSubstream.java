package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class InputSubstream extends SdkFilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f15951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15954d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15955f;

    public InputSubstream(InputStream inputStream, long j11, long j12, boolean z11) {
        super(inputStream);
        this.f15955f = 0L;
        this.f15951a = 0L;
        this.f15953c = j12;
        this.f15952b = j11;
        this.f15954d = z11;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        long j11 = this.f15951a;
        long j12 = this.f15952b;
        return (int) Math.min(j11 < j12 ? this.f15953c : (this.f15953c + j12) - j11, super.available());
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f15954d) {
            super.close();
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i11) {
        this.f15955f = this.f15951a;
        super.mark(i11);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i11 = read(bArr, 0, 1);
        return i11 == -1 ? i11 : bArr[0];
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        long j11;
        long j12;
        while (true) {
            j11 = this.f15951a;
            j12 = this.f15952b;
            if (j11 >= j12) {
                break;
            }
            this.f15951a += super.skip(j12 - j11);
        }
        long j13 = (this.f15953c + j12) - j11;
        if (j13 <= 0) {
            return -1;
        }
        int i13 = super.read(bArr, i11, (int) Math.min(i12, j13));
        this.f15951a += (long) i13;
        return i13;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f15951a = this.f15955f;
        super.reset();
    }
}
