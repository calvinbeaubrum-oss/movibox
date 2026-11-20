package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class K5 {
    public static K5 A00;
    public static byte[] A01;
    public static String[] A02 = {"Nd0aIJaSSdT6golxDxmvfQ8KGIhkioAs", "ixyRHf3ginhO64aTdthArc1g6ok2H3", "GbO21nRDfLqDtubwMBv4WZcS7UdykcI0", "mXXayHEFxYYogLv80iNIAWV0V8DSaho2", "P31SQSGtrqVfDfZK9ecLZSYzpsOr4NmF", "LoLWC0hqSx9uRqEUKclND68NLRAhrZnk", "BjBhbLG4paZ7rOUqjAFqxmQoWglNay8W", "K86adGKhBwKF7i3Zzr1zFaSNRf7F"};

    static {
        A05();
        A00 = new K5();
    }

    public static synchronized K5 A00() {
        return A00;
    }

    private C1697Up A01(C1795Yn c1795Yn, JSONObject jSONObject, long j11) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONArray(A04(151, 10, 78)).getJSONObject(0);
        C8T c8tA00 = C8T.A00(jSONObject2.getJSONObject(A04(115, 10, 70)));
        String strOptString = jSONObject2.optString(A04(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 14, 18));
        String strOptString2 = jSONObject2.optString(A04(0, 19, 98));
        String strA04 = A04(100, 15, 87);
        C8S c8s = new C8S(c8tA00, strOptString, strOptString2, jSONObject2.has(strA04) ? jSONObject2.optString(strA04) : null);
        String strA05 = A04(26, 3, 57);
        if (jSONObject2.has(strA05)) {
            JSONArray jSONArray = jSONObject2.getJSONArray(strA05);
            int i11 = 0;
            while (true) {
                int length = jSONArray.length();
                String[] strArr = A02;
                if (strArr[5].charAt(22) == strArr[0].charAt(22)) {
                    String[] strArr2 = A02;
                    strArr2[5] = "EVHdYwJmDBIkQbvU6cH0jf8LCXZeDjo6";
                    strArr2[0] = "LqKeHeP2dtVwdsKCNOcbJj8gANtIspsD";
                    if (i11 >= length) {
                        break;
                    }
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i11);
                    JC.A06(c1795Yn, jSONObject3, j11, null);
                    String strOptString3 = jSONObject3.optString(A04(19, 7, 39));
                    String strOptString4 = jSONObject3.optString(A04(85, 15, 63));
                    JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(A04(63, 4, 116));
                    JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray(A04(161, 8, 90));
                    if (jSONObjectOptJSONObject != null) {
                        c8s.A0A(new C8Q(strOptString3, strOptString4, jSONObjectOptJSONObject, jSONArrayOptJSONArray));
                    } else {
                        c1795Yn.A0E().A4t(AdErrorType.UNKNOWN_ERROR.getErrorCode(), A04(67, 18, 82));
                    }
                    i11++;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        String strA06 = A04(47, 12, 116);
        if (jSONObject2.has(strA06)) {
            c8s.A0B(jSONObject2.getJSONObject(strA06));
        }
        return new C1697Up(c8s, jSONObject.optString(A04(29, 18, 1)));
    }

    private C1696Uo A02(JSONObject jSONObject) {
        return new C1696Uo(jSONObject.optString(A04(144, 7, 21), A04(0, 0, 87)), jSONObject.optInt(A04(59, 4, 3), 0), null);
    }

    private C1696Uo A03(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONArray(A04(151, 10, 78)).getJSONObject(0);
            return new C1696Uo(jSONObject.optString(A04(144, 7, 21), A04(0, 0, 87)), jSONObject.optInt(A04(59, 4, 3), 0), new C8S(C8T.A00(jSONObject2.getJSONObject(A04(115, 10, 70))), jSONObject2.optString(A04(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 14, 18)), jSONObject2.optString(A04(0, 19, 98)), null));
        } catch (JSONException unused) {
            return A02(jSONObject);
        }
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{116, 113, 74, 103, 112, 101, 122, 103, 97, 124, 123, 114, 74, 118, 122, 123, 115, 124, 114, 49, 52, 49, 32, 36, 53, 34, 47, 42, 61, Ascii.ETB, Ascii.CAN, 41, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, Ascii.ETB, 2, Ascii.US, Ascii.EM, Ascii.CAN, 41, 3, 3, Ascii.US, Ascii.DC2, 96, 107, 98, 106, 109, 92, 115, 98, 113, 98, 110, 112, Ascii.ETB, Ascii.ESC, Ascii.DLE, 17, 103, 98, 119, 98, 65, 68, 81, 68, 106, 71, 79, 64, 70, 81, 5, 76, 86, 5, 75, 80, 73, 73, 44, 41, 60, 41, Ascii.ETB, 37, 39, 44, 45, 36, Ascii.ETB, 60, 49, 56, 45, 68, 67, 76, Ascii.DEL, 84, 69, 83, 84, Ascii.DEL, 67, 79, 78, 70, 73, 71, 85, 84, 87, 88, 95, 88, 69, 88, 94, 95, 74, 93, 93, 64, 93, 3, 0, 4, 17, Ascii.DLE, Ascii.ETB, 0, 58, 6, 10, Ascii.VT, 3, Ascii.FF, 2, Ascii.SI, 7, 17, 17, 3, 5, 7, 73, 85, 88, 90, 92, 84, 92, 87, 77, 74, 89, 95, 76, 78, 70, 72, 95, 94, 69, 72, 65, 84};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0028  */
    public final K7 A06(C1795Yn c1795Yn, String str, long j11) throws JSONException {
        byte b11;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(A04(169, 4, 70));
            int iHashCode = strOptString.hashCode();
            String strA04 = A04(125, 5, 88);
            switch (iHashCode) {
                case 96432:
                    if (!strOptString.equals(A04(26, 3, 57))) {
                        b11 = -1;
                    } else {
                        b11 = 0;
                    }
                    break;
                case 96784904:
                    if (!strOptString.equals(strA04)) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            switch (b11) {
                case 0:
                    return A01(c1795Yn, jSONObject, j11);
                case 1:
                    return A03(jSONObject);
                default:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strA04);
                    if (jSONObjectOptJSONObject != null) {
                        return A02(jSONObjectOptJSONObject);
                    }
                    break;
            }
        }
        return new K7(K6.A04);
    }
}
