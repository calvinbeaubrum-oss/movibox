package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ua, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1682Ua {
    public static String[] A00 = {"hdmHMjdsCvnnIiAm68nbzST5FT4P5mLb", "EH3LUmZxwOvThvXMHcswnn58jDASieiK", "ljU4lnctUqCxo644HWpRzVkau739AG18", "cf0wMMVzQ5eDMzw1G9WbfLTL5VaSUv", "l50byEuqIAJWTFcEqiPP3cq5SFvrKOhf", "BkuhnFfUhQO532vAuKLRONmm63PuLWNO", "lueSUxwI7577CW", "p49ZYnIXKwO4jtZLxoBrhqW2OVcn4ZYc"};
    public static final short[] A02 = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    public static final byte[] A01 = {9, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.CR, Ascii.SO, Ascii.SO, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.DLE, 17, 17, 17, 17, 17, 17, 17, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.DC4, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN, Ascii.CAN};

    public static void A00(int[] iArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17 = i11 - 1;
        int i18 = i12 - 1;
        int i19 = (i13 * 2) + 1;
        short s11 = A02[i13];
        byte b11 = A01[i13];
        int[] iArr2 = new int[i19];
        long j11 = 0;
        if (i16 == 1) {
            int i21 = (i15 * i12) / i14;
            int i22 = ((i15 + 1) * i12) / i14;
            while (i21 < i22) {
                long j12 = j11;
                long j13 = j11;
                long j14 = j11;
                long j15 = j11;
                long j16 = j11;
                long j17 = j11;
                long j18 = j11;
                long j19 = j11;
                int i23 = i11 * i21;
                for (int i24 = 0; i24 <= i13; i24++) {
                    iArr2[i24] = iArr[i23];
                    j19 += (long) (((iArr[i23] >>> 16) & 255) * (i24 + 1));
                    j18 += (long) (((iArr[i23] >>> 8) & 255) * (i24 + 1));
                    j17 += (long) ((iArr[i23] & 255) * (i24 + 1));
                    j13 += (long) ((iArr[i23] >>> 16) & 255);
                    j12 += (long) ((iArr[i23] >>> 8) & 255);
                    j11 += (long) (iArr[i23] & 255);
                }
                for (int i25 = 1; i25 <= i13; i25++) {
                    if (i25 <= i17) {
                        i23++;
                    }
                    iArr2[i25 + i13] = iArr[i23];
                    j19 += (long) (((iArr[i23] >>> 16) & 255) * ((i13 + 1) - i25));
                    j18 += (long) (((iArr[i23] >>> 8) & 255) * ((i13 + 1) - i25));
                    j17 += (long) ((iArr[i23] & 255) * ((i13 + 1) - i25));
                    j16 += (long) ((iArr[i23] >>> 16) & 255);
                    j15 += (long) ((iArr[i23] >>> 8) & 255);
                    j14 += (long) (iArr[i23] & 255);
                }
                int i26 = i13;
                int i27 = i13;
                if (i27 > i17) {
                    i27 = i17;
                }
                int i28 = (i21 * i11) + i27;
                int i29 = i21 * i11;
                for (int i31 = 0; i31 < i11; i31++) {
                    iArr[i29] = (int) (((long) (iArr[i29] & ViewCompat.MEASURED_STATE_MASK)) | ((((((long) s11) * j19) >>> b11) & 255) << 16) | ((((((long) s11) * j18) >>> b11) & 255) << 8) | (((((long) s11) * j17) >>> b11) & 255));
                    i29++;
                    long j21 = j19 - j13;
                    long j22 = j18 - j12;
                    long j23 = j17 - j11;
                    int i32 = (i26 + i19) - i13;
                    if (i32 >= i19) {
                        i32 -= i19;
                    }
                    long j24 = j13 - ((long) ((iArr2[i32] >>> 16) & 255));
                    long j25 = j12 - ((long) ((iArr2[i32] >>> 8) & 255));
                    long j26 = j11 - ((long) (iArr2[i32] & 255));
                    if (i27 < i17) {
                        i28++;
                        i27++;
                    }
                    iArr2[i32] = iArr[i28];
                    long j27 = j16 + ((long) ((iArr[i28] >>> 16) & 255));
                    long j28 = j15 + ((long) ((iArr[i28] >>> 8) & 255));
                    long j29 = j14 + ((long) (iArr[i28] & 255));
                    j19 = j21 + j27;
                    j18 = j22 + j28;
                    j17 = j23 + j29;
                    int i33 = i26 + 1;
                    if (i33 >= i19) {
                        i33 = 0;
                    }
                    i26 = i33;
                    j13 = j24 + ((long) ((iArr2[i33] >>> 16) & 255));
                    j12 = j25 + ((long) ((iArr2[i33] >>> 8) & 255));
                    j11 = j26 + ((long) (iArr2[i33] & 255));
                    j16 = j27 - ((long) ((iArr2[i33] >>> 16) & 255));
                    j15 = j28 - ((long) ((iArr2[i33] >>> 8) & 255));
                    j14 = j29 - ((long) (iArr2[i33] & 255));
                }
                i21++;
                j11 = 0;
            }
            return;
        }
        if (i16 == 2) {
            int i34 = (i15 * i11) / i14;
            int i35 = ((i15 + 1) * i11) / i14;
            while (i34 < i35) {
                long j31 = 0;
                long j32 = 0;
                long j33 = 0;
                long j34 = 0;
                long j35 = 0;
                long j36 = 0;
                long j37 = 0;
                long j38 = 0;
                long j39 = 0;
                int i36 = i34;
                for (int i37 = 0; i37 <= i13; i37++) {
                    iArr2[i37] = iArr[i36];
                    j39 += (long) (((iArr[i36] >>> 16) & 255) * (i37 + 1));
                    j38 += (long) (((iArr[i36] >>> 8) & 255) * (i37 + 1));
                    j37 += (long) ((iArr[i36] & 255) * (i37 + 1));
                    j33 += (long) ((iArr[i36] >>> 16) & 255);
                    j32 += (long) ((iArr[i36] >>> 8) & 255);
                    j31 += (long) (iArr[i36] & 255);
                }
                for (int i38 = 1; i38 <= i13; i38++) {
                    if (i38 <= i18) {
                        i36 += i11;
                    }
                    iArr2[i38 + i13] = iArr[i36];
                    j39 += (long) (((iArr[i36] >>> 16) & 255) * ((i13 + 1) - i38));
                    j38 += (long) (((iArr[i36] >>> 8) & 255) * ((i13 + 1) - i38));
                    j37 += (long) ((iArr[i36] & 255) * ((i13 + 1) - i38));
                    j36 += (long) ((iArr[i36] >>> 16) & 255);
                    j35 += (long) ((iArr[i36] >>> 8) & 255);
                    j34 += (long) (iArr[i36] & 255);
                }
                int i39 = i13;
                int i40 = i13;
                if (i40 > i18) {
                    i40 = i18;
                }
                int i41 = (i40 * i11) + i34;
                int i42 = i34;
                for (int i43 = 0; i43 < i12; i43++) {
                    iArr[i42] = (int) (((long) (iArr[i42] & ViewCompat.MEASURED_STATE_MASK)) | ((((((long) s11) * j39) >>> b11) & 255) << 16) | ((((((long) s11) * j38) >>> b11) & 255) << 8) | (((((long) s11) * j37) >>> b11) & 255));
                    i42 += i11;
                    long j40 = j39 - j33;
                    long j41 = j38 - j32;
                    long j42 = j37 - j31;
                    int i44 = (i39 + i19) - i13;
                    if (i44 >= i19) {
                        i44 -= i19;
                    }
                    long j43 = j33 - ((long) ((iArr2[i44] >>> 16) & 255));
                    long j44 = j32 - ((long) ((iArr2[i44] >>> 8) & 255));
                    long j45 = j31 - ((long) (iArr2[i44] & 255));
                    if (i40 < i18) {
                        i41 += i11;
                        i40++;
                    }
                    iArr2[i44] = iArr[i41];
                    long j46 = j36 + ((long) ((iArr[i41] >>> 16) & 255));
                    long j47 = j35 + ((long) ((iArr[i41] >>> 8) & 255));
                    long j48 = j34 + ((long) (iArr[i41] & 255));
                    j39 = j40 + j46;
                    j38 = j41 + j47;
                    j37 = j42 + j48;
                    i39++;
                    if (i39 >= i19) {
                        i39 = 0;
                    }
                    j33 = j43 + ((long) ((iArr2[i39] >>> 16) & 255));
                    j32 = j44 + ((long) ((iArr2[i39] >>> 8) & 255));
                    j31 = j45 + ((long) (iArr2[i39] & 255));
                    j36 = j46 - ((long) ((iArr2[i39] >>> 16) & 255));
                    j35 = j47 - ((long) ((iArr2[i39] >>> 8) & 255));
                    j34 = j48 - ((long) (iArr2[i39] & 255));
                }
                i34++;
                String[] strArr = A00;
                if (strArr[4].charAt(24) == strArr[0].charAt(24)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A00;
                strArr2[4] = "dRrOf81uK3m7JlCVGnAp7HBN8Ud450kD";
                strArr2[0] = "ERfsWS88AUosonNdTmqfcWCTdCaDCKBU";
            }
        }
    }

    public final Bitmap A02(Bitmap bitmap, float f11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i11 = AbstractC1473Lz.A00;
            ArrayList arrayList = new ArrayList(i11);
            ArrayList arrayList2 = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = height;
                arrayList.add(new CallableC1472Ly(iArr, width, i13, (int) f11, i11, i12, 1));
                height = i13;
                arrayList2.add(new CallableC1472Ly(iArr, width, height, (int) f11, i11, i12, 2));
            }
            try {
                AbstractC1473Lz.A01.invokeAll(arrayList);
                try {
                    AbstractC1473Lz.A01.invokeAll(arrayList2);
                    try {
                        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        return null;
                    }
                } catch (InterruptedException unused2) {
                    return null;
                }
            } catch (InterruptedException unused3) {
                return null;
            }
        } catch (OutOfMemoryError unused4) {
            return null;
        }
    }
}
