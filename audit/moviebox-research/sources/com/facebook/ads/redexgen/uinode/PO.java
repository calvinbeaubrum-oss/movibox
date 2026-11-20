package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class PO {
    public static byte[] A00;
    public static String[] A01 = {"xPMOoUfbkmQ5kvnU3jbgLL47OcFEjU7z", "1dodMLotzUEJucQn2MWgY64F", "Ei0kY7ZOP", "czo3jP2JN", "", "hHdeWCinA2EaAz86iaUgwk6OrkZVXmHI", "CkfkaUvdCRi5J5AIUl6JSr62iIVQ3RiE", "AT3hLPm3hPYjZ73rxoY4ER"};

    static {
        A02();
    }

    public static PN A00(C1795Yn c1795Yn, JSONObject jSONObject, C11006c c11006c, JA ja2, C1550Oy c1550Oy, boolean z11) {
        boolean z12;
        String strA0R;
        boolean z13 = z11;
        String strA01 = A01(101, 3, 106);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String strOptString = jSONObject.optString(A01(51, 26, 80));
        arrayList3.add(strOptString);
        if (z13) {
            strA0R = c11006c.A0R(strOptString);
            if (strOptString.equals(strA0R)) {
                z13 = false;
                z12 = false;
            } else {
                z12 = z13;
            }
        } else {
            z12 = z13;
            strA0R = strOptString;
        }
        ja2.A04(J9.A0P, null);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(92, 4, 1));
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optString(strA01) != null) {
                arrayList.add(jSONObjectOptJSONObject.optString(strA01));
                if (z12) {
                    jSONObjectOptJSONObject.put(strA01, c11006c.A0Q(jSONObjectOptJSONObject.optString(strA01)));
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A01(77, 15, WebSocketProtocol.PAYLOAD_SHORT));
            if (jSONArrayOptJSONArray != null) {
                for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                    String strOptString2 = jSONArrayOptJSONArray.optString(i11);
                    arrayList.add(strOptString2);
                    if (z12) {
                        jSONArrayOptJSONArray.put(i11, c11006c.A0Q(strOptString2));
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(A01(43, 8, 26));
            if (jSONArrayOptJSONArray2 != null) {
                for (int i12 = 0; i12 < jSONArrayOptJSONArray2.length(); i12++) {
                    A03(arrayList, arrayList2, jSONArrayOptJSONArray2.optJSONObject(i12), c11006c, z12);
                }
            } else {
                A03(arrayList, arrayList2, jSONObject, c11006c, z12);
            }
        } catch (JSONException unused) {
            c1550Oy.A04(C8A.A15, A01(0, 43, 79));
        }
        return new PN(jSONObject, strA0R, arrayList, arrayList2, arrayList3, z13);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{69, 114, 114, 111, 114, 32, 116, 114, 97, 110, 115, 102, 111, 114, 109, 105, 110, 103, 32, 74, 83, 79, 78, 32, 105, 110, 32, 117, 112, 100, 97, 116, 101, 67, 97, 99, 104, 101, 100, 85, 114, 108, 115, 54, 52, 39, 58, 32, 38, 48, 57, 123, 102, 113, 126, 114, 118, 124, 64, 108, 123, 116, 64, 115, 126, 102, 122, 109, 64, 119, 107, 114, 115, 64, 106, 109, 115, 84, 95, 85, 110, 82, 80, 67, 85, 110, 88, 92, 80, 86, 84, 66, 39, 45, 33, 32, 2, 6, 10, Ascii.FF, Ascii.SO, 80, 87, 73, 107, 116, 121, 120, 114, 66, 104, 111, 113};
    }

    public static void A03(ArrayList<String> arrayList, ArrayList<String> arrayList2, JSONObject jSONObject, C11006c c11006c, boolean z11) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(96, 5, 36));
        if (jSONObjectOptJSONObject != null) {
            String strA01 = A01(101, 3, 106);
            if (A01[1].length() == 1) {
                throw new RuntimeException();
            }
            A01[7] = "G1neCcMuoIIVUH8A2yIEObncf";
            if (jSONObjectOptJSONObject.optString(strA01) != null) {
                String strOptString = jSONObjectOptJSONObject.optString(strA01);
                arrayList.add(strOptString);
                if (z11) {
                    jSONObjectOptJSONObject.put(strA01, c11006c.A0Q(strOptString));
                }
            }
        }
        String strA02 = A01(104, 9, 82);
        if (TextUtils.isEmpty(jSONObject.optString(strA02))) {
            return;
        }
        String strOptString2 = jSONObject.optString(strA02);
        arrayList2.add(strOptString2);
        if (z11) {
            jSONObject.put(strA02, c11006c.A0R(strOptString2));
        }
    }
}
