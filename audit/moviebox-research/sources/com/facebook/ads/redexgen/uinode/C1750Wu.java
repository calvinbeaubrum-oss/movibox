package com.facebook.ads.redexgen.uinode;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1750Wu implements InterfaceC1233Bs {
    public static String[] A08 = {"pV6afMZIVEGTOqSkK4PJAxqV3cRTXe0d", "IAHwWl6p9dkO64XBfZ0QYdoG1FARrH3l", "8O8qDLmpQAmlCV9yXa4a4pqjSYQFT4zH", "zdF1gQZIlZar6BQddk1LhfG9pE3e2nBq", "3CFwU8lFm", "v9T9Lg78nTaSAiVLG9Jw7rJGA2UCfL0z", "6lAaLpwrnWkg", "Pzi"};
    public static final InterfaceC1236Bv A09 = new C1751Wv();
    public long A00;
    public InterfaceC1235Bu A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;
    public final SparseArray<D5> A05;
    public final C1376Hz A06;
    public final IB A07;

    public C1750Wu() {
        this(new IB(0L));
    }

    public C1750Wu(IB ib2) {
        this.A07 = ib2;
        this.A06 = new C1376Hz(4096);
        this.A05 = new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A01 = interfaceC1235Bu;
        interfaceC1235Bu.AFi(new C1765Xj(C.TIME_UNSET));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        if (!interfaceC1234Bt.ADw(this.A06.A00, 0, 4, true)) {
            return -1;
        }
        this.A06.A0Y(0);
        int iA08 = this.A06.A08();
        if (iA08 == 441) {
            return -1;
        }
        if (iA08 == 442) {
            interfaceC1234Bt.ADv(this.A06.A00, 0, 10);
            this.A06.A0Y(9);
            interfaceC1234Bt.AGP((this.A06.A0E() & 7) + 14);
            return 0;
        }
        if (iA08 != 443) {
            if (((iA08 & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
                interfaceC1234Bt.AGP(1);
                return 0;
            }
            int i11 = iA08 & 255;
            D5 d11 = this.A05.get(i11);
            if (!this.A02) {
                if (d11 == null) {
                    InterfaceC1259Cy x11 = null;
                    if (i11 == 189) {
                        x11 = new X9();
                        this.A03 = true;
                        this.A00 = interfaceC1234Bt.A7i();
                    } else if ((i11 & 224) == 192) {
                        x11 = new C1753Wx();
                        this.A03 = true;
                        this.A00 = interfaceC1234Bt.A7i();
                    } else if ((i11 & 240) == 224) {
                        x11 = new X2();
                        this.A04 = true;
                        this.A00 = interfaceC1234Bt.A7i();
                    }
                    if (x11 != null) {
                        x11.A4p(this.A01, new DC(i11, 256));
                        d11 = new D5(x11, this.A07);
                        this.A05.put(i11, d11);
                    }
                }
                if (interfaceC1234Bt.A7i() > ((this.A03 && this.A04) ? this.A00 + PlaybackStateCompat.ACTION_PLAY_FROM_URI : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    this.A02 = true;
                    InterfaceC1235Bu interfaceC1235Bu = this.A01;
                    if (A08[6].length() != 7) {
                        A08[4] = "xdmI1xGjCkbROfx6HlMFi8Q1HtnAUXbK";
                        interfaceC1235Bu.A5Y();
                    }
                }
            }
            interfaceC1234Bt.ADv(this.A06.A00, 0, 2);
            this.A06.A0Y(0);
            int iA0I = this.A06.A0I() + 6;
            if (d11 == null) {
                interfaceC1234Bt.AGP(iA0I);
            } else {
                this.A06.A0W(iA0I);
                interfaceC1234Bt.readFully(this.A06.A00, 0, iA0I);
                this.A06.A0Y(6);
                d11.A03(this.A06);
                C1376Hz c1376Hz = this.A06;
                c1376Hz.A0X(c1376Hz.A05());
            }
            return 0;
        }
        interfaceC1234Bt.ADv(this.A06.A00, 0, 2);
        this.A06.A0Y(0);
        int iA0I2 = this.A06.A0I() + 6;
        if (A08[7].length() != 22) {
            String[] strArr = A08;
            strArr[5] = "HKquBkRqV5bg6e7zOk5qC1bF2o25gd0c";
            strArr[0] = "faW9VDigV6ilhrF8PW3drZ4wwMfODA0N";
            interfaceC1234Bt.AGP(iA0I2);
            return 0;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A07.A08();
        for (int i11 = 0; i11 < this.A05.size(); i11++) {
            this.A05.valueAt(i11).A02();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        byte[] bArr = new byte[14];
        interfaceC1234Bt.ADv(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4) {
            return false;
        }
        int i11 = bArr[8] & 4;
        if (A08[4].length() != 31) {
            A08[6] = "Yb1F33WkxQfWiaSVh137";
            if (i11 != 4) {
                return false;
            }
            String[] strArr = A08;
            if (strArr[5].charAt(30) == strArr[0].charAt(30)) {
                String[] strArr2 = A08;
                strArr2[2] = "0jRSG84WTzZndWahG37MGXBabYk0DmjV";
                strArr2[3] = "QaZZpRdUVGXpS1N3yC2DPVE3W204sMee";
                if ((bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
                    return false;
                }
                interfaceC1234Bt.A3W(bArr[13] & 7);
                interfaceC1234Bt.ADv(bArr, 0, 3);
                return 1 == ((bArr[2] & 255) | (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)));
            }
        }
        throw new RuntimeException();
    }
}
