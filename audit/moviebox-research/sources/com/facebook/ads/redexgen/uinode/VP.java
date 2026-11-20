package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class VP implements J0 {
    public static byte[] A02;
    public static String[] A03 = {"4VJF", "NMiFc9mQHDdEdTYDts8ebbMyjIljV2c0", "gJxI4lQggzgG7l1t48TOLBAVsZm4smpW", "RC", "7emK", "VnvWTQ3PSRLSSOUq71E5D", "jZ42e8scbVg896gjqaujwC7", "gj"};
    public static final String A04;
    public C1794Ym A00;
    public YH A01;

    static {
        A05();
        A04 = VP.class.getSimpleName();
    }

    public VP(C1794Ym c1794Ym, YH yh2) {
        this.A00 = c1794Ym;
        this.A01 = yh2;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[0].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "6iaNxoAqzoeupDn53l2Cm";
            strArr2[6] = "N7vye13Dqewush4C3JTfsv4";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 104);
            i14++;
        }
    }

    public static JSONArray A01(C1794Ym c1794Ym, JSONArray jSONArray, JSONArray jSONArray2) {
        int length = jSONArray != null ? 0 + jSONArray.length() : 0;
        if (jSONArray2 != null) {
            length += jSONArray2.length();
        }
        return A02(c1794Ym, jSONArray, jSONArray2, length);
    }

    public static JSONArray A02(C1794Ym c1794Ym, JSONArray jSONArray, JSONArray jSONArray2, int i11) {
        if (jSONArray == null) {
            return jSONArray2;
        }
        if (jSONArray2 == null) {
            return jSONArray;
        }
        int length = jSONArray.length();
        int length2 = jSONArray2.length();
        JSONArray jSONArray3 = new JSONArray();
        int i12 = 0;
        int i13 = 0;
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        double d11 = Double.MAX_VALUE;
        double d12 = Double.MAX_VALUE;
        while (true) {
            if ((i12 >= length && i13 >= length2) || i11 <= 0) {
                break;
            }
            String[] strArr = A03;
            if (strArr[0].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "aN";
            strArr2[3] = "P5";
            String strA00 = A00(435, 4, 91);
            if (i12 < length && jSONObject == null) {
                try {
                    jSONObject = jSONArray.getJSONObject(i12);
                    d11 = jSONObject.getDouble(strA00);
                } catch (JSONException e11) {
                    if (c1794Ym.A04().A8z()) {
                        Log.e(A04, A00(273, 33, 107) + i12, e11);
                    }
                    jSONObject = null;
                    d11 = Double.MAX_VALUE;
                }
                i12++;
            }
            if (i13 < length2 && jSONObject2 == null) {
                try {
                    jSONObject2 = jSONArray2.getJSONObject(i13);
                    d12 = jSONObject2.getDouble(strA00);
                } catch (JSONException e12) {
                    if (c1794Ym.A04().A8z()) {
                        Log.e(A04, A00(306, 25, 59) + i13, e12);
                    }
                    jSONObject2 = null;
                    d12 = Double.MAX_VALUE;
                }
                i13++;
            }
            if (jSONObject != null || jSONObject2 != null) {
                if (jSONObject == null || d12 < d11) {
                    jSONArray3.put(jSONObject2);
                    jSONObject2 = null;
                    d12 = Double.MAX_VALUE;
                } else {
                    jSONArray3.put(jSONObject);
                    jSONObject = null;
                    d11 = Double.MAX_VALUE;
                }
                i11--;
            }
        }
        if (i11 > 0) {
            if (jSONObject != null) {
                jSONArray3.put(jSONObject);
            } else if (jSONObject2 != null) {
                jSONArray3.put(jSONObject2);
            }
        }
        return jSONArray3;
    }

    private JSONObject A03() {
        JSONArray jSONArrayA03;
        JSONObject jSONObjectA5z = this.A01.A5z();
        JSONArray jSONArrayA5y = this.A01.A5y();
        if (Ij.A0P(this.A00) && (jSONArrayA03 = C8C.A03(this.A00)) != null && jSONArrayA03.length() > 0) {
            C1794Ym c1794Ym = this.A00;
            String[] strArr = A03;
            if (strArr[7].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[1] = "DqeH9SIpXFi3b8zfs8mhzwqF8zVFhPmm";
            strArr2[2] = "TV1z9woSYeZeWz7dxNs9KlrMFeTbS55S";
            jSONArrayA5y = A01(c1794Ym, jSONArrayA03, jSONArrayA5y);
        }
        JSONObject jSONObject = null;
        if (jSONArrayA5y != null) {
            try {
                jSONObject = new JSONObject();
                if (jSONObjectA5z != null) {
                    jSONObject.put(A00(439, 6, 32), jSONObjectA5z);
                }
                jSONObject.put(A00(387, 6, 28), jSONArrayA5y);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject;
    }

    private JSONObject A04(int i11) {
        int iA08;
        JSONArray jSONArrayA04;
        Pair<JSONObject, JSONArray> pairA89 = this.A01.A89(i11);
        JSONObject jSONObject = (JSONObject) pairA89.first;
        JSONArray jSONArrayA02 = (JSONArray) pairA89.second;
        if (Ij.A0P(this.A00) && (jSONArrayA04 = C8C.A04(this.A00, (iA08 = Ij.A08(this.A00)))) != null && jSONArrayA04.length() > 0) {
            jSONArrayA02 = A02(this.A00, jSONArrayA04, jSONArrayA02, i11 + iA08);
        }
        JSONObject jSONObject2 = null;
        if (jSONArrayA02 != null) {
            try {
                jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    jSONObject2.put(A00(439, 6, 32), jSONObject);
                }
                jSONObject2.put(A00(387, 6, 28), jSONArrayA02);
            } catch (JSONException unused) {
                return null;
            }
        }
        return jSONObject2;
    }

    public static void A05() {
        A02 = new byte[]{Ascii.NAK, 83, 90, 71, Ascii.NAK, 80, 67, 80, 91, 65, 124, 81, Ascii.NAK, 60, 111, 105, Ascii.DEL, Ascii.DEL, 121, 111, 111, 122, 105, 112, 112, 101, 50, 110, 101, 68, 77, 68, 85, 68, 69, 1, 68, 87, 68, 79, 85, 82, 1, 68, 89, 66, 68, 68, 69, 68, 69, 1, 83, 68, 85, 83, 88, 1, 77, 72, 76, 72, 85, Ascii.SI, 1, 98, 78, 84, 79, 85, Ascii.ESC, 1, 72, 123, 104, 99, 121, 45, 121, 116, 125, 104, 45, 125, Ascii.DEL, 98, 110, 104, 126, 126, 104, 105, 45, 111, 116, 45, 121, 101, 104, 45, 126, 104, Ascii.DEL, 123, 104, Ascii.DEL, 55, 45, 84, 115, 123, 126, 119, 118, 50, 102, 125, 50, 98, 115, 96, 97, 119, 50, 115, 124, 50, 119, 100, 119, 124, 102, 50, 123, 124, 50, 119, 100, 119, 124, 102, 97, 50, 115, 96, 96, 115, 107, 50, 116, 125, 96, 50, 118, 123, 97, 98, 115, 102, 113, 122, 50, 116, 115, 123, 126, 103, 96, 119, 60, 65, 119, 96, 100, 119, 96, 50, 98, 96, 125, 113, 119, 97, 97, 119, 118, 50, 119, 100, 119, 124, 102, 91, 118, 50, 50, 4, 19, Ascii.ETB, 4, 19, 65, 19, 4, Ascii.NAK, Ascii.DC4, 19, Ascii.SI, 4, 5, 65, Ascii.SI, Ascii.SO, Ascii.SI, 76, 19, 4, Ascii.NAK, 19, Ascii.CAN, 0, 3, Ascii.CR, 4, 65, 4, 19, 19, Ascii.SO, 19, 65, 2, Ascii.SO, 5, 4, 65, 42, Ascii.FS, Ascii.VT, Ascii.SI, Ascii.FS, Ascii.VT, 89, Ascii.VT, Ascii.FS, Ascii.CR, Ascii.FF, Ascii.VT, Ascii.ETB, Ascii.FS, Ascii.GS, 89, Ascii.VT, Ascii.FS, Ascii.CR, Ascii.VT, 0, Ascii.CAN, Ascii.ESC, Ascii.NAK, Ascii.FS, 89, Ascii.FS, Ascii.VT, Ascii.VT, Ascii.SYN, Ascii.VT, 89, Ascii.SUB, Ascii.SYN, Ascii.GS, Ascii.FS, 89, 86, 109, 98, 97, 111, 102, 35, 119, 108, 35, 115, 98, 113, 112, 102, 35, 103, 102, 97, 118, 100, 79, 108, 100, 70, 117, 102, 109, 119, 35, 98, 119, 35, 6, 61, 50, 49, Utf8.REPLACEMENT_BYTE, 54, 115, 39, 60, 115, 35, 50, 33, 32, 54, 115, 54, 37, 54, 61, 39, 115, 50, 39, 115, 111, 84, 91, 88, 86, 95, Ascii.SUB, 78, 85, Ascii.SUB, 74, 91, 72, 73, 95, Ascii.SUB, 73, 95, 72, 76, 95, 72, Ascii.SUB, 72, 95, 73, 74, 85, 84, 73, 95, Ascii.SUB, 91, 78, Ascii.SUB, 74, 85, 73, 83, 78, 83, 85, 84, Ascii.SUB, 80, 92, 87, 86, 104, 109, 120, 109, 110, 109, Ascii.DEL, 105, 17, 2, 17, Ascii.SUB, 0, 7, 6, 5, 1, Ascii.DC4, Ascii.NAK, Ascii.DC2, 5, 77, 3, Ascii.SI, Ascii.SO, 6, 9, 7, 77, 5, Ascii.SYN, 5, Ascii.SO, Ascii.DC4, 77, Ascii.CR, 1, 7, 9, 3, 33, 34, 38, 51, 50, 53, 34, Ascii.CAN, 36, 40, 41, 33, 46, 32, 44, 33, 71, 90, 94, 86, 60, 39, 35, 45, 38, 59};
    }

    private void A06(String str) {
        if (C8C.A0I(str)) {
            C8C.A0B(this.A00, str);
        } else {
            this.A01.A8m(str);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.J0
    public final JSONObject A4a() {
        int iA0F = Ij.A0F(this.A00);
        return iA0F > 0 ? A04(iA0F) : A03();
    }

    @Override // com.facebook.ads.redexgen.uinode.J0
    public final boolean A9A() {
        int iA0F = Ij.A0F(this.A00);
        return iA0F >= 1 && this.A01.A6z() + C8C.A00(this.A00) > iA0F;
    }

    @Override // com.facebook.ads.redexgen.uinode.J0
    public final void AAi() {
        int iA4I = this.A01.A4I(Ij.A0G(this.A00));
        if (iA4I > 0) {
            this.A00.A07().A9a(A00(379, 8, 100), C8A.A10, new C8B(A00(28, 44, 73) + iA4I));
        }
        C1794Ym c1794Ym = this.A00;
        String[] strArr = A03;
        if (strArr[5].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[5] = "bzDkK7DGlCk2AgYUikBmx";
        strArr2[6] = "oAHu9PBino36rPxONmBwiLk";
        C8C.A0F(c1794Ym);
    }

    @Override // com.facebook.ads.redexgen.uinode.J0
    public final void ABI(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            try {
                A06(jSONArray.getJSONObject(i11).getString(A00(433, 2, 45)));
            } catch (JSONException e11) {
                if (this.A00.A04().A8z()) {
                    String str = A04;
                    String[] strArr = A03;
                    if (strArr[5].length() == strArr[6].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A03;
                    strArr2[1] = "UiT9WvgcUGvh4UJIWCcVV8uUv9KhPAuj";
                    strArr2[2] = "iCLGRVxWINjUDSHIa5c9b6YKh720uR79";
                    Log.e(str, A00(108, 62, 122), e11);
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.J0
    public final boolean ABJ(JSONArray jSONArray) {
        String strA00 = A00(27, 1, 40);
        boolean z11 = true;
        boolean zA0P = Ij.A0P(this.A00);
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                String string = jSONObject.getString(A00(433, 2, 45));
                if (A00(393, 26, 8).equals(string)) {
                    C1384Ih.A0R(this.A00).A2X(jSONObject.getString(A00(419, 14, 47)));
                    this.A00.A03().AAL();
                } else {
                    int i12 = jSONObject.getInt(A00(375, 4, 91));
                    if (i12 == 1) {
                        if (this.A00.A04().A8z()) {
                            String str = A00(170, 25, 122) + string + A00(13, 14, 116);
                            String strA72 = this.A01.A72(string);
                            if (strA72 != null) {
                                String str2 = A00(72, 36, 101) + strA72;
                            }
                        }
                        if (!this.A01.A53(string) && zA0P) {
                            C8C.A0D(string);
                        }
                    } else {
                        String strA01 = A00(0, 13, 93);
                        if (i12 >= 1000 && i12 < 2000) {
                            if (this.A00.A04().A8z()) {
                                Log.e(A04, A00(236, 37, 17) + i12 + strA01 + string + strA00);
                            }
                            A06(string);
                            z11 = false;
                        } else if (i12 >= 2000 && i12 < 3000) {
                            if (this.A00.A04().A8z()) {
                                Log.e(A04, A00(195, 41, 9) + i12 + strA01 + string + strA00);
                            }
                            if (!this.A01.A53(string) && zA0P) {
                                C8C.A0D(string);
                            }
                        }
                    }
                }
            } catch (JSONException e11) {
                if (this.A00.A04().A8z()) {
                    Log.e(A04, A00(331, 44, 82) + i11 + strA00, e11);
                }
                z11 = false;
            }
        }
        return z11;
    }

    @Override // com.facebook.ads.redexgen.uinode.J0
    public final void ACo() {
        this.A01.A4J();
        C8C.A07(this.A00);
    }
}
