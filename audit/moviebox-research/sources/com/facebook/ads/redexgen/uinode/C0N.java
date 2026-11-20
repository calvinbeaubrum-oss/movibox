package com.facebook.ads.redexgen.uinode;

import com.google.android.gms.common.api.Api;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0N extends BufferedInputStream {
    public int A00;
    public int A01;
    public boolean A02;

    public C0N(InputStream inputStream) {
        super(inputStream);
        this.A00 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean A00() {
        return this.A02;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i11) {
        this.A00 = i11;
        super.mark(i11);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i11 = this.A01;
        if (i11 + 1 > this.A00) {
            this.A02 = true;
            return -1;
        }
        this.A01 = i11 + 1;
        return super.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        if (this.A01 + bArr.length <= this.A00) {
            return super.read(bArr);
        }
        this.A02 = true;
        return -1;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.A01 + i12 > this.A00) {
            this.A02 = true;
            return -1;
        }
        int i13 = super.read(bArr, i11, i12);
        this.A01 += i13;
        return i13;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.A00 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        super.reset();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j11) throws IOException {
        int i11 = this.A01;
        if (((long) i11) + j11 > this.A00) {
            this.A02 = true;
            return 0L;
        }
        this.A01 = (int) (((long) i11) + j11);
        return super.skip(j11);
    }
}
