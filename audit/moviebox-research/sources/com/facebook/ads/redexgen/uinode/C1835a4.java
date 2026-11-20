package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1835a4<T> implements InterfaceC10212z<T> {
    public static byte[] A02;
    public static String[] A03 = {"pRcBA4OWefysSNzvRxIkpBVTVwfc3AVE", "RPn4qv0f1UarsEXGS1XogTnrbpEJEmnV", "xmsaI0t9E", "ZcBN", "DIlRoYRb", "oKMZSswBXiC", "UEhtJ1eDnORTZ2wzgc9obnj9WqOhgFHK", "4xQT2X5Ea9Pr"};
    public int A00;
    public final Object[] A01;

    static {
        A01();
    }

    public C1835a4(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException(A00(20, 29, 114));
        }
        this.A01 = new Object[i11];
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            byte b11 = bArrCopyOfRange[i14];
            String[] strArr = A03;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A03[5] = "P1E265Ge3cQ";
            bArrCopyOfRange[i14] = (byte) ((b11 ^ i13) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{44, 1, Ascii.US, 8, Ascii.FF, 9, Ascii.DC4, 77, 4, 3, 77, Ascii.EM, 5, 8, 77, Ascii.GS, 2, 2, 1, 76, 76, 112, 125, 56, 117, 121, 96, 56, 104, 119, 119, 116, 56, 107, 113, 98, 125, 56, 117, 109, 107, 108, 56, 122, 125, 56, 38, 56, 40};
    }

    private boolean A02(T t11) {
        for (int i11 = 0; i11 < this.A00; i11++) {
            Object obj = this.A01[i11];
            String[] strArr = A03;
            if (strArr[2].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[4] = "IsiBXNP8";
            strArr2[7] = "yZIlFrLQCuaZ";
            if (obj == t11) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10212z
    public T A2b() {
        int i11 = this.A00;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        Object[] objArr = this.A01;
        T t11 = (T) objArr[i12];
        objArr[i12] = null;
        this.A00 = i11 - 1;
        return t11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10212z
    public boolean AEY(T t11) {
        if (A02(t11)) {
            throw new IllegalStateException(A00(0, 20, 7));
        }
        int i11 = this.A00;
        Object[] objArr = this.A01;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = t11;
        this.A00 = i11 + 1;
        return true;
    }
}
