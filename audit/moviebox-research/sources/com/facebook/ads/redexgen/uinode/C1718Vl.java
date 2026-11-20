package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1718Vl implements InterfaceC1344Gs {
    public long A00;
    public long A01;
    public C1350Gy A02;
    public I6 A03;
    public File A04;
    public FileOutputStream A05;
    public OutputStream A06;
    public final int A07;
    public final long A08;
    public final HK A09;
    public final boolean A0A;

    public C1718Vl(HK hk2, long j11) {
        this(hk2, j11, CacheDataSink.DEFAULT_BUFFER_SIZE, true);
    }

    public C1718Vl(HK hk2, long j11, int i11, boolean z11) {
        this.A09 = (HK) AbstractC1351Ha.A01(hk2);
        this.A08 = j11;
        this.A07 = i11;
        this.A0A = z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A00() throws IOException {
        OutputStream outputStream = this.A06;
        if (outputStream == null) {
            return;
        }
        boolean z11 = false;
        try {
            outputStream.flush();
            if (this.A0A) {
                this.A05.getFD().sync();
            }
            boolean z12 = true;
            Object[] objArr = objArr == true ? 1 : 0;
        } finally {
            IF.A0X(this.A06);
            this.A06 = null;
            File file = this.A04;
            this.A04 = null;
            if (z11) {
                this.A09.A4N(file);
            } else {
                file.delete();
            }
        }
    }

    private void A01() throws IOException {
        this.A04 = this.A09.AGT(this.A02.A05, this.A00 + this.A02.A01, this.A02.A02 == -1 ? this.A08 : Math.min(this.A02.A02 - this.A00, this.A08));
        FileOutputStream fileOutputStream = new FileOutputStream(this.A04);
        this.A05 = fileOutputStream;
        if (this.A07 > 0) {
            I6 i11 = this.A03;
            if (i11 == null) {
                this.A03 = new I6(this.A05, this.A07);
            } else {
                i11.A00(fileOutputStream);
            }
            this.A06 = this.A03;
        } else {
            this.A06 = fileOutputStream;
        }
        this.A01 = 0L;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1344Gs
    public final void ADn(C1350Gy c1350Gy) throws C1719Vm {
        if (c1350Gy.A02 == -1 && !c1350Gy.A02(2)) {
            this.A02 = null;
            return;
        }
        this.A02 = c1350Gy;
        this.A00 = 0L;
        try {
            A01();
        } catch (IOException e11) {
            throw new C1719Vm(e11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1344Gs
    public final void close() throws C1719Vm {
        if (this.A02 == null) {
            return;
        }
        try {
            A00();
        } catch (IOException e11) {
            throw new C1719Vm(e11);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1344Gs
    public final void write(byte[] bArr, int i11, int i12) throws C1719Vm {
        if (this.A02 == null) {
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            try {
                if (this.A01 == this.A08) {
                    A00();
                    A01();
                }
                int iMin = (int) Math.min(i12 - i13, this.A08 - this.A01);
                this.A06.write(bArr, i11 + i13, iMin);
                i13 += iMin;
                this.A01 += (long) iMin;
                this.A00 += (long) iMin;
            } catch (IOException e11) {
                throw new C1719Vm(e11);
            }
        }
    }
}
