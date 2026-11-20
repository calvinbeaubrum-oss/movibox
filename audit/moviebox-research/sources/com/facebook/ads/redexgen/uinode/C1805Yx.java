package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1805Yx implements AnonymousClass69 {
    public static byte[] A02;
    public static String[] A03 = {"TFthAsyh9DXeOXmOSrI", "6fWFj2GuIp8edYChPrJEmZ0EGdAH52zr", "1W8BLXCecsGswLg5J6ItB4TJ0IeP92", "LJOYl73w1qtKK7uJcnV", "z6IkqPokH6efARGWKazebLzdy8d5mCY", "2wZEZTk79zqBVt75gMVieTbdYLiT7Zir", "bDoQVkMDKn3JHFmlXSVDRiBYbpx4sGCA", "L28Z4g4sdLlGf5SKMowSfgQKz11TtxJ4"};
    public final C6A A00;
    public final String A01;

    static {
        A02();
    }

    public C1805Yx(C6A c6a, String str) {
        this.A00 = c6a;
        this.A01 = str;
    }

    public static C1805Yx A00(JSONObject jSONObject) {
        C6A c6aA00 = C6A.A00(jSONObject.optString(A01(0, 4, 21)));
        String strOptString = jSONObject.optString(A01(4, 3, 93));
        if (c6aA00 != null && strOptString != null) {
            return new C1805Yx(c6aA00, strOptString);
        }
        String[] strArr = A03;
        if (strArr[7].charAt(27) != strArr[5].charAt(27)) {
            throw new RuntimeException();
        }
        A03[2] = "YX1kth4";
        return null;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{5, 10, 1, -10, 78, 75, 69};
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass69
    public final C6A A8D() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r4 != r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (r4 != r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        r7 = (com.facebook.ads.redexgen.uinode.C1805Yx) r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        if (r6.A00 == r7.A00) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
    
        return r6.A01.equals(r7.A01);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            if (A03[4].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "7vOCIJjJCX9CoY0eg8O";
            strArr[3] = "3BsZIpiI9Segj8T9GPE";
            return true;
        }
        String[] strArr2 = A03;
        if (strArr2[7].charAt(27) != strArr2[5].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A03;
        strArr3[0] = "CUYUmjEQroJXgi3huLe";
        strArr3[3] = "AnYHMDp1ebtK81SsggF";
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            if (A03[2].length() != 31) {
                A03[4] = "McBoxOwAJvKvGI9HKqBnGpNAZAcduNL";
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass69
    public final String getUrl() {
        return this.A01;
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }
}
