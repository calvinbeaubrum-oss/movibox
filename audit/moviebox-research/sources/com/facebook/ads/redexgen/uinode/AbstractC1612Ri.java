package com.facebook.ads.redexgen.uinode;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ri, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1612Ri {
    public static boolean A00(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            EnumC1611Rh enumC1611RhA00 = EnumC1611Rh.A00(jSONArray, i11);
            if (enumC1611RhA00 != EnumC1611Rh.A00(jSONArray2, i11) || !enumC1611RhA00.A05(jSONArray, jSONArray2, i11)) {
                return false;
            }
        }
        return true;
    }

    public static boolean A02(JSONObject jSONObject, JSONObject jSONObject2) {
        EnumC1611Rh enumC1611RhA01;
        if (jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next) || (enumC1611RhA01 = EnumC1611Rh.A01(jSONObject, next)) != EnumC1611Rh.A01(jSONObject2, next) || !enumC1611RhA01.A07(jSONObject, jSONObject2, next)) {
                return false;
            }
        }
        return true;
    }
}
