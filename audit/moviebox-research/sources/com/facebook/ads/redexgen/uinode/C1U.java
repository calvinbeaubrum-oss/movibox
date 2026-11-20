package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.io.Serializable;
import java.util.Arrays;
import okio.Utf8;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1U implements Serializable {
    public static byte[] A05 = null;
    public static String[] A06 = {DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, "N8LJkoTRbuRbC1tJ", "jfJOiGRwPDVL1NrTNwB42KXE8H2UBngU", "vBF5X8psVmC8vN2i9Fb6pwYPcFw8P16Y", "MnzIPqWVO6BB6yg7oNwcPff6zueAQoos", "vMZUyoTb2kOawbdq3lii4zyBkGUB4gvd", "5yRYj6PaRtwfaNlpyi5ySSeMn9NdrDw4", "Ti3I"};
    public static final long serialVersionUID = 238472947123L;
    public int A00;
    public String A01;
    public String A02;
    public String A03;
    public boolean A04;

    static {
        A05();
    }

    public C1U(String str, String str2, String str3, int i11, boolean z11) {
        this.A01 = str;
        this.A03 = str2;
        this.A02 = str3;
        this.A00 = i11;
        this.A04 = z11;
    }

    public static C1U A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(A04(0, 6, 35));
        String strOptString2 = jSONObject.optString(A04(36, 8, 108));
        String strOptString3 = jSONObject.optString(A04(24, 12, 29));
        int iOptInt = jSONObject.optInt(A04(44, 14, 36), -1);
        boolean zOptBoolean = jSONObject.optBoolean(A04(6, 18, 62), false);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3) || iOptInt == -1) {
            return null;
        }
        return new C1U(strOptString, strOptString2, strOptString3, iOptInt, zOptBoolean);
    }

    private final String A01() {
        return this.A01;
    }

    private final String A02() {
        return this.A02;
    }

    private final String A03() {
        return this.A03;
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = (bArrCopyOfRange[i14] ^ i13) ^ 96;
            String[] strArr = A06;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "o";
            strArr2[1] = "Fs5WcDJhxaD3DdRX";
            bArrCopyOfRange[i14] = (byte) i15;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{34, 51, 51, Ascii.FS, 42, 39, 56, Utf8.REPLACEMENT_BYTE, 50, 50, 60, Utf8.REPLACEMENT_BYTE, 61, 53, 1, 55, 48, 45, 42, Utf8.REPLACEMENT_BYTE, 57, 44, Utf8.REPLACEMENT_BYTE, 51, Ascii.CR, Ascii.FS, Ascii.RS, Ascii.SYN, Ascii.FS, Ascii.SUB, Ascii.CAN, 34, 19, Ascii.FS, Ascii.DLE, Ascii.CAN, 126, 105, 106, 105, 126, 126, 105, 126, 54, 33, 52, 43, 54, 48, 45, 42, 35, Ascii.ESC, 41, 43, 32, 33};
    }

    public static void A06(C1U c1u, C1795Yn c1795Yn) {
        if (c1u == null || !c1u.A09()) {
            return;
        }
        new VL(c1795Yn).A04(true, c1u.A01(), c1u.A03(), c1u.A02(), System.currentTimeMillis(), c1u.A08());
    }

    public static void A07(C1U c1u, C1795Yn c1795Yn) {
        if (c1u == null || !c1u.A0A()) {
            return;
        }
        new VL(c1795Yn).A04(false, c1u.A01(), c1u.A03(), c1u.A02(), System.currentTimeMillis(), c1u.A08());
    }

    private final boolean A08() {
        return this.A04;
    }

    private final boolean A09() {
        return (this.A00 & 2) != 0;
    }

    private final boolean A0A() {
        return (this.A00 & 1) != 0;
    }
}
