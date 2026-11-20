package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PF extends InputStream {
    public int A00;
    public long A01;
    public InterfaceC1346Gu A02;
    public final Uri A03;
    public final C1794Ym A04;
    public final InterfaceC1345Gt A05;
    public final String A06;

    public PF(C1794Ym c1794Ym, Uri uri, InterfaceC1345Gt interfaceC1345Gt) throws IOException {
        this.A04 = c1794Ym;
        this.A05 = interfaceC1345Gt;
        this.A03 = uri;
        this.A06 = R0.A08(c1794Ym, uri);
        A00(0);
    }

    private void A00(int i11) throws IOException {
        InterfaceC1346Gu interfaceC1346Gu = this.A02;
        if (interfaceC1346Gu != null) {
            interfaceC1346Gu.close();
        }
        this.A02 = this.A05.A4X();
        this.A01 = (int) this.A02.ADl(new C1350Gy(this.A03, i11, -1L, this.A06));
    }

    @Override // java.io.InputStream
    public final int available() {
        return ((int) this.A01) - this.A00;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        return read(new byte[1]);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.A02.read(bArr, i11, i12);
        this.A00 += i13;
        return i13;
    }

    @Override // java.io.InputStream
    public final long skip(long j11) throws IOException {
        long j12 = this.A01;
        int i11 = this.A00;
        long j13 = j12 - ((long) i11);
        if (j13 <= 0) {
            return 0L;
        }
        if (j11 > j13) {
            j11 = j13;
        }
        int i12 = (int) (((long) i11) + j11);
        this.A00 = i12;
        A00(i12);
        return j11;
    }
}
