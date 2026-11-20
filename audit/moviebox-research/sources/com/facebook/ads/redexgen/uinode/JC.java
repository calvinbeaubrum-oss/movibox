package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class JC {
    public static byte[] A00;
    public static final Map<String, String> A01;
    public static final Map<String, List<String>> A02;

    static {
        A03();
        A02 = new HashMap();
        A01 = new HashMap();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 27);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A01(String str) {
        return A01.get(str);
    }

    public static List<String> A02(C1795Yn c1795Yn, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                arrayList.add(jSONArray.getString(i11));
            } catch (JSONException e11) {
                c1795Yn.A07().A9a(A00(39, 17, 1), C8A.A1C, new C8B(e11));
            }
        }
        return arrayList;
    }

    public static void A03() {
        A00 = new byte[]{-68, -51, -49, -52, -33, -52, -42, -27, -34, -34, -43, -36, -3, 0, -14, -11, -16, 5, -6, -2, -10, -16, -2, 4, -68, -81, -69, -65, -81, -67, -66, -87, -66, -77, -73, -81, -87, -73, -67, -111, -108, 123, -126, -111, -118, -118, -127, -120, 123, -120, -117, -125, -125, -123, -118, -125};
    }

    public static void A04(View view, JA ja2, J9 j11) {
        view.addOnAttachStateChangeListener(new JB(ja2, j11));
    }

    public static void A05(C1795Yn c1795Yn, String str, long j11) {
        JA ja2 = new JA(str, c1795Yn.A09());
        HashMap map = new HashMap();
        map.put(A00(24, 15, 47), C1453Lf.A06(j11));
        map.put(A00(12, 12, 118), C1453Lf.A04(j11));
        ja2.A04(J9.A0D, map);
    }

    public static void A06(C1795Yn c1795Yn, JSONObject jSONObject, long j11, String str) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A00(2, 4, 80));
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A00(6, 6, 85));
        if (TextUtils.isEmpty(str) && jSONArrayOptJSONArray != null) {
            A07(c1795Yn, jSONObjectOptJSONObject, A02(c1795Yn, jSONArrayOptJSONArray), j11, null);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Map<String, List<String>> map = A02;
            if (map.containsKey(str)) {
                A07(c1795Yn, jSONObjectOptJSONObject, map.get(str), j11, str);
            }
        }
    }

    public static void A07(C1795Yn c1795Yn, JSONObject jSONObject, List<String> list, long j11, String str) {
        String strA00 = A00(0, 2, 62);
        if (jSONObject.has(strA00)) {
            String strOptString = jSONObject.optString(strA00);
            A08(strOptString, str);
            A09(strOptString, list);
            A05(c1795Yn, strOptString, j11);
        }
    }

    public static void A08(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        A01.put(str, str2);
    }

    public static void A09(String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list.isEmpty()) {
            return;
        }
        A02.put(str, list);
    }

    public static boolean A0A(String str, J9 j11) {
        return A0B(str, j11.A02());
    }

    public static boolean A0B(String str, String str2) {
        Map<String, List<String>> map = A02;
        return map.containsKey(str) && map.get(str).contains(str2);
    }
}
