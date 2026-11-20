package com.facebook.ads.redexgen.uinode;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X7 implements InterfaceC1233Bs {
    public static byte[] A04;
    public static String[] A05 = {"zdP8mq1V4qx9ZCdsfAD4NG7cLFVpQAAe", "koAkuIv", "fyRTvmHGGGsRl9BV6D3JToZwd0QymLEV", "Ol6FmQC", "pWzJ4KWOtVeOprDRKRooJjLfCIz1i7Yl", "FaGWZpOEFJ3DEiDU22ljd64Ld5pUV9HD", "txEKQBUTk3v9kOkzxdvVTnLo1IME9gDG", "VQ1knBpCfCAoSCLl3kVfN2N5wBdN5LBp"};
    public static final InterfaceC1236Bv A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final X6 A02;
    public final C1376Hz A03;

    static {
        A01();
        A06 = new X8();
        A07 = IF.A08(A00(0, 3, 72));
    }

    public X7() {
        this(0L);
    }

    public X7(long j11) {
        this.A01 = j11;
        this.A02 = new X6(true);
        this.A03 = new C1376Hz(200);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A05;
            if (strArr[2].charAt(21) == strArr[4].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "6nR4pRT1Z5KTQHbqvhpghrBhlvQkSoKV";
            strArr2[5] = "SkXTa4uQceGhkSQtr6wVij7rDC15CMq5";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 67);
            i14++;
        }
    }

    public static void A01() {
        A04 = new byte[]{66, 79, 56};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A02.A4p(interfaceC1235Bu, new DC(0, 1));
        interfaceC1235Bu.A5Y();
        interfaceC1235Bu.AFi(new C1765Xj(C.TIME_UNSET));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        int i11 = interfaceC1234Bt.read(this.A03.A00, 0, 200);
        if (i11 == -1) {
            return -1;
        }
        this.A03.A0Y(0);
        this.A03.A0X(i11);
        if (!this.A00) {
            this.A02.ADt(this.A01, true);
            this.A00 = true;
        }
        this.A02.A4R(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A00 = false;
        this.A02.AFg();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        C1376Hz c1376Hz = new C1376Hz(10);
        C1375Hy c1375Hy = new C1375Hy(c1376Hz.A00);
        int i11 = 0;
        while (true) {
            interfaceC1234Bt.ADv(c1376Hz.A00, 0, 10);
            c1376Hz.A0Y(0);
            if (c1376Hz.A0G() != A07) {
                break;
            }
            c1376Hz.A0Z(3);
            int iA0D = c1376Hz.A0D();
            i11 += iA0D + 10;
            interfaceC1234Bt.A3W(iA0D);
        }
        interfaceC1234Bt.AFM();
        interfaceC1234Bt.A3W(i11);
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            interfaceC1234Bt.ADv(c1376Hz.A00, 0, 2);
            c1376Hz.A0Y(0);
            if ((65526 & c1376Hz.A0I()) != 65520) {
                i14 = 0;
                i13 = 0;
                interfaceC1234Bt.AFM();
                i12++;
                if (i12 - i11 >= 8192) {
                    return false;
                }
                interfaceC1234Bt.A3W(i12);
            } else {
                i14++;
                if (i14 >= 4 && i13 > 188) {
                    return true;
                }
                interfaceC1234Bt.ADv(c1376Hz.A00, 0, 4);
                c1375Hy.A07(14);
                int iA04 = c1375Hy.A04(13);
                if (iA04 <= 6) {
                    return false;
                }
                interfaceC1234Bt.A3W(iA04 - 6);
                i13 += iA04;
            }
        }
    }
}
