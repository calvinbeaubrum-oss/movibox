package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1906bD implements InterfaceC09550k {
    public static byte[] A08;
    public static String[] A09 = {"a8CS69kVNecuN9Nm4E1lChlBM", "ag8ss2YsLKCBvL1N8ZsAQ7i2G", "9IBuBVemd2S2dbE3BWmY83r4APvNrK7d", "ZoqrROBX", "uf7sNUy4ZjnbrmNcJuZuOOSXLwo6bRiZ", "LuNKGusWtlIWkNNSsxJCgMD8UDEcDleP", "s1ncMgVhGbgxvH35X0QQBiYqSsxlrK3j", "2ghFrXKxVbUZFk6auJt6qCgV8pKBUCZ9"};
    public final EnumC09540j A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final String A05;
    public final Collection<String> A06;
    public final Map<String, String> A07;

    static {
        A02();
    }

    public C1906bD(String str, String str2, EnumC09540j enumC09540j, Collection<String> collection, Map<String, String> map, String str3, String str4, String str5) {
        this.A04 = str;
        this.A01 = str2;
        this.A00 = enumC09540j;
        this.A06 = collection;
        this.A07 = map;
        this.A05 = str3;
        this.A02 = str4;
        this.A03 = str5;
    }

    public static C1906bD A00(EQ eq2, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A01(33, 6, 95));
        String strOptString2 = jSONObject.optString(A01(0, 18, 13));
        String strOptString3 = jSONObject.optString(A01(47, 10, 34));
        String strA02 = LJ.A02(jSONObject, A01(18, 2, 2));
        EnumC09540j enumC09540jA00 = AbstractC09560l.A00(jSONObject);
        Collection<String> collectionA03 = AbstractC09560l.A03(eq2, jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(39, 8, 57));
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (true) {
                boolean zHasNext = itKeys.hasNext();
                if (A09[7].charAt(3) == 'o') {
                    throw new RuntimeException();
                }
                String[] strArr = A09;
                strArr[3] = "3pk8Rtt7";
                strArr[1] = "M9VcdiL4tfZ71WotJMHbX4yrU";
                if (zHasNext) {
                    String next = itKeys.next();
                    map.put(next, jSONObjectOptJSONObject.optString(next));
                }
            }
        }
        return new C1906bD(strOptString, strOptString2, enumC09540jA00, collectionA03, map, strOptString3, strA02, LJ.A02(jSONObject, A01(20, 13, 58)));
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A08 = new byte[]{9, Ascii.VT, Ascii.FS, 1, Ascii.RS, 9, Ascii.FS, 1, 7, 6, 55, Ascii.VT, 7, 5, 5, 9, 6, Ascii.FF, 4, 19, 58, 49, 60, 45, 38, 47, 43, 58, 59, 0, 60, 47, 50, 87, 91, 72, 81, 79, 74, 49, 57, 40, 61, 56, 61, 40, 61, 53, 34, 54, 50, 34, 52, 51, Ascii.CAN, 46, 35};
    }

    public final String A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A04;
    }

    public final String A05() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final String A6T() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final Collection<String> A6n() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC09550k
    public final EnumC09540j A7E() {
        return this.A00;
    }
}
