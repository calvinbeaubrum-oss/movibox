package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IH {
    public static byte[] A05;
    public static String[] A06 = {"BmLXPPjgF3W3yl6sHxYVjODx4Gc4ZSvN", "I4b0P0MoHEzHAP7yyYIBBQ151YdBHOwS", "TnUUZ2ELhZytD28RyaEX2mWW0X", "N95", "x88QxZ2XVEltUSPssGjwLeARzs7qYdf0", "T8gtGJunXdUSumjdX3X9mxIBVL", "lBAIpAErMYY7sFwVqjboSux", "Abd"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final List<byte[]> A04;

    static {
        A02();
    }

    public IH(List<byte[]> list, int i11, int i12, int i13, float f11) {
        this.A04 = list;
        this.A02 = i11;
        this.A03 = i12;
        this.A01 = i13;
        this.A00 = f11;
    }

    public static IH A00(C1376Hz c1376Hz) throws C11849v {
        try {
            c1376Hz.A0Z(4);
            int iA0E = (c1376Hz.A0E() & 3) + 1;
            if (iA0E == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iA0E2 = c1376Hz.A0E() & 31;
            for (int i11 = 0; i11 < iA0E2; i11++) {
                arrayList.add(A03(c1376Hz));
            }
            int iA0E3 = c1376Hz.A0E();
            for (int i12 = 0; i12 < iA0E3; i12++) {
                arrayList.add(A03(c1376Hz));
            }
            int i13 = -1;
            int i14 = -1;
            float f11 = 1.0f;
            if (iA0E2 > 0) {
                C1371Hu c1371HuA06 = AbstractC1372Hv.A06((byte[]) arrayList.get(0), iA0E, ((byte[]) arrayList.get(0)).length);
                i13 = c1371HuA06.A06;
                i14 = c1371HuA06.A02;
                f11 = c1371HuA06.A00;
            } else {
                String[] strArr = A06;
                if (strArr[3].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A06;
                strArr2[2] = "uBIRbiuvHYy0oHv2RJvgJqXQ4A";
                strArr2[5] = "sPpQgCzWXqIb9lVIC566YsDxxs";
            }
            return new IH(arrayList, iA0E, i13, i14, f11);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw new C11849v(A01(0, 24, 65), e11);
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-14, Ascii.US, Ascii.US, Ascii.FS, Ascii.US, -51, Ascii.GS, Ascii.SO, Ascii.US, 32, Ascii.SYN, Ascii.ESC, Ascii.DC4, -51, -18, 3, -16, -51, Ascii.DLE, Ascii.FS, Ascii.ESC, 19, Ascii.SYN, Ascii.DC4};
    }

    public static byte[] A03(C1376Hz c1376Hz) {
        int iA0I = c1376Hz.A0I();
        int iA06 = c1376Hz.A06();
        c1376Hz.A0Z(iA0I);
        return AbstractC1355He.A08(c1376Hz.A00, iA06, iA0I);
    }
}
