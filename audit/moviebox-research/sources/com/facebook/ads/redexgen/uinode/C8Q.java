package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8Q {
    public static byte[] A04;
    public static String[] A05 = {"MRuBx", "tnrUNtkj", "pjyIxrC6Yt5E7Bc8e3CsDS5x0xMg", "2xISKY0hJDtdJSu4Q6JXzE3xpGdbyGij", "ditV1dZQcpc", "LaRPF5Qegj7e827D6k5bX2o3j9w5", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "ieJW9hY3GIu"};
    public final String A00;
    public final String A01;
    public final Map<C8U, List<String>> A02 = new HashMap();
    public final JSONObject A03;

    static {
        A01();
    }

    public C8Q(String str, String str2, JSONObject jSONObject, JSONArray jSONArray) {
        List<String> list;
        this.A00 = str;
        this.A01 = str2;
        this.A03 = jSONObject;
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (C8U c8u : C8U.values()) {
            this.A02.put(c8u, new LinkedList());
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                String string = jSONObject2.getString(A00(0, 4, 108));
                String string2 = jSONObject2.getString(A00(4, 3, 61));
                C8U c8uValueOf = C8U.valueOf(string.toUpperCase(Locale.US));
                if (!TextUtils.isEmpty(string2) && (list = this.A02.get(c8uValueOf)) != null) {
                    list.add(string2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-23, -18, -27, -38, -69, -72, -78};
        String[] strArr = A05;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[4] = "sekG1ort6wl";
        strArr2[7] = "5zf1LSqUL7z";
        A04 = bArr;
    }

    public final String A02() {
        return this.A00;
    }

    public final List<String> A03(C8U c8u) {
        return this.A02.get(c8u);
    }

    public final JSONObject A04() {
        return this.A03;
    }
}
