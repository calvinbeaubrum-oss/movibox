package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.gslb.Worker;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1763Xh implements InterfaceC1233Bs {
    public static byte[] A07;
    public static String[] A08 = {"ovn62aUcwqSIvWTqoELg4J4D8wHkUDmq", "Ycr5XQrqBi4bqXq", "xp8qJzBZ1bRZYruPJEcRAHgYPTR5RYjX", "i3q4o3QoTWkNmhcyfYOgrV6edePVNuRX", "3foLzBlJQPuSe9je9cnopJfCpNuQ", "jIofLs5qujimwrYxWQlB52zkZNTbvGhY", "Oin2hfMzoDcJa9P29jyigMxfd8hffyV", "DiUz7SyfwAQ"};
    public static final InterfaceC1236Bv A09;
    public static final int A0A;
    public static final byte[] A0B;
    public static final byte[] A0C;
    public static final int[] A0D;
    public static final int[] A0E;
    public int A00;
    public int A01;
    public long A02;
    public C4 A03;
    public boolean A04;
    public boolean A05;
    public final byte[] A06 = new byte[1];

    static {
        A05();
        A09 = new C1764Xi();
        A0D = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        A0E = iArr;
        A0B = IF.A0i(A03(12, 6, 52));
        A0C = IF.A0i(A03(18, 9, 100));
        A0A = iArr[8];
    }

    private int A00(int i11) throws C11849v {
        String strA03;
        if (!A07(i11)) {
            StringBuilder sbAppend = new StringBuilder().append(A03(53, 12, 116));
            if (!this.A05) {
                strA03 = A03(Worker.WHAT_SYNC_DATA, 2, 21);
            } else if (A08[6].length() == 31) {
                A08[7] = "wEjTIiVmShi";
                strA03 = A03(105, 2, 31);
            }
            throw new C11849v(sbAppend.append(strA03).append(A03(0, 12, 31)).append(i11).toString());
        }
        if (this.A05) {
            return A0E[i11];
        }
        int[] iArr = A0D;
        if (A08[6].length() == 31) {
            String[] strArr = A08;
            strArr[4] = "W5GqdpRCUv4UTAd2FZcqfYNQbOUH";
            strArr[1] = "vSYrWd8JkI4l23w";
            return iArr[i11];
        }
        throw new RuntimeException();
    }

    private int A01(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.AFM();
        interfaceC1234Bt.ADv(this.A06, 0, 1);
        byte b11 = this.A06[0];
        if ((b11 & 131) <= 0) {
            return A00((b11 >> 3) & 15);
        }
        throw new C11849v(A03(65, 38, 115) + ((int) b11));
    }

    private int A02(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            try {
                int iA01 = A01(interfaceC1234Bt);
                this.A01 = iA01;
                this.A00 = iA01;
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iAFQ = this.A03.AFQ(interfaceC1234Bt, this.A00, true);
        if (iAFQ == -1) {
            return -1;
        }
        int i11 = this.A00 - iAFQ;
        this.A00 = i11;
        if (i11 > 0) {
            return 0;
        }
        this.A03.AFS(this.A02, 1, this.A01, 0, null);
        this.A02 += DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT;
        return 0;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = (byte) ((bArrCopyOfRange[i14] - i13) - 104);
            String[] strArr = A08;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A08[7] = "o17bMTHd2bo";
            bArrCopyOfRange[i14] = b11;
        }
        return new String(bArrCopyOfRange);
    }

    private void A04() {
        if (this.A04) {
            return;
        }
        this.A04 = true;
        boolean z11 = this.A05;
        this.A03.A5n(Format.A06(null, z11 ? A03(117, 12, 52) : A03(107, 10, 122), null, -1, A0A, 1, z11 ? 16000 : 8000, -1, null, null, 0, null));
    }

    public static void A05() {
        byte[] bArr = {-89, -19, -7, -24, -12, -20, -89, -5, 0, -9, -20, -89, -65, -67, -35, -23, -18, -90, -17, -19, Ascii.CR, Ascii.EM, Ascii.RS, -7, 35, Ascii.SO, -42, Ascii.SO, 58, 64, 55, 47, -21, 57, 58, Utf8.REPLACEMENT_BYTE, -21, 49, 52, 57, 47, -21, Ascii.FF, Ascii.CAN, Ascii.GS, -21, 51, 48, 44, 47, 48, 61, -7, 37, 72, 72, 65, 67, 61, 72, -4, Ascii.GS, 41, 46, -4, 36, 73, 81, 60, 71, 68, Utf8.REPLACEMENT_BYTE, -5, 75, 60, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 68, 73, 66, -5, 61, 68, 79, 78, -5, 65, 74, 77, -5, 65, 77, 60, 72, 64, -5, 67, 64, 60, Utf8.REPLACEMENT_BYTE, 64, 77, -5, -53, -65, -34, -55, 67, 87, 70, 75, 81, 17, Ascii.NAK, 73, 82, 82, -3, 17, 0, 5, Ascii.VT, -53, -3, 9, Ascii.SO, -55, 19, -2};
        if (A08[6].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "iWdi7SFZoODeZbEJMl3L6ntPbKeDMNvO";
        strArr[2] = "0wFRuzGYIju4XbKNAoPYNxHAh615x32s";
        A07 = bArr;
    }

    private boolean A06(int i11) {
        return !this.A05 && (i11 < 12 || i11 > 14);
    }

    private boolean A07(int i11) {
        return i11 >= 0 && i11 <= 15 && (A08(i11) || A06(i11));
    }

    private boolean A08(int i11) {
        if (this.A05) {
            if (i11 >= 10) {
                if (A08[6].length() != 31) {
                    throw new RuntimeException();
                }
                A08[5] = "qMGeUOCLNxoOBJxwE1u31s5i7NTepy4l";
                if (i11 > 13) {
                }
            }
            return true;
        }
        return false;
    }

    private boolean A09(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        byte[] bArr = A0B;
        if (A0A(interfaceC1234Bt, bArr)) {
            this.A05 = false;
            interfaceC1234Bt.AGP(bArr.length);
            return true;
        }
        byte[] bArr2 = A0C;
        if (!A0A(interfaceC1234Bt, bArr2)) {
            return false;
        }
        this.A05 = true;
        interfaceC1234Bt.AGP(bArr2.length);
        return true;
    }

    private boolean A0A(InterfaceC1234Bt interfaceC1234Bt, byte[] bArr) throws InterruptedException, IOException {
        interfaceC1234Bt.AFM();
        byte[] bArr2 = new byte[bArr.length];
        interfaceC1234Bt.ADv(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        interfaceC1235Bu.AFi(new C1765Xj(C.TIME_UNSET));
        this.A03 = interfaceC1235Bu.AGi(0, 1);
        interfaceC1235Bu.A5Y();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        if (interfaceC1234Bt.A7i() == 0 && !A09(interfaceC1234Bt)) {
            throw new C11849v(A03(27, 26, 99));
        }
        A04();
        return A02(interfaceC1234Bt);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A02 = 0L;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return A09(interfaceC1234Bt);
    }
}
