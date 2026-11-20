package com.facebook.ads.redexgen.uinode;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1775Xt implements InterfaceC1190Ab {
    public static String[] A0D = {"pWxjFsNDaGkCJOJIXf3nBpXapJRDFAns", "UkLwcPvzhTn0p2HYHg4j6N15VQJC2l4J", "YJRY7F74jhCJ9GxMtbKfeDIDzZlQRHvd", "", "", "sMHZoQnzt9jO1PxekMXjLs1IjEAfMk8v", "KagcOA94TBJJAh6RgnCdHwb09FdTTp2T", "s5OQD0o5JvIPNjQnPDHHdNmWUeQWTVLd"};
    public int A04;
    public long A06;
    public long A07;
    public B6 A08;
    public ByteBuffer A09;
    public ByteBuffer A0A;
    public ShortBuffer A0B;
    public boolean A0C;
    public float A01 = 1.0f;
    public float A00 = 1.0f;
    public int A02 = -1;
    public int A05 = -1;
    public int A03 = -1;

    public C1775Xt() {
        ByteBuffer byteBuffer = InterfaceC1190Ab.A00;
        this.A09 = byteBuffer;
        this.A0B = byteBuffer.asShortBuffer();
        this.A0A = InterfaceC1190Ab.A00;
        this.A04 = -1;
    }

    public final float A00(float f11) {
        float fA00 = IF.A00(f11, 0.1f, 8.0f);
        if (this.A00 != fA00) {
            this.A00 = fA00;
            this.A08 = null;
        }
        flush();
        return fA00;
    }

    public final float A01(float f11) {
        float fA00 = IF.A00(f11, 0.1f, 8.0f);
        if (this.A01 != fA00) {
            this.A01 = fA00;
            this.A08 = null;
        }
        flush();
        return fA00;
    }

    public final long A02(long j11) {
        long j12 = this.A07;
        if (j12 < 1024) {
            return (long) (((double) this.A01) * j11);
        }
        int i11 = this.A03;
        int i12 = this.A05;
        if (A0D[5].charAt(5) != 'Q') {
            throw new RuntimeException();
        }
        A0D[1] = "wo8T89BmhgCv6RPfRPDSoWflpmmFSmBw";
        return i11 == i12 ? IF.A0F(j11, this.A06, j12) : IF.A0F(j11, this.A06 * ((long) i11), j12 * ((long) i12));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A4Q(int i11, int i12, int i13) throws C1189Aa {
        if (i13 != 2) {
            throw new C1189Aa(i11, i12, i13);
        }
        int i14 = this.A04;
        if (i14 == -1) {
            i14 = i11;
        }
        if (this.A05 == i11 && this.A02 == i12 && this.A03 == i14) {
            return false;
        }
        this.A05 = i11;
        this.A02 = i12;
        this.A03 = i14;
        this.A08 = null;
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final ByteBuffer A7W() {
        ByteBuffer byteBuffer = this.A0A;
        this.A0A = InterfaceC1190Ab.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7X() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Y() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Z() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A8w() {
        return this.A05 != -1 && (Math.abs(this.A01 - 1.0f) >= 0.01f || Math.abs(this.A00 - 1.0f) >= 0.01f || this.A03 != this.A05);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A91() {
        B6 b11;
        return this.A0C && ((b11 = this.A08) == null || b11.A0H() == 0);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEE() {
        AbstractC1351Ha.A04(this.A08 != null);
        this.A08.A0J();
        this.A0C = true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEF(ByteBuffer byteBuffer) {
        AbstractC1351Ha.A04(this.A08 != null);
        boolean zHasRemaining = byteBuffer.hasRemaining();
        if (A0D[1].charAt(8) != 'h') {
            throw new RuntimeException();
        }
        A0D[0] = "CgSP7s2gOF1CWMy2qVo8ASfS0wZJy2y3";
        if (zHasRemaining) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.A06 += (long) iRemaining;
            this.A08.A0L(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iA0H = this.A08.A0H() * this.A02 * 2;
        if (iA0H > 0) {
            if (this.A09.capacity() < iA0H) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iA0H).order(ByteOrder.nativeOrder());
                this.A09 = byteBufferOrder;
                this.A0B = byteBufferOrder.asShortBuffer();
            } else {
                this.A09.clear();
                this.A0B.clear();
            }
            this.A08.A0K(this.A0B);
            this.A07 += (long) iA0H;
            this.A09.limit(iA0H);
            this.A0A = this.A09;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void flush() {
        if (A8w()) {
            B6 b11 = this.A08;
            if (b11 == null) {
                this.A08 = new B6(this.A05, this.A02, this.A01, this.A00, this.A03);
            } else {
                b11.A0I();
            }
        }
        this.A0A = InterfaceC1190Ab.A00;
        this.A06 = 0L;
        this.A07 = 0L;
        this.A0C = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void reset() {
        this.A01 = 1.0f;
        this.A00 = 1.0f;
        this.A02 = -1;
        this.A05 = -1;
        this.A03 = -1;
        ByteBuffer byteBuffer = InterfaceC1190Ab.A00;
        this.A09 = byteBuffer;
        this.A0B = byteBuffer.asShortBuffer();
        this.A0A = InterfaceC1190Ab.A00;
        this.A04 = -1;
        this.A08 = null;
        this.A06 = 0L;
        this.A07 = 0L;
        this.A0C = false;
    }
}
