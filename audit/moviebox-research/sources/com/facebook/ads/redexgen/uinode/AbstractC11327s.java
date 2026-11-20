package com.facebook.ads.redexgen.uinode;

import android.database.sqlite.SQLiteDatabase;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC11327s {
    public static byte[] A01;
    public static String[] A02 = {"HVKZvR5UTjStDLOL9o4rPessbKuh0O7V", "lcBs6IulTDBXs0xMNwr7074HBb5CT680", "pp9", "08Pk9qbigTz1ItVQ0hAeiWjKqsV0Kke0", "IZPR1WSW", "qkmVdqnPN26Te8aFuQlNVKOt05q5LyYY", "adXBxD3OrJvPB32QQ8w", "pvdflY6bA4nr3ZgRZtp7kAtC3Qj6GBkc"};
    public final C11297o A00;

    static {
        A04();
    }

    public AbstractC11327s(C11297o c11297o) {
        this.A00 = c11297o;
    }

    private String A00() {
        C11287m[] c11287mArrA0A = A0A();
        if (c11287mArrA0A.length < 1) {
            if (A02[4].length() != 8) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[0] = "NTtbWHu0RetWI6yxki67w6X3knWPKgwD";
            strArr[1] = "wg0AU135P1OwlpIQrYrtBV6UQnwqkPhP";
            return null;
        }
        String strA01 = A01(0, 0, 31);
        for (int i11 = 0; i11 < c11287mArrA0A.length - 1; i11++) {
            strA01 = strA01 + c11287mArrA0A[i11].A02() + A01(20, 2, 35);
        }
        return strA01 + c11287mArrA0A[c11287mArrA0A.length - 1].A02();
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A02(String str, C11287m[] c11287mArr) {
        StringBuilder sb2 = new StringBuilder(A01(56, 7, 106));
        for (int i11 = 0; i11 < c11287mArr.length - 1; i11++) {
            sb2.append(c11287mArr[i11].A01);
            if (A02[2].length() != 3) {
                throw new RuntimeException();
            }
            A02[4] = "CXWyM2Ol";
            sb2.append(A01(20, 2, 35));
        }
        sb2.append(c11287mArr[c11287mArr.length - 1].A01);
        sb2.append(A01(6, 6, 79));
        sb2.append(str);
        return sb2.toString();
    }

    public static String A03(String str, C11287m[] c11287mArr, C11287m c11287m) {
        return A02(str, c11287mArr) + A01(12, 7, 121) + c11287m.A01 + A01(2, 4, 32);
    }

    public static void A04() {
        A01 = new byte[]{121, -127, 123, -104, 123, -102, -86, -48, -36, -39, -41, -86, -44, Ascii.VT, -4, -7, 6, -7, -44, -108, -118, 126, -126, -111, -124, -128, -109, -124, 95, -109, -128, -127, -117, -124, 95, -95, -81, -84, -83, 125, -79, -98, -97, -87, -94, 125, -90, -93, 125, -94, -75, -90, -80, -79, -80, 125, -8, -22, -15, -22, -24, -7, -59};
    }

    public final SQLiteDatabase A05() {
        return this.A00.A0E();
    }

    public abstract String A06();

    public final void A07(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(22, 13, 4) + A06() + A01(0, 2, 30) + A00() + A01(19, 1, 48));
    }

    public final void A08(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(A01(35, 21, 34) + A06());
    }

    public final boolean A09() {
        return A05().delete(A06(), null, null) > 0;
    }

    public abstract C11287m[] A0A();
}
