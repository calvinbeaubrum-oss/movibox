package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YL implements InterfaceC11247h {
    public static YL A07;
    public static byte[] A08;
    public static String[] A09 = {"kZNWMB05A80rolZkZr5gINRkemJedumA", "PGnlsDLswmZGHAGkHnqyou4j", "CQczeQcoxNMNqPeDO5UPH4delPie3CF6", "Ozs7AQnIuhnl4TF488yhCLnc3lqg3Tqv", "QUMQF15y8F49TOv2Mbtf3pi6YRJU7tsl", "iRM3Hx3PCEqf", "8yEJzjy1AvS4vnL", "zEXAgd0MZ6iopjt"};
    public C0W A00;
    public InterfaceC11046g A01;
    public C7g A02;
    public InterfaceC11357w A03;
    public C11418c A04;
    public JE A05;
    public InterfaceC1360Hj A06;

    static {
        A07();
    }

    public static AnonymousClass66 A00(C1794Ym c1794Ym, InterfaceC1360Hj interfaceC1360Hj) {
        if (!C1384Ih.A1P(c1794Ym) || interfaceC1360Hj == null) {
            return null;
        }
        return AnonymousClass67.A00().A00(interfaceC1360Hj);
    }

    public static InterfaceC11357w A01(C1794Ym c1794Ym) {
        return AbstractC11367x.A00().A00(c1794Ym, new YS());
    }

    public static synchronized YL A02() {
        if (A07 == null) {
            A07 = new YL();
        }
        return A07;
    }

    public static RK A03(C1794Ym c1794Ym) {
        if (C1384Ih.A1L(c1794Ym)) {
            return C1606Rc.A01(c1794Ym);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final synchronized InterfaceC1360Hj A86() {
        return this.A06;
    }

    public static InterfaceC1360Hj A05(C1794Ym c1794Ym, InterfaceC11357w interfaceC11357w, RK rk2) {
        if (!C1384Ih.A2E(c1794Ym) || rk2 == null || ProcessUtils.isRemoteRenderingProcess()) {
            return null;
        }
        return AbstractC1629Rz.A00().A00(c1794Ym, interfaceC11357w, rk2, K9.A04(c1794Ym), new YM(new K1(c1794Ym, A06(0, 0, 122), null, EnumC1405Jg.A07, 0, new C1410Jl(), LW.A01(C1384Ih.A0J(c1794Ym)), null, null, new C1866aZ()), c1794Ym), C1627Rx.A00().A00());
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A09;
            if (strArr[6].length() != strArr[7].length()) {
                break;
            }
            String[] strArr2 = A09;
            strArr2[6] = "Hv2WK1fJh7GnXaP";
            strArr2[7] = "jwUFRNkRPBL5IaL";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            int i15 = bArrCopyOfRange[i14] - i13;
            String[] strArr3 = A09;
            if (strArr3[4].charAt(26) != strArr3[0].charAt(26)) {
                break;
            }
            String[] strArr4 = A09;
            strArr4[2] = "3jbuj6iR6sIerVLqEJ9xAsC0KuP7QrbG";
            strArr4[3] = "qsuffxm3RCjhy50iWQEl04Txy4tWGAPw";
            bArrCopyOfRange[i14] = (byte) (i15 - 98);
            i14++;
        }
        throw new RuntimeException();
    }

    public static void A07() {
        A08 = new byte[]{-62, -11, -55, -10, -13, -62, -63, -62, -16, 2, Ascii.DLE, Ascii.DLE, 6, Ascii.FF, Ascii.VT, -67, 1, -2, 17, -2, -67, 6, Ascii.VT, 6, 17, 6, -2, 9, 6, Ascii.ETB, 2, 1, 33, Ascii.DC4, Ascii.US, Ascii.RS, 33, 35, 2, Ascii.DC4, 34, 34, Ascii.CAN, Ascii.RS, Ascii.GS, -13, Ascii.DLE, 35, Ascii.DLE, -8, Ascii.GS, Ascii.CAN, 35, Ascii.CAN, Ascii.DLE, Ascii.ESC, Ascii.CAN, 41, Ascii.DC4, 19};
        if (A09[1].length() == 32) {
            throw new RuntimeException();
        }
        String[] strArr = A09;
        strArr[2] = "XQj6tBQR93KUWcmqG7acynHpkyXbPHo4";
        strArr[3] = "0fPU7ngiro1m2vFzwgFa3cBnolZ3o5pA";
    }

    public static void A08() {
        String strA06 = A06(8, 24, 59);
        if (A09[5].length() == 20) {
            throw new RuntimeException();
        }
        A09[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
        AbstractC1414Jp.A05(A06(32, 28, 77), strA06, A06(0, 8, 46));
    }

    public static void A09(C1794Ym c1794Ym, AnonymousClass66 anonymousClass66) {
        if (!C1384Ih.A1P(c1794Ym) || anonymousClass66 == null) {
            return;
        }
        AnonymousClass64.A00().A00(anonymousClass66, c1794Ym);
    }

    public static void A0A(C1794Ym c1794Ym, InterfaceC1360Hj interfaceC1360Hj) {
        if (!C1384Ih.A0h(c1794Ym) || interfaceC1360Hj == null) {
            return;
        }
        new C6R(c1794Ym, interfaceC1360Hj, new C6S(), DynamicLoaderImpl.getBidderTokenProviderApi().A00());
    }

    public static void A0B(C1794Ym c1794Ym, InterfaceC1360Hj interfaceC1360Hj) {
        if (interfaceC1360Hj == null) {
            return;
        }
        AbstractC1387Il.A00(c1794Ym, interfaceC1360Hj);
    }

    public final synchronized void A0C(C1794Ym c1794Ym) {
        if (this.A06 != null) {
            return;
        }
        this.A03 = A01(c1794Ym);
        InterfaceC1360Hj interfaceC1360HjA05 = A05(c1794Ym, this.A03, A03(c1794Ym));
        this.A06 = interfaceC1360HjA05;
        A09(c1794Ym, A00(c1794Ym, interfaceC1360HjA05));
        A0A(c1794Ym, this.A06);
        A0B(c1794Ym, this.A06);
        InterfaceC1360Hj interfaceC1360Hj = this.A06;
        if (interfaceC1360Hj != null) {
            interfaceC1360Hj.A5m();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final J2 A5u(C1794Ym c1794Ym) {
        return VQ.A01(c1794Ym);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized C7g A6A(C11237f c11237f) {
        if (this.A02 == null) {
            this.A02 = new YN(this);
        }
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized InterfaceC11046g A6L() {
        if (this.A01 == null) {
            this.A01 = new C1796Yo();
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized InterfaceC11357w A6j(C11237f c11237f) {
        if (this.A03 == null) {
            this.A03 = A01(c11237f.A01());
        }
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized AnonymousClass89 A6l(C11237f c11237f) {
        return new C1783Yb(c11237f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized InterfaceC11257i A6v(C11237f c11237f) {
        return new EO(this, c11237f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized C0W A77(C11237f c11237f) {
        if (!C1384Ih.A0v(c11237f)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = C0X.A00().A00(new YQ(c11237f));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized C7k A7q(C11237f c11237f) {
        return new YO(c11237f);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final C1794Ym A7r(Context context) {
        C1794Ym c1794YmA00 = AbstractC11227e.A00();
        if (c1794YmA00 != null) {
            return c1794YmA00;
        }
        C1794Ym c1794Ym = new C1794Ym(context, this);
        AbstractC11227e.A01(c1794Ym);
        return c1794Ym;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized JE A7s(C1794Ym c1794Ym) {
        if (this.A05 == null) {
            this.A05 = new VY(c1794Ym);
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11247h
    public final synchronized C11418c A7y() {
        if (this.A04 == null) {
            this.A04 = new C11418c();
            A08();
        }
        return this.A04;
    }
}
