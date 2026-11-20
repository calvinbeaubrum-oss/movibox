package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC09560l {
    public static byte[] A00;
    public static String[] A01 = {"4Fi3cRKjKwjo", "pfwDmZC0EgnSHGG3akphHDiSxRpjxWfc", "OwKyFlCBYoW0NHpoiuFf2exuC", "FTixXnraWBf7yQ9sseM6khJqknPB2", "87lno6sBf8EnLpq9v2WrftgOrdI4V", "hcLSbPhFObKmfxN2jEGb0Jf71EM4", "MV7VLhl", "AE1L1nhQpeYYJvXkfFkincgpQRIdvuit"};

    static {
        A05();
    }

    public static EnumC09540j A00(JSONObject jSONObject) {
        return EnumC09540j.A00(jSONObject.optString(A02(52, 21, 114)));
    }

    public static C1929ba A01(C1795Yn c1795Yn, JSONObject jSONObject, String str) {
        return new C1929ba(jSONObject, c1795Yn, str);
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static Collection<String> A03(C1795Yn c1795Yn, JSONObject jSONObject) {
        JSONArray jSONArray = null;
        try {
            String strOptString = jSONObject.optString(A02(35, 17, 123));
            if (!TextUtils.isEmpty(strOptString)) {
                jSONArray = new JSONArray(strOptString);
            }
        } catch (JSONException e11) {
            c1795Yn.A07().A9a(A02(73, 7, 42), C8A.A2C, new C8B(e11));
        }
        return A04(jSONArray);
    }

    public static Collection<String> A04(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            hashSet.add(jSONArray.optString(i11));
        }
        return hashSet;
    }

    public static void A05() {
        A00 = new byte[]{101, 64, 4, 77, 87, 4, 77, 74, 82, 69, 72, 77, 64, 69, 80, 65, 64, 4, 83, 77, 80, 76, 75, 81, 80, 4, 80, 75, 79, 65, 74, 10, 10, Ascii.ESC, 2, 39, 38, 55, 38, 32, 55, 42, 44, 45, Ascii.FS, 48, 55, 49, 42, 45, 36, 48, 35, 36, 60, 43, 38, 35, 46, 43, 62, 35, 37, 36, Ascii.NAK, 40, 47, 34, 43, 60, 35, 37, 56, 98, 115, 96, 97, 123, 124, 117};
    }

    public static boolean A06(C1795Yn c1795Yn, InterfaceC09550k interfaceC09550k, J2 j11) {
        EnumC09540j enumC09540jA7E = interfaceC09550k.A7E();
        if (enumC09540jA7E == null || enumC09540jA7E == EnumC09540j.A03) {
            return false;
        }
        boolean z11 = false;
        Collection<String> collectionA6n = interfaceC09550k.A6n();
        if (collectionA6n == null || collectionA6n.isEmpty()) {
            return false;
        }
        Iterator<String> it = collectionA6n.iterator();
        while (it.hasNext()) {
            if (LM.A04(c1795Yn, it.next())) {
                z11 = true;
                break;
            }
        }
        if (z11 != (enumC09540jA7E == EnumC09540j.A02)) {
            return false;
        }
        String strA6T = interfaceC09550k.A6T();
        boolean zIsEmpty = TextUtils.isEmpty(strA6T);
        String[] strArr = A01;
        if (strArr[7].charAt(25) != strArr[1].charAt(25)) {
            throw new RuntimeException();
        }
        A01[2] = "Y0XUyINdugWnNFuKX72emGLWk";
        if (zIsEmpty) {
            c1795Yn.A07().A9a(A02(32, 3, 83), C8A.A0Z, new C8B(A02(0, 32, 28)));
            return true;
        }
        j11.A9h(strA6T, null);
        return true;
    }
}
