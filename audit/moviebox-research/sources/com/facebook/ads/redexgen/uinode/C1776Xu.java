package com.facebook.ads.redexgen.uinode;

import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1776Xu implements InterfaceC1190Ab {
    public static String[] A0E = {"fmVPqkFD1cgVEf5yEceID3qk2mv0y9jV", "b0qKN8vCZijgotAYoetPmKMmgBOh17e", "g7TZXYRzX5Z2yGc3Q7ZfgtgqT", "qnhKgbP1LxOTukF1AVGitzUWI170z7Sc", "gLdsa9A", "GaZA", "7VW9", "auyYkXCiGRTQJpd2YduJgHCR"};
    public int A00;
    public int A02;
    public int A03;
    public int A05;
    public long A06;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public ByteBuffer A07 = InterfaceC1190Ab.A00;
    public ByteBuffer A08 = InterfaceC1190Ab.A00;
    public int A01 = -1;
    public int A04 = -1;
    public byte[] A0C = new byte[0];
    public byte[] A0D = new byte[0];

    private int A00(long j11) {
        return (int) ((((long) this.A04) * j11) / 1000000);
    }

    private int A01(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (Math.abs((int) byteBuffer.get(iLimit)) > 4) {
                int i11 = this.A00;
                int i12 = ((iLimit / i11) * i11) + i11;
                String[] strArr = A0E;
                if (strArr[4].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0E;
                strArr2[4] = "SOTn58r";
                strArr2[1] = "mEuLJiBevsWuJD71nrz4KbfWqLj7leU";
                return i12;
            }
        }
        return byteBuffer.position();
    }

    private int A02(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.get(iPosition)) > 4) {
                int i11 = this.A00;
                return i11 * (iPosition / i11);
            }
        }
        return byteBuffer.limit();
    }

    private void A03(int i11) {
        if (this.A07.capacity() < i11) {
            this.A07 = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
        } else {
            this.A07.clear();
        }
        if (i11 > 0) {
            this.A0A = true;
        }
    }

    private void A04(ByteBuffer byteBuffer) {
        A03(byteBuffer.remaining());
        this.A07.put(byteBuffer);
        this.A07.flip();
        this.A08 = this.A07;
    }

    private void A05(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iA02 = A02(byteBuffer);
        int iPosition = iA02 - byteBuffer.position();
        byte[] bArr = this.A0C;
        int length = bArr.length;
        int i11 = this.A02;
        int i12 = length - i11;
        if (iA02 < iLimit && iPosition < i12) {
            A09(bArr, i11);
            this.A02 = 0;
            String[] strArr = A0E;
            if (strArr[7].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[7] = "O6VD7siumNrk7CVoottqf9Wd";
            strArr2[2] = "eko4kK9cp1fEhg6H4c3WRP0k0";
            this.A05 = 0;
            return;
        }
        int iMin = Math.min(iPosition, i12);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.A0C, this.A02, iMin);
        int i13 = this.A02 + iMin;
        this.A02 = i13;
        byte[] bArr2 = this.A0C;
        if (i13 == bArr2.length) {
            if (this.A0A) {
                A09(bArr2, this.A03);
                this.A06 += (long) ((this.A02 - (this.A03 * 2)) / this.A00);
            } else {
                this.A06 += (long) ((i13 - this.A03) / this.A00);
            }
            A08(byteBuffer, this.A0C, this.A02);
            this.A02 = 0;
            this.A05 = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void A06(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.A0C.length));
        int iA01 = A01(byteBuffer);
        if (iA01 == byteBuffer.position()) {
            this.A05 = 1;
        } else {
            byteBuffer.limit(iA01);
            A04(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void A07(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iA02 = A02(byteBuffer);
        byteBuffer.limit(iA02);
        this.A06 += (long) (byteBuffer.remaining() / this.A00);
        A08(byteBuffer, this.A0D, this.A03);
        if (iA02 < iLimit) {
            A09(this.A0D, this.A03);
            this.A05 = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void A08(ByteBuffer byteBuffer, byte[] bArr, int i11) {
        int iMin = Math.min(byteBuffer.remaining(), this.A03);
        int i12 = this.A03 - iMin;
        System.arraycopy(bArr, i11 - i12, this.A0D, 0, i12);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.A0D, i12, iMin);
    }

    private void A09(byte[] bArr, int i11) {
        A03(i11);
        this.A07.put(bArr, 0, i11);
        this.A07.flip();
        this.A08 = this.A07;
    }

    public final long A0A() {
        return this.A06;
    }

    public final void A0B(boolean z11) {
        this.A09 = z11;
        flush();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A4Q(int i11, int i12, int i13) throws C1189Aa {
        if (i13 != 2) {
            throw new C1189Aa(i11, i12, i13);
        }
        if (this.A04 == i11 && this.A01 == i12) {
            return false;
        }
        this.A04 = i11;
        this.A01 = i12;
        this.A00 = i12 * 2;
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final ByteBuffer A7W() {
        ByteBuffer byteBuffer = this.A08;
        this.A08 = InterfaceC1190Ab.A00;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7X() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Y() {
        return 2;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final int A7Z() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A8w() {
        return this.A04 != -1 && this.A09;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final boolean A91() {
        return this.A0B && this.A08 == InterfaceC1190Ab.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEE() {
        this.A0B = true;
        int i11 = this.A02;
        if (i11 > 0) {
            A09(this.A0C, i11);
        }
        if (this.A0A) {
            return;
        }
        long j11 = this.A06;
        int i12 = this.A03 / this.A00;
        String[] strArr = A0E;
        if (strArr[5].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[0] = "We9PvBsbdasK7tn9VyyhVUkeOk007ymd";
        strArr2[3] = "bdBvwmZlOtVUMyUHuHiUMKijb9L0xmkD";
        this.A06 = j11 + ((long) i12);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void AEF(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.A08.hasRemaining()) {
            switch (this.A05) {
                case 0:
                    A06(byteBuffer);
                    break;
                case 1:
                    A05(byteBuffer);
                    break;
                case 2:
                    A07(byteBuffer);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void flush() {
        if (A8w()) {
            int iA00 = A00(150000L) * this.A00;
            if (this.A0C.length != iA00) {
                this.A0C = new byte[iA00];
            }
            int iA01 = A00(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) * this.A00;
            this.A03 = iA01;
            if (this.A0D.length != iA01) {
                this.A0D = new byte[iA01];
            }
        }
        this.A05 = 0;
        this.A08 = InterfaceC1190Ab.A00;
        this.A0B = false;
        this.A06 = 0L;
        this.A02 = 0;
        this.A0A = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1190Ab
    public final void reset() {
        this.A09 = false;
        flush();
        this.A07 = InterfaceC1190Ab.A00;
        this.A01 = -1;
        this.A04 = -1;
        this.A03 = 0;
        this.A0C = new byte[0];
        this.A0D = new byte[0];
    }
}
