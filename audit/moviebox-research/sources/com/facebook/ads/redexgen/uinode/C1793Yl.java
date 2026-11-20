package com.facebook.ads.redexgen.uinode;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1793Yl extends AbstractC11327s {
    public static byte[] A00;
    public static String[] A01 = {"jrDlnlrK", "iy84zN2ZyMyHjuWhjHotEPEqpiKyPe89", "dhX4OOJDnXlCZP9pL8vYTq2cDSC1Ep0f", "V5wGJKV", "mjidYuf4", "f2fONlBHJxOBrlG7qLTpq6ivaaiBfV2e", "tNB7OhzIAdgb5rZvvS5ZVqcHEeMF5GsI", "2zYeFugNugInNaPrLN78SJaAZY8hyaCl"};
    public static final C11287m A02;
    public static final C11287m A03;
    public static final C11287m A04;
    public static final C11287m A05;
    public static final C11287m A06;
    public static final C11287m A07;
    public static final C11287m A08;
    public static final C11287m A09;
    public static final C11287m A0A;
    public static final C11287m[] A0B;
    public static final String A0C;

    static {
        A04();
        C11287m c11287m = new C11287m(0, A00(159, 8, 31), A00(73, 16, 35));
        A04 = c11287m;
        C11287m c11287m2 = new C11287m(1, A00(207, 8, 2), A00(89, 59, 111));
        A09 = c11287m2;
        String strA00 = A00(173, 8, 25);
        String strA01 = A00(4, 7, 49);
        C11287m c11287m3 = new C11287m(2, strA00, strA01);
        A05 = c11287m3;
        String strA02 = A00(215, 4, 66);
        String strA03 = A00(69, 4, 81);
        C11287m c11287m4 = new C11287m(3, strA02, strA03);
        A0A = c11287m4;
        String strA04 = A00(203, 4, 55);
        String strA05 = A00(11, 4, Worker.WHAT_QUIT);
        C11287m c11287m5 = new C11287m(4, strA04, strA05);
        A08 = c11287m5;
        C11287m c11287m6 = new C11287m(5, A00(191, 12, 9), strA05);
        A07 = c11287m6;
        C11287m c11287m7 = new C11287m(6, A00(181, 10, 19), strA03);
        A06 = c11287m7;
        C11287m c11287m8 = new C11287m(7, A00(155, 4, 29), strA03);
        A03 = c11287m8;
        C11287m c11287m9 = new C11287m(8, A00(148, 7, 100), strA01);
        A02 = c11287m9;
        C11287m[] c11287mArr = {c11287m, c11287m2, c11287m3, c11287m4, c11287m5, c11287m6, c11287m7, c11287m8, c11287m9};
        A0B = c11287mArr;
        A0C = AbstractC11327s.A02(A00(167, 6, 109), c11287mArr);
    }

    public C1793Yl(C11297o c11297o) {
        super(c11297o);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 42);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-102, -73, -102, -71, -92, -87, -81, -96, -94, -96, -83, -22, -35, -39, -28, -93, -107, -100, -107, -109, -92, 112, 122, 112, -106, -94, -97, -99, 112, -75, -58, -75, -66, -60, -61, 112, -89, -104, -107, -94, -107, 112, -11, -25, -18, -25, -27, -10, -62, 5, 17, Ascii.ETB, Ascii.DLE, Ascii.SYN, -54, -52, -53, -62, -24, -12, -15, -17, -62, 7, Ascii.CAN, 7, Ascii.DLE, Ascii.SYN, Ascii.NAK, -49, -64, -45, -49, -95, -110, -91, -95, 109, -99, -97, -106, -102, -114, -97, -90, 109, -104, -110, -90, -19, -34, -15, -19, -71, -21, -34, -33, -34, -21, -34, -25, -36, -34, -20, -71, Ascii.CR, 8, 4, -2, 7, Ascii.FF, -71, -24, -25, -71, -18, -23, -35, -38, -19, -34, -71, -36, -38, -20, -36, -38, -35, -34, -71, -24, -25, -71, -35, -34, -27, -34, -19, -34, -71, -21, -34, -20, -19, -21, -30, -36, -19, -17, 2, 2, -13, -5, -2, 2, -85, -88, -69, -88, -82, -65, -82, -73, -67, -88, -78, -83, -4, Ascii.CR, -4, 5, Ascii.VT, 10, -77, -75, -84, -78, -75, -84, -73, -68, -80, -94, -80, -80, -90, -84, -85, -100, -90, -95, -90, -104, -90, -90, -100, -94, -95, -110, -89, -100, -96, -104, -43, -54, -50, -58, -96, -101, -105, -111, -102, -117, -107, -112, -32, -27, -36, -47};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11327s
    public final String A06() {
        return A00(167, 6, 109);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC11327s
    public final C11287m[] A0A() {
        return A0B;
    }

    public final Cursor A0B() {
        return A05().rawQuery(A00(42, 27, 120), null);
    }

    public final Cursor A0C() {
        return A05().rawQuery(A0C, null);
    }

    public final Cursor A0D(String str) {
        return A05().rawQuery(A00(15, 27, 38) + A04.A01 + A00(0, 4, 80), new String[]{str});
    }

    public final String A0E(String str, int i11, String str2, double d11, double d12, String str3, Map<String, String> map) throws SQLiteException {
        String string = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(9);
        contentValues.put(A04.A01, string);
        contentValues.put(A09.A01, str);
        contentValues.put(A05.A01, Integer.valueOf(i11));
        contentValues.put(A0A.A01, str2);
        contentValues.put(A08.A01, Double.valueOf(d11));
        contentValues.put(A07.A01, Double.valueOf(d12));
        contentValues.put(A06.A01, str3);
        contentValues.put(A03.A01, map != null ? new JSONObject(map).toString() : null);
        if (A01[2].charAt(6) == '9') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "s3YvQaCKhotLBtEqHITMzm2bHxiojI5j";
        strArr[5] = "6LuOsEhvTekWWK5Zi4EuC4VUkJbxKkeL";
        contentValues.put(A02.A01, (Integer) 0);
        A05().insertOrThrow(A00(167, 6, 109), null, contentValues);
        return string;
    }

    public final boolean A0F(String str) {
        return A05().delete(A00(167, 6, 109), new StringBuilder().append(A04.A01).append(A00(0, 4, 80)).toString(), new String[]{str}) > 0;
    }
}
