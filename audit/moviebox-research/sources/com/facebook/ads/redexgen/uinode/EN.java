package com.facebook.ads.redexgen.uinode;

import android.database.Cursor;
import android.util.Log;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EN implements YH {
    public static byte[] A03;
    public static String[] A04 = {"zSqnO64p11LQVC3SPrHTwk7q", "RQQcRArwNRw7pCFobI7zm4AECBhyO", "uX7W3VjoXSZ8mIic8tH9fb17VHeYN2EI", "VdQ4q", "h", "roUcO9bhLUMzgbi0", "6tdL5l5B64y16QievzXwm2hdxMIwTdT2", "M1EyYsdVjnJYnVOvo"};
    public boolean A00 = true;
    public final C1794Ym A01;
    public final C11297o A02;

    static {
        A04();
    }

    public EN(C1794Ym c1794Ym) {
        this.A01 = c1794Ym;
        this.A02 = new C11297o(c1794Ym);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 85);
        }
        return new String(bArrCopyOfRange);
    }

    private JSONArray A01(Cursor cursor) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(54, 2, 44), cursor.getString(C1793Yl.A04.A00));
            jSONObject.put(A00(82, 8, 53), cursor.getString(C1793Yl.A09.A00));
            jSONObject.put(A00(90, 4, 94), cursor.getString(C1793Yl.A0A.A00));
            jSONObject.put(A00(78, 4, 109), C1453Lf.A02(cursor.getDouble(C1793Yl.A08.A00)));
            jSONObject.put(A00(66, 12, 6), C1453Lf.A02(cursor.getDouble(C1793Yl.A07.A00)));
            jSONObject.put(A00(56, 10, 20), cursor.getString(C1793Yl.A06.A00));
            String string = cursor.getString(C1793Yl.A03.A00);
            jSONObject.put(A00(50, 4, 78), string != null ? new JSONObject(string) : new JSONObject());
            jSONObject.put(A00(43, 7, 26), cursor.getString(C1793Yl.A02.A00));
            jSONObject.put(A00(38, 5, 36), this.A01.A03().A7H());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private JSONArray A02(Cursor cursor) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(54, 2, 44), cursor.getString(2));
            jSONObject.put(A00(82, 8, 53), cursor.getString(0));
            jSONObject.put(A00(90, 4, 94), cursor.getString(4));
            jSONObject.put(A00(78, 4, 109), C1453Lf.A02(cursor.getDouble(5)));
            jSONObject.put(A00(66, 12, 6), C1453Lf.A02(cursor.getDouble(6)));
            jSONObject.put(A00(56, 10, 20), cursor.getString(7));
            String string = cursor.getString(8);
            jSONObject.put(A00(50, 4, 78), string != null ? new JSONObject(string) : new JSONObject());
            jSONObject.put(A00(43, 7, 26), cursor.getString(9));
            jSONObject.put(A00(38, 5, 36), this.A01.A03().A7H());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static JSONObject A03(Cursor cursor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            String string = cursor.getString(C1792Yk.A02.A00);
            String string2 = cursor.getString(C1792Yk.A01.A00);
            String[] strArr = A04;
            if (strArr[6].charAt(14) != strArr[2].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[7] = "IfQdYzKY6vCyBSxPg";
            strArr2[5] = "fxZpsWnZoPKbT5Dt";
            jSONObject.put(string, string2);
        }
        return jSONObject;
    }

    public static void A04() {
        String[] strArr = A04;
        if (strArr[7].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "GUa5RhIL61d4FW3HWW0RBx9i";
        strArr2[1] = "4nKtohmUbY7tHai9z2t8ojCMJbrZv";
        A03 = new byte[]{62, Ascii.FS, 19, 90, 9, 93, Ascii.EM, Ascii.CAN, 17, Ascii.CAN, 9, Ascii.CAN, 93, Ascii.FS, 9, 9, Ascii.CAN, Ascii.DLE, Ascii.CR, 9, Ascii.SO, 93, Ascii.CAN, 5, Ascii.RS, Ascii.CAN, Ascii.CAN, Ascii.EM, Ascii.CAN, Ascii.EM, 93, Ascii.CAN, Ascii.VT, Ascii.CAN, 19, 9, Ascii.SO, 83, Ascii.DLE, Ascii.NAK, 7, Ascii.CAN, Ascii.NAK, 46, 59, 59, 42, 34, Utf8.REPLACEMENT_BYTE, 59, Ascii.DEL, 122, 111, 122, Ascii.DLE, Ascii.GS, 50, 36, 50, 50, 40, 46, 47, Ascii.RS, 40, 37, 32, 54, 32, 32, 58, 60, 61, Ascii.FF, 39, 58, 62, 54, 76, 81, 85, 93, Ascii.DC4, Ascii.SI, Ascii.VT, 5, Ascii.SO, Utf8.REPLACEMENT_BYTE, 9, 4, Ascii.DEL, 114, 123, 110};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final int A4I(int i11) {
        int iA08 = 0;
        if (i11 > -1) {
            try {
                iA08 = this.A02.A08(i11);
            } catch (Exception e11) {
                if (this.A01.A04().A8z()) {
                    Log.e(YH.A00, A00(0, 38, 40), e11);
                }
            }
        }
        this.A02.A0I();
        if (this.A00) {
            this.A02.A0J();
        }
        return iA08;
    }

    @Override // com.facebook.ads.redexgen.uinode.C8w
    public final void A4J() {
        this.A02.A0H();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final boolean A53(String str) {
        return this.A02.A0K(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final JSONArray A5y() {
        Cursor cursorA0A = null;
        try {
            cursorA0A = this.A02.A0A();
            return cursorA0A.getCount() > 0 ? A01(cursorA0A) : null;
        } catch (JSONException unused) {
        } finally {
            if (cursorA0A != null) {
                cursorA0A.close();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final JSONObject A5z() {
        Cursor cursorA0B = null;
        try {
            cursorA0B = this.A02.A0B();
            return cursorA0B.getCount() > 0 ? A03(cursorA0B) : null;
        } catch (JSONException unused) {
        } finally {
            if (cursorA0B != null) {
                cursorA0B.close();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final int A6z() {
        Cursor cursorA09 = null;
        try {
            cursorA09 = this.A02.A09();
            return cursorA09.moveToFirst() ? cursorA09.getInt(0) : 0;
        } finally {
            if (cursorA09 != null) {
                cursorA09.close();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final String A72(String str) {
        String string = null;
        Cursor cursorA0D = this.A02.A0D(str);
        if (cursorA0D != null) {
            if (cursorA0D.moveToNext() && cursorA0D.getCount() > 0) {
                C11287m c11287m = C1793Yl.A0A;
                String[] strArr = A04;
                if (strArr[7].length() == strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A04;
                strArr2[3] = "VgiME";
                strArr2[4] = "4";
                string = cursorA0D.getString(cursorA0D.getColumnIndex(c11287m.A01));
            }
            cursorA0D.close();
        }
        return string;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final Pair<JSONObject, JSONArray> A89(int i11) {
        Cursor cursorA0C = null;
        try {
            cursorA0C = this.A02.A0C(i11);
            JSONArray jSONArrayA02 = null;
            JSONObject jSONObjectA03 = null;
            if (cursorA0C.getCount() > 0) {
                jSONObjectA03 = A03(cursorA0C);
                jSONArrayA02 = A02(cursorA0C);
            }
            return new Pair<>(jSONObjectA03, jSONArrayA02);
        } catch (JSONException unused) {
            return new Pair<>(null, null);
        } finally {
            if (cursorA0C != null) {
                cursorA0C.close();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11608v
    public final boolean A8m(String str) {
        return this.A02.A0L(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.C8w
    public final void AHE(C1400Iz c1400Iz, AbstractC11588t<String> abstractC11588t) {
        this.A02.A0G(c1400Iz.A08(), c1400Iz.A05().A00, c1400Iz.A06().toString(), c1400Iz.A04(), c1400Iz.A03(), c1400Iz.A07(), c1400Iz.A09(), abstractC11588t);
    }
}
