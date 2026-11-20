package com.facebook.ads.redexgen.uinode;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.transsion.gslb.Worker;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PM {
    public static byte[] A08;
    public WeakReference<PB> A00;
    public WeakReference<TD> A01 = new WeakReference<>(null);
    public boolean A02 = false;
    public final C1795Yn A03;
    public final C1550Oy A04;
    public final String A05;
    public final String A06;
    public final WeakReference<J2> A07;

    static {
        A09();
    }

    public PM(C1795Yn c1795Yn, PB pb2, J2 j11, C1550Oy c1550Oy, String str, String str2) {
        this.A03 = c1795Yn;
        this.A00 = new WeakReference<>(pb2);
        this.A07 = new WeakReference<>(j11);
        this.A04 = c1550Oy;
        this.A05 = str;
        this.A06 = str2;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static Map<String, String> A03(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        HashMap map = new HashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.optString(next));
        }
        return map;
    }

    private void A04() {
        TD td2 = this.A01.get();
        if (td2 == null) {
            return;
        }
        td2.close();
    }

    private void A05() {
        TD td2 = this.A01.get();
        if (td2 == null) {
            return;
        }
        td2.A8X();
    }

    private void A06() {
        TD td2 = this.A01.get();
        if (td2 == null) {
            return;
        }
        td2.A9K();
    }

    private void A07() {
        this.A03.A0E().A5F();
        this.A02 = true;
        TD td2 = this.A01.get();
        if (td2 == null) {
            return;
        }
        td2.AGY();
        if (C1384Ih.A1W(this.A03)) {
            this.A03.A0A().ABG();
        }
    }

    private void A08() {
        TD td2 = this.A01.get();
        if (td2 == null) {
            return;
        }
        td2.ABb();
    }

    public static void A09() {
        A08 = new byte[]{44, 56, 54, 54, 42, 55, 45, 10, Ascii.VT, Ascii.FF, 7, Ascii.ESC, Ascii.DC2, Ascii.SUB, Utf8.REPLACEMENT_BYTE, 78, 71, 58, -29, -14, -21, -21, -30, -23, -36, -32, -20, -31, -30, Ascii.FF, Ascii.ESC, Ascii.DC4, Ascii.DC4, Ascii.VT, Ascii.DC2, 5, 19, Ascii.VT, Ascii.EM, Ascii.EM, 7, Ascii.CR, Ascii.VT, -37, -22, -29, -29, -38, -31, -44, -23, -18, -27, -38, -23, -29, -9, 52, 53, 36, 46, 41, 90, 75, 95, 93, 79, 78, 44, 99, Utf8.REPLACEMENT_BYTE, 93, 79, 92, 57, 58, 39, 56, 58, 43, 42, 8, Utf8.REPLACEMENT_BYTE, Ascii.ESC, 57, 43, 56, 83, 84, 65, 84, 69, 48, 45, 39, 6, 32, 52, -10, -31, -20, -11, -27};
    }

    private void A0A(PB pb2, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        SharedPreferences sharedPreferencesA00 = KE.A00(this.A03);
        String strA01 = A01(57, 5, 81);
        String strA02 = A01(0, 0, 21);
        String strOptString = jSONObject.optString(strA01, strA02);
        String string = sharedPreferencesA00.getString(A01(14, 4, Worker.WHAT_SYNC_DATA) + jSONObject.optString(A01(54, 3, 10), A01(7, 7, 50)), strA02);
        if (string != null) {
            strA02 = string;
        }
        pb2.A0g(strOptString, strA02);
    }

    private void A0B(PB pb2, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String strA01 = A01(98, 5, 12);
        String strA02 = A01(0, 0, 21);
        String strOptString = jSONObject.optString(strA01, strA02);
        String strOptString2 = jSONObject.optString(A01(57, 5, 81), strA02);
        KE.A00(this.A03).edit().putString(A01(14, 4, Worker.WHAT_SYNC_DATA) + jSONObject.optString(A01(54, 3, 10), A01(7, 7, 50)), strOptString).apply();
        pb2.A0f(strOptString2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(PK pk2, String str) throws JSONException {
        switch (PJ.A00[pk2.ordinal()]) {
            case 1:
                A0I(new JSONObject(str));
                break;
            case 2:
                A06();
                break;
            case 3:
                A04();
                break;
            case 4:
                A07();
                break;
            case 5:
                A0K(new JSONObject(str));
                break;
            case 6:
                A0L(new JSONObject(str));
                break;
            case 7:
                if (BuildConfigApi.isDebug()) {
                }
                break;
            case 8:
                A05();
            case 9:
                this.A03.A0E().A5R(str);
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                A0D(pk2, str);
                break;
            case 15:
                A0J(new JSONObject(str));
                break;
            case 16:
                A08();
                break;
            case 17:
                A0M(new JSONObject(str));
                break;
        }
        PB pb2 = this.A00.get();
        if (pb2 == null) {
        }
        switch (pk2) {
            case A06:
                pb2.A0S();
                break;
            case A05:
                pb2.A0R();
                break;
            case A0P:
                A0B(pb2, str);
                break;
            case A0L:
                A0A(pb2, str);
                break;
            case A0F:
                pb2.A0i(A03(new JSONObject(str)));
                break;
        }
    }

    private void A0D(PK pk2, String str) throws JSONException {
        TD td2 = this.A01.get();
        if (td2 == null) {
        }
        switch (pk2) {
            case A0C:
                td2.ABf();
                break;
            case A0N:
                td2.AD8();
                break;
            case A0K:
                A0G(td2, str);
                break;
            case A0J:
                A0F(td2, str);
                break;
            case A0G:
                A0E(td2, str);
                break;
        }
    }

    private void A0E(TD td2, String str) throws JSONException {
        td2.ACL(new JSONObject(str).optBoolean(A01(87, 5, 108), false));
    }

    private void A0F(TD td2, String str) throws JSONException {
        td2.ADc(new JSONObject(str).optBoolean(A01(62, 12, 118), false));
    }

    private void A0G(TD td2, String str) throws JSONException {
        td2.ADe(new JSONObject(str).optBoolean(A01(74, 13, 82), false));
    }

    private void A0I(JSONObject jSONObject) {
        TD td2 = this.A01.get();
        if (td2 == null) {
            return;
        }
        String strOptString = jSONObject.optString(A01(0, 7, 85));
        if (TextUtils.isEmpty(strOptString)) {
            td2.A8S();
        } else {
            td2.A8T(strOptString);
        }
    }

    private void A0J(JSONObject jSONObject) {
        if (this.A01.get() == null) {
            return;
        }
        jSONObject.optString(A01(0, 7, 85));
    }

    private void A0K(JSONObject jSONObject) {
        J2 j11 = this.A07.get();
        if (j11 == null) {
            return;
        }
        String strOptString = jSONObject.optString(A01(43, 11, 1));
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        new JA(this.A06, j11).A05(strOptString, A03(jSONObject));
    }

    private void A0L(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt(A01(18, 11, 9), -1);
        if (iOptInt == -1) {
            return;
        }
        String strOptString = jSONObject.optString(A01(29, 14, 50));
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.A03.A0E().A9Y(iOptInt, strOptString);
    }

    private void A0M(JSONObject jSONObject) {
        String strOptString;
        TD td2 = this.A01.get();
        if (td2 == null || (strOptString = jSONObject.optString(A01(92, 6, 71))) == null) {
            return;
        }
        td2.ADr(strOptString);
    }

    public final void A0N(TD td2) {
        this.A01 = new WeakReference<>(td2);
    }

    public final boolean A0O() {
        return this.A02;
    }

    @JavascriptInterface
    public void postMessage(String str) {
        ExecutorC1456Li.A00(new PI(this, str));
    }
}
