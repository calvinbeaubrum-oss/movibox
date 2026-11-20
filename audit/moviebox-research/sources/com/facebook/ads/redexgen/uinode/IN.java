package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IN {
    public static byte[] A02;
    public static String[] A03 = {"ByJYsTLYuoR6uc8r", "JtyXwt9Aly6TcqGHtKIVJmBsk4OeLfoM", "a9HBAd1W81XiearAjjAT3V1ZsLEmO9Oi", "EXNlrjnsmLCbvnLTR5jNuRmyx9d0ZBX8", "CaQoJFxeqSTbWtIeh0kRdnuLPh9NlfCW", "NDFH7JBJhJBLaqfKHqozYt4fbxKVNhf7", "NTYlS1n6YEIgBX9wiCzSTuRNkv1W0ADe", "oBB1NAAyCwUYb6ONAQdFrjyju4xXh"};
    public final int A00;
    public final List<byte[]> A01;

    static {
        A02();
    }

    public IN(List<byte[]> list, int i11) {
        this.A01 = list;
        this.A00 = i11;
    }

    public static IN A00(C1376Hz c1376Hz) throws C11849v {
        try {
            c1376Hz.A0Z(21);
            int iA0E = c1376Hz.A0E() & 3;
            int iA0E2 = c1376Hz.A0E();
            int i11 = 0;
            int iA06 = c1376Hz.A06();
            for (int i12 = 0; i12 < iA0E2; i12++) {
                c1376Hz.A0Z(1);
                int iA0I = c1376Hz.A0I();
                for (int i13 = 0; i13 < iA0I; i13++) {
                    int iA0I2 = c1376Hz.A0I();
                    i11 += iA0I2 + 4;
                    c1376Hz.A0Z(iA0I2);
                }
            }
            c1376Hz.A0Y(iA06);
            byte[] bArr = new byte[i11];
            int i14 = 0;
            String[] strArr = A03;
            if (strArr[2].charAt(26) == strArr[4].charAt(26)) {
                throw new RuntimeException();
            }
            A03[7] = "2";
            for (int i15 = 0; i15 < iA0E2; i15++) {
                c1376Hz.A0Z(1);
                int iA0I3 = c1376Hz.A0I();
                for (int i16 = 0; i16 < iA0I3; i16++) {
                    int iA0I4 = c1376Hz.A0I();
                    System.arraycopy(AbstractC1372Hv.A03, 0, bArr, i14, AbstractC1372Hv.A03.length);
                    int length = i14 + AbstractC1372Hv.A03.length;
                    System.arraycopy(c1376Hz.A00, c1376Hz.A06(), bArr, length, iA0I4);
                    i14 = length + iA0I4;
                    c1376Hz.A0Z(iA0I4);
                }
            }
            return new IN(i11 == 0 ? null : Collections.singletonList(bArr), iA0E + 1);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw new C11849v(A01(0, 25, 65), e11);
        }
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{83, 100, 100, 121, 100, 54, 102, 119, 100, 101, Ascii.DEL, 120, 113, 54, 94, 83, 64, 85, 54, 117, 121, 120, 112, Ascii.DEL, 113};
    }
}
