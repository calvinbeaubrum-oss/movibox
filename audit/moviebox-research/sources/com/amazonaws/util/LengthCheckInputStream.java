package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class LengthCheckInputStream extends SdkFilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16267d;

    public LengthCheckInputStream(InputStream inputStream, long j11, boolean z11) {
        super(inputStream);
        if (j11 < 0) {
            throw new IllegalArgumentException();
        }
        this.f16264a = j11;
        this.f16265b = z11;
    }

    public final void d(boolean z11) {
        if (z11) {
            if (this.f16266c == this.f16264a) {
                return;
            }
            throw new AmazonClientException("Data read (" + this.f16266c + ") has a different length than the expected (" + this.f16264a + ")");
        }
        if (this.f16266c <= this.f16264a) {
            return;
        }
        throw new AmazonClientException("More data read (" + this.f16266c + ") than expected (" + this.f16264a + ")");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int i11) {
        super.mark(i11);
        this.f16267d = this.f16266c;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i11 = super.read();
        if (i11 >= 0) {
            this.f16266c++;
        }
        d(i11 == -1);
        return i11;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = super.read(bArr, i11, i12);
        this.f16266c += i13 >= 0 ? i13 : 0L;
        d(i13 == -1);
        return i13;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.f16266c = this.f16267d;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j11) throws IOException {
        long jSkip = super.skip(j11);
        if (this.f16265b && jSkip > 0) {
            this.f16266c += jSkip;
            d(false);
        }
        return jSkip;
    }
}
