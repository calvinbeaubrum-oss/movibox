package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1O, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C1O {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static List<C1G> A01(JSONArray jSONArray, JSONObject jSONObject, C1795Yn c1795Yn, C1S c1s) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                if (i11 == 0) {
                    A03(jSONObject2, jSONObject);
                }
                C1G c1gA00 = C1G.A00(jSONObject2);
                c1s.A3N(c1gA00, jSONObject2);
                arrayList.add(c1gA00);
            } catch (JSONException e11) {
                c1795Yn.A07().A9a(A00(8, 7, 31), C8A.A2B, new C8B(e11));
            }
        }
        return arrayList;
    }

    public static void A02() {
        A00 = new byte[]{43, 41, 58, 55, 61, 59, 45, 52, -39, -54, -37, -36, -46, -41, -48, 46, 33, Ascii.FS, Ascii.GS, 39, Ascii.ETB, 45, 42, 36};
    }

    public static void A03(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!next.equals(A00(15, 9, Worker.WHAT_QUIT)) && !next.equals(A00(0, 8, WebSocketProtocol.PAYLOAD_SHORT)) && !jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
    }
}
