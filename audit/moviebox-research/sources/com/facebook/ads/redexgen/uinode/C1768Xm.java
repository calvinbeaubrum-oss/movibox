package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1768Xm implements InterfaceC1236Bv {
    public static byte[] A06;
    public static final Constructor<? extends InterfaceC1233Bs> A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05 = 1;

    static {
        A01();
        Constructor<? extends InterfaceC1233Bs> constructor = null;
        try {
            constructor = Class.forName(A00(74, 59, 61)).asSubclass(InterfaceC1233Bs.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException unused) {
        } catch (Exception e11) {
            throw new RuntimeException(A00(0, 34, 105), e11);
        }
        A07 = constructor;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{38, 83, 83, 80, 83, 1, 74, 79, 84, 85, 66, 79, 85, 74, 66, 85, 74, 79, 72, 1, 39, 45, 34, 36, 1, 70, 89, 85, 70, 79, 84, 74, 80, 79, 42, 67, 58, 77, 69, 58, 56, 73, 58, 57, -11, 58, 71, 71, 68, 71, -11, 56, 71, 58, 54, 73, 62, 67, 60, -11, Ascii.ESC, 33, Ascii.SYN, Ascii.CAN, -11, 58, 77, 73, 71, 54, 56, 73, 68, 71, Ascii.CAN, 36, 34, -29, Ascii.ESC, Ascii.SYN, Ascii.CAN, Ascii.SUB, Ascii.ETB, 36, 36, 32, -29, Ascii.SYN, Ascii.EM, 40, -29, Ascii.RS, 35, 41, Ascii.SUB, 39, 35, Ascii.SYN, 33, -29, Ascii.SUB, 45, 36, 37, 33, Ascii.SYN, 46, Ascii.SUB, 39, -25, -29, Ascii.SUB, 45, 41, -29, Ascii.ESC, 33, Ascii.SYN, Ascii.CAN, -29, -5, 33, Ascii.SYN, Ascii.CAN, -6, 45, 41, 39, Ascii.SYN, Ascii.CAN, 41, 36, 39};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1236Bv
    public final synchronized InterfaceC1233Bs[] A4b() {
        InterfaceC1233Bs[] interfaceC1233BsArr;
        Constructor<? extends InterfaceC1233Bs> constructor = A07;
        interfaceC1233BsArr = new InterfaceC1233Bs[constructor == null ? 12 : 13];
        interfaceC1233BsArr[0] = new XX(this.A01);
        interfaceC1233BsArr[1] = new XN(this.A00);
        interfaceC1233BsArr[2] = new XL(this.A03);
        interfaceC1233BsArr[3] = new XU(this.A02);
        interfaceC1233BsArr[4] = new X7();
        interfaceC1233BsArr[5] = new XA();
        interfaceC1233BsArr[6] = new C1744Wo(this.A05, this.A04);
        interfaceC1233BsArr[7] = new C1760Xe();
        interfaceC1233BsArr[8] = new XF();
        interfaceC1233BsArr[9] = new C1750Wu();
        interfaceC1233BsArr[10] = new C1742Wm();
        interfaceC1233BsArr[11] = new C1763Xh();
        if (constructor != null) {
            try {
                interfaceC1233BsArr[12] = constructor.newInstance(new Object[0]);
            } catch (Exception e11) {
                throw new IllegalStateException(A00(34, 40, 93), e11);
            }
        }
        return interfaceC1233BsArr;
    }
}
