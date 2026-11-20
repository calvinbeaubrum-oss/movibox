package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class PE {
    public static byte[] A00;
    public static String[] A01 = {"CXRchRuqobcH0303RF", "0PvsG2xJSmQLgGTcWH9EYe7sEgRs7pRt", "Ep2muPcKb5OPprn584rkOKVS7ZwPor7u", "ESdTFl6hgzo0PrNou", "ifIc3126Iu24LMQAqXU9MKX3mrrg1qWL", "gYyPZy3RrUjZ7", "cRp6DEQTFSLuVCLvwOm8", "Iag0U1Rq9Q0ZydVPffrz8fjunI2ky4CH"};

    static {
        A04();
    }

    public static WebResourceResponse A00(C1795Yn c1795Yn, WebResourceRequest webResourceRequest, Uri uri, String str, HashMap<String, String> map) throws IOException {
        String strA02 = A02(85, 5, 49);
        C1716Vj c1716VjA0F = R0.A05(c1795Yn.A01()).A0F(c1795Yn);
        C11006c.A0H(c1795Yn, uri.toString());
        try {
            PF pf2 = new PF(c1795Yn.A01(), uri, c1716VjA0F);
            int iAvailable = pf2.available();
            if (iAvailable <= 0) {
                A05(c1795Yn, 1, new Pair[]{new Pair(A02(61, 9, 77), String.valueOf(iAvailable))});
                return null;
            }
            String strA03 = A03(webResourceRequest.getRequestHeaders());
            if (strA03 == null) {
                c1795Yn.A0E().A5O();
                A06(map, iAvailable);
                return new WebResourceResponse(str, null, 200, A02(44, 2, 15), map, pf2);
            }
            try {
                PD pdA01 = A01(strA03);
                boolean z11 = pdA01.A03;
                if (A01[7].charAt(0) == '8') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[5] = "V65aPOMRpqA07";
                strArr[6] = "uUbGIz9l3eQBVw2CYc6n";
                if (!z11) {
                    Pair[] pairArr = new Pair[1];
                    pairArr[0] = new Pair(A02(94, 5, 44), pdA01.A02 != null ? pdA01.A02 : A02(90, 4, 76));
                    A05(c1795Yn, 0, pairArr);
                    return null;
                }
                int i11 = pdA01.A01;
                int i12 = pdA01.A00 == -1 ? iAvailable - 1 : pdA01.A00;
                A06(map, iAvailable);
                map.put(A02(31, 13, 81), A02(75, 6, 17) + i11 + A02(1, 1, 52) + i12 + A02(2, 1, Worker.WHAT_QUIT) + iAvailable);
                c1795Yn.A0E().A5O();
                return new WebResourceResponse(str, null, 206, A02(46, 15, 36), map, pf2);
            } catch (NumberFormatException e11) {
                A05(c1795Yn, 3, new Pair[]{new Pair(strA02, e11.toString())});
                return null;
            }
        } catch (IOException e12) {
            A05(c1795Yn, 2, new Pair[]{new Pair(strA02, e12.toString())});
            return null;
        }
    }

    public static PD A01(String str) {
        if (str == null) {
            PD pd2 = new PD();
            pd2.A03 = false;
            pd2.A02 = null;
            return pd2;
        }
        String[] strArrSplit = str.split(A02(3, 1, 90));
        if (strArrSplit.length >= 2) {
            if (A02(70, 5, 60).equals(strArrSplit[0].toLowerCase(Locale.US).trim())) {
                if (strArrSplit[1].trim().split(A02(0, 1, 2)).length != 1) {
                    PD pd3 = new PD();
                    pd3.A03 = false;
                    pd3.A02 = str;
                    return pd3;
                }
                String[] strArrSplit2 = strArrSplit[1].trim().split(A02(1, 1, 52));
                PD pd4 = new PD();
                pd4.A03 = true;
                pd4.A02 = str;
                pd4.A01 = TextUtils.isEmpty(strArrSplit2[0]) ? 0 : Integer.parseInt(strArrSplit2[0]);
                if (strArrSplit2.length > 1) {
                    pd4.A00 = TextUtils.isEmpty(strArrSplit2[1]) ? -1 : Integer.parseInt(strArrSplit2[1]);
                } else {
                    pd4.A00 = -1;
                }
                return pd4;
            }
        }
        PD pd5 = new PD();
        pd5.A03 = false;
        pd5.A02 = str;
        return pd5;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A03(Map<String, String> map) {
        for (String str : map.keySet()) {
            if (A02(94, 5, 44).equals(str.toLowerCase(Locale.US))) {
                return map.get(str);
            }
        }
        return null;
    }

    public static void A04() {
        A00 = new byte[]{-119, -68, -8, -14, -50, -16, -16, -14, -3, 1, -70, -33, -18, -5, -12, -14, 0, -46, -2, -3, 3, -12, -3, 3, -68, -37, -12, -3, -10, 3, -9, -17, Ascii.ESC, Ascii.SUB, 32, 17, Ascii.SUB, 32, -39, -2, Ascii.CR, Ascii.SUB, 19, 17, -71, -75, -49, -32, -15, -13, -24, -32, -21, -97, -62, -18, -19, -13, -28, -19, -13, 9, Ascii.RS, 9, 17, Ascii.DC4, 9, 10, Ascii.DC4, Ascii.CR, -7, Ascii.DLE, Ascii.VT, -4, 10, -50, -27, -32, -47, -33, -116, 4, Ascii.DLE, 5, 6, -15, -2, -2, -5, -2, Ascii.NAK, Ascii.FS, 19, 19, -7, -24, -11, -18, -20};
    }

    public static void A05(C1795Yn c1795Yn, int i11, Pair<String, String>[] pairArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(81, 4, 70), i11);
            for (Pair<String, String> pair : pairArr) {
                jSONObject.put((String) pair.first, pair.second);
            }
        } catch (JSONException unused) {
        }
        c1795Yn.A0E().A5N(jSONObject.toString());
    }

    public static void A06(HashMap<String, String> map, int i11) {
        map.put(A02(4, 13, 50), A02(70, 5, 60));
        map.put(A02(17, 14, 52), String.valueOf(i11));
    }
}
