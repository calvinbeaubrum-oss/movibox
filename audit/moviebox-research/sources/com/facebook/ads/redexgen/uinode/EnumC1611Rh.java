package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A03' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class EnumC1611Rh {
    public static byte[] A00;
    public static String[] A01 = {"nA8fLeyOwVmNwvq6aIqKxCaagHA5eYr", "8Z3ODqLNUnEAqB2P3Amw9Ur1PSsugik5", "YRmdf", "zIg3Ob9eurpeZ06C2uEHUxbrUPW1iO5", "DwODnBhAs5I9lGAPLwBjllp42Gjp41Mv", "6IL6kP5nz", "IHg6IZuYXxuMxytmBHiV", "YXmTZGEBqQ8NuPQvZDB03"};
    public static final /* synthetic */ EnumC1611Rh[] A02;
    public static final EnumC1611Rh A03;
    public static final EnumC1611Rh A04;
    public static final EnumC1611Rh A05;
    public static final EnumC1611Rh A06;
    public static final EnumC1611Rh A07;
    public static final EnumC1611Rh A08;

    static {
        A03();
        final String strA02 = A02(0, 5, 105);
        final int i11 = 0;
        EnumC1611Rh enumC1611Rh = new EnumC1611Rh(strA02, i11) { // from class: com.facebook.ads.redexgen.X.J6
            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A04(JSONArray jSONArray, int i12) {
                return jSONArray.optJSONArray(i12) != null;
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i12) {
                return AbstractC1612Ri.A00(jSONArray.optJSONArray(i12), jSONArray2.optJSONArray(i12));
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optJSONArray(str) != null;
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return AbstractC1612Ri.A00(jSONObject.optJSONArray(str), jSONObject2.optJSONArray(str));
            }
        };
        A03 = enumC1611Rh;
        final String strA03 = A02(5, 7, 40);
        final int i12 = 1;
        EnumC1611Rh enumC1611Rh2 = new EnumC1611Rh(strA03, i12) { // from class: com.facebook.ads.redexgen.X.In
            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A04(JSONArray jSONArray, int i13) {
                return jSONArray.optBoolean(i13, true) == jSONArray.optBoolean(i13, false);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i13) {
                return jSONArray.optBoolean(i13) == jSONArray2.optBoolean(i13);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optBoolean(str, true) == jSONObject.optBoolean(str, false);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optBoolean(str) == jSONObject2.optBoolean(str);
            }
        };
        A04 = enumC1611Rh2;
        final String strA04 = A02(12, 6, 81);
        final int i13 = 2;
        EnumC1611Rh enumC1611Rh3 = new EnumC1611Rh(strA04, i13) { // from class: com.facebook.ads.redexgen.X.ID
            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A04(JSONArray jSONArray, int i14) {
                return jSONArray.optInt(i14, 0) == jSONArray.optInt(i14, 1) && jSONArray.optDouble(i14, 0.0d) == jSONArray.optDouble(i14, 1.0d) && ((double) jSONArray.optInt(i14, 0)) != jSONArray.optDouble(i14, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i14) {
                return jSONArray.optDouble(i14) == jSONArray2.optDouble(i14);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optInt(str, 0) == jSONObject.optInt(str, 1) && jSONObject.optDouble(str, 0.0d) == jSONObject.optDouble(str, 1.0d) && ((double) jSONObject.optInt(str, 0)) != jSONObject.optDouble(str, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optDouble(str) == jSONObject2.optDouble(str);
            }
        };
        A05 = enumC1611Rh3;
        final String strA05 = A02(18, 3, 50);
        final int i14 = 3;
        EnumC1611Rh enumC1611Rh4 = new EnumC1611Rh(strA05, i14) { // from class: com.facebook.ads.redexgen.X.I5
            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A04(JSONArray jSONArray, int i15) {
                return jSONArray.optInt(i15, 0) == jSONArray.optInt(i15, 1) && jSONArray.optDouble(i15, 0.0d) == jSONArray.optDouble(i15, 1.0d) && ((double) jSONArray.optInt(i15, 0)) == jSONArray.optDouble(i15, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i15) {
                return jSONArray.optInt(i15) == jSONArray2.optInt(i15);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optInt(str, 0) == jSONObject.optInt(str, 1) && jSONObject.optDouble(str, 0.0d) == jSONObject.optDouble(str, 1.0d) && ((double) jSONObject.optInt(str, 0)) == jSONObject.optDouble(str, 0.0d);
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optInt(str) == jSONObject2.optInt(str);
            }
        };
        A06 = enumC1611Rh4;
        final String strA06 = A02(21, 6, 18);
        final int i15 = 4;
        EnumC1611Rh enumC1611Rh5 = new EnumC1611Rh(strA06, i15) { // from class: com.facebook.ads.redexgen.X.I4
            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A04(JSONArray jSONArray, int i16) {
                return jSONArray.optJSONObject(i16) != null;
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i16) {
                return AbstractC1612Ri.A02(jSONArray.optJSONObject(i16), jSONArray2.optJSONObject(i16));
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optJSONObject(str) != null;
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return AbstractC1612Ri.A02(jSONObject.optJSONObject(str), jSONObject2.optJSONObject(str));
            }
        };
        A07 = enumC1611Rh5;
        final String strA07 = A02(27, 6, 36);
        final int i16 = 5;
        EnumC1611Rh enumC1611Rh6 = new EnumC1611Rh(strA07, i16) { // from class: com.facebook.ads.redexgen.X.Hx
            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A04(JSONArray jSONArray, int i17) {
                return jSONArray.optString(i17) != null;
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i17) {
                return jSONArray.optString(i17).equals(jSONArray2.optString(i17));
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A06(JSONObject jSONObject, String str) {
                return jSONObject.optString(str) != null;
            }

            @Override // com.facebook.ads.redexgen.uinode.EnumC1611Rh
            public final boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str) {
                return jSONObject.optString(str).equals(jSONObject2.optString(str));
            }
        };
        A08 = enumC1611Rh6;
        A02 = new EnumC1611Rh[]{enumC1611Rh, enumC1611Rh2, enumC1611Rh3, enumC1611Rh4, enumC1611Rh5, enumC1611Rh6};
    }

    public EnumC1611Rh(String str, int i11) {
        super(str, i11);
    }

    public static EnumC1611Rh A00(JSONArray jSONArray, int i11) {
        for (EnumC1611Rh enumC1611Rh : values()) {
            if (A01[1].charAt(14) != '2') {
                throw new RuntimeException();
            }
            A01[4] = "PUsgFaltT51mxPXWqnHKjq6lqfkoVDea";
            if (enumC1611Rh.A04(jSONArray, i11)) {
                return enumC1611Rh;
            }
        }
        throw new AssertionError(A02(33, 31, 68));
    }

    public static EnumC1611Rh A01(JSONObject jSONObject, String str) {
        for (EnumC1611Rh enumC1611Rh : values()) {
            boolean zA06 = enumC1611Rh.A06(jSONObject, str);
            if (A01[5].length() != 9) {
                throw new RuntimeException();
            }
            A01[6] = "GmRRmI3tzaTgoS0GQtjO0";
            if (zA06) {
                return enumC1611Rh;
            }
        }
        throw new AssertionError(A02(33, 31, 68));
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-82, -33, -33, -50, -26, 110, -101, -101, -104, -111, -115, -102, -103, -60, -54, -73, -63, -70, Ascii.DEL, -92, -86, 101, 120, -128, 123, 121, -118, 123, -100, -102, -111, -106, -113, -99, -74, -77, -74, -73, -65, -74, 104, -68, -63, -72, -83, 104, -73, -82, 104, -78, -69, -73, -74, 104, -73, -86, -78, -83, -85, -68, 104, -77, -83, -63};
    }

    public static EnumC1611Rh valueOf(String str) {
        return (EnumC1611Rh) Enum.valueOf(EnumC1611Rh.class, str);
    }

    public static EnumC1611Rh[] values() {
        return (EnumC1611Rh[]) A02.clone();
    }

    public abstract boolean A04(JSONArray jSONArray, int i11);

    public abstract boolean A05(JSONArray jSONArray, JSONArray jSONArray2, int i11);

    public abstract boolean A06(JSONObject jSONObject, String str);

    public abstract boolean A07(JSONObject jSONObject, JSONObject jSONObject2, String str);
}
